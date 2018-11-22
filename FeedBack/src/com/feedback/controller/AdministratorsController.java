package com.feedback.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feedback.domain.Administrators;
import com.feedback.service.AdministratorsService;

@Controller
@RequestMapping(value="/AdministratorsCtrl")
public class AdministratorsController {
	@Resource
	private AdministratorsService admServ;
	@RequestMapping(value="/ListAdministrators",method=RequestMethod.GET)
	public String listAll(Model model,HttpSession session){
		List<Administrators> list = null;
		try{
			list = admServ.getAdmList();
			model.addAttribute("AdministratorsList", list);
		}catch(Exception e){
			
		}
		return "superAdm/ManageAdm";
	}
	
	@RequestMapping(value="/DeleteAdm")
	public String delete(String admno){
		admServ.deleteAdm(admno);
		System.out.println("success into delete and admno="+admno);
		return "redirect:../AdministratorsCtrl/ListAdministrators";
	}
}
