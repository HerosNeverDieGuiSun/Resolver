package com.feedback.exception;
@SuppressWarnings("serial")
public class StudentCourseException extends Exception {
	public StudentCourseException(Exception e) {
		super(e);
	}
	
	public StudentCourseException(String msg) {
		super(msg);
	}
}
