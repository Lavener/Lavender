package com.course.controller;

import org.springframework.stereotype.Component;

@Component

//成长积分评级
public class Level {

    public void level(){
        System.out.println("======被拦截的level方法执行======");
    }

}
