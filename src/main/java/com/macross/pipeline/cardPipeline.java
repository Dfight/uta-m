package com.macross.pipeline;

import com.macross.entry.*;
import com.macross.service.cardService;
import com.macross.service.singerService;
import com.macross.service.skillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

@Component("cardPipeline")
public class cardPipeline implements Pipeline {
    @Autowired
    public skillService skillService;
    @Autowired
    public cardService cardService;
    @Autowired
    public singerService singerService;
    @Override
    public void process(ResultItems resultItems, Task task) {
        card card = resultItems.get("card");
        card_detailed init = resultItems.get("init");
        card_detailed max = resultItems.get("max");
        skill center = resultItems.get("center");
        skill action = resultItems.get("action");
        skill live = resultItems.get("live");
        List<String> singer = resultItems.get("singer");

        card.setOpus(opus);
        card.setSkill_C( skillService.addSkill(center));
        card.setSkill_A( skillService.addSkill(action));
        card.setSkill_L( skillService.addSkill(live));

        cardService.addCard(card);

        for (int i = 0; i < singer.size(); i++) {
            int id = singerService.getSinger_name(singer.get(i)).getId();
            card_singer card_singer = new card_singer();
            card_singer.setCard(card.getId());
            card_singer.setSinger(id);
            cardService.addCard_Singer(card_singer);
        }

        init.setId(card.getId());
        max.setId(card.getId());
        cardService.addCard_detailed(init);
        cardService.addCard_detailed(max);
    }


    private int opus;
    public int getOpus() {
        return opus;
    }
    public void setOpus(int opus) {
        this.opus = opus;
    }
}
