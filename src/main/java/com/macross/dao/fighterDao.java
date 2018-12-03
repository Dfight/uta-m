package com.macross.dao;

import com.macross.entry.fighter;
import org.springframework.stereotype.Repository;

@Repository
public interface fighterDao {
    public fighter getFighter_url(String url);
    public int addFighter(fighter fighter);
}
