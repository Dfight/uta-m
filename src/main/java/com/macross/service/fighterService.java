package com.macross.service;

import com.macross.entry.fighter;

import java.util.List;

public interface fighterService {
    public fighter getFighter_url(String url);
    public int addFighter(fighter fighter);
    public List<fighter> getFighter_opus(int opus);
}
