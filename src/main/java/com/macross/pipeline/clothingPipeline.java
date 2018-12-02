package com.macross.pipeline;

import com.macross.entry.clothing;
import com.macross.service.clothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
@Component("clothingPipeline")
public class clothingPipeline implements Pipeline {
    @Autowired
    public clothingService clothingService;
    @Override
    public void process(ResultItems resultItems, Task task) {
        clothing clothing = resultItems.get("clothing");
        clothingService.addClothing(clothing);
    }
}
