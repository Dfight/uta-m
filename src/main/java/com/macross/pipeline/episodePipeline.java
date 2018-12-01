package com.macross.pipeline;

import com.macross.entry.episode;
import com.macross.service.episodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component("episodePipeline")
public class episodePipeline implements Pipeline{
    private int opus;
    public int getOpus() {
        return opus;
    }
    public void setOpus(int opus) {
        this.opus = opus;
    }

    @Autowired
    public episodeService episodeService;
    @Override
    public void process(ResultItems resultItems, Task task) {
        episode episode = resultItems.get("episode");
        episode.setOpus(opus);
        episodeService.addEpisode(episode);
    }
}
