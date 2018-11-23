<%@ page language="java" import="com.feedback.domain.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.feedback.domain.*" %>
<%@ page import="java.sql.*" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>课表查询</title>

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link href="lib/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
  <link href="css/Schedule.css" rel="stylesheet">
  <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
  <script src="lib/Timetables.min.js"></script>
  
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
       <a href="index.html" class="logo"><b>教师端</b></a>
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
          <p class="centered"><a href="profile.html"><img src="img/wuyanzu.jpg" class="img-circle" width="80"></a></p>
          <h5 class="centered">小明</h5>
          
          <li class="mt">
            <a  href="TeacherInInfo.html">
              <i class="fa fa-dashboard"></i>
              <span>个人信息</span>
              </a>
          </li>
		  <li class="mt">
            <a  href="TeacherBox.html">
              <i class="fa fa-envelope"></i>
              <span>查看反馈</span>
              </a>
          </li>
		  <li class="mt">
            <a  href="Exams.html">
              <i class="fa fa-th"></i>
              <span>查看考试</span>
              </a>
          </li>
		  <li class="mt">
            <a   class="active" href="Schedule.html">
              <i class="fa fa-book"></i>
              <span>课表</span>
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
      <div id="coursesTable"></div>
        <script>
		  var courseList = [
		    ['大学英语(Ⅳ)@10203', '大学英语(Ⅳ)@10203', '', '', '', '', '毛概@14208', '毛概@14208', '', ''],
		    ['', '', '信号与系统@11302', '信号与系统@11302', '模拟电子技术基础@16204', '模拟电子技术基础@16204', '', '', '', ''],
		    ['大学体育(Ⅳ)', '大学体育(Ⅳ)', '形势与政策(Ⅳ)@15208', '形势与政策(Ⅳ)@15208', '', '', '电路、信号与系统实验', '电路、信号与系统实验', '', ''],
		    ['', '', '', '', '电装实习@11301', '电装实习@11301', '', '', ''],
		    ['', '', '数据结构与算法分析', '数据结构与算法分析', '', '', '', '', '信号与系统', '信号与系统'],
		  ];
		  var week = window.innerWidth > 360 ? ['周一', '周二', '周三', '周四', '周五','周六','周日'] :
		    ['一', '二', '三', '四', '五','六','七'];
		  var day = new Date().getDay();
		  var courseType = [
		    [{index: '1', name: '8:10'}, 1],
		    [{index: '2', name: '10:00'}, 1],
		    [{index: '3', name: '10:20'}, 1],
		    [{index: '4', name: '12:10'}, 1],
		    [{index: '5', name: '2:00'}, 1],
		    [{index: '6', name: '15:50'}, 1],
		    [{index: '7', name: '4:00'}, 1],
		    [{index: '8', name: '17:50'}, 1],
		    [{index: '9', name: '19:00'}, 1],
		    [{index: '10', name: '20:50'}, 1],
		    
		  ];
		  // 实例化(初始化课表)
		  var Timetable = new Timetables({
		    el: '#coursesTable',
		    timetables: courseList,
		    week: week,
		    timetableType: courseType,
		    highlightWeek: day,
		    gridOnClick: function (e) {
		      alert(e.name + '  ' + e.week + ', 第' + e.index + '节课, 课长' + e.length + '节');
		      console.log(e);
		    },
		    styles: {
		      Gheight: 50
		    }
		  });

 

		</script>
        <!-- page end-->
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
    <!--footer start-->
    
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script src="lib/fullcalendar/fullcalendar.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="lib/jquery.scrollTo.min.js"></script>
  <script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="lib/common-scripts.js"></script>
  <!--script for this page-->
  <script src="lib/calendar-conf-events.js"></script>
</body>

</html>
