<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*,com.feedback.domain.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
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
  <link href="<%=basePath %>student/img/favicon.png" rel="icon">
  <link href="<%=basePath %>student/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="<%=basePath %>student/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="<%=basePath %>student/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link href="<%=basePath %>student/lib/bootstrap-wysihtml5/bootstrap-wysihtml5.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="<%=basePath %>student/css/style.css" rel="stylesheet">
  <link href="<%=basePath %>student/css/style-responsive.css" rel="stylesheet">

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
          <p class="centered"><a href="profile.html"><img src="<%=basePath %>student/img/ui-sam.jpg" class="img-circle" width="80"></a></p>
          <h5 class="centered">小红</h5>
          
          <li class="mt">
            <a href="<%=basePath %>student/StudentInfo.html">
              <i class="fa fa-dashboard"></i>
              <span>个人信息</span>
              </a>
          </li>
		  <li class="mt">
            <a  href="<%=basePath %>student/SendCollegeMsg.jsp">
              <i class="fa fa-envelope"></i>
              <span>提交关于学院的反馈</span>
              </a>
          </li>
          <li class="mt">
             <a  href="../StudentCtrl/SelectStudentCourseCtrl">
              <i class="fa fa-envelope"></i>
              <span>提交关于老师的反馈</span>
              </a>
          </li>
		  <li class="mt">
            <a  href="<%=basePath %>student/MsgSubmit.jsp">
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
      <section class="wrapper">
        <!-- page start-->
        <div class="row mt">
          <div class="col-sm-9a">
            <section class="panel">
              <header class="panel-heading wht-bg">
                <h4 class="gen-case">
                    教学班
                    <form action="#" class="pull-right mail-src-position">
                      <div class="input-append">
                        <input type="text" class="form-control " placeholder="搜索意见">
                      </div>
                    </form>
                  </h4>
              </header>
              <div class="panel-body minimal">
                <div class="mail-option">
                  <div class="chk-all">
                    <div class="pull-left mail-checkbox">
                      <input type="checkbox" class="">
                    </div>
                    <div class="btn-group">
                      <a data-toggle="dropdown" href="#" class="btn mini all">
                        全部
                        <i class="fa fa-angle-down "></i>
                        </a>
                      <ul class="dropdown-menu">
                        <li><a href="#"> 已读</a></li>
                        <li><a href="#"> 未读</a></li>
                      </ul>
                    </div>
                  </div>
                  <div class="btn-group">
                    <a data-original-title="Refresh" data-placement="top" data-toggle="dropdown" href="#" class="btn mini tooltips">
                      <i class=" fa fa-refresh"></i>
                      </a>
                  </div>
                  <div class="btn-group hidden-phone">
                    <a data-toggle="dropdown" href="#" class="btn mini blue">
                      操作
                      <i class="fa fa-angle-down "></i>
                      </a>
                    <ul class="dropdown-menu">
                      <li><a href="#"><i class="fa fa-pencil"></i> 标记为已读</a></li>
                      <li><a href="#"><i class="fa fa-ban"></i> 标记为未处理</a></li>
                      <li class="divider"></li>
                      <li><a href="#"><i class="fa fa-trash-o"></i> 删除</a></li>
                    </ul>
                  </div>               
                  <ul class="unstyled inbox-pagination">
                    <li><span>1-50 of 99</span></li>
                    <li>
                      <a class="np-btn" href="#"><i class="fa fa-angle-left  pagination-left"></i></a>
                    </li>
                    <li>
                      <a class="np-btn" href="#"><i class="fa fa-angle-right pagination-right"></i></a>
                    </li>
                  </ul>
                </div>
                <div class="table-inbox-wrap ">
                  <table class="table table-inbox table-hover">
                    <tbody>                     
                      <tr class="unread">
                        <td class="view-message">学号</td>
                        <td class="view-message">课程名</td>
                        <td class="view-message">教学班号</td>
                        <td class="view-message">老师</td>
                      </tr>
                      <c:forEach var="studentcourse" items="${requestScope.listsc}">
                      <tr class="unread">
                      <td> ${studentcourse.sno}</td>
                      <td> ${studentcourse.cname}</td>
                      <td> ${studentcourse.ctno}</td>
                      <td> ${studentcourse.tname}</td>
                      <form action='../StudentCtrl/ViewContentCtrl' method="POST">
                     	<input type = hidden name='sno' value=${studentcourse.sno}>
                     	<input type = hidden name='cname' value=${studentcourse.cname}>
                      	<input type = hidden name='ctno' value=${studentcourse.ctno}>
                      	<input type = hidden name='tname' value=${studentcourse.tname}>
                      <td> <input type=submit value="提交反馈"></td>
                      </form>
                      </tr>
                      </c:forEach >
                    </tbody>
                  </table>
                  <p align = "center">
         				<a href='./SelectScCtrl?page=0'>首 页</a> 
         				<a href='./SelectScCtrl?page=prev'>上一页</a>
          
         				<a href='./SelectScCtrl?page=next'>下一页</a>
         				<a href='./SelectScCtrl?page=${requestScope.lastPage}'>末 页</a>
    			  </p>  
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
