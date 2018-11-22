package com.feedback.state;

import com.feedback.util.ManageStudentUtil;
public class ManageStudentQueryState extends PageQueryState {
	private String sno = "";
	private String sname = "";
	private String spsw = "";
	private String cnname = "";
	private String ico = "";
	private int status = ManageStudentUtil.UNDEFINE_STUDENT_STATUS;
	
	public ManageStudentQueryState(){
		
	}
	
	public ManageStudentQueryState(int curPage,String sno,String sname,String spsw,String cnname,int status){
		setCurPage(curPage);
		this.sno = sno;
		this.sname = sname;
		this.spsw = spsw;
		this.cnname = cnname;
		this.status = status;
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
