<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>后台管理系统</title>
    <meta name="description" content="这是一个电商后台网站，这里应有尽有，只有你想，就有卖">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/fontastic.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/dibutexiao.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.default.css" id="theme-stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/custom.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/img/favicon.ico">
     <script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin/manage.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin/bootstrap.min.css">
	<script src="${pageContext.request.contextPath }/js/admin/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/admin/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath }/js/admin/bootbox.min.js"></script>
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
  <script type="text/javascript">
	 $(function(){
		  var count = 0;
		  var pagesVal = $(".pages").val();
		  maxAdmin();
		  pageNumber();
		  query(pagesVal);
		  $("#cb").click(function(){
			  query(1);
		  });
		//查询有多少笔数据
		function maxAdmin(){
			 $.ajax({
				url:"${pageContext.request.contextPath}/baseservice/CountAdminServlet",
				async:false,
				type:"post",
				success:function(data){
					count = Math.ceil(eval(data)/1);
				}
			}) 
			//post方法无法给全局变量赋值
			 /* $.post("${pageContext.request.contextPath}/baseservice/CountAdminServlet",function(data){
				//data=eval(data);
				count=data;
			}); */
		}
		 function query(pagesVal){
				  
			  var param = {
					  changePage:pagesVal
			  }
			  $.post("${pageContext.request.contextPath}/admin/AdminInfoServlet",param,function(data){
				  data = eval(data);
				  var table = "<table id='tb' class='table'> <thead><tr><th>工号</th><th>用户名</th>"+
				  "<th>密码</th><th>使用人</th><th>修改状态</th><th>删除</th><th>更改</th></tr></thead><tbody id='show_tbody'>";
				  var td = "";
				  for (var i = 0; i < data.length; i++) {
					var state = "";
					if(data[i].state == 1 || data[i].state == "1"){
						state = "<a href='"+data[i].adminId+"' id='stop'>停用</a>";
					}else{
						state = "<a href='"+data[i].adminId+"' id='start'>启用</a>";
					}
					td += "<tr><td>"+data[i].adminNumber+"</td><td>"+data[i].adminName+
					"</td><td>"+data[i].adminPassword+"</td><td>"+data[i].realName+"</td>"+
					"<td>"+state+"</td>"+
					"<td><a href='"+data[i].adminId+"' id='deleteAdmin'>删除</a></td><td><a href='"+
					data[i].adminId+"' id='changeAdmin' >更改</a></td></tr>";
					}
				  table = table + td +"</tbody></table>";
				  var showEmp = document.getElementById("showEmp");
				  showEmp.innerHTML = table;
				  
			  });
		 }
		 //点击更改，触发新的拟态框
		 $(document).on("click","#changeAdmin",function(){
		 		var adminId = $(this).attr("href");
		 		//工号
		 		var a = $(this).parent().siblings().eq(0).html();
		 		//用户名
		 		var b = $(this).parent().siblings().eq(1).html();
		 		//密码
		 		var c = $(this).parent().siblings().eq(2).html();
		 		//使用人
		 		var d = $(this).parent().siblings().eq(3).html();
		 		$("#numberText").val(a); 
		 		$("#nameText").val(d); 
		 		$("#accountText").val(b); 
		 		$("#passwordText").val(c); 
		 		$("#change_admin").modal("show");
		 		updateAdmin(adminId);
		 		return false;
		 });
		 	//数据库查询数据
			 /* function getAdmin(adminId){
		 		var param = {
		 				adminId:amdinId
		 		}
		 		$.post("",param,function(){
		 			
		 		});
		 	} */
		 //添加输入框的点击事件
		 $("#insertAdmin").click(function(){
			 var numberText = $("#numberText1").val();
			 var nameText = $("#nameText1").val();
			 var accountText = $("#accountText1").val();
			 var passwordText = $("#passwordText1").val();
			 if(numberText == null || numberText == "" || nameText == null || nameText == "" ||accountText == null || accountText == "" ||passwordText == null || passwordText == ""){
				 alert("您还有信息没有输入");
				 
			 }else{
				 var param = {
						 adminNumber:numberText, 
						 realName:nameText, 
						 adminName:accountText, 
						 adminPassword:passwordText
				 }
				 $.post("${pageContext.request.contextPath}/baseservice/DoInsAdminServlet",param,function(data){
					 if(data == true || data == "true"){
						 alert("添加成功");
						 $("#renyuan").modal("hide");
						 $(".modal-backdrop.fade").hide();
						 pagesVal = parseInt(pagesVal) + 1;
						 query(pagesVal);
					 }else{
						 alert("添加失败了，账号或者工号已经存在");
					 }
					 $("").modal("hide");
					 
				 });
			 }
		 });
		 //修改输入框的点击事件
		 function updateAdmin(adminId){
			 $("#updateAdmin").click(function(){
				 var numberText = $("#numberText").val();
				 var nameText = $("#nameText").val();
				 var accountText = $("#accountText").val();
				 var passwordText = $("#passwordText").val();
				 if(numberText == null || numberText == "" || nameText == null || nameText == "" ||accountText == null || accountText == "" ||passwordText == null || passwordText == ""){
					 alert("您还有信息没有输入");
					 
				 }else{
					 var param = {
							 adminId:adminId,
							 adminNumber:numberText, 
							 realName:nameText, 
							 adminName:accountText, 
							 adminPassword:passwordText
					 }
					 $.post("${pageContext.request.contextPath}/baseservice/DoUpdAdminServlet",param,function(data){
						 if(data == true || data == "true"){
							 alert("修改成功");
							 $("#change_admin").modal("hide");
							 $(".modal-backdrop.fade").hide();
							 query(1);
						 }else{
							 alert("修改失败了，账号或者工号已经存在");
						 }
					 });
				 }
				 return false;
			 });
		 }
		 //删除按钮的点击事件
		 $("#showEmp").on("click","#deleteAdmin",function(event){
			 var con = confirm("点击要删除哦！！");
			 event.preventDefault();
			 var adminId = $(this).attr("href");
			 if(con == true){
				 var param = {
						 adminId:adminId
				 }
				 $.post("${pageContext.request.contextPath}/baseservice/DoDelAdminServlet",param,function(){
					 alert("删除成功");
					 pagesVal = pagesVal - 1;
						//获取当前的值给输入框赋值
					$(".pages").val(pagesVal);
					 query(pagesVal);
				 });
			 }
		 });
		 //修改状态的点击事件,停用
		 $("#showEmp").on("click","#stop",function(event){
			 event.preventDefault();
			 var adminId = $(this).attr("href");
			 var state = 0;
			 var param = {
					state:state,
					adminId:adminId
			 }
			 $.post("${pageContext.request.contextPath}/baseservice/DoUpdAdminStateServlet",param,function(){
				 alert("该账号现在变成停用了");
				 query(pagesVal);
			 });
		 });
		//修改状态的点击事件,启用
		 $("#showEmp").on("click","#start",function(event){
			 event.preventDefault();
			 var adminId = $(this).attr("href");
			 var param = {
					state:1,
					adminId:adminId
			 }
			 $.post("${pageContext.request.contextPath}/baseservice/DoUpdAdminStateServlet",param,function(){
				 alert("该账号现在变成启用了");
				 query(pagesVal);
			 });
		 });
		//上一页功能
		$(".uppage").click(function(){
			if(pagesVal == 1){
				alert("没有上一页了！");
			}else{
				pagesVal = $(".pages").val();
				pagesVal = pagesVal - 1;
				//获取当前的值给输入框赋值
				$(".pages").val(pagesVal);
				query(pagesVal);
			}
		});
		//下一页功能
		$(".nextpage").click(function(){
			if(pagesVal == count){
				alert("没有下一页了！");
			}else{
				pagesVal = $(".pages").val();
				pagesVal = parseInt(pagesVal) + 1;
				//获取当前的值给输入框赋值
				$(".pages").val(pagesVal);
				query(pagesVal);
			}
		});
		//第几页的功能展示
		 function pageNumber(){
			var option = "";
			for (var i = 1; i <= count; i++) {
				option += "<option>"+i+"</option>";
			}
			var pages = document.getElementById("optionPage");
			pages.innerHTML = option;
		}
		//第几页的状态改变，重新加载表格
		$(".pages").change(function(){
			pagesVal = $(".pages").val();
			query(pagesVal);
		})
	});
		  
  </script>
  <style>
  	nav.navbar {background: #29176c;}
  	footer.main-footer {padding:0;}
  	.waves {
    height: 35px;
    margin-bottom: -7px;
    min-height: 20px;
    max-height: 150px;
	}
 	body{color: white;}
  	section {padding:0;}
	.page {overflow: hidden;}
  </style>
  <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath }/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath }/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${pageContext.request.contextPath }/vendor/chart.js/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath }/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/charts-home.js"></script>
   
    <!-- Main File-->
    <script src="${pageContext.request.contextPath }/js/front.js"></script>
  
    <div class="page">
      <header class="header">
        <nav class="navbar">
          <!-- 头部  -->
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <!-- Navbar Header-->
              <div class="navbar-header">
                <!-- Navbar Brand --><a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                  <div class="brand-text d-none d-lg-inline-block"><strong>“南老板”后台管理系统</strong></div>
                  <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>"南老板"</strong></div></a>
                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
              </div>
              <!-- Navbar Menu -->
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                <!-- 注销   -->
                <li class="nav-item"><a href="${pageContext.request.contextPath}/merchantadmin/loginOutServlet" class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="page-content d-flex align-items-stretch"> 
        <!-- 侧边栏 -->
        <nav class="side-navbar">
          <!-- 侧边头部-->
          <div class="sidebar-header d-flex align-items-center">
          	<cc:if test="${ role == 2 }">
            <div class="avatar"><img src="${pageContext.request.contextPath}/img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
            <div class="title">
              <h1 class="h4">${ sessionScope.merchant.merchantName}</h1>
              <h6>${sessionScope.merchant.account}</h6>
            </div>
            </cc:if>
            <cc:if test="${ role == 1 }">
            <div class="avatar"><img src="${pageContext.request.contextPath}/img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
            <div class="title">
              <h1 class="h4">${ sessionScope.admin.adminName}</h1>
              <h6>${sessionScope.admin.realName}</h6>
            </div>
            </cc:if>
          </div>
          <!-- 测边框主要功能模块-->
          <cc:if test="${ role == 2 }">
          <span class="heading">菜单导航</span>
          <ul class="list-unstyled">
                    <li><a href="${pageContext.request.contextPath }/jsp/indexAdmin.jsp"> <i class="icon-home"></i>主页面</a></li>
                    <li><a href="#basicfunction"aria-expanded="false" data-toggle="collapse"> <i class="icon-grid"></i>基本功能 </a>
                    	<ul id="basicfunction" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath }/jsp/merchant/merchantInfo.jsp">我的信息</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/merchant/merchantIn.jsp">充值</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/merchant/merchantOut.jsp">提现</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/merchant/updPassWord.jsp">修改密码</a></li>
                     	</ul>
                    </li>
                    <li><a href="#firstfunction"data-toggle="collapse"> <i class="fa fa-bar-chart"></i>商品系统</a>
                    	<ul id="firstfunction" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath }/jsp/commodity/manage/commodityManage.jsp">商品管理</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/commodity/sort/commoditySort.jsp">商品类别管理</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/commodity/img/commodityPicture.jsp">商品图片管理</a></li>
                     	</ul>
                    </li>
                    <li><a href="#secondfunction" aria-expanded="false"  data-toggle="collapse"> <i class="icon-padnote"></i>仓储系统 </a>
                    <ul id="secondfunction" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath }/jsp/storage/in/in.jsp">进货清单</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/storage/return/return.jsp">退货清单</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/storage/sale/sale.jsp">销售清单</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/storage/saleReturn/saleReturn.jsp">销售退货清单</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/storage/stock/stock.jsp">库存盘点</a></li>
                      </ul>
                    </li>
                    <li><a href="#endfunction" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>评价系统</a>
                      <ul id="endfunction" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath }/jsp/appraise/appraiseInfoAll.jsp">评价信息查询</a></li>
                      </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/merchantadmin/loginOutServlet"> <i class="icon-interface-windows"></i>退出登陆 </a></li>
          </ul>
          </cc:if>
          <cc:if test="${ role == 1 }">
          <span class="heading">菜单导航</span>
          <ul class="list-unstyled">
                    <li ><a href="${pageContext.request.contextPath }/jsp/indexAdmin.jsp"> <i class="icon-home"></i>主页面</a></li>
                    <li><a href="#basicfunction"aria-expanded="false" data-toggle="collapse"> <i class="icon-grid"></i>基础业务模块 </a>
                    	<ul id="basicfunction" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath }/jsp/baseService/commodityType/commodityType.jsp">商品分类管理</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/baseService/merchantAudit/merchantAudit.jsp">商家审核</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/baseService/commodityAudit/commodityAudit.jsp">商品审核</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/baseService/adminManager/adminManager.jsp">平台管理员</a></li>
                     	</ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/merchantadmin/loginOutServlet"> <i class="icon-interface-windows"></i>退出登陆 </a></li>
          </ul>
          </cc:if>
        </nav>
        <!-- 主体部分 -->
        <div class="content-inner">
			<!-- 这是自己写功能模块 -->
			<div class="box">
			<br>
    <div class="title" style="color:gold;margin:0 0 auto;"><b>平台管理员展示</b></div>
    <div class="content">
        <!--搜索输入框及查询、重置按钮-->
        <div class="container content_width">
            <div class="person_search">
                <div class="search_input">
                    <div class="input-group mb-3">
                         <select class="form-control" style="font-size: 13px; color: #666; height: 35px;">
                            <option>管理员名称</option>
                            <!-- <option>审核状态</option> -->
                        </select>
                        <input id="Ktext" type="text" class="form-control" placeholder="请输入姓名">
                    </div>
                </div>
                <div class="search_input">
                    <div class="input-group mb-3" hidden>
                        <span>工号：</span>
                        <input id="job_num" type="text" class="form-control" placeholder="请输入工号">
                    </div>
                </div>
                <div class="search_input">
                    <button class="btn btn-primary search_btn" type="button" id="search_btn">查询</button>
                    <button class="btn btn-primary search_btn" type="button" id="back_btn">重置</button>
                </div>
                 <div class="search_input">
                    <input type="text" id="change_page" class="form-control" value="1" placeholder="请输入查询第几页数据">
                </div>
                <div class="search_input">
                    <button class="btn btn-primary search_btn" type="button" id="cb">提交</button>
                </div>
            </div>
            <div class="line"></div>
        </div>
        <!--添加按钮及bootstrap的模态框-->
		<style>
			textarea{ height: 35px; width: 100%;}
			
		</style>
        <div class="export">
            <button id="new_add" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#renyuan">
                <img src="${pageContext.request.contextPath }/img/admin/add_two.png">
                <span>添加管理员</span>
            </button>
            <div class="modal fade" id="renyuan">
                <div class="modal-dialog modal-lg modal_position">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">添加</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <table id="xztb" class="table">
                                <!--新修改弹窗的样式-->
                                <tbody>
                                <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>工号</label>
                                    </td>
                                    <td><input class="commodityName" id="numberText1" type="text" placeholder="请输入工号"></td>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>使用人</label>
                                    </td>
                                    <td><input type="text" id="nameText1" placeholder="请输入使用人"/> </td>
                                </tr>
                                <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>账号</label>
                                    </td>
                                    <td><input class="commodityPice" id="accountText1" type="text" placeholder="请输入账号"></td>
                                    <td class="tb_bg"><label for="">密码</label></td>
                                    <td><input class="vipPice" id="passwordText1" type="text" placeholder="请输入密码"></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button id="insertAdmin" type="button" class="btn btn-secondary">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="export">
            <div class="modal fade" id="change_admin">
                <div class="modal-dialog modal-lg modal_position">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">修改</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <table id="xztb" class="table">
                                <!--新修改弹窗的样式-->
                                <tbody>
                                <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>工号</label>
                                    </td>
                                    <td><input class="commodityName" id="numberText" type="text"  placeholder="请输入工号"></td>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>使用人</label>
                                    </td>
                                    <td><input type="text" id="nameText" placeholder="请输入使用人"/>
                                </tr>
                                 <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>账号</label>
                                    </td>
                                    <td><input class="commodityName" id="accountText" type="text" placeholder="请输入账号"></td>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>密码</label>
                                    </td>
                                    <td><input type="text" id="passwordText" placeholder="请输入密码"/></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button id="updateAdmin" type="button" class="btn btn-secondary">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--表格列表-->
		<div id="showEmp"></div>
		<style>
		.search_input1 {
			height: 50px;
			line-height: 50px;
			margin: 15px 10px 0 0;
			float: right;
		}
		
		</style>
		<div class="search_input1">
			<div class="input-group mb-2">
				<a class="uppage" href="#">上一页</a>
					<select class="form-control pages" id="optionPage" style="font-size: 13px; color: #666; height: 35px; width: 55px; margin: 0 20px;">
						<option value="1">1</option>
					</select> 
				<a class="nextpage" href="#">下一页</a>
			</div>
		</div>
    </div>
</div>
</div>
<script src="${pageContext.request.contextPath }/js/admin/mejs.js"></script>
          <!-- Page Header-->
          <!-- Dashboard Counts Section-->
          <!-- 页脚 模块-->
          <footer class="main-footer">
              <div class="heardstyle">
				<div class="inner-heardstyle flex">
				<h6>Copyright &copy; 2019.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">“南老板”电商网</a></h6>
				</div>
				<div>
					<svg class="waves" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 24 150 28" preserveAspectRatio="none" shape-rendering="auto">
						<defs>
						<path id="gentle-wave" d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z" />
						</defs>
						<g class="parallax">
							<use xlink:href="#gentle-wave" x="48" y="0" fill="rgba(255,255,255,0.7" />
							<use xlink:href="#gentle-wave" x="48" y="3" fill="rgba(255,255,255,0.5)" />
							<use xlink:href="#gentle-wave" x="48" y="5" fill="rgba(255,255,255,0.3)" />
							<use xlink:href="#gentle-wave" x="48" y="7" fill="#fff" />
						</g>
					</svg>
				</div>
			</div>
          </footer> 
        </div>
      </div>
    </div>
  </body>
</html>