package com.hotel.hotel.services;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RandomIdGen {

    @Bean
    public String genrateRandomId(){
         Random random = new Random();
        Integer randomId = random.nextInt(1000000) + 1;
        String appId = "BNG" + randomId;
        return appId;
    }
}
