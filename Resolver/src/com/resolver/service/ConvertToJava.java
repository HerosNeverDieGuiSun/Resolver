package com.resolver.service;

import java.util.Map;

public class ConvertToJava {
	
	public String generateClass(String type) {
		String str = "public class " + type + " {\n";
		return str;
	}
	
	public String upperCase(String str) {  
        char[] ch = str.toCharArray();  
        if (ch[0] >= 'a' && ch[0] <= 'z') {  
            ch[0] = (char) (ch[0] - 32);  
        }  
        return new String(ch);  
    }
	
	public String convert(Map<String, String> map) {
		String variable = "";
		String getAndSet = "";
		for (Map.Entry<String, String> entry : map.entrySet()) {
			variable = variable + "\tprivate " + entry.getValue() + " " + entry.getKey() + ";\n";
			getAndSet = getAndSet + "\tpublic " + entry.getValue() + " get" + upperCase(entry.getKey()) + "() {\n";
			getAndSet = getAndSet + "\t\t" + "return " + entry.getKey() + ";\n" + "\t}\n";
			getAndSet = getAndSet + "\tpublic void set" + upperCase(entry.getKey()) + "(" + entry.getValue() + " " + entry.getKey() + ") {\n";
			getAndSet = getAndSet + "\t\t" + "this." + entry.getKey() + " = " + entry.getKey() + ";\n" + "\t}\n";
		}
		return variable + getAndSet;
	}
}
