package com.macross.dao;

import com.macross.entry.opus;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface opusDao {
    public List<opus> getAllOpus();
    public opus getopus_img(String img);
}
