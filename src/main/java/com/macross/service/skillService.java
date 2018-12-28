package com.macross.service;

import com.macross.entry.skill;

import java.util.List;

public interface skillService {
    public int addSkill(skill skill);
    public skill getSkill_id(int id);
    public List<skill> getAllSkill();
    public int translate(skill skill);
    public List<String> getSkillType_Pos(String pos);
}
