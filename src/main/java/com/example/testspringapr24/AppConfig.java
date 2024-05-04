package com.example.testspringapr24;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean("MyNumOne")
    @Scope("prototype")
    public MyNumber getMyNum(){
        MyNumber myNumber = new MyNumber();
        myNumber.setNum(76);
        return myNumber;
    }

    @Bean
    @Scope("prototype")
    public MyNumber getMyNumTwo(){
        MyNumber myNumber = new MyNumber();
        myNumber.setNum(89);
        return myNumber;
    }
}
