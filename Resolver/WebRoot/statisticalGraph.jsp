<%@ page language="java" import="com.resolver.domain.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.resolver.tool.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>解析结果-统计信息</title>
		<link rel="stylesheet" type="text/css" href="./semantic/out/semantic.min.css"/>
		<link href="img/favicon.png" rel="icon"/>
		<link href="img/apple-touch-icon.png" rel="apple-touch-icon"/>

		<!-- Bootstrap core CSS -->
		<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
		<!--external css-->
		<link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet"/>
		<link rel="stylesheet" type="text/css" href="css/zabuto_calendar.css"/>
		<link rel="stylesheet" type="text/css" href="lib/gritter/css/jquery.gritter.css"/>
		<!-- Custom styles for this template -->
		<link href="css/style.css" rel="stylesheet"/>
		<link href="css/style-responsive.css" rel="stylesheet"/>
		<script src="lib/chart-master/Chart.js"></script>
		<script src="./semantic/out/semantic.min.js"></script>

		<script src="lib/sparkline-chart.js"></script>
		<script src="lib/zabuto_calendar.js"></script>
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
			<a class="item" style="margin-top: 30%;" href="./variableList.jsp">
				<font size="3">属性列表</font>
			</a>
			<a class="item" href="./modelList.jsp">
				<font size="3">模式列表</font>
			</a>
			<a class="active item" href="./statisticalGraph.jsp">
				<font size="3">统计信息</font>
			</a>
		</div>
		<section id="container">

			<section id="main-content">
				<section class="wrapper">
					<div class="row">
						<div class="col-lg-9 main-chart">
							<!--CUSTOM CHART START -->
							<div class="border-head">
								<h3>统计图表</h3>
							</div>

							<div class="custom-bar-chart">
								<ul class="y-axis">
									<li>
										<span>10</span>
									</li>
									<li>
										<span>8</span>
									</li>
									<li>
										<span>6</span>
									</li>
									<li>
										<span>4</span>
									</li>
									<li>
										<span>2</span>
									</li>
									<li>
										<span>0</span>
									</li>
								</ul>
								<c:forEach var="l" items="${sessionScope.countList }" varStatus="vs">
									<div class="bar">
										<div class="title">${l.name}</div>
										<div class="value tooltips" data-original-title="${l.num}" data-toggle="tooltip" data-placement="top">${l.proportion}</div>
									</div>
								</c:forEach>

							</div>

						</div>
						<!-- /col-lg-9 END SECTION MIDDLE -->
						<!-- ********************************************************************************************************************************************************** RIGHT SIDEBAR CONTENT
						*********************************************************************************************************************************************************** -->

					</div>
					<!-- /row -->
				</section>
			</section>
			<!--main content end-->
			<!--footer start-->

			<!--footer end-->
		</section>
	</div>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="lib/jquery/jquery.min.js"></script>

	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="lib/jquery.scrollTo.min.js"></script>
	<script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="lib/jquery.sparkline.js"></script>
	<!--common script for all pages-->
	<script src="lib/common-scripts.js"></script>
	<script type="text/javascript" src="lib/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="lib/gritter-conf.js"></script>

</body>
</html>
