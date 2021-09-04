package com.example.democustomspringannotationsaspect.annotation;

import com.example.democustomspringannotationsaspect.dto.StaticDtoObjectTest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AttachDateAspect {

    @Around("@annotation(AttachDate)")
    public Object addDate(ProceedingJoinPoint pjp) throws Throwable {
        String date = LocalDateTime.now().toString();
        return pjp.proceed() + " || " + date;
    }

    @Around("@annotation(AgeControl)")
    public Object verifyAge(ProceedingJoinPoint pjp) throws Throwable {
        Object res = pjp.proceed();
        log.info("This is res "+res);
        Field field = res.getClass().getDeclaredField("age");
        field.setAccessible(true);
        int age = field.getInt(res);
        log.info("This is Field "+ age);
        log.info("Checking of the age value ...");
        if(age==77){
            byte newAge = 36;
            field.setByte(res,newAge);
        }
        return res;
    }

}
