package com.macross.controller;

import com.alibaba.fastjson.JSONObject;
import com.macross.entry.attr;
import com.macross.service.attrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/attr")
public class attrController {
    @Autowired
    public attrService attrService;

    @RequestMapping("/getAllAttr")
    @ResponseBody
    public String getAllAttr(){
        JSONObject jsonObject = new JSONObject();
        List<attr> attr = attrService.getAllAttr();
        jsonObject.put("attr",attr);
        return jsonObject.toJSONString();
    }
}
