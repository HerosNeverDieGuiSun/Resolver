<%@ page language="java" import="com.resolver.domain.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>解析结果-变量列表</title>
		<link rel="stylesheet" type="text/css" href="./semantic/out/semantic.min.css"/>
		<script src="./semantic/out/semantic.min.js"></script>
		<style type="text/css">
			.backimage {
				background-image: url("./images/background2.jpg");
				background-repeat: no-repeat;
				background-size: cover;
			}
		</style>
	</head>
	<body>
		<div class="backimage" style="height: 100%; width: 100%;">
			<div class="ui visible inverted left fixed vertical menu" style="opacity: 0.7;">
				<a class="active item" style="margin-top: 30%;" href="./variableList.jsp">
					<font size="3">属性列表</font>
				</a>
				<a class="item" href="./modelList.jsp">
					<font size="3">模式列表</font>
				</a>
				<a class="item" href="./statisticalGraph.jsp">
					<font size="3">统计信息</font>
				</a>
			</div>
			<div  style="margin-left: 11%; margin-top: 0%; height: 100%;">
				<font color="black">
					<h3>*变量(包括模式)*</h3>
				</font>
				<table class="ui celled table">
					<thead>
						<tr>
							<th>序号</th>
							<th>名称</th>
							<th>类型</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="l" items="${sessionScope.bigList }" varStatus="vs">
							<tr>
								<td>${vs.index+1 }</td>
								<td>${l.name}</td>
								<td>${l.tag}</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<th colspan="4">
								<div class="ui right floated pagination menu">
									<a class="icon item">
										<i class="left chevron icon"></i>
									</a>
									<a class="item">1</a>
									<a class="item">2</a>
									<a class="item">3</a>
									<a class="item">4</a>
									<a class="icon item">
										<i class="right chevron icon"></i>
									</a>
								</div>
							</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</body>
</html>
