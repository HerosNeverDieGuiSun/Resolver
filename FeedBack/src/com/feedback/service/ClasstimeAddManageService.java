package com.feedback.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feedback.dao.ClasstimeAddMapper;
import com.feedback.dao.StudentMapper;
import com.feedback.domain.ClasstimeAdd;
import com.feedback.domain.Student;
import com.feedback.state.ManageStudentQueryState;
import com.feedback.state.PageQueryState;
import com.feedback.util.ManageStudentUtil;



@Service("ClasstimeAddManageService")
@Scope("singleton")
public class ClasstimeAddManageService {
	@Resource
	private ClasstimeAddMapper classtimeAddDao;
	
	public boolean deleteClasstimeAdd(Map<String,Object> map){
		return classtimeAddDao.deleteClasstimeAdd(map);
	}
	
	
	/*
	 * 获取查询结果的最大页数
	 */
	public int getManageClasstimeAddLastPage(PageQueryState state){

		int pageCount = classtimeAddDao.queryManageClasstimeAddMaxPageCount();
		System.out.println("pageCount "+pageCount);
		int maxPage = (pageCount + ManageStudentUtil.MAX_MANAGE_STUDENT_PAGE_LINES - 1) / ManageStudentUtil.MAX_MANAGE_STUDENT_PAGE_LINES;
		System.out.println("maxPage "+maxPage);
		int lastPage = (maxPage > 0) ? maxPage - 1 : 0;  

        return lastPage;
		
	}
	
	public List<ClasstimeAdd> getClasstimeAddByPage(PageQueryState state,String page){
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
		map.put("startRow", state.getCurPage() * ManageStudentUtil.MAX_MANAGE_STUDENT_PAGE_LINES);
		map.put("rowCount", ManageStudentUtil.MAX_MANAGE_STUDENT_PAGE_LINES);
		
		List<ClasstimeAdd> list = classtimeAddDao.queryByPage(map);
		return list;
	}
	
	public boolean updateClasstimeAdd(Map<String,Object> map){
		return classtimeAddDao.updateClasstimeAdd(map);
	}
}