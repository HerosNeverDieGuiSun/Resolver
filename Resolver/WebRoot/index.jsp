<%@ page language="java" import="com.resolver.domain.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.sql.*" %>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>首页</title>
		<link rel="stylesheet" type="text/css" href="./semantic/out/semantic.min.css"/>
		<link href="img/favicon.png" rel="icon"/>
		<link href="img/apple-touch-icon.png" rel="apple-touch-icon"/>

		<!-- Bootstrap core CSS -->
		<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
		<!--external css-->
		<link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet"/>
		<!-- Custom styles for this template -->
		<link href="css/style.css" rel="stylesheet"/>
		<link href="css/style-responsive.css" rel="stylesheet"/>
		<!-- blueimp Gallery styles -->
		<link rel="stylesheet" href="http://blueimp.github.io/Gallery/css/blueimp-gallery.min.css"/>
		<!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
		<link rel="stylesheet" href="lib/file-uploader/css/jquery.fileupload.css"/>
		<link rel="stylesheet" href="lib/file-uploader/css/jquery.fileupload-ui.css"/>
		<script src="./semantic/out/semantic.min.js"></script>
		<style type="text/css">
			.backimage {
				background-image: url("./images/background2.jpg");
				background-repeat: no-repeat;
				background-size: cover;
			}
			.txt {
				height: 40px;
				border: 1px solid #cdcdcd;
				width: 300px;
			}
			.file {
				position: absolute;
				height: 40px;
				filter: alpha(opacity:0);
				opacity: 0;
				width: 410px;
			}
			#uploadFile {
				display: flex;
				margin-top: 0.5%;
				margin-left: 32%;
			}
		</style>
	</head>

	<body>
		<div class="backimage" style="height: 100%; width: 100%;">
			<br>
				<center>
					<h1 style="margin-top: 10%">欢迎使用Z语言解析器</h1>
				</center>
				<div style="margin-left: 36%; margin-top: 5%;">
					<font size="4">请选择您要解析的Z语言文件：</font>
				</div>
				<div id="uploadFile">
					<form action="<%=path %>/InputTXT" method="POST" enctype="multipart/form-data">

						<!-- The fileinput-button span is used to style the file input field as button -->
						<span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</span>
						<span class="btn btn-success fileinput-button">
							<i class="glyphicon glyphicon-plus"></i>
							<span>添加文件</span>
							<input type="file" name="file"></span>
							<button type="submit" class="btn btn-theme start">
								<i class="glyphicon glyphicon-upload"></i>
								<span>开始上传</span>
							</button>
							<button type="reset" class="btn btn-theme02 cancel">
								<i class="glyphicon glyphicon-ban-circle"></i>
								<span>取消上传</span>
							</button>
							<button type="button" class="btn btn-theme04 delete">
								<i class="glyphicon glyphicon-trash"></i>
								<span>删除</span>
							</button>
						</form>
					</div>
				</div>
			</body>
		</html>
