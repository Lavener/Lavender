package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class ResearchRecruitment {

    public void researchRecruitment(){
    	String file = FileUtils.readFile("score");
    	PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
    	Integer exchange = pointObject.getExchangeScore();
    	Integer total = pointObject.getScoreTotal();
    	Integer researchRecruitment = pointObject.getResearchRecruitment();
    	pointObject.setExchangeScore(exchange+8);
    	pointObject.setScoreTotal(total+8);
    	pointObject.setResearchRecruitment(researchRecruitment+1);
    	
    	String content = JsonUtils.objectToJson(pointObject);
    	FileUtils.writeFile("score", content);
        System.out.println("+++++researchRecruitment积分计算方法执行+++++");
    }

}
