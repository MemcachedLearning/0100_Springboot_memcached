package com.ymd.learn.memcachedemo.config;

import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.FailureMode;
import net.spy.memcached.HashAlgorithm;
import net.spy.memcached.spring.MemcachedClientFactoryBean;
import net.spy.memcached.transcoders.SerializingTranscoder;
import org.springframework.beans.factory.config.FieldRetrievingFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="memcached")
public class MemcacheConfig {

    private String servers;
    private String protocol;
    private long opTimeout;
    private int timeoutExceptionThreshold;
    private String locatorType;
    private String failureMode;
    private boolean useNagleAlgorithm;

    @Bean("memcachedClient")
    public MemcachedClientFactoryBean getMemcachedClientFactoryBean() {
        MemcachedClientFactoryBean bean = new MemcachedClientFactoryBean();
        bean.setServers(this.servers);
        bean.setProtocol(ConnectionFactoryBuilder.Protocol.valueOf(this.protocol));
        SerializingTranscoder transcoder = new SerializingTranscoder();
        transcoder.setCompressionThreshold(1024);
        bean.setTranscoder(transcoder);
        bean.setOpTimeout(this.opTimeout);
        bean.setTimeoutExceptionThreshold(this.timeoutExceptionThreshold);
        bean.setLocatorType(ConnectionFactoryBuilder.Locator.valueOf(this.locatorType));
        bean.setFailureMode(FailureMode.Redistribute);
        bean.setUseNagleAlgorithm(useNagleAlgorithm);
        bean.setHashAlg((HashAlgorithm) this.getFieldRetrievingFactoryBean());
        return bean;
    }

    @Bean
    public FieldRetrievingFactoryBean getFieldRetrievingFactoryBean() {
        FieldRetrievingFactoryBean bean = new FieldRetrievingFactoryBean();
        bean.setStaticField("net.spy.memcached.DefaultHashAlgorithm.KETAMA_HASH");
        return bean;
    }

}
