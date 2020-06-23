package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class EvaluateReport {

    public void evaluateReport(){
    	String file = FileUtils.readFile("score");
    	PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
    	Integer grow = pointObject.getGrowScore();
    	Integer total = pointObject.getScoreTotal();
    	Integer fillInformation = pointObject.getFillInformation();
    	Integer bloodsugar = pointObject.getBloodSugar();
    	Integer evaluatereport = pointObject.getEvaluateReport();
    	//在这里判断是否满足生成评估报告的需求
    	if(fillInformation==1&&bloodsugar>9)
    	{
    		pointObject.setGrowScore(grow+2);
        	pointObject.setScoreTotal(total+2);
        	pointObject.setEvaluateReport(evaluatereport+1);
    	}
    	else
    	{
    		System.out.println("~您不满足生成评估报告的要求~");
    	}
    	
    	String content = JsonUtils.objectToJson(pointObject);
    	FileUtils.writeFile("score", content);
        System.out.println("+++++evaluateReport积分计算方法执行+++++");
    }

}
