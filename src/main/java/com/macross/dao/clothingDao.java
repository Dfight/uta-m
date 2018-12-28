package com.macross.dao;

import com.macross.entry.clothing;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface clothingDao {
    public clothing getClothing_url(String url);
    public int addClothing(clothing clothing);
    public List<clothing> getAllClothing();
    public List<HashMap<String,Object>> getClothing_singer(int id);
}
