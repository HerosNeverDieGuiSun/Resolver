package com.feedback.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.feedback.dao.ScheduleMapper;
import com.feedback.domain.Schedule;

import com.feedback.service.ScheduleService;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.codehaus.jackson.map.ObjectMapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/ScheduleCtrl")
public class ScheduleController {
	@Resource
	private ScheduleService scheduleServ;
	
	@RequestMapping(value="/ListScheduleInfo",method=RequestMethod.GET )
	public String listScheduleInfo(Model model,HttpSession session){
		String tino="2016215257";
		Schedule schedule=new Schedule();
		try{
			System.out.println("success into ScheduleInfo");
			List<Schedule>list = scheduleServ.showCourseInfo(tino);
			System.out.println("123456");
			
			String s1="[\'\', \'\', \'\', \'\', \'\', \'\', \'\', \'\', \'\', \'\']";
			System.out.println(s1);
			String[] s =new String[7];
			for (int i=0;i<7;i++){
				s[i] ="[\'\', \'\', \'\', \'\', \'\', \'\', \'\', \'\', \'\', \'\']";
			}
			
			for(int i=0;i<list.size();i++){
				//list.get(i).getCname();
				//list.get(i).getAdd();
				//list.get(i).getDay();
				//list.get(i).getStartsection();
				//list.get(i).getEndsection();
				//list.get(i).getStartweek();
				//list.get(i).getEndweek();
				s[list.get(i).getDay()-1] = "[";
				for(int j=1;j<list.get(i).getStartsection();j++){
					s[list.get(i).getDay()-1]=s[list.get(i).getDay()-1].concat("\'\',");
					
				}
				for(int j=list.get(i).getStartsection();j<=list.get(i).getEndsection();j++){
					s[list.get(i).getDay()-1]=s[list.get(i).getDay()-1].concat("\'");
					s[list.get(i).getDay()-1]=s[list.get(i).getDay()-1].concat(list.get(i).getCname()+" "+list.get(i).getAdd()+"第"+list.get(i).getStartweek()+"周开始"+" 第"+list.get(i).getEndweek()+"周结束");
					s[list.get(i).getDay()-1]=s[list.get(i).getDay()-1].concat("\'");
					s[list.get(i).getDay()-1]=s[list.get(i).getDay()-1].concat(",");
				}
				for(int j=list.get(i).getEndsection()+1;j<=10;j++){
					s[list.get(i).getDay()-1]=s[list.get(i).getDay()-1].concat("\'\',");
				}
				s[list.get(i).getDay()-1] = s[list.get(i).getDay()-1].substring(0,s[list.get(i).getDay()-1].length() - 1);
				
				s[list.get(i).getDay()-1]=s[list.get(i).getDay()-1].concat("]");
				System.out.println("final=="+s[list.get(i).getDay()-1]);
			}
			String course="[";
			for(int i=0;i<7;i++){
				course=course.concat(s[i]);
				course=course.concat(",");
				
			}
			course=course.substring(0,course.length()-1);
			course=course.concat("]");
			System.out.println("finalcourse="+course);
			/*String json ="[[\'大学英语(Ⅳ)@10203\', \'大学英语(Ⅳ)@10203\', \'\', \'\', \'\', \'\', \'毛概@14208\', \'毛概@14208\', \'\', \'\'],"
					+ "[\'大学英语(Ⅳ)@10203\', \'大学英语(Ⅳ)@10203\', \'\', \'\', \'\', \'\', \'毛概@14208\', \'毛概@14208\', \'\', \'\'],"
					+ "[\'大学英语(Ⅳ)@10203\', \'大学英语(Ⅳ)@10203\', \'\', \'\', \'\', \'\', \'毛概@14208\', \'毛概@14208\', \'\', \'\'],"
					+ "[\'\', \'\', \'\', \'\', \'\', \'\', \'\', \'\', \'\', \'\'],"
					+ "[\'大学英语(Ⅳ)@10203\', \'大学英语(Ⅳ)@10203\', \'\', \'\', \'\', \'\', \'毛概@14208\', \'毛概@14208\', \'\', \'\']]";*/
			
			
			
			
			
			
			
			model.addAttribute("json", course);
			session.setAttribute("Schedule", list);
			model.addAttribute("ScheduleInfo",list);
			
			
		}catch(Exception e){
			
		}
		
		return "teacher/Schedule";
	}
}
