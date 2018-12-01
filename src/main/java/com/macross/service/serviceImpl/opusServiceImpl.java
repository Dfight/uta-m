package com.macross.service.serviceImpl;

import com.macross.dao.opusDao;
import com.macross.entry.opus;
import com.macross.service.opusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("opusService")
public class opusServiceImpl implements opusService {
    @Autowired
    public opusDao opusDao;
    @Override
    public List<opus> getAllOpus() {
        return opusDao.getAllOpus();
    }

    @Override
    public opus getopus_img(String img) {
        return opusDao.getopus_img(img);
    }

}
