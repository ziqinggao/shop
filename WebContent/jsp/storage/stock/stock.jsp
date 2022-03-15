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
        	getTime();
        	var findRep = "";
        	datequery();
        	$("#searchParticulars").click(function(){
				var dateOrder = $("#dateOrder").val();
        		var merchantId = "${sessionScope.merchant.merchantId}";
        		datequery();
        	});
        	function datequery(){
        		var checkDate = $("#dateOrder").val();
        		var merchantId = "${sessionScope.merchant.merchantId}";
        		var param = {
        				merchantId:merchantId,
        				checkDate:checkDate
        		}
        		$.post("${pageContext.request.contextPath }/storage/GetRepertoryVServlet",param,function(data){
        			data = eval(data);
        			var state = "";
        			var send = "";
        			var table = "<table id='tb' class='table'><thead><tr><th>名称</th><th>详细类别</th><th>检查库存</th><th>统计库存</th><th>检查日期</th><th>检查人</th>"+
        			"<th>修改库存</th></tr></thead><tbody id='show_tbody'>";
        			for (var i = 0; i < data.length; i++) {
						table += "<tr><td>"+data[i].commodityName+"</td><td>"+data[i].subsort+"</td><td>"+data[i].checkRepertory+
						"</td><td>"+data[i].countRepertory+"</td><td>"+data[i].checkDate+"</td><td>"+data[i].checkName+
						"</td><td><a href='"+data[i].repertoryId+"' id='changeCheckDate'>修改</a></td></tr>";
					}
        			table = table + "</tbody></style>";
        			var showEmp = document.getElementById("showEmp");
        			showEmp.innerHTML = table;
        		});
        	}
	        //点击更改，触发新的拟态框
	   		 $(document).on("click","#changeCheckDate",function(event){
	   			 	event.preventDefault();
	   		 		var repertoryId = $(this).attr("href");
	   		 		//盘点库存
	   		 		var c = $(this).parent().siblings().eq(2).html();
	   		 		$("#repertoryText").val(c); 
	   		 		$("#changeCheck").modal("show");
	   		 		updateRepertory(repertoryId);
	   		 });
	        function updateRepertory(repertoryId){
	        	$("#updateRepertory").click(function(){
	        		var checkRepertory = $("#repertoryText").val();
	        		var param = {
	        				repertoryId:repertoryId,
	        				checkRepertory:checkRepertory
	        		}
	        		$.post("${pageContext.request.contextPath }/storage/DoUpdRepertoryServlet",param,function(){
	        			alert("添加成功");
	        			$("#changeCheck").modal("hide");
	        			$("#renyuan").modal("hide");
						$(".modal-backdrop.fade").hide();
						datequery();
	        		})
	        	});
	        }
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
        	//查询是否有当天的数据
        	function getquery(){
        		getTime();
        		var checkDate = $("#dateOrder").val();
        		var merchantId = "${sessionScope.merchant.merchantId}";
        		var param = {
        				merchantId:merchantId,
        				checkDate:checkDate
        		}
        		 $.ajax({
     				url:"${pageContext.request.contextPath }/storage/FindRepertoryVServlet",
     				async:false,
     				type:"post",
     				data:param,
     				success:function(data){
     					data = eval(data);
            			if(data == true || data == "true"){
            				alert("您今天已经初始化过数据了");
            			}else{
            				alert("您今天并没有初始化过数据");
            			}
     				}
        		 });
        		/* var param = {
        				merchantId:merchantId,
        				checkDate:checkDate
        		}
        		$.post("${pageContext.request.contextPath }/storage/FindRepertoryVServlet",param,function(data){
        			data = eval(data);
        			if(data == true || data == "true"){
        				alert("您今天已经初始化过数据了");
        			}else{
        				alert("您今天并没有初始化过数据");
        			}
        		}); */
        	}
        	//点击初始化库存
        	$("#initialize").click(function(){
        		getquery();
        		con();
        	})
        	function con(){
        		var a = confirm("您确定要初始化数据？？？");
        		if(a == true || a == "true"){
	        		var checkDate = $("#dateOrder").val();
	        		var merchantId = "${sessionScope.merchant.merchantId}";
	        		var param = {
	        				merchantId:merchantId,
	        				checkDate:checkDate
	        		}
	        		 $.ajax({
	      				url:"${pageContext.request.contextPath }/storage/DoRepertoryServlet",
	      				async:false,
	      				type:"post",
	      				data:param,
	      				success:function(data){
	      					data = eval(data);
		        			if(data == true||data == "true"){
		        				alert("初始化成功");
		        				datequery();
		        			}
	      				}
	        		 });
	        		/* $.post("${pageContext.request.contextPath }/storage/DoRepertoryServlet",param,function(data){
	        			data = eval(data);
	        			if(data == true||data == "true"){
	        				alert("初始化成功");
	        				datequery();
	        			}
	        		}); */
        		}
        	}
        	//获取系统休眠时间
        	 function sleep(n) {
		        var start = new Date().getTime();
		        while (true) {
		            if (new Date().getTime() - start > n) {
		                break;
		            }
		        }
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
                </div>
                
                <div class="search_input">
                 <span>查询方式：</span> &nbsp; &nbsp; <input id="dateOrder" type="date" class="form-control" style="width:160px;">
                	<button class="btn btn-primary search_btn" type="button" id="searchParticulars">查询</button>
                </div>
                <div class="search_input">
                	<button class="btn btn-primary search_btn" type="button" id="initialize">初始化库存</button>
                </div>
            </div>
            <div class="line"></div>
        </div>
        <!--添加按钮及bootstrap的模态框-->
		 <div class="export">
            <div class="modal fade" id="changeCheck">
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
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>请输入您要更新的盘点库存</label>
                                    </td>
                                    <td><input type="number" id="repertoryText" placeholder="请输入库存"/></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button id="updateRepertory" type="button" class="btn btn-secondary">确定</button>
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