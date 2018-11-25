package com.feedback.domain;

public class StudentCourse {
	@Override
	public String toString() {
		return "StudentCourse [sno=" + sno + ", cname=" + cname + ", ctno=" + ctno + ", tname=" + tname + "]";
	}
	private String sno;
	private String cname;
	private String ctno;
	private String tname;
	
	public StudentCourse() {}
	public StudentCourse(String studentno,String course,String classteachno,String teacher) {
		this.sno = studentno;
		this.cname = course;
		this.ctno = classteachno;
		this.tname = teacher;
	}
	
	public String getSno() {
		return sno;
	}
	public void setSno(String n) {
		this.sno = n;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String name) {
		this.cname = name;
	}
	public String getCtno() {
		return ctno;
	}
	public void setCtno(String n) {
		this.ctno = n;
	}
	
	public String getTname() {
		return tname;
	}
	public void setTname(String name) {
		this.tname = name;
	}
}
