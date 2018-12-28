package com.macross.service.serviceImpl;

import com.macross.dao.singerDao;
import com.macross.entry.singer;
import com.macross.entry.singer_detailed;
import com.macross.service.singerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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

    @Override
    public singer getSinger_name(String name) {
        return singerDao.getSinger_name(name);
    }

    @Override
    public int addSinger(singer singer) {
        return singerDao.addSinger(singer);
    }

    @Override
    public void addSingerDetailed(singer singer, singer_detailed init, singer_detailed max) {
        singerDao.addSingerDate(singer);
        singerDao.addSingerDetailed(init);
        singerDao.addSingerDetailed(max);
    }

    @Override
    public List<HashMap<String,Object>> getAllSinger() {
        return singerDao.getAllSinger();
    }
    public int getSingerClothingNumber(int id){
        return singerDao.getSingerClothingNumber(id);
    }
    public int getSingerCardNumber(int id){
        return singerDao.getSingerCardNumber(id);
    }

    @Override
    public HashMap<String,Object> getSinger(int id) {
        return singerDao.getSinger(id);
    }

    @Override
    public singer_detailed getSingerInit(int id) {
        return singerDao.getSingerInit(id);
    }

    @Override
    public singer_detailed getSingerMax(int id) {
        return singerDao.getSingerMax(id);
    }
}
