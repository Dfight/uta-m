package com.macross.service;

import com.macross.entry.clothing;

public interface clothingService {
    public clothing getClothing_url(String url);
    public int addClothing(clothing clothing);
}
