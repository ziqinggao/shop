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
	  		var INSERTORUPDATE=false;//判断点击事件时添加还是修改
	  		var INSERT=false;
  			var maxpages;//存放最大页数
  			$(".pages").val('1');//先设置默认页
			var subtypeList={};//存放类型对象
			var COMMODITYID;//定义商品ID
		    //创建页数下拉选择框
		    foundOption();
  			//加载页面时加载所有商品信息，显示所有商品
  			showCommodity();
		    //执行显示类型的方法
		    showType();
		    
		    //关闭模态框点击事件
			$(document).on("click",".closeCommodity",function(){
				INSERTORUPDATE=false;
				$(".commodityName").val("");
			 	$('.commodityDescribe').val("");
			 	$('.commodityPice').val("");
			  	$('.vipPice').val("");
			  	$(".subtype option[value='']").prop("selected",true);
				$('#renyuan').modal('hide');
				$(".modal-backdrop.fade").hide();
			});
		    //重置功能
		    $("#back_btn").click(function(){
		    	location.reload(); 
		    });
		    //添加商品的点击事件
		    $("#new_add").click(function(){
		    	$(".modal-title").html("添加商品");
		    	$('#renyuan').modal('show');
		    });
	  		//修改商品信息的点击事件
	  		$(document).on("click","#insertCommodity",function(){
	  			//设置事件为添加事件
	  			INSERTORUPDATE=true;
	  			$(".modal-title").html("修改商品");
	  			COMMODITYID=$(this).parent().siblings("td").eq(0).attr("commodityId"); 
	  			var commodityName=$(this).parent().siblings("td").eq(0).html(); 
	  			var commodityDescribe=$(this).parent().siblings("td").eq(1).html();
	  			var price=new Number($(this).parent().siblings("td").eq(2).html());
	  			var vipPrice=new Number($(this).parent().siblings("td").eq(3).html());
	  			var subType=new Number($(this).parent().siblings("td").eq(4).attr("subTypeId"));
	  			//弹出模态框
	  			$('#renyuan').modal('show');
				$(".commodityName").val(commodityName);
			 	$('.commodityDescribe').val(commodityDescribe);
			 	$('.commodityPice').val(price);
			  	$('.vipPice').val(vipPrice);
			  	//设置下拉框为默认id
			  	$(".subtype option[value="+subType+"]").prop("selected",true);
	  		});
	  		//上下架点击事件
	  		$(document).on("click", "#saleState", function(){ 
	  			//获取商品Id
	  			var commodityId=$(this).parent().siblings("td").eq(0).attr("commodityId"); 
	  			//获取销售状态的值
	  			var saleState=$(this).parent().siblings("td").eq(7).html();
	  			//获取点击事件的值用来判断上架/下架的操作
	  			var state=$(this).attr("state");
	  			var stateInt=getSaleStateByString(saleState);
	  			if(state==stateInt){
		            showCommodity();
	  				bootbox.alert({
		                title: "来自火星的提示",
		                message: "该商品"+saleState,
		                closeButton:false
		            })
		            return
	  			}else{
	  				var param={
	  						commodityId:commodityId,
	  						state:state
	  				}
	  				$.post("${pageContext.request.contextPath}/commodity/doUpdSaleStateServlet",param,function(data){
	  					if(data==true||data=="true"){
	  						alert( "该商品"+getSaleStateByInt(state));
	  						showCommodity();
	  					}else{
	  						alert( "该商品上下架失败");
	  						showCommodity();
	  					}
	  					
	  				});
	  			}
			}); 
	  
	  		//上一页点击事件
	  		$(".uppage").click(function(){
	  			var pages=new Number($(".pages").val());
	  			if(pages==1||pages=='1'){
	  				 bootbox.alert({
			                title: "来自火星的提示",
			                message: "这是第一页",
			                closeButton:false
			            })
			            return
	  			}else{
	  				pages=pages-1;
	  				$(".pages option[value="+pages+"]").prop("selected",true);
	  				showCommodity();
	  			}
	  		});
	  		//下一页点击事件
	  		$(".nextpage").click(function(){
	  			var pages=new Number($(".pages").val());
	  			if(pages==maxpages){
	  				 bootbox.alert({
			                title: "来自火星的提示",
			                message: "这是最后一页",
			                closeButton:false
			            })
			            return
	  			}else{
	  				pages=pages+1;
	  				$(".pages option[value="+pages+"]").prop("selected",true);
	  				showCommodity();
	  			}
	  		});
	  		//创建下拉选择框发生改变时的事件
	  		$(".pages").change(function(){
	  			showCommodity();
	  		});
	  		//创建查询点击事件
	  		$("#search_btn").click(function(){
	  			INSERT=true;
	  			//设置默认页数为1
	  			$(".pages").val('1');
	  			//查询方法
	  			showCommodity();
	  			//创建页数下拉选择框
			    foundOption();
	  		});
		  //创建页数选择框
		  function foundOption(){
				//获取搜索输入框的值
	  			var commodityName=$("#Ktext").val().trim();
	  			$.post("${pageContext.request.contextPath}/commodity/getSerachPageServlet",{commodityName:commodityName},function(data){
	  				 var option="";
	  					maxpages=data;
	  				  for(var i=1;i<=data;i++){
	  					  option+="<option class='searchPages' value='"+i+"' >"+i+"</option>"
	  				  }
	  				  $(".pages").html(option);
	  			});
	  		}
		  //显示所有类型名称
		  function showType(){
			   $.ajax({
				    type: "POST",
				    url: "../../../commodity/ShowCommodityTypeServlet",
				    data: {},
				    async:false,
				    success: function(data){
						  data=eval(data);
						  var type=data[0];
						  var table="";
						  for(var i=0; i<type.length;i++){
							  var subname=showSubtype(type[i].typeId);
							  table+="<optgroup label='"+type[i].typeName+"'>"+subname+"</optgroup>";
						  }
						  $('.subtype').append(table);
					  },
				    error: function(){
				    }
				}); 
		  }
		  //显示详细类型名称
		  function showSubtype(typeId){
			  var table1="";
			   $.ajax({
				    type: "POST",
				    url: "../../../commodity/ShowCommoditySubtypeServlet",
				    data: {typeId:typeId},
				    async:false,
				    success: function(data1){
						  data1=eval(data1);
						  var subtype=data1[0];
						   for(var i=0; i<subtype.length;i++){
							   subtypeList[subtype[i].subtypeId]=subtype[i].subtypeName;
							  table1+="<option value='"+subtype[i].subtypeId+"'>"+subtype[i].subtypeName+"</option>";
						  }
					  },
				    error: function(){
				    }
				});
			  return table1;
		  	}
	  		//显示所有商品的方法
		    function showCommodity(){
		  			//获取当前页数
			  		var pages=$(".pages").val();
		  			//获取搜索输入框的值
		  			var commodityName=$("#Ktext").val().trim();
		  			//如果是显示全部商品就是空
		  			if(!INSERT){
		  				commodityName='';
		  			}
		  			
		  			$.post("${pageContext.request.contextPath}/commodity/getCommodityAllServlet",{pages:pages,commodityName:commodityName},function(data){
				  		data=eval(data);
				  		var commodity=data[0];
				  		console.log(commodity);
		  				console.log(subtypeList[commodity[1].subtypeId]);
				  		var table="";
				  		for(var i=0;i<commodity.length;i++){
				  			var subtypeId=commodity[i].subtypeId;
				  			var checkState=getState(commodity[i].checkInfo);
				  			var saleState=getSaleStateByInt(commodity[i].saleInfo);
				  			table+="<tr>"
				  					+"<td commodityId='"+commodity[i].commodityId+"'>"+commodity[i].commodityName
				  					+"</td><td>"+commodity[i].commodityDescribe
				  					+"</td><td>"+commodity[i].price
				  					+"</td><td>"+commodity[i].vipPrice
				  					+"</td><td subTypeId='"+subtypeId+"'>"+subtypeList[commodity[i].subtypeId]
				  					+"</td><td>"+checkState
				  					+"</td><td>"+commodity[i].checkDate
				  					+"</td><td>"+saleState  // href='${pageContext.request.contextPath}/commodity/doUpdSaleStateServlet?commodityId="+commodity[i].commodityId+"&state='1'
				  					+"</td><td><a id='saleState' href='#' state='1'>上架</a>&nbsp;&nbsp;&nbsp;&nbsp;"
				  					+"<a href='#' id='saleState' state='2'>下架</a>&nbsp;&nbsp;&nbsp;&nbsp;"
				  					+"<a href='#' id='insertCommodity' class='edit'> 修改商品 </a></td></tr>"
				  		}
				  		//显示当前页的数据
				  		$("#show_tbody").html(table);
				  	});
	  		}
			//判断审核状态
		  	function getState( info){
		  		if(info==1||info=='1'){
		  			return "等待审核";
		  		}else if(info==2||info=='2'){
		  			return "审核不通过";
		  		}else{
		  			return "审核通过";
		  		}
		  	}
		  //通过数字判断销售状态
		  	function getSaleStateByInt( info){
		  		if(info==1||info=='1'){
		  			return "已上架";
		  		}else{
		  			return "已下架";
		  		}
		  	}
		  //通过字符串判断销售状态
		  function getSaleStateByString( info){
			  if(info=='已上架'){
				  return 1;
			  }else{
				  return 2;
			  }
		  }
		  //点击确定时发生的事情
		  $("#add_btn").click(function(){
			  //商品名称
			  var commodityName=$(".commodityName").val();
			  //商品描述
			  var commodityDescribe=$('.commodityDescribe').val();
			  //商品价格
			  var commodityPice=$('.commodityPice').val();
			  //商品vip价格
			  var vipPice=$('.vipPice').val();
			  //获取类型ID
			  var subtypeId=$('.subtype').val();
			  //var subtypeid=$('.subtype').attr("subtypeID");
			  //alert($('.subtype').val());
			  //commodityDescribe commodityPice vipPice
			  if ($('.commodityName').val().trim()==='') {
			      alert("商品名称为必选项，请填写");
			      return
			  }
			  if ($('.commodityPice').val().trim()==='') {
			     alert("基础价格为必选项，请填写");
			      return
			  }
			  if ($('.commodityPice').val().trim()<'0'||$('.commodityPice').val().trim()< 0) {
			      alert("基础价格不能为负数，请输入正确值");
			      $('.commodityPice').val("");
			      return
			  }
			  
			  if ($('.vipPice').val().trim()<'0'||$('.vipPice').val().trim()<0) {
			      alert("基础价格不能为负数，请输入正确值");
			      $('.vipPice').val("");
			      return
			  }
						  
			  var param={
					  commodityName:commodityName,
					  commodityDescribe :commodityDescribe,
					  commodityPice :commodityPice,
					  commodityVipPice:vipPice,
					  subtypeId:subtypeId,
					  commodityId:COMMODITYID
			  }
			  
			  if(INSERTORUPDATE==true||INSERTORUPDATE=='true'){
				  //执行修改语句
				  $.post("${pageContext.request.contextPath}/commodity/doUpdCommodityServlet",param,function(data){
				  if(data ==true || data=="true"){
					  //执行显示功能
					  	alert("商品修改成功");
					  	showCommodity();
					 }else{
						alert( "商品修改失败");
						showCommodity();
					 }
				  INSERTORUPDATE=false;
					$(".commodityName").val("");
				 	$('.commodityDescribe').val("");
				 	$('.commodityPice').val("");
				  	$('.vipPice').val("");
				  	$(".subtype option[value='']").prop("selected",true);
					$('#renyuan').modal('hide');
					$(".modal-backdrop.fade").hide();
			  	});
			  }else{
				  $.post("${pageContext.request.contextPath}/commodity/DoInsCommodityServlet",param,function(data){
					  if(data ==true || data=="true"){
						  //执行显示功能
						  	alert("商品添加成功");
						  	showCommodity();
						 }else{
							alert( "商品添加失败");
							showCommodity();
						 }
						  INSERTORUPDATE=false;
						$(".commodityName").val("");
					 	$('.commodityDescribe').val("");
					 	$('.commodityPice').val("");
					  	$('.vipPice').val("");
					  	$(".subtype option[value='']").prop("selected",true);
						$('#renyuan').modal('hide');
						$(".modal-backdrop.fade").hide();
				  });
			  }
				
		  });
  });
  </script>
	<style>
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
										 <select class="form-control"
											style="font-size: 13px; color: #666; height: 35px;">
											<option>商品名称</option>
										</select>
										<!-- <span>请输入要查询的商品名称</span> -->
										<input id="Ktext" type="text" class="form-control">

									</div>
								</div>
								<div class="search_input">
									<div class="input-group mb-3" hidden>
										<span>工号：</span> <input id="job_num" type="text"
											class="form-control" placeholder="请输入工号">
									</div>
								</div>
								<div class="search_input">
									<button class="btn btn-primary search_btn" type="button"
										id="search_btn">查询</button>
									<button class="btn btn-primary search_btn" type="button"
										id="back_btn">重置</button>
								</div>

								<button id="new_add" type="button" class="btn btn-primary "
									style="margin-top: 15px; margin-left: 10px; padding: 0; height: 35px; width: 100px">
									 <span>➕添加商品</span>
								</button>
							</div>
							<div class="line"></div>
						</div>
						<!--添加按钮及bootstrap的模态框-->
						<style>
						textarea {
							height: 35px;
							width: 100%;
						}
						.bootbox {
						    opacity: 1 ! important;
						}
						</style>
						<div class="export" >
							<div class="modal fade" id="renyuan"  >
								<div class="modal-dialog modal-lg modal_position">
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title"></h4>
											<button type="button" class="close closeCommodity" >&times;</button>
										</div>
										<div class="modal-body">
											<table id="xztb" class="table">
												<!--新修改弹窗的样式-->
												<tbody>
													<tr>
														<!-- <td class="tb_bg"><label for=""><font
																style="font-size: 14px; color: red;">*</font>商品ID</label></td>
														<td><input class="commodityID" type="text"
															disabled="disabled" value="等待系统自动分配中"></td> -->
														<td class="tb_bg"><label for=""><font
																style="font-size: 14px; color: red;">*</font>商品名称</label></td>
														<td><input class="commodityName" type="text"
															name="commodityName" placeholder="请输入商品名称"></td>	
														<td class="tb_bg"><label for=""><font
																style="font-size: 14px; color: red;"></font>商品类型</label></td>
														<td><select class="form-control subtype"
															style="font-size: 13px; color: #666; height: 35px;"
															name="subtype">
														</select></td>
													</tr>
													<tr>
														<td class="tb_bg"><label for=""><font
																style="font-size: 14px; color: red;">*</font>基础价格</label></td>
														<td><input class="commodityPice" type="number"
															min="0" placeholder="请输入基础价格"></td>
														<td class="tb_bg"><label for="">VIP价格</label></td>
														<td><input class="vipPice" type="number" min="0"
															placeholder="请输入VIP价格"></td>
														
													</tr>
													<tr>
														<td class="tb_bg"><label for=""><font
																style="font-size: 14px; color: red;"></font>商品描述</label></td>
														<td >
														<!-- <input class="commodityDescribe" type="text"
															placeholder="对商品的描述" /> -->
														 <textarea class="commodityDescribe" ></textarea>	
														</td>
														
													</tr>
													<!-- <tr>
														<td class="tb_bg"><label for=""><font
																style="font-size: 14px; color: red;"></font>审核状态</label></td>
														<td><input type="text" disabled="disabled"
															value="等待审核"></td>
														<td class="tb_bg"><label for="">审核时间</label></td>
														<td><input type="text" disabled="disabled"></td>
													</tr> -->
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary closeCommodity"
												>取消</button>
											<button id="add_btn" type="button" class="btn btn-secondary">确定</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--表格列表-->

						<table id="tb" class="table commodity">
							<thead>
								<tr>
									<th>商品名称</th>
									<th>商品描述</th>
									<th>基础价格</th>
									<th>VIP价格</th>
									<th>类型</th>
									<th>审核状态</th>
									<th>审核时间</th>
									<th>销售状态</th>
									<th>商品管理</th>
								</tr>
							</thead>
							<tbody id="show_tbody">
								<!-- 从数据库获取的值 -->
							</tbody>
						</table>
						<style>
						.search_input1 {
							height: 35px;
							line-height: 35px;
							margin: 15px 10px 0 0;
							float: right;
						}
						</style>
						<div class="line"></div>

						<div class="search_input1">
							<div class="input-group mb-2">
								<a class="uppage" href="#">上一页</a>
								 <select class="form-control  pages"
									style="font-size: 13px; color: #666; height: 35px; widht: 50px; margin: 0 20px;">
									<option value="1">1</option>
								</select> 
								<a class="nextpage" href="#">下一页</a>
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
								target="_blank" href="#">“南老板”电商网</a>
						</h6>
					</div>
					<div>
						<svg class="waves"
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