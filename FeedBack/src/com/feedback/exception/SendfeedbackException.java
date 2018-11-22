package com.feedback.exception;

@SuppressWarnings("serial")
public class SendfeedbackException extends Exception {
	
	public SendfeedbackException(Exception e) {
		super(e);
	}
	
	public SendfeedbackException(String msg) {
		super(msg);
	}
}
