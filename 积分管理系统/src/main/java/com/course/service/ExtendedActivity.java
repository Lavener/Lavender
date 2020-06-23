package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class ExtendedActivity {

    public void extendedActivity(){
        int point = 5;
        String file = FileUtils.readFile("score");
        PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);

        Integer exchange = pointObject.getExchangeScore();
        pointObject.setExchangeScore(exchange+point);
        Integer total = pointObject.getScoreTotal();
        pointObject.setScoreTotal(total+point);
        Integer num = pointObject.getExtendedactivity();
        pointObject.setExtendedactivity(num+1);

        String content = JsonUtils.objectToJson(pointObject);
        FileUtils.writeFile("score", content);
        System.out.println("+++++extendedActivity积分计算方法执行+++++");
    }

}
