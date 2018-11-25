package com.feedback.exception;

@SuppressWarnings("serial")
public class FeedbackException extends Exception {
	public FeedbackException(Exception e) {
		super(e);
	}
	
	public FeedbackException(String msg) {
		super(msg);
	}
}
