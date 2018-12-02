package com.macross.pipeline;

import com.macross.entry.singer;
import com.macross.entry.singer_detailed;
import com.macross.service.opusService;
import com.macross.service.singerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

@Component("singerPipeline")
public class singerPipeline implements Pipeline{
    @Autowired
    public opusService opusService;
    @Autowired
    public singerService singerService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String state = resultItems.get("state");
        if (state!=null){
            List<String> name = resultItems.get("name");
            List<String> img = resultItems.get("img");
            for (int i=0;i<name.size();i++){
                singer singer = new singer();
                singer.setImg1(img.get(i).substring(73));
                singer.setName(name.get(i));
                singerService.addSinger(singer);
            }
        }else{
            String name = resultItems.get("name");
            String img = resultItems.get("img");
            String url = resultItems.get("url");
            singer_detailed init = resultItems.get("init");
            singer_detailed max = resultItems.get("max");
            int max_level = Integer.parseInt(resultItems.get("max_level"));
            String opus_img = resultItems.get("opus_img");
            singer singer = new singer();
            singer.setName(name);
            singer.setImg2(img);
            singer.setUrl(url);
            singer.setMax_level(max_level);
            singer.setOpus(opusService.getopus_img(opus_img).getId());

            init.setId(singerService.getSinger_name(name).getId());
            max.setId(singerService.getSinger_name(name).getId());
            singerService.addSingerDetailed(singer,init,max);
        }
    }
}
