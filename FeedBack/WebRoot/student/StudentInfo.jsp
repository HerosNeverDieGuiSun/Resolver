<%@ page language="java" import="com.feedback.domain.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.feedback.domain.Student" %>
<%@ page import="java.sql.*" %>
<%
	String path = request.getContextPath();
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr" >

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>Dashio - Bootstrap Admin Template</title>

  <!-- Favicons -->
  <link href="<%=path%>/student/img/favicon.png" rel="icon">
  <link href="<%=path%>/student/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="<%=path%>/student/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="<%=path%>/student/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="<%=path%>/student/css/style.css" rel="stylesheet">
  <link href="<%=path%>/student/css/style-responsive.css" rel="stylesheet">
  <script src="<%=path%>/js/jquery-3.3.1.js" type="text/javascript"></script>
  <script>
  	
		
		
  </script>
   

</head>

<body>
<c:set var="stu" value="${ sessionScope.student }"></c:set>


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
          <p class="centered"><a href="profile.html"><img src="<%=path%>/student/img/upload/${stu.getIco() }" class="img-circle" width="80"></a></p>
          <h5 class="centered">${stu.getSname()}</h5>
          
          
          <li class="mt">
            <a  class="active"  href="StudentInfo.html">
              <i class="fa fa-dashboard"></i>
              <span>个人信息</span>
              </a>
          </li>
		  <li class="mt">
             <a  href="MsgSubmit.html">
              <i class="fa fa-envelope"></i>
              <span>提交反馈</span>
              </a>
          </li>
		  <li class="mt">
            <a  href="MsgSubmit.html">
              <i class="fa fa-envelope"></i>
              <span>查看反馈回复</span>
              </a>
          </li>
		  
          
          
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
        <!--sidebar end-->
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    
    <section id="main-content">
      <section class="wrapper site-min-height">
        <div class="row mt">
          <div class="col-lg-12">
            <div class="row content-panel">
              <div class="col-md-4 profile-text mt mb centered">
                <div class="right-divider hidden-sm hidden-xs">
                  <h4>院系</h4>
                  <h5>软件学院</h5>
                  <h4>专业</h4>
                  <h5>软件工程</h5>
                  <h4>班级</h4>
                  <h5>${ stu.getCnname()}</h5>
                </div>
              </div>
              <!-- /col-md-4 -->
              
              <div class="col-md-4 profile-text">
              
                <h3>学生姓名：<b>${ stu.getSname() }</b></h3>
                <h4>学号：<b> ${stu.getSno() }</b></h4>
                
                <br>
                <!--
                <p><button class="btn btn-theme"><i class="fa fa-envelope"></i> Send Message</button></p>
                -->
              </div>
              <!-- /col-md-4 -->
              <div class="col-md-4 centered">
                <div class="profile-pic">
                  <p><img src="<%=path%>/student/img/upload/${stu.getIco() }" class="img-circle"></p>
                  <!--
                  <p>
                    <button class="btn btn-theme"><i class="fa fa-check"></i> Follow</button>
                    <button class="btn btn-theme02">Add</button>
                  </p>
                  -->
                </div>
              </div>
              <!-- /col-md-4 -->
            </div>
            <!-- /row -->
          </div>
          <!-- /col-lg-12 -->
          <div class="col-lg-12 mt">
            <div class="row content-panel">
              
              <!-- /panel-heading -->
              <div class="panel-body">
                <div class="tab-content">
                    <div id="edit" class="tab-pane active">
                      <div class="row">
                        <div class="col-lg-8 col-lg-offset-2 detailed">
                          <h4 class="mb">基本信息</h4>
                          <form role="form" class="form-horizontal">

                            <div class="form-group">
                              <label class="col-lg-2 control-label">姓名</label>
                              <div class="col-lg-6">
                                <input type="text" placeholder=" " id="c-name" class="form-control" value=${stu.getSname() }>
                              </div>
                            </div>
                            <div class="form-group">
                              <label class="col-lg-2 control-label">学号</label>
                              <div class="col-lg-6">
                                <input type="text" placeholder=" " id="lives-in" class="form-control" value="${stu.getSno() }">
                              </div>
							  
                            </div>
							<div class="form-group">
                              <label class="col-lg-2 control-label">自然班</label>
                              <div class="col-lg-6">
                                <input type="text" placeholder=" " id="c-name" class="form-control" value="${stu.getCnname() }">
                              </div>
                            </div>
                            
           
                          </form>
                        </div>
                        <div class="col-lg-8 col-lg-offset-2 detailed mt">
                          <h4 class="mb">详细信息</h4>
                          <fieldset>
                          <jsp:useBean id="stu" scope="request" class="com.feedback.domain.Student" />
                          	<form  action="<%=path%>/StudentCtrl/updateStudentInfo" method="post"  enctype="multipart/form-data" class="form-horizontal">
                          		
								<div class="form-group">
	                              <label class="col-lg-2 control-label">个人头像</label>
	                              <div class="profile-pic">
	                                <p><img src="<%=path%>/student/img/upload/${stu.getIco() }" class="img-circle"></p>
	                              </div>
	                              <div class="col-lg-6">
	                                <input type="file" name="uploudIco" class="file-pos">
	                              </div>
	                            </div>
	                            <div class="form-group">
	                              <label class="col-lg-2 control-label">密码</label>
	                              <div class="col-lg-6">
	                                <input type="text"  name="spsw" class="form-control" value="${stu.getSpsw() }">
	                              </div>
	                            </div>
	                            
	                            <div class="form-group">
	                              <div class="col-lg-offset-2 col-lg-10">
	                                <button class="btn btn-theme" type="submit" >保存</button>
	                                <button class="btn btn-theme04" type="button">清空</button>
	                                
	                                
	                              </div>
	                            </div>
	                      	
                          	</form>
                           <iframe id='frameFile' name='frameFile' style='display: none;'></iframe>
                          </fieldset>
                          
                        </div>
                        <!-- /col-lg-8 -->
                      </div>
                      <!-- /row -->
                    </div>
                    <!-- /tab-pane -->
                  
                  
                </div>
                <!-- /tab-content -->
              </div>
              <!-- /panel-body -->
            </div>
            <!-- /col-lg-12 -->
          </div>
          <!-- /row -->
        </div>
        <!-- /container -->
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
    <!--footer start-->
    
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="<%=path%>/student/lib/jquery/jquery.min.js"></script>
  <script src="<%=path%>/student/lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="<%=path%>/student/lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="<%=path%>/student/lib/jquery.scrollTo.min.js"></script>
  <script src="<%=path%>/student/lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="<%=path%>/student/lib/common-scripts.js"></script>
  <!--script for this page-->
  <!-- MAP SCRIPT - ALL CONFIGURATION IS PLACED HERE - VIEW OUR DOCUMENTATION FOR FURTHER INFORMATION -->
  
  
</body>

</html>
