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

import com.feedback.domain.Administrators;
import com.feedback.service.AdmManageService;
import com.feedback.state.ManageAdmQueryState;

@Controller

public class AdmManageController {
	@Resource
	private AdmManageService admManageService;
	@RequestMapping(value="/AdmManageController/deleteAdm",method=RequestMethod.GET)
	public String deleteAdm(String admno,String page){
		System.out.println("enter deleteAdm page " + page);
		admManageService.deleteAdmByAdmno(admno);
		String redirectURL = "redirect:/AdmManageController/listAllAdmByPage?page="+page;
		System.out.println(redirectURL);
		return redirectURL;
	}
	
	
	@RequestMapping(value="/AdmManageController/updateAdmInfo",method=RequestMethod.POST)
	public String updateAdmInfo(Model model, HttpSession session,HttpServletRequest request,String page){
		Map<String,String> map = new HashMap<String,String>();
		map.put("admno", (String) request.getParameter("admNumber"));
		map.put("admpsw",(String) request.getParameter("admPassword"));
		System.out.println( (String) request.getParameter("admNumber")+"l");
		System.out.println( (String) request.getParameter("admPassword"+"l"));
		admManageService.updateAdm(map);
		String redirectURL = "redirect:/AdmManageController/listAllAdmByPage?page="+page;
		return redirectURL;
	}
	
	
	@RequestMapping(value="/AdmManageController/listAllAdmByPage",method=RequestMethod.GET)
	public String listAllAdmByPage(Model model, HttpSession session,HttpServletRequest request,String page){		
		
		ManageAdmQueryState state = null;
		
		if (page == null) {
			page = "0";
			session.removeAttribute("manageStudentQueryState");
			state = new ManageAdmQueryState();
		} else {
			state = (ManageAdmQueryState)session.getAttribute("manageAdmQueryState");
			if (state == null) {
				state = new ManageAdmQueryState();
			}
		}
		
		List<Administrators> admList = null;
		try {
			
			String classQuery = request.getParameter("classQuery");
			if(classQuery!=null&&!classQuery.equals("")){
				String [] stringArr = classQuery.split(":|：");
				if(stringArr[0].equals("登录名"))
					state.setAdmno(stringArr[1].trim());
				else if(stringArr[0].equals("密码"))
					state.setAdmpsw(stringArr[1].trim());
				else{}
			}
			
			int lastPage = admManageService.getManageAdmLastPage(state);

			//System.out.println("listAll 中的 lastPage 为"+lastPage);
			state.setLastPage(lastPage);
			admList = admManageService.getAdmByPage(state, page);
			System.out.println(page);
			session.setAttribute("manageAdmQueryState", state);
			model.addAttribute("lastPage", lastPage);
		} catch (Exception e) {
			e.printStackTrace();
			//list = new ArrayList<Ticket>();
			//Map<String, String> errMap = new HashMap<String, String>();
			//errMap.put("GLOBAL", "发生非预期错误，请联系管理员");
			//model.addAttribute("errMap", errMap);
		}
		
		model.addAttribute("admList",admList); 
		return "superAdm/ManageAdm";
	}
	

}

