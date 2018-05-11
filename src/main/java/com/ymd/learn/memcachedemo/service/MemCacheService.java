package com.ymd.learn.memcachedemo.service;

import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemCacheService {

    @Autowired
    private MemcachedClient memcachedClient;

    public void setValue(String name, String value) {
        this.memcachedClient.add(name, 0, value );
    }

    public String getValue(String name) {
        return (String)this.memcachedClient.get(name);
    }



}
