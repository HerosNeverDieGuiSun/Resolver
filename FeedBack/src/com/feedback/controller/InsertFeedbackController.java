package com.feedback.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feedback.domain.FeedbackRecord;
import com.feedback.service.FeedbackService;

@Controller
@RequestMapping(value="/StudentCtrl")
public class InsertFeedbackController {
	@Resource
	private FeedbackService fbservice;
	
	@RequestMapping(value="InsertCollegeFeedBack", method=RequestMethod.POST)
    public String add(HttpServletRequest request) {  //@Valid League参数须与Errors紧邻
    	
    	String content=request.getParameter("content");
		System.out.println("the content is" + content);
		try {
			Date date = new Date();       
			Timestamp nousedate = new Timestamp(date.getTime());
			//String strn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nousedate);
			System.out.println("the time is "+ nousedate);
			FeedbackRecord fb=new FeedbackRecord("2016215251","01",nousedate,content,1,1,1,1);
			//Feedback fb=new Feedback(feedback.getSno(),feedback.getCTno(),feedback.getFBtime(),feedback.getContent(),feedback.getAgree());
			fbservice.addFeedback(fb);
		} catch (Exception e) {
			e.printStackTrace();
			
			return "student/StudentInfo";
		}
		
		return "student/StudentInfo";
	}
	
	
	@RequestMapping(value="InsertTeacherFBCtrl", method=RequestMethod.POST)
    public String addtwo(HttpServletRequest request) {  //@Valid League参数须与Errors紧邻
    	
		String cname = request.getParameter("cname");
		String sno = request.getParameter("sno");
		String ctno = request.getParameter("ctno");
    	String tname =request.getParameter("tname");
    	String content =request.getParameter("content");
		System.out.println(sno+"   "+cname+"   "+ctno+"   "+tname+"   "+content);
		try {
			Date date = new Date();       
			Timestamp nousedate = new Timestamp(date.getTime());
			//String strn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nousedate);
			System.out.println("the time is "+ nousedate);
			FeedbackRecord fb=new FeedbackRecord(sno,ctno,nousedate,content,1,1,1,1);
			//Feedback fb=new Feedback(feedback.getSno(),feedback.getCTno(),feedback.getFBtime(),feedback.getContent(),feedback.getAgree());
			fbservice.addFeedback(fb);
		} catch (Exception e) {
			e.printStackTrace();
			
			return "student/StudentInfo";
		}
		
		return "student/StudentInfo";
	}
}
