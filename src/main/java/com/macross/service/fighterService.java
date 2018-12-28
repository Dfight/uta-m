package com.macross.service;

import com.macross.entry.fighter;

import java.util.HashMap;
import java.util.List;

public interface fighterService {
    public fighter getFighter_url(String url);
    public int addFighter(fighter fighter);
    public List<fighter> getAllFighter();
    public List<HashMap<String,Object>> getAllFighter_opus(int opus);
}
