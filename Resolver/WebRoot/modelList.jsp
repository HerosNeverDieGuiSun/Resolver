<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.sql.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>解析结果-模式列表</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<meta name="description" content=""/>
		<meta name="author" content="Dashboard"/>
		<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina"/>
		<!-- Bootstrap core CSS -->
		<link href="<%=path%>/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
		<!--external css-->
		<link rel="stylesheet" type="text/css" href="<%=path%>/lib/bootstrap-fileupload/bootstrap-fileupload.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path%>/lib/bootstrap-datepicker/css/datepicker.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path%>/lib/bootstrap-daterangepicker/daterangepicker.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path%>/lib/bootstrap-timepicker/compiled/timepicker.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path%>/lib/bootstrap-datetimepicker/datertimepicker.css"/>
		<link rel="stylesheet" type="text/css" href="./semantic/out/semantic.min.css"/>
		<script src="./semantic/out/semantic.min.js"></script>
		<style type="text/css">
			.backimage {
				background-image: url("./images/background2.jpg");
				background-repeat: no-repeat;
				background-size: cover;
			}
		</style>
		<script type="text/javascript">
			//触发模态框的同时调用此方法
			function showJavaCode(obj) {
				//从session中获取后台生成并传过来的java代码 暂时测试使用 var javaCode = "var stuno = document.getElementById('table').\n rows[id].cells[0].innerText;" $('#codeArea').val(javaCode);

				$('#exampleModal').modal('show');

			}
		</script>
	</head>
	<c:set var="code" value="${sessionScope.javacode}"/>
<body>
	<div class="backimage" style="height: 100%; width: 100%;">
		<div class="ui  inverted left fixed vertical menu" style="opacity: 0.7;">
			<a class="item" style="margin-top: 30%;" href="./variableList.jsp">
				<font size="3">属性列表</font>
			</a>
			<a class="active item" href="./modelList.jsp">
				<font size="3">模式列表</font>
			</a>
			<a class=" item" href="./statisticalGraph.jsp">
				<font size="3">统计信息</font>
			</a>
		</div>
		
		<div  style="margin-left: 11%; margin-top: 0%; height: 100%;">
			<font color="black">
				<h3>*模式*</h3>
			</font>
			<div class="ui inverted relaxed divided list">
				<table class="ui celled table">
					<thead>
						<tr>
							<th>序号</th>
							<th>原句</th>
							<th>译句</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="l" items="${sessionScope.transList }" varStatus="vs">
							<tr>
								<td>${vs.index+1 }</td>
	
								<td>${l.line}</td>
								<td>${l.trans}</td>
	
							</tr>
						</c:forEach>
						<tbody>
							<tfoot>
								<tr>
									<th colspan="3">
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
						</tbody>
					</tbody>
				</table>
				<center>
					<button type="submit" class="btn btn-primary" onclick="showJavaCode(this);">生成Java代码</button>
				</center>
			</div>
		</div>
	
		<!-- 模态弹出窗 -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<!-- 标题栏 -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">Java代码</h4>
				</div>
				<form method="POST" action="">
					<div class="modal-body">
						<div class="form-group">
							<textarea class="form-control" rows="20" id="codeArea">${sessionScope.javacode}</textarea>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<%=path %>/lib/jquery/jquery.min.js"></script>
	<script src="<%=path %>/lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="<%=path %>/lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="<%=path %>/lib/jquery.scrollTo.min.js"></script>
	<script src="<%=path %>/lib/jquery.nicescroll.js" type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="<%=path %>/lib/common-scripts.js"></script>
	<!--script for this page-->
	<script src="<%=path %>/lib/jquery-ui-1.9.2.custom.min.js"></script>
	<script type="text/javascript" src="<%=path %>/lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
	<script type="text/javascript" src="<%=path %>/lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="<%=path %>/lib/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript" src="<%=path %>/lib/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script type="text/javascript" src="<%=path %>/lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="<%=path %>/lib/bootstrap-daterangepicker/moment.min.js"></script>
	<script type="text/javascript" src="<%=path %>/lib/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
	<script src="<%=path %>/lib/advanced-form-components.js"></script>
	
</body>
</html>
