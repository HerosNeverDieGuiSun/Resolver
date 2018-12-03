package com.service;

import java.util.ArrayList;
import java.util.List;

import com.domain.Key;
import com.tag.Tag;
import com.domain.Token;

public class DFA {
	
	char a='1';
	
	Tag tag ;
	Tag tag1;
	List<Token> list = new ArrayList<Token>();
	int index=0;
	void change(){
		Key key  =new Key();
		
		System.out.println(key.getTag('='));
	}
	
	public void Scan(String str){
		String name ="";
		list.clear();
		//List<Token> list = new ArrayList<Token>();
		for(int i =0 ;i<str.length();i++){
			//字符串逐个扫描,并加入ch中,并判断
			char ch = str.charAt(i);
			char chplus='`';
			char chpluss='`';
			if(i!=str.length()-1){
				chplus = str.charAt(i+1);
			}
			if(i<str.length()-2){
				chpluss=str.charAt(i+2);
			}
			//判断幂集
			if(ch=='P'&& chplus==' '){
				Key key  =new Key();
				tag=key.getTag(ch);
				Token t = new Token();
				
				t.setTag(tag);
				
				list.add(t);
				System.out.println("tag="+tag);
				continue;
				
			}
			//判断有限集
			if(ch=='F'&& chplus==' '){
				Key key  =new Key();
				tag=key.getTag(ch);
				Token t = new Token();
				
				t.setTag(tag);
				
				list.add(t);
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
				Token t = new Token();
				
				t.setTag(tag);
				
				list.add(t);
				temp="";
				i=i+1;
				System.out.println("tag="+tag);
				continue;
				
			}
			//判断bag
			if(ch=='b'&& chplus=='a' && chpluss=='g'){
				if(!name.equals("")){
					Key key  =new Key();
					tag=key.getTag(name);
					System.out.println("name= "+name);
					System.out.println("tag="+tag);
					name="";
				}
				Key key  =new Key();
				String temp="";
				temp=temp+ch+chplus+chpluss;
				
				tag=key.getTag(temp);
				Token t = new Token();
				
				t.setTag(tag);
				
				list.add(t);
				temp="";
				i=i+2;
				System.out.println("tag="+tag);
				continue;
			}
			//判断seq
			if(ch=='s'&& chplus=='e' && chpluss=='q'){
				if(!name.equals("")){
					Key key  =new Key();
					tag=key.getTag(name);
					System.out.println("name= "+name);
					System.out.println("tag="+tag);
					name="";
				}
				Key key  =new Key();
				String temp="";
				temp=temp+ch+chplus+chpluss;
				
				tag=key.getTag(temp);
				Token t = new Token();
				
				t.setTag(tag);
				
				list.add(t);
				temp="";
				i=i+2;
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
						Token t = new Token();
						t.setname(name);
						t.setTag(tag);
						
						list.add(t);
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
						Token t = new Token();
						t.setname(name);
						t.setTag(tag);
						
						list.add(t);
						name="";
					}
					Key key  =new Key();
					tag=key.getTag(ch);
		
					Token t = new Token();
					t.setTag(tag);
					
					list.add(t);
					System.out.println("ch= "+ch);
					System.out.println("tag="+tag);
				}
			
		}
		if(!name.equals("")){
			Key key  =new Key();
			tag=key.getTag(name);
			Token t = new Token();
			t.setname(name);
			t.setTag(tag);
			list.add(t);
			System.out.println("name= "+name);
			System.out.println("tag="+tag);
			name="";
		}
		//return list;
	}
	
	public Token getToken(){
		Token token =new Token();
		if(index==list.size()){
			return null;
		}else{

			return token=list.get(index++);
		}
		
	}
	
	public void returnToken(Token token){
		
			index=index-1;
			
	}
	public static void main(String args[]){
		DFA fda = new DFA();
		String str="staff,borrowers:P Person ";
		String str1="staff==sss";
		String str2="a' ∈  person ∩ hhh";
		fda.Scan(str2);
	
		
	}
}
