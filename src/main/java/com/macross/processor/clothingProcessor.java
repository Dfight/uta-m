package com.macross.processor;

import com.macross.entry.clothing;
import com.macross.entry.episode;
import com.macross.service.clothingService;
import com.macross.service.episodeService;
import com.macross.service.singerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

@Component("clothingProcessor")
public class clothingProcessor implements PageProcessor {
    @Autowired
    public clothingService clothingService;
    @Autowired
    public singerService singerService;
    @Autowired
    public episodeService episodeService;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setTimeOut(6000);
    @Override
    public void process(Page page) {
        String name = page.getHtml().xpath("//h1[@itemprop='headline']/text()").toString();
        if (name.equals("衣装")){
            List<String> url = page.getHtml().xpath("//table[@id='content_block_3']").links().all();
            for (int i = 0;i<url.size();i++){
                clothing clothing = clothingService.getClothing_url(url.get(i));
                if (clothing==null){
                    page.addTargetRequest(url.get(i));
                }
            }
            //page.addTargetRequests(url);
            page.setSkip(true);
        }else{
            clothing clothing = new clothing();
            clothing.setName(name);
            clothing.setImg(page.getHtml().xpath("//div[@class='page']/div/div/div/img/@src").toString().substring(73));
            clothing.setUrl(page.getUrl().toString());
            String singer_name = page.getHtml().xpath("//table[@id=content_block_3]/tbody/tr[1]/td[2]/a/text()").toString();
            int id = singerService.getSinger_name(singer_name).getId();
            clothing.setSinger(id);
            clothing.setEffect(page.getHtml().xpath("//table[@id=content_block_3]/tbody/tr[3]/td[2]/text()").toString());
            String episode_url = page.getHtml().xpath("//table[@id=content_block_3]/tbody/tr[2]/td[2]").links().toString();
            episode episode = episodeService.getEpisode_url(episode_url);
            if(episode!=null){
                clothing.setEpisode(episode.getId());
            }
            page.putField("clothing",clothing);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
