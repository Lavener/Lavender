package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

import java.io.File;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class BloodSugar {

    public void bloodSugar(){
        int point = 1;
        int add = 1;

        String file = FileUtils.readFile("score");
        PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);//序列化，string转换成object

        Integer blood_sugar = pointObject.getBloodSugar();
        if (blood_sugar==null)
            blood_sugar = 0;
        blood_sugar = blood_sugar + add;
        pointObject.setBloodSugar(blood_sugar);
        //大于三并且第一次记录，则加一个积分
        if(blood_sugar>3&&pointObject.getflag()==0) {
            Integer grow = pointObject.getGrowScore();
            pointObject.setGrowScore(grow + point);
            Integer total = pointObject.getScoreTotal();
            pointObject.setScoreTotal(total+point);
             pointObject.setflag(1);

        }

        String content = JsonUtils.objectToJson(pointObject);
        FileUtils.writeFile("score", content);
        System.out.println("+++++bloodSugar积分计算方法执行+++++");
    }

}
