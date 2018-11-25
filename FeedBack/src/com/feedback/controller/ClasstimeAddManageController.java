package com.feedback.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feedback.domain.*;
import com.feedback.service.ClasstimeAddManageService;
import com.feedback.state.ManageStudentQueryState;
import com.feedback.state.PageQueryState;

@Controller
public class ClasstimeAddManageController {
	@Resource
	private ClasstimeAddManageService classtimeAddManageService;
	
	@RequestMapping(value="/ClasstimeAddManageController/deleteClasstimeAdd",method=RequestMethod.GET)
	public String deleteClasstimeAdd(String ctno,String add,String startweek,String endweek,String day,String page){
		System.out.println("enter deleteStudent page " + page);
		Map<String,Object> map = new HashMap<String,Object>();
		//修改
		map.put("ctno",ctno);
		map.put("add",add);
		map.put("startweek",Integer.valueOf(startweek).intValue());
		map.put("endweek",Integer.valueOf(endweek).intValue());
		map.put("day",Integer.valueOf(day).intValue());
		classtimeAddManageService.deleteClasstimeAdd(map);
		String redirectURL = "redirect:/ClasstimeAddManageController/listAllClasstimeAddByPage?page="+page;
		System.out.println(redirectURL);
		return redirectURL;
	}

	@RequestMapping(value="/ClasstimeAddManageController/updateClasstimeAdd",method=RequestMethod.POST)
	public String updateClasstimeAddInfo(Model model, HttpSession session,HttpServletRequest request,String page){
		Map<String,Object> map = new HashMap<String,Object>();
		//
		map.put("ctno", (String) request.getParameter("ctno"));
		map.put("add", (String)request.getParameter("add"));
		map.put("startweek",Integer.valueOf(request.getParameter("startweek")).intValue());
		map.put("endweek",Integer.valueOf(request.getParameter("endweek")).intValue());
		map.put("day", Integer.valueOf(request.getParameter("day")).intValue());
		map.put("startsection",Integer.valueOf(request.getParameter("startsection")).intValue());
		map.put("endsection",Integer.valueOf(request.getParameter("endsection")).intValue());
		
		classtimeAddManageService.updateClasstimeAdd(map);
		String redirectURL = "redirect:/ClasstimeAddManageController/listAllClasstimeAddByPage?page="+page;
		return redirectURL;
	}
	
	
	@RequestMapping(value="/ClasstimeAddManageController/listAllClasstimeAddByPage",method=RequestMethod.GET)
	public String listAllStudentByPage(Model model, HttpSession session,HttpServletRequest request,String page){		
		
		PageQueryState state = null;
		
		if (page == null) {
			page = "0";
			session.removeAttribute("manageClasstimeAddQueryState");
			state = new PageQueryState();
		} else {
			state = (PageQueryState)session.getAttribute("manageClasstimeAddQueryState");
			if (state == null) {
				state = new PageQueryState();
			}
		}
		
		List<ClasstimeAdd> classtimeAddList = null;
		try {
			
			
			
			int lastPage = classtimeAddManageService.getManageClasstimeAddLastPage(state);

			//System.out.println("listAll 中的 lastPage 为"+lastPage);
			state.setLastPage(lastPage);
			System.out.println("+++"+page+"00"+state);
			classtimeAddList = classtimeAddManageService.getClasstimeAddByPage(state, page);
			System.out.println(page);
			session.setAttribute("QueryState", state);
			model.addAttribute("lastPage", lastPage);
		} catch (Exception e) {
			e.printStackTrace();
			//list = new ArrayList<Ticket>();
			//Map<String, String> errMap = new HashMap<String, String>();
			//errMap.put("GLOBAL", "发生非预期错误，请联系管理员");
			//model.addAttribute("errMap", errMap);
		}
		
		model.addAttribute("classtimeAddList",classtimeAddList); 
		return "admin/ManageClasstimeAdd";
	}
	

}