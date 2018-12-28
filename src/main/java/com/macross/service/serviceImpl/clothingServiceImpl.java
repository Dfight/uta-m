package com.macross.service.serviceImpl;

import com.macross.dao.clothingDao;
import com.macross.entry.clothing;
import com.macross.service.clothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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

    @Override
    public List<clothing> getAllClothing() {
        return clothingDao.getAllClothing();
    }

    @Override
    public List<HashMap<String,Object>> getClothing_singer(int id) {
        return clothingDao.getClothing_singer(id);
    }
}
