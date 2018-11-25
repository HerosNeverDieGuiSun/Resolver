<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>管理员端</title>

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
		
		var studentName = tr.cells[0].innerText;
		var studentNumber = tr.cells[1].innerText;
		var studentPassword = tr.cells[2].innerText;
		var studentClass = tr.cells[3].innerText;
		//window.alert(tr.cells[0]).innerText;
		//向模态框中传值
		
		$('#student_name').val(studentName);
		$('#student_number').val(studentNumber);
		$('#student_password').val(studentPassword);
		$('#student_class').val(studentClass);
		$('#exampleModal').modal('show');
		
	}
	function help(){
		$(function () {
	  		$('[data-toggle="popover"]').popover()
		});
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
      <a href="index.html" class="logo"><b>管理员端</b></a>
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
          <!-- 导入头像 -->
          <p class="centered"><a href="profile.html"><img src="<%=path %>/superAdm/img/wuyanzu.jpg" class="img-circle" width="80"></a></p>
          <!-- 导入用户名 -->
          <h5 class="centered">小红</h5>
          <li class="mt">
            <a href="TeacherInInfo.html">
              <i class="fa fa-dashboard"></i>
              <span>教师信息</span>
            </a>
          </li>
		      <li class="mt">
            <a class="active" href="TeacherInInfo.html">
              <i class="fa fa-dashboard"></i>
              <span>学生信息</span>
            </a>
          </li>
		      <li class="mt">
            <a href="TeacherInInfo.html">
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
        <div class="row">
        </div>
        <!-- row -->
        <div class="row mt">
          <div class="col-md-12">
            <div class="content-panel">
              <table class="table table-striped table-advance table-hover">
                <h4><i class="fa fa-angle-right"></i>学生信息</h4>
                <hr>
                <div class="row mt">
                	<div>
	                <form action="../StudentManageController/listAllStudentByPage">
					  	<div class="col-md-2">
					    	<input type="text" class="form-control" id="searchByName" name="classQuery">
					  	</div>
					  	<div class="col-md-1">
					  		<button type="submit" class="btn btn-default">搜索</button>
					  	</div>
					</form>
					  	<button type="button" class="btn btn-default" data-toggle="popover" title="使用说明：" data-content="在搜索框内以'条件':'内容'格式输入搜索内容，即可按照相应条件进行搜索。支持条件有'姓名'、'学号'、'专业班级'" onclick="help();">帮助</button>
					</div>
					
				</div>
                <thead>
                  <tr>
                    <th><i class="fa fa-bullhorn"></i> 学生名字</th>
                    <th class="hidden-phone"><i class="fa fa-question-circle"></i> 学号</th>
                    <th><i class="fa fa-bookmark"></i> 密码</th>
                    <th><i class="fa fa-edit"></i>专业班级</th>
                    <th><i class="fa fa-edit"></i>账户状态</th>
                    <th><i class="fa fa-edit"></i>操作</th>
                  </tr>
                </thead>
                <tbody>
                	
                  <c:forEach var="student" items="${requestScope.studentList}">
                  <tr>
                    <td><a href="basic_table.html#">${student.sname }</a></td>
                    <td class="hidden-phone">${student.sno}</td>
                    <td class="hidden-phone">${student.spsw}</td>
                    <td class="hidden-phone">${student.cnname }</td>
                    <td class="hidden-phone">${student.status==1?"正常":"冻结"}</td>
                    <td class="hidden-phone">
                      <button type="button" class="btn btn-primary btn-xs" onclick="editInfo(this);" class="btn btn-info btn-xs" data-placement="top" title="修改"><i class="fa fa-pencil"></i></button>
                      <a href="../StudentManageController/deleteStudent?sno=${student.sno }&page=${manageStudentQueryState.curPage}"><button class="btn btn-danger btn-xs" class="btn btn-info btn-xs" data-toggle="tooltip" data-placement="top" title="删除"><i class="fa fa-trash-o " ></i></button></a>
                      <c:choose>
                      <c:when test="${student.status==1}" >
                      	<a href="../StudentManageController/exchangeStudentStatus?sno=${student.sno }&newStatus=${1-student.status}&page=${manageStudentQueryState.curPage}"><button class="btn btn-info btn-xs" data-toggle="tooltip" data-placement="top" title="禁用"><i class="fa fa-ban " ></i></button></a>
                      </c:when>	
                      <c:otherwise>
                      	<a href="../StudentManageController/exchangeStudentStatus?sno=${student.sno }&newStatus=${1-student.status}&page=${manageStudentQueryState.curPage}"><button class="btn btn-info btn-xs" data-toggle="tooltip" data-placement="top" title="解封"><i class="fa fa-check-circle-o"></i></button></a>
                      </c:otherwise>
                      </c:choose>
                    </td>
                  </tr>
				  </c:forEach>
                </tbody>
              </table>
              <div class="col-md-12">
                <center>
                <nav aria-label="Page navigation">
                  <ul class="pagination">
                  <li>
                    <a href="../StudentManageController/listAllStudentByPage?page=prev" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <c:choose>
	                  <c:when test="${manageStudentQueryState.lastPage<6}">
		                  <c:forEach begin = "0" end = "${manageStudentQueryState.lastPage}"  step = "1" varStatus="pageIndex">
		                  	  <li><a href="../StudentManageController/listAllStudentByPage?page=${pageIndex.index}">${pageIndex.index+1}</a></li>
		                  </c:forEach>
	                  </c:when>
                  	  <c:otherwise>
                  		  <li><a href="../StudentManageController/listAllStudentByPage?page=0">1</a></li>
		                  <li><a href="#">...</a></li>
		                  <li><a href="#">${manageStudentQueryState.curPage+1}</a></li>
		                  <li><a href="#">...</a></li>
                  		  <li><a href=".../StudentManageController/listAllStudentByPage?page=${manageStudentQueryState.lastPage}">${manageStudentQueryState.lastPage+1}</a></li>
                  	  </c:otherwise>
                  </c:choose>
                  <li>
                    <a href="../StudentManageController/listAllStudentByPage?page=next" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    </a>
                  </li>
                  </ul>
                </nav>
              </center>
              </div>
            </div>
            <!-- /content-panel -->
          </div>
          <!-- /col-md-12 -->
        </div>
        <!-- 模态弹出窗 -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <!-- 标题栏 -->
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="exampleModalLabel">学生信息</h4>
			  </div>
			  <form method="POST" action="../StudentManageController/updateStudentInfo?page=${manageStudentQueryState.curPage}">
			  <div class="modal-body">
				  <div class="form-group">
					<label for="recipient-name" class="control-label">姓名:</label>
					<input type="text" class="form-control" id="student_name" name="studentName">
				  </div>
				  <div class="form-group">
					<label for="message-text" class="control-label">学号:</label>
					<input type="text" class="form-control" id="student_number" name="studentNumber" readonly="readonly">
				  </div>
				  <div class="form-group">
					<label for="recipient-name" class="control-label">密码:</label>
					<input type="text" class="form-control" id="student_password" name="studentPassword">
				  </div>
				  <div class="form-group">
					<label for="recipient-name" class="control-label">专业班级:</label>
					<input type="text" class="form-control" id="student_class" name="studentClass">
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
		<form>
          <div class="form-group">
            <input id="studentTableInput" name="studentInfoTable" type="file" type="file">
            <br/>
            <button type="submit" class="btn btn-default">导入</button>
          </div>
        </form>

        
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
