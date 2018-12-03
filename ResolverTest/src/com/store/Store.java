package com.store;
import com.domain.*;
import com.service.*;
import com.tag.*;

public class Store {
	
	public String Deal(String str){
		DFA dfa = new DFA();
		dfa.Scan(str);
		Parse parse = new Parse(dfa);
		return parse.restraint();
	}
	public String Split(String str){
		ReadID r = new ReadID();
		String s=r.reader(str);
		return s;
	}
}
