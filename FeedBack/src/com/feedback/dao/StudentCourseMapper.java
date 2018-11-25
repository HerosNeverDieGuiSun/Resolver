package com.feedback.dao;

import java.util.List;
import java.util.Map;

import com.feedback.domain.StudentCourse;

public interface StudentCourseMapper {
	public int queryMaxCount();
	public int queryMaxCountBySno(String sno);
	public List<StudentCourse> queryByNo(Map<String, Object> map);
}