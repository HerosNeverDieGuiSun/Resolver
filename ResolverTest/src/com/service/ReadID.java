package com.service;

public class ReadID {
	public void ReadID(){
		
	}
	public String reader(String str){
		 //str = "123321:123457";
		int start = str.indexOf(":");
		String b;
		char ch = str.charAt(start-1);
		if((ch>='a' && ch<='z') || (ch>='A'&& ch<='Z')||(ch=='_')){
			 b = str.substring(0, start);
			System.out.println(b);
			
		}else{
			 b = str.substring(0, start-1);
			System.out.println(b);
		}
		return b;
		
	}
}
