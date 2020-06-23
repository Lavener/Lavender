package com.course.service;


import java.util.Calendar;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class Level {

    public void level(){
    	String file = FileUtils.readFile("score");
		PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
		Integer growScore = pointObject.getGrowScore();
		char growScoreGrade = pointObject.getlevel();
		// 获取记录日期
		int year = pointObject.getyear(); 
		int month = pointObject.getmonth();
		// 获取当前日期
		Calendar newcal = Calendar.getInstance();
		int newyear = newcal.get(Calendar.YEAR); 
		int newmonth = newcal.get(Calendar.MONTH) + 1;
		if (year == newyear && month == newmonth) {
			//如果处于同一个月则进行评级
			//否则默认当月初次登录，默认等级为'C'
			if (0 <= growScore && growScore <= 10) {
				pointObject.setlevel('C');
				System.out.println("成长积分评级 ："+pointObject.getlevel());
			} else if (10 < growScore && growScore <= 25) {
				pointObject.setlevel('B');
				System.out.println("成长积分评级 ："+pointObject.getlevel());
			} else if (25 < growScore) {
				pointObject.setlevel('A');
				System.out.println("成长积分评级 ："+pointObject.getlevel());
			}
		} 
		// 将时间更新为当前日期
		pointObject.setyear(); 
		pointObject.setmonth();
		String content = JsonUtils.objectToJson(pointObject);
		FileUtils.writeFile("score", content);
        System.out.println("+++++level成长积分评级计算方法执行+++++");
    }

}
