package com.course;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;
import org.junit.Test;

/**
 * @author lixuy
 * Created on 2019-04-10
 */
public class TestFileIo {

    @Test
    public void testWrite(){
        try {
            PointObject pointObject = new PointObject();
            pointObject.setId(1);
            pointObject.setGrowScore(0);
            pointObject.setExchangeScore(0);
            pointObject.setScoreTotal(0); 
            pointObject.setFillInformation(0);
            pointObject.setEvaluateReport(0);
            pointObject.setBloodSugar(0);
            pointObject.setResearchRecruitment(0);
            pointObject.setyear();
            pointObject.setmonth();
            //此处默认为‘c'
            pointObject.setlevel('C');
            pointObject.setLogin(0);
            pointObject.setbfzNote(0);
            pointObject.setFollowup(0);
            pointObject.setExtendedactivity(0);
            pointObject.setydgn(0);
            pointObject.setflag(0);
            String json = JsonUtils.objectToJson(pointObject);
            FileUtils.writeFile("score",json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testRead() {
        try {
            String file = FileUtils.readFile("score");
            System.out.println(file);
            PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
            System.out.println(pointObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
