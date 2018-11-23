package com.feedback.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feedback.dao.LeaderMapper;
import com.feedback.domain.Leader;

@Service("leaderService")
@Scope("singleton")
public class LeaderService {
	@Resource
	private LeaderMapper leaderServ;
	@Resource
	private LeaderMapper leaderDAO;
	
	public List<Leader> getLeaderList(){
		List<Leader> list = leaderDAO.queryAll();
		System.out.println(list.toString());
		return list;
	}
	
	public void deleteLeader(String lno){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("lno", lno);
		System.out.println("ssdasda");
		System.out.println(lno+"ssss");
		leaderDAO.deleteLeader(lno);
	}
}
