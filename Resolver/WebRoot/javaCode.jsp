<%@ page language="java" import="com.resolver.domain.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
	<title>解析结果-生成Java代码</title>
	<link rel="stylesheet" type="text/css" href="./semantic/out/semantic.min.css">
	<script src="./semantic/out/semantic.min.js"></script>
    <style type="text/css">
        .backimage{
            background-image: url(./images/background2.jpg);
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
</head>
<body> 
    <div class="backimage" style="height: 100%; width: 100%;">
        <div class="ui visible inverted left fixed vertical menu" style="opacity: 0.7;">
            <a class="item" style="margin-top: 30%;" href="./variableList.jsp"><font size="3">属性列表</font></a>
            <a class="item" href="./modelList.jsp"><font size="3">模式列表</font></a>
            <a class="item" href="./statisticalGraph.jsp"><font size="3">统计信息</font></a> 
            <a class="active item" href="./javaCode.jsp"><font size="3">生成代码</font></a>
        </div>
        <div class="ui raised segment" style="margin-left: 11%; margin-top: 0%; height: 100%;">
            <font color="black"><h3>*生成Java代码*</h3></font>
            <div class="field">
                <textarea  style="margin-top: 2.2%; margin-left: 2.3%; height: 730px; width: 96%;">${s3}</textarea>
            </div> 
        </div>
    </div>
</body>
</html>
