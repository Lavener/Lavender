package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

import java.io.File;
import java.util.Calendar;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class YdgnNote {

    public void ydgnNote(){
        int point = 2;
        Calendar this_time = Calendar.getInstance();

        String file = FileUtils.readFile("score");
        PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);//序列化，string转换成object

        Calendar last_time = pointObject.getCalendar();
        if (last_time==null) {
            pointObject.setCalendar();
            last_time = Calendar.getInstance();
            Integer grow = pointObject.getGrowScore();
            pointObject.setGrowScore(grow + point);
            Integer total = pointObject.getScoreTotal();
            pointObject.setScoreTotal(total+point);
            Integer num = pointObject.getydgn();
            pointObject.setydgn(num+1);
        }
        if ((this_time.get(Calendar.MONTH)-last_time.get(Calendar.MONTH))==3&&
                this_time.get(Calendar.DATE)>=last_time.get(Calendar.DATE)){//超过三个月
            pointObject.setCalendar();//更新记录胰岛功能日期
            Integer grow = pointObject.getGrowScore();
            pointObject.setGrowScore(grow + point);
            Integer total = pointObject.getScoreTotal();
            pointObject.setScoreTotal(total+point);
            Integer num = pointObject.getydgn();
            pointObject.setydgn(num+1);
        }
        String content = JsonUtils.objectToJson(pointObject);
        FileUtils.writeFile("score", content);

        System.out.println("+++++ydgnNote积分计算方法执行+++++");
    }

}
