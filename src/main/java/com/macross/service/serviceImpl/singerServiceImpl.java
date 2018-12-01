package com.macross.service.serviceImpl;

import com.macross.dao.singerDao;
import com.macross.entry.singer;
import com.macross.service.singerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("singerService")
public class singerServiceImpl implements singerService {
    @Autowired
    public singerDao singerDao;
    @Override
    public boolean exist_url(String url) {
        singer singer = singerDao.exist_url(url);
        if(singer!=null){
            return true;
        }else{
            return false;
        }
    }
}
