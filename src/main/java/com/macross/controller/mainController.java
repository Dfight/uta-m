package com.macross.controller;

import com.alibaba.fastjson.JSONObject;
import com.macross.entry.episode;
import com.macross.entry.opus;
import com.macross.pipeline.numberPipeline;
import com.macross.processor.numberProcessor;
import com.macross.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/main")
public class mainController {
    @Autowired
    public cardService cardService;
    @Autowired
    public clothingService clothingService;
    @Autowired
    public episodeService episodeService;
    @Autowired
    public fighterService fighterService;
    @Autowired
    public opusService opusService;
    @Autowired
    public singerService singerService;
    @Autowired
    public numberProcessor numberProcessor;
    @Autowired
    public numberPipeline numberPipeline;

    @RequestMapping("/number")
    @ResponseBody
    public String number(HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<opus> allOpus = opusService.getAllOpus();
        List<String> episodeURL = new ArrayList<>();
        List<String> fighterURL = new ArrayList<>();
        List<String> cardURL = new ArrayList<>();
        for (int i=0;i<allOpus.size();i++){
            episodeURL.add("https://歌マクロス.gamematome.jp/game/977/wiki/エピソード_"+allOpus.get(i).getName());
            fighterURL.add("https://歌マクロス.gamematome.jp/game/977/wiki/バルキリー_"+allOpus.get(i).getName());
            cardURL.add("https://歌マクロス.gamematome.jp/game/977/wiki/プレート_"+allOpus.get(i).getName());
        }
        for (int i = 0; i < allOpus.size(); i++) {
            Spider.create(numberProcessor)
                .addUrl(episodeURL.get(i))
                .addUrl(fighterURL.get(i))
                .addUrl(cardURL.get(i))
                .addPipeline(numberPipeline)
                .thread(3)
                .run();
        }
        Spider.create(numberProcessor)
                .addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/エピソード")
                .addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/バルキリー")
                .addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/プレート")
                .addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/歌姫_衣装")
                .addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/歌姫_歌姫")
                .addPipeline(numberPipeline)
                .thread(3)
                .run();
        Map<String, Integer> episode = numberPipeline.getEpisode();
        Map<String, Integer> fighter = numberPipeline.getFighter();
        Map<String, Integer> card = numberPipeline.getCard();
        int clothing = numberPipeline.getClothing();
        int singer = numberPipeline.getSinger();
        for (int i = 0; i < allOpus.size(); i++) {
            int episode_size = episodeService.getEpisode_opus(allOpus.get(i).getId()).size();
            episode.put(allOpus.get(i).getName(),episode.get(allOpus.get(i).getName()) - episode_size);
            int fighter_size = fighterService.getFighter_opus(allOpus.get(i).getId()).size();
            fighter.put(allOpus.get(i).getName(),fighter.get(allOpus.get(i).getName()) - fighter_size);
            int card_size = cardService.getCard_opus(allOpus.get(i).getId()).size();
            card.put(allOpus.get(i).getName(),card.get(allOpus.get(i).getName()) - card_size);
        }
        int clothing_size = clothingService.getAllClothing().size();
        clothing-=clothing_size;
        int singer_size = singerService.getAllSinger().size();
        singer-=singer_size;
        jsonObject.put("episode",episode);
        jsonObject.put("fighter",fighter);
        jsonObject.put("card",card);
        jsonObject.put("clothing",clothing);
        jsonObject.put("singer",singer);


        return jsonObject.toJSONString();
    }
}
