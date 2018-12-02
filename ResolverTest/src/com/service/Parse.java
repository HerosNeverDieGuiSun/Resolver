package com.service;

import com.domain.Token;
import com.tag.*;

public class Parse {
	public Tag tag;
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
				str = tmp1 + "是" + tmp3 + "的子集";
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
		Token token = nexttoken();
		if(token.getTag()==tag.EQUALITY){
			str = "等于";
			return str;
		}else if(token.getTag()==tag.NOTQUELITY){
			str = "不等于";
			return str;
		}else if(token.getTag()==tag.BELONG){
			str = "属于";
			return str;
		}else if(token.getTag()==tag.NOTBELONG){
			str = "不属于";
			return str;
		}else if(token.getTag()==tag.SUBSET){
			str = "子集";
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
		 
		Token token = nexttoken();

		if(token.getTag() == tag.DOM){
			t = nexttoken();
			if(t.getTag() == tag.ID){
				str = t.getName() + "的定义域";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.RAN){
			t = nexttoken();
			if(t.getTag() == tag.ID){
				str = t.getName() + "的值域";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.SEQ){
			t = nexttoken();
			if(t.getTag() == tag.ID){
				str =  "序列"+t.getName();
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.BAG){
			t = nexttoken();
			if(t.getTag() == tag.ID){
				str =  "包"+t.getName();
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.POWERSET){
			t = nexttoken();
			if(t.getTag() == tag.ID){
				str =  t.getName() + "的幂集";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.FINITE){
			t = nexttoken();
			if(t.getTag() = tag.ID){
				str =  t.getName() + "的有限集";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() = tag.ID){
			t = nexttoken();
			if(t.getTag() == tag.EXCLAMATORY){
				str =  t.getName() + "（输出变量）";
				return str;
			}else if(t.getTag() == tag.QUESTIONMARK){
				str =  t.getName() + "（输入变量）";
				return str;
			}else if(t.getTag() = tag.SINGLEQUOTE){
				str =  t.getName() + "（后状态）";
				return str;
			}else{
				str = t.getName();
				return str;
				save(t);//对于多读的这个token，保存起来，给下一次调用token的函数使用
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
		Token token = nexttoken();
		String str = "";
		if (token.getTag() == tag.UNION) {
			return str + "交";
		} else if (token.getTag() == tag.INTERSECTION) {
			return str + "并";
		} else {
			return "ERROR";
		}
	}
}
