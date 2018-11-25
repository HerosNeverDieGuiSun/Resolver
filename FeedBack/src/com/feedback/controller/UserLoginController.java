package com.feedback.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.hadoop.hive.ql.parse.HiveParser_IdentifiersParser.nullCondition_return;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feedback.domain.Leader;
import com.feedback.domain.Student;
import com.feedback.domain.SuperAdm;
import com.feedback.domain.TeacherIn;
import com.feedback.domain.TeacherOut;
import com.feedback.domain.TeacherSchool;
import com.feedback.service.LoginService;

@Controller
public class UserLoginController {
	@Resource
	private LoginService loginService;
	
	@RequestMapping(value="/LoginServlet", method=RequestMethod.POST)
	public String UserLogin(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("usern");
		String userpsw = request.getParameter("userp");
		
		Student student = loginService.checkStudent(username, userpsw);
		TeacherIn teacherIn = loginService.checkTeacherIn(username, userpsw);
		TeacherOut teacherOut = loginService.checkTeacherOut(username, userpsw);
		TeacherSchool teacherSchool = loginService.checkTeacherSchool(username, userpsw);
		Leader leader = loginService.checkLeader(username, userpsw);
		SuperAdm superAdm = loginService.checkSuperAdm(username, userpsw);
		
		
		if (student != null) {
			session.setAttribute("student", student);
			return "student/StudentInfo";
		} else if (teacherIn != null) {
			session.setAttribute("user", teacherIn);
			return "teacher/TeacherView";
		} else if (teacherOut != null) {
			session.setAttribute("user", teacherOut);
			return "teacher/TeacherView";
		} else if (teacherSchool != null) {
			session.setAttribute("user", teacherSchool);
			return "teacher/TeacherView";
		} else if (leader != null) {
			session.setAttribute("user", leader);
			return "leader/BossView";
		} else if (superAdm != null) {
			session.setAttribute("user", superAdm);
			return "redirect:/GetTeacherInServlet";
		}
		
		request.setAttribute("usererror", "用户名或密码错误");
		return "Login";
	}
}
