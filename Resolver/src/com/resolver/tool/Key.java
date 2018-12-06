

package com.resolver.tool;



//关键字表
public class Key{
	public Tag tag;
	
	public Key(){
		
	}
	
	//字符的判断和输出标签
	public  Tag getTag(char name){	
		switch(name){
			case '\n':
				return tag.NEWLINE;
			case ':':
				return tag.COLOM;
			case '∫':
				return tag.FIRST;
			case '∬':
				return tag.SECOND;
			case '∭':
				return tag.THIRD;
			case '{':
				return tag.LBRAC;
			case '}':
				return tag.RBRAC;
			case '?':
				return tag.QUESTIONMARK;
			case '=':
				return tag.EQUALITY;
			case '≠':
				return tag.NOTQUELITY;
			case '∈':
				return tag.BELONG;
			case '∉':
				return tag.NOTBELONG;
			case 'P':
				return tag.POWERSET;
			case 'F':
				return tag.FINITE;
			case '\'':
				return tag.SINGLEQUOTE;
			case ',':
				return tag.COMMA;
			case '(':
				return tag.COMMA;
			case ')':
				return tag.COMMA;
			case '∃':
				return tag.EXIST;
			case '∀':
				return tag.ALL;
			case '·':
				return tag.DOT;
			case '∪':
				return tag.UNION;
			case '∩':
				return tag.INTERSECTION;
			case'∅':
				return tag.EMPTY;
			case'⊆':
				return tag.SUBSET;
			
			case'!':
				return tag.EXCLAMATORY;
			default:
				return tag.ERR;
		}
		
	}
	//字符串的判断和输出标签
	public Tag getTag(String str){
		if(str.equals("dom")){
			return tag.DOM;
		}else if(str.equals("ran")){
			return tag.RAN;
		}else if(str.equals("==")){
			return tag.DOUBLEEQUALITY;
		}else if(str.equals("bag")){
			return tag.BAG;
		}else if(str.equals("seq")){
			return tag.SEQ;
		}
		else{
			return tag.ID;
		}
		
	}
}

