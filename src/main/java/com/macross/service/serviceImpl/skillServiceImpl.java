package com.macross.service.serviceImpl;

import com.macross.dao.skillDao;
import com.macross.entry.skill;
import com.macross.service.skillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
