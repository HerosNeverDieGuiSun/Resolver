<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*,com.feedback.domain.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
%>
<jsp:directive.page import="java.util.List"/>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>反馈信息提交</title>

  <!-- Favicons -->
  <link href="<%=path%>/student/img/favicon.png" rel="icon">
  <link href="<%=path%>/student/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="<%=path%>/student/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="<%=path%>/student/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link href="<%=path%>/student/lib/bootstrap-wysihtml5/bootstrap-wysihtml5.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="<%=path%>/student/css/style.css" rel="stylesheet">
  <link href="<%=path%>/student/css/style-responsive.css" rel="stylesheet">

  <!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>
<section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right"></div>
      </div>
      <!--logo start-->
      <a href="index.html" class="logo"><b>学生端</b></a>
      <!--logo end-->
      
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" href="login.html">退出</a></li>
        </ul>
      </div>
    </header>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered"><a href="profile.html"><img src="<%=path%>/student/img/ui-sam.jpg" class="img-circle" width="80"></a></p>
          <h5 class="centered">小红</h5>
          
          <li class="mt">
            <a href="StudentInfo.jsp">
              <i class="fa fa-dashboard"></i>
              <span>个人信息</span>
              </a>
          </li>
		  <li class="mt">
            <a  href="MsgSubmit.jsp">
              <i class="fa fa-envelope"></i>
              <span>提交反馈</span>
              </a>
          </li>
		  <li class="mt">
            <a class="active" href = "./myfeedbackctrl">
              <i class="fa fa-envelope"></i>
              <span>查看反馈</span>
              </a>
          </li>
		  
          
          
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!-- page start-->
        <div class="row mt">
          <div class="col-sm-3">

          </div>
          <div class="col-sm-9a">
            <section class="panel">
              <header class="panel-heading wht-bg">
                <h4 class="gen-case">
                    学生反馈
                    <form action="#" class="pull-right mail-src-position">
                      <div class="input-append">
                        <input type="text" class="form-control " placeholder="搜索反馈">
                      </div>
                    </form>
                  </h4>
              </header>
              <div class="panel-body ">
                <div class="mail-header row">
                  <div class="col-md-8">
                    <h4 class="pull-left"></h4>
                  </div>
                  <div class="col-md-4">
                    <div class="compose-btn pull-right">
                      
                    </div>
                  </div>
                </div>
                <div class="mail-sender">
                  <div class="row">
                    <div class="col-md-8">
                      <img src="img/ui-zac.jpg" alt="">
                      <c:forEach var="feedback" items="${requestScope.concreteFeedback}">
                      <tr class="unread">
                      <td> ${feedback.sno}</td>
                      <td> ${feedback.ctno}</td>
                      <td> ${feedback.fbtime}</td>                    
                      </tr>
                      
                      
                      <strong></strong>
                    </div>
                    <div class="col-md-4">
                    </div>
                  </div>
                </div>
                <div class="view-mail">
                  <p> ${feedback.content}</p>
               </c:forEach>
                </div>
              </div>
            </section>
          </div>
        </div>
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
    
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="lib/jquery.scrollTo.min.js"></script>
  <script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="lib/common-scripts.js"></script>
  <!--script for this page-->

</body>

</html>
