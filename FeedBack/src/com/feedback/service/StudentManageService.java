package com.feedback.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feedback.dao.StudentMapper;
import com.feedback.domain.Student;
import com.feedback.state.ManageStudentQueryState;
import com.feedback.util.ManageStudentUtil;



@Service("studentManageService")
@Scope("singleton")
public class StudentManageService {
	@Resource
	private StudentMapper studentDao;
	
	public boolean deleteStudentBySno(String sno){
		return studentDao.deleteStudentBySno(sno);
	}
	
	public boolean exchangeStudentStatus(String sno,int newStatus){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sno", sno);
		map.put("newStatus", newStatus);
		return studentDao.exchangeStudentStatus(map); 
	}
	
	/*
	 * 获取查询结果的最大页数
	 */
	public int getManageStudentLastPage(ManageStudentQueryState state){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sno", state.getSno());
		map.put("sname",state.getSname());
		map.put("spsw", state.getSpsw());
		map.put("cnname", state.getCnname());
		map.put("status", state.getStatus());
		
		int pageCount = studentDao.queryManageStudentMaxPageCount(map);
		System.out.println("pageCount "+pageCount);
		int maxPage = (pageCount + ManageStudentUtil.MAX_MANAGE_STUDENT_PAGE_LINES - 1) / ManageStudentUtil.MAX_MANAGE_STUDENT_PAGE_LINES;
		System.out.println("maxPage "+maxPage);
		int lastPage = (maxPage > 0) ? maxPage - 1 : 0;  

        return lastPage;
		
	}
	
	public List<Student> getStudentByPage(ManageStudentQueryState state,String page){
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
		map.put("sno", state.getSno());
		map.put("sname",state.getSname());
		map.put("spsw", state.getSpsw());
		map.put("cnname", state.getCnname());
		map.put("status", state.getStatus());
		
		List<Student> list = studentDao.queryByPage(map);
		return list;
	}
	
	public boolean updateStudent(Map<String,String> map){
		return studentDao.updateStudent(map);
	}
}
