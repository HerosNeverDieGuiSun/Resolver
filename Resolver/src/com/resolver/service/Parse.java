package com.resolver.service;


import com.resolver.tool.*;

public class Parse {
	public Tag tag;
	public Token token;
	public DFA dfa;
	
	public Parse(DFA dfa) {
		this.dfa = dfa; 
	}
	
	public String restraint(){
		String str = "";
		String tmp1 = "";
		String tmp2 = "";
		String tmp3 = "";
		tmp1 = exp();
		tmp2 = RelationalOperators();
		tmp3 = exp();
		
		if(tmp1.equals("ERROR")||tmp2.equals("ERROR")||tmp3.equals("ERROR")){
			return "ERROR";
		}
		else{
			if(tmp2.equals("是子集")){
				str = tmp1 + " 是 " + tmp3 + " 的子集";
			}else if(tmp2.equals("不是子集")){
				str = tmp1 + "不是" + tmp3 + "的子集";
			}else{
				str = tmp1 + tmp2 + tmp3;
			}
			return str;
		}
	}

	// 表达式
	public String exp() {
		String str = "";
		String variable = variable();
		if (variable.equals("ERROR")) {
			str = "ERROR";
		} else {
			str = str + variable;
		}
		
		String surplus = surplus();
		if (surplus.equals("ERROR")) {
			str = "ERROR";
		} else {
			str = str + surplus;
		}

		return str;
	}

	// 剩余部分
	public String surplus() {
		String str = "";
		Token token = dfa.getToken();
		if (token == null) return "";
		if (token.getTag() == tag.BELONG || 
				token.getTag() == tag.EQUALITY ||
				token.getTag() == tag.NOTBELONG ||
				token.getTag() == tag.NOTQUELITY ||
				token.getTag() == tag.NOTSUBSET ||
				token.getTag() == tag.SUBSET) {
			dfa.returnToken(token);
			return "";
		}
		dfa.returnToken(token);
		String operator = operator();
		if (operator.equals("ERROR")) {
			str = "ERROR";
		} else {
			str = str + operator;
		}
		String variable =  variable();
		if (variable.equals("ERROR")) {
			str = "ERROR";
		} else {
			str = str + variable;
		}

		return str;
	}

	public String RelationalOperators(){
		String str = "";
		token = dfa.getToken();
		if (token == null) return str;
		if(token.getTag()==tag.EQUALITY){
			str = "等于";
			return str;
		}else if(token.getTag()==tag.NOTQUELITY){
			str = "不等于";
			return str;
		}else if(token.getTag()==tag.BELONG){
			str = "属于集合";
			return str;
		}else if(token.getTag()==tag.NOTBELONG){
			str = "不属于";
			return str;
		}else if(token.getTag()==tag.SUBSET){
			str = "是子集";
			return str;
		}else if(token.getTag()==tag.NOTSUBSET){
			str = "不是子集";
			return str;
		}else{
			str = "ERROR";
			return str;
		}
	}

	public String variable(){
		String str = "";
		token = dfa.getToken();
		if (token == null) return "";
		if(token.getTag() == tag.DOM){
			Token t = dfa.getToken();
			if (t == null) return "";
			if(t.getTag() == tag.ID){
				str = t.getname() + "的定义域";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.RAN){
			Token t = dfa.getToken();
			if (t == null) return "";
			if(t.getTag() == tag.ID){
				str = t.getname() + "的值域";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.SEQ){
			Token t = dfa.getToken();
			if (t == null) return "";
			if(t.getTag() == tag.ID){
				str =  "序列"+t.getname();
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.BAG){
			Token t = dfa.getToken();
			if (t == null) return "";
			if(t.getTag() == tag.ID){
				str =  "包"+t.getname();
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.POWERSET){
			Token t = dfa.getToken();
			if (t == null) return "";
			if(t.getTag() == tag.ID){
				str =  t.getname() + "的幂集";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.FINITE){
			Token t = dfa.getToken();
			if (t == null) return "";
			if(t.getTag() == tag.ID){
				str =  t.getname() + "的有限集";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.ID){
			Token t = dfa.getToken();
			if (t == null) return token.getname();
			if(t.getTag() == tag.EXCLAMATORY){
				str =  token.getname() + "（输出变量）";
				return str;
			}else if(t.getTag() == tag.QUESTIONMARK){
				str =  token.getname() + "（输入变量）";
				return str;
			}else if(t.getTag() == tag.SINGLEQUOTE){
				str =  token.getname() + "（后状态）";
				return str;
			}else{
				str = token.getname();
				
				dfa.returnToken(t);//对于多读的这个token，保存起来，给下一次调用token的函数使用
				return str;
			}
			//对于空终结符该如何判别？
			/*
			else{
				return "ERROR";
			}
			*/
		}else if(token.getTag() == tag.EMPTY){
			str = "空集";
			return str;
		}else{
			return "ERROR";
		}
	}

	// 集合运算符
	public String operator() {
		Token token = dfa.getToken();
		if (token == null) return "";
		String str = "";
		if (token.getTag() == tag.UNION) {
			return str + "并";
		} else if (token.getTag() == tag.INTERSECTION) {
			return str + "交";
		} else {
			return "ERROR";
		}
	}
}
