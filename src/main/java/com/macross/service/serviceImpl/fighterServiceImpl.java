package com.macross.service.serviceImpl;

import com.macross.dao.fighterDao;
import com.macross.entry.fighter;
import com.macross.service.fighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fighterService")
public class fighterServiceImpl implements fighterService {
    @Autowired
    public fighterDao fighterDao;
    @Override
    public fighter getFighter_url(String url) {
        return fighterDao.getFighter_url(url);
    }

    @Override
    public int addFighter(fighter fighter) {
        return fighterDao.addFighter(fighter);
    }

    @Override
    public List<fighter> getAllFighter() {
        return fighterDao.getAllFighter();
    }
}
