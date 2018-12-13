package com.resolver.service;

public class ReadID {
	public void ReadID(){
		
	}
	public String reader(String str){
		 //str = "123321:123457";
		String b=null;
		int start = str.indexOf(":");
		if(start!=-1){
			char ch = str.charAt(start-1);
			if((ch>='a' && ch<='z') || (ch>='A'&& ch<='Z')||(ch=='_')){
				 b = str.substring(0, start);
				System.out.println(b);
				
			}else{
				 b = str.substring(0, start-1);
				System.out.println(b);
			}
		}
		
		
		
		return b;
		
	}
	public String readerLater(String str){
		int start = str.indexOf(":");
		String b=null ;
		if(start!=-1){
			int k=0;
			
			int size = str.length()-1;
			for(int i = start+1 ; i<str.length() ;i++){
				char ch=str.charAt(i);
				char chplus='*';
				char chpluss='*';
				
				if(i<str.length()-1){
					 chplus=str.charAt(i+1);
				}
				if(i<str.length()-2){
					 chpluss=str.charAt(i+2);
				}
				
				if((ch=='P' && chplus==' ')|| (ch=='F' && chplus==' ')){
					System.out.println("进入");
					k=i+2;
					break;
				}else if((ch=='d'&&chplus=='o'&&chpluss=='m') || (ch=='s'&&chplus=='e'&&chpluss=='q')){
					k=i+3;
					break;
				}else if(ch==' '){
					continue;
				}else{
					k=i+1;
					break;
				}
			}
			b=str.substring(k,size+1);
		}
		
		return b;
	}
}
