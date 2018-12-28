package com.macross.controller;

import com.alibaba.fastjson.JSONObject;
import com.macross.entry.clothing;
import com.macross.entry.singer;
import com.macross.entry.singer_detailed;
import com.macross.pipeline.singerPipeline;
import com.macross.processor.singerProcessor;
import com.macross.service.clothingService;
import com.macross.service.singerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/singer")
public class singerController {

    @Autowired
    public singerPipeline singerPipeline;
    @Autowired
    public singerProcessor singerProcessor;
    @Autowired
    public singerService singerService;
    @Autowired
    public clothingService clothingService;
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

    @RequestMapping("/getAllSinger")
    @ResponseBody
    public String getAllSinger(){
        JSONObject jsonObject = new JSONObject();
        List<HashMap<String, Object>> singer = singerService.getAllSinger();
        for (int i = 0; i < singer.size(); i++) {
            singer.get(i).put("clothing",singerService.getSingerClothingNumber((Integer) singer.get(i).get("id")));
            singer.get(i).put("card",singerService.getSingerCardNumber((Integer) singer.get(i).get("id")));
        }
        jsonObject.put("singer",singer);
        return  jsonObject.toJSONString();
    }

    @RequestMapping("/getSinger")
    @ResponseBody
    public String getSinger(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int id = Integer.parseInt(request.getParameter("id"));
        HashMap<String,Object> singer = singerService.getSinger(id);
        singer_detailed init = singerService.getSingerInit(id);
        singer_detailed max = singerService.getSingerMax(id);
        int clothing = singerService.getSingerClothingNumber(id);
        int card = singerService.getSingerCardNumber(id);
        List<HashMap<String,Object>> clothingList = clothingService.getClothing_singer(id);
        jsonObject.put("singer",singer);
        jsonObject.put("init",init);
        jsonObject.put("max",max);
        jsonObject.put("clothing",clothing);
        jsonObject.put("clothingList",clothingList);
        jsonObject.put("card",card);
        return  jsonObject.toJSONString();
    }
}
