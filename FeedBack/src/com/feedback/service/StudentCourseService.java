package com.feedback.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feedback.dao.StudentCourseMapper;
import com.feedback.domain.StudentCourse;
import com.feedback.exception.StudentCourseException;
import com.feedback.state.StudentCourseQueryState;
import com.feedback.util.WebUtil;

@Service
@Scope("singleton")
public class StudentCourseService {
	@Resource
	private StudentCourseMapper scDAO;
	
	public int getLastPage(StudentCourseQueryState state) throws Exception {
		int count = scDAO.queryMaxCount();
		int maxPage = (count + WebUtil.MAX_PAGE_LINES - 1) / WebUtil.MAX_PAGE_LINES;
		int lastPage = (maxPage > 0) ? maxPage - 1 : 0;  
		
        return lastPage;
	}
	public List<StudentCourse> selectStudentCourse(String studentno,StudentCourseQueryState state,String page) throws StudentCourseException{
		int curPage = state.getCurPage();
		switch (page) {
		case "0":
			curPage = 0;
			break;
		case "cur":
			break;
		case "prev":
			if (curPage > 0) curPage--;
			break;
		case "next":
			if (curPage < state.getLastPage()) curPage++;
			break;
		default:
			curPage = state.getLastPage();
			break;
		}
		state.setCurPage(curPage);
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", state.getCurPage() * WebUtil.MAX_PAGE_LINES);
		map.put("rowCount", WebUtil.MAX_PAGE_LINES);
		map.put("sno", studentno);
		List<StudentCourse> list = scDAO.queryByNo(map);
		for(StudentCourse sc : list) {
			System.out.println(sc.toString());
		}
		return list;
	}
}
