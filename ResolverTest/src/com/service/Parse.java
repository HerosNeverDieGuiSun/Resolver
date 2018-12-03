package com.service;

import com.domain.Token;
import com.tag.*;

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
			if(tmp2.equals("���Ӽ�")){
				str = tmp1 + " �� " + tmp3 + " ���Ӽ�";
			}else if(tmp2.equals("�����Ӽ�")){
				str = tmp1 + "����" + tmp3 + "���Ӽ�";
			}else{
				str = tmp1 + tmp2 + tmp3;
			}
			return str;
		}
	}

	// ���ʽ
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

	// ʣ�ಿ��
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
			str = "����";
			return str;
		}else if(token.getTag()==tag.NOTQUELITY){
			str = "������";
			return str;
		}else if(token.getTag()==tag.BELONG){
			str = "���ڼ���";
			return str;
		}else if(token.getTag()==tag.NOTBELONG){
			str = "������";
			return str;
		}else if(token.getTag()==tag.SUBSET){
			str = "���Ӽ�";
			return str;
		}else if(token.getTag()==tag.NOTSUBSET){
			str = "�����Ӽ�";
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
				str = t.getname() + "�Ķ�����";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.RAN){
			Token t = dfa.getToken();
			if (t == null) return "";
			if(t.getTag() == tag.ID){
				str = t.getname() + "��ֵ��";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.SEQ){
			Token t = dfa.getToken();
			if (t == null) return "";
			if(t.getTag() == tag.ID){
				str =  "����"+t.getname();
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.BAG){
			Token t = dfa.getToken();
			if (t == null) return "";
			if(t.getTag() == tag.ID){
				str =  "��"+t.getname();
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.POWERSET){
			Token t = dfa.getToken();
			if (t == null) return "";
			if(t.getTag() == tag.ID){
				str =  t.getname() + "���ݼ�";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.FINITE){
			Token t = dfa.getToken();
			if (t == null) return "";
			if(t.getTag() == tag.ID){
				str =  t.getname() + "�����޼�";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.ID){
			Token t = dfa.getToken();
			if (t == null) return token.getname();
			if(t.getTag() == tag.EXCLAMATORY){
				str =  token.getname() + "�����������";
				return str;
			}else if(t.getTag() == tag.QUESTIONMARK){
				str =  token.getname() + "�����������";
				return str;
			}else if(t.getTag() == tag.SINGLEQUOTE){
				str =  token.getname() + "����״̬��";
				return str;
			}else{
				str = token.getname();
				
				dfa.returnToken(t);//���ڶ�������token����������������һ�ε���token�ĺ���ʹ��
				return str;
			}
			//���ڿ��ս��������б�
			/*
			else{
				return "ERROR";
			}
			*/
		}else if(token.getTag() == tag.EMPTY){
			str = "�ռ�";
			return str;
		}else{
			return "ERROR";
		}
	}

	// ���������
	public String operator() {
		Token token = dfa.getToken();
		if (token == null) return "";
		String str = "";
		if (token.getTag() == tag.UNION) {
			return str + "��";
		} else if (token.getTag() == tag.INTERSECTION) {
			return str + "��";
		} else {
			return "ERROR";
		}
	}
}
