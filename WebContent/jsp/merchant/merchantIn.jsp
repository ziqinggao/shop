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
	<link rel="stylesheet" type="text/css" href=""${pageContext.request.contextPath }/css/amazeui.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css" />
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
        <script type="text/javascript">
        	$(function(){
        		$("#cp").click(function(){
        			var merchantBalance = $("#ap").val();
        			if(merchantBalance != null){
        			var param = {
        					merchantBalance:merchantBalance
        			}
        			$.post("${pageContext.request.contextPath}/merchant/MerchantBalanceInServlet",param,function(data){
        				if(data == true||data == "true"){
        					alert("充值成功");
        					window.location.href = "${pageContext.request.contextPath}/jsp/merchant/merchantIn.jsp";
        				}else{
        					alert("充值失败");
        				}
        			});
        			}else{
        				
        			alert("您没有输入金额");
        			}
        			return false;
        		});
        	});
        
        
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
			<div class="pay">
			<!--主内容开始编辑-->
			<div class="tr_recharge">
				<form action="#" class="am-form" id="doc-vld-msg" method="post">
					<div class="tr_rechbox">
						<div class="tr_rechhead">
							<img src="${pageContext.request.contextPath}/merchantImg/ys_head2.jpg" />
							<p>充值帐号：${sessionScope.merchant.corp}
							</p>
							<div class="tr_rechheadcion">
								<img src="${pageContext.request.contextPath}/merchantImg/coin.png" alt="" />
								<span>当前余额：<span>${ merchant.merchantBalance }人民币</span></span>
							</div>
						</div>
						<div class="tr_rechli am-form-group">
							<ul class="ui-choose am-form-group" id="uc_01">
								<li>
									<label class="am-radio-inline">
											<input type="radio"  value="" name="docVlGender" required data-validation-message="请选择一项充值额度"> 10￥
										</label>
								</li>
								<li>
									<label class="am-radio-inline">
											<input type="radio" name="docVlGender" data-validation-message="请选择一项充值额度"> 20￥
										</label>
								</li>
		
								<li>
									<label class="am-radio-inline">
											<input type="radio" name="docVlGender" data-validation-message="请选择一项充值额度"> 50￥
										</label>
								</li>
								<li>
									<label class="am-radio-inline">
											<input type="radio" name="docVlGender" data-validation-message="请选择一项充值额度"> 其他金额
										</label>
								</li>
							</ul>
							<!--<span>1招兵币=1元 10元起充</span>-->
						</div>
						<div class="tr_rechoth am-form-group">
							<span>其他金额：</span>
							<input type="number" min="10" max="10000" value="10.00元" class="othbox" data-validation-message="充值金额范围：10-10000元" />
							<!--<p>充值金额范围：10-10000元</p>-->
						</div>
						<div class="tr_rechcho am-form-group">
							<span>充值方式：</span>
							<label class="am-radio">
									<input type="radio" name="radio1" value="" data-am-ucheck required data-validation-message="请选择一种充值方式"><img src="${pageContext.request.contextPath}/merchantImg/wechatpay.png">
								</label>
							<label class="am-radio" style="margin-right:30px;">
									<input type="radio" name="radio1" value="" data-am-ucheck data-validation-message="请选择一种充值方式"><img src="${pageContext.request.contextPath}/merchantImg/zfbpay.png">
								</label>
						</div>
						<div class="tr_rechnum">
							<span style="color:#666;">应付金额：</span>
							<input type="text" class="rechnum" name="money" id="ap">
						</div>
					</div>
					<div class="tr_paybox">
						<input type="submit" value="确认支付" class="tr_pay am-btn" id="cp" />
					</div>
				</form>
			</div>
		</div>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ui-choose.js"></script>
		<script type="text/javascript">
			// 将所有.ui-choose实例化
			$('.ui-choose').ui_choose();
			// uc_01 ul 单选
			var uc_01 = $('#uc_01').data('ui-choose'); // 取回已实例化的对象
			uc_01.click = function(index, item) {
				console.log('click', index, item.text())
			}
			uc_01.change = function(index, item) {
				console.log('change', index, item.text())
			}
			$(function() {
				$('#uc_01 li:eq(3)').click(function() {
					$('.tr_rechoth').show();
					$('.tr_rechoth').find("input").attr('required', 'true')
					$('.rechnum').val('10.00');
				})
				$('#uc_01 li:eq(0)').click(function() {
					$('.tr_rechoth').hide();
					$('.rechnum').val('10.00');
					$('.othbox').val('');
				})
				$('#uc_01 li:eq(1)').click(function() {
					$('.tr_rechoth').hide();
					$('.rechnum').val('20.00');
					$('.othbox').val('');
				})
				$('#uc_01 li:eq(2)').click(function() {
					$('.tr_rechoth').hide();
					$('.rechnum').val('50.00');
					$('.othbox').val('');
				})
				$(document).ready(function() {
					$('.othbox').on('input propertychange', function() {
						var num = $(this).val();
						$('.rechnum').val(num + ".00");
					});
				});
			})
		
			$(function() {
				$('#doc-vld-msg').validator({
					onValid: function(validity) {
						$(validity.field).closest('.am-form-group').find('.am-alert').hide();
					},
					onInValid: function(validity) {
						var $field = $(validity.field);
						var $group = $field.closest('.am-form-group');
						var $alert = $group.find('.am-alert');
						// 使用自定义的提示信息 或 插件内置的提示信息
						var msg = $field.data('validationMessage') || this.getValidationMessage(validity);
		
						if(!$alert.length) {
							$alert = $('<div class="am-alert am-alert-danger"></div>').hide().
							appendTo($group);
						}
						$alert.html(msg).show();
					}
				});
			});
		</script>
		<div style="text-align:center;">
		
		</div>
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