package com.feedback.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feedback.dao.FeedbackMapper;
import com.feedback.domain.FeedbackRecord;
import com.feedback.exception.FeedbackException;

@Service
@Scope("singleton")
public class FeedbackService {
	@Resource
	private FeedbackMapper fbDAO;
	
	public void addFeedback(FeedbackRecord fb) throws FeedbackException{
		fbDAO.insert(fb);
	}
}
