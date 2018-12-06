
package com.resolver.tool;

//枚举标签
public enum Tag{
	ERR, //错误
	END, //文件结束标记
	ID,  //标识符
	COLOM,//冒号
	ADD,SUB,MUL,DIV,MOD,  //算术运算符
	FIRST,SECOND,THIRD,   //表示 ∫  ∬  ∭  三个层
	LBRAC,RBRAC, 		// 表示{}
	QUESTIONMARK,       //问号
	EQUALITY,NOTQUELITY,			//等号  , 不等号
	BELONG,NOTBELONG,	//属于  ， 不属于
	POWERSET,		//幂集
	SINGLEQUOTE,		//单引号
	NEWLINE,     //换行
	DOM,RAN,		//定义域，值域
	COMMA,		//逗号
	LBRACKET,RBRACKET,	//表示()
	DOUBLEEQUALITY,		//表示==
	DOT,					//圆点·
	EXIST,ALL,				//∃   ∀
	UNION,INTERSECTION,      // ∪    ∩
	FINITE,					// F
	SEQ,					//seq
	BAG,						//bag	
	EMPTY,				// 空集
	SUBSET,NOTSUBSET,		// 子集 , 不是子集
	EXCLAMATORY		// 感叹号

}