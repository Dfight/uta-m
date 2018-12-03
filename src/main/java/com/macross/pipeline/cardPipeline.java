package com.macross.pipeline;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
@Component("cardPipeline")
public class cardPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {

    }


    private int opus;
    public int getOpus() {
        return opus;
    }
    public void setOpus(int opus) {
        this.opus = opus;
    }
}
