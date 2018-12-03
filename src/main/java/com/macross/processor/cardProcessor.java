package com.macross.processor;

import com.macross.entry.opus;
import com.macross.service.opusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

@Component("cardProcessor")
public class cardProcessor implements PageProcessor {
    @Autowired
    public opusService opusService;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setTimeOut(6000);
    @Override
    public void process(Page page) {
        allOpus = opusService.getAllOpus();
        String name = page.getHtml().xpath("//h1[@itemprop='headline']/text()").toString();

        if (notOpus(name)){
            List<String> url = page.getHtml().xpath("//table[@id='content_block_3']").links().all();

            for(int i=0;i<url.size();i++){

            }
            page.setSkip(true);
        }else {

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
