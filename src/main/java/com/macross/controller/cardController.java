package com.macross.controller;

import com.alibaba.fastjson.JSONObject;
import com.macross.entry.card_detailed;
import com.macross.entry.singer;
import com.macross.entry.skill;
import com.macross.pipeline.cardPipeline;
import com.macross.processor.cardProcessor;
import com.macross.service.cardService;
import com.macross.service.skillService;
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
@RequestMapping("/card")
public class cardController {
    @Autowired
    public cardProcessor cardProcessor;
    @Autowired
    public cardPipeline cardPipeline;
    @Autowired
    public cardService cardService;
    @Autowired
    public skillService skillService;
    @RequestMapping("autoload")
    @ResponseBody
    public String autoload(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        cardPipeline.setOpus(Integer.parseInt(id));
        String strUrl = "https://歌マクロス.gamematome.jp/game/977/wiki/プレート_"+name;
        Spider.create(cardProcessor).
                addUrl(strUrl)
                .addPipeline(cardPipeline)
                .thread(5)
                .run();

        return jsonObject.toJSONString();
    }
    @RequestMapping("/getCard")
    @ResponseBody
    public String getCard(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        int CardID = Integer.parseInt(id);
        HashMap<String, Object> card = cardService.getCard_id(CardID);
        skill center = skillService.getSkill_id((int) card.get("skill_C"));
        skill action = skillService.getSkill_id((int) card.get("skill_A"));
        skill live = skillService.getSkill_id((int) card.get("skill_L"));
        card_detailed init = cardService.getCardDetailed(CardID, 0);
        card_detailed max = cardService.getCardDetailed(CardID, 1);
        List<singer> singer = cardService.getCardSinger(CardID);
        jsonObject.put("card",card);
        jsonObject.put("center",center);
        jsonObject.put("action",action);
        jsonObject.put("live",live);
        jsonObject.put("init",init);
        jsonObject.put("max",max);
        jsonObject.put("singer",singer);
        return jsonObject.toJSONString();
    }
    @RequestMapping("/getCardList")
    @ResponseBody
    public String getCardList(@RequestParam(value="star[]") Integer[] star,@RequestParam(value="opus[]") Integer[] opus,@RequestParam(value="attr[]") Integer[] attr,@RequestParam(value="singer[]") Integer[] singer,int page,String center,String action,String live){
        JSONObject jsonObject = new JSONObject();
        page = (page-1)*10;
        List<HashMap<String, Object>> cardList = cardService.getCardList(star, opus, attr, singer, page,center,action,live);
        jsonObject.put("cardList",cardList);
        return jsonObject.toJSONString();
    }
}
