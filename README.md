# Lavender

积分管理系统

目的：通过开发积分系统或模拟积分系统，了解软件开发项目实践的基本过程，对 git， maven，spring 框架，拦截器，文件读写等知识或技术有一定了解
任务：通过给出的实际需求设计并实现积分系统；可以通过我们给出的思路来实现并模拟积分系统的实现


内容与要求：
1.积分是平台对用户通过本平台使用的行为分析数据，也是兑换奖励的依据。完成制定的操作行为获得相应的积分，社员积分包括“成长积分”和“可兑换积分”。积分规则和限制的基本需求如下：

分类	     行为	            分值	         限制

成长积分   

              b.登陆平台	      1	           每日首次登陆获得

	      b.填写个人资料	    2	           首次填写获得
		
	      b.记录血糖	      1	             填写血糖记录大于 3，积 1 分
		
	      c.填写并发症记录	   3	           并发症记录一般每年填写 1 次，每年只计分 1 次
		
	      c.生成评估报告	    2	            需要先填写好个人资料，血糖记录数填写大于等于 10
		
	      c.监测胰岛功能	    2	            胰岛功能 3 个月只积分 1 次
	      

可兑换积分	


              a.完成门诊随访	    3	            无限制

	      a.参加扩展活动	    5	            无限制
		
	      a.参加科研招募	    8	            无限制

2.扩展需求：
在完成基本需求的基础上，完成以下功能可以获得额外分数： 

① 成长积分：根据成长积分每月进行评级：C：0-10；B：11-25；A：大于 25

② 可兑换积分：兑换积分的有效期为 1 年，满一年将积分清零
