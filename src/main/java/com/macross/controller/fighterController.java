package com.macross.controller;

import com.alibaba.fastjson.JSONObject;
import com.macross.pipeline.fighterPipeline;
import com.macross.processor.fighterProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/fighter")
public class fighterController {
    @Autowired
    public fighterProcessor fighterProcessor;
    @Autowired
    public fighterPipeline fighterPipeline;
    @RequestMapping("/autoload")
    @ResponseBody
    public String autoload(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        fighterPipeline.setOpus(Integer.parseInt(id));
        String strUrl = "https://歌マクロス.gamematome.jp/game/977/wiki/バルキリー_"+name;
        Spider.create(fighterProcessor).
                addUrl(strUrl)
                .addPipeline(fighterPipeline)
                .thread(5)
                .run();

        return jsonObject.toJSONString();
    }
}
