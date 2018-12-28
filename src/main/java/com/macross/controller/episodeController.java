package com.macross.controller;

import com.alibaba.fastjson.JSONObject;
import com.macross.entry.opus;
import com.macross.pipeline.episodePipeline;
import com.macross.processor.episodeProcessor;
import com.macross.service.episodeService;
import com.macross.service.opusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/episode")
public class episodeController {

    @Autowired
    public episodePipeline episodePipeline;
    @Autowired
    public episodeProcessor episodeProcessor;
    @Autowired
    public episodeService episodeService;
    @RequestMapping("/autoload")
    @ResponseBody
    public String autoload(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        episodePipeline.setOpus(Integer.parseInt(id));
        String strUrl = "https://歌マクロス.gamematome.jp/game/977/wiki/エピソード_"+name;
        Spider.create(episodeProcessor).
                addUrl(strUrl)
                .addPipeline(episodePipeline)
                .thread(5)
                .run();

        JSONObject jsonObject = new JSONObject();
        return jsonObject.toJSONString();
    }

    @RequestMapping("/getAllEpisode")
    @ResponseBody
    public String getAllEpisode(){
        JSONObject jsonObject = new JSONObject();
        List<HashMap<String, Object>> episode = episodeService.getAllEpisode_opus();
        jsonObject.put("episode",episode);
        return jsonObject.toJSONString();
    }
}
