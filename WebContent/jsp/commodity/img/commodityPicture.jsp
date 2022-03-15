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
<link href="${pageContext.request.contextPath }/css/common.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/picture.css" type="text/css" rel="stylesheet">
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
			//添加商品名字的下拉框
			getCommodityName();
			
			//修改图片状态
			$(document).on("click",".pictureState",function(event){
					event.preventDefault();
					var pictureId=$(this).attr("href");
					var pictureState=$(this).html();
					var state="";
					if(pictureState=='停用'){
						state=0;
					}else{
						state=1;
					}
					$.post("${pageContext.request.contextPath}/commodity/doUpdCommodityPictureStateServlet",{pictureId:pictureId,state:state},function(date){
						if(date==true||date=="true"){
							alert(pictureState+"成功");
						}else{
							alert(pictureState+"失败");
						}
						getPicture();
					});
			});
			
			//删除图片
			$(document).on("click",".close-upimg",function(){
				var content=confirm("你确定要删除这个图片吗？");
				if(content=="true"||content==true){
					var pictureId=$(this).attr("value");
					
					$.post("${pageContext.request.contextPath}/commodity/doDelCommodityPictureServlet",{pictureId:pictureId},function(date){
						if(date==true||date=="true"){
							alert("删除成功");
						}else{
							alert("删除失败");
						}
						getPicture();
					});
				}else{
					return
				}				
			});
			
			//删除视频
			$(document).on("click",".deleImg",function(event){
				event.preventDefault();
				var content=confirm("你确定要删除这个视频吗？");
				if(content=="true"||content==true){
					var pictureId=$(this).attr("href");
					
					$.post("${pageContext.request.contextPath}/commodity/doDelCommodityPictureServlet",{pictureId:pictureId},function(date){
						if(date==true||date=="true"){
							alert("删除成功");
						}else{
							alert("删除失败");
						}
						getPicture();
					});
				}else{
					return
				}				
			});
			//上传图片
			$(document).on("change","#file1,#file3,#file4,#file2",function(){
				var id=$(this).attr("id");
				if(id=="file1"){
					document.getElementById("form1").submit();
					alert("上传成功");
					getPicture();
				}else if(id=="file3"){
					document.getElementById("form3").submit();
					alert("上传成功");
					getPicture();
				}else if(id=="file4"){
					document.getElementById("form4").submit();
					alert("上传成功");
					getPicture();
				}else{
					document.getElementById("form2").submit();
					alert("上传成功");
					getPicture();
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
			$(".pictureType").change(function(){
				var commodityId=$(".getCommodity").val();
				if(commodityId==''||commodityId==null){
					alert("请选择商品");
					return 
				}
				$(".typebox1,.typebox2,.typebox3,.typebox4").css({
					"display":"none"
				});
				getPicture();
			});
			
			//选定一个商品时获取所有的类型的图片
			$(".getCommodity").change(function(){
				$(".typebox1,.typebox2,.typebox3,.typebox4").css({
					"display":"none"
				});
				$(".pictureType option[value='1']").prop("selected",true);
				getPicture();
			});
			
			//显示图片或者视频
			function getPicture(){
				var commodityId=$(".getCommodity").val();
				var type=$(".pictureType").val();
				var formId="form"+type;
				var fileId="file"+type;
				var param={
						type:type,
						commodityId:commodityId
				}
				if(type==2||type=='2'){
					$.post("${pageContext.request.contextPath}/commodity/getCommodityPictureByCommodityIdServlet",param,function(date){
						date=eval(date);
						var picture=date[0];
						var table="";
						var table2="<section class='z_file fl pic' ><form id='"+formId+"' action='${pageContext.request.contextPath}/commodity/doCommodityPictureUploadServlet' enctype='multipart/form-data' method='post' target='target'><img src='${pageContext.request.contextPath }/img/a11.png' class='add-img'>"+
						"<input type='file' name='file' id='"+fileId+"' class='file' accept='video/*'  multiple='multiple'  /><input value='"+type+"' name='type' type='hidden'><input value='"+commodityId+"' name='commodityId' type='hidden'></form></section>";
						for(var i=0;i<picture.length;i++){
							var state="";
							if(picture[i].pictureState==1||picture[i].pictureState=='1'){
								state="<a class='pictureState' href='"+picture[i].pictureId+"'>停用</a>";
							}else{
								state="<a class='pictureState' href='"+picture[i].pictureId+"'>使用</a>";
							}
							table+="<div class='pic1'>"+
							"<video src='${pageContext.request.contextPath}/commodityImg/"+picture[i].pictureUrl+"' controls='controls' style='width:240px;'>你的浏览器不支持视频</video>"
							+state+"&nbsp;&nbsp;&nbsp;&nbsp;<a class='deleImg' href='"+picture[i].pictureId+"'>删除视频</a></div>";
						}
							$(".typebox2").css({
								"display":"block"
							});
							if(picture.length<1){
								$(".pictureType2").html(table2+table);
								}else{
									$(".pictureType2").html(table);
								}
					});

					
					
					
				}else{
					$.post("${pageContext.request.contextPath}/commodity/getCommodityPictureByCommodityIdServlet",param,function(date){
						date=eval(date);
						var picture=date[0];
						var table="";
						var table2="<section class='z_file fl pic' ><form id='"+formId+"' action='${pageContext.request.contextPath}/commodity/doCommodityPictureUploadServlet' enctype='multipart/form-data' method='post' target='target'><img src='${pageContext.request.contextPath }/img/a11.png' class='add-img'>"+
						"<input type='file' name='file' id='"+fileId+"' class='file' accept='image/jpg,image/jpeg,image/png,image/gif'  multiple='multiple' /><input value='"+type+"' name='type' type='hidden'><input value='"+commodityId+"' name='commodityId' type='hidden'></form></section>";
						for(var i=0;i<picture.length;i++){
							var state="";
							if(picture[i].pictureState==1||picture[i].pictureState=='1'){
								state="<a class='pictureState' href='"+picture[i].pictureId+"'>停用</a>";
							}else{
								state="<a class='pictureState' href='"+picture[i].pictureId+"'>使用</a>";
							}
							table+="<div class='pic1'><section class='up-section fl'>"+
							"<img src='${pageContext.request.contextPath}/img/a7.png' class='close-upimg' value='"+picture[i].pictureId+"'>"+
							"<img src='${pageContext.request.contextPath}/commodityImg/"+picture[i].pictureUrl+"' class='up-img'>"+
							"</section>"+state+"</div>";
						}
						if(type==1||type=='1'){
							$(".typebox1").css({
								"display":"block"
							});
							if(picture.length<5){
							$(".pictureType1").html(table2+table);
							}else{
								$(".pictureType1").html(table);
							}
						}else if(type==3||type=='3'){
							$(".typebox3").css({
								"display":"block"
							});
							if(picture.length<1){
								$(".pictureType3").html(table2+table);
								}else{
									$(".pictureType3").html(table);
								}
						}else{
							$(".typebox4").css({
								"display":"block"
							});
							if(picture.length<10){
								$(".pictureType4").html(table2+table);
								}else{
									$(".pictureType4").html(table);
								}
						}
					});
					
				
				}
				
			}
			
			
		});
	</script>
	<style>
		video {
	    object-fit: contain;
		}
		.pic1{
		height: 200px;width: 190px; display:inline-block;margin-right:20px;
		}
		.pic{
		margin-right:20px;
		}
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
		.z_photo .up-section{
			    margin-bottom: 0px;
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
					<div class="mycontent">
						<!--搜索输入框及查询、重置按钮-->
						<div class="container content_width">
							<div class="person_search">
								<div class="search_input">
									<div class="input-group mb-6">
										<span >选择商品</span>
										 <select class="form-control  getCommodity"
											style="font-size: 13px; color: #666; height: 35px;">
										</select>
									</div>
								</div>
								
									<span style="color: black;">👓显示图片</span>
								
								<select class="form-control pictureType"
											style="font-size: 13px; color: #666; height: 35px; width:100px ! important; display:inline;margin-top:15px;">
											<option value='1' selected="selected">轮播图</option>
											<option value='2'>视频</option>
											<option value='3'>广告图片</option>
											<option value='4'>详细图片</option>
								</select>
							</div>
							<div class="line"></div>
						</div>
				<div class="typebox1" style="display:none;">	
					<div class="mytitle">轮播图</div>
						<div class="img-box full">
							<section class=" img-section">
								<p class="up-p">轮播图<span class="up-span">上传图片要求应小于3MB,gif,png,jpg,jpe格式,最多可以上传5张图片，点击上传</span></p>
								<div class="z_photo upimg-div clear pictureType1 " >
										
								 </div>
							 </section>
						</div>
					<br/>
					<div class="line"></div>
				</div>	
				<div class="typebox2" style="display:none;">	
					<div class="mytitle">视频</div>
						<div class="img-box full">
							<section class=" img-section">
								<p class="up-p">视频<span class="up-span">视频长度不能大于60s，点击上传</span></p>
								<div class="z_photo upimg-div clear pictureType2 " >
								 </div>
							 </section>
						</div>
					<br/>
					<div class="line"></div>
					</div>	
				<div class="typebox3" style="display:none;">	
					<div class="mytitle">广告图片</div>
						<div class="img-box full">
							<section class=" img-section">
								<p class="up-p">广告图片<span class="up-span">只限上传一张,点击上传</span></p>
								<div class="z_photo upimg-div clear pictureType3 " >
								 </div>
							 </section>
						</div>
					<br/>
					<div class="line"></div>
				</div>
				<div class="typebox4" style="display:none;">	
					<div class="mytitle">详细图片</div>
						<div class="img-box full">
							<section class=" img-section">
								<p class="up-p"><span class="up-span">最多可以上传10张图片，点击上传</span></p>
								<div class="z_photo upimg-div clear pictureType4 " >
								 </div>
							 </section>
						</div>
					<br/>
					<div class="line"></div>
				</div>	
				<iframe id="target" name="target" class='target' style="display:none;"></iframe>
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