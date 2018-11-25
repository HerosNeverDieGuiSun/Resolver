package com.feedback.domain;

public class ClasstimeAdd {
	private String ctno;
	private String add;//µÿ÷∑
	private int startweek;
	private int endweek;	
	private int day;
	private int startsection;
	private int endsection;
	
	public ClasstimeAdd() {}
	
	public ClasstimeAdd(String ctno,String add,int startweek,int endweek,int day,int startsection,int endsection) {
		super();
		this.ctno=ctno;
		this.add=add;
		this.startweek=startweek;
		this.endweek=endweek;
		this.day=day;
		this.startsection=startsection;
		this.endsection=endsection;
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


	@Override
	public String toString() {
		return "ClasstimeAdd [ctno=" + ctno + ", add=" + add + ", startweek=" + startweek + ", endweek=" + endweek
				+ ", day=" + day + ", startsection=" + startsection + ", endsection=" + endsection + "]";
	}
	
	
}
