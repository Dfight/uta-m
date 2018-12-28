package com.macross.dao;

import com.macross.entry.fighter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface fighterDao {
    public fighter getFighter_url(String url);
    public int addFighter(fighter fighter);
    public List<fighter> getAllFighter();
    public List<HashMap<String,Object>> getAllFighter_opus(int opus);
}
