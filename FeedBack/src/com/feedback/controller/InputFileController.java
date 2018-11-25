package com.feedback.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.feedback.domain.TeacherIn;
import com.feedback.domain.TeacherOut;
import com.feedback.domain.TeacherSchool;
import com.feedback.service.*;
import com.feedback.state.TeacherQueryState;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class InputFileController {
	@Resource
	private InputFileService inputFileService;
	
	@RequestMapping(value="/superAdm/TeacherInfoInputServlet", method=RequestMethod.POST)
	public String TeacherInfoInput(MultipartFile file, Model model, HttpServletRequest request) {
		String UPLOAD_PATH = "uploadFiles/";
		if (file == null) return "redirect:/GetTeacherInServlet";
		if (file.getOriginalFilename().equals("")) return "redirect:/GetTeacherInServlet";
		
		//设置上传文件的保存目录
		String path = request.getServletContext().getRealPath(".");
		path += "/" + UPLOAD_PATH;
		File newfile = new File(path);
		if (!newfile.exists()) {
			newfile.mkdirs();
		}
		
		// 修改文件名
		String filename = file.getOriginalFilename();
		String newname = System.currentTimeMillis() + "-" + filename;
		
		try {
			//保存到path下的名字为newname的文件
			file.transferTo(new File(path, newname));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		inputFileService.inputTeacherInfo(file, path + newname);
		
		return "redirect:/GetTeacherInServlet";
	}
	

	@RequestMapping(value="/superAdm/AdmInfoInputServlet", method=RequestMethod.POST)
	public String AdmInfoInput(MultipartFile file, Model model, HttpServletRequest request) {
		String UPLOAD_PATH = "uploadFiles/";
		if (file == null) return "redirect:/GetAdmInServlet";
		if (file.getOriginalFilename().equals("")) return "redirect:/GetAdmInServlet";
	
		//设置上传文件的保存目录
		String path = request.getServletContext().getRealPath(".");
		path += "/" + UPLOAD_PATH;
		File newfile = new File(path);
		if (!newfile.exists()) {
			newfile.mkdirs();
		}
		
		// 修改文件名
		String filename = file.getOriginalFilename();
		String newname = System.currentTimeMillis() + "-" + filename;
		
		try {
			//保存到path下的名字为newname的文件
			file.transferTo(new File(path, newname));
			
		} catch (Exception e) {
			e.printStackTrace();
		}


		inputFileService.inputAdmInfo(file, path + newname);
		
		return "redirect:../AdmManageController/listAllAdmByPage";

		

	}
@RequestMapping(value="/admin/ClasstimeAddInfoInputServlet", method=RequestMethod.POST)
public String ClasstimeAddInfoInput(MultipartFile file, Model model, HttpServletRequest request) {
	String UPLOAD_PATH = "uploadFiles/";
	if (file == null) return "redirect:/ClasstimeAddManageController/listAllClasstimeAddByPage";
	if (file.getOriginalFilename().equals("")) return "redirect:/ClasstimeAddManageController/listAllClasstimeAddByPage";
		//设置上传文件的保存目录
			String path = request.getServletContext().getRealPath(".");
			path += "/" + UPLOAD_PATH;
			File newfile = new File(path);
			if (!newfile.exists()) {
				newfile.mkdirs();
			}
			
			// 修改文件名
			String filename = file.getOriginalFilename();
			String newname = System.currentTimeMillis() + "-" + filename;
			
			try {
				//保存到path下的名字为newname的文件
				file.transferTo(new File(path, newname));
				
			} catch (Exception e) {
				e.printStackTrace();
			}

	inputFileService.inputClasstimeAddInfo(file, path + newname);
	
	return "redirect:/ClasstimeAddManageController/listAllClasstimeAddByPage";
}
	
	@RequestMapping(value="/StudentInfoInputServlet")
	public String StudentInfoInput(MultipartFile file, Model model, HttpServletRequest request) {
		String UPLOAD_PATH = "uploadFiles/";
		if (file == null) return "";
		if (file.getOriginalFilename().equals("")) return "";
		
		//设置上传文件的保存目录
		String path = request.getServletContext().getRealPath(".");
		path += "/" + UPLOAD_PATH;
		File newfile = new File(path);
		if (!newfile.exists()) {
			newfile.mkdirs();
		}
		
		// 修改文件名
		String filename = file.getOriginalFilename();
		String newname = System.currentTimeMillis() + "-" + filename;
		
		try {
			//保存到path下的名字为newname的文件
			file.transferTo(new File(path, newname));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		inputFileService.inputStudentInfo(file, path + newname);
		return "redirect:/GetTeacherInServlet";
	}
	

	@RequestMapping(value="/teacher/GetTeacherOutServlet")
	public String getTeacherOut(Model model,HttpSession session) {
		
		TeacherOut t = new TeacherOut("2016215001","1","徐本柱","2","院内","555","5","56"
				,"5565","665","555","2016215201","555","222");
		model.addAttribute("teacherout", t);
		session.setAttribute("teacherout", t);
		return "teacher/TeacherOutInfo";
	}

	@RequestMapping(value="/superAdm/LeaderInfoInputServlet", method=RequestMethod.POST)
	public String LeaderInfoInput(MultipartFile file, Model model, HttpServletRequest request) {
		String UPLOAD_PATH = "uploadFiles/";
		if (file == null) return "redirect:/GetTeacherInServlet";
		if (file.getOriginalFilename().equals("")) return "redirect:/GetTeacherInServlet";
		
		//设置上传文件的保存目录
		String path = request.getServletContext().getRealPath(".");
		path += "/" + UPLOAD_PATH;
		File newfile = new File(path);
		if (!newfile.exists()) {
			newfile.mkdirs();
		}
		
		// 修改文件名
		String filename = file.getOriginalFilename();
		String newname = System.currentTimeMillis() + "-" + filename;
		
		try {
			//保存到path下的名字为newname的文件
			file.transferTo(new File(path, newname));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("in");
		inputFileService.inputLeaderInfo(file, path + newname);
		
		return "redirect://LeaderCtrl/ListLeader";
	}
	

	@RequestMapping(value="/GetTeacherInServlet")
	public String getAllTeacher(Model model, HttpSession session) {
		session.removeAttribute("TeacherInState");
		session.removeAttribute("TeacherOutState");
		session.removeAttribute("TeacherSchoolState");
		
		TeacherQueryState teacherInState = new TeacherQueryState(0);
		TeacherQueryState teacherOutState = new TeacherQueryState(0);
		TeacherQueryState teacherSchoolState = new TeacherQueryState(0);
		
		int tiLastPage = inputFileService.getTILastPage(teacherInState);
		int toLastPage = inputFileService.getTOLastPage(teacherOutState);
		int tsLastPage = inputFileService.getTSLastPage(teacherSchoolState);
		
		teacherInState.setLastPage(tiLastPage);
		teacherOutState.setLastPage(toLastPage);
		teacherSchoolState.setLastPage(tsLastPage);
		
		System.out.println(tiLastPage + " " + toLastPage + " " + tsLastPage);
		
		List<TeacherIn> teacherInList = inputFileService.getTeacherIn(teacherInState);
		List<TeacherOut> teacherOutList = inputFileService.getTeacherOut(teacherOutState);
		List<TeacherSchool> teacherSchoolList = inputFileService.getTeacherSchool(teacherSchoolState);
		
		session.setAttribute("TeacherInState", teacherInState);
		model.addAttribute("lastpageTI", tiLastPage);
		session.setAttribute("TeacherOutState", teacherOutState);
		model.addAttribute("lastpageTO", toLastPage);
		session.setAttribute("TeacherSchoolState", teacherSchoolState);
		model.addAttribute("lastpageTS", tsLastPage);
		
		model.addAttribute("curPageTI", teacherInState.getCurPage());
		model.addAttribute("curPageTO", teacherOutState.getCurPage());
		model.addAttribute("curPageTS", teacherSchoolState.getCurPage());
		
		model.addAttribute("teacherInList", teacherInList);
		model.addAttribute("teacherOutList", teacherOutList);
		model.addAttribute("teacherSchoolList", teacherSchoolList);
		return "superAdm/ManangeTeacher";
	}
	
	@RequestMapping(value="/DoPageTIServlet", method=RequestMethod.GET)
	public String doPageTI(Model model, HttpSession session, String page) {
		TeacherQueryState tiState = null;
		
		if (page == null) {
			page = "0";
			session.removeAttribute("TeacherInState");
			tiState = new TeacherQueryState();
		} else {
			tiState = (TeacherQueryState) session.getAttribute("TeacherInState");
			if (tiState == null) {
				tiState = new TeacherQueryState();
			}
		}
		
		List<TeacherIn> tiList = null;
		int lastpage = inputFileService.getTILastPage(tiState);
		tiState.setLastPage(lastpage);
		tiList = inputFileService.getTeacherInByPage(tiState, page);
		
		TeacherQueryState teacherOutState = (TeacherQueryState) session.getAttribute("TeacherOutState");
		TeacherQueryState teacherSchoolState = (TeacherQueryState) session.getAttribute("TeacherSchoolState");
		
		int toLastPage = inputFileService.getTOLastPage(teacherOutState);
		int tsLastPage = inputFileService.getTSLastPage(teacherSchoolState);
		
		teacherOutState.setLastPage(toLastPage);
		teacherSchoolState.setLastPage(tsLastPage);
		
		List<TeacherOut> teacherOutList = inputFileService.getTeacherOut(teacherOutState);
		List<TeacherSchool> teacherSchoolList = inputFileService.getTeacherSchool(teacherSchoolState);
		
		session.setAttribute("TeacherInState", tiState);
		model.addAttribute("lastpageTI", lastpage);
		
		model.addAttribute("curPageTI", tiState.getCurPage());
		model.addAttribute("curPageTO", teacherOutState.getCurPage());
		model.addAttribute("curPageTS", teacherSchoolState.getCurPage());
		
		model.addAttribute("lastpageTO", teacherOutState.getLastPage());
		model.addAttribute("lastpageTS", teacherSchoolState.getLastPage());
		
		model.addAttribute("teacherInList", tiList);
		model.addAttribute("teacherOutList", teacherOutList);
		model.addAttribute("teacherSchoolList", teacherSchoolList);
		
		session.setAttribute("TeacherOutState", teacherOutState);
		session.setAttribute("TeacherSchoolState", teacherSchoolState);
		return "superAdm/ManangeTeacher";
	}
	
	@RequestMapping(value="/DoPageTSServlet", method=RequestMethod.GET)
	public String doPageTS(Model model, HttpSession session, String page) {
		TeacherQueryState tsState = null;
		
		if (page == null) {
			page = "0";
			session.removeAttribute("TeacherSchoolState");
			tsState = new TeacherQueryState();
		} else {
			tsState = (TeacherQueryState) session.getAttribute("TeacherSchoolState");
			if (tsState == null) {
				tsState = new TeacherQueryState();
			}
		}
		
		List<TeacherSchool> tsList = null;
		int lastpage = inputFileService.getTSLastPage(tsState);
		tsState.setLastPage(lastpage);
		tsList = inputFileService.getTeacherSchoolByPage(tsState, page);
		
		TeacherQueryState teacherOutState = (TeacherQueryState) session.getAttribute("TeacherOutState");
		TeacherQueryState teacherInState = (TeacherQueryState) session.getAttribute("TeacherInState");
		
		int toLastPage = inputFileService.getTOLastPage(teacherOutState);
		int tiLastPage = inputFileService.getTILastPage(teacherInState);
		
		teacherOutState.setLastPage(toLastPage);
		teacherInState.setLastPage(tiLastPage);
		
		List<TeacherOut> teacherOutList = inputFileService.getTeacherOut(teacherOutState);
		List<TeacherIn> teacherInList = inputFileService.getTeacherIn(teacherInState);
		
		session.setAttribute("TeacherSchoolState", tsState);
		model.addAttribute("lastpageTS", lastpage);
		
		model.addAttribute("teacherSchoolList", tsList);
		model.addAttribute("teacherOutList", teacherOutList);
		model.addAttribute("teacherInList", teacherInList);
		
		model.addAttribute("curPageTI", teacherInState.getCurPage());
		model.addAttribute("curPageTO", teacherOutState.getCurPage());
		model.addAttribute("curPageTS", tsState.getCurPage());
		
		model.addAttribute("lastpageTI", teacherInState.getLastPage());
		model.addAttribute("lastpageTO", teacherOutState.getLastPage());
		
		session.setAttribute("TeacherOutState", teacherOutState);
		session.setAttribute("TeacherInState", teacherInState);
		return "superAdm/ManangeTeacher";
	}
	
	@RequestMapping(value="/DoPageTOServlet", method=RequestMethod.GET)
	public String doPageTO(Model model, HttpSession session, String page) {
		TeacherQueryState toState = null;
		
		if (page == null) {
			page = "0";
			session.removeAttribute("TeacherOutState");
			toState = new TeacherQueryState();
		} else {
			toState = (TeacherQueryState) session.getAttribute("TeacherOutState");
			if (toState == null) {
				toState = new TeacherQueryState();
			}
		}
		
		List<TeacherOut> toList = null;
		int lastpage = inputFileService.getTOLastPage(toState);
		toState.setLastPage(lastpage);
		toList = inputFileService.getTeacherOutByPage(toState, page);
		
		TeacherQueryState teacherInState = (TeacherQueryState) session.getAttribute("TeacherInState");
		TeacherQueryState teacherSchoolState = (TeacherQueryState) session.getAttribute("TeacherSchoolState");
		
		int tiLastPage = inputFileService.getTILastPage(teacherInState);
		int tsLastPage = inputFileService.getTSLastPage(teacherSchoolState);
		
		teacherInState.setLastPage(tiLastPage);
		teacherSchoolState.setLastPage(tsLastPage);
		
		List<TeacherIn> teacherInList = inputFileService.getTeacherIn(teacherInState);
		List<TeacherSchool> teacherSchoolList = inputFileService.getTeacherSchool(teacherSchoolState);
		
		session.setAttribute("TeacherOutState", toState);
		model.addAttribute("lastpageTO", lastpage);
		
		model.addAttribute("teacherInList", teacherInList);
		model.addAttribute("teacherOutList", toList);
		model.addAttribute("teacherSchoolList", teacherSchoolList);
		
		model.addAttribute("curPageTI", teacherInState.getCurPage());
		model.addAttribute("curPageTO", toState.getCurPage());
		model.addAttribute("curPageTS", teacherSchoolState.getCurPage());
		
		model.addAttribute("lastpageTI", teacherInState.getLastPage());
		model.addAttribute("lastpageTS", teacherSchoolState.getLastPage());
		
		session.setAttribute("TeacherInState", teacherInState);
		session.setAttribute("TeacherSchoolState", teacherSchoolState);
		return "superAdm/ManangeTeacher";
	}
	
	@RequestMapping(value="/InputFileController/updateTeacherInInfo",method=RequestMethod.POST)
	public String updateTeacherInInfo(Model model, HttpSession session,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tino", (String) request.getParameter("teacherNumber"));
		map.put("tiname", (String)request.getParameter("teacherName"));
		map.put("tiprofession",(String) request.getParameter("teacherProfession"));
		map.put("title",(String)request.getParameter("teacherTelephone"));
		
		inputFileService.updateTeacherInInfo(map);
		return "redirect:/GetTeacherInServlet";
	}
	
	@RequestMapping(value="/InputFileController/updateTeacherOutInfo",method=RequestMethod.POST)
	public String updateStudentOutInfo(Model model, HttpSession session,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tono", (String) request.getParameter("teacherNumber"));
		map.put("toname", (String)request.getParameter("teacherName"));
		map.put("toprofession",(String) request.getParameter("teacherProfession"));
		map.put("totel",(String)request.getParameter("teacherTelephone"));
		
		inputFileService.updateTeacherOutInfo(map);
		return "redirect:/GetTeacherInServlet";
	}
	
	@RequestMapping(value="/InputFileController/updateTeacherSchoolInfo",method=RequestMethod.POST)
	public String updateStudentSchoolInfo(Model model, HttpSession session,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tsno", (String) request.getParameter("teacherNumber"));
		map.put("tsname", (String)request.getParameter("teacherName"));
		map.put("tsprofession",(String) request.getParameter("teacherProfession"));
		map.put("tstel",(String)request.getParameter("teacherTelephone"));
		inputFileService.updateTeacherSchoolInfo(map);
		return "redirect:/GetTeacherInServlet";
	}
	
	@RequestMapping(value="/InputFileController/deleteTeacherIn",method=RequestMethod.GET)
	public String deleteTeacherIn(Model model, HttpSession session,HttpServletRequest request){
		String tino = (String) request.getParameter("tino");

		inputFileService.deleteTeacherIn(tino);
		return "redirect:/GetTeacherInServlet";
	}
	
	@RequestMapping(value="/InputFileController/deleteTeacherSchool",method=RequestMethod.GET)
	public String deleteTeacherSchool(Model model, HttpSession session,HttpServletRequest request){
		String tsno = (String) request.getParameter("tsno");

		inputFileService.deleteTeacherSchool(tsno);
		return "redirect:/GetTeacherInServlet";
	}
	
	@RequestMapping(value="/InputFileController/deleteTeacherOut",method=RequestMethod.GET)
	public String deleteTeacherOut(Model model, HttpSession session,HttpServletRequest request){
		String tono = (String) request.getParameter("tono");

		inputFileService.deleteTeacherOut(tono);
		return "redirect:/GetTeacherInServlet";
	}
}
