package com.macross.service;

import com.macross.entry.clothing;

import java.util.List;

public interface clothingService {
    public clothing getClothing_url(String url);
    public int addClothing(clothing clothing);
    public List<clothing> getAllClothing();
}
