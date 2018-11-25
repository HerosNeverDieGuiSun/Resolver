<%@ page language="java" import="com.feedback.domain.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.feedback.domain.Leader" %>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
  <title>超级管理员端</title>

  <!-- Favicons -->
  <link href="<%=path%>/superAdm/img/favicon.png" rel="icon">
  <link href="<%=path%>/superAdm/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="<%=path%>/superAdm/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="<%=path%>/superAdm/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="<%=path%>/superAdm/lib/bootstrap-fileupload/bootstrap-fileupload.css" />
  <link rel="stylesheet" type="text/css" href="<%=path%>/superAdm/lib/bootstrap-datepicker/css/datepicker.css" />
  <link rel="stylesheet" type="text/css" href="<%=path%>/superAdm/lib/bootstrap-daterangepicker/daterangepicker.css" />
  <link rel="stylesheet" type="text/css" href="<%=path%>/superAdm/lib/bootstrap-timepicker/compiled/timepicker.css" />
  <link rel="stylesheet" type="text/css" href="<%=path%>/superAdm/lib/bootstrap-datetimepicker/datertimepicker.css" />
  <!-- Custom styles for this template -->
  <link href="<%=path%>/superAdm/css/style.css" rel="stylesheet">
  <link href="<%=path%>/superAdm/css/style-responsive.css" rel="stylesheet">

  <!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
  <style>
	file{
		font-size:10px;
	}
  </style>
  <script type="text/javascript">
	function loadFile(file){
	   $("#filename").html(file.name);
	}
	function loadFile1(file){
		$("#filename1").html(file.name);
	}
	function loadFile2(file){
		  $("#filename2").html(file.name);
	}
	//触发模态框的同时调用此方法
	function editInfo(obj) {
		
		var tr = obj.parentNode.parentNode;
		
		//var id = document.getElementById("table").attr("id");
		//var id = $(obj).attr("id");
		//获取表格中的一行数据
		/*
		var stuno = document.getElementById("table").rows[id].cells[0].innerText;
		var pass = document.getElementById("table").rows[id].cells[1].innerText;
		var name = document.getElementById("table").rows[id].cells[2].innerText;
		var sex = document.getElementById("table").rows[id].cells[3].innerText;*/
		
		var leaderName = tr.cells[0].innerText;
		var leaderNumber = tr.cells[1].innerText;
		var leaderPassword = tr.cells[2].innerText;
		//window.alert(tr.cells[0]).innerText;*/
		//向模态框中传值
		$('#leader_name').val(leaderName);
		$('#leader_number').val(leaderNumber);
		$('#leader_password').val(leaderPassword);
		$('#leaderModal').modal('show');
	}
	
  </script>
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
      <a href="index.html" class="logo"><b>超级管理员端</b></a>
      <!--logo end-->
      
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" href="login.html">退出</a></li>
        </ul>
      </div>
    </header>
	<aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered"><a href="profile.html"><img src="<%=path%>/superAdm/img/wuyanzu.jpg" class="img-circle" width="80"></a></p>
          <h5 class="centered">小红</h5>
          
          <li class="mt">
            <a  href="TeacherInInfo.html">
              <i class="fa fa-dashboard"></i>
              <span>教师信息</span>
              </a>
          </li>
		  <li class="mt">
            <a  href="TeacherInInfo.html">
              <i class="fa fa-dashboard"></i>
              <span>学生信息</span>
              </a>
          </li>
		  <li class="mt">
            <a class="active" href="TeacherInInfo.html">
              <i class="fa fa-dashboard"></i>
              <span>领导信息</span>
              </a>
          </li>
		  <li class="mt">
            <a href="TeacherInInfo.html">
              <i class="fa fa-dashboard"></i>
              <span>管理员信息</span>
              </a>
          </li>
		  
		  
		  
          
          
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
   <section id="main-content">
      <section class="wrapper">
        <!-- row -->
        <div class="row mt">
          <div class="col-md-12">
            <div class="content-panel">
              <table class="table table-striped table-advance table-hover">
                <h4><i class="fa fa-angle-right"></i>领导信息</h4>
                <hr>
                <thead>
                  <tr>
                    <th><i class="fa fa-bullhorn"></i> 领导名字</th>
                    <th class="hidden-phone"><i class="fa fa-question-circle"></i> 领导工号</th>
                    <th><i class="fa fa-bookmark"></i> 领导密码</th>
                    <th><i class=" fa fa-edit"></i>操作 </th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="l" items="${requestScope.LeaderList }">
                  <tr>
                    <td>
                      <a href="basic_table.html#">${l.lname}</a>
                    </td>
                    <td class="hidden-phone">${l.lno}</td>
                    <td>${l.lpsw }</td>
                    <td class="hidden-phone">
                      <button type="button" class="btn btn-primary btn-xs" onclick="editInfo(this);" class="btn btn-info btn-xs" data-placement="top" title="修改"><i class="fa fa-pencil"></i></button>
                      <a href="<%=path%>/LeaderCtrl/DeleteLeader?lno=${l.lno}"><button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button></a>
                    </td>
                  </tr>
				 </c:forEach>
	           </tbody>
              </table>
            </div>
            <!-- /content-panel -->
          </div>
          <!-- /col-md-12 -->
        </div>
        
		<!-- 模态弹出窗 -->
		<div class="modal fade" id="leaderModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <!-- 标题栏 -->
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="exampleModalLabel">领导信息</h4>
			  </div>
			  <form method="POST" action="../LeaderCtrl/UpdateLeaderInfo">
			  <div class="modal-body">
				  <div class="form-group">
					<label for="recipient-name" class="control-label">姓名:</label>
					<input type="text" class="form-control" id="leader_name" name="leaderName">
				  </div>
				  <div class="form-group">
					<label for="message-text" class="control-label">工号:</label>
					<input type="text" class="form-control" id="leader_number" name="leaderNumber" readonly="readonly">
				  </div>
				  <div class="form-group">
					<label for="recipient-name" class="control-label">密码:</label>
					<input type="text" class="form-control" id="leader_password" name="leaderPassword">
				  </div>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<input type="submit" class="btn btn-primary" value="确认修改 "></submits>
			  </div>
			  </form>
			</div>
		  </div>
		</div>
		<hr>
		<div>
			<form:form method="post" action="../superAdm/LeaderInfoInputServlet" enctype="multipart/form-data">
				<div class="file-container" style="display:inline-block;position:relative;overflow: hidden;vertical-align:middle">
			        &nbsp;&nbsp;<button class="btn btn-info" type="button">上传文件</button>
			        <input type="file" name="file" id="jobData" onchange="loadFile2(this.files[0])" style="position:absolute;top:0;left:0;font-size:34px; opacity:0">
			    </div>
   				&nbsp;&nbsp;<span id="filename2" style="vertical-align: middle">未上传文件</span>
   				&nbsp;&nbsp;<button type="submit" class="btn btn-info">导入领导信息</button>			
			</form:form>
		</div>
        <!-- /row -->
      </section>
    </section>
	</section>
    <!--sidebar end-->
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="<%=path %>/superAdm/lib/jquery/jquery.min.js"></script>
  <script src="<%=path %>/superAdm/lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="<%=path %>/superAdm/lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="<%=path %>/superAdm/lib/jquery.scrollTo.min.js"></script>
  <script src="<%=path %>/superAdm/lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="<%=path %>/superAdm/lib/common-scripts.js"></script>
  <!--script for this page-->
  <script src="<%=path %>/superAdm/lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script type="text/javascript" src="<%=path %>/superAdm/lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
  <script type="text/javascript" src="<%=path %>/superAdm/lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script type="text/javascript" src="<%=path %>/superAdm/lib/bootstrap-daterangepicker/date.js"></script>
  <script type="text/javascript" src="<%=path %>/superAdm/lib/bootstrap-daterangepicker/daterangepicker.js"></script>
  <script type="text/javascript" src="<%=path %>/superAdm/lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
  <script type="text/javascript" src="<%=path %>/superAdm/lib/bootstrap-daterangepicker/moment.min.js"></script>
  <script type="text/javascript" src="<%=path %>/superAdm/lib/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
  <script src="<%=path %>/superAdm/lib/advanced-form-components.js"></script>

</body>

</html>
