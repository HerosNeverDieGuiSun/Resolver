package com.resolver.controller;
import java.util.List;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.resolver.service.ConvertToJava;
import com.resolver.service.ReadID;
import com.resolver.store.*;
import com.resolver.tool.Count;
import com.resolver.tool.Key;
import com.resolver.tool.Tag;
import com.resolver.tool.Token;
import com.resolver.tool.Trans;
@Controller
public class InputTXTController {
	
	@RequestMapping(value="/InputTXT",method=RequestMethod.POST)
	public String Input(MultipartFile file, Model model, HttpServletRequest request,HttpSession session){
		String UPLOAD_PATH = "upload/";
		System.out.println("Success into input");
		//设置上传目录
		String path=request.getServletContext().getRealPath(".");
		path += "/" + UPLOAD_PATH;
		File newfile = new File(path);
		if (!newfile.exists()) {
			newfile.mkdirs();
		}
		
		//修改文件名
		String filename = file.getOriginalFilename();
		String newname = System.currentTimeMillis() + "-" + filename;
		
		try {
			//保存到path下的名字为newname的文件
			file.transferTo(new File(path, newname));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//处理txt 文件
		
		System.out.println("处理文件开始");
		List<Token> bigList = new ArrayList<Token>();
		List<Trans> transList = new ArrayList<Trans>();
		List<Count> countList=new ArrayList<Count>();
		
		for(int i=0;i<7;i++){
			if(i==0){
				Count c=new Count();
				c.setName("ID");
				c.setNum(0);
				countList.add(c);
			}else if(i==1){
				Count c=new Count();
				c.setName("幂集类");
				c.setNum(0);
				countList.add(c);
			}else if(i==2){
				Count c=new Count();
				c.setName("定义域值域");
				c.setNum(0);
				countList.add(c);
			}else if(i==3){
				Count c=new Count();
				c.setName("序列");
				c.setNum(0);
				countList.add(c);
			}else if(i==4){
				Count c=new Count();
				c.setName("后状态");
				c.setNum(0);
				countList.add(c);
			}else if(i==5){
				Count c=new Count();
				c.setName("输入变量");
				c.setNum(0);
				countList.add(c);
			}else if(i==6){
				Count c=new Count();
				c.setName("操作符");
				c.setNum(0);
				countList.add(c);
			}
			
		
		}
		BufferedReader br = null;
		String line2="";
		Map<String, String> codeMap = new HashMap<String, String>();
		String classString="";
		try {
			FileInputStream fileInputStream = new FileInputStream(path+newname);
			System.out.println(path+newname);
			//BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
			InputStreamReader reader = new InputStreamReader(fileInputStream,"Unicode"); 
			br = new BufferedReader(reader); 
			classString= br.readLine();
			String line1 ="";
			ReadID readId = new ReadID();
			Store store = new Store();
			while((line1 = br.readLine()) != null){
				System.out.println(line1);
				if(readId.reader(line1)!=null && readId.readerLater(line1)!=null){
					codeMap.put(readId.reader(line1), readId.readerLater(line1));
				}
				
				transList.add(store.Deal(line1));
				bigList.addAll(store.ShowTokenList(line1));
				
				
				for(int j =0;j<7;j++){
					
					int n=store.showCountList(line1).get(j).getNum();
					int m=countList.get(j).getNum();
					int p=n+m;
					countList.get(j).setNum(p);
					//System.out.println("n="+n+" m="+m+" p="+p);
					//System.out.println(store.showCountList(line1).get(j).getName()+"==="+store.showCountList(line1).get(j).getNum());
				}
				
			}
			for(int j=0;j<7;j++){
				
				int n=countList.get(j).getNum();
				String s;
				if(n==0){
					 s=String.valueOf(n)+"%";
				}else{
					 s=String.valueOf(n)+"0%";
				}
				
				countList.get(j).setProportion(s);
				System.out.println("===="+countList.get(j).getName()+"|||"+countList.get(j).getProportion());
			}
		}catch(Exception e){ 
			e.printStackTrace();
		}finally{
			if(br != null){
				try{
					br.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				
			}
		}
		
		ConvertToJava convert = new ConvertToJava();
		String convertClass = convert.generateClass(classString);
		String body = convert.convert(codeMap);
		String finalJava = convertClass + body+"}";
		
		session.setAttribute("javacode", finalJava);
		session.setAttribute("bigList", bigList);
		session.setAttribute("transList", transList);
		session.setAttribute("countList",countList);
		
		
		Key key = new Key();
		Map<Tag, Integer> tag_map = new HashMap<Tag, Integer>();
		Map<Tag, Double> map = new HashMap<Tag, Double>();
		tag_map.put(key.getTag(':'), 100);
		tag_map.put(key.getTag('\n'), 100);
		int sum = 0;
		Iterator iter1 = tag_map.entrySet().iterator();
		while (iter1.hasNext()) {
			Map.Entry entry = (Map.Entry) iter1.next();
			int val = (int) entry.getValue();
			sum += val;
		}
		
		Iterator iter2 = tag_map.entrySet().iterator();
		while (iter2.hasNext()) {
			Map.Entry entry = (Map.Entry) iter2.next();
			int x = (int) entry.getValue();
			map.put((Tag) entry.getKey(), x*450.0/sum);			
		}
		System.out.println(sum);
		double h4 = map.get(key.getTag(':'));
		System.out.println(h4);
		session.setAttribute("tag_map", tag_map);
		session.setAttribute("key", key);
		session.setAttribute("map", map);	
		
		
		

		//return "index";
		return "variableList";

	}
}