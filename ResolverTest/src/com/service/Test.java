package com.service;
import com.domain.Key;
import com.domain.Token;
import com.tag.Tag;

public class Test {
	char a='1';
	String str="ssss";
	Tag tag ;
	

	public static void main(String args[]){
		DFA dfa = new DFA();
		String aString = "a' ∈  person ∩ hhh";
		dfa.Scan(aString);
		Parse parse = new Parse(dfa);
		
		System.out.println(parse.restraint());

	}
}

