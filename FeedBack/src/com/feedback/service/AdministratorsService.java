package com.feedback.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feedback.dao.AdministratorsMapper;
import com.feedback.domain.Administrators;

@Service("administratorsService")
@Scope("singleton")
public class AdministratorsService {
	@Resource
	private AdministratorsMapper admServ;
	@Resource
	private AdministratorsMapper admDAO;
	
	public List<Administrators> getAdmList(){
		List<Administrators> list = admDAO.queryAll();
		return list;
	}
	public void deleteAdm(String admno){
		System.out.println("success into deleteAdm");
		admDAO.deleteAdm(admno);
	}
}
