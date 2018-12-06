package com.resolver.store;

import java.util.ArrayList;
import java.util.List;

import com.resolver.service.DFA;
import com.resolver.service.Parse;
import com.resolver.service.ReadID;
import com.resolver.tool.Count;
import com.resolver.tool.Token;
import com.resolver.tool.Trans;
import com.resolver.tool.Tag;

public class Store {
	List<Token> list;
	
	public Tag t ;
	public Trans Deal(String str){
		DFA dfa = new DFA();
		dfa.Scan(str);
		Parse parse = new Parse(dfa);
		Trans t = new Trans();
		t.setLine(str);
		t.setTrans(parse.restraint());
		return t;
		
	}
	
	public String Split(String str){
		ReadID r = new ReadID();
		String s=r.reader(str);
		return s;
	}
	public List<Token> ShowTokenList(String str){
		DFA dfa = new DFA();
		dfa.Scan(str);
		list = dfa.getTokenList();
		return list;
	}
	public List<Count> showCountList(String str){
		List<Count> listCount = new ArrayList<Count>();
		int countID=0;
		int countPF=0;
		int countDOMRAN=0;
		int countSEQ=0;
		int countSINGLEQUOTE=0;
		int countQUESTION=0;
		int countOther=0;
		DFA dfa = new DFA();
		dfa.Scan(str);
		List<Token> listTemp= dfa.getTokenList();
		for(int i=0;i<listTemp.size();i++){
			//System.out.println(listTemp.get(i).getTag());
			if(listTemp.get(i).getTag()==t.ID){
				countID=countID+1;
			}else if(listTemp.get(i).getTag()==t.POWERSET || listTemp.get(i).getTag()==t.FINITE){
				countPF=countPF+1;
			}else if(listTemp.get(i).getTag()==t.RAN || listTemp.get(i).getTag()==t.DOM){
				countDOMRAN=countDOMRAN+1;
			}else if(listTemp.get(i).getTag()==t.SEQ){
				countSEQ=countSEQ+1;
			}else if(listTemp.get(i).getTag()==t.SINGLEQUOTE){
				countSINGLEQUOTE=countSINGLEQUOTE+1;
			}else if(listTemp.get(i).getTag()==t.QUESTIONMARK){
				countQUESTION=countQUESTION+1;
			}else{
				countOther=countOther+1;
			}
		}
		//System.out.println("---countPF="+countPF);
		//System.out.println("---countSINGLEQUOTE="+countSINGLEQUOTE);
		System.out.println("countQUESTION="+countQUESTION);
		for(int i=0;i<7;i++){
			if(i==0){
				Count c=new Count();
				c.setName("ID");
				c.setNum(countID);
				listCount.add(c);
			}else if(i==1){
				Count c=new Count();
				c.setName("幂集类");
				c.setNum(countPF);
				listCount.add(c);
			}else if(i==2){
				Count c=new Count();
				c.setName("定义域值域");
				c.setNum(countDOMRAN);
				listCount.add(c);
			}else if(i==3){
				Count c=new Count();
				c.setName("序列");
				c.setNum(countSEQ);
				listCount.add(c);
			}else if(i==4){
				Count c=new Count();
				c.setName("后状态");
				c.setNum(countSINGLEQUOTE);
				listCount.add(c);
			}else if(i==5){
				Count c=new Count();
				c.setName("输入变量");
				c.setNum(countQUESTION);
				listCount.add(c);
			}else if(i==6){
				Count c=new Count();
				c.setName("操作符");
				c.setNum(countOther);
				listCount.add(c);
			}
			
		
		}
		return listCount;
	}
}
