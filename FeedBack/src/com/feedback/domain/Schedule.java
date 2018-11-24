package com.feedback.domain;

public class Schedule {
	String ctno;
	String add;
	int startweek;
	int endweek;
	int day;
	int startsection;
	int endsection;
	String cno;
	String cname;
	String tino;
	public Schedule(){
		
	}
	public Schedule(String ctno,String add,int startweek,int endweek,int day,int startsection,int endsection,String cno,String cname,String tino){
		this.ctno = ctno;
		this.add = add;
		this.startweek = startweek;
		this.endweek = endweek;
		this.day = day;
		this.startsection = startsection;
		this.endsection=endsection;
		this.cno=cno;
		this.cname = cname;
		this.tino = tino;
	}
	public String getCtno() {
		return ctno;
	}
	public void setCtno(String ctno) {
		this.ctno = ctno;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public int getStartweek() {
		return startweek;
	}
	public void setStartweek(int startweek) {
		this.startweek = startweek;
	}
	public int getEndweek() {
		return endweek;
	}
	public void setEndweek(int endweek) {
		this.endweek = endweek;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getStartsection() {
		return startsection;
	}
	public void setStartsection(int startsection) {
		this.startsection = startsection;
	}
	public int getEndsection() {
		return endsection;
	}
	public void setEndsection(int endsection) {
		this.endsection = endsection;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTino() {
		return tino;
	}
	public void setTino(String tino) {
		this.tino = tino;
	}
	
}
