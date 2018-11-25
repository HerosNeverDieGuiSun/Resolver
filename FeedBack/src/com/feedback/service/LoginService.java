package com.feedback.service;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feedback.dao.LoginMapper;
import com.feedback.domain.Leader;
import com.feedback.domain.Student;
import com.feedback.domain.SuperAdm;
import com.feedback.domain.TeacherIn;
import com.feedback.domain.TeacherOut;
import com.feedback.domain.TeacherSchool;

@Service
@Scope("singleton")
public class LoginService {
	@Resource
	private LoginMapper loginMapper;
	
	public Student checkStudent(String username, String userpsw) {
		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("sno", username);
		map.put("spsw", userpsw);
		Student student = loginMapper.selectStudent(map);
		return student;
	}
	
	public TeacherIn checkTeacherIn(String username, String userpsw) {
		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("tino", username);
		map.put("tipsw", userpsw);
		TeacherIn teacherIn = loginMapper.selectTeacherIn(map);
		return teacherIn;
	}
	
	public TeacherOut checkTeacherOut(String username, String userpsw) {
		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("tono", username);
		map.put("topsw", userpsw);
		TeacherOut teacherOut = loginMapper.selectTeacherOut(map);
		return teacherOut;
	}
	
	public TeacherSchool checkTeacherSchool(String username, String userpsw) {
		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("tsno", username);
		map.put("tspsw", userpsw);
		TeacherSchool teacherSchool = loginMapper.selectTeacherSchool(map);
		return teacherSchool;
	}
	
	public Leader checkLeader(String username, String userpsw) {
		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("lno", username);
		map.put("lpsw", userpsw);
		Leader leader = loginMapper.selectLeader(map);
		return leader;
	}
	
	public SuperAdm checkSuperAdm(String username, String userpsw) {
		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("superno", username);
		map.put("superpsw", userpsw);
		SuperAdm superAdm = loginMapper.selectSuperAdm(map);
		return superAdm;
	}
}
