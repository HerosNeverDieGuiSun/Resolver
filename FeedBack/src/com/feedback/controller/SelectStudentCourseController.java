package com.feedback.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feedback.domain.StudentCourse;
import com.feedback.exception.StudentCourseException;
import com.feedback.service.StudentCourseService;
import com.feedback.state.StudentCourseQueryState;

@Controller
@RequestMapping(value="/StudentCtrl")
public class SelectStudentCourseController {
	@Resource
	private StudentCourseService scservice;
	
	@RequestMapping(value="SelectStudentCourseCtrl",method=RequestMethod.GET)
	public String select(Model model, HttpSession session,String page) throws Exception {
		//Student stu = (Student)session.getAttribute("Student");
		StudentCourseQueryState state = null;
		if (page == null) {
			page = "0";
			session.removeAttribute("StudentCourseQueryState");
			state = new StudentCourseQueryState();
		} else {
			state = (StudentCourseQueryState)
					session.getAttribute("StudentCourseQueryState");
			if (state == null) {
				state = new StudentCourseQueryState();
			}
		}
		List<StudentCourse> list = null;
		try {
			int lastPage = scservice.getLastPage(state);
			state.setLastPage(lastPage);
			list = scservice.selectStudentCourse("2016215251",state,page);
			session.setAttribute("StudentCourseQueryState", state);
			model.addAttribute("lastPage", lastPage);
			for(StudentCourse sc : list) {
				System.out.println(sc.toString());
			}
		} catch (StudentCourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("listsc", list);
		return "student/ShowStudentCourse";
	}
	
	@RequestMapping(value="ViewContentCtrl",method=RequestMethod.POST)
	public String show(Model model,String sno,String cname,String ctno,String tname) {
		StudentCourse studentcourse  = new StudentCourse(sno,cname,ctno,tname);
		List<StudentCourse> list = new ArrayList<StudentCourse>();
		list.add(studentcourse);
		model.addAttribute("studentcourse", list);
		//System.out.println(studentcourse.toString()+"        04");
		return "student/SendTeacherMsg";
	}
}
