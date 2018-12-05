package com.macross.processor;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

@Component("numberProcessor")
public class numberProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setTimeOut(6000);
    @Override
    public void process(Page page) {
        String name = page.getHtml().xpath("//h1[@itemprop='headline']/text()").toString();
        if (page.getUrl().toString().indexOf("エピソード")!=-1){
            int size = page.getHtml().xpath("//table[@id='content_block_2']/tbody/tr").all().size()-1;
            page.putField("type","episode");
            page.putField("name",name);
            page.putField("number",size);
        }else if(page.getUrl().toString().indexOf("バルキリー")!=-1){
            int size = page.getHtml().xpath("//table[@id='content_block_2']/tbody/tr").all().size()-1;
            page.putField("type","fighter");
            page.putField("name",name);
            page.putField("number",size);
        }else if(page.getUrl().toString().indexOf("プレート")!=-1){
            //int size = page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr").all().size()-1;
            int size = 0;
            List<String> star = page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr/td[1]/text()").all();
            for(int i=0;i<star.size();i++) {
                if (star.get(i).length() ==2) {
                    size=i;
                    break;
                }
            }
            page.putField("type","card");
            page.putField("name",name);
            page.putField("number",size);
        }else if(page.getUrl().toString().indexOf("歌姫_衣装")!=-1){
            int size = page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr").all().size()-1;
            page.putField("type","clothing");
            page.putField("number",size);
        }else if(page.getUrl().toString().indexOf("歌姫_歌姫")!=-1){
            int size = page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr").all().size()-1;
            page.putField("type","singer");
            page.putField("number",size);
        }else{
            page.setSkip(true);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
