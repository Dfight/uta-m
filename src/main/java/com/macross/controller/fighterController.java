package com.macross.controller;

import com.alibaba.fastjson.JSONObject;
import com.macross.pipeline.fighterPipeline;
import com.macross.processor.fighterProcessor;
import com.macross.service.fighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/fighter")
public class fighterController {
    @Autowired
    public fighterProcessor fighterProcessor;
    @Autowired
    public fighterPipeline fighterPipeline;
    @Autowired
    public fighterService fighterService;
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

    @RequestMapping("/getAllFighter")
    @ResponseBody
    public String getAllFighter(HttpServletRequest request){

        JSONObject jsonObject = new JSONObject();
        String opus = request.getParameter("opus");
        int opusID = Integer.parseInt(opus);
        List<HashMap<String, Object>> fighter = fighterService.getAllFighter_opus(opusID);
        jsonObject.put("fighter",fighter);
        return jsonObject.toJSONString();
    }
}
