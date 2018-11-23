package com.feedback.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feedback.dao.*;
import com.feedback.exception.*;

@Service("SendfeedbackService")
@Scope("singleton")
public class SendfeedbackService {
	@Resource
	private SendfeedbackMapper sendfeedbackDAO ;
	
	public void sendtoTeacher(String Sno,String CTno,Timestamp FBtime)throws SendfeedbackException {
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("sno", Sno);
		map.put("ctno", CTno);
		map.put("fbtime", FBtime);
		sendfeedbackDAO.process(map);
		sendfeedbackDAO.sendtoTeacher(map);
	}
	
	public void sendtoLeader(String Sno,String CTno,Timestamp FBtime)throws SendfeedbackException {
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("sno", Sno);
		map.put("ctno", CTno);
		map.put("fbtime", FBtime);
		sendfeedbackDAO.process(map);
		sendfeedbackDAO.sendtoLeader(map);
	}
	
	public void agree(String Sno,String CTno,Timestamp FBtime)throws SendfeedbackException {
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("sno", Sno);
		map.put("ctno", CTno);
		map.put("fbtime", FBtime);
		sendfeedbackDAO.process(map);
		sendfeedbackDAO.agree(map);
	}
	
	public void disagree(String Sno,String CTno,Timestamp FBtime)throws SendfeedbackException {
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("sno", Sno);
		map.put("ctno", CTno);
		map.put("fbtime", FBtime);
		sendfeedbackDAO.process(map);
		sendfeedbackDAO.disagree(map);
	}
	
	public void leaderSendtoTeacher(String Sno,String CTno,Timestamp FBtime)throws SendfeedbackException {
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("sno", Sno);
		map.put("ctno", CTno);
		map.put("fbtime", FBtime);
		sendfeedbackDAO.leaderProcess(map);
		sendfeedbackDAO.sendtoTeacher(map);
	}
	
	public void leaderAgree(String Sno,String CTno,Timestamp FBtime)throws SendfeedbackException {
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("sno", Sno);
		map.put("ctno", CTno);
		map.put("fbtime", FBtime);
		sendfeedbackDAO.leaderProcess(map);
		sendfeedbackDAO.agree(map);
	}
	
	public void leaderDisagree(String Sno,String CTno,Timestamp FBtime)throws SendfeedbackException {
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("sno", Sno);
		map.put("ctno", CTno);
		map.put("fbtime", FBtime);
		sendfeedbackDAO.leaderProcess(map);
		sendfeedbackDAO.disagree(map);
	}
	
	public void teacherAgree(String Sno,String CTno,Timestamp FBtime)throws SendfeedbackException {
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("sno", Sno);
		map.put("ctno", CTno);
		map.put("fbtime", FBtime);
		sendfeedbackDAO.teacherProcess(map);
		sendfeedbackDAO.agree(map);
	}
	
	public void teacherDisagree(String Sno,String CTno,Timestamp FBtime)throws SendfeedbackException {
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("sno", Sno);
		map.put("ctno", CTno);
		map.put("fbtime", FBtime);
		sendfeedbackDAO.teacherProcess(map);
		sendfeedbackDAO.disagree(map);
	}
}
