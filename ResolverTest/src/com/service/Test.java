package com.service;
import com.domain.Key;
import com.domain.Token;
import com.tag.Tag;

public class Test {
	char a='1';
	
	Tag tag ;
	

	public static void main(String args[]){
		DFA dfa = new DFA();

		//String aString = "a' ∈  person ∩ hhh\n c? ≠  person ∩ HHH";
		String str="ssss':aaa";

		String aString = "dom a ⊆ seq person ∪ ran boy";
		dfa.Scan(aString);
		Parse parse = new Parse(dfa);

		
		ReadID r = new ReadID();
		r.reader(str);
		System.out.println();

	}
}

