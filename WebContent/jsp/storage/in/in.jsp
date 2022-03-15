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
    <script>
    $(function(){
      showcommodtiy();
      getcommodityName ();
      var stockid;
      
      $("#search_btn").click(function(){
    	  shoudate();
    	  
      });
      //根据日期查询进货列表
        function shoudate(){
        	var buystockdate=$("#Ktext").val();
        	var param={
        			buystockdate:buystockdate
        	} 
        	$.post("${pageContext.request.contextPath}/storage/SeeCommodityStockServlet",param,function(data){
        		data=eval(data);
        		var commodity=data[0];
        		if(commodity!=0){
        			var table="";
            		for(var i=0;i<commodity.length;i++){
            			table+="<tr><td>"+commodity[i].commodityName
            			+"</td><td>"+commodity[i].subsort
            			+"</td><td>"+commodity[i].stockNumber
            			+"</td><td>"+commodity[i].stockPrice
            			+"</td><td>"+commodity[i].stockPrices
            			+"</td><td>"+commodity[i].procurement
            			+"</td><td>"+commodity[i].buystockDate
            			+"</td><td>"+commodity[i].supplier
            			+"</td><td> <a id='Update' href='"+commodity[i].stockId+"'>修改进货商品</a>"
            			+"</td></tr>";
            		}
            		$("#show_tbody").html(table);
            		
        		}else{
        			alert("当天没有进货信息");
        		}
        		
        	});
        	
        }
        $("#back_btn").click(function(){
        	window.location.reload();
        });
    	
    	//显示进货清单信息
    	function showcommodtiy(){
    		var param= {
    				pages:1
    		}
    	$.post("${pageContext.request.contextPath}/storage/StockVVServlet",param,function(data){
    		data=eval(data);
    		var commodity=data[0];
    		var table="";
    		for(var i=0;i<commodity.length;i++){
    			table+="<tr><td>"+commodity[i].commodityName
    			+"</td><td>"+commodity[i].subsort
    			+"</td><td>"+commodity[i].stockNumber
    			+"</td><td>"+commodity[i].stockPrice
    			+"</td><td>"+commodity[i].stockPrices
    			+"</td><td>"+commodity[i].procurement
    			+"</td><td>"+commodity[i].buystockDate
    			+"</td><td>"+commodity[i].supplier
    			+"</td><td> <a id='Update' href='"+commodity[i].stockId+"'>修改进货商品</a>"
    			+"</td></tr>";
    		}
    		$("#show_tbody").html(table);
    	  });
    	}
    	//获取商品名字事件
    	function getcommodityName (){
    		$.post("${pageContext.request.contextPath}/commodity/CommodityStockServlet",{},function(data){
    			data=eval(data);
        		var getcommodity=data[0];
        		var table= "";
        		table="<option  value='' disabled selected hidden> 请选择商品名字</option>";
        		for(var i=0;i<getcommodity.length;i++){
        			table+="<option  value="+getcommodity[i].commodityId+">"+getcommodity[i].commodityName+" </option>"; 
        		}
        		
        		$(".commodityName").html(table);
        		$(".commodityName1").html(table);
    		});
    	}
    	
    	//根据商品ID获取商品类别事件
    	$(".commodityName").change(function(){
    		
    		var commodityid=$(".commodityName").val();
    		console.log(commodityid);
    		$.post("${pageContext.request.contextPath}/storage/StockVVSubsortServlet",{commodityid:commodityid},function(data){
    			data=eval(data);
    			var getcommoditysubsort=data[0];
    			var table="";
    			table="<option  value='' disabled selected hidden> 请选择商品类别 </option>";
    			for(var i=0;i<getcommoditysubsort.length;i++){
    			 var number=new Number(i+1); 
    				table+="<option   value='"+number+"' >"+getcommoditysubsort[i]+"</option>";
    			 }
    			  $(".subsort").html(table);
    			
    			
    		});
    		
    	});
	$(".commodityName1").change(function(){
	    		
	    		var commodityid=$(".commodityName1").val();
	    		$.post("${pageContext.request.contextPath}/storage/StockVVSubsortServlet",{commodityid:commodityid},function(data){
	    			data=eval(data);
	    			var getcommoditysubsort=data[0];
	    			var table="";
	    			table="<option  value='' disabled selected hidden> 请选择商品类别 </option>";
	    			for(var i=0;i<getcommoditysubsort.length;i++){
	    			 var number=new Number(i+1); 
	    				table+="<option   value='"+number+"' >"+getcommoditysubsort[i]+"</option>";
	    			 }
	    			  $(".subsort1").html(table);
	    			
	    			
	    		});
	    		
	    	});
    	//添加进货商品事件
    	$("#add_btn").click(function(){
    		
    	    var  commodityid=$(".commodityName").val();
    		   if(null==commodityid||""==commodityid){
    		   alert("商品名不能为空");
			   return false; 
    		}  
    		var  subsort=$(".subsort").val();
    	 	var subname=$(".subsort option[value ="+subsort+"]").html(); 
    		    if(null==subsort||""==subsort){
    		    alert("类别名不能为空");
			    return false;
    		  }    
    		var stockNumber=$("#stockNumber").val();
    		    if(null==stockNumber||""==stockNumber){
    		    alert("商品数量不能为空");
			    return false; 
    		  } 
    		 var price=$("#price").val();
			     if(null==price||""==price){
    		     alert("商品单价不能为空");
			     return false;  
			  } 
    		 var procurement=$("#procurement").val();
    		     if(null==procurement||""==procurement){
    		     alert("进货人姓名不能为空");
			     return false;  
    		 } 
    		var supplier=$("#supplier").val();
    	 	    if(null==supplier||""==supplier){
    		    alert("供应商不能为空");
			    return false; 
    		} 
    		var param ={
    				 commodityid:commodityid,
    				 subname:subname,
    		         stockNumber:stockNumber,
    		         price:price,
    		         procurement:procurement,
    		         supplier:supplier
    				
    		}
    		
    		
    	 $.post("${pageContext.request.contextPath}/storage/DoInsCommodityStockServlet",param,function(data){
    		 if(data==true||data=="true"){
    			alert("添加成功");
   		    }else{
   			    alert("添加失败，请检查各项输框有没有为空");
   		        }
    		    showcommodtiy();
    		    $(".commodityName" ).val("");
    		    $(".subsort ").val("");
    		    $("#stockNumber").val("");
    		    $("#price").val("");
    		    $("#procurement").val();
    		    $("#supplier").val("");
    		    $("#renyuan").modal('hide');
				$(".modal-backdrop.fade").hide();

    	    }); 
    	});
    	//修改进货商品事件
    	$(document).on("click","#Update",function(event){
    		event.preventDefault();
    		$("#renyuan1").modal("show");
    		stockid=$(this).attr("href");
    		var param={
    				stockid:stockid
    				
    		}
    	 	 $.post("${pageContext.request.contextPath}/storage/CommodityStockidServlet",param,function(data){
    	
    	 		 data=eval(data);
    	 		 var stock =data[0];
    	 		$(".commodityName1 option[value='commoddityid']").val();
    	 		$(".subsort1 option[value='subsort']").val(subsort);
    	 		$("#stockNumber1").val(stock.stockNumber);
    	 		$("#price1").val(stock.stockPrice);
    	 		$("#procurement1").val(stock.procurement);
    	 		$("#supplier1").val(stock.supplier);
    		});  
    		return false;
    	});
    	$("#add_btn1").click(function(){
    		var commodityid=$(".commodityName1").val();
    		 /*    if(null==commodityid||""==commodityid){
    		   alert("商品名不能为空");
   			   return false;
    		}   */
    		var   subsort=$(".subsort1").val();
    		var subname=$(".subsort1 option[value ="+subsort+"]").html(); 
    		  /*   if(null==subsort||""==subsort){
    		    alert("类别名不能为空");
   			    return false;
    		  }    */ 
    		var stockNumber=$("#stockNumber1").val();
    		    if(null==stockNumber||""==stockNumber){
    		    alert("商品数量不能为空");
   			    return false; 
    		  } 
    		 var price=$("#price1").val();
   			     if(null==price||""==price){
    		     alert("商品单价不能为空");
   			     return false;  
   			  } 
    		 var procurement=$("#procurement1").val();
    		     if(null==procurement||""==procurement){
    		     alert("进货人姓名不能为空");
   			     return false;  
    		 } 
    		var supplier=$("#supplier1").val();
    	 	    if(null==supplier||""==supplier){
    		    alert("供应商不能为空");
   			    return false; 
    		} 
    		var param ={
    				 commodityid:commodityid,
    				 subname:subname, 
    		         stockNumber:stockNumber,
    		         price:price,
    		         procurement:procurement,
    		         supplier:supplier,
    		         stockid:stockid
    		}
    		
    		$.post("${pageContext.request.contextPath}/storage/StockUpdateServlet",param,function(data){
    			if(data==true||data=="true"){
    				alert("修改成功");
    			}
    			showcommodtiy();
    		    $(".commodityName").val("");
    		    $(".subsort").val("");
    		    $("#stockNumber1").val("");
    		    $("#price1").val("");
    		    $("#procurement1").val("");
    		    $("#supplier1").val("");
    		    $("#renyuan1").modal('hide');
				$(".modal-backdrop.fade").hide();
    			
    		});
    	});

    });
    
    </script>
    
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
			<div class="mybox">
			    <div class="mytitle">进货清单列表</div>
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
			                <span  style=" color:black" >点击添加进货商品</span>
			            </button>
			            </div>
			            <div class="line"></div>
			        </div>
			        <!--添加按钮及bootstrap的模态框-->
					<style>
						textarea{ height: 35px; width: 100%;}
						
					</style>
			        <div class="export">
			            <div class="modal fade" id="renyuan1" style="opacity: 1.0 !important;">
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
			                                    <td id="commodityName1" class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>商品名称</label>
			                                    </td>
			                                  <td><select class="form-control  commodityName1"
											style="font-size: 13px; color: #666; height: 35px;">
										</select></td>
			                                    <td id="subsort1" class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>商品类别</label></td>
			                                    <td><select class="form-control  subsort1"
											style="font-size: 13px; color: #666; height: 35px;">
										</select></td>
									
			                                </tr>
			                                <tr>
			                                <td  class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>商品数量</label></td>
			                                    <td><input type="number"  id="stockNumber1"   placeholder="请输入商品数量" style="width:185px "/> </td>
			                               <td  class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>输入商品单价</label></td>
			                                    <td><input id="price1"
			                                     type="number"  placeholder="商品价格" style="width:185px "/>
			                                   
			                                <tr>
			                                    <td   class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>进货人姓名</label></td>
			                                    
			                                    <td><input id="procurement1" class="commodityPice" type="text"  placeholder="请输入进货人姓名" style="width:185px "></td>
		
			                                    <td  class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>供应商名字</label></td>
											    
											    <td><input id="supplier1" class="commodityPice" type="text"  placeholder="请输入供应商名字 " style="width:185px "></td>
			                                </tr>
											
											<!-- <tr>
											    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>审核状态</label>
											    </td>
											    <td><input type="text" disabled="disabled" value="等待审核"></td>
											   
											    </td>
											</tr>
										 -->
			                                </tbody>
			                            </table>
			                        </div>
			                   
			                        <div class="modal-footer">
			                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
			                            <button id="add_btn1" type="button" class="btn btn-secondary">确定</button>
			                        </div>
			                    </div>
			                </div>
			            </div>
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
			                                    <td id="commodityName" class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>商品名称</label>
			                                    </td>
			                                  <td><select class="form-control  commodityName"
											style="font-size: 13px; color: #666; height: 35px;">
										</select></td>
			                                    <td id="subsort" class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>商品类别</label></td>
			                                    <td><select class="form-control  subsort"
											style="font-size: 13px; color: #666; height: 35px;">
										</select></td>
									
			                                </tr>
			                                <tr>
			                                <td  class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>商品数量</label></td>
			                                    <td><input type="number"  id="stockNumber"   placeholder="请输入商品数量" style="width:185px "/> </td>
			                               <td  class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>输入商品单价</label></td>
			                                    <td><input id="price"
			                                     type="number"  placeholder="商品价格" style="width:185px "/>
			                                   
			                                <tr>
			                                    <td   class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>进货人姓名</label></td>
			                                    
			                                    <td><input id="procurement" class="commodityPice" type="text"  placeholder="请输入进货人姓名" style="width:185px "></td>
		
			                                    <td  class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>供应商名字</label></td>
											    
											    <td><input id="supplier" class="commodityPice" type="text"  placeholder="请输入供应商名字 " style="width:185px "></td>
			                                </tr>
											
											<!-- <tr>
											    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>审核状态</label>
											    </td>
											    <td><input type="text" disabled="disabled" value="等待审核"></td>
											   
											    </td>
											</tr>
										 -->
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
			                <th>商品名字</th>
			                <th>商品类别</th>
			                <th>商品数量</th>
			                <th>商品单价</th>
							<th>进货总价</th>
							<th>进货人</th>
							<th>进货日期</th>
							<th>供应商</th>
							<th>进货修改</th>
			            </tr>
			            </thead>
			            <tbody id="show_tbody">
							<!-- 从数据库获取的值 -->
							<tr>
			               
			            </tr>
			            </tbody>
			        </table>
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