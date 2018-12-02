package com.macross.service.serviceImpl;

import com.macross.dao.clothingDao;
import com.macross.entry.clothing;
import com.macross.service.clothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clothingService")
public class clothingServiceImpl implements clothingService {
    @Autowired
    public clothingDao clothingDao;
    @Override
    public clothing getClothing_url(String url) {
        return clothingDao.getClothing_url(url);
    }

    @Override
    public int addClothing(clothing clothing) {
        return clothingDao.addClothing(clothing);
    }
}
