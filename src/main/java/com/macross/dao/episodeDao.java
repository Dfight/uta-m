package com.macross.dao;

import com.macross.entry.episode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface episodeDao {
    public int addEpisode(episode episode);
    public episode existEpisode(String url);
    public List<episode> getEpisode_opus(int opus);
}
