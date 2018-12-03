package com.domain;
import com.tag.Tag;



//词法记号类
public class Token {
	
	public Tag tag;
	public String name;
	public Token(Tag t){
		
	};
	public Token(String t){
		
	}
	public Token(){
		
	}
	public void setname(String name){
		this.name=name;
	}
	public String getname(){
		return name;
	}
	public void setTag(Tag tag){
		this.tag=tag;
	}
	public Tag getTag(){
		return tag;
	}
}








