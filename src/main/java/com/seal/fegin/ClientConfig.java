package com.seal.fegin;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean
    public MessageClient messageClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(MessageClient.class))
                .logLevel(Logger.Level.FULL)
                .target(MessageClient.class, "http://localhost:8081/");
    }

    @Bean
    public AnotherMessageClient anotherMessageClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(MessageClient.class))
                .logLevel(Logger.Level.FULL)
                .target(AnotherMessageClient.class, "http://localhost:8081/");
    }

}
