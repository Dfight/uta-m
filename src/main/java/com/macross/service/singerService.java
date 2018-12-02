package com.macross.service;

import com.macross.entry.singer;
import com.macross.entry.singer_detailed;

public interface singerService {
    public boolean exist_url(String url);
    public singer getSinger_name(String name);
    public int addSinger(singer singer);
    public void addSingerDetailed(singer singer, singer_detailed init,singer_detailed max);
}
