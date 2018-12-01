package com.macross.controller;

import com.alibaba.fastjson.JSONObject;
import com.macross.pipeline.singerPipeline;
import com.macross.processor.singerProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;

@Controller
@RequestMapping("/singer")
public class singerController {

    @Autowired
    public singerPipeline singerPipeline;
    @Autowired
    public singerProcessor singerProcessor;
    @RequestMapping("/autoload")
    @ResponseBody
    public String autoload(){
        JSONObject jsonObject = new JSONObject();
        String strUrl = "https://歌マクロス.gamematome.jp/game/977/wiki/歌姫_歌姫";
        Spider.create(singerProcessor).
                addUrl(strUrl)
                .addPipeline(singerPipeline)
                .thread(5)
                .run();
        return  jsonObject.toJSONString();
    }
}
