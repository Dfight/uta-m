package com.macross.dao;

import com.macross.entry.skill;
import org.springframework.stereotype.Repository;

@Repository
public interface skillDao {
    public skill getSkill(skill skill);
    public int addSkill(skill skill);
}
