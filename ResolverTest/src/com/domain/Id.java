package com.domain;

import com.tag.Tag;

//��ʶ���Ǻ���
public class Id extends Token{
	public Id(Tag t) {
		super(t);
		
	}
	public String name;
	public Id(String name){
		super(name);
	}
}