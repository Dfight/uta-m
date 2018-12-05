package com.macross.dao;

import com.macross.entry.fighter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface fighterDao {
    public fighter getFighter_url(String url);
    public int addFighter(fighter fighter);
    public List<fighter> getFighter_opus(int opus);
}
