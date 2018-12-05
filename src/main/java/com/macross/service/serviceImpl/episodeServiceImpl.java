package com.macross.service.serviceImpl;

import com.macross.dao.episodeDao;
import com.macross.entry.episode;
import com.macross.service.episodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("episodeService")
public class episodeServiceImpl implements episodeService {
    @Autowired
    public episodeDao episodeDao;
    @Override
    public int addEpisode(episode episode) {
        return episodeDao.addEpisode(episode);
    }

    @Override
    public boolean existEpisode(String url) {
        episode episode = episodeDao.existEpisode(url);
        if(episode==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public episode getEpisode_url(String url) {
        return episodeDao.existEpisode(url);
    }

    @Override
    public List<episode> getEpisode_opus(int opus) {
        return episodeDao.getEpisode_opus(opus);
    }
}
