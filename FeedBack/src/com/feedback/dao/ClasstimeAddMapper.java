package com.feedback.dao;
import java.util.List;
import java.util.Map;

import com.feedback.domain.ClasstimeAdd;
import com.feedback.domain.Student;
public interface ClasstimeAddMapper {
	public List<ClasstimeAdd> queryByPage(Map<String,Object> map);
	public boolean updateClasstimeAdd(Map<String,Object> map);
	public boolean deleteClasstimeAdd(Map<String,Object> map);
	public int queryManageClasstimeAddMaxPageCount();
}