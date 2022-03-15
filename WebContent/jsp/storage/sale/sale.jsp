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
	<script src="${pageContext.request.contextPath }/js/admin/mejs.js"></script>
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    <script type="text/javascript">
        $(function(){
        	var countMax = 0;
        	var countStateMax = 0;
        	var countDateMax = 0;
        	var max = 0;
        	var m = "${sessionScope.merchant.merchantId}";
    		CountMax(m);
        	query(); 
        	function query(){
        		max = 0;
        		var merchantId = "${sessionScope.merchant.merchantId}";
        		var limit = $("#optionPage").val();
        		var param = {
        				merchantId:merchantId,
        				limit:limit
        		}
        		$.post("${pageContext.request.contextPath }/storage/GetOrderParticularsVServlet",param,function(data){
        			data = eval(data);
        			var state = "";
        			var send = "";
        			var table = "<table id='tb' class='table'><thead><tr><th>类别</th><th>数量</th><th>单价</th><th>总价</th><th>购买日期</th>"+
        			"<th>状态</th><th>用户地址</th><th>发货日期</th><th>发货</th></tr></thead><tbody id='show_tbody'>";
        			for (var i = 0; i < data.length; i++) {
        				if(data[i].state == 1 || data[i].state == "1"){
        					state = "未支付";
        					send = "发货";
        				}else if(data[i].state == 2 || data[i].state == "2"){
        					state = "已经支付";
        					send = "发货";
        				}else if(data[i].state == 3 || data[i].state == "3"){
        					state = "已发货";
        					send = "";
        				}else if(data[i].state == 4 || data[i].state == "4"){
        					state = "已收货";
        					send = "";
        				}else if(data[i].state == 5 || data[i].state == "5"){
        					state = "已退货";
        					send = "";
        				}else if(data[i].state == 6 || data[i].state == "6"){
        					state = "已评价";
        					send = "";
        				}
						table += "<tr><td>"+data[i].subsort+"</td><td>"+data[i].commodityNumber+"</td><td>"+data[i].commodityPrice+
						"</td><td>"+data[i].commodityPrices+"</td><td>"+data[i].buyDate+"</td><td>"+state+"</td><td>"+data[i].location+
						"</td><td>"+data[i].sendDate+"</td><td><a href='"+data[i].particularsId+"' id='send'>"+send+"</a></td></tr>";
					}
        			table = table + "</tbody></style>";
        			var showEmp = document.getElementById("showEmp");
        			showEmp.innerHTML = table;
        		});
        	}
        	//将未发货状态，改成发货状态
        	$(document).on("click","#send",function(event){
        		event.preventDefault();
        		var s = confirm("您将要发货是吗？？？");
        		var state = 3;
        		var particularsId = $(this).attr("href");
        		if(s == true){
        			var param = {
        					particularsId:particularsId,
        					state:state
        			}
        			$.post("${pageContext.request.contextPath }/storage/DoUpdOrderParticularsServlet",param,function(){
        				alert("发货成功");
        				query();
        			});
        		}
        	});
        	//根据状态查询不同的订单
        	$("#optionOrder").change(function(){
        		var state = $("#optionOrder").val();
        		var merchantId = "${sessionScope.merchant.merchantId}";
        		CountStateMax(state,merchantId);
        		max = 1;
        		statequery();
        	});
        	function statequery(){
        		var state = $("#optionOrder").val();
        		var limit = $("#optionPage").val();
        		var merchantId = "${sessionScope.merchant.merchantId}";
        		if(limit == ""||limit == null){
        			limit = 1;
        		}
        		var param = {
        				merchantId:merchantId,
        				state:state,
        				limit:limit
        		}
        		$.post("${pageContext.request.contextPath }/Storage/GetOrderParticularsVByStateServlet",param,function(data){
        			data = eval(data);
        			console.log(data);
        			var state = "";
        			var send = "";
        			var table = "<table id='tb' class='table'><thead><tr><th>类别</th><th>数量</th><th>单价</th><th>总价</th><th>购买日期</th>"+
        			"<th>状态</th><th>用户地址</th><th>发货日期</th><th>发货</th></tr></thead><tbody id='show_tbody'>";
        			for (var i = 0; i < data.length; i++) {
        				if(data[i].state == 1 || data[i].state == "1"){
        					state = "未支付";
        					send = "发货";
        				}else if(data[i].state == 2 || data[i].state == "2"){
        					state = "已经支付";
        					send = "发货";
        				}else if(data[i].state == 3 || data[i].state == "3"){
        					state = "已发货";
        					send = "";
        				}else if(data[i].state == 4 || data[i].state == "4"){
        					state = "已收货";
        					send = "";
        				}else if(data[i].state == 5 || data[i].state == "5"){
        					state = "已退货";
        					send = "";
        				}else if(data[i].state == 6 || data[i].state == "6"){
        					state = "已评价";
        					send = "";
        				}
						table += "<tr><td>"+data[i].subsort+"</td><td>"+data[i].commodityNumber+"</td><td>"+data[i].commodityPrice+
						"</td><td>"+data[i].commodityPrices+"</td><td>"+data[i].buyDate+"</td><td>"+state+"</td><td>"+data[i].location+
						"</td><td>"+data[i].sendDate+"</td><td><a href='"+data[i].particularsId+"' id='send'>"+send+"</a></td></tr>";
					}
        			table = table + "</tbody></style>";
        			var showEmp = document.getElementById("showEmp");
        			showEmp.innerHTML = table;
        		});
        	}
        	//根据日期查询订单
        	$("#searchParticulars").click(function(){
				var dateOrder = $("#dateOrder").val();
        		var merchantId = "${sessionScope.merchant.merchantId}";
        		CountDateMax(dateOrder,merchantId);
        		max = 2;
        		datequery();
        	});
        	function datequery(){
        		var dateOrder = $("#dateOrder").val();
        		var limit = $("#optionPage").val();
        		var merchantId = "${sessionScope.merchant.merchantId}";
        		if(limit == ""||limit == null){
        			limit = 1;
        		}
        		var param = {
        				sendDate:dateOrder,
        				merchantId:merchantId,
        				limit:limit
        		}
        		$.post("${pageContext.request.contextPath }/storage/GetOrderParticularsVBySendDateServlet",param,function(data){
        			data = eval(data);
        			var state = "";
        			var send = "";
        			var table = "<table id='tb' class='table'><thead><tr><th>类别</th><th>数量</th><th>单价</th><th>总价</th><th>购买日期</th>"+
        			"<th>状态</th><th>用户地址</th><th>发货日期</th><th>发货</th></tr></thead><tbody id='show_tbody'>";
        			for (var i = 0; i < data.length; i++) {
        				if(data[i].state == 1 || data[i].state == "1"){
        					state = "未支付";
        					send = "发货";
        				}else if(data[i].state == 2 || data[i].state == "2"){
        					state = "已经支付";
        					send = "发货";
        				}else if(data[i].state == 3 || data[i].state == "3"){
        					state = "已发货";
        					send = "";
        				}else if(data[i].state == 4 || data[i].state == "4"){
        					state = "已收货";
        					send = "";
        				}else if(data[i].state == 5 || data[i].state == "5"){
        					state = "已退货";
        					send = "";
        				}else if(data[i].state == 6 || data[i].state == "6"){
        					state = "已评价";
        					send = "";
        				}
						table += "<tr><td>"+data[i].subsort+"</td><td>"+data[i].commodityNumber+"</td><td>"+data[i].commodityPrice+
						"</td><td>"+data[i].commodityPrices+"</td><td>"+data[i].buyDate+"</td><td>"+state+"</td><td>"+data[i].location+
						"</td><td>"+data[i].sendDate+"</td><td><a href='"+data[i].particularsId+"' id='send'>"+send+"</a></td></tr>";
					}
        			table = table + "</tbody></style>";
        			var showEmp = document.getElementById("showEmp");
        			showEmp.innerHTML = table;
        		});
        	}
        	//查询数据最大笔数
        	function CountMax(merchantId){
        		$.ajax({
        			url:"${pageContext.request.contextPath}/storage/CountParticularsVServlet",
        			async:false,//将事件变成同步
        			data:{"merchantId":merchantId},
        			type:"post",
        			success:function(data){
        				countMax = Math.ceil(eval(data)/2);
        				if(countMax == 0){
        					countMax = 1;
        				}
        				var option = "";
            			for (var i = 1; i <= countMax; i++) {
    						option += "<option value='"+i+"'>"+i+"</option>";
    					}
            			var pageoption = document.getElementById("optionPage");
            			pageoption.innerHTML = option;
        			}
        		});
        	}
        	//查询某种状态下的数据最大笔数
        	function CountStateMax(state,merchantId){
        		$.ajax({
        			url:"${pageContext.request.contextPath}/storage/CountParticularsVStateServlet",
        			async:false,
        			data:{"state":state,"merchantId":merchantId},
        			type:"post",
        			success:function(data){
        				countStateMax = Math.ceil(eval(data)/2);
        				if(countDateMax == 0){
        					countMax = 1;
        				}
        				var option1 = "";
        				for (var i = 1; i <= countStateMax; i++) {
							option1 += "<option>"+i+"</option>";
						}
        				var pageoption1 = document.getElementById("optionPage");
        				pageoption1.innerHTML = option1;

        			}
        		});
        	}
        	//查询某个日期下数据的最大笔数
        	function CountDateMax(date,merchantId){
        		$.ajax({
        			url:"${pageContext.request.contextPath}/storage/CountParticularsVDateServlet",
        			async:false,
        			data:{"sendDate":date,"merchantId":merchantId},
        			type:"post",
        			success:function(data){
        				countDateMax = Math.ceil(eval(data)/2);
        				if(countDateMax == 0){
        					countMax = 1;
        				}
        				var option2 = "";
        				for (var i = 1; i <= countDateMax; i++) {
							option2 += "<option>"+i+"</option>";
						}
        				var pageoption2 = document.getElementById("optionPage");
        				pageoption2.innerHTML = option2;
        			}
        		})
        	}
        	//
        	//上一页查询
        	$(".uppage").click(function(){
        		var optionPage = $("#optionPage").val();
        		if(optionPage == ""){
        			optionPage = 0;
        		}
        		if(optionPage == 1 ||optionPage == 0||optionPage == "1"||optionPage == "1"){
        			alert("没有上一页了");
        			$("#optionPage").val(1);
        		}else{
        			if(max == 0){
        				$("#optionPage").val(optionPage-1);
        				query();
        			}else if(max == 1){
        				$("#optionPage").val(optionPage-1);
        				statequery();
        			}else if(max == 2){
        				$("#optionPage").val(optionPage-1);
        				datequery();
        			}
        		}
        	});
        	//下一页查询
        	$(".nextpage").click(function(){
        		var optionPage = $("#optionPage").val();
        		if(max == 0){
    				if(optionPage == countMax||countMax == 1||countMax == "1"||countMax == 0||countMax == "0"){
    					alert("没有下一页了");
    				}else{
    					optionPage = parseInt(optionPage)+1;
    					$("#optionPage").val(optionPage);
	    				query();
    				}
    			}else if(max == 1){
    				if(optionPage == countStateMax||countStateMax == 1||countStateMax == "1"||countStateMax == 0||countStateMax == "0"){
    					alert("没有下一页了");
    				}else{
    					optionPage = parseInt(optionPage)+1;
    					$("#optionPage").val(optionPage);
	    				statequery();
    				}
    			}else if(max == 2){
    				if(optionPage == countDateMax ||countDateMax == 1||countDateMax == "1"||countDateMax == 0||countDateMax == "0"){
    					alert("没有下一页了");
    				}else{
    					optionPage = parseInt(optionPage)+1;
    					$("#optionPage").val(optionPage);
	    				datequery();
    				}
    			}
        	});
        	//当输入框发生改变
        	$("#optionPage").change(function(){
        		if(max == 0){
    				query();
    			}else if(max == 1){
    				var state = $("#optionOrder").val();
            		var merchantId = "${sessionScope.merchant.merchantId}";
            		CountStateMax(state,merchantId);
    				statequery();
    			}else if(max == 2){
    				var dateOrder = $("#dateOrder").val();
            		var merchantId = "${sessionScope.merchant.merchantId}";
            		CountDateMax(dateOrder,merchantId);
    				datequery();
    			}
        	});
        	//获取当前系统年月日,时分秒
        	function getTime(){
        		var date = new Date();
        		var year = date.getFullYear()+"";
        		var month = date.getMonth();
        		//获取天数
        		var day = date.getDate()+"";
        		//获取星期
        		var week = date.getDay+"";
        		var hour=date.getHours()+""; //获取小时 
        		var min=date.getMinutes()+""; //获取分钟 
        		var sec=date.getSeconds()+""; //获取秒钟 
        		if(sec.length=="1"){
        			sec = "0"+sec;
        		};
        		if(min.length=="1"){
        			min = "0"+min;
        		};
        		if(hour.length=="1"){
        			hour = "0"+hour;
        		};
        		if(day.length=="1"){
        			day = "0"+day;
        		};
        		month=month+1;
        		if((month+"").length=="1"){
        			month = "0"+month;
        		};
        		var titleDate = year+"-"+month+"-"+day; //组合系统时间 
        		var time = hour+":"+min; //组合系统时间 
        		$("#dateOrder").val(titleDate);
        	}
        })	
     </script>
  </head>
  <body>
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
			<div class="mybox">
    <div class="title" style="color:black;text-align:center;">商品销售清单</div>
    <div class="content">
        <!--搜索输入框及查询、重置按钮-->
        <div class="container content_width">
            <div class="person_search">
                <div class="search_input">
                    <div class="input-group mb-3">
                         <select class="form-control" id="optionOrder" style="font-size: 13px; color: #666; height: 35px;">
                            <option value="1">未支付订单</option>
                            <option value="2">已支付订单</option>
                            <option value="3">已发货订单</option>
                            <option value="4">已收货订单</option>
                            <option value="5">已退货订单</option>
                            <option value="6">已评价订单</option>
                        </select>
                    </div>
                </div>
                
                <div class="search_input">
                       &nbsp; &nbsp;<span color="black">发货日期：</span> <input id="dateOrder" type="date" class="form-control" style="width:160px;">
                	<button class="btn btn-primary search_btn" type="button" id="searchParticulars">查询</button>
                </div>
            </div>
            <div class="line"></div>
        </div>
        <!--添加按钮及bootstrap的模态框-->
		
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
		
		<div class="line"></div>
    </div>
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
          <!-- Page Header-->
          <!-- Dashboard Counts Section-->
          <!-- 页脚 模块-->
          
        </div>
      </div>
    </div>
  </body>
</html>