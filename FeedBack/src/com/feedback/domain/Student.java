package com.feedback.domain;

public class Student {
	private String sno;
	private String sname;
	private String spsw;
	private String cnname;
	private String ico;
	private int status;
	
	public Student(){
		
	}
	public Student (String sno,String sname, String spsw,String cnname,String ico){
		super();
		this.sno=sno;
		this.cnname=cnname;
		this.ico=ico;
		this.spsw=spsw;
	}
	public Student (String sno,String sname, String spsw,String cnname,String ico,int status){
		super();
		this.sno=sno;
		this.cnname=cnname;
		this.ico=ico;
		this.spsw=spsw;
		this.status=status;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpsw() {
		return spsw;
	}
	public void setSpsw(String spsw) {
		this.spsw = spsw;
	}
	public String getCnname() {
		return cnname;
	}
	public void setCnname(String cnname) {
		this.cnname = cnname;
	}
	public String getIco() {
		return ico;
	}
	public void setIco(String ico) {
		this.ico = ico;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
