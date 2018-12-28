package com.macross.service.serviceImpl;

import com.macross.dao.attrDao;
import com.macross.entry.attr;
import com.macross.service.attrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("attrService")
public class attrServiceImpl implements attrService {
    @Autowired
    public attrDao attrDao;
    @Override
    public attr getAttr_name(String name) {
        return attrDao.getAttr_name(name);
    }

    @Override
    public List<attr> getAllAttr() {
        return attrDao.getAllAttr();
    }
}
