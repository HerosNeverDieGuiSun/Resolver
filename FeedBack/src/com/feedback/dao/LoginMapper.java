package com.feedback.dao;

import java.util.Map;

import com.feedback.domain.Leader;
import com.feedback.domain.Student;
import com.feedback.domain.SuperAdm;
import com.feedback.domain.TeacherIn;
import com.feedback.domain.TeacherOut;
import com.feedback.domain.TeacherSchool;

public interface LoginMapper {
	public Student selectStudent(Map<String, Object> map);
	public TeacherIn selectTeacherIn(Map<String, Object> map);
	public TeacherOut selectTeacherOut(Map<String, Object> map);
	public TeacherSchool selectTeacherSchool(Map<String, Object> map);
	public Leader selectLeader(Map<String, Object> map);
	public SuperAdm selectSuperAdm(Map<String, Object> map);
}
