<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	function editInfo(obj,type) {
		
		var tr = obj.parentNode.parentNode;
		
		var teacherNumber = tr.cells[0].innerText;
		var teacherName = tr.cells[1].innerText;
		
		var teacherProfession = tr.cells[2].innerText;
		var teacherTelephone = tr.cells[3].innerText;

		//向模态框中传值
		$('#teacher_number').val(teacherNumber);
		$('#teacher_name').val(teacherName);
		$('#teacher_profession').val(teacherProfession);
		$('#teacher_telephone').val(teacherTelephone);
		
		if(type == "1" || type == 1){ //院内老师
			$("#updateTeacherInfoForm").attr("action", "./InputFileController/updateTeacherInInfo");
		}else if(type == "2" || type == 2){ //校内老师
			$("#updateTeacherInfoForm").attr("action", "./InputFileController/updateTeacherSchoolInfo");
		}else if(type == "3" || type == 3){ //外聘老师
			$("#updateTeacherInfoForm").attr("action", "./InputFileController/updateTeacherOutInfo");
		}
		
		$('#teacherModal').modal('show');
	}
	</script>
</head>

<body>
  <section id="container">
    <!--header start-->
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right"></div>
      </div>
      <!--logo start-->
      <a href="index.html" class="logo"><b>超级管理员</b></a>
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
            <a class="active" href="TeacherInInfo.html">
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
            <a  href="TeacherInInfo.html">
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
    
    <!--sidebar start-->
   <section id="main-content">
      <section class="wrapper">
        <!-- row -->
        <div class="row mt">
          <div class="col-md-12">
            <div class="content-panel">
              <table class="table table-striped table-advance table-hover">
                <h4><i class="fa fa-angle-right"></i>院内教师信息</h4>
                <hr>
                <thead>
                  <tr>
                    <th class="hidden-phone"><i class="fa fa-question-circle"></i> 教工号</th>
                    <th><i class="fa fa-bullhorn"></i> 教师名字</th>
                    <th><i class="fa fa-bookmark"></i> 职称</th>
                    <th><i class="fa fa-bookmark"></i> 联系电话</th>
                    <th><i class=" fa fa-edit"></i>操作 </th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
				  <c:forEach var="list" items="${ requestScope.teacherInList }">
				  	<tr>
				  		<td><a href="#">${ list.tino }</a></td>
	                    <td>${ list.tiname }</td>
	                    <td>${ list.tiprofession }</td>
	                    <td class="hidden-phone">${ list.title }</td>
	                    <td>
	                      <button onclick="editInfo(this,1);" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
	                      <a href="./InputFileController/deleteTeacherIn?tino=${list.tino }"><button class="btn btn-danger btn-xs" class="btn btn-info btn-xs" data-toggle="tooltip" data-placement="top" title="删除"><i class="fa fa-trash-o " ></i></button></a>
	                    </td>
				  	</tr>
				  </c:forEach>
               	</tbody>
             	</table>
             	<table class="table table-striped table-advance table-hover">
			        <tr>
			            <td align=center>
			                <a href='./DoPageTIServlet?page=0'>首 页</a>&nbsp;&nbsp;&nbsp;&nbsp;  
			                <a href='./DoPageTIServlet?page=prev'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			                <a href='./DoPageTIServlet?page=next'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			                <a href='./DoPageTIServlet?page=${requestScope.lastpageTI}'>末 页</a>
			            </td>
			        </tr>
			        <tr>
			        	<td align=center>当前第 ${ requestScope.curPageTI + 1 }页 / 共 ${ requestScope.lastpageTI + 1 }页 </td>
			        </tr>
   				</table>
   				<div>
					<form:form method="post" action="./superAdm/TeacherInfoInputServlet" enctype="multipart/form-data">
						<div class="file-container" style="display:inline-block;position:relative;overflow: hidden;vertical-align:middle">
					        &nbsp;&nbsp;<button class="btn btn-info" type="button">上传文件</button>
					        <input type="file" name="file" id="jobData" onchange="loadFile(this.files[0])" style="position:absolute;top:0;left:0;font-size:34px; opacity:0">
					    </div>
	    				&nbsp;&nbsp;<span id="filename" style="vertical-align: middle">未上传文件</span>
	    				&nbsp;&nbsp;<button type="submit" class="btn btn-info">导入院内教师信息</button>			
					</form:form>
				</div>
           	</div>
           
			
            <!-- /content-panel -->
          </div>
          
          <div class="col-md-12">
            <div class="content-panel">
              <table class="table table-striped table-advance table-hover">
                <h4><i class="fa fa-angle-right"></i>校内教师信息</h4>
                <hr>
                <thead>
                  <tr>
                    <th class="hidden-phone"><i class="fa fa-question-circle"></i> 教工号</th>
                    <th><i class="fa fa-bullhorn"></i> 教师名字</th>
                    <th><i class="fa fa-bookmark"></i> 职称</th>
                    <th><i class="fa fa-bookmark"></i> 联系电话</th>
                    <th><i class=" fa fa-edit"></i>操作 </th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
				  <c:forEach var="list" items="${ requestScope.teacherSchoolList }">
				  	<tr>
				  		<td><a href="#">${ list.tsno }</a></td>
	                    <td>${ list.tsname }</td>
	                    <td>${ list.tsprofession }</td>
	                    <td class="hidden-phone">${ list.tstel }</td>
	                    <td>
	                      <button onclick="editInfo(this,2);" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
						  <a href="./InputFileController/deleteTeacherSchool?tsno=${list.tsno }"><button class="btn btn-danger btn-xs" class="btn btn-info btn-xs" data-toggle="tooltip" data-placement="top" title="删除"><i class="fa fa-trash-o " ></i></button></a>
	                    </td>
				  	</tr>
				  </c:forEach>
               	</tbody>
             	</table>
             	<table class="table table-striped table-advance table-hover">
			        <tr>
			            <td align=center>
			                <a href='./DoPageTSServlet?page=0'>首 页</a>&nbsp;&nbsp;&nbsp;&nbsp;  
			                <a href='./DoPageTSServlet?page=prev'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			                <a href='./DoPageTSServlet?page=next'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			                <a href='./DoPageTSServlet?page=${requestScope.lastpageTS}'>末 页</a>
			            </td>
			        </tr>
			        <tr>
			        	<td align=center>当前第 ${ requestScope.curPageTS + 1 }页 / 共 ${ requestScope.lastpageTS + 1 }页 </td>
			        </tr>
   				</table>
   				<div>
					<form:form method="post" action="./superAdm/TeacherInfoInputServlet" enctype="multipart/form-data">
						<div class="file-container" style="display:inline-block;position:relative;overflow: hidden;vertical-align:middle">
					        &nbsp;&nbsp;<button class="btn btn-info" type="button">上传文件</button>
					        <input type="file" name="file" id="jobData" onchange="loadFile1(this.files[0])" style="position:absolute;top:0;left:0;font-size:34px; opacity:0">
					    </div>
	    				&nbsp;&nbsp;<span id="filename1" style="vertical-align: middle">未上传文件</span>
	    				&nbsp;&nbsp;<button type="submit" class="btn btn-info">导入校内教师信息</button>			
					</form:form>
				</div>
           	</div>
            <!-- /content-panel -->
          </div>
          
          <div class="col-md-12">
            <div class="content-panel">
              <table class="table table-striped table-advance table-hover">
                <h4><i class="fa fa-angle-right"></i>外聘教师信息</h4>
                <hr>
                <thead>
                  <tr>
                    <th class="hidden-phone"><i class="fa fa-question-circle"></i> 教工号</th>
                    <th><i class="fa fa-bullhorn"></i> 教师名字</th>
                    <th><i class="fa fa-bookmark"></i> 职称</th>
                    <th><i class="fa fa-bookmark"></i> 联系电话</th>
                    <th><i class=" fa fa-edit"></i>操作 </th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
				  <c:forEach var="list" items="${ requestScope.teacherOutList }">
				  	<tr>
				  		<td><a href="#">${ list.tono }</a></td>
	                    <td>${ list.toname }</td>
	                    <td>${ list.toprofession }</td>
	                    <td class="hidden-phone">${ list.totel }</td>
	                    <td>
	                      <button onclick="editInfo(this,3);" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
						  <a href="./InputFileController/deleteTeacherOut?tono=${list.tono }"><button class="btn btn-danger btn-xs" class="btn btn-info btn-xs" data-toggle="tooltip" data-placement="top" title="删除"><i class="fa fa-trash-o " ></i></button></a>
	                    </td>
				  	</tr>
				  </c:forEach>
               	</tbody>
             	</table>
             	<table class="table table-striped table-advance table-hover">
			        <tr>
			            <td align=center>
			                <a href='./DoPageTOServlet?page=0'>首 页</a>&nbsp;&nbsp;&nbsp;&nbsp;  
			                <a href='./DoPageTOServlet?page=prev'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			                <a href='./DoPageTOServlet?page=next'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			                <a href='./DoPageTOServlet?page=${requestScope.lastpageTO}'>末 页</a>
			            </td>
			        </tr>
			        <tr>
			        	<td align=center>当前第 ${ requestScope.curPageTO + 1 }页 / 共 ${ requestScope.lastpageTO + 1 }页 </td>
			        </tr>
   				</table>
   				<div>
					<form:form method="post" action="./superAdm/TeacherInfoInputServlet" enctype="multipart/form-data">
						<div class="file-container" style="display:inline-block;position:relative;overflow: hidden;vertical-align:middle">
					        &nbsp;&nbsp;<button class="btn btn-info" type="button">上传文件</button>
					        <input type="file" name="file" id="jobData" onchange="loadFile2(this.files[0])" style="position:absolute;top:0;left:0;font-size:34px; opacity:0">
					    </div>
	    				&nbsp;&nbsp;<span id="filename2" style="vertical-align: middle">未上传文件</span>
	    				&nbsp;&nbsp;<button type="submit" class="btn btn-info">导入外聘教师信息</button>			
					</form:form>
				</div>
				<!-- 模态弹出窗 -->
				<div class="modal fade" id="teacherModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
				  <div class="modal-dialog" role="document">
					<div class="modal-content">
					  <!-- 标题栏 -->
					  <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="exampleModalLabel">老师信息</h4>
					  </div>
					  <form method="POST" id="updateTeacherInfoForm" name="updateTeacherInfoForm" action="../StudentManageController/updateStudentInfo?page=${manageStudentQueryState.curPage}">
					  <div class="modal-body">
						  <div class="form-group">
							<label for="recipient-name" class="control-label">教工号:</label>
							<input type="text" class="form-control" id="teacher_number" name="teacherNumber"  readonly="readonly">
						  </div>
						  <div class="form-group">
							<label for="message-text" class="control-label">教师姓名:</label>
							<input type="text" class="form-control" id="teacher_name" name="teacherName">
						  </div>
						  <div class="form-group">
							<label for="message-text" class="control-label">职称:</label>
							<input type="text" class="form-control" id="teacher_profession" name="teacherProfession">
						  </div>
						  <div class="form-group">
							<label for="recipient-name" class="control-label">联系电话:</label>
							<input type="text" class="form-control" id="teacher_telephone" name="teacherTelephone">
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
           	</div>
            <!-- /content-panel -->
          </div>
          
          <!-- /col-md-12 -->
        </div>
        <!-- /row -->
      </section>
   	</section>
