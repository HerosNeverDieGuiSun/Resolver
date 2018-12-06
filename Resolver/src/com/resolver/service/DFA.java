

package com.resolver.service;

import java.util.ArrayList;
import java.util.List;


import com.resolver.tool.*;




public class DFA {
	
char a='1';
	
	Tag tag ;
	Tag tag1;
	List<Token> list = new ArrayList<Token>();
	int index=0;
	void change(){
		Key key  =new Key();
		
		
	}
	
	public void Scan(String str){
		String name ="";
		list.clear();
		//List<Token> list = new ArrayList<Token>();
		for(int i =0 ;i<str.length();i++){
			//×Ö·û´®Öð¸öÉ¨Ãè,²¢¼ÓÈëchÖÐ,²¢ÅÐ¶Ï
			char ch = str.charAt(i);
			char chplus='`';
			char chpluss='`';
			if(i!=str.length()-1){
				chplus = str.charAt(i+1);
			}
			if(i<str.length()-2){
				chpluss=str.charAt(i+2);
			}
			//ÅÐ¶ÏÃÝ¼¯
			if(ch=='P'&& chplus==' '){
				Key key  =new Key();
				tag=key.getTag(ch);
				Token t = new Token();
				t.setname("P ");
				t.setTag(tag);
				list.add(t);
				//System.out.println("tag="+tag);
				continue;
				
			}
			//ÅÐ¶ÏÓÐÏÞ¼¯
			if(ch=='F'&& chplus==' '){
				Key key  =new Key();
				tag=key.getTag(ch);
				Token t = new Token();
				t.setname("F ");
				t.setTag(tag);
				
				list.add(t);
				//System.out.println("tag="+tag);
				continue;
				
			}
			//ÅÐ¶Ï==·ûºÅ
			if(ch=='='&& chplus=='='){
				
				if(!name.equals("")){
					Key key  =new Key();
					tag=key.getTag(name);
					//System.out.println("name= "+name);
					//System.out.println("tag="+tag);
					name="";
				}
				Key key  =new Key();
				String temp="";
				temp=temp+ch+chplus;
				
				tag=key.getTag(temp);
				Token t = new Token();
				t.setname("==");
				t.setTag(tag);
				
				list.add(t);
				temp="";
				i=i+1;
				//System.out.println("tag="+tag);
				continue;
				
			}
			//ÅÐ¶Ïdom
			if(ch=='d'&& chplus=='o' && chpluss=='m'){
				if(!name.equals("")){
					Key key  =new Key();
					tag=key.getTag(name);
					//System.out.println("name= "+name);
					//System.out.println("tag="+tag);
					name="";
				}
				Key key  =new Key();
				String temp="";
				temp=temp+ch+chplus+chpluss;
				
				tag=key.getTag(temp);
				Token t = new Token();
				t.setname("dom");
				t.setTag(tag);
				
				list.add(t);
				temp="";
				i=i+2;
				//System.out.println("tag="+tag);
				continue;
			}
			
			//ÅÐ¶Ïbag
			if(ch=='b'&& chplus=='a' && chpluss=='g'){
				if(!name.equals("")){
					Key key  =new Key();
					tag=key.getTag(name);
					//System.out.println("name= "+name);
					//System.out.println("tag="+tag);
					name="";
				}
				Key key  =new Key();
				String temp="";
				temp=temp+ch+chplus+chpluss;
				
				tag=key.getTag(temp);
				Token t = new Token();
				t.setname("bag");
				t.setTag(tag);
				
				list.add(t);
				temp="";
				i=i+2;
				//System.out.println("tag="+tag);
				continue;
			}
			
			//ÅÐ¶Ïran
			if(ch=='r'&& chplus=='a' && chpluss=='n'){
				if(!name.equals("")){
					Key key  =new Key();
					tag=key.getTag(name);
					//System.out.println("name= "+name);
					//System.out.println("tag="+tag);
					name="";
				}
				Key key  =new Key();
				String temp="";
				temp=temp+ch+chplus+chpluss;
				
				tag=key.getTag(temp);
				Token t = new Token();
				t.setname("ran");
				t.setTag(tag);
				
				list.add(t);
				temp="";
				i=i+2;
				//System.out.println("tag="+tag);
				continue;
			}
			//ÅÐ¶Ïseq
			if(ch=='s'&& chplus=='e' && chpluss=='q'){
				if(!name.equals("")){
					Key key  =new Key();
					tag=key.getTag(name);
					//System.out.println("name= "+name);
					//System.out.println("tag="+tag);
					name="";
				}
				Key key  =new Key();
				String temp="";
				temp=temp+ch+chplus+chpluss;
				
				tag=key.getTag(temp);
				Token t = new Token();
				t.setname("seq");
				t.setTag(tag);
				
				list.add(t);
				temp="";
				i=i+2;
				//System.out.println("tag="+tag);
				continue;
			}
			if((ch>='a' && ch<='z') || (ch>='A'&& ch<='Z')||(ch=='_')){
					
					name=name+ch;
				}
				else if(ch=='\n'){
					if(!name.equals("")){
						
						Key key  =new Key();
						//System.out.println("name="+name);
						tag=key.getTag(name);
						//System.out.println("tag="+tag);
						tag=key.getTag(ch);
						Token t = new Token();
						t.setname(name);
						t.setTag(tag);
						
						list.add(t);
						//System.out.println("ch= "+ch);
						//System.out.println("tag="+tag);
						name="";
					}
				}else if(ch==' '){
					continue;
				}
				else{
					if(!name.equals("")){
						Key key  =new Key();
						tag=key.getTag(name);
						//System.out.println("name= "+name);
						//System.out.println("tag="+tag);
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
					t.setname(ch);
					list.add(t);
					//System.out.println("ch= "+ch);
					//System.out.println("tag="+tag);
				}
			
		}
		if(!name.equals("")){
			Key key  =new Key();
			tag=key.getTag(name);
			Token t = new Token();
			t.setname(name);
			t.setTag(tag);
			list.add(t);
			//System.out.println("name= "+name);
			//System.out.println("tag="+tag);
			name="";
		}
		//return list;
	}
	
	public List<Token> getTokenList(){
		
		return list;
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
	
	/*public static void main(String args[]){
		DFA fda = new DFA();
		String str="staff,borrowers:P Person ";
		String str1="staff==sss";
		String str2="a' ¡Ê  person ¡É hhh";
		fda.Scan(str2);
	
		
	}*/
}
