package com.feedback.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feedback.dao.StudentMapper;
import com.feedback.domain.Student;
@Service("studentService")
@Scope("singleton")
public class StudentService {
	@Resource
	private StudentMapper studentServ;
	@Resource
	private StudentMapper studentDAO;
	
	public Student showStudentInfo(String sno){
		Student stu = studentDAO.showStudentInfo(sno);
		return stu;
	}
	public void  updateStudentInfo(String sno,String ico,String spsw){
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("sno", sno);
		map.put("ico", ico);
		map.put("spsw", spsw);
		studentDAO.updateStudentInfo(map);
		
	}
}
