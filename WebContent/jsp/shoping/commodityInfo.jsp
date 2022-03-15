<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品详情页</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css">
<!-- font-awesome icons -->
<link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/normalize.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/manage.css">
<!-- //font-awesome icons -->
<!-- js -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easing.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/base.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery.jqzoom.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/bootbox.min.js"></script>
<!-- //here ends scrolling icon -->
<script type='text/javascript' src="${pageContext.request.contextPath}/js/jquery.mycart.js"></script>
<script type="text/javascript">
$(function(){
	var subsortPrice={};
	var commodityId="${param.commodityId}";
	showCommodityInfo();
	showPicture();
	showMerchant();
	CommodityNum();
	getCarNum();
	showCommodityOrdersAndEvaluates();
	showCommodityEvaluate();
	showSimilarityCommodity();
	
	//评价单选发生改变事件
	$(document).on("change","input[name='seach']",function(){
		showCommodityEvaluate();
	});
	$(document).on("change",".vaild",function(){
		showCommodityEvaluate();
	});
	//点击购买
	$(".yh").click(function(){
		var account="${sessionScope.account}";
		if($(".yListrclickem").length<$(".yListr li").length){
			alert("请选择商品详细类别");
			return 
		}
		if(account==null||account==""){
			$("#accountLogin").modal('show');
			return 
		}
		window.location.href="${pageContext.request.contextPath}/jsp/order/shoppingcart/shoppingCart.jsp";	
	});
	
	//添加购物车事件
	$(".hu").click(function(){
		var account="${sessionScope.account}";
		if($(".yListrclickem").length<$(".yListr li").length){
			alert("请选择商品详细类别");
			return 
		}
		if(account==null||account==""){
			$("#accountLogin").modal('show');
			return 
		}
		var prices=new Number(subsortPrice['price']);
		var subsort="";
		$(".yListrclickem").each(function(){
			var price=new Number(subsortPrice[$(this).attr("subsortid")]);
			prices+=price;
			subsort+=$(this).attr("subsortName");
		});
		var num=$("#text_box").val().trim();
		var param={
				commodityId:commodityId,
				subsort:subsort,
				price:prices,
				num:num
		}
		//添加购物车
		$.post("${pageContext.request.contextPath}/shoping/addShoppingCartServlet",param,function(date){
			if(date==true||date=="true"){
				alert("添加购物车成功");
			}else{
				alert("添加失败");
			}
			getCarNum();
		});
		
	});
	
	//点击购物车跳转页面
	$(".my-cart-icon").click(function(){
		var account="${sessionScope.account}";
		if(account==null||account==""){
			$("#accountLogin").modal('show');
			return false;
		}
		window.location.href="${pageContext.request.contextPath}/jsp/order/shoppingcart/shoppingCart.jsp";		
	});
	//检查购物车数量
	function getCarNum(){
		$.post("${pageContext.request.contextPath}/shoping/getCartsByAccountIdServlet",{},function(date){
			date=eval(date);
			$(".my-cart-badge").html(date);
		});	
	}
	
	//关闭登陆框
	$('.toggle').click(function(){
		$("#accountLogin").modal('hide');
		$(".modal-backdrop.fade").hide();
	});
	
	//点击登陆
	$("#login").click(function(){
		var username = $("#accountName").val();
		var password = $("#accountPassWord").val();  
		if(username == null||"" == username){
			alert("登录名不能为空");
			return false;
		}else if(password == null||"" == password){
			alert("密码不能为空");
			return false;
		}
		var param = {
				accountName:username,
				accountPassWord:password
		};
		$.post("${pageContext.request.contextPath}/customer/AccountLoginServlet",param,function(data){
			if(data == true || data == "true"){
				window.location.reload();
			}else{
				alert("账号或密码错误，请重新登录");
			}
		});
		return false;
	});
	
	//商品数量框
	$("#text_box").change(function(){
		CommodityNum();
	});
	
	$("#min").click(function(){
		var num=new Number($("#text_box").val());
		if(num==1){
			return false;
		}else{
			num--;
			$("#text_box").val(num);
			CommodityNum();
		}
	});
	$("#add").click(function(){
		var num=new Number($("#text_box").val());
		if(num==9999){
			return false;
		}else{
			num++;
			$("#text_box").val(num);
			CommodityNum();
		}
	});
	
	//判断选择的详细类别
	$(document).on("click",".yListr ul li em",function(){
		var classname=$(this).attr("class");
		if(classname==null||classname==''){
			$(this).addClass("yListrclickem").siblings().removeClass("yListrclickem");
		}else{
			$(this).removeClass("yListrclickem");
		}
		if($(".yListrclickem").length==$(".yListr li").length){
			var prices=new Number(subsortPrice['price']);
			$(".yListrclickem").each(function(){
				var price=new Number(subsortPrice[$(this).attr("subsortid")]);
				prices+=price;
			});
			$(".nowprice").html("￥<a href='#'>"+prices.toFixed(2)+"</a>");
		}else{
			if(subsortPrice['minprice']==subsortPrice['maxprice']){
				$(".nowprice").html("￥<a href='#'>"+subsortPrice['minprice'].toFixed(2)+"</a>");
			}else{
				
			$(".nowprice").html("￥<a href='#'>"+subsortPrice['minprice'].toFixed(2)+"~"+subsortPrice['maxprice'].toFixed(2)+"</a>");
			}
		}
	});
	//获取评价
	function showCommodityEvaluate(){
		var sort=0;
		if($(".allEvaluateData").prop("checked")){
			sort=1;
		}
		var vaild=0;
		if($(".vaild").prop("checked")){
			vaild=1;
		}
		var param={
			sort:sort,	
			vaild:vaild,
			commodityId:commodityId
		}
		$.post("${pageContext.request.contextPath}/shoping/getCommodityEvaluateByCommodityIdServlet",param,function(date){
			date=eval(date);
			var Evaluate=date[0];
			var table="";
			for(var i=0; i<Evaluate.length;i++){
				table+="<li><div ><span>评价人："+Evaluate[i].accountName.substr(0,1)+"**</span><span style='float: right;' >商品类别:&nbsp;&nbsp;&nbsp;&nbsp;"+Evaluate[i].subsort+"</span>"+
				"<div class='content-des'>"+Evaluate[i].evaluate+"</div><p style='text-align: right;'>"+Evaluate[i].evlauateDate+"</p></div></li>";
			}
			$(".detail-c-1").nextAll().remove();
			$(".evaluate").append(table);
		});
	}
	//获取商品销量和评价数
	function showCommodityOrdersAndEvaluates(){
		$.post("${pageContext.request.contextPath}/shoping/getOrdersAndEvaluatesByCommodityIdServlet",{commodityId:commodityId},function(date){
			date=eval(date);
			var Orders=date[0];//销量
			var Evaluates=date[1];//评价数
			$(".ty1").html("累计售出<br /><em id='add_sell_num_363'>"+Orders+"</em>");
			$(".tyu").html("累计评价<br /><em id='add_sell_num_363'>"+Evaluates+"</em>");
		});
	}
	
	//商品详情类别
	function showCommodityInfo(){
		$.post("${pageContext.request.contextPath}/shoping/getCommodityInfoByCommodityIdServlet",{commodityId:commodityId},function(date){
			date=eval(date);
			console.log(date);
			var Sort=date[0];//类别
			var Subsort=date[1];//详细类别
			var Commodity=date[2];//商品信息
			var maxPrice=new Number(Commodity.price);
			var minPrice=new Number(Commodity.price);
			var table="<form><ul>";
			for(var i=0;i<Sort.length;i++){
				table+="<li><span>"+Sort[i].sortName+"</span>";
				var sortArray=new Array();
				var a=0;
				for(var j=0;j<Subsort.length;j++){
					if(Subsort[j].sortId!=Sort[i].sortId){
						continue;
					}
					sortArray[a]=Subsort[j].subsortPrice;
					a++;
					subsortPrice[Subsort[j].subsortId]=Subsort[j].subsortPrice;
					table+="<em subsortId='"+Subsort[j].subsortId+"' subsortName='"+Subsort[j].subsortName+"'>"+Subsort[j].subsortName+"</em>";
				}
				maxPrice+=Math.max.apply(null, sortArray);
				minPrice+=Math.min.apply(null, sortArray);
				table+="</li>";
			}
			subsortPrice['price']=new Number(Commodity.price);
			subsortPrice['maxprice']=maxPrice;
			subsortPrice['minprice']=minPrice;
			table+="</ul></form>";
			$(".yListr").html(table);//添加详细类别
			$(".tr-nobdr").html("<h3>"+Commodity.commodityName+"</h3><p>"+Commodity.commodityDescribe+"</p>");//添加商品名字
			if(minPrice==maxPrice){
				$(".nowprice").html("￥<a href='#'>"+minPrice.toFixed(2)+"</a>");//添加价格
			}else{
				
			$(".nowprice").html("￥<a href='#'>"+minPrice.toFixed(2)+"~"+maxPrice.toFixed(2)+"</a>");//添加价格
			}
		
		});
	}
	//显示商家信息
	function showMerchant(){
		$.post("${pageContext.request.contextPath}/shoping/getMerchantByCommodityIdServlet",{commodityId:commodityId},function(date){
			date=eval(date);
			var Merchant=date[0];//商家信息
			$(".seller-pop-box").html("<span class='tr'>商家名称："+Merchant.merchantName+"</span>"+
					"<span class='tr'>社会征信统一码："+Merchant.unifyCode+"</span>"+
					"<span class='tr'>经营范围："+Merchant.manage+"</span>"+
					"<span class='tr hoh'><a title='"+Merchant.location+"' href='#'>所在地区："+Merchant.location+"</a></span>");
			
		});
			
			
	}
	//显示商品图片
	function showPicture(){
		$.post("${pageContext.request.contextPath}/shoping/getPictureByCommodityIdServlet",{commodityId:commodityId},function(date){
			date=eval(date);
			var picture=date[0];
			var table1="<ul>";//显示商品轮播图
			var table2="<ul style='display:block;'>";//显示商品详细图
			var table3="";//广告图
			for(var i=0;i<picture.length;i++){
				if(picture[i].pictureType==1||picture[i].pictureType=='1'){
					table1+="<li><img bimg='${pageContext.request.contextPath}/commodityImg/"+picture[i].pictureUrl+"' src='${pageContext.request.contextPath}/commodityImg/"+picture[i].pictureUrl+"' onmousemove='preview(this);'></li>";
				}else if(picture[i].pictureType==4||picture[i].pictureType=='4'){
					table2+="<li><img src='${pageContext.request.contextPath}/commodityImg/"+picture[i].pictureUrl+"'style='width:790px;'></li>";
				}else if(picture[i].pictureType==3||picture[i].pictureType=='3'){
					table3+="<img jqimg='${pageContext.request.contextPath}/commodityImg/"+picture[i].pictureUrl+"' src='${pageContext.request.contextPath}/commodityImg/"+picture[i].pictureUrl+"' style='width:350px;height:350px;'/>";
				}else{
					continue;
				}
			}
			table1+="</ul>";
			table2+="</ul>";
			$(".items").html(table1);
			$("#detail-a").html(table2);
			$(".jqzoom").html(table3);
			
		});
	}
	
	//判断数量框
	function CommodityNum(){
		var num=new Number($("#text_box").val());
		if(num<=1||num<='1'){
		 $("#min").css({
			 cursor: "not-allowed"
		 });   
		}else{
			$("#min").css({
				 cursor:"pointer"
			 }); 
		}
		if(num<=0){
			alert("数量不能低于1件");
			$("#text_box").val(1);
		}
	}
	//获取相同类型的商品
	function showSimilarityCommodity(){
		$.post("${pageContext.request.contextPath}/shoping/getSimilarityCommodityByCommodityIdServlet",{commodityId:commodityId},function(date){
			date=eval(date);
			var commodityInfo=date[0];
			var table="<h3>看了还看<span>🔍换一批</span></h3>";
			for(var i=0;i<commodityInfo.length;i++){
				table+="<dl class='ac-mod-list'><dt><a href='${pageContext.request.contextPath}/jsp/shoping/commodityInfo.jsp?commodityId="+commodityInfo[i].commodityId+"'><img src='${pageContext.request.contextPath}/commodityImg/"+commodityInfo[i].pictureUrl
				+"' /></a></dt><dd>"+commodityInfo[i].commodityName+"<span>￥"+commodityInfo[i].price+"</span></dd></dl>";
			}
			$(".aside").html(table);
		});
	}
	
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
	
});
</script>
</head>
	
