package com.macross.service;

import com.macross.entry.singer;
import com.macross.entry.singer_detailed;

import java.util.HashMap;
import java.util.List;

public interface singerService {
    public boolean exist_url(String url);
    public singer getSinger_name(String name);
    public int addSinger(singer singer);
    public void addSingerDetailed(singer singer, singer_detailed init,singer_detailed max);
    public List<HashMap<String,Object>> getAllSinger();
    public int getSingerClothingNumber(int id);
    public int getSingerCardNumber(int id);
    public HashMap<String,Object> getSinger(int id);
    public singer_detailed getSingerInit(int id);
    public singer_detailed getSingerMax(int id);
}
