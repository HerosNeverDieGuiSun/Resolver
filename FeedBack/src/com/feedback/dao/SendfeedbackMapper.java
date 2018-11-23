package com.feedback.dao;

import java.util.Map;

public  interface SendfeedbackMapper {
	public void process(Map<String,Object> map);
	public void leaderProcess(Map<String,Object> map);
	public void teacherProcess(Map<String,Object> map);
	public void sendtoTeacher(Map<String,Object> map);
	public void sendtoLeader(Map<String,Object> map);
	public void agree(Map<String,Object> map);
	public void disagree(Map<String,Object> map);
	
}
