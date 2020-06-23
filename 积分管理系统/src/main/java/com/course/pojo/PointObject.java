package com.course.pojo;
import java.util.Calendar;
import java.io.Serializable;
import java.util.Calendar;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author lixuy
 * Created on 2019-04-10
 */

@JsonIgnoreProperties(ignoreUnknown = true) //防止jackson反序列化错误--在需要转化的对象的类中添加
public class PointObject implements Serializable{

    private static final long serialVersionUID = 123456789L;

    private Integer id;
    //成长积分数 
    private Integer growScore;
    //可兑换积分数 
    private Integer exchangeScore;
    //总积分数
    private Integer scoreTotal;

    private Integer fillInformation;
    //记录血糖
    private Integer bloodSugar;
    //生成评估报告
    private Integer evaluatereport;
    //完成门诊随访
    private Integer followup;
    //参加扩展活动
    private Integer extendedactivity;
    //参加科研招募
    private Integer researchRecruitment;
    
    //记录登录年月日和评级
    private Integer year;
    private Integer month;
    private Integer day;
    private char level;
    
    //填写胰岛功能的时间
    private Calendar calendar;
    //监测胰岛功能
    private Integer ydgn;
    
    //登陆平台
    private Integer login;
    
    //并发症记录
    private Integer bfzNote;
    
    //并发症记录填写时间
    private Calendar bfzNote_time;
    
    //可兑换积分有效期时间
    private Calendar ExchangePointTime;
    
    //哨兵参数
    private Integer flag = 0;

    public Integer getflag() {
        return flag;
    }

    public void setflag(Integer flag) {
        this.flag = flag;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrowScore() {
        return growScore;
    }

    public void setGrowScore(Integer growScore) {
        this.growScore = growScore;
    }

    public Integer getExchangeScore() {
        return exchangeScore;
    }

    public void setExchangeScore(Integer exchangeScore) {
        this.exchangeScore = exchangeScore;
    }

    public Integer getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(Integer scoreTotal) {
        this.scoreTotal = scoreTotal;
    }



    public Integer getBloodSugar(){return this.bloodSugar;}

    public void setBloodSugar(Integer bloodSugar){this.bloodSugar=bloodSugar;}

    public Calendar getCalendar(){return this.calendar;}

    public void setCalendar(){
        this.calendar = Calendar.getInstance();
    }

   
    //个人资料的填写
    public void setFillInformation(Integer fillInformation) {
        this.fillInformation = fillInformation;
    }
 
	public Integer getFillInformation() {
		return fillInformation;
	}
	
	//生成评估报告
	public void setEvaluateReport(Integer evaluatereport) {
	    this.evaluatereport = evaluatereport;
	}
 
	public Integer getEvaluateReport() {
		return evaluatereport;
	}
	
	//参加科研
	public void setResearchRecruitment(Integer researchRecruitment) {
	    this.researchRecruitment = researchRecruitment;
	}
 
	public Integer getResearchRecruitment() {
		return researchRecruitment;
	}
	
	//记录登录时间和等级
	public Integer getyear() {
        return year;
    }

    public void setyear() {
    	Calendar cal = Calendar.getInstance();
    	this.year = cal.get(Calendar.YEAR);
    }
    public Integer getmonth() {
        return month;
    }

    public void setmonth() {
    	Calendar cal = Calendar.getInstance();
    	this.month = cal.get(Calendar.MONTH)+1;
    }
    public Integer getday() {
        return year;
    }

    public void setday() {
    	Calendar cal = Calendar.getInstance();
    	this.day = cal.get(Calendar.DAY_OF_MONTH);
    }
    public char getlevel() {
        return level;
    }

    public void setlevel(char level) {
    	this.level = level;
    }
    

    
	//登陆平台
    public void setLogin(Integer login) {
        this.login = login;
    }
	public Integer getLogin() {
		return login;
	}
    
	//并发症记录
	public void setbfzNote(Integer bfzNote) {
	    this.bfzNote = bfzNote;
	}
	public Integer getbfzNote() {
		return bfzNote;
	}
	
    //填写并发症记录的时间
    public Calendar getbfzNoteTime() {
    	return bfzNote_time;
    }
    public void setbfzNoteTime() {
    	this.bfzNote_time = Calendar.getInstance();
    }
    
    //可兑换积分的清零时间
    public void setExchangePointTime() {
        this.ExchangePointTime = Calendar.getInstance();
    }
	public Calendar getExchangePointTime() {
		return ExchangePointTime;
	}
    
	//完成门诊随访
	public Integer getFollowup() {
        return followup;
    }

    public void setFollowup(Integer followup) {
        this.followup = followup;
    }
    //参加扩展活动
    public Integer getExtendedactivity() {
        return extendedactivity;
    }

    public void setExtendedactivity(Integer extendedactivity) {
        this.extendedactivity = extendedactivity;
    }

//监测胰岛功能
    public Integer getydgn() {
        return ydgn;
    }

    public void setydgn(Integer ydgn) {
        this.ydgn = ydgn;
    }
    

}

