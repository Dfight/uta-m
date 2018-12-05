package com.macross.service;

import com.macross.entry.episode;

import java.util.List;

public interface episodeService {
    public int addEpisode(episode episode);
    public boolean existEpisode(String url);
    public episode getEpisode_url(String url);
    public List<episode> getAllEpisode();
}
