package com.macross.dao;

import com.macross.entry.skill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface skillDao {
    public skill getSkill(skill skill);
    public int addSkill(skill skill);
    public skill getSkill_id(int id);
    public List<skill> getAllSkill();
    public int translate(skill skill);
    public List<String> getSkillType_Pos(String pos);
}
