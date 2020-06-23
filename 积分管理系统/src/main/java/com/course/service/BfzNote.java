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
public class BfzNote {

    public void bfzNote(){
    	int integral_value = 3;
        Calendar rightNow = Calendar.getInstance();
        String file = FileUtils.readFile("score");
        PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
        Integer grow = pointObject.getGrowScore();
        Integer total = pointObject.getScoreTotal();
        Calendar previous = pointObject.getbfzNoteTime();
        if(previous==null) {
            pointObject.setbfzNoteTime();
            previous = Calendar.getInstance();
        }
        Integer bfzNote = pointObject.getbfzNote();
        //默认无并发症记录的时候，填写一次（添加）
        if(bfzNote==0) {
            bfzNote ++;
            pointObject.setbfzNote(bfzNote); //设置并发症记录为1（即已经填写过一次），并且积分一次

            pointObject.setGrowScore(grow+integral_value);
            pointObject.setScoreTotal(total+integral_value);
        }
        //一年只填写一次并发症记录，积分一次
        if((rightNow.get(Calendar.YEAR)-previous.get(Calendar.YEAR)==1
                &&rightNow.get(Calendar.MONTH)>=previous.get(Calendar.MONTH)
                &&rightNow.get(Calendar.DATE)>=previous.get(Calendar.DATE))
        		||rightNow.get(Calendar.YEAR)-previous.get(Calendar.YEAR)>1)
        {
            pointObject.setbfzNoteTime();  //更新填写并发症记录的日期时间
            pointObject.setGrowScore(grow+integral_value);
            pointObject.setScoreTotal(total+integral_value);
        }
        String content = JsonUtils.objectToJson(pointObject);  //模拟数据库的写操作，把对象转换成json的字符串
        FileUtils.writeFile("score", content);

        System.out.println("+++++bfzNote积分计算方法执行+++++");
    }

}
