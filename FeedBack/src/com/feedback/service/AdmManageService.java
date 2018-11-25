package com.feedback.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feedback.dao.AdministratorsMapper;
import com.feedback.domain.Administrators;
import com.feedback.state.ManageAdmQueryState;
import com.feedback.util.ManageAdmUtil;

@Service("admManageService")
@Scope("singleton")
public class AdmManageService {
	@Resource
	private AdministratorsMapper admDao;
	
	public boolean deleteAdmByAdmno(String admno){
		return admDao.deleteAdmByAdmno(admno);
	}
	
	/*
	 * 获取查询结果的最大页数
	 */
	public int getManageAdmLastPage(ManageAdmQueryState state){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("admno", state.getAdmno());
		map.put("admpsw", state.getAdmpsw());
		
		int pageCount = admDao.queryManageAdmMaxPageCount(map);
		System.out.println("pageCount "+pageCount);
		int maxPage = (pageCount + ManageAdmUtil.MAX_MANAGE_STUDENT_PAGE_LINES - 1) / ManageAdmUtil.MAX_MANAGE_STUDENT_PAGE_LINES;
		System.out.println("maxPage "+maxPage);
		int lastPage = (maxPage > 0) ? maxPage - 1 : 0;  

        return lastPage;
		
	}
	
	public List<Administrators> getAdmByPage(ManageAdmQueryState state,String page){
		int curPage = state.getCurPage();
		
		 //判断页面跳转
		
		if(page.equals("prev")){
			if(curPage>0) 
				curPage--;
		}else if(page.equals("next")){
			if(curPage<state.getLastPage())
				curPage++;
		}else{
			int curPageInt = Integer.parseInt(page);
			if(curPage>=0 && curPage<=state.getLastPage())
				curPage = curPageInt;
		}
		state.setCurPage(curPage);
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", state.getCurPage() * ManageAdmUtil.MAX_MANAGE_STUDENT_PAGE_LINES);
		map.put("rowCount", ManageAdmUtil.MAX_MANAGE_STUDENT_PAGE_LINES);
		map.put("admno", state.getAdmno());
		map.put("admpsw", state.getAdmpsw());
		
		List<Administrators> list = admDao.queryByPage(map);
		return list;
	}
	
	public boolean updateAdm(Map<String,String> map){
		return admDao.updateAdm(map);
	}
}
