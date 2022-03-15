<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<title>购物车</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/frontDesk/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/frontDesk/carts.css">
<link href="${pageContext.request.contextPath }/css/frontDesk/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath }/css/frontDesk/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="${pageContext.request.contextPath }/css/frontDesk/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="${pageContext.request.contextPath }/js/frontDesk/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/frontDesk/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/style/jquery.cookie.js"></script>
<script src="${pageContext.request.contextPath }/js/frontDesk/carts.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath }/js/frontDesk/jquery.mycart.js"></script>
<!-- //js -->
<!--css类引用-->
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/plugins/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/plugins/layui/css/layui.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/plugins/awesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/plugins/eleme-ui/index.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/CivilMilitaryIntegration/public.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/CivilMilitaryIntegration/ShoppingCartAdress.css" />
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/frontDesk/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/frontDesk/easing.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style/cy.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/style/jquery.SuperSlide.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/style/banner.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/style/even.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/style/provinces-city-county.js"></script>
<!-- <script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script> -->
<script type="text/javascript">
	$(function(){
		query();
		acountLocation();
		shoppingCommodity();
		function query(){
			var prices = parseFloat($.cookie("prices"));
			$("#spanPrices").html(prices);
			$("#spanPrices1").html(prices);
			var accountId = "${account.accountId}";
			var param = {
					accountId:accountId
			};
			$.post("${pageContext.request.contextPath}/order/orderlist/GetDefaultLocationServlet",param,function(data){
				data = eval(data);
				var p = "<p>"+data[0].consignee+" "+data[0].phone+"</p><p>"+data[0].provinces+" "+data[0].city+" "+data[0].county+" "+
						data[0].specificLocation+"</p>";
				var showEmp = document.getElementById("showEmp");
				showEmp.innerHTML = p;
			})
		}
		function acountLocation(){
			var accountId = "${account.accountId}";
			var param = {
					accountId:accountId
			};
			$.post("${pageContext.request.contextPath}/order/orderlist/GetLocationServlet",param,function(data){
				data = eval(data);
				data = data[0];
				var li = "";
				for (var i = 0; i < data.length; i++) {
					li += "<li class='rY-Qms'><div class='gw-yys'><input type='radio' consignee='"+data[i].consignee+
							"' phone='"+data[i].phone+"' provinces='"+data[i].provinces+"' city='"+data[i].city+"' "+
							" county='"+data[i].county+"' specificLocation='"+data[i].specificLocation+"' "+
							" class='gwc-y'  name='1'><label></label></div><i>"+data[i].consignee+" "
						 	+data[i].provinces+" "+data[i].city+" "+data[i].county+" "+data[i].specificLocation+" "+"<br/> 联系电话："+
						 	data[i].phone+"</i></li>";
				}
				var showEmp1 = document.getElementById("showEmp1");
				showEmp1.innerHTML = li;
			})
		}
		//展示地址的关闭
		$(".Aqxs").click(function(){
			$(".Rsy-l").hide();
			$(".add-v1,.nEW-TC1").show()	
		})
		//点击确认添加新的地址信息和关闭模态框
		$(".Bc-list").click(function(){
			addLocation();
			acountLocation();
			$(".add-v1,.nEW-TC1").hide();
		})
		//点击取消关闭模态框
		$(".Bc-list1").click(function(){
			$(".add-v1,.nEW-TC1").hide();
		})
		//打开其他地址的模态框		
		$(".other").click(function(){
			$(".add-v1,.Rsy-l").show();
		})
		//右上角的叉号关闭模态框
		$(".chacha").click(function(){	
			$(".add-v1,.nEW-TC1,.Rsy-l").hide();
		})	
		//改变用户的地址和关闭模态框
		$(".Aqrs").click(function(){	
			newLocation();
			$(".add-v1,.nEW-TC1,.Rsy-l").hide();
		})
		//读取新选择的地址
		function newLocation(){
			$(".gwc-y").each(function(){
				if($(this).prop("checked")==true||$(this).prop("checked")=="true"){
					var consignee = $(this).attr("consignee");
					var phone = $(this).attr("phone");
					var provinces = $(this).attr("provinces");
					var city = $(this).attr("city");
					var county = $(this).attr("county");
					var specificLocation = $(this).attr("specificLocation");
					//重新向页面打印地址
					var p = "<p>"+consignee+" "+phone+"</p><p>"+provinces+" "+city+" "+county+" "+
					specificLocation+"</p>";
					var showEmp = document.getElementById("showEmp");
					showEmp.innerHTML = p;
				}
			})
		}
		//添加新的地址
		function addLocation(){
			var accountId = "${account.accountId}";
			var provinces = $("#s1").val();
			var city = $("#s2").val();
			var county = $("#s3").val();
			var specificLocation = $(".tcy-3").val();
			var consignee = $(".tcy-1").val();
			var phone = $(".tcy-4").val();
			var param = {
					accountId:accountId,
					provinces:provinces,
					city:city,
					county:county,
					specificLocation:specificLocation,
					consignee:consignee,
					phone:phone
			}
			$.post("${pageContext.request.contextPath}/order/orderlist/DoInsLocationServlet",param,function(){
				alert("添加成功！");
			})
		}
		//接收传过来的购物车id
		function shoppingCommodity(){
			var cartIds = $.cookie("cartId");
			var cartId = cartIds.split(",");
			for (var i = 0; i < cartId.length-1; i++) {
				orderListInfo(cartId[i]);
			}
		}
		//向页面打印需要提交订单的信息
		function orderListInfo(cartId){
			var param = {
					cartId:cartId
			}
			$.post("${pageContext.request.contextPath}/order/orderlist/GetShoppingCartVInfoServlet",param,function(data){
				data = eval(data);
				data = data[0];
				var tr = "<tr class='Jtxq'><td><img class='cpzs' src='${pageContext.request.contextPath }/img/photos/paul-morris-116514-unsplash.jpg' width='71' height='71' alt='' /><div class='rigt'>"+
							data.commodityName+"</div></td><td valign='top' align='center'>"+data.subsort+"</td><td valign='top' align='center'>"+data.commodityNumber+"</td><td valign='top' align='center'>"+
							data.commodityPrices+"</td><td valign='top' align='center'></td></tr>";
				$("#showEmp2").before(tr);
			})
		}
		$(".jsbu").click(function(){
			var a = confirm("确定要提交订单吗？？");
			var balance = parseFloat("${account.balance}");
			var prices = parseFloat($.cookie("prices"));
			console.log(balance);
			console.log(prices);
			if(a == true||a == "true"){
				if(prices>balance){
					alert("您资金不足，请充值！");
				}else{
					window.location.href="${pageContext.request.contextPath}/jsp/order/orderform/orderformdo.jsp";
				}
			}
			
		})
	})


