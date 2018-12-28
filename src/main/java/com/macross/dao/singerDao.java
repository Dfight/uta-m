package com.macross.dao;

import com.macross.entry.singer;
import com.macross.entry.singer_detailed;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface singerDao {
    public singer exist_url(String url);
    public singer getSinger_name(String name);
    public int addSinger(singer singer);
    public int addSingerDate(singer singer);
    public int addSingerDetailed(singer_detailed singer_detailed);
    public List<HashMap<String,Object>> getAllSinger();
    public int getSingerClothingNumber(int id);
    public int getSingerCardNumber(int id);
    public HashMap<String,Object> getSinger(int id);
    public singer_detailed getSingerInit(int id);
    public singer_detailed getSingerMax(int id);

}
