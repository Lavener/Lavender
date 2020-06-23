package com.course;

import com.course.controller.BloodSugar;


import com.course.controller.ExtendedActivity;

import com.course.controller.TestDesign;

import com.course.controller.YdgnNote;

import com.course.controller.FillInformation;//引入包
import com.course.controller.EvaluateReport;
import com.course.controller.ResearchRecruitment;
import com.course.controller.Level;
import com.course.controller.BfzNote;
import com.course.controller.FollowUp;
import com.course.controller.Login;
import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lixuy
 * Created on 2019-04-10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class TestInterceptor {
	
	@Autowired
	TestDesign testDesign;

	@Autowired
    ExtendedActivity extendedActivity;

	@Autowired
    BloodSugar bloodSugar;

	@Autowired
    YdgnNote ydgnNote;

	@Autowired
	FillInformation fillinformation;
	
	@Autowired
	EvaluateReport evaluateReport;
	
	@Autowired
	ResearchRecruitment researchRecruitment;
	
	@Autowired
	Level level;
	
	
	@Autowired
	FollowUp followUp;
	
	@Autowired 
	Login login;
	
	@Autowired
	BfzNote bfzNote;
	
	
    //检验当前积分情况
    private int assertScore(){
        try {
            String file = FileUtils.readFile("score");
            PointObject pointObject = JsonUtils.jsonToPojo(file,PointObject.class);
            System.out.println("成长积分："+pointObject.getGrowScore());
            System.out.println("可交换积分："+pointObject.getExchangeScore());
            System.out.println("总积分："+pointObject.getScoreTotal());
            System.out.println("登陆平台："+pointObject.getLogin());
            System.out.println("填写个人资料："+pointObject.getFillInformation());
            System.out.println("记录血糖的次数 ："+pointObject.getBloodSugar());
            
            System.out.println("填写并发症的次数 ："+pointObject.getbfzNote());
            System.out.println("生成评估报告 ："+pointObject.getEvaluateReport());
            System.out.println("监测胰岛功能 ："+pointObject.getydgn());
            
            System.out.println("完成门诊随访 ："+pointObject.getFollowup());
            System.out.println("参加扩展活动 ："+pointObject.getExtendedactivity());
            System.out.println("参加科研招募 ："+pointObject.getResearchRecruitment());
            
 
            
            return pointObject.getScoreTotal();
        }catch (Exception e){
            e.printStackTrace();
        }
		return 0;        
    }
 
  //记录成长积分
    private int assertGrowScore() {
		try {
			String file = FileUtils.readFile("score");
			PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
			return pointObject.getGrowScore();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
    //记录可兑换积分的情况
	private int assertExchangeScore() {
		try {
			String file = FileUtils.readFile("score");
			PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
			return pointObject.getExchangeScore();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
    
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("this is setUpBeforeClass...");
    }
 
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("this is tearDownAfterClass...");
    }
 
    @Before
    public void setUp() throws Exception {
        System.out.println("this is setUp...");
    }
 
    @After
    public void tearDown() throws Exception {
        System.out.println("this is tearDown...");
    }
    
    /* 门诊随访的测试方法  */
    @Test
    public void followUpTest() {  //空参方法
    	try {
    		int score1=assertScore();
    		followUp.followUp();
    		int score2=assertScore();
    		
    		assertEquals(3, score2-score1);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    /* 登陆平台的测试方法  */
    @Test
    public void loginTest() {  //空参方法
    	try {
    		int score1=assertScore();
    		login.login();
    		int score2=assertScore();
    		
    		assertEquals(1, score2-score1); 
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    /* 填写并发症记录的测试方法  */
    @Test
    public void bfzNoteTest() {  //空参方法
    	try {
    		int score1=assertScore();
    		bfzNote.bfzNote();
    		int score2=assertScore();
    		
    		assertEquals(3, score2-score1); 
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    

    @Test
    public void extendActivity(){
        try{
            int score1 = assertScore();
            extendedActivity.extendedActivity();
            int score2 = assertScore();

            assertEquals(5, score2-score1);

        }catch(Exception e){
            // TODO: handle exception
        }
    }

    @Test
    public void bloodSugar(){
        try{
            int score1 = assertScore();
            bloodSugar.bloodSugar();
            int score2 = assertScore();
            //assertEquals(1, score2-score1);
        }catch(Exception e){
            // TODO: handle exception
        }
    }

    @Test
    public void ydgnNote(){
        try{
            int score1 = assertScore();
            ydgnNote.ydgnNote();
            int score2 = assertScore();
            //assertEquals(2, score2-score1);

    		
    		assertEquals(2, score2-score1); 
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    

  //测试成长积分评级
    @Test
    public void level() {
    	try {
    		int score1=assertScore();
    		level.level();
    		int score2=assertScore();
    		assertEquals(0, score2-score1);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    //测试填写个人资料
    @Test
    public void fillinformation() {
    	try {
    		int score1=assertScore();
    		fillinformation.fillInformation();
    		int score2=assertScore();
    		
    		assertEquals(2, score2-score1);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    //测试生成评估报告
    @Test
    public void evaluateReport() {
    	try {
    		int score1=assertScore();
    		evaluateReport.evaluateReport();
    		int score2=assertScore();
    		assertEquals(2, score2-score1);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    //测试参加科研招募
    @Test
    public void researchRecruitment() {
    	try {
    		int score1=assertScore();
    		int score2 = assertGrowScore();
    		int score3 = assertExchangeScore();
    		researchRecruitment.researchRecruitment();
    		int score4=assertScore();
    		int score5 = assertGrowScore();
    		int score6 = assertExchangeScore();
    		assertEquals(8, score4-score1);
    		assertEquals(0, score5-score2);
    		assertEquals(8, score6-score3);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }

    

}
