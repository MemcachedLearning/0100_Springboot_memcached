package com.ymd.learn.memcachedemo.runner;

import com.ymd.learn.memcachedemo.service.MemCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MemcachedRunner implements CommandLineRunner {

    @Autowired()
    private MemCacheService memCacheService;

    @Override
    public void run(String... args) throws Exception {
        //memCacheService.setValue("name", "michael");
        System.out.println(memCacheService.getValue("name"));
        System.out.println("Done!");
    }
}
