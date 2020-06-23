package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class FollowUp {

    public void followUp(){
    	int integral_value = 3;
    	
    	String file = FileUtils.readFile("score");
    	PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
    	
    	Integer exchange = pointObject.getExchangeScore();
    	Integer total = pointObject.getScoreTotal();
    	Integer num = pointObject.getFollowup();
    	pointObject.setExchangeScore(exchange+integral_value);
    	pointObject.setScoreTotal(total+integral_value);
    	pointObject.setFollowup(num+1);
    	
    	String content = JsonUtils.objectToJson(pointObject);
    	FileUtils.writeFile("score", content);
    	
        System.out.println("+++++followUp积分计算方法执行+++++");
    }

}
