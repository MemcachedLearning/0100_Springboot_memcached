package com.ymd.learn.memcachedemo;

import com.btmatthews.springboot.memcached.EnableMemcached;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMemcached
public class MemcachedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemcachedemoApplication.class, args);
    }
}
