package com.macross.service;

import com.macross.entry.attr;

import java.util.List;

public interface attrService {
    public attr getAttr_name(String name);
    public List<attr> getAllAttr();
}
