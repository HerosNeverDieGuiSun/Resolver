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

import com.feedback.domain.Student;
import com.feedback.service.StudentManageService;
import com.feedback.state.ManageStudentQueryState;

@Controller
public class StudentManageController {
	@Resource
	private StudentManageService studentManageService;
	
	@RequestMapping(value="/StudentManageController/deleteStudent",method=RequestMethod.GET)
	public String deleteStudent(String sno,String page){
		System.out.println("enter deleteStudent page " + page);
		studentManageService.deleteStudentBySno(sno);
		String redirectURL = "redirect:/StudentManageController/listAllStudentByPage?page="+page;
		System.out.println(redirectURL);
		return redirectURL;
	}
	
	@RequestMapping(value="/StudentManageController/exchangeStudentStatus",method=RequestMethod.GET)
	public String exchangeStudentStatus(String sno,String newStatus,String page){
		System.out.println("enter exchageStudentStatus " + newStatus);
		studentManageService.exchangeStudentStatus(sno,Integer.parseInt(newStatus));
		String redirectURL = "redirect:/StudentManageController/listAllStudentByPage?page="+page;
		System.out.println(redirectURL);
		return redirectURL;
	}
	
	
	@RequestMapping(value="/StudentManageController/updateStudentInfo",method=RequestMethod.POST)
	public String updateStudentInfo(Model model, HttpSession session,HttpServletRequest request,String page){
		Map<String,String> map = new HashMap<String,String>();
		map.put("sno", (String) request.getParameter("studentNumber"));
		map.put("sname", (String)request.getParameter("studentName"));
		map.put("spsw",(String) request.getParameter("studentPassword"));
		map.put("cnname",(String)request.getParameter("studentClass"));
		
		studentManageService.updateStudent(map);
		String redirectURL = "redirect:/StudentManageController/listAllStudentByPage?page="+page;
		return redirectURL;
	}
	
	
	@RequestMapping(value="/StudentManageController/listAllStudentByPage",method=RequestMethod.GET)
	public String listAllStudentByPage(Model model, HttpSession session,HttpServletRequest request,String page){		
		
		ManageStudentQueryState state = null;
		
		if (page == null) {
			page = "0";
			session.removeAttribute("manageStudentQueryState");
			state = new ManageStudentQueryState();
		} else {
			state = (ManageStudentQueryState)session.getAttribute("manageStudentQueryState");
			if (state == null) {
				state = new ManageStudentQueryState();
			}
		}
		
		List<Student> studentList = null;
		try {
			
			String classQuery = request.getParameter("classQuery");
			if(classQuery!=null&&!classQuery.equals("")){
				String [] stringArr = classQuery.split(":|：");
				if(stringArr[0].equals("姓名"))
					state.setSname(stringArr[1].trim());
				else if(stringArr[0].equals("专业班级"))
					state.setCnname(stringArr[1].trim());
				else if(stringArr[0].equals("学号"))
					state.setSno(stringArr[1].trim());
				else{}
			}
			
			int lastPage = studentManageService.getManageStudentLastPage(state);

			//System.out.println("listAll 中的 lastPage 为"+lastPage);
			state.setLastPage(lastPage);
			studentList = studentManageService.getStudentByPage(state, page);
			System.out.println(page);
			session.setAttribute("manageStudentQueryState", state);
			model.addAttribute("lastPage", lastPage);
		} catch (Exception e) {
			e.printStackTrace();
			//list = new ArrayList<Ticket>();
			//Map<String, String> errMap = new HashMap<String, String>();
			//errMap.put("GLOBAL", "发生非预期错误，请联系管理员");
			//model.addAttribute("errMap", errMap);
		}
		
		model.addAttribute("studentList",studentList); 
		return "superAdm/ManageStudent";
	}
	

}
