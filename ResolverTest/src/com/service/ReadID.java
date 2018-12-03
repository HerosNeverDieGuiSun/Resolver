package com.service;

public class ReadID {
	public void ReadID(){
		
	}
	public void reader(String str){
		 //str = "123321:123457";
		int start = str.indexOf(":");
		System.out.println(start);
		String b = str.substring(start,1);
		System.out.println(b);
	}
}
