package com.domain;

import com.tag.Tag;

//标识符记号类
public class Id extends Token{
	public Id(Tag t) {
		super(t);
		
	}
	public String name;
	public Id(String name){
		super(name);
	}
}