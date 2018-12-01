package com.macross.service;

import com.macross.entry.episode;

public interface episodeService {
    public int addEpisode(episode episode);
    public boolean existEpisode(String url);
}
