package com.macross.service.serviceImpl;
import com.macross.dao.userDao;
import com.macross.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class userServiceImpl implements userService {
    @Autowired
    private userDao userDao;

    @Override
    public String getcardname(int id) {
        return userDao.getcardname(id);
    }
}
