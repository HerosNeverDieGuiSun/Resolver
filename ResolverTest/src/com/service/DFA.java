package com.service;

import com.domain.Key;
import com.tag.Tag;

public class DFA {
	
	char a='1';
	
	Tag tag ;
	Tag tag1;
	void change(){
		Key key  =new Key();
		
		System.out.println(key.getTag('='));
	}
	
	public void Scan(String str){
		String name ="";
		for(int i =0 ;i<str.length();i++){
			//字符串逐个扫描,并加入ch中,并判断
			char ch = str.charAt(i);
			char chplus='`';
			if(i!=str.length()-1){
				chplus = str.charAt(i+1);
			}
			//判断幂集
			if(ch=='P'&& chplus==' '){
				Key key  =new Key();
				tag=key.getTag(ch);
				System.out.println("tag="+tag);
				continue;
				
			}
			//判断==符号
			if(ch=='='&& chplus=='='){
				
				if(!name.equals("")){
					Key key  =new Key();
					tag=key.getTag(name);
					System.out.println("name= "+name);
					System.out.println("tag="+tag);
					name="";
				}
				Key key  =new Key();
				String temp="";
				temp=temp+ch+chplus;
				
				tag=key.getTag(temp);
				temp="";
				i=i+1;
				System.out.println("tag="+tag);
				continue;
				
			}
			if((ch>='a' && ch<='z') || (ch>='A'&& ch<='Z')||(ch=='_')){
					
					name=name+ch;
				}
				else if(ch=='\n'){
					if(!name.equals("")){
						
						Key key  =new Key();
						System.out.println("name="+name);
						tag=key.getTag(name);
						System.out.println("tag="+tag);
						tag=key.getTag(ch);
						System.out.println("ch= "+ch);
						System.out.println("tag="+tag);
						name="";
					}
				}else if(ch==' '){
					continue;
				}
				else{
					if(!name.equals("")){
						Key key  =new Key();
						tag=key.getTag(name);
						System.out.println("name= "+name);
						System.out.println("tag="+tag);
						name="";
					}
					Key key  =new Key();
					tag=key.getTag(ch);
					System.out.println("ch= "+ch);
					System.out.println("tag="+tag);
				}
			
		}
		if(!name.equals("")){
			Key key  =new Key();
			tag=key.getTag(name);
			System.out.println("name= "+name);
			System.out.println("tag="+tag);
			name="";
		}
	}
	public static void main(String args[]){
		DFA fda = new DFA();
		String str="staff,borrowers:P Person ";
		String str1="staff==sss";
		fda.Scan(str1);
		
	}
}
