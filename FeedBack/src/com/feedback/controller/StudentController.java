package com.feedback.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.SetAccessibility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.apache.commons.io.FileUtils;

import com.feedback.domain.Student;
import com.feedback.service.StudentService;


@Controller
@RequestMapping(value="/StudentCtrl")
public class StudentController {
	@Resource
	private StudentService studentServ;
	@RequestMapping(value="ListStudentInfo" , method = RequestMethod.GET)
	public String listStudentInfo(Model model , HttpSession session){
		
		String sno="2016215257";
		Student stu=new Student();
		
		try{
			stu = studentServ.showStudentInfo(sno);
			session.setAttribute("student", stu);
			model.addAttribute("studentInfoList",stu);
			System.out.println(stu.getIco());
		}catch(Exception e){
			
		}
		
		return "student/StudentInfo";
	}
	
	@RequestMapping(value = "updateStudentInfo")
	public String updateStudentInfo(@RequestParam("uploudIco") CommonsMultipartFile file,
			HttpServletRequest request,HttpSession session,@RequestParam("spsw")String spsw){
			Student stu = (Student)session.getAttribute("student");
			System.out.println(stu.getSno());
		if (!file.isEmpty()) {
             String type = file.getOriginalFilename().substring(
                     file.getOriginalFilename().indexOf("."));// 取文件格式后缀名
             String filename = System.currentTimeMillis() + type;// 取当前时间戳作为文件名
             String path = request.getSession().getServletContext()
                    .getRealPath("/student/img/upload/" + filename);
            
             
             System.out.println(path);
             File destFile = new File(path);
            
             try {
                 
                 FileUtils
                         .copyInputStreamToFile(file.getInputStream(), destFile);// 复制临时文件到指定目录下
                
                 studentServ.updateStudentInfo(stu.getSno(), filename, spsw);
                 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
             } catch (IOException e) {
                 e.printStackTrace();
             }
             return "student/StudentInfo";
         } else {
             return "student/StudentInfo";
         }
		
		
	}
	@RequestMapping(value="text")
	public String text(HttpServletRequest request,HttpSession session){
		System.out.println("successs to text");
		return "student/StudentInfo";
	}
	
}
