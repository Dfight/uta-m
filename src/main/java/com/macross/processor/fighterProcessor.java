package com.macross.processor;

import com.macross.entry.episode;
import com.macross.entry.fighter;
import com.macross.entry.opus;
import com.macross.service.episodeService;
import com.macross.service.fighterService;
import com.macross.service.opusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

@Component("fighterProcessor")
public class fighterProcessor implements PageProcessor{
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setTimeOut(6000);
    @Autowired
    public opusService opusService;
    @Autowired
    public fighterService fighterService;
    @Autowired
    public episodeService episodeService;
    @Override
    public void process(Page page) {
        allOpus = opusService.getAllOpus();
        String name = page.getHtml().xpath("//h1[@itemprop='headline']/text()").toString();

        fighter fighter = new fighter();
        if (notOpus(name)){
            List<String> all = page.getHtml().xpath("//table[@id='content_block_2']").links().all();
            for(int i=0;i<all.size();i++){
                fighter = fighterService.getFighter_url(all.get(i));
                if (fighter==null){
                    page.addTargetRequest(all.get(i));
                }
            }
            //page.addTargetRequests(all);
            page.setSkip(true);
        }else{
            fighter.setName(name);
            fighter.setImg(page.getHtml().xpath("//div[@class='page']/div/div/div/img/@src").toString().substring(73));
            fighter.setDriver(page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr[2]/td[2]/text()").toString());
            fighter.setAttack(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr[3]/td[2]/text()").toString()));
            fighter.setHit(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr[4]/td[2]/text()").toString()));
            String fighter_url = page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr[5]/td[2]").links().toString();
            episode episode = episodeService.getEpisode_url(fighter_url);
            if(episode!=null){
                fighter.setEpisode(episode.getId());
            }
            fighter.setUrl(page.getUrl().toString());
            page.putField("fighter",fighter);
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
