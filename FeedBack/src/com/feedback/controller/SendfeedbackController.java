package com.feedback.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feedback.exception.SendfeedbackException;
import com.feedback.service.*;
import com.feedback.domain.*;

@Controller
public class SendfeedbackController {
	@Resource
	private SendfeedbackService sendfeedbackService;
	
	@RequestMapping(value="/admin/SendTeacherCtrl",method=RequestMethod.GET)
	private String sendtoTeacher(Model model, HttpSession session/*,String Sno,String CTno,Timestamp FBtime*/) {
		
		Map<String, String> errMap = new HashMap<String, String>();
		
		List<FeedbackRecord> feedbacklist=(List<FeedbackRecord>)session.getAttribute("concreteFeedback");
		FeedbackRecord feedback=feedbacklist.get(0);
		try {
			sendfeedbackService.sendtoTeacher(feedback.getSno(), feedback.getCtno(),feedback.getFbtime());
		} catch (SendfeedbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "redirect:allfeedbackctrl";
	}
	
	@RequestMapping(value="/admin/SendLeaderCtrl", method=RequestMethod.GET)
	private String sendtoLeader(Model model, HttpSession session/*,String Sno,String CTno,Timestamp FBtime*/) {
		
		Map<String, String> errMap = new HashMap<String, String>();
		
		
			List<FeedbackRecord> feedbacklist=(List<FeedbackRecord>)session.getAttribute("concreteFeedback");
			FeedbackRecord feedback=feedbacklist.get(0);
			try {
				sendfeedbackService.sendtoLeader(feedback.getSno(), feedback.getCtno(),feedback.getFbtime());
			} catch (SendfeedbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    	
		return "redirect:allfeedbackctrl";
	}
	
	@RequestMapping(value="/admin/AgreeCtrl", method=RequestMethod.GET)
	private String agree(Model model, HttpSession session/*,String Sno,String CTno,Timestamp FBtime*/) {
		
		Map<String, String> errMap = new HashMap<String, String>();
		
		List<FeedbackRecord> feedbacklist=(List<FeedbackRecord>)session.getAttribute("concreteFeedback");
		FeedbackRecord feedback=feedbacklist.get(0);
		try {
			sendfeedbackService.agree(feedback.getSno(), feedback.getCtno(),feedback.getFbtime());
		} catch (SendfeedbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "redirect:allfeedbackctrl";
	}
	
	@RequestMapping(value="/admin/DisagreeCtrl", method=RequestMethod.GET)
	private String disagree(Model model, HttpSession session/*,String Sno,String CTno,Timestamp FBtime*/) {
		
		Map<String, String> errMap = new HashMap<String, String>();
		
		List<FeedbackRecord> feedbacklist=(List<FeedbackRecord>)session.getAttribute("concreteFeedback");
		FeedbackRecord feedback=feedbacklist.get(0);
		try {
			sendfeedbackService.disagree(feedback.getSno(), feedback.getCtno(),feedback.getFbtime());
		} catch (SendfeedbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "redirect:allfeedbackctrl";
	}
	
	
	@RequestMapping(value="/leader/LeaderSendTeacherCtrl",method=RequestMethod.GET)
	private String leaderSendtoTeacher(Model model, HttpSession session/*,String Sno,String CTno,Timestamp FBtime*/) {
		
		Map<String, String> errMap = new HashMap<String, String>();
		
		List<FeedbackRecord> feedbacklist=(List<FeedbackRecord>)session.getAttribute("concreteFeedback");
		FeedbackRecord feedback=feedbacklist.get(0);
		try {
			sendfeedbackService.leaderSendtoTeacher(feedback.getSno(), feedback.getCtno(),feedback.getFbtime());
		} catch (SendfeedbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "redirect:allfeedbackctrl";
	}
	
	@RequestMapping(value="/leader/LeaderAgreeCtrl", method=RequestMethod.GET)
	private String leaderAgree(Model model, HttpSession session/*,String Sno,String CTno,Timestamp FBtime*/) {
		
		Map<String, String> errMap = new HashMap<String, String>();
		
		List<FeedbackRecord> feedbacklist=(List<FeedbackRecord>)session.getAttribute("concreteFeedback");
		FeedbackRecord feedback=feedbacklist.get(0);
		try {
			sendfeedbackService.leaderAgree(feedback.getSno(), feedback.getCtno(),feedback.getFbtime());
		} catch (SendfeedbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "redirect:allfeedbackctrl";
	}
	
	@RequestMapping(value="/leader/LeaderDisagreeCtrl", method=RequestMethod.GET)
	private String leaderDisagree(Model model, HttpSession session/*,String Sno,String CTno,Timestamp FBtime*/) {
		
		Map<String, String> errMap = new HashMap<String, String>();
		
		List<FeedbackRecord> feedbacklist=(List<FeedbackRecord>)session.getAttribute("concreteFeedback");
		FeedbackRecord feedback=feedbacklist.get(0);
		try {
			sendfeedbackService.leaderDisagree(feedback.getSno(), feedback.getCtno(),feedback.getFbtime());
		} catch (SendfeedbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "redirect:allfeedbackctrl";
	}
	
	@RequestMapping(value="/teacher/TeacherAgreeCtrl", method=RequestMethod.GET)
	private String teacherAgree(Model model, HttpSession session/*,String Sno,String CTno,Timestamp FBtime*/) {
		
		Map<String, String> errMap = new HashMap<String, String>();
		
		List<FeedbackRecord> feedbacklist=(List<FeedbackRecord>)session.getAttribute("concreteFeedback");
		FeedbackRecord feedback=feedbacklist.get(0);
		try {
			sendfeedbackService.teacherAgree(feedback.getSno(), feedback.getCtno(),feedback.getFbtime());
		} catch (SendfeedbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "redirect:allfeedbackctrl";
	}
	
	@RequestMapping(value="/teacher/TeacherDisagreeCtrl", method=RequestMethod.GET)
	private String teacherDisagree(Model model, HttpSession session/*,String Sno,String CTno,Timestamp FBtime*/) {
		
		Map<String, String> errMap = new HashMap<String, String>();
		
		List<FeedbackRecord> feedbacklist=(List<FeedbackRecord>)session.getAttribute("concreteFeedback");
		FeedbackRecord feedback=feedbacklist.get(0);
		try {
			sendfeedbackService.teacherDisagree(feedback.getSno(), feedback.getCtno(),feedback.getFbtime());
		} catch (SendfeedbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "redirect:allfeedbackctrl";
	}
}
