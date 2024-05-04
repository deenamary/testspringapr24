package com.example.testspringapr24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @Autowired
    @Qualifier("MyNumOne")
    MyNumber number1;

    @Autowired
    @Qualifier("getMyNumTwo")
    MyNumber number2;

    @GetMapping("greet")
    public String greet() {
        return "Hello World";
    }

    @GetMapping("get/numberone")
    public MyNumber getNumber1(){
        number1.increment();
        return number1;
    }

    @GetMapping("get/numbertwo")
    public MyNumber getNumber2(){
        return number2;
    }

}
