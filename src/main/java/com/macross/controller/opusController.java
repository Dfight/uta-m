package com.macross.controller;

import com.alibaba.fastjson.JSONObject;
import com.macross.entry.opus;
import com.macross.service.opusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/opus")
public class opusController {
    @Autowired
    public opusService opusService;

    @RequestMapping(value = "/getAllOpus",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getAllOpus(){
        JSONObject jsonObject = new JSONObject();
        List<opus> opus = opusService.getAllOpus();
        jsonObject.put("opus",opus);
        return jsonObject.toJSONString();
    }
}
