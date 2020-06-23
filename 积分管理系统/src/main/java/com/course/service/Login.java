package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class Login {

    public void login(){

    	int integral_value = 1;
    	int num=1;
  
    	String file = FileUtils.readFile("score");
    	PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
    	Integer grow = pointObject.getGrowScore();
    	Integer total = pointObject.getScoreTotal();
    	Integer login = pointObject.getLogin();
    	
    	//判断是否是第一次登陆平台
    	if(login==0){
        	pointObject.setGrowScore(grow+integral_value);
        	pointObject.setScoreTotal(total+integral_value);
        	pointObject.setLogin(login+num);
    	}
    	else{
    		System.out.println("==您今天已经登陆过平台了呢==");
    	}
    	
    	String content = JsonUtils.objectToJson(pointObject);  //模拟数据库的写操作，把对象转换成json的字符串
    	FileUtils.writeFile("score", content);
    	
        
    }
    
}
