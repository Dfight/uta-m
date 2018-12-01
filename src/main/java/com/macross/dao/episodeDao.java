package com.macross.dao;

import com.macross.entry.episode;
import org.springframework.stereotype.Repository;

@Repository
public interface episodeDao {
    public int addEpisode(episode episode);
    public episode existEpisode(String url);
}
