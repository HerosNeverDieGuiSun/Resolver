package com.feedback.domain;

import java.util.Date;

public class TeacherSchool {
	public String tsno;
	public String tsname;
	public String ico;
	public String tstype;
	public String tsprofession;
	public String tsdepartment;
	public String tsscholar;
	public Date birthyear;
	public String tsschool;
	public String tsoversea;
	public String tsbackground;
	public String tswork;
	public int tsscpaper;
	public int tspatent;
	public int tssoft;
	public int tssp;
	public int tsteapaper;
	public String tsprize;
	public String tsreward;
	public String tsarch;
	public String tspsw;
	public String tstel;
	
	public TeacherSchool() {}
	public TeacherSchool(String no,String name,String ico,String type,String profession,String department,String scholar,
			Date birthyear,String school,String sea,String back,String work, int scpaper,int patent,int soft
			,int sp,int teapaper,String prize,String reward,String arch,String psw,String tel) {
		
		this.tsno = no ;
		this.tsname = name;
		this.ico = ico;
		this.tstype = type;
		this.tsprofession = profession;
		this.tsdepartment = department;
		this.tsscholar = scholar;
		this.birthyear = birthyear;
		this.tsschool = school;
		this.tsoversea = sea;
		this.tsbackground = back;
		this.tswork = work;
		this.tsscpaper = scpaper;
		
		this.tspatent = patent;
		this.tssoft = soft;
		this.tssp = sp;
		this.tsteapaper = teapaper;
		this.tsprize = prize;
		this.tsreward = reward;
		this.tsarch = arch;
		this.tspsw = psw;
		this.tstel = tel;
	}
	public String getTsno() {
		return tsno;
	}
	public void setTsno(String tsno) {
		this.tsno = tsno;
	}
	public String getTsname() {
		return tsname;
	}
	public void setTsname(String tsname) {
		this.tsname = tsname;
	}
	public String getIco() {
		return ico;
	}
	public void setIco(String ico) {
		this.ico = ico;
	}
	public String getTstype() {
		return tstype;
	}
	public void setTstype(String tstype) {
		this.tstype = tstype;
	}
	public String getTsprofession() {
		return tsprofession;
	}
	public void setTsprofession(String tsprofession) {
		this.tsprofession = tsprofession;
	}
	public String getTsdepartment() {
		return tsdepartment;
	}
	public void setTsdepartment(String tsdepartment) {
		this.tsdepartment = tsdepartment;
	}
	public String getTsscholar() {
		return tsscholar;
	}
	public void setTsscholar(String tsscholar) {
		this.tsscholar = tsscholar;
	}
	public Date getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(Date birthyear) {
		this.birthyear = birthyear;
	}
	public String getTsschool() {
		return tsschool;
	}
	public void setTsschool(String tsschool) {
		this.tsschool = tsschool;
	}
	public String getTsoversea() {
		return tsoversea;
	}
	public void setTsoversea(String tsoversea) {
		this.tsoversea = tsoversea;
	}
	public String getTsbackground() {
		return tsbackground;
	}
	public void setTsbackground(String tsbackground) {
		this.tsbackground = tsbackground;
	}
	public String getTswork() {
		return tswork;
	}
	public void setTswork(String tswork) {
		this.tswork = tswork;
	}
	public int getTsscpaper() {
		return tsscpaper;
	}
	public void setTsscpaper(int tsscpaper) {
		this.tsscpaper = tsscpaper;
	}
	public int getTspatent() {
		return tspatent;
	}
	public void setTspatent(int tspatent) {
		this.tspatent = tspatent;
	}
	public int getTssoft() {
		return tssoft;
	}
	public void setTssoft(int tssoft) {
		this.tssoft = tssoft;
	}
	public int getTssp() {
		return tssp;
	}
	public void setTssp(int tssp) {
		this.tssp = tssp;
	}
	public int getTsteapaper() {
		return tsteapaper;
	}
	public void setTsteapaper(int tsteapaper) {
		this.tsteapaper = tsteapaper;
	}
	public String getTsprize() {
		return tsprize;
	}
	public void setTsprize(String tsprize) {
		this.tsprize = tsprize;
	}
	public String getTsreward() {
		return tsreward;
	}
	public void setTsreward(String tsreward) {
		this.tsreward = tsreward;
	}
	public String getTsarch() {
		return tsarch;
	}
	public void setTsarch(String tsarch) {
		this.tsarch = tsarch;
	}
	public String getTspsw() {
		return tspsw;
	}
	public void setTspsw(String tspsw) {
		this.tspsw = tspsw;
	}
	public String getTstel() {
		return tstel;
	}
	public void setTstel(String tstel) {
		this.tstel = tstel;
	}
}
