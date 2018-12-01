package com.macross.dao;

import com.macross.entry.singer;
import org.springframework.stereotype.Repository;

@Repository
public interface singerDao {
    public singer exist_url(String url);
    public singer getSinger_name(String name);
}
