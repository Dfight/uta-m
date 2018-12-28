package com.macross.controller;

import com.alibaba.fastjson.JSONObject;
import com.macross.entry.skill;
import com.macross.service.skillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/skill")
public class skillController {
    @Autowired
    public skillService skillService;
    @RequestMapping("/translate")
    @ResponseBody
    public void translate(){
        List<skill> skillList = skillService.getAllSkill();
        for (int i = 0;i<skillList.size();i++){
            if (skillList.get(i).getEffect_C()==null){
                skill c = J2C(skillList.get(i));
                skillService.translate(c);
            }
        }
    }

    public skill J2C(skill j){
        String pos = j.getPos();
        skill c = new skill();
        switch (pos){
            case "center":
                c.setId(j.getId());
                c.setEffect_C(CenterJ2C(j.getEffect()));
                c.setEffect_M_C(CenterJ2C(j.getEffect_M()));
                if (c.getEffect_C().indexOf("和")==-1) {
                    if (c.getEffect_C().indexOf("属性乐曲时unit的") != -1) {
                        if (c.getEffect_C().indexOf("Total") != -1) {
                            c.setType("指定属性歌曲时unit的Total提升");
                        } else if (c.getEffect_C().indexOf("Voice") != -1) {
                            c.setType("指定属性歌曲时unit的Voice提升");
                        } else if (c.getEffect_C().indexOf("Life") != -1) {
                            c.setType("指定属性歌曲时unit的Life提升");
                        } else if (c.getEffect_C().indexOf("Support") != -1) {
                            c.setType("指定属性歌曲时unit的Support提升");
                        } else if (c.getEffect_C().indexOf("Fold波") != -1) {
                            c.setType("指定属性歌曲时unit的Fold波提升");
                        } else if (c.getEffect_C().indexOf("Charm") != -1) {
                            c.setType("指定属性歌曲时unit的Charm提升");
                        } else if (c.getEffect_C().indexOf("Soul") != -1) {
                            c.setType("指定属性歌曲时unit的Soul提升");
                        }
                    } else if (c.getEffect_C().indexOf("属性卡的") != -1) {
                        if (c.getEffect_C().indexOf("Total") != -1) {
                            c.setType("指定属性卡的Total提升");
                        } else if (c.getEffect_C().indexOf("Voice") != -1) {
                            c.setType("指定属性卡的Voice提升");
                        } else if (c.getEffect_C().indexOf("Life") != -1) {
                            c.setType("指定属性卡的Life提升");
                        } else if (c.getEffect_C().indexOf("Support") != -1) {
                            c.setType("指定属性卡的Support提升");
                        } else if (c.getEffect_C().indexOf("Fold波") != -1) {
                            c.setType("指定属性卡的Fold波提升");
                        } else if (c.getEffect_C().indexOf("Soul") != -1) {
                            c.setType("指定属性卡的Soul提升");
                        } else if (c.getEffect_C().indexOf("Charm") != -1) {
                            c.setType("指定属性卡的Charm提升");
                        }
                    } else if (c.getEffect_C().indexOf("unit的") != -1) {
                        if (c.getEffect_C().indexOf("Total") != -1) {
                            c.setType("unitTotal提升");
                        } else if (c.getEffect_C().indexOf("Voice") != -1) {
                            c.setType("unitVoice提升");
                        } else if (c.getEffect_C().indexOf("Life") != -1) {
                            c.setType("unitLife提升");
                        } else if (c.getEffect_C().indexOf("Support") != -1) {
                            c.setType("unitSupport提升");
                        } else if (c.getEffect_C().indexOf("Fold波") != -1) {
                            c.setType("unitFold波提升");
                        } else if (c.getEffect_C().indexOf("Soul") != -1) {
                            c.setType("unitSoul提升");
                        } else if (c.getEffect_C().indexOf("Charm") != -1) {
                            c.setType("unitCharm提升");
                        }
                    }
                }else{
                    if (c.getEffect_C().indexOf("Total") != -1) {
                        if (c.getType()==null){
                            c.setType("unitTotal提升");
                        }else{
                            c.setType(c.getType()+"&unitTotal提升");
                        }
                    }
                    if (c.getEffect_C().indexOf("Voice") != -1) {
                        if (c.getType()==null){
                            c.setType("unitVoice提升");
                        }else{
                            c.setType(c.getType()+"&unitVoice提升");
                        }

                    }
                    if (c.getEffect_C().indexOf("Life") != -1) {
                        if (c.getType()==null){
                            c.setType("unitLife提升");
                        }else{
                            c.setType(c.getType()+"&unitLife提升");
                        }

                    }
                    if (c.getEffect_C().indexOf("Support") != -1) {
                        if (c.getType()==null){
                            c.setType("unitSupport提升");
                        }else {
                            c.setType(c.getType() + "&unitSupport提升");
                        }
                    }
                    if (c.getEffect_C().indexOf("Fold波") != -1) {
                        if (c.getType()==null){
                            c.setType("unitFold波提升");
                        }else{
                            c.setType(c.getType()+"&unitFold波提升");
                        }

                    }
                    if (c.getEffect_C().indexOf("Soul") != -1) {
                        if (c.getType()==null){
                            c.setType("unitSoul提升");
                        }else {
                            c.setType(c.getType() + "&unitSoul提升");
                        }
                    }
                }
                break;
            case "action":
                c.setId(j.getId());
                c.setEffect_C(actionJ2C(j.getEffect()));
                c.setEffect_M_C(actionJ2C(j.getEffect_M()));
                if(c.getEffect_C().indexOf("伤害减半")!=-1){
                    c.setType("伤害减半");
                }else if(c.getEffect_C().indexOf("判定缓和")!=-1){
                    c.setType("判定缓和");
                }else if(c.getEffect_C().indexOf("combo不断")!=-1){
                    c.setType("combo不断");
                }else if(c.getEffect_C().indexOf("生命回复")!=-1){
                    c.setType("生命回复");
                }else if(c.getEffect_C().indexOf("分数提高")!=-1){
                    c.setType("分数提高");
                }
                break;
            case "live":
                c.setId(j.getId());
                c.setEffect_C(LiveJ2C(j.getEffect()));
                c.setEffect_M_C(LiveJ2C(j.getEffect_M()));
                if(c.getEffect_C().indexOf("判定")!=-1){
                    if(c.getEffect_C().indexOf("每秒生命值降低")!=-1){
                        c.setType("判定缓和+生命减少");
                    }else if(c.getEffect_C().indexOf("伤害")!=-1){
                        c.setType("判定缓和+伤害减少");
                    }else if(c.getEffect_C().indexOf("回复")!=-1){
                        c.setType("判定缓和+生命回复");
                    }else if(c.getEffect_C().indexOf("combo不断")!=-1){
                        c.setType("判定缓和+combo不断");
                    }else if(c.getEffect_C().indexOf("分数")!=-1){
                        c.setType("判定缓和+分数提高");
                    }else{
                        c.setType("判定缓和");
                    }
                }else if(c.getEffect_C().indexOf("伤害")!=-1){
                    if(c.getEffect_C().indexOf("判定")!=-1){
                        c.setType("伤害减少+判定缓和");
                    }else if(c.getEffect_C().indexOf("每秒生命值降低")!=-1){
                        c.setType("伤害减少+生命减少");
                    }else if(c.getEffect_C().indexOf("回复")!=-1){
                        c.setType("伤害减少+生命回复");
                    }else if(c.getEffect_C().indexOf("combo不断")!=-1){
                        c.setType("伤害减少+combo不断");
                    }else if(c.getEffect_C().indexOf("分数")!=-1){
                        c.setType("伤害减少+分数提高");
                    }else{
                        c.setType("伤害减少");
                    }
                }else if(c.getEffect_C().indexOf("回复")!=-1){
                    if(c.getEffect_C().indexOf("判定")!=-1){
                        c.setType("生命回复+判定缓和");
                    }else if(c.getEffect_C().indexOf("伤害")!=-1){
                        c.setType("生命回复+伤害减少");
                    }else if(c.getEffect_C().indexOf("combo不断")!=-1){
                        c.setType("生命回复+combo不断");
                    }else if(c.getEffect_C().indexOf("分数")!=-1){
                        c.setType("生命回复+分数提高");
                    }else{
                        c.setType("生命回复");
                    }
                }else if(c.getEffect_C().indexOf("combo不断")!=-1){
                    if(c.getEffect_C().indexOf("判定")!=-1){
                        c.setType("combo不断+判定缓和");
                    }else if(c.getEffect_C().indexOf("伤害")!=-1){
                        c.setType("combo不断+伤害减少");
                    }else if(c.getEffect_C().indexOf("回复")!=-1){
                        c.setType("combo不断+生命回复");
                    }else if(c.getEffect_C().indexOf("每秒生命值降低")!=-1){
                        c.setType("combo不断+生命减少");
                    }else if(c.getEffect_C().indexOf("分数")!=-1){
                        c.setType("combo不断+分数提高");
                    }else{
                        c.setType("combo不断");
                    }
                }else if(c.getEffect_C().indexOf("分数")!=-1){
                    if(c.getEffect_C().indexOf("判定")!=-1){
                        c.setType("判定缓和+分数提高");
                    }else if(c.getEffect_C().indexOf("伤害")!=-1){
                        c.setType("伤害减少+分数提高");
                    }else if(c.getEffect_C().indexOf("回复")!=-1){
                        c.setType("生命回复+分数提高");
                    }else if(c.getEffect_C().indexOf("combo不断")!=-1){
                        c.setType("combo不断+分数提高");
                    }else if(c.getEffect_C().indexOf("每秒生命值降低")!=-1){
                        c.setType("生命减少+分数提高");
                    }else{
                        c.setType("分数提高");
                    }
                }
                break;
        }
        return c;
    }
    public String CenterJ2C(String j){
//        ユニットのサポート値が10％アップ
//        ユニットのトータル値とサポート値が10％アップ
//        命属性プレートのトータル値が10％アップ
//        命属性楽曲の時ユニットのトータル値が12％アップ
        j = j.replace("属性楽曲の時ユニットの","属性乐曲时unit的");
        j = j.replace("ユニットの","unit的");
        j = j.replace("属性プレートの","属性卡的");

        j = j.replace("トータル","Total");
        j = j.replace("ボイス","Voice");
        j = j.replace("ライフ","Life");
        j = j.replace("チャーム","Charm");
        j = j.replace("サポート","Support");
        j = j.replace("フォールド波","Fold波");
        j = j.replace("ソウル","Soul");
        j = j.replace("と","和");
        j = j.replace("が","提升");
        j = j.replace("アップ","");
        return j;
    }
    public String actionJ2C(String j){
        j = j.replace("秒間ダメージが半減する","秒内受到伤害减半");
        j = j.replace("秒間判定が緩和される","秒内判定缓和");
        j = j.replace("秒間コンボが切れない","秒内combo不断");
        j = j.replace("ライフを","生命回复");
        j = j.replace("回復","");
        j = j.replace("秒間スコアが","秒内分数提高");
        j = j.replace("アップ","");
        return j;
    }
    public String LiveJ2C(String j){
            j = j.replace("コンボ時に発動し","combo时发动,");
            j = j.replace("バルキリーモード開始時に発動し","空战模式开始时发动,");
            j = j.replace("超歌姫モード開始時に発動し","歌姬模式开始时发动,");
            j = j.replace("開始","开始");
            j = j.replace("秒後に発動し","秒后发动,");
            j = j.replace("秒後に発動、","秒后发动,");
            j = j.replace("毎秒ライフが","每秒生命值降低");
            j = j.replace("ライフが","生命值");

            j = j.replace("秒間","秒内");
            j = j.replace("アップ","提升");
            j = j.replace("スコアが","分数");
            j = j.replace("コンボが切れない","combo不断");
            j = j.replace("ダメージを受けなくなる","不受伤害");
            j = j.replace("ダメージを受けなくなり","不受伤害同时");
            j = j.replace("コンボが切れず","combo不断同时");

            j = j.replace("ダメージ半減","伤害减半");
            j = j.replace("ダメージ","伤害降低");

            j = j.replace("減少する","点");
            j = j.replace("減少","点");
            j = j.replace("減","");
            j = j.replace("回復","");
            j = j.replace("ライフを","生命值回复");
            j = j.replace("ダメージを受けなくなる","不受伤害");
            j = j.replace("判定が緩和される","判定缓和");
            j = j.replace("判定が緩和され","判定缓和同时");

            j = j.replace("以下になると発動し","以下时发动,");
             j = j.replace("以下になると","以下时发动,");

            j = j.replace("し","同时");
            j = j.replace("され","同时");



        return j;
    }

    @RequestMapping("/getSkillType")
    @ResponseBody
    public String getSkillType(){
        JSONObject jsonObject = new JSONObject();
        List<String> center = skillService.getSkillType_Pos("center");
        List<String> live = skillService.getSkillType_Pos("live");
        List<String> action = skillService.getSkillType_Pos("action");
        jsonObject.put("center",center);
        jsonObject.put("live",live);
        jsonObject.put("action",action);
        return jsonObject.toJSONString();
    }
}
