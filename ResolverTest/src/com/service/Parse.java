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
			if(tmp2.equals("���Ӽ�")){
				str = tmp1 + "��" + tmp3 + "���Ӽ�";
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
			str = "����";
			return str;
		}else if(token.getTag()==tag.NOTQUELITY){
			str = "������";
			return str;
		}else if(token.getTag()==tag.BELONG){
			str = "����";
			return str;
		}else if(token.getTag()==tag.NOTBELONG){
			str = "������";
			return str;
		}else if(token.getTag()==tag.SUBSET){
			str = "�Ӽ�";
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
		 
		Token token = nexttoken();

		if(token.getTag() == tag.DOM){
			t = nexttoken();
			if(t.getTag() == tag.ID){
				str = t.getName() + "�Ķ�����";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.RAN){
			t = nexttoken();
			if(t.getTag() == tag.ID){
				str = t.getName() + "��ֵ��";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.SEQ){
			t = nexttoken();
			if(t.getTag() == tag.ID){
				str =  "����"+t.getName();
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.BAG){
			t = nexttoken();
			if(t.getTag() == tag.ID){
				str =  "��"+t.getName();
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.POWERSET){
			t = nexttoken();
			if(t.getTag() == tag.ID){
				str =  t.getName() + "���ݼ�";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() == tag.FINITE){
			t = nexttoken();
			if(t.getTag() = tag.ID){
				str =  t.getName() + "�����޼�";
				return str;
			}else{
				return "ERROR";
			}
		}else if(token.getTag() = tag.ID){
			t = nexttoken();
			if(t.getTag() == tag.EXCLAMATORY){
				str =  t.getName() + "�����������";
				return str;
			}else if(t.getTag() == tag.QUESTIONMARK){
				str =  t.getName() + "�����������";
				return str;
			}else if(t.getTag() = tag.SINGLEQUOTE){
				str =  t.getName() + "����״̬��";
				return str;
			}else{
				str = t.getName();
				return str;
				save(t);//���ڶ�������token����������������һ�ε���token�ĺ���ʹ��
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
		Token token = nexttoken();
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