</script>
<!-- 页面的js -->

	<script type="text/javascript">
		$(function(){
			$(document).on("click",".yListr ul li em",function(){
				$(this).addClass("yListrclickem").siblings().removeClass("yListrclickem");
			})
		})
</script>
	<!-- 修改的绝对定位 -->
	<style>
		.list_info{
			position:relative;
		}
		#xiu_gai:hover{
			border:2px solid yellow;
		}
		.xiugai{
			position:absolute;
			top:0px;
			right:50px;
		}
	</style>
	<style>
			body,select
			{
			 font-size:9pt;
			 font-family:Verdana;
			}
			a
			{
			 color:red;
			 text-decoration:none;
			}
			a:hover{
			 text-decoration:underline;
			}
	</style>
	<style type="text/css">
			*{margin:0;padding:0;list-style-type:none;}
			a,img{border:0;text-decoration:none;}
			body{font:14px/180% Arial, Helvetica, sans-serif, "新宋体";}
			.yListr{width:690px;font-family:"微软雅黑";margin:0px auto 0 auto;}
			.yListr ul{padding-bottom:10px;margin-bottom:13px;}
			.yListr ul li{margin-bottom:23px;}
			.yListr ul li span{color:#000000;font-size:14px;line-height:36px;display:inline-block;padding-left:4px;}
			.yListr ul li em{cursor:pointer;color:#666666;font-size:14px;display:inline-block;padding:0 10px;font-style:normal;border:1px solid #dcdcdc;line-height:34px;height:34px;}
			.yListr ul li em.yListrclickem{line-height:32px;border:2px solid #e9630a;height:32px;position:relative;padding:0 9px;}
			.yListr ul li em.yListrclickem i{display:block;width:15px;height:14px;background:url(../../../img/frontDesk/righbt.png) no-repeat 0 0;right:-1px;bottom:-1px;position:absolute;}
			.yListr .colorp00{color:#333333;font-size:18px;line-height:50px;}
			.yListr .colorp00 span{color:#ed610c;font-size:14px;padding-left:20px;}
			.yListr .colorp00 em{font-style:normal;}
			.yListr form input,.yListr form select{outline:none;border:1px solid #dcdcdc;width:86px;height:34px;font-size:14px;color:#333333;padding-left:8px;}
			.yListr form select{height:36px;}
			.yListr form .YImmediatelyininstallment{font-size:24px;color:#ffffff;text-align:center;display:block;width:332px;height:50px;line-height:50px;border-radius:3px;background:#e9630a;margin-top:42px;}
	</style>
<!-- start-smoth-scrolling -->
</head>
<!-- 在这里调用省市县联动的方法 -->

<body bgcolor="#E0E0E0" onload="setup()">
<script type="text/javascript">
$(function(){
	//点击购物车跳转页面
	$(".my-cart-icon").click(function(){
		var account="${sessionScope.account}";
		if(account==null||account==""){
			$("#accountLogin").modal('show');
			return false;
		}
		window.location.href="${pageContext.request.contextPath}/jsp/order/shoppingcart/shoppingCart.jsp";		
	});
	getCarNum();
	//检查购物车数量
	function getCarNum(){
		$.post("${pageContext.request.contextPath}/shoping/getCartsByAccountIdServlet",{},function(date){
			date=eval(date);
			$(".my-cart-badge").html(date);
		});	
	}
});


</script>
<!-- header -->
	<div class="agileits_header">
		<div class="w3l_offers">
			<a href="products.html">今日特价！！！</a>
		</div>
		<div class="w3l_search">
			<form action="#" method="post">
				<input type="text" name="Product" value="输入您将要查询的信息" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search a product...';}" required="">
				<input type="submit" value=" ">
			</form>
		</div>
		<div class="product_list_header">  
			<div style="cursor: pointer;">
				<span class="glyphicon glyphicon-shopping-cart my-cart-icon"><i class="badge badge-notify my-cart-badge"></i></span>
			</div>
		</div>
		<div class="w3l_header_right">
			<ul>
				<li class="dropdown profile_details_drop">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user" aria-hidden="true"></i><span class="caret"></span></a>
					<div class="mega-dropdown-menu">
						<div class="w3ls_vegetables">
							<ul class="dropdown-menu drp-mnu">
								<li><a href="${pageContext.request.contextPath}/jsp/customer/account.jsp">登陆</a></li> 
								<li><a href="${pageContext.request.contextPath}/jsp/customer/index.jsp">个人中心</a></li>
								<li><a href="${pageContext.request.contextPath}/customer/LoginOutServlet">注销</a></li>
							</ul>
						</div>                  
					</div>	
				</li>
			</ul>
		</div>
		<div class="w3l_header_right1">
			<h2><a href="mail.html">联系我们</a></h2>
		</div>
		<div class="clearfix"> </div>
	</div>
<!-- script-for sticky-nav -->
<!-- //script-for sticky-nav -->
	<div class="logo_products">
		<div class="container">
			<div class="w3ls_logo_products_left">
				<h1><a href="${pageContext.request.contextPath}/jsp/index.jsp"><span>南老板</span> 商城</a></h1>
			</div>
			<div class="w3ls_logo_products_left1">
				<ul class="special_items">
					<li><a href="events.html">活动</a><i>/</i></li>
					<li><a href="about.html">关于我们</a><i>/</i></li>
					<li><a href="products.html">最优惠</a><i>/</i></li>
					<li><a href="services.html">服务</a></li>
				</ul>
			</div>
			<div class="w3ls_logo_products_left1">
				<ul class="phone_email">
					<li><i class="fa fa-phone" aria-hidden="true"></i>(+0123) 234 567</li>
					<li><i class="fa fa-envelope-o" aria-hidden="true"></i><a href="mailto:store@grocery.com">nan@163.com</a></li>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header -->
<!-- products-breadcrumb -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/jsp/index.jsp">主页</a><span>|</span></li>
				<li>订单结算页面</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb -->
<!-- banner -->
	<div class="banner">
<!-- faq -->
		<div class="faq">
			<h3>订单结算页面</h3>
			<!-- 功能模块 -->
		<!--通用搜索栏-->
<div class="GPS GPS_more">
  <div class="logo logo_more"> <a href="#"><img src="${pageContext.request.contextPath }/img/屏幕截图.jpg" width="187" height="94" alt="菜小子" title="菜小子" /></a> </div>
  <div class="guc_bt"><i>核对订单信息</i></div>
</div>
<!--通用导航栏-->

<!--banner栏目-->

<!--内容部分-->
<div class="main_box"> 

  <!--核对订单信息-->
  	
 	<!--收货人信息--> 
    <div class="shrxx">
    	<h1>收货人信息<i class="other">其他收货地址</i></h1>
    	<div id="showEmp">
		</div>
    </div>
    <!--支付方式-->
    <div class="zffs">
    	<h1>支付方式</h1>
        <ul class="zffs_xq">
        	<li>
            	<a href="#">在线支付</a>
            </li>
        </ul>
    </div>
    <!--商品清单-->
    <div class="spqd">
    	<h1>商品清单<i><a href="${pageContext.request.contextPath }/jsp/order/shoppingcart/shoppingCart.jsp">返回修改购物车</a></i></h1>
        <table width="1132" border="0" cellspacing="0" cellpadding="0" >
  			<tr class="qdbg1" >
    			<td align="center" width="586">商品信息</td>
    			<td align="center" width="114">商品类别</td>
    			<td align="center" width="150">数量</td>
    			<td align="center" width="114">总价</td>
  		   </tr>
         	<tr id="showEmp2"></tr>
		</table>
        
        <div class="qdnr">
        	
			<p>应付总额：                 ￥<span id="spanPrices"></span></p>
        </div>
    </div>
    <!--添加订单备注-->
    <div class="ddbz">
    	<h1>添加订单备注</h1>
        <textarea></textarea>
    </div>

    <!--应付金额-->
    <div class="gjs">
    	<div class="gjs_r">
        	<span>应付总额：<em>￥<i><span id="spanPrices1"></span></i></em></span>
            <input type="button" value="去结算" class="jsbu" />
        </div>
    </div>
</div>
      
</div>
 <div class="add-v1"></div>  
            <div class="nEW-TC1">
            	<div class="chacha"><img src="${pageContext.request.contextPath }/img/map-close.png" width="15" height="15" alt="" /></div>
                 <div class="nEW-dress">
                        <div class="nEW-More">
                    		<span>添加新地址</span>
                        </div>
                        <table class="New-tb" width="472" border="0" cellspacing="0" cellpadding="0">
  							<tr>
    							<td width="60">收件人：</td>
    							<td><input class="tcy-1" type="text" /></td>
  							</tr>
                            <tr>
    							<td>取货地址：</td>
    							<td>
    								<form name="frm">
										<select class="tcy-2" id="s1"><option>省份</option></select>
										<select class="tcy-2" id="s2"><option>地级市</option></select>
										<select class="tcy-2" id="s3"><option>市、县级市、县</option></select>
									</form>
                                </td>
  							</tr>
                            <tr>
    							<td>详细地址：</td>
    							<td><input class="tcy-3" type="text" /></td>
  							</tr>
                            <tr>
    							<td>手机号码：</td>
    							<td><input class="tcy-4" type="text" /></td>
  							</tr>
                            <tr>
    							<td>&nbsp;</td>
    							<td class="Inputbox"><input class="Bc-list" type="submit" value="确认" /><input class="Bc-list1" type="submit" value="取消" /></td>
  							</tr>
					</table>
                    	</div>
                 </div>
            <div class="Rsy-l">
            	<div class="chacha"><img src="${pageContext.request.contextPath }/img/map-close.png" width="15" height="15" alt="" /></div>
            	<div class="Rsy-lU">
                	<div class="Rsy-span">
                		<span>选择收货地址</span>
                    </div>
                    <ul class="fosys" id="showEmp1">
                    </ul>                   
                    <div class="aDDs">
                    	<input type="button" class="Aqrs" value="确认" /><input type="button"  class="Aqxs" value="添加" />
                    </div>
                </div>
            </div>         
                   
				<!--底部-->
			
			<!-- stop -->
		</div>
<!-- //faq -->
		<section class="model_bg"></section>
			<section class="my_model">
				<p class="title">删除宝贝<span class="closeModel">X</span></p>
				<p>您确认要删除该宝贝吗？</p>
				<div class="opBtn"><a href="javascript:;" class="dialog-sure">确定</a><a href="javascript:;" class="dialog-close">关闭</a></div>
				
			</section>
		
		<div class="clearfix"></div>
		
	</div>
<!-- //banner -->
<!-- newsletter -->
	<div class="newsletter">
		<div class="container">
			<div class="w3agile_newsletter_left">
				<h3>注册我们的通讯</h3>
			</div>
			<div class="w3agile_newsletter_right">
				<form action="#" method="post">
					<input type="email" name="Email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
					<input type="submit" value="现在订阅">
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //newsletter -->
<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="col-md-3 w3_footer_grid">
				<h3>信息</h3>
				<ul class="w3_footer_grid_list">
					<li><a href="events.html">大事记</a></li>
					<li><a href="about.html">关于我们</a></li>
					<li><a href="products.html">最优惠</a></li>
					<li><a href="services.html">服务</a></li>
					<li><a href="short-codes.html">简码</a></li>
				</ul>
			</div>
			<div class="col-md-3 w3_footer_grid">
				<h3>政策信息</h3>
				<ul class="w3_footer_grid_list">
					<li><a href="faqs.html">常见问题</a></li>
					<li><a href="privacy.html">隐私政策</a></li>
					<li><a href="privacy.html">使用条款</a></li>
				</ul>
			</div>
			<div class="col-md-3 w3_footer_grid">
				<h3>店里有什么</h3>
				<ul class="w3_footer_grid_list">
					<li><a href="pet.html">宠物食品</a></li>
					<li><a href="frozen.html">冷冻零食</a></li>
					<li><a href="kitchen.html">厨房</a></li>
					<li><a href="products.html">品牌食品</a></li>
					<li><a href="household.html">住户</a></li>
				</ul>
			</div>
			<div class="col-md-3 w3_footer_grid">
				<h3>推特帖子</h3>
				<ul class="w3_footer_grid_list1">
					<li><label class="fa fa-twitter" aria-hidden="true"></label><i>01 day ago</i><span>Non numquam <a href="#">http://sd.ds/13jklf#</a>
						eius modi tempora incidunt ut labore et
						<a href="#">http://sd.ds/1389kjklf#</a>quo nulla.</span></li>
					<li><label class="fa fa-twitter" aria-hidden="true"></label><i>02 day ago</i><span>Con numquam <a href="#">http://fd.uf/56hfg#</a>
						eius modi tempora incidunt ut labore et
						<a href="#">http://fd.uf/56hfg#</a>quo nulla.</span></li>
				</ul>
			</div>
			<div class="clearfix"> </div>
			<div class="agile_footer_grids">
				<div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
					<div class="w3_footer_grid_bottom">
						<h4>100% 安全付款</h4>
						<img src="${pageContext.request.contextPath }/img/frontDesk/card.png" alt=" " class="img-responsive" />
					</div>
				</div>
				<div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
					<div class="w3_footer_grid_bottom">
						<h5>联系我们</h5>
						<ul class="agileits_social_icons">
							<li><a href="#" class="facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
							<li><a href="#" class="twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
							<li><a href="#" class="google"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
							<li><a href="#" class="instagram"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
							<li><a href="#" class="dribbble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="wthree_footer_copy">
				<p>版权所有 &copy; 2016.该商城拥有最终解释权 。</p>
			</div>
		</div>
	</div>
	<div class="export">
            <div class="modal fade" id="renyuan">
                <div class="modal-dialog modal-lg modal_position">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">添加</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body" style="overflow: auto;height:320px;"  >
                                <!--新修改弹窗的样式-->
						  <div class="yListr" id="madalxiugai">
						  
						  </div>
                       	</div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button id="insertAdmin" type="button" class="btn btn-secondary">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/frontDesk/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
		    $(".dropdown").hover(            
		        function() {
		            $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
		            $(this).toggleClass('open');        
		        },
		        function() {
		            $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
		            $(this).toggleClass('open');       
		        }
		    );
		});
	</script>
<!-- here stars scrolling icon -->
	<!-- <script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script> -->
<!-- //here ends scrolling icon -->
<script type="text/javascript"></script>
<!-- <script type="text/javascript">
  $(function () {

    var goToCartIcon = function($addTocartBtn){
      var $cartIcon = $(".my-cart-icon");
      var $image = $('<img width="30px" height="30px" src="' + $addTocartBtn.data("image") + '"/>').css({"position": "fixed", "z-index": "999"});
      $addTocartBtn.prepend($image);
      var position = $cartIcon.position();
      $image.animate({
	  
      }, 500 , "linear", function() {
        $image.remove();
      });
    }

    $('.my-cart-btn').myCart({
      classCartIcon: 'my-cart-icon',
      classCartBadge: 'my-cart-badge',
      affixCartIcon: true,
      checkoutCart: function(products) {
        $.each(products, function(){
          console.log(this);
        });
      },
      clickOnAddToCart: function($addTocart){
        goToCartIcon($addTocart);
      },
      getDiscountPrice: function(products) {
        var total = 0;
        $.each(products, function(){
          total += this.quantity * this.price;
        });
        return total * 1;
      }
    });

  });
  </script> -->
</body>
</html>