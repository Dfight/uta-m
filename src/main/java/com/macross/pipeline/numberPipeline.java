package com.macross.pipeline;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.HashMap;
import java.util.Map;

@Component("numberPipeline")
public class numberPipeline implements Pipeline{
    private int episode;
    private int fighter;
    private int card;
    private int clothing;
    private int singer;


    @Override
    public void process(ResultItems resultItems, Task task) {
        String type = resultItems.get("type");
        switch (type){
            case "episode":
                episode = resultItems.get("number");
                break;
            case "fighter":
                fighter = resultItems.get("number");
                break;
            case "card":
                card = resultItems.get("number");
                break;
            case "clothing":
                clothing = resultItems.get("number");
                break;
            case "singer":
                singer = resultItems.get("number");
                break;
        }
    }


    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public int getFighter() {
        return fighter;
    }

    public void setFighter(int fighter) {
        this.fighter = fighter;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public int getClothing() {
        return clothing;
    }

    public void setClothing(int clothing) {
        this.clothing = clothing;
    }

    public int getSinger() {
        return singer;
    }

    public void setSinger(int singer) {
        this.singer = singer;
    }
}
