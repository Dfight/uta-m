package com.macross.dao;

import com.macross.entry.attr;
import org.springframework.stereotype.Repository;

@Repository
public interface attrDao {
    public attr getAttr_name(String name);
}
