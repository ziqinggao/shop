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
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/frontDesk/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/frontDesk/easing.js"></script>
<!-- <script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script> -->
<!-- 页面的js -->
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
			query();
			//购物车的数据打印
			function query(){
				var accountId = "${account.accountId}";
				var param = {
						accountId:accountId
				}	
				 $.post("${pageContext.request.contextPath}/order/shoppingcart/GetShoppingCartVListServlet",param,function(data){
					data = eval(data);
					var div = "";
					 for (var i = 0; i < data.length; i++) {
						div += "<div class='cartBox'><div class='shop_info'><div class='all_check'><input type='checkbox' id='merchant"+data[i][0].merchantId+"' class='shopChoice'><label for='merchant"+data[i][0].merchantId+"' class='shop'></label>"+
						"</div><div class='shop_name'>店铺：<a href='javascript:;'>"+data[i][0].merchantName+"</a></div></div><div class='order_content'>";
						var ul = "";
						for (var j = 0; j < data[i].length; j++) {
							ul += "<ul class='order_lists'><li class='list_chk'><input type='checkbox' prices='"+data[i][j].commodityPrices+"' commodityNum='"+data[i][j].commodityNumber+"' cartId='"+data[i][j].cartId+"' id='commodity"+data[i][j].cartId+"' class='son_check'><label for='commodity"+data[i][j].cartId+"'></label></li>"+
							"<li class='list_con'><div class='list_img'><a href='javascript:;'><img src='${pageContext.request.contextPath }/img/frontDesk/5.png' alt=''></a></div><div class='list_text'><a href='${pageContext.request.contextPath}/jsp/shoping/commodityInfo.jsp?commodityId="+data[i][j].commodityId+"'>"+data[i][j].commodityName+"</a></div></li>"+
							"<li class='list_info' id='xiu_gai'><p>默认规格</p><p>"+data[i][j].subsort+"</p><a href='"+data[i][j].commodityId+"' cartId='"+data[i][j].cartId+"' class='xiugai'>修改</a></li>"+
							"<li class='list_price'><p class='price'>"+data[i][j].commodityPrice+"</p></li>"+
							"<li class='list_amount' commodityNum='"+data[i][j].commodityNumber+"'><div class='amount_box'><a href='javascript:;' class='reduce'>-</a><input type='text' subsort='"+data[i][j].subsort+"' cartId='"+data[i][j].cartId+"' value='"+data[i][j].commodityNumber+"' class='sum'><a href='javascript:;' class='plus'>+</a></div></li>"+
							"<li class='list_sum' prices='"+data[i][j].commodityPrices+"'><p class='sum_price'>"+data[i][j].commodityPrices+"</p></li>"+
							"<li class='list_op'><p class='del'><a href='"+data[i][j].cartId+"' class='delBtn'>移除商品</a></p></li></ul>";
						}
						div += ul + "</div></div>";
					}  
					var section = document.getElementById("shoppingcartsection");
					section.innerHTML = div;
				}) 
			}
			//修改的事件
			$("body").on("click",".xiugai",function(){
				$("#renyuan").modal("show");
				var commodityId = $(this).attr("href");
				var cartId = $(this).attr("cartId");
				getSortAndSubsort(commodityId,cartId);
				return false;
			})
			//修改的时间弹窗打印
			function getSortAndSubsort(commodityId,cartId){
				event.preventDefault();
				var param = {
						commodityId:commodityId
				}
				$.post("${pageContext.request.contextPath}/order/shoppingcart/GetSortAndSubsortServlet",param,function(data){
					data = eval(data);
					var array1 = data[0];
					var form = "<form><ul class='sortnamecartid' cartId='"+cartId+"'>";
					var li = "";
					var a=1;
				 	for (var i = 0; i < array1.length; i++) {
						li += "<li><span>"+array1[i].sortName+":&nbsp;&nbsp;&nbsp;&nbsp;</span>";
						var em = "";
						var array2=data[a];
						for (var j = 0; j < array2.length; j++) {
							em += "&nbsp;<em subsortName='"+array2[j].subsortName+"' cartId='"+cartId+"'>"+array2[j].subsortName+"<i></i></em>&nbsp;";
						}
						a++;
						li += em + "</li>";
					}
					form += li + "</ul></form>";
					var madalxiugai = document.getElementById("madalxiugai");
					madalxiugai.innerHTML = form; 
				})
			}
			//数量的减
			$("body").on("click",".reduce",function(){
				var commodityNumber = $(this).next().val();
				var cartId = $(this).next().attr("cartId");
				var subsort = $(this).next().attr("subsort");
				if(commodityNumber == 1 || commodityNumber == "1"){
					alert("已经是最小数量了");
				}else{
					commodityNumber = parseInt(commodityNumber) - 1;
					inputNumber(cartId,subsort,commodityNumber);
					$(".sum").val(commodityNumber);
				}
			})
			//数量的加
			$("body").on("click",".plus",function(){
				var commodityNumber = $(this).prev().val();
				var cartId = $(this).prev().attr("cartId");
				var subsort = $(this).prev().attr("subsort");
				commodityNumber = parseInt(commodityNumber) + 1;
				inputNumber(cartId,subsort,commodityNumber);
				$(".sum").val(commodityNumber);
			})
			//input框的输入值
			$("body").on("change",".sum",function(){
				var cartId = $(this).attr("cartId");
				var subsort = $(this).attr("subsort");
				var commodityNumber = $(this).val();
				inputNumber(cartId,subsort,commodityNumber);
			})
			function inputNumber(cartId,subsort,commodityNumber){
				var param = {
						commodityNumber:commodityNumber,
						cartId:cartId,
						subsort:subsort
				}
			 	$.post("${pageContext.request.contextPath}/order/shoppingcart/DoUpdNumberAndPricesServlet",param,function(data){
					if(data == true || data == "true"){
						query();
					}else{
						alert("我们并没有这样数量的库存哦！！");
						query();
					}
				}) 
			}
			//删除商品
			$("body").on("click",".delBtn",function(event){
				event.preventDefault();
				var a = confirm("确定要删除吗？？");
				if(a == true || a == "true"){
					var cartId = $(this).attr("href");
					var param = {
							cartId:cartId
					}
					$.post("${pageContext.request.contextPath}/order/shoppingcart/DoDelShoppingCartServlet",param,function(){
						alert("删除成功");
						query();
					})
				}
			})
			//修改商品的类别
			$("body").on("click","#insertAdmin",function(){
				var b = "";
				var cartId = "";
				$("em[class='yListrclickem']").each(function(){
					cartId = $(this).attr("cartId");
					 b += $(this).attr("subsortName");
				})
				var param = {
					cartId:cartId,
					subsortName:b
				}
				$.post("${pageContext.request.contextPath}/order/shoppingcart/DoUpdSubsortServlet",param,function(data){
					if(data == false || data == "false"){
						alert("产品现下是无货的哦！")
					}
					$("#renyuan").modal("hide");
					$(".modal-backdrop.fade").hide();
					query();
					
				})
			})
			 //选择框s
			 //店铺的选择框
			$("body").on("click",".shopChoice",function(){
					if($(this).prop("checked")==false||$(this).prop("checked")=='false'){
						$(this).parents(".cartBox").find(".son_check").prop("checked",false);
						$(this).parents(".cartBox").find(".son_check").next().removeClass("mark");
						$(this).next().removeClass("mark");
					}else{
						$(this).parents(".cartBox").find(".son_check").prop("checked",true);
						$(this).parents(".cartBox").find(".son_check").next().addClass("mark");
						$(this).next().addClass("mark");
					}
					total();
			})
			//单个商品的选择框
			 $("body").on("click",".son_check",function(){
				if($(this).prop("checked")==false||$(this).prop("checked")=='false'){
					$(this).parents(".cartBox").find(".shopChoice").prop("checked",false);
					$(this).parents(".cartBox").find(".shopChoice").next().removeClass("mark");
					$(this).next().removeClass("mark");
				}else{
					$(this).next().addClass("mark");
				}
				total();
			})
			//全选的选择框
			$("body").on("click",".whole_check",function(){
				if($(this).prop("checked")==false||$(this).prop("checked")=='false'){
					$(".son_check").prop("checked",false);
					$(".son_check").next().removeClass("mark");
					$(".shopChoice").prop("checked",false);
					$(".shopChoice").next().removeClass("mark");
					$(this).next().removeClass("mark");
				}else{
					$(".son_check").prop("checked",true);
					$(".son_check").next().addClass("mark");
					$(".shopChoice").prop("checked",true);
					$(".shopChoice").next().addClass("mark");
					$(this).next().addClass("mark");
				}
				total();
			})
			//获取价格，每一次都重新加载就可以了
			function total(){
				/* var pieceNum =  parseInt($(".piece_num").html());
				var totalText = parseFloat($(".total_text").html())*100; */
				$.cookie("cartId",null);
				$.cookie("prices",null);
				var pieceNum =  0;
				var totalText = 0;
				var cartIds = "";
				$(".son_check").each(function(){
					if($(this).prop("checked")==true||$(this).prop("checked")=="true"){
						var cartId = parseInt($(this).attr("cartId"));
						var commodityNum = parseInt($(this).attr("commodityNum"));
						var prices = parseFloat($(this).attr("prices"))*100;
						pieceNum = pieceNum + commodityNum;
						totalText = totalText + prices;
						cartIds += cartId+",";
					}
				}) 
				//设置cookie值要设置path，否者读取不到
				$.cookie("cartId",cartIds,{path:"/"});
				if(pieceNum == 0|| pieceNum == "0"){
					$(".calBtn a").removeClass("btn_sty");
				}else{
					$(".calBtn a").addClass("btn_sty");
				}
				totalText = (totalText/100).toFixed(2);
				$.cookie("prices",totalText,{path:"/"});
				$(".total_text").html(totalText);
				$(".piece_num").html(pieceNum);
			}
			
			
			//取得同级元素的价格和数量
		/* 	function total(){
				var pieceNum =  parseInt($(".piece_num").html());
				var totalText = parseFloat($(".total_text").html())*100;
				console.log(pieceNum+"--"+totalText);
				$(".total_text").html("10.00"); 
				$(".son_check").each(function(){
					if($(this).prop("checked")==true||$(this).prop("checked")=="true"){
						var commodityNum = parseInt($(this).parent().siblings().eq(4).attr("commodityNum"));
						var prices = parseFloat($(this).parent().siblings().eq(5).attr("prices"))*100;
						pieceNum = pieceNum + commodityNum;
						totalText = totalText + prices;
						console.log(pieceNum+"--"+totalText);
						console.log($(this).parent().siblings().eq(5).attr("prices"));
					}
				}) 
				console.log(pieceNum+"--"+totalText);
				$(".total_text").html("100.00");
				$(".pieceNum").html(100);
			}  */
			/* $("body").on("click","label",function(){
				if($(this).prev().is(":checked")){
					$(this).prev().prop("checked",false);
					$(this).removeClass("mark");
				}else{
					$(this).prev().prop("checked",true);
					$(this).addClass("mark");
				}
			}) */
		})
	</script>
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
	
