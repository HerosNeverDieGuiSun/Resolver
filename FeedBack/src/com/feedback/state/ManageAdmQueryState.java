package com.feedback.state;
import com.feedback.util.ManageAdmUtil;
public class ManageAdmQueryState extends PageQueryState{
	private String admno = "";
	private String admpsw = "";
	
	public ManageAdmQueryState(){
		
	}
	
	public ManageAdmQueryState(int curPage,String admno,String admpsw){
		setCurPage(curPage);
		this.admno = admno;
		this.admpsw = admpsw;
	}
	public String getAdmno() {
		// TODO Auto-generated method stub
		return admno;
	}
	public void setAdmno(String admno) {
		this.admno = admno;
	}

	public String getAdmpsw() {
		// TODO Auto-generated method stub
		return admpsw;
	}
	public void setAdmpsw(String psw) {
		// TODO Auto-generated method stub
		this.admpsw = psw;
	}
	

}
