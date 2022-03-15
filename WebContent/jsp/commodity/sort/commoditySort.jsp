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
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no,minimum-scale=1,maximum-scale=1,user-scalable=no">
<meta name="robots" content="all,follow">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/fontastic.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/dibutexiao.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.default.css"
	id="theme-stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/custom.css">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/img/favicon.ico">

<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/bootbox.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/manage.css">
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
	<script type="text/javascript">
		$(function(){
			var INSERT=true;//判断是不是添加事件
			var INSERTSUBSORT=true;//判断是不是添加详细类别事件
			var sortId;
			var subsortId;
			var sortArray={};//类别数组
			//添加商品名字的下拉框
			getCommodityName();
			
			//添加对应商品的详细类别
			$(document).on("click",".insSubsort",function(){
				$(".modal-title").html("添加商品详细类别");
				$(".subsortstate1").prop("checked",true);
				$("#commoditySubsort").modal('show');
				return false;
			});
			
			//修改详细类别状态
			$(document).on("click",".subsortState",function(){
				subsortId=$(this).attr("href");
				var state=$(this).html();
				var subsortstate;
				if(state=="停用"){
					subsortstate=0;
				}else{
					subsortstate=1;
				}
				var param={
						subsortId:subsortId,
						subsortstate:subsortstate
				}
				$.post("${pageContext.request.contextPath}/commodity/doUpdSubsortStateServlet",param,function(date){
					if(date==true||date=='true'){
						alert("类别已经成功"+state);
					}else{
						alert(state+"类别失败");
					}
					showSubsort();
				});
				return false;
			});
			
			//修改详细类别
			$(document).on("click",".updSubsort",function(){
				INSERTSUBSORT=false;
				subsortId=$(this).attr("href");
				$.post("${pageContext.request.contextPath}/commodity/getCommoditySubsortBySubsortIdServlet",{subsortId:subsortId},function(date){
					date=eval(date);
				var commoditySubsort=date[0];
				$(".subsortName").val(commoditySubsort.subsortName);
				$(".subsortPrice").val(commoditySubsort.subsortPrice);
				$(".vipPrice").val(commoditySubsort.vipPrice);
				if(commoditySubsort.subsortState=='1'||commoditySubsort.subsortState==1){
					$(".subsortstate1").prop("checked",true);
				}else{
					$(".subsortstate").prop("checked",true);
				}	
					console.log(commoditySubsort);
					console.log(sortArray);
					console.log(commoditySubsort.sortId);
					$(".modal-title").html("添加商品详细类别("+sortArray[commoditySubsort.sortId]+")");
					$("#commoditySubsort").modal('show');
				});
				return false;
			});
			
			//删除详细类别
			$(document).on("click",".deletSubsort",function(){
				subsortId=$(this).attr("href");
				var con=confirm("你确定要删除该条详细类别吗？");
				if(con==true||con=='true'){
				$.post("${pageContext.request.contextPath}/commodity/doDelCommoditySubsortBySubsortIdServlet",{subsortId:subsortId},function(date){
					if(date==true||date=='true'){
						alert("删除成功");
					}else{
						alert("删除失败");
					}
					showSubsort();
				});
				}
				return false;
			});
			
			//详细类别点击事件
			$("#add_subsort").click(function(){
				var subsortName =$(".subsortName").val();
				var subsortPrice=$(".subsortPrice").val();
				var vipPrice =$(".vipPrice").val();
				var state=1;
				if($(".subsortstate").prop("checked") == true){
					state=0;
				}
				if(INSERTSUBSORT==true||INSERTSUBSORT=='true'){
				var param={
						subsortName:subsortName,
						subsortPrice:subsortPrice,
						vipPrice:vipPrice,
						state:state,
						sortId:sortId
				}
						$.post("${pageContext.request.contextPath}/commodity/doInsCommoditySubsortServlet",param,function(date){
								if(date==true||date=="true"){
									alert("添加成功");
								}else{
									alert("添加失败");
								}
								showSubsort();
								$(".subsortName").val('');
								$(".subsortPrice").val('');
								$(".vipPrice").val('');
								$(".subsortstate1").prop("checked",true);
								$("#commoditySubsort").modal('hide');
								$(".modal-backdrop.fade").hide();
						});
				}else{
					var param={
							subsortName:subsortName,
							subsortPrice:subsortPrice,
							vipPrice:vipPrice,
							state:state,
							subsortId:subsortId,
							sortId:sortId
					}
						$.post("${pageContext.request.contextPath}/commodity/doUpdCommoditySubsortServlet",param,function(date){
							if(date==true||date=="true"){
								alert("修改成功");
							}else{
								alert("修改失败");
							}
								INSERTSUBSORT=true;
								showSubsort();
								$(".subsortName").val('');
								$(".subsortPrice").val('');
								$(".vipPrice").val('');
								$(".subsortstate1").prop("checked",true);
								$("#commoditySubsort").modal('hide');
								$(".modal-backdrop.fade").hide();
					});
				}
			});
			
			//显示编辑按钮
			$(".edit").click(function(){
				$(".caidan").css({
					"display":"none"
				});
				return false;
			});
			//移除商品类别
			$(document).on("click",".deletSort",function(){
				sortId=$(this).attr("href");
				var con=confirm("你确定要删除该条类别吗？");
				if(con==true||con=='true'){
				$.post("${pageContext.request.contextPath}/commodity/doDelCommoditySortBySortIdServlet",{sortId:sortId},function(date){
					if(date==true||date=='true'){
						alert("删除成功");
					}else{
						alert("删除失败,该类别还存在详细类别");
					}
					showCommoditySort();
				});
				}
				return false;
			});
			//显示详细信息
			$(document).on("click",".showSubsort",function(){
				sortId=new Number($(this).attr("href"));
				showSubsort();
				$(".subsorttitle").html("详细类别列表(<span style='color:red;'>"+sortArray[sortId]+"</span>)");
				$(".caidan").css({
					"display":"none"
				});
				$(".card").css({
					"display":"block"
				});
				return false;
			});
			
			//显示详细类别的方法
			function showSubsort(){
				var param={
						sortId:sortId
				}
				$.post("${pageContext.request.contextPath}/commodity/getComoditySubsortBySortIdServlet",param,function(date){
					date =eval(date);					
					console.log(date);
					var subSort=date[0];
					var table="";
					for(var i=0; i<subSort.length;i++){
						var state=subSort[i].subsortState
						var sortstate="";
						if(state==1||state=='1'){
							state="使用中";
							sortstate="<a class='subsortState' href='"+subSort[i].subsortId+"'>停用</a>";
						}else{
							state="已停用";
							sortstate="<a class='subsortState' href='"+subSort[i].subsortId+"'>使用</a>";
						}
						table+="<tr><th>"+subSort[i].subsortName
						+"</th><td>"+subSort[i].subsortPrice
						+"</td><td>"+subSort[i].vipPrice
						+"</td><td>"+state
						+"</td><td>"+sortstate+"&nbsp;&nbsp;&nbsp;&nbsp;<a class='updSubsort' href='"+subSort[i].subsortId+"'>修改类别</a>"
						+"&nbsp;&nbsp;&nbsp;&nbsp;<a class='deletSubsort' href='"+subSort[i].subsortId+"'>❌ </a>"
						+"</td>";
					}
					$("#subSort").html(table);
				});
				
			}
			
			//点击修改类别事件
			$(document).on("click",".updSort ",function(event){
				event.preventDefault();
				$(".modal-title").html("修改商品类别");
				$("#commoditySort").modal('show');
				INSERT=false;
				SORTID=$(this).attr("href");
				$.post("${pageContext.request.contextPath}/commodity/getCommoditySortServlet",{sortId:SORTID},function(date){
					date=eval(date);
					var commoditySort=date[0];
					$(".sortName").val(commoditySort.sortName);
					if(commoditySort.sortState==1||commoditySort.sortState=='1'){
						$(".state1").prop("checked",true);
					}else{
						$(".state").prop("checked",true);
					}
				});
			});
			//添加类别弹框事件
			$("#new_add").click(function(){
				var commodityId=$(".getCommodity").val();
				if(commodityId==null){
					bootbox.alert({
		                title: "来自火星的提示",
		                message: "请选择商品名称",
		                closeButton:false
		            })
		            return
				}else{
				$(".modal-title").html("添加商品类别");
				$(".state1").prop("checked",true);
				$("#commoditySort").modal('show');
				}
			});
			//关闭模态框点击事件
			$(document).on("click",".closeSort,.closeSubsort",function(){
				INSERT=true;
				INSERTSUBSORT=true;
				$(".sortName").val('');
				$(".state1").prop("checked",true);
				$("#commoditySort").modal('hide');
				$(".modal-backdrop.fade").hide();
				$(".subsortName").val('');
				$(".subsortPrice").val('');
				$(".vipPrice").val('');
				$(".subsortstate1").prop("checked",true);
				$("#commoditySubsort").modal('hide');
				$(".modal-backdrop.fade").hide();
			});
			//添加商品类别点击确定时事件
			$("#add_btn").click(function(){
				var commodityId=$(".getCommodity").val(); 
				var sortName=$(".sortName").val();
				if(sortName==''){
					bootbox.alert({
		                title: "来自火星的提示",
		                message: "类型名不能为空",
		                closeButton:false
		            })
		            return
				}
				var state=1;
				if($(".state").prop("checked") == true){
					state=0;
				}
				if(INSERT==true||INSERT=='true'){
						var param={
								commodityId:commodityId,
								sortName:sortName,
								state:state
						}
						$.post("${pageContext.request.contextPath}/commodity/doInsCommoditySortSerlvet",param,function(date){
							if(date==true||date=='true'){
								alert("添加成功");
							}else{
								alert("添加失败");
							}
							$(".getCommodity option[value="+commodityId+"]").prop("selected",true);
							showCommoditySort();
							$(".sortName").val('');
							$(".state1").prop("checked",true);
							$("#commoditySort").modal('hide');
							$(".modal-backdrop.fade").hide();
						});
				
				}else{
						var param={
								commodityId:commodityId,
								sortName:sortName,
								sortId:SORTID,
								state:state
						}
						$.post("${pageContext.request.contextPath}/commodity/doUpdCommoditySortServlet",param,function(date){
							if(date==true||date=='true'){
								alert("修改成功");
							}else{
								alert("修改失败");
							}
							INSERT=true;
							$(".getCommodity option[value="+commodityId+"]").prop("selected",true);
							showCommoditySort();
							$(".sortName").val('');
							$("#commoditySort").modal('hide');
							$(".modal-backdrop.fade").hide();
						});
				}
			});
			//显示所有的商品名称
			 function getCommodityName(){
					$.post("${pageContext.request.contextPath}/commodity/getCommodityNameServlet",{},function(date){
				  		date=eval(date);
				  		var commodity=date[0];
				  		var table="";
				  		table="<option value='' disabled selected hidden>请选择商品名称</option>"
					  	
				  		for(var i=0;i<commodity.length;i++){
				  			table+="<option value='"+commodity[i].commodityId+"'>"+commodity[i].commodityName+"</option>"
				  		}
				  		//显示当前页的数据
				  		$(".getCommodity").html(table);
				  	});
			}
			//显示商品对应的类别信息
			$(".getCommodity").change(function(){
				$(".card").css({
					"display":"none"
				});
				sortArray={};
				var sortid=$('.getCommodity').val();
				var commodityName=$(".getCommodity option[value="+sortid+"]").html();
				$(".commodityName").val(commodityName);
				showCommoditySort();
			});
			
			function showCommoditySort(){
				var commodityId=$(".getCommodity").val();
				$.post("${pageContext.request.contextPath}/commodity/getCommoditySortAllServlet",{ commodityId:commodityId},function(date){
					date=eval(date);
					var commoditySort=date[0];
					console.log(commoditySort);
					var table="";
					for(var i=0; i<commoditySort.length;i++){
						sortArray[commoditySort[i].sortId]=commoditySort[i].sortName;
						var sortState=commoditySort[i].sortState;
						var	b="&nbsp;&nbsp;&nbsp;&nbsp;<a class='deletSort' href='"+commoditySort[i].sortId+"'>❌</a>";
						var	c="<a href='"+commoditySort[i].sortId+" ' class='showSubsort'>查看详情</a>&nbsp;&nbsp;&nbsp;&nbsp;";
						if(sortState=='1'||sortState==1){
							sortState="使用中";
						}else{
							sortState="已停用"
						}
						table+="<tr><td>"+commoditySort[i].sortName
						+"</td><td>"+sortState
						+"</td><td>"+c
						+"</td><td><a class='updSort' href='"+commoditySort[i].sortId+"'>修改类别</a>"+b
						+"</td></tr>";
					}
					$("#show_tbody").html(table);
				});
			}
		});
	
	</script>
	<style>
		.removeImg{
		background:#EEF5F9;
		width:16px;
		heigh:16px;
		transform:rotate(40);
		}
		nav.navbar {
			background: #29176c;
		}
		footer.main-footer {
			padding: 0;
		}
		.waves {
			height: 35px;
			margin-bottom: -7px;
			min-height: 20px;
			max-height: 150px;
		}
		body {
			color: white;
		}
		section {
			padding: 0;
		}
		.page {
			overflow: hidden;
		}
		.btn-primary {
			background-color: #3ea2ee;;
			border-color: #796AEE;
		}
		.commodityDescribe{
			height:80px;
		}
		textarea {
			height: 35px;
			width: 100%;
		}
		.search_input1 {
			height: 35px;
			line-height: 35px;
			margin: 15px 10px 0 0;
			float: right;
		}
		</style>
	<!-- JavaScript files-->
	<script
		src="${pageContext.request.contextPath }/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/vendor/popper.js/umd/popper.min.js"> </script>
	<script
		src="${pageContext.request.contextPath }/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/vendor/jquery.cookie/jquery.cookie.js"> </script>
	<script
		src="${pageContext.request.contextPath }/vendor/chart.js/Chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/vendor/jquery-validation/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/charts-home.js"></script>
	<!-- Main File-->
	<script src="${pageContext.request.contextPath }/js/front.js"></script>
	<div class="page">
		<header class="header"> <nav class="navbar"> <!-- 头部  -->
			<div class="container-fluid">
				<div
					class="navbar-holder d-flex align-items-center justify-content-between">
						<!-- Navbar Header-->
						<div class="navbar-header">
							<!-- Navbar Brand -->
							<a href="index.html" class="navbar-brand d-none d-sm-inline-block">
							<div class="brand-text d-none d-lg-inline-block">
								<strong>“南老板”后台管理系统</strong>
							</div>
							<div class="brand-text d-none d-sm-inline-block d-lg-none">
								<strong>"南老板"</strong>
							</div>
						</a>
						<!-- Toggle Button-->
						<a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
					</div>
				<!-- Navbar Menu -->
				<ul
					class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
					<!-- 注销   -->
					<li class="nav-item"><a
						href="${pageContext.request.contextPath}/merchantadmin/loginOutServlet"
						class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i
							class="fa fa-sign-out"></i></a></li>
				</ul>
			</div>
		</div>
		</nav> </header>
		<div class="page-content d-flex align-items-stretch">
			<!-- 侧边栏 -->
			<nav class="side-navbar"> <!-- 侧边头部-->
				<div class="sidebar-header d-flex align-items-center">
					<cc:if test="${ role == 2 }">
						<div class="avatar">
							<img src="${pageContext.request.contextPath}/img/avatar-1.jpg"
								alt="..." class="img-fluid rounded-circle">
						</div>
						<div class="title">
							<h1 class="h4">${ sessionScope.merchant.merchantName}</h1>
							<h6>${sessionScope.merchant.account}</h6>
						</div>
					</cc:if>
					<cc:if test="${ role == 1 }">
						<div class="avatar">
							<img src="${pageContext.request.contextPath}/img/avatar-1.jpg"
								alt="..." class="img-fluid rounded-circle">
						</div>
						<div class="title">
							<h1 class="h4">${ sessionScope.admin.adminName}</h1>
							<h6>${sessionScope.admin.realName}</h6>
						</div>
					</cc:if>
			</div>
			<!-- 测边框主要功能模块--> <cc:if test="${ role == 2 }">
				<span class="heading">菜单导航</span>
				<ul class="list-unstyled">
					<li><a
						href="${pageContext.request.contextPath }/jsp/indexAdmin.jsp">
							<i class="icon-home"></i>主页面
					</a></li>
					<li><a href="#basicfunction" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-grid"></i>基本功能
					</a>
						<ul id="basicfunction" class="collapse list-unstyled ">
							<li><a
								href="${pageContext.request.contextPath }/jsp/merchant/merchantInfo.jsp">我的信息</a></li>
							<li><a
								href="${pageContext.request.contextPath }/jsp/merchant/merchantIn.jsp">充值</a></li>
							<li><a
								href="${pageContext.request.contextPath }/jsp/merchant/merchantOut.jsp">提现</a></li>
							<li><a
								href="${pageContext.request.contextPath }/jsp/merchant/updPassWord.jsp">修改密码</a></li>
						</ul></li>
					<li><a href="#firstfunction" data-toggle="collapse"> <i
							class="fa fa-bar-chart"></i>商品系统
					</a>
						<ul id="firstfunction" class="collapse list-unstyled ">
							<li><a
								href="${pageContext.request.contextPath }/jsp/commodity/manage/commodityManage.jsp">商品管理</a></li>
							<li><a
								href="${pageContext.request.contextPath }/jsp/commodity/sort/commoditySort.jsp">商品类别管理</a></li>
							<li><a
								href="${pageContext.request.contextPath }/jsp/commodity/img/commodityPicture.jsp">商品图片管理</a></li>
						</ul></li>
					<li><a href="#secondfunction" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-padnote"></i>仓储系统
					</a>
						<ul id="secondfunction" class="collapse list-unstyled ">
							<li><a
								href="${pageContext.request.contextPath }/jsp/storage/in/in.jsp">进货清单</a></li>
							<li><a
								href="${pageContext.request.contextPath }/jsp/storage/return/return.jsp">退货清单</a></li>
							<li><a
								href="${pageContext.request.contextPath }/jsp/storage/sale/sale.jsp">销售清单</a></li>
							<li><a
								href="${pageContext.request.contextPath }/jsp/storage/saleReturn/saleReturn.jsp">销售退货清单</a></li>
							<li><a
								href="${pageContext.request.contextPath }/jsp/storage/stock/stock.jsp">库存盘点</a></li>
						</ul></li>
					<li><a href="#endfunction" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>评价系统
					</a>
						<ul id="endfunction" class="collapse list-unstyled ">
							<li><a
								href="${pageContext.request.contextPath }/jsp/appraise/appraiseInfoAll.jsp">评价信息查询</a></li>
						</ul></li>
					<li><a
						href="${pageContext.request.contextPath}/merchantadmin/loginOutServlet">
							<i class="icon-interface-windows"></i>退出登陆
					</a></li>
				</ul>
			</cc:if> <cc:if test="${ role == 1 }">
				<span class="heading">菜单导航</span>
					<ul class="list-unstyled">
						<li><a
							href="${pageContext.request.contextPath }/jsp/indexAdmin.jsp">
								<i class="icon-home"></i>主页面
						</a></li>
						<li><a href="#basicfunction" aria-expanded="false"
							data-toggle="collapse"> <i class="icon-grid"></i>基础业务模块
						</a>
							<ul id="basicfunction" class="collapse list-unstyled ">
								<li><a
									href="${pageContext.request.contextPath }/jsp/baseService/commodityType/commodityType.jsp">商品分类管理</a></li>
								<li><a
									href="${pageContext.request.contextPath }/jsp/baseService/merchantAudit/merchantAudit.jsp">商家审核</a></li>
								<li><a
									href="${pageContext.request.contextPath }/jsp/baseService/commodityAudit/commodityAudit.jsp">商品审核</a></li>
								<li><a
									href="${pageContext.request.contextPath }/jsp/baseService/adminManager/adminManager.jsp">平台管理员</a></li>
							</ul></li>
						<li><a
							href="${pageContext.request.contextPath}/merchantadmin/loginOutServlet">
								<i class="icon-interface-windows"></i>退出登陆
						</a></li>
					</ul>
			</cc:if> </nav>
			<!-- 主体部分 -->
			<div class="content-inner">
				<!-- 这是自己写功能模块 -->
				<div class="mybox">
					<div class="mytitle">商品显示列表</div>
					<div class="mycontent">
						<!--搜索输入框及查询、重置按钮-->
						<div class="container content_width">
							<div class="person_search">
								<div class="search_input">
									<div class="input-group mb-3">
									<span>请选择商品</span>
										 <select class="form-control  getCommodity"
											style="font-size: 13px; color: #666; height: 35px;">
										</select>
									</div>
								</div>
								<button id="new_add" type="button" class="btn btn-primary "
									style="margin-top: 15px; margin-left: 10px; padding: 0; height: 35px; width: 100px">
									<span>➕ 添加类别</span>
								</button>
							</div>
							<div class="line"></div>
						</div>
						<!--添加按钮及bootstrap的模态框-->
						<!-- 这是为商品添加新的类别 -->
						<div class="export" >
							<div class="modal fade" id="commoditySort" style="opacity: 1;">
								<div class="modal-dialog modal-lg modal_position">
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title"></h4>
											<button type="button" class="close closeSort" >&times;</button>
										</div>
										<div class="modal-body">
											<table id="xztb" class="table">
												<!--新修改弹窗的样式-->
												<tbody>
													<tr>
														<td class="tb_bg"><label for=""><font
																style="font-size: 14px; color: red;">*</font>商品名称</label></td>
														<td><input type="text" disabled="disabled" class="commodityName"></td>	
													</tr>
													<tr>
														<td class="tb_bg"><label for=""><font
																style="font-size: 14px; color: red;">*</font>类别名称</label></td>
														<td><input type="text" placeholder="请输入类别名称" class="sortName"/>
														</td>
													</tr>
													<tr>
														<td class="tb_bg"><label for=""><font
																style="font-size: 14px; color: red;">*</font>类别状态</label></td>
														<td  class="radio">
														
														 <input class="state1" type="radio" name='state' checked="checked" style="display: inline-block ! important; width:14px ! important; height:14px ! important;"/><span
																style="font-size:14px;line-height: 35px; height:35px; margin:0px 10px 0px 10px" >使用</span>
														 <input class="state" type="radio"  name='state' style="display: inline-block ! important; width:14px ! important;height:14px ! important;" /><span
																style="font-size:14px;line-height: 35px; height:35px; margin:0px 10px 0px 10px" >停用</span>
														
														</td>
													</tr>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary closeSort"
												>取消</button>
											<button id="add_btn" type="button" class="btn btn-secondary">确定</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--表格列表-->
						
						<!--详细类别模态框 -->
						<div class="export" >
							<div class="modal fade" id="commoditySubsort">
								<div class="modal-dialog modal-lg modal_position">
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title">添加</h4>
											<button type="button" class="close closeSubsort" >&times;</button>
										</div>
										<div class="modal-body">
											<table id="xztb" class="table">
												<!--新修改弹窗的样式-->
												<tbody>
													<tr>
														<td class="tb_bg"><label for=""><font
																style="font-size: 14px; color: red;">*</font>详细类别名称</label></td>
														<td><input type="text" class="subsortName" placeholder="请输入详细类别名称"></td>
													</tr>
													<tr>
														<td class="tb_bg"><label for=""><font
																style="font-size: 14px; color: red;">*</font>基础价格</label></td>
														<td><input class="subsortPrice" type="number"
															min="0" placeholder="请输入基础价格"></td>
													</tr>
													<tr>
													
														<td class="tb_bg"><label for="">VIP价格</label></td>
														<td><input class="vipPrice" type="number" min="0"
															placeholder="请输入VIP价格"></td>
													</tr>
													<tr>
														<td class="tb_bg"><label for=""><font
																style="font-size: 14px; color: red;">*</font>详细类别状态</label></td>
														<td  class="radio">
														 <input class="subsortstate1" type="radio" name='state' checked="checked" style="display: inline-block ! important; width:14px ! important; height:14px ! important;"/><span
																style="font-size:14px;line-height: 35px; height:35px; margin:0px 10px 0px 10px" >使用</span>
														 <input class="subsortstate" type="radio"  name='state' style="display: inline-block ! important; width:14px ! important;height:14px ! important;" /><span
																style="font-size:14px;line-height: 35px; height:35px; margin:0px 10px 0px 10px" >停用</span>
														
														</td>
													</tr>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary closeSubsort"
												>取消</button>
											<button id="add_subsort" type="button" class="btn btn-secondary">确定</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						

						<table id="tb" class="table commodity">
							<thead>
								<tr>
									<th>商品类别名称</th>
									<th>商品类别状态</th>
									<th>更多详情</th>
									<th>类别管理</th>
								</tr>
							</thead>
							<tbody id="show_tbody">
								<!-- 从数据库获取的值 -->
							</tbody>
						</table>
						<style>
						
						</style>
						<div class="line"></div>
						
				<div class="col-lg-12">
                  <div class="card" style="display:none;" >
                    <div class="card-close">
                      <div class="dropdown">
                        <button type="button" id="closeCard3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                        <div aria-labelledby="closeCard3" class="dropdown-menu dropdown-menu-right has-shadow caidan"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                      </div>
                    </div>
                 <div class="card-header d-flex align-items-center">
                   <h3 class="h4 subsorttitle" style="color:#007bff;text-align: center;
    width: 100%;"></h3>
                    </div>
                    <div class="card-body">
                      <div class="table-responsive">                       
                        <table class="table table-striped table-hover">
                          <thead>
                            <tr>
                              <th>详细类别名称</th>
                              <th>基础价格</th>
                              <th>VIP价格</th>
                              <th>类别状态</th>
                              <th  >类别管理</th>
                            </tr>
                          </thead>
                          <tbody id="subSort">
                          
                          </tbody>
                        </table>
                        <div>
                          <button  type="button" class="btn btn-primary insSubsort"
									style="padding: 0; height: 35px; width:100%">
									<span>➕   添加详细类别</span>
							</button>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
				</div>
				</div>
				<!-- Page Header-->
				<!-- Dashboard Counts Section-->
				<!-- 页脚 模块-->
				<footer class="main-footer">
				<div class="heardstyle">
					<div class="inner-heardstyle flex">
						<h6>
							Copyright &copy; 2019.Company name All rights reserved.<a
								target="_blank" href="http://sc.chinaz.com/moban/">“南老板”电商网</a>
						</h6>
					</div>
					<div>
						<svg class="waves" xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 24 150 28"
							preserveAspectRatio="none" shape-rendering="auto"> <defs>
						<path id="gentle-wave"
							d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z" />
						</defs> <g class="parallax"> <use xlink:href="#gentle-wave" x="48"
							y="0" fill="rgba(255,255,255,0.7" /> <use
							xlink:href="#gentle-wave" x="48" y="3"
							fill="rgba(255,255,255,0.5)" /> <use xlink:href="#gentle-wave"
							x="48" y="5" fill="rgba(255,255,255,0.3)" /> <use
							xlink:href="#gentle-wave" x="48" y="7" fill="#fff" /> </g> </svg>
					</div>
				</div>
				</footer>
			</div>
		</div>
	</div>
</body>
</html>