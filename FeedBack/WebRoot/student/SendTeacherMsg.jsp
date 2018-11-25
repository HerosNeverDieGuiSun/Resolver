<%@ page language="java" import="java.util.*,com.feedback.domain.StudentCourse" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

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
            <a href="<%=basePath %>student/SendCollegeMsg.jsp">
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
          <div class="col-sm-9">
            <section class="panel">
              <header class="panel-heading wht-bg">
                <h4 class="gen-case">
                    学生反馈
                    <form action="#" class="pull-right mail-src-position">
                      <div class="input-append">
                        <input type="text" class="form-control " placeholder="查询历史反馈">
                      </div>
                    </form>
                  </h4>
              </header>
              <div class="panel-body">
                <div class="compose-mail">
                  <form action="../StudentCtrl/InsertTeacherFBCtrl" role="form-horizontal" method="post">
                  	<table align=center>
                  		<tr>
                  			<td></td>
                  			<td></td>
                  			<td></td>
                  		</tr>
                  		<c:forEach var="studentcourse" items="${requestScope.studentcourse}">
                      		<tr class="unread">
                      			
                     			 <td>学号: <input type="text" name="sno" class="form-control " value="${studentcourse.sno}"></td>
                     			 <td>课程名称: <input type="text" name="cname" class="form-control " value="${studentcourse.cname}"> </td>
                     			 <td>教学班号: <input type="text" name="ctno" class="form-control " value="${studentcourse.ctno}"></td>   
                     			 <td>老师: <input type="text" name="tname" class="form-control " value="${studentcourse.tname}"> </td>                 
                      		</tr>
               			</c:forEach>
                  	
                   	</table>
                    <div class="compose-editor">
                      <textarea name = "content"  class="form-control" rows="9"></textarea>
                    </div>
                    <div class="compose-btn">
                      <button class="btn btn-theme btn-sm" type="submit"><i class="fa fa-check"></i> 提交</button>
                     
                    </div>
                  </form>
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
    <!--footer start-->
    
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="<%=basePath %>student/lib/jquery/jquery.min.js"></script>
  <script src="<%=basePath %>student/lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="<%=basePath %>student/lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="<%=basePath %>student/lib/jquery.scrollTo.min.js"></script>
  <script src="<%=basePath %>student/lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="<%=basePath %>student/lib/common-scripts.js"></script>
  <!--script for this page-->
  <script type="text/javascript" src="<%=basePath %>student/lib/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
  <script type="text/javascript" src="<%=basePath %>student/lib/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>

  <script type="text/javascript">
    //wysihtml5 start

    $('.wysihtml5').wysihtml5();

    //wysihtml5 end
  </script>
</body>

</html>
