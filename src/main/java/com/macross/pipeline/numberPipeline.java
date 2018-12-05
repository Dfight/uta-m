package com.macross.pipeline;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.HashMap;
import java.util.Map;

@Component("numberPipeline")
public class numberPipeline implements Pipeline{
    private Map<String,Integer> episode= new HashMap<String,Integer>();
    private Map<String,Integer> fighter= new HashMap<String,Integer>();
    private Map<String,Integer> card= new HashMap<String,Integer>();
    private int clothing;
    private int singer;


    @Override
    public void process(ResultItems resultItems, Task task) {
        String type = resultItems.get("type");
        String name;
        int number;
        switch (type){
            case "episode":
                name = resultItems.get("name");
                number = resultItems.get("number");
                episode.put(name,number);
                break;
            case "fighter":
                name = resultItems.get("name");
                number = resultItems.get("number");
                fighter.put(name,number);
                break;
            case "card":
                name = resultItems.get("name");
                number = resultItems.get("number");
                card.put(name,number);
                break;
            case "clothing":
                clothing = resultItems.get("number");
                break;
            case "singer":
                singer = resultItems.get("number");
                break;
        }
    }




    public Map<String, Integer> getFighter() {
        return fighter;
    }

    public void setFighter(Map<String, Integer> fighter) {
        this.fighter = fighter;
    }

    public Map<String, Integer> getCard() {
        return card;
    }

    public void setCard(Map<String, Integer> card) {
        this.card = card;
    }

    public Map<String, Integer> getEpisode() {
        return episode;
    }

    public void setEpisode(Map<String, Integer> episode) {
        this.episode = episode;
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
