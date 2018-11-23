package com.feedback.dao;
import java.util.List;
import java.util.Map;
import com.feedback.domain.Student;
public interface StudentMapper {
	public Student showStudentInfo(String sno);
	public void updateStudentInfo(Map<String,Object> map);
	public List<Student> queryByPage(Map<String,Object> map);
	public boolean updateStudent(Map<String,String> map);
	public boolean deleteStudentBySno(String sno);
	public boolean exchangeStudentStatus(Map<String,Object> map);
	public int queryManageStudentMaxPageCount(Map<String,Object> map);
}
