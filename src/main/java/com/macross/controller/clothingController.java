package com.macross.controller;

import com.alibaba.fastjson.JSONObject;
import com.macross.pipeline.clothingPipeline;
import com.macross.processor.clothingProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;

@Controller
@RequestMapping("/clothing")
public class clothingController {
    @Autowired
    public clothingProcessor clothingProcessor;
    @Autowired
    public clothingPipeline clothingPipeline;
    @RequestMapping("/autoload")
    @ResponseBody
    public String autoload(){
        JSONObject jsonObject = new JSONObject();
        String strUrl = "https://歌マクロス.gamematome.jp/game/977/wiki/歌姫_衣装";
        Spider.create(clothingProcessor).
                addUrl(strUrl)
                .addPipeline(clothingPipeline)
                .thread(5)
                .run();
        return jsonObject.toJSONString();
    }
}
