package com.feedback.dao;
import java.util.List;
import java.util.Map;
import com.feedback.domain.Student;
public interface StudentMapper {
	public Student showStudentInfo(String sno);
	public void updateStudentInfo(Map<String,Object> map);
}