</section>
    <!--sidebar end-->
    
    <!--main content start-->
    
	  <!-- js placed at the end of the document so the pages load faster -->
	  <script src="<%=path%>/superAdm/lib/jquery/jquery.min.js"></script>
	  <script src="<%=path%>/superAdm/lib/bootstrap/js/bootstrap.min.js"></script>
	  <script class="include" type="text/javascript" src="<%=path%>/superAdm/lib/jquery.dcjqaccordion.2.7.js"></script>
	  <script src="<%=path%>/superAdm/lib/jquery.scrollTo.min.js"></script>
	  <script src="<%=path%>/superAdm/lib/jquery.nicescroll.js" type="text/javascript"></script>
	  <!--common script for all pages-->
	  <script src="<%=path%>/superAdm/lib/common-scripts.js"></script>
	  <!--script for this page-->
	  <script src="<%=path%>/superAdm/lib/jquery-ui-1.9.2.custom.min.js"></script>
	  <script type="text/javascript" src="<%=path%>/superAdm/lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
	  <script type="text/javascript" src="<%=path%>/superAdm/lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	  <script type="text/javascript" src="<%=path%>/superAdm/lib/bootstrap-daterangepicker/date.js"></script>
	  <script type="text/javascript" src="<%=path%>/superAdm/lib/bootstrap-daterangepicker/daterangepicker.js"></script>
	  <script type="text/javascript" src="<%=path%>/superAdm/lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
	  <script type="text/javascript" src="<%=path%>/superAdm/lib/bootstrap-daterangepicker/moment.min.js"></script>
	  <script type="text/javascript" src="<%=path%>/superAdm/lib/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
	  <script src="<%=path%>/superAdm/lib/advanced-form-components.js"></script>

</body>
</html>
