package com.feedback.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feedback.domain.FeedbackRecord;
import com.feedback.service.FeedbackRecordService;
import com.feedback.state.FeedbackRecordQueryState;

@Controller

public class FeedbackRecordController {
	@Resource
	private FeedbackRecordService feedbackSv;
	
	@RequestMapping(value="/student/myfeedbackctrl", method=RequestMethod.GET)
	public String getMyFeedback(Model model, HttpSession session,String page){
		FeedbackRecordQueryState state = null;
		if (page == null) {
			page = "0";
			session.removeAttribute("FeedbackRecordQueryState");
			state = new FeedbackRecordQueryState();
		} else {
			state = (FeedbackRecordQueryState)
					session.getAttribute("FeedbackRecordQueryState");
			if (state == null) {
				state = new FeedbackRecordQueryState();
			}
		}
		
		List<FeedbackRecord> myFeedback = null;
		String sno = "2016215255";
		try {
			int lastPage = feedbackSv.getLastPage(state);
			state.setLastPage(lastPage);
			myFeedback = feedbackSv.getMyFeedback(sno,state,page);
			session.setAttribute("FeedbackRecordQueryState", state);
			model.addAttribute("lastPage", lastPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(myFeedback.get(0).toString());
		//System.out.println("----------------------------------------------------");
		//System.out.println("----------------------------------------------------");
		model.addAttribute("myfeedback", myFeedback);
		return "student/StudentBox";
	}
	
	@RequestMapping(value="/teacher/teacherfeedbackctrl", method=RequestMethod.GET)
	public String getTeacherFeedback(Model model, HttpSession session,String page){
		FeedbackRecordQueryState state = null;
		if (page == null) {
			page = "0";
			session.removeAttribute("FeedbackRecordQueryState");
			state = new FeedbackRecordQueryState();
		} else {
			state = (FeedbackRecordQueryState)
					session.getAttribute("FeedbackRecordQueryState");
			if (state == null) {
				state = new FeedbackRecordQueryState();
			}
		}
		
		List<FeedbackRecord> teacherFeedback = null;
		String tNo = "2016215254";
		try {
			int lastPage = feedbackSv.getLastPage(state);
			state.setLastPage(lastPage);
			teacherFeedback = feedbackSv.getTeacherFeedback(tNo, state, page);
			session.setAttribute("FeedbackRecordQueryState", state);
			model.addAttribute("lastPage", lastPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("----------------------------------------------------");
		model.addAttribute("teacherFeedback", teacherFeedback);
		return "teacher/TeacherBox";
	}
	
	@RequestMapping(value="leader/leaderfeedbackctrl", method=RequestMethod.GET)
	public String getLeaderFeedback(Model model, HttpSession session,String page){
		
		FeedbackRecordQueryState state = null;
		if (page == null) {
			page = "0";
			session.removeAttribute("FeedbackRecordQueryState");
			state = new FeedbackRecordQueryState();
		} else {
			state = (FeedbackRecordQueryState)
					session.getAttribute("FeedbackRecordQueryState");
			if (state == null) {
				state = new FeedbackRecordQueryState();
			}
		}
		
		List<FeedbackRecord> leaderFeedback = null;
		try {
			int lastPage = feedbackSv.getLastPage(state);
			state.setLastPage(lastPage);
			leaderFeedback = feedbackSv.getLeaderFeedback(state, page);
			session.setAttribute("FeedbackRecordQueryState", state);
			model.addAttribute("lastPage", lastPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("leaderFeedback", leaderFeedback);
		return "leader/BossBox";
	}
	
	@RequestMapping(value="/admin/allfeedbackctrl", method=RequestMethod.GET)
	public String getAllFeedback(Model model, HttpSession session,String page){
		FeedbackRecordQueryState state = null;
		if (page == null) {
			page = "0";
			session.removeAttribute("FeedbackRecordQueryState");
			state = new FeedbackRecordQueryState();
		} else {
			state = (FeedbackRecordQueryState)
					session.getAttribute("FeedbackRecordQueryState");
			if (state == null) {
				state = new FeedbackRecordQueryState();
			}
		}
		
		List<FeedbackRecord> allFeedback = null;
		try {
			int lastPage = feedbackSv.getLastPage(state);
			state.setLastPage(lastPage);
			allFeedback = feedbackSv.getAllFeedback(state,page);
			session.setAttribute("FeedbackRecordQueryState", state);
			model.addAttribute("lastPage", lastPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("allFeedback", allFeedback);
		return "admin/AdminBox";
	}
	
	@RequestMapping(value="/admin/ViewContentCtrl", method=RequestMethod.POST)
	public String viewFeedbackContent(Model model, HttpSession session,String sno,String ctno,Timestamp fbtime,String content,int statusadm,int statusleader,int statusteacher,int agree) {
		List<FeedbackRecord> concreteFeedbackList = new ArrayList<FeedbackRecord>();
		FeedbackRecord concreteFeedback = new FeedbackRecord( sno, ctno, fbtime, content, statusadm, statusleader, statusteacher, agree);
		concreteFeedbackList.add(concreteFeedback);
		session.setAttribute("concreteFeedback", concreteFeedbackList);
		model.addAttribute("concreteFeedback", concreteFeedbackList);
		return "admin/AdminView";
	}
	
	@RequestMapping(value="/student/ViewContentCtrl", method=RequestMethod.POST)
	public String viewMyFeedbackContent(Model model, HttpSession session,String sno,String ctno,Timestamp fbtime,String content,int statusadm,int statusleader,int statusteacher,int agree) {
		List<FeedbackRecord> concreteFeedbackList = new ArrayList<FeedbackRecord>();
		FeedbackRecord concreteFeedback = new FeedbackRecord( sno, ctno, fbtime, content, statusadm, statusleader, statusteacher, agree);
		concreteFeedbackList.add(concreteFeedback);
		session.setAttribute("concreteFeedback", concreteFeedbackList);
		model.addAttribute("concreteFeedback", concreteFeedbackList);
		return "student/StudentView";
	}
	
	@RequestMapping(value="/leader/ViewContentCtrl", method=RequestMethod.POST)
	public String viewLeaderFeedbackContent(Model model, HttpSession session,String sno,String ctno,Timestamp fbtime,String content,int statusadm,int statusleader,int statusteacher,int agree) {
		List<FeedbackRecord> concreteFeedbackList = new ArrayList<FeedbackRecord>();
		FeedbackRecord concreteFeedback = new FeedbackRecord( sno, ctno, fbtime, content, statusadm, statusleader, statusteacher, agree);
		concreteFeedbackList.add(concreteFeedback);
		session.setAttribute("concreteFeedback", concreteFeedbackList);
		model.addAttribute("concreteFeedback", concreteFeedbackList);
		return "leader/BossView";
	}
	
	@RequestMapping(value="/teacher/ViewContentCtrl", method=RequestMethod.POST)
	public String viewTeacherFeedbackContent(Model model, HttpSession session,String sno,String ctno,Timestamp fbtime,String content,int statusadm,int statusleader,int statusteacher,int agree) {
		List<FeedbackRecord> concreteFeedbackList = new ArrayList<FeedbackRecord>();
		FeedbackRecord concreteFeedback = new FeedbackRecord( sno, ctno, fbtime, content, statusadm, statusleader, statusteacher, agree);
		concreteFeedbackList.add(concreteFeedback);
		session.setAttribute("concreteFeedback", concreteFeedbackList);
		model.addAttribute("concreteFeedback", concreteFeedbackList);
		return "teacher/TeacherView";
	}
}
