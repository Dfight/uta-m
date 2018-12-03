package com.macross.pipeline;

import com.macross.entry.fighter;
import com.macross.service.fighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
@Component("fighterPipeline")
public class fighterPipeline implements Pipeline {
    @Autowired
    public fighterService fighterService;
    private int opus;
    public int getOpus() {
        return opus;
    }
    public void setOpus(int opus) {
        this.opus = opus;
    }


    @Override
    public void process(ResultItems resultItems, Task task) {
        fighter fighter = resultItems.get("fighter");
        fighter.setOpus(opus);
        fighterService.addFighter(fighter);
    }
}
