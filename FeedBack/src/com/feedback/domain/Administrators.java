package com.feedback.domain;

public class Administrators {
	private String admno;
	private String admpsw;
	
	public Administrators(){
		
	}
	
	public Administrators(String admno,String admpsw){
		this.admno=admno;
		this.admpsw = admpsw;
		
	}

	public String getAdmno() {
		return admno;
	}

	public void setAdmno(String admno) {
		this.admno = admno;
	}

	public String getAdmpsw() {
		return admpsw;
	}

	public void setAdmpsw(String admpsw) {
		this.admpsw = admpsw;
	}

	
}
