package com.domain;

import com.tag.Tag;

public class Str extends Token {
	
	String str;
	
	public Str(Tag t) {
		super(t);
		
	}
	public Str(String str){
		super(str);
	}
	
}
