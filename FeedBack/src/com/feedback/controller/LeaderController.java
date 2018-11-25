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

import com.feedback.domain.Leader;
import com.feedback.service.LeaderService;
import com.feedback.state.LeaderQueryState;

@Controller
@RequestMapping(value="/LeaderCtrl")
public class LeaderController {
	@Resource
	private LeaderService leaderServ;
	
	@RequestMapping(value="/ListLeader",method=RequestMethod.GET)
	public String listAll(Model model , HttpSession session ){
		List<Leader> list = null;
		try{
			
			list = leaderServ.getLeaderList();
			model.addAttribute("LeaderList" , list);
		}catch(Exception e){
			
		}
		for(int i = 0; i<list.size();i++){
			System.out.println(list.get(i).getLname());
		}
		return "superAdm/ManageLeader";
	}
	
	@RequestMapping(value="/DeleteLeader")
	public String delete(String lno){
		System.out.println(lno);
		leaderServ.deleteLeader(lno);
		return "redirect:../LeaderCtrl/ListLeader";
	}
	
	@RequestMapping(value="/UpdateLeaderInfo")
	public String updateLeaderInfo(Model model, HttpSession session,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("lno", (String) request.getParameter("leaderNumber"));
		map.put("lname", (String)request.getParameter("leaderName"));
		map.put("lpsw",(String) request.getParameter("leaderPassword"));
		
		leaderServ.updateLeaderInfo(map);
		return "redirect:../LeaderCtrl/ListLeader";
	}
}
