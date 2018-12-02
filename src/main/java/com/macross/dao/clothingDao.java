package com.macross.dao;

import com.macross.entry.clothing;
import org.springframework.stereotype.Repository;

@Repository
public interface clothingDao {
    public clothing getClothing_url(String url);
    public int addClothing(clothing clothing);
}
