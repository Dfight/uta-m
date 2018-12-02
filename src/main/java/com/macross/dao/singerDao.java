package com.macross.dao;

import com.macross.entry.singer;
import com.macross.entry.singer_detailed;
import org.springframework.stereotype.Repository;

@Repository
public interface singerDao {
    public singer exist_url(String url);
    public singer getSinger_name(String name);
    public int addSinger(singer singer);
    public int addSingerDate(singer singer);
    public int addSingerDetailed(singer_detailed singer_detailed);
}
