package com.example.democustomspringannotationsaspect.controller;

import com.example.democustomspringannotationsaspect.annotation.AgeControl;
import com.example.democustomspringannotationsaspect.annotation.AttachDate;
import com.example.democustomspringannotationsaspect.dto.StaticDtoObjectTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseStatus(HttpStatus.ACCEPTED)
@RequestMapping("api")
public class HelloController {

    @GetMapping("greeting")
    @AttachDate
    public String getGreeting(){
        return "Hi there!";
    }

    @GetMapping("object")
    @AgeControl
    public Object getObject(){
        return new StaticDtoObjectTest(12345, "test",77);
    }


}