<body>
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
				<li>购物车清算页面</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb -->
<!-- banner -->
	<div class="banner">
<!-- faq -->
		<div class="faq">
			<h3>购物车清算页面</h3>
			<!-- 功能模块 -->
			<section class="cartMain" >
				<div class="cartMain_hd">
					<ul class="order_lists cartTop">
						<li class="list_chk">
							<!--所有商品全选-->
							<input type="checkbox" id="all" class="whole_check">
							<label for="all"></label>
						</li>
						<li class="list_con">商品信息</li>
						<li class="list_info">商品类别</li>
						<li class="list_price">单价</li>
						<li class="list_amount">数量</li>
						<li class="list_sum">金额</li>
						<li class="list_op">操作</li>
					</ul>
				</div>
				<div id="shoppingcartsection">
				</div>
				<div class="bar-wrapper">
							<div class="bar-right">
								<div class="piece">已选商品<strong class="piece_num">1</strong>件</div>
								<div class="totalMoney">共计: <strong class="total_text">1.25</strong></div>
								<div class="calBtn"><a href="${pageContext.request.contextPath }/jsp/order/orderform/orderform.jsp" id="orderformjsp">结算</a></div>
							</div>
				</div>
			</section>
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
<!-- <script type="text/javascript"></script>
<script type="text/javascript">
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