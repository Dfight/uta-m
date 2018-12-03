package com.macross.controller;

import com.alibaba.fastjson.JSONObject;
import com.macross.pipeline.cardPipeline;
import com.macross.processor.cardProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/card")
public class cardController {
    @Autowired
    public cardProcessor cardProcessor;
    @Autowired
    public cardPipeline cardPipeline;
    @RequestMapping("autoload")
    @ResponseBody
    public String autoload(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        cardPipeline.setOpus(Integer.parseInt(id));
        String strUrl = "https://歌マクロス.gamematome.jp/game/977/wiki/プレート_"+name;
        //String strUrl = "https://歌マクロス.gamematome.jp/game/977/wiki/プレート_空中の救出劇";
        Spider.create(cardProcessor).
                addUrl(strUrl)
                .addPipeline(cardPipeline)
                .thread(5)
                .run();

        return jsonObject.toJSONString();
    }
}
