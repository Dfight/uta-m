package com.macross.processor;

import com.macross.entry.singer;
import com.macross.entry.singer_detailed;
import com.macross.service.singerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

@Component("singerProcessor")
public class singerProcessor implements PageProcessor{
    @Autowired
    public singerService singerService;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setTimeOut(6000);
    @Override
    public void process(Page page) {
        String name = page.getHtml().xpath("//h1[@itemprop='headline']/text()").toString();
        singer singer = new singer();
        if (name.equals("歌姫")){
            List<String> img = page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr/td[1]/a/img/@src").all();
            List<String> singer_name = page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr/td[2]/b/a/text()").all();
            List<String> url = page.getHtml().xpath("//table[@id='content_block_3']").links().all();
            page.putField("state","add");
            page.putField("img",img);
            page.putField("name",singer_name);
            for (int i=0;i<url.size();i++){
                boolean exist = singerService.exist_url(url.get(i));
                if (!exist){
                    page.addTargetRequest(url.get(i));
                }
            }
            //page.addTargetRequests(url);
        }else{
            String img = page.getHtml().xpath("//div[@class='user-area']/div/img/@src").toString().substring(73);
            String max_level = page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr[3]/td[2]/text()").toString();
            String opus_img = page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr[2]/td[2]/img/@src").toString().substring(73);
            page.putField("name",name);
            page.putField("img",img);
            page.putField("url",page.getUrl().toString());
            page.putField("max_level",max_level);
            page.putField("opus_img",opus_img);

            singer_detailed init = new singer_detailed();
            singer_detailed max = new singer_detailed();

            init.setState(0);
            init.setTotal(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_8']/tbody/tr[2]/td[2]/text()").toString()));
            init.setSoul(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_8']/tbody/tr[2]/td[3]/text()").toString()));
            init.setVoice(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_8']/tbody/tr[2]/td[4]/text()").toString()));
            init.setCharm(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_8']/tbody/tr[2]/td[5]/text()").toString()));
            init.setLife(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[2]/text()").toString()));
            init.setSupport(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[3]/text()").toString()));
            init.setFold_wave(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[4]/text()").toString()));

            max.setState(1);
            max.setTotal(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_8']/tbody/tr[3]/td[2]/text()").toString()));
            max.setSoul(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_8']/tbody/tr[3]/td[3]/text()").toString()));
            max.setVoice(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_8']/tbody/tr[3]/td[4]/text()").toString()));
            max.setCharm(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_8']/tbody/tr[3]/td[5]/text()").toString()));
            max.setLife(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[2]/text()").toString()));
            max.setSupport(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[3]/text()").toString()));
            max.setFold_wave(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[4]/text()").toString()));

            page.putField("init",init);
            page.putField("max",max);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
