package com.macross.service.serviceImpl;

import com.macross.dao.skillDao;
import com.macross.entry.skill;
import com.macross.service.skillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("skillService")
public class skillServiceImpl implements skillService {
    @Autowired
    public skillDao skillDao;
    @Override
    public int addSkill(skill skill) {
        skill ex_skill = skillDao.getSkill(skill);
        if (ex_skill==null){
            skillDao.addSkill(skill);
            return skill.getId();
        }else{
            return ex_skill.getId();
        }
    }

    @Override
    public skill getSkill_id(int id) {
        return skillDao.getSkill_id(id);
    }

    @Override
    public List<skill> getAllSkill() {
        return skillDao.getAllSkill();
    }

    @Override
    public int translate(skill skill) {
        return skillDao.translate(skill);
    }

    @Override
    public List<String> getSkillType_Pos(String pos) {
        return skillDao.getSkillType_Pos(pos);
    }
}
