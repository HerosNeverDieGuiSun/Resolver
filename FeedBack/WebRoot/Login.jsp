<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>登录</title>

  <!-- Favicons -->
  <link href="<%=path%>/img/favicon.png" rel="icon">
  <link href="<%=path%>/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="<%=path%>/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="<%=path%>/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="<%=path%>/css/style.css" rel="stylesheet">
  <link href="<%=path%>/css/style-responsive.css" rel="stylesheet">
  
  <!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>
  <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
  <div id="login-page">
    <div class="container">
      <form:form class="form-login" action="./LoginServlet" method="post">
        <h2 class="form-login-heading">登录</h2>
        <div class="login-wrap">
          <input type="text" class="form-control" name="usern" placeholder="用户名"></input>
          <br>
          <input type="password" class="form-control" name="userp" placeholder="密码"></input>
          <span style="color:red;font-size:20px;text-align:center;">${usererror}</span>
          <label class="checkbox" >
			<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <input type="checkbox" value="remember-me"> 记住密码
            <span class="pull-right">
            <a data-toggle="modal" href="login.html#myModal"> 忘记密码?</a>
            </span>
            </label>
          <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> 登录</button>
          <hr>
        </div>
        <!-- Modal -->
        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">忘记密码 ?</h4>
              </div>
              <div class="modal-body">
                <p>请去翡翠科教楼b座903联系尹老师</p>
              </div>
            </div>
          </div>
        </div>
        <!-- modal -->
      </form:form>
    </div>
  </div>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="<%=path%>/lib/jquery/jquery.min.js"></script>
  <script src="<%=path%>/lib/bootstrap/js/bootstrap.min.js"></script>
  <!--BACKSTRETCH-->
  <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
  <script type="text/javascript" src="<%=path%>/lib/jquery.backstretch.min.js"></script>
  <script>
    $.backstretch("img/login-bg.jpg", {
      speed: 500
    });
  </script>
</body>
</html>
