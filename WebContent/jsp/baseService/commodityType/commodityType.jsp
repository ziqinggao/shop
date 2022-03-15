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
        <div width="1260px" height="128px">
        <br>
        <span><h2 style="color:black;">商品分类管理</h2></span>
        </div>
        <style>
			textarea{ height: 35px; width: 100%;}
			
		</style>
		<div>
			<form action="#" method="post">
				<select id="likeOption"><option value="1">分类</option><option value="2">详细分类</option></select>&nbsp;<input type="text" id="likeText">&nbsp;
				<span style="color:black;">状态:</span>&nbsp;<input type="checkbox" id="likeChecked" style="display:inline-block;width='70px';height:'70px'; zoom:150%;" checked="checked">&nbsp;	
				<input type="submit" value="查询" id="likeCheck">
			</form>
		</div>
		<br>
        <div class="export">
            <button id="new_add" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#renyuan">
                 <img width="20px" src="${pageContext.request.contextPath }/img/admin/add_two.png">
                <span>添加商品分类</span> 
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
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>类型名称</label>
                                    </td>
                                    <td><input id="typeName" class="commodityName" type="text" placeholder="请输入类型名称"></td>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>类型描述</label>
                                    </td>
                                    <td><input id="typeDescribe" type="text" placeholder="对新类型的描述"/>
                                </tr>
                                <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>类型状态</label>
                                    </td>
                                    <td><input id="typeState" class="commodityName" type="text" placeholder="1为可用，0为停用" value="1"></td>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>类型排序码</label>
                                    </td>
                                    <td><input id="sortCode" type="text" placeholder="类型的排序码,请填入等级数字" value="1"/>
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
            <button style="float:right" id="new_add" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#nihao">
                 <img width="20px" src="${pageContext.request.contextPath }/img/admin/add_two.png">
                <span>添加商品详细分类</span> 
            </button>
            <div class="modal fade" id="nihao">
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
                                	<td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>类型名称</label>
                                    </td>
                                    <td>
                                    	<select id="newoption" >
				                        </select>
									</td>
                                </tr>
                                <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>新的类型明细名称</label>
                                    </td>
                                    <td><input id="subtypeName" class="commodityName" type="text" placeholder="请输入类型明细名称"></td>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>新的类型明细描述</label>
                                    </td>
                                    <td><input id="subtypeDescribe" type="text" placeholder="对新类型明细的描述"/>
                                </tr>
                                <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>新的类型明细状态</label>
                                    </td>
                                    <td><input id="subtypeState" class="commodityName" type="text" placeholder="1为可用，0为停用" value="1"></td>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;"></font>新的类型明细排序码</label>
                                    </td>
                                    <td><input id="subsortCode" type="text" placeholder="明细类型的排序码,请填入等级数字" value="1"/>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button id="add_subtype" type="button" class="btn btn-secondary">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        
			<!-- 这是自己写功能模块 -->
			<style type="text/css">
			.subNav table {
				width: 1260px;
				font-weight: normal;
				text-indent: 12px;
				line-height: 42px;
				height: 42px;
				font-size: 15px;
				color: #000;
				cursor: pointer;
				text-align:center;
			}
		</style>
		<div class="subNav" id="showEmp">
			
		</div>
		<script type="text/javascript">
			$(function(){
				getTypeInfo(); 
				addTypeOption();
				//查询类型信息
				function getTypeInfo(){
					$.post("${pageContext.request.contextPath}/admin/AdminCommodityTypeAllsServlet",function(data){
						data = eval(data);
						var useStop = "";
						 var table = "<table id='tb' class='table'> <thead><tr>"+
							"<th>名称</th>"+
							"<th>描述</th>"+
							"<th>修改</th>"+
							"<th>详细类型</th>"+
							"</tr></thead><tbody id='show_tbody' >";
						  var td = "";
						  for (var i = 0; i < data.length; i++) {
							  	if(data[i].typeState == 1){
							  		useStop = "<a href='"+data[i].typeId+"' class='stop'>停用</a>";
							  	}else{
							  		useStop = "<a href='"+data[i].typeId+"' class='useable'>可用</a>";
							  	}
								td += "<tr><td>"+data[i].typeName+"</td><td>"+
								data[i].typeDescribe+"</td><td>"+useStop+"</td>"+
								"<td><a href='"+data[i].typeId+"' class='lockOver'>查看</a></td></tr>";
							}
						  table = table + td +"</tbody></table>";
						  var showEmp = document.getElementById("showEmp");
						  showEmp.innerHTML = table;
						
					});
				}
				//添加新的类型
				$("#add_btn").click(function(){
					var typeName = $("#typeName").val();
					var typeDescribe = $("#typeDescribe").val();
					var typeState = $("#typeState").val();
					var sortCode = $("#sortCode").val();
					if(typeName == null || typeDescribe == null || typeName == "" || typeDescribe == ""){
						alert("有信息没有填写");
						return false;
					}else{
						var param = {
								typeName:typeName,
								typeDescribe:typeDescribe,
								typeState:typeState,
								sortCode:sortCode
						}
						$.post("${pageContext.request.contextPath}/admin/commoditytype/DoInsTypeServlet",param,function(){
							alert("添加成功");
							$("add_btn").modal("hide");
							$(".modal-backdrop.fade").hide();
							getTypeInfo();
							addTypeOption();
						});
					}
				});
				//添加新的类型明细
				$("#add_subtype").click(function(){
					//查询option的上一级select的值
					var typeId = $("#newoption").val();
					var subtypeName = $("#subtypeName").val();
					var subtypeDescribe = $("#subtypeDescribe").val();
					var subtypeState = $("#subtypeState").val();
					var subsortCode = $("#subsortCode").val();
					if(subtypeName == null || subtypeName == "" || subtypeDescribe == null || subtypeDescribe == ""){
						alert("有信息没有填写");
					}else{
						var param = {
								typeId:typeId,
								subtypeName:subtypeName,
								subtypeDescribe:subtypeDescribe,
								subtypeState:subtypeState,
								subsortCode:subsortCode
						}
						$.post("${pageContext.request.contextPath}/admin/commoditysubtype/DoInsSubtypeServlet",param,function(){
							alert("添加成功");
							$("add_subtype").modal("hide");
							$(".modal-backgrop.fade").hide();
							getSubtypeInfo(typeId);
						});
					}
				});
				//为类型明细展示可选择的下拉框
				function addTypeOption(){
					$.post("${pageContext.request.contextPath}/admin/AdminCommodityTypeAllsServlet",function(data){
						data = eval(data);
						var option = "";
						for (var i = 0; i < data.length; i++) {
							option += "<option value="+data[i].typeId+">"+data[i].typeName+"</option>";
						}
						var newoption = document.getElementById("newoption");
						newoption.innerHTML = option;
					});
				}
				//类型信息改变为可用,给未来元素添加事件，给父类容器添加事件，未来元素都有这个属性,a标签等都可取消事件的发生
				$(".subNav").on("click",".useable",function(event){
					event.preventDefault();//取消元素的默认行为
					var typeId = $(this).attr("href");
					var typeState = 1;
					var param = {
							typeId:typeId,
							typeState:typeState
					}
					$.post("${pageContext.request.contextPath}/admin/commoditytype/DoUpdTypeServlet",param,function(){
						updSubtype(typeId,typeState);
						getTypeInfo();
						alert("状态变成可用了！！！");
					});
					//return false;//取消超链接默认行为
				});
				//类型信息改变为可用
				/* $(document).on("click",".useable",function(){
					var typeId = $(this).parent().siblings().eq(0).html();
					var typeState = 1;
					var param = {
							typeId:typeId,
							typeState:typeState
					}
					$.post("${pageContext.request.contextPath}/admin/commoditytype/DoUpdTypeServlet",param,function(){
						updSubtype(typeId,typeState);
						getTypeInfo();
						alert("状态变成可用了！！！");
					});
				}); */
				//类型信息变成停用
				$(document).on("click",".stop",function(event){
					event.preventDefault();
					var typeId = $(this).attr("href");
					var typeState = 0;
					var param = {
							typeId:typeId,
							typeState:typeState
					}
					$.post("${pageContext.request.contextPath}/admin/commoditytype/DoUpdTypeServlet",param,function(){
						updSubtype(typeId,typeState);
						getTypeInfo();
						alert("状态变成停用了！！！");
					});
				});
				//类型信息明细可用
				$(document).on("click",".useable1",function(event){
					event.preventDefault();
					var subtypeId = $(this).attr("href");
					var typeId = $(this).attr("typeId");
					var subtypeState = 1;
					var param = {
							subtypeId:subtypeId,
							subtypeState:subtypeState
					}
					$.post("${pageContext.request.contextPath}/admin/commoditysubtype/DoUpdSubtypeServlet",param,function(){
						getSubtypeInfo(typeId);
						alert("状态变成可用了！！！");
					});
				});
				//类型信息明细不可用
				$(document).on("click",".stop1",function(event){
					event.preventDefault();
					var subtypeId = $(this).attr("href");
					var typeId = $(this).attr("typeId");
					var subtypeState = 0;
					var param = {
							subtypeId:subtypeId,
							subtypeState:subtypeState
					}
					$.post("${pageContext.request.contextPath}/admin/commoditysubtype/DoUpdSubtypeServlet",param,function(){
						getSubtypeInfo(typeId);
						alert("状态变成停用了！！！");
					});
				});
				//根据类型信息状态，判断是否改变类型明细表的状态
				function updSubtype(typeId,subtypeState){
					var param = {
							typeId:typeId,
							subtypeState:subtypeState
					}
					$.post("${pageContext.request.contextPath}/admin/commoditysubtype/DoUpdSubtypeAllServlet",param,function(){
						alert("明细也修改了哦！！");
					});
				}
				//点击查看，类型信息明细
				$(document).on("click",".lockOver",function(event){
					event.preventDefault();
					var typeId = $(this).attr("href");
					getSubtypeInfo(typeId);
					/* return false; */
				});
				//点击返回，查看类型信息
				$(document).on("click",".goBack",function(){
					getTypeInfo();
					return false;
				});
				//根据typeID查询明细信息
				function getSubtypeInfo(typeId){
					var param = {
							typeId:typeId
					}
					$.post("${pageContext.request.contextPath}/admin/AdminCommoditySubtypeServlet",param,function(data){
						data = eval(data);
						var state = "";
						if(data.length == 0){
							alert("没有详细分类了");
							getTypeInfo();
						}
						var table = "<table id='tb' class='table'> <thead><tr>"+
						"<th>名字</th>"+
						"<th>描述</th>"+
						"<th>修改</th>"+
						"<th>返回信息</th>"+
						"</tr></thead><tbody id='show_tbody' >";
						 var td = "";
						 for (var i = 0; i < data.length; i++) {
								if(data[i].subtypeState == 1 || data[i].subtypeState == "1"){
									state = "<a href='"+data[i].subtypeId+"'typeId='"+data[i].typeId+"' class='stop1'>停用</a>";
								}else{
									state = "<a href='"+data[i].subtypeId+"'typeId='"+data[i].typeId+"' class='useable1'>可用</a>";
								}
								td += "<td>"+data[i].subtypeName+"</td><td>"+
								data[i].subtypeDescribe+"</td><td>"+state+"</td>"+
								"<td><a href='#' class='goBack'>返回</a></td></tr>";
						}
					  table = table + td +"</tbody></table>";
					  var showEmp = document.getElementById("showEmp");
					  showEmp.innerHTML = table;
					});
				}
				//查询在停用状态和可用状态，获取到的列表
				$("#likeCheck").click(function(event){
					event.preventDefault();
					var likeOption = $("#likeOption").val();
					var likeText = $("#likeText").val();
					var state = 0;
					//默认显示可用状态
					if($("#likeChecked").prop("checked") == true){
						state = 1;
					}
					if(likeOption == 1 || likeOption == "1"){
						var param = {
								likeOption:likeOption,
								likeText:likeText,
								state:state
						}
						$.post("${pageContext.request.contextPath}/baseservice/CommodityTypeAndSubtypeLikeServlet",param,function(data){
							data = eval(data);
							var useStop = "";
							 var table = "<table id='tb' class='table'> <thead><tr>"+
								"<th>名称</th>"+
								"<th>描述</th>"+
								"<th>修改</th>"+
								"<th>详细类型</th>"+
								"</tr></thead><tbody id='show_tbody' >";
							  var td = "";
							  for (var i = 0; i < data.length; i++) {
								  	if(data[i].typeState == 1){
								  		useStop = "<a href='"+data[i].typeId+"' class='stop'>停用</a>";
								  	}else{
								  		useStop = "<a href='"+data[i].typeId+"' class='useable'>可用</a>";
								  	}
									td += "<tr><td>"+data[i].typeName+"</td><td>"+
									data[i].typeDescribe+"</td><td>"+useStop+"</td>"+
									"<td><a href='"+data[i].typeId+"' class='lockOver'>查看</a></td></tr>";
								}
							  table = table + td +"</tbody></table>";
							  var showEmp = document.getElementById("showEmp");
							  showEmp.innerHTML = table;
						});
					}else{
						var param = {
								likeOption:likeOption,
								likeText:likeText,
								state:state
						}
						$.post("${pageContext.request.contextPath}/baseservice/CommodityTypeAndSubtypeLikeServlet",param,function(data){
							data = eval(data);
							var state = "";
							var table = "<table id='tb' class='table'> <thead><tr>"+
							"<th>名字</th>"+
							"<th>描述</th>"+
							"<th>修改</th>"+
							"<th>返回信息</th>"+
							"</tr></thead><tbody id='show_tbody' >";
							 var td = "";
							 for (var i = 0; i < data.length; i++) {
									if(data[i].subtypeState == 1 || data[i].subtypeState == "1"){
										state = "<a href='"+data[i].subtypeId+"'typeId='"+data[i].typeId+"' class='stop1'>停用</a>";
									}else{
										state = "<a href='"+data[i].subtypeId+"'typeId='"+data[i].typeId+"' class='useable1'>可用</a>";
									}
									td += "<td>"+data[i].subtypeName+"</td><td>"+
									data[i].subtypeDescribe+"</td><td>"+state+"</td>"+
									"<td><a href='#' class='goBack'>返回</a></td></tr>";
							}
						  table = table + td +"</tbody></table>";
						  var showEmp = document.getElementById("showEmp");
						  showEmp.innerHTML = table;
						});
					}
				});
			})
			
		</script>
          <!-- Page Header-->
          <!-- Dashboard Counts Section-->
          <!-- 页脚 模块-->
          <br>
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