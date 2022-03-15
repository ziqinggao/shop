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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/manage.css">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
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
    <script>
    $(function(){
    	 showreturn();
    	 getstockreturn();
    	 var price={};
    	 var returnId;
    	 var maxNumber={};
    	 var bounced=true;
    	 
    	$("#search_btn").click(function(){
    		showmerchant();
    	});
    	//根据日期查询退货清单
    	function showmerchant(){
    		var returndate=$("#Ktext").val();
    		var param={
    				returndate:returndate
    				
    		}
    		$.post("${pageContext.request.contextPath}/storage/GetMerchantReturnVServlet",param,function(data){
    			data=eval(data);
    			console.log(data);
    			var merchantreturn=data[0];
    			if(merchantreturn!=0){
        			var table="";
        			for(var i=0;i<merchantreturn.length;i++){
            			table+="<tr><td>"+merchantreturn[i].commodityName
            			+"</td><td>"+merchantreturn[i].subsort
            			+"</td><td>"+merchantreturn[i].returnNumber
            			+"</td><td>"+merchantreturn[i].returnPrice
            			+"</td><td>"+merchantreturn[i].returnPrices
            			+"</td><td>"+merchantreturn[i].returnCause
            			+"</td><td>"+merchantreturn[i].buystockDate
            			+"</td><td>"+merchantreturn[i].returnDate
            			+"</td><td> <a id='Update' href='"+merchantreturn[i].returnId+"'>修改进货商品</a>"
            			+"</td></tr>";
        			}
        			$("#show_tbody").html(table);
    				
    			}else{
    				alert("当天没有退货商品");
    			}
    			
    			
    		});
    	}
    	
    	
    	$("#back_btn").click(function(){
        	window.location.reload();
        	
        });
    	//显示退货清单信息
    	function showreturn(){
    		$.post("${pageContext.request.contextPath}/storage/MerchantReturnServlet",{},function(data){
    			data=eval(data);
    			var merchantreturn=data[0];
    			var table="";
    			for(var i=0;i<merchantreturn.length;i++){
        			table+="<tr><td>"+merchantreturn[i].commodityName
        			+"</td><td>"+merchantreturn[i].subsort
        			+"</td><td>"+merchantreturn[i].returnNumber
        			+"</td><td>"+merchantreturn[i].returnPrice
        			+"</td><td>"+merchantreturn[i].returnPrices
        			+"</td><td>"+merchantreturn[i].returnCause
        			+"</td><td>"+merchantreturn[i].buystockDate
        			+"</td><td>"+merchantreturn[i].returnDate
        			+"</td><td> <a id='Update' href='"+merchantreturn[i].returnId+"'>修改进货商品</a>"
        			+"</td></tr>";
    			}
    			$("#show_tbody").html(table);
    			
    		});
    	}
    	//获取进货信息来确定退货信息
    	function getstockreturn(){
    		$.post("${pageContext.request.contextPath}/storage/CommodityReturnServlet",{},function(data){
    			if(data==true||data=="true"){
    				
    			}
    			data=eval(data);
    			var commoditystock=data[0];
    			var table="<option  value='' disabled selected hidden> 请选择退货信息 </option>";
    			for(var i=0;i<commoditystock.length;i++){
    				price[commoditystock[i].stockId]=commoditystock[i].stockPrice;
    				maxNumber[commoditystock[i].stockId]=commoditystock[i].stockNumber,
    				table+="<option value='"+commoditystock[i].stockId+"'>"+commoditystock[i].commodityName+":"+commoditystock[i].subsort+":"+commoditystock[i].stockNumber
    				+":"+commoditystock[i].stockPrice+":"+commoditystock[i].procurement+":"+commoditystock[i].supplier+":"+commoditystock[i].buystockDate
    				+"</option>";
    			}
    			$("#return").html(table);
    			
    		});
    		
    	}
    	$("#return").change(function(){
    		var stockid =$("#return").val();
    		var monney=price[stockid];
    		$("#price").val(monney);
    		
    	});
    	$(document).on("click","#Update",function(event){
    	 bounced=false;
   		 event.preventDefault();
   		 $("#renyuan").modal("show");
   		 returnId=$(this).attr("href");
   		 var param={
   				returnId:returnId
   		 }
   	   $.post("${pageContext.request.contextPath}/storage/GetMerchantReturnServlet",param,function(data){
   		data=eval(data);
   		var merchantreturn=data[0];
   		$("#return  option[value='"+merchantreturn.stockId+"']").prop("selected",true);
   		$("#stockNumber").val(merchantreturn.returnNumber);
   		$("#price").val(merchantreturn.returnPrice);
   		$("#cause").val(merchantreturn.returnCause);
   		
   	 });
   		 
   	 });
    	
    	 $("#add_btn").click(function(){
    		var pricea=$("#price").val();
    		var returnCause=$("#cause").val();
    		var returnkNumber=$("#stockNumber").val();
    		var stockid=$("#return").val();
    		var number=maxNumber[stockid];
    		if(returnkNumber<=number){
    			
    		}else{
    			alert("不能大于进货数量");
    			return;
    		};
    		var param={
    				returnCause:returnCause,
    				pricea:pricea,
    				returnkNumber:returnkNumber,
    				stockid:stockid,
    				returnId:returnId
    		}
    		if(bounced==false||bounced=="false"){
    		
    			 $.post("${pageContext.request.contextPath}/storage/UpdataMerchantReturnServlet",param,function(data){
    				 if(data==true||data=="true"){
    					 alert("修改成功");
    					 bounced=true;
    				 }
    				 showreturn();
    				 $("#return").val("");
    				 $("#stockNumber").val("");
    				 $("#cause").val("");
    				 $("#renyuan").modal('hide');
    				 $(".modal-backdrop.fade").hide();
    				
    			}); 
    	
    			
    		}else{
    			
    	$.post("${pageContext.request.contextPath}/storage/ReturnUpdateServlet",param,function(data){
    		if(data==true||data=="true"){
     			alert("添加成功");
    		    }else{
    			    alert("添加失败");
    		        }
    		showreturn();
    		$("#return").val("");
    		$("#price").val("");
    		$("#cause").val("");
    		$("#stockNumber").val("");
    		$("#renyuan").modal('hide');
			$(".modal-backdrop.fade").hide();
    	  });
        };
     });
    	
   });
    
    </script>
   <style>
		.search_input1 {
			height: 35px;
			line-height: 35px;
			margin: 15px 10px 0 0;
			float: right;
		}
		</style>
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
   				 <div class="mytitle">商品显示列表</div>
   				 <div class="mycontent">
        <!--搜索输入框及查询、重置按钮-->
        			<div class="container content_width">
			            <div class="person_search">
			                <div class="search_input">
			             <div class="input-group mb-3">
                        <input id="Ktext" type="date" class="form-control" placeholder="请输入进货日期">
                    </div>
                </div>
                <div class="search_input">
                    <button class="btn btn-primary search_btn" type="button" id="search_btn">查询</button>
                    <button class="btn btn-primary search_btn" type="button" id="back_btn">重置</button>
                </div>
			                <button id="new_add" type="button" class="btn btn-primary btn-sm" data-toggle="modal" style="margin-top:15px; margin-left:10px; padding:0 ;height:35px ;width:150px"  data-target="#renyuan">
			                <span  style=" color:black" >点击添加退货商品</span>
			            </button>
			            </div>
			            <div class="line"></div>
			        </div>
        <!--添加按钮及bootstrap的模态框-->
		<style>
			textarea{ height: 35px; width: 100%;}
		</style>
        <div class="export">
            <div class="modal fade" id="renyuan"style="opacity: 1.0 !important;">
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
			                                    <td id="commodityName" class="tb_bg"><label for=""><font style="font-size: 14px;width:385px; color: red;">*</font>退货信息</label>
			                                    </td>
			                                  <td><select class="form-control  commodityName" id="return"
											style="font-size: 13px; color: #666; height: 35px;">
										</select></td>
			                                   <!--  <td id="subsort1" class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>商品类别</label></td>
			                                    <td><select class="form-control  subsort1"
											style="font-size: 13px; color: #666; height: 35px;">
										</select></td> -->
									
			                                </tr>
			                                <tr>
			                                <td  class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>商品数量</label></td>
			                                    <td><input type="number"  id="stockNumber"   placeholder="请输入商品数量" style="text-align:left"/> </td>
			                               
			                                   
			                                <tr>
			                                <tr>
			                                <td  class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>输入商品单价</label></td>
			                                    <td><input id="price"
			                                     type="number" disabled="disabled" placeholder="商品价格" style="width:185px "/>
			                                </tr>
			                                    <td   class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>退货原因</label></td>
			                                    
											    <td><input id="cause" class="commodityPice" type="text"  placeholder="请输入退货原因 " style="width:185px "></td>
			                                </tr>
											
			                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button id="add_btn" type="button" class="btn btn-secondary">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--表格列表-->
		
        <table id="tb" class="table"> 
            <thead>
            <tr>
                <th>商品名称</th>
                <th>商品类别</th>
                <th>商品数量</th>
                <th>退货单价</th>
                <th>退货总价</th>
				<th>退货原因</th>
				<th>进货时间</th>
				<th>退货时间</th>
				<th>商品管理</th>
            </tr>
            </thead>
            <tbody id="show_tbody">
            
            </tbody>
        </table>
       
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
  </body>
</html>