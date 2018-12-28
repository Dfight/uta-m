package com.macross.dao;

import com.macross.entry.attr;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface attrDao {
    public attr getAttr_name(String name);
    public List<attr> getAllAttr();
}
