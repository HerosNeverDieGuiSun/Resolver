package com.feedback.domain;

import java.sql.Timestamp;

public class FeedbackRecord {
	public String sno;
	public String ctno;
	public Timestamp fbtime;
	public String content;
	public int statusadm;
	public int statusleader;
	public int statusteacher;
	public int agree;
	
	public FeedbackRecord(){}
	
	

	public FeedbackRecord(String sno, String cTno, Timestamp fBtime, String content,
			int statusAdm, int statusLeader, int statusTeacher, int agree) {
		super();
		this.sno = sno;
		this.ctno = cTno;
		this.fbtime = fBtime;
		this.content = content;
		this.statusadm = statusAdm;
		this.statusleader = statusLeader;
		this.statusteacher = statusTeacher;
		this.agree = agree;
	}



	public String getSno() {
		return sno;
	}



	public void setSno(String sno) {
		this.sno = sno;
	}



	public String getCtno() {
		return ctno;
	}



	public void setCtno(String ctno) {
		this.ctno = ctno;
	}



	public Timestamp getFbtime() {
		return fbtime;
	}



	public void setFbtime(Timestamp fbtime) {
		this.fbtime = fbtime;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getStatusadm() {
		return statusadm;
	}



	public void setStatusadm(int statusadm) {
		this.statusadm = statusadm;
	}



	public int getStatusleader() {
		return statusleader;
	}



	public void setStatusleader(int statusleader) {
		this.statusleader = statusleader;
	}



	public int getStatusteacher() {
		return statusteacher;
	}



	public void setStatusteacher(int statusteacher) {
		this.statusteacher = statusteacher;
	}



	public int getAgree() {
		return agree;
	}



	public void setAgree(int agree) {
		this.agree = agree;
	}



	@Override
	public String toString() {
		return "Feedback [sno=" + sno + ", ctno=" + ctno + ", fbtime=" + fbtime + ", content=" + content
				+ ", statusadm=" + statusadm + ", statusleader=" + statusleader + ", statusteacher=" + statusteacher
				+ ", agree=" + agree + "]";
	}



	
	
	
	
	
}
