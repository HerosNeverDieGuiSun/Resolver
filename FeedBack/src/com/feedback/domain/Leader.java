package com.feedback.domain;

public class Leader {
	private String lno;
	private String lname;
	private String ico;
	private String lpsw;
	
	public Leader(){
		
	}
	
	public Leader(String lno,String lname,String ico,String lpsw){
		super();
		this.lpsw = lpsw;
		this.lno=lno;
		this.ico=ico;
		this.lname=lname;
		
	}

	public String getLno() {
		return lno;
	}

	public void setLno(String lno) {
		this.lno = lno;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public String getLpsw() {
		return lpsw;
	}

	public void setLpsw(String lpsw) {
		this.lpsw = lpsw;
	}

	
	
}
