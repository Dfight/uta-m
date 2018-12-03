package com.macross.processor;

import com.macross.entry.card;
import com.macross.entry.card_detailed;
import com.macross.entry.opus;
import com.macross.entry.skill;
import com.macross.service.attrService;
import com.macross.service.cardService;
import com.macross.service.episodeService;
import com.macross.service.opusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

@Component("cardProcessor")
public class cardProcessor implements PageProcessor {
    @Autowired
    public opusService opusService;
    @Autowired
    public cardService cardService;
    @Autowired
    public episodeService episodeService;
    @Autowired
    public attrService attrService;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setTimeOut(6000);
    @Override
    public void process(Page page) {
        allOpus = opusService.getAllOpus();
        String name = page.getHtml().xpath("//h1[@itemprop='headline']/text()").toString();

        if (notOpus(name)){
            List<String> url = page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr/td[4]").links().all();
            List<String> star = page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr/td[1]/text()").all();
            for(int i=0;i<star.size();i++){
                if (star.get(i).length()>2){
                    card card = cardService.getCard_url(url.get(i));
                    if(card==null){
                         page.addTargetRequest(url.get(i));
                    }
                }
            }
            page.setSkip(true);
        }else {
            card card = new card();
            card_detailed init = new card_detailed();
            card_detailed max = new card_detailed();
            skill center = new skill();
            skill live = new skill();
            skill action = new skill();

            card.setName(name);
            card.setUrl(page.getUrl().toString());
            card.setStar(page.getHtml().xpath("//table[@id='content_block_2']/tbody/tr[2]/td[1]/div/text()").toString().length());
            card.setEpisode(episodeService.getEpisode_url(page.getHtml().xpath("//table[@id='content_block_6']/tbody/tr[2]/td[2]").links().toString()).getId());
            card.setAttr(attrService.getAttr_name(page.getHtml().xpath("//table[@id='content_block_6']/tbody/tr[1]/td[2]/text()").toString()).getId());

            init.setState(0);
            max.setState(1);
            init.setImg(page.getHtml().xpath("//table[@id='content_block_2']/tbody/tr[1]/td[1]/div/img/@src").toString().substring(73));
            max.setImg(page.getHtml().xpath("//table[@id='content_block_2']/tbody/tr[1]/td[2]/div/img/@src").toString().substring(73));
            init.setTotal(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[2]/text()").toString()));
            max.setTotal(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[2]/text()").toString()));
            init.setSoul(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[3]/text()").toString()));
            max.setSoul(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[3]/text()").toString()));
            init.setVoice(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[4]/text()").toString()));
            max.setVoice(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[4]/text()").toString()));
            init.setCharm(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[5]/text()").toString()));
            max.setCharm(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[5]/text()").toString()));
            init.setLife(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_14']/tbody/tr[2]/td[2]/text()").toString()));
            max.setLife(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_14']/tbody/tr[3]/td[2]/text()").toString()));
            init.setSupport(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_14']/tbody/tr[2]/td[3]/text()").toString()));
            max.setSupport(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_14']/tbody/tr[3]/td[3]/text()").toString()));
            init.setFold_wave(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_14']/tbody/tr[2]/td[4]/text()").toString()));
            max.setFold_wave(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_14']/tbody/tr[3]/td[4]/text()").toString()));
            init.setLuck(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_14']/tbody/tr[2]/td[5]/text()").toString()));
            max.setLuck(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_14']/tbody/tr[3]/td[5]/text()").toString()));

            center.setPos("center");
            action.setPos("action");
            live.setPos("live");
            center.setEffect(page.getHtml().xpath("//table[@id='content_block_19']/tbody/tr[1]/td[2]/text()").toString());
            center.setEffect_M(page.getHtml().xpath("//table[@id='content_block_19']/tbody/tr[2]/td[2]/text()").toString());
            action.setEffect(page.getHtml().xpath("//table[@id='content_block_24']/tbody/tr[1]/td[2]/text()").toString());
            action.setEffect_M(page.getHtml().xpath("//table[@id='content_block_24']/tbody/tr[2]/td[2]/text()").toString());
            live.setEffect(page.getHtml().xpath("//table[@id='content_block_29']/tbody/tr[1]/td[2]/text()").toString());
            live.setEffect_M(page.getHtml().xpath("//table[@id='content_block_29']/tbody/tr[2]/td[2]/text()").toString());

            List<String> singer = page.getHtml().xpath("//table[@id=content_block_33]/tbody/tr/td[2]/div/b/a/text()").all();

            page.putField("card",card);
            page.putField("init",init);
            page.putField("max",max);
            page.putField("center",center);
            page.putField("live",live);
            page.putField("action",action);
            page.putField("singer",singer);
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
