package com.macross.processor;


import com.macross.entry.episode;
import com.macross.entry.opus;
import com.macross.service.episodeService;
import com.macross.service.opusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

@Component("episodeProcessor")
public class episodeProcessor implements PageProcessor {
    @Autowired
    public opusService opusService;
    @Autowired
    public com.macross.service.episodeService episodeService;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setTimeOut(6000);
    @Override
    public void process(Page page) {
        allOpus = opusService.getAllOpus();
        String name = page.getHtml().xpath("//h1[@itemprop='headline']/text()").toString();

        episode episode = new episode();
        if (notOpus(name)){
            List<String> all = page.getHtml().xpath("//table[@id='content_block_2']").links().all();

            for(int i=0;i<all.size();i++){
                boolean existEpisode = episodeService.existEpisode(all.get(i));
                if (!existEpisode) {
                    page.addTargetRequest(all.get(i));
                }
            }
            //page.addTargetRequests(all);
            page.setSkip(true);
        }else{
            episode.setImg(page.getHtml().xpath("//div[@class='user-area']/div/img/@src").toString().substring(73));
            episode.setName(name);
            episode.setText(page.getHtml().xpath("//div[@class='user-area']/div/b/text()").toString());
            episode.setUrl(page.getUrl().toString());
            page.putField("episode",episode);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }



    private List<opus> allOpus;

    public boolean notOpus(String name){
        boolean flag = false;
        for (int i=0;i<allOpus.size();i++){
            if (allOpus.get(i).getName().equals(name)){
                flag =  true;
            }
        }
        return  flag;
    }
}