<body>
<style type="text/css">
.yListr{width:520px;font-family:"微软雅黑";margin:20px auto 0 auto;max-height:400px;min-height:250px ;overflow: auto;}
.yListr ul li{margin-bottom:10px;}
.yListr ul li span{color:#000000;font-size:14px;line-height:50px;display:inline-block;width:70px;padding-left:4px;}
.yListr ul li em{cursor:pointer;color:#666666;font-size:14px;display:inline-block;padding:0 10px;font-style:normal;border:1px solid #dcdcdc;line-height:32px;height:32px;margin-right: 10px;margin-bottom: 5px;}
.yListr ul li em.yListrclickem{line-height:32px;border:2px solid #e9630a;height:32px;position:relative;padding:0 9px;}
.yListr ul li em.yListrclickem i{display:block;width:15px;height:14px;background:url(../../img/righbt.png) no-repeat 0 0;right:-1px;bottom:-1px;position:absolute;}
.yListr .colorp00{color:#333333;font-size:18px;line-height:50px;}
.yListr .colorp00 span{color:#ed610c;font-size:14px;padding-left:20px;}
.yListr .colorp00 em{font-style:normal;}
.yListr form input,.yListr form select{outline:none;border:1px solid #dcdcdc;width:86px;height:34px;font-size:14px;color:#333333;padding-left:8px;}
.yListr form select{height:36px;}
.yListr form .YImmediatelyininstallment{font-size:24px;color:#ffffff;text-align:center;display:block;width:332px;height:50px;line-height:50px;border-radius:3px;background:#e9630a;margin-top:42px;}
.clean{clear:both;}
.motai{margin: 9.75rem auto;width: 400px;}
</style>
<!-- header -->
	<div class="agileits_header">
		<div class="w3l_offers">
			<a href="products.html">Today's special Offers !</a>
		</div>
		<div class="w3l_search">
			<form action="#" method="post">
				<input type="text" name="Product" value="Search a product..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search a product...';}" required="">
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
			<h2><a href="mail.html">Contact Us</a></h2>
		</div>
		<div class="clearfix"> </div>
	</div>
<!-- script-for sticky-nav -->
	<script>
	$(document).ready(function() {
		 var navoffeset=$(".agileits_header").offset().top;
		 $(window).scroll(function(){
			var scrollpos=$(window).scrollTop(); 
			if(scrollpos >=navoffeset){
				$(".agileits_header").addClass("fixed");
			}else{
				$(".agileits_header").removeClass("fixed");
			}
		 });
		 
	});
	</script>
<!-- //script-for sticky-nav -->
	<div class="logo_products">
		<div class="container">
			<div class="w3ls_logo_products_left">
				<h1><a href="${pageContext.request.contextPath }/jsp/index.jsp"><span>Grocery</span> Store</a></h1>
			</div>
			<div class="w3ls_logo_products_left1">
				<ul class="special_items">
					<li><a href="events.html">Events</a><i>/</i></li>
					<li><a href="about.html">About Us</a><i>/</i></li>
					<li><a href="products.html">Best Deals</a><i>/</i></li>
					<li><a href="services.html">Services</a></li>
				</ul>
			</div>
			<div class="w3ls_logo_products_left1">
				<ul class="phone_email">
					<li><i class="fa fa-phone" aria-hidden="true"></i>(+0123) 234 567</li>
					<li><i class="fa fa-envelope-o" aria-hidden="true"></i><a href="mailto:store@grocery.com">store@grocery.com</a></li>
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
				<li>商品详情</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb -->
<!-- banner -->
<!-- //banner -->
<div class="showall">
			<!--left -->
			<div class="right-extra" style="float: left;margin-top: 20px; width:400px">
			  <!--产品参数开始-->
			  <div>
			    <div id="preview" class="spec-preview"> <span class="jqzoom"></span> </div>
			    <!--缩图开始-->
			    <div class="spec-scroll"> <a class="prev">&lt;</a> <a class="next">&gt;</a>
			      <div class="items">
			        
			      </div>
			    </div>
			
			  </div>
			  
			</div>
			<!--conet -->
			<div class="tb-property">
				<div class="tr-nobdr">
					<h3>商品正在备货中</h3>
				</div>
				<div class="txt">
					<span class="nowprice">￥<a href=""></a></span>
					<div class="cumulative">
						<span class="number ty1">累计售出<br /><em id="add_sell_num_363"></em></span>
						<span class="number tyu">累计评价<br /><em id="add_sell_num_363"></em></span>
					</div>
				</div>
				<!--商品详情类别 -->
				<div class="yListr">
					
				</div>
				<div class="gcIpt">
					<span class="guT">数量</span>
								<input id="min" name="" type="button" value="-" />
								<input id="text_box" name="" type="text" value="1" style="width:50px; text-align: center; color: #0F0F0F;" />
								<input id="add" name="" type="button" value="+" />
								<span class="Hgt">库存(99)</span>
				</div>
				<div class="nobdr-btns">
					<button class="addcart hu"><img src="${pageContext.request.contextPath }/imgs/cart.png" width="25" height="25" />加入购物车</button>
					<button class="addcart yh"><img src="${pageContext.request.contextPath }/imgs/share.png" width="25" height="25" />立即购买</button>
				</div>
				
			</div>
			<div class="export" >
				<div class="modal fade" id="accountLogin" style="opacity: 1.0 !important;">
					<div class="modal-dialog motai">
						<div class="modal-content">
									<div class="w3_login_module">
										<div class="module form-module">
										  <div class="toggle">
										  <span>✖</span>
										  </div>
										  <div class="form">
											<h2>请输入您的账户信息</h2>
											<form action="#" method="post">
											  <input type="text" name="accountName" id="accountName"  placeholder="账号" >
											  <input type="password" name="accountPassWord" id="accountPassWord" placeholder="密码" >
											  <input type="submit" id="login" value="Login">
											</form>
										  </div>
										  <div class="cta"><a href="#">Forgot your password?</a></div>
										</div>
									</div>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="extInfo">
				<div class="seller-pop-box">
					<span class="tr">商家名称:等待审核</span>
					<span class="tr">社会征信统一码：</span>
					<span class="tr">经营范围：</span>
					<span class="tr">注册资金：</span>
					<span class="tr">审核状态：</span>
					<span class="tr hoh">
						<a title="" href="">所在地区：</a>
					</span>
				</div>
				<div class="seller-phone">
					<span class="pop im">
						<a href="" data-name="联系卖家"><img src="" />联系卖家</a>
					</span>
					<span class="pop in">
						<a href="" data-name="咨询卖家"><img src="" />咨询卖家</a>
					</span>
					<span class="pop in">
						<a href="" data-name="进店逛逛"><img src="" />进店逛逛</a>
					</span>
					<span class="pop in">
						<a href="" data-name="关注店铺"><img src="" />关注店铺</a>
					</span>
				</div>
			</div>
		</div>
		<!-- 商品介紹 -->
		<div class="gdetail" >
			<!-- left -->
			<div class="aside">
				<h3>看了还看<span><img src="" width="22" height="22" />换一批</span></h3>
				<dl class="ac-mod-list">
					<dt><a href=""><img src="${pageContext.request.contextPath}/imgs/shopphone5.png" /></a></dt>
					<dd>
						O2+车载空气净化器DM2
						<span>￥99</span>
					</dd>
				</dl>
				<dl class="ac-mod-list">
					<dt><a href=""><img src="${pageContext.request.contextPath}/imgs/shopphone7.png" /></a></dt>
					<dd>
						O2+车载空气净化器DM2
						<span>￥99</span>
					</dd>
				</dl>
				<dl class="ac-mod-list">
					<dt><a href=""><img src="${pageContext.request.contextPath}/imgs/shopphone8.png" /></a></dt>
					<dd>
						O2+车载空气净化器DM2
						<span>￥99</span>
					</dd>
				</dl>
			</div>
			<div class="detail" >
				<div class="active_tab" id="outer">
					<ul class="act_title_left" id="tab">
						<li class="act_active">
							<a href="">商品详情</a>
						</li>
						<li>
							<a href="">商品评价</a>
						</li>
					</ul>
					<div class="clear"></div>
				</div>
				<div id="content" class="active_list">
					<!-- 商品详情-->
					<div id="detail-a" class="ui-a">
					<ul style="display:none;"></ul>
					</div>
					<!--规格参数-->
					<!-- <div id="detail-b" class="bit">
						<ul style="display:none;">

							<li>商品名称：仙人指路道镜前后双录智能后视镜导航仪行车记录仪后视预警一体机</li>
							<li>商品编号：ECS001983</li>
							<li>品牌</li>
							<li>上架时间：2016-05-24</li>
							<li>商品毛重：0克</li>
							<li>库存： 999 </li>
							<li><img src="hunsha/2hunsha1007.jpg"></li>

						</ul>
					</div>
 -->
 <style>
 .ui-c ul li{border-bottom: 1px solid #999999;}
 .ui-c ul li div span{color:#c8c8c8;}
 .ui-c ul li div p{color:#c8c8c8;}
 .detail-c-1{ width:100%; height:36px ;line-height: 36px; background-color: #c8c8c8;}
 .content-des{ width:60%;  margin-top: 10px; }
 </style>
					<!--商品评价-->
					<div id="detail-c" class="ui-c" >
						<ul class="detail-c-2 evaluate" style="display:none;">
							<div class="detail-c-1">
								<label><input class="allEvaluate" type="radio" name="seach" checked="checked"/>全部</label>
								<label><input class="allEvaluateData" type="radio" name="seach" />最新评价</label>
								<input class="vaild" type="checkbox" style="margin-left: 600px;" />过滤简短评价
							</div>
							<li>
								<div >
									<span>评级人：张三</span>
									<span style="float: right;" >商品：百草味零食大礼包&nbsp;&nbsp;&nbsp;&nbsp;规格：24包/箱</span>
									<div class="content-des">
										这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好
									</div>
									<p style="text-align: right;">2019-10-1</p>
								</div>
							</li>
							<li>
								<div >
									<span>评级人：张三</span>
									<span style="float: right;" >商品：百草味零食大礼包&nbsp;&nbsp;&nbsp;&nbsp;规格：24包/箱</span>
									<div class="content-des">
										这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好
									</div>
									<p style="text-align: right;">2019-10-1</p>
								</div>
							</li>
							<li>
								<div >
									<span>评级人：张三</span>
									<span style="float: right;" >商品：百草味零食大礼包&nbsp;&nbsp;&nbsp;&nbsp;规格：24包/箱</span>
									<div class="content-des">
										这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好这个商品很好
									</div>
									<p style="text-align: right;">2019-10-1</p>
								</div>
							</li>
						</ul>
					</div>
					<!--售后保障-->
					<!-- <div id="detail-d" class="uic">
						<ul style="display:none;">
							<p>商品名称：仙人指路道镜前后双录智能后视镜导航仪行车记录仪后视预警一体机</p>
							<p>商品编号：ECS001983</p>
							<p>品牌:威力马哈国产</p>
							<p>上架时间：2016-05-24</p>
							<span><img src="" /></span>
							<span><img src="" /></span>
						</ul>
					</div> -->
				</div>
				<script>
					$(function() {
						window.onload = function() {
							var $li = $('#tab li');
							var $ul = $('#content ul');

							$li.click(function() {
								var $this = $(this);
								var $t = $this.index();
								$li.removeClass();
								$this.addClass('act_active');
								$ul.css('display', 'none');
								$ul.eq($t).css('display', 'block');
								return false;
							})
						}
					});
				</script>
			</div>
			<div class='clean'></div>
		</div>
		<style type="text/css">
			.heart {
				width: 300px;
				height: 300px;
				background-color: pink;
				margin: 100px auto;
				position: relative;
			}

			.heart::before,
			.heart::after {
				position: absolute;

				display: block;
				content: ".";
				width: 150px;
				height: 250px;
				background-color: red;
				border-top-left-radius: 50% 75px;
				border-top-right-radius: 50% 75px;
				left: 41px;
				top: 0px;
				transform: rotate(-45deg);
			}

			.heart::after {
				transform: rotate(45deg);
				left: 112px;

			}
		</style>

<!-- newsletter -->
	<div class="newsletter">
		<div class="container"  >
			<div class="w3agile_newsletter_left">
				<h3>sign up for our newsletter</h3>
			</div>
			<div class="w3agile_newsletter_right">
				<form action="#" method="post">
					<input type="email" name="Email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
					<input type="submit" value="subscribe now">
				</form>
			</div>
			<div class="clearfix" style="width: 1300px"> </div>
		</div>
	</div>
<!-- //newsletter -->
<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="col-md-3 w3_footer_grid">
				<h3>information</h3>
				<ul class="w3_footer_grid_list">
					<li><a href="events.html">Events</a></li>
					<li><a href="about.html">About Us</a></li>
					<li><a href="products.html">Best Deals</a></li>
					<li><a href="services.html">Services</a></li>
					<li><a href="short-codes.html">Short Codes</a></li>
				</ul>
			</div>
			<div class="col-md-3 w3_footer_grid">
				<h3>policy info</h3>
				<ul class="w3_footer_grid_list">
					<li><a href="faqs.html">FAQ</a></li>
					<li><a href="privacy.html">privacy policy</a></li>
					<li><a href="privacy.html">terms of use</a></li>
				</ul>
			</div>
			<div class="col-md-3 w3_footer_grid">
				<h3>what in stores</h3>
				<ul class="w3_footer_grid_list">
					<li><a href="pet.html">Pet Food</a></li>
					<li><a href="frozen.html">Frozen Snacks</a></li>
					<li><a href="kitchen.html">Kitchen</a></li>
					<li><a href="products.html">Branded Foods</a></li>
					<li><a href="household.html">Households</a></li>
				</ul>
			</div>
			<div class="col-md-3 w3_footer_grid">
				<h3>twitter posts</h3>
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
						<h4>100% secure payments</h4>
						<img src="${pageContext.request.contextPath}/images/card.png" alt=" " class="img-responsive" />
					</div>
				</div>
				<div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
					<div class="w3_footer_grid_bottom">
						<h5>connect with us</h5>
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
				<p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">“南老板”网站</a></p>
			</div>
		</div>
	</div>
<!-- //footer -->

</body>
</html>