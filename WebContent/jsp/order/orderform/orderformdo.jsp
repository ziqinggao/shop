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

<!-- 页面的js -->
<script type="text/javascript" src='${pageContext.request.contextPath }/js/style/jquery-1.7.1.min.js'></script>
<script type="text/javascript">
$(function() {
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
	
	setTimeout("changeDivStyle();", 100); // 0.1秒后展示结果，因为HTML加载顺序，先加载脚本+样式，再加载body内容。所以加个延时
});
function changeDivStyle(){
//		var o_status = $("#o_status").val();	//获取隐藏框值
	var o_status = 2;
	if(o_status==0){
		$('#create').css('background', '#DD0000');
		$('#createText').css('color', '#DD0000');
	}else if(o_status==1||o_status==2){
		$('#check').css('background', '#DD0000');
		$('#checkText').css('color', '#DD0000');
	}else if(o_status==3){
		$('#produce').css('background', '#DD0000');
		$('#produceText').css('color', '#DD0000');
	}else if(o_status==4){
		$('#delivery').css('background', '#DD0000');
		$('#deliveryText').css('color', '#DD0000');
	}else if(o_status>=5){
		$('#received').css('background', '#DD0000');
		$('#receivedText').css('color', '#DD0000');
	}
}
</script>

<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
body{background:#f2f2f2;font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}
/* stepInfo 
	border-radius：0为正方形，0~N，由正方形向圆形转化，N越大越圆。
	padding：图形的内边距
	background：图形背景色
	text-align：文本对齐
	line-height：行高
	color：文字颜色
	position：定位
	width：宽度
	height：高度
*/
.stepInfo{position:relative;background:#f2f2f2;margin:20px auto 0 auto;width:500px;}
.stepInfo li{float:left;width:48%;height:0.15em;background:#bbb;}
.stepIco{border-radius:1em;padding:0.03em;background:#bbb;text-align:center;line-height:1.5em;color:#fff; position:absolute;width:1.4em;height:1.4em;}
.stepIco1{top:-0.7em;left:-1%;}
.stepIco2{top:-0.7em;left:21%;}
.stepIco3{top:-0.7em;left:46%;}
.stepIco4{top:-0.7em;left:71%;}
.stepIco5{top:-0.7em;left:95%;}
.stepText{color:#666;margin-top:0.2em;width:4em;text-align:center;margin-left:-1.4em;}
</style>
	
<!-- start-smoth-scrolling -->
</head>
<!-- 在这里调用省市县联动的方法 -->
<body bgcolor="#E0E0E0" onload="setup()">
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
			<h3>订单流程变化页面</h3>
		       <div class="stepInfo">
	<ul>
		<li></li>
		<li></li>
	</ul>
	<div class="stepIco stepIco1" id="create">1
		<div class="stepText" id="createText">创建订单</div>
	</div>
	<div class="stepIco stepIco2" id="check">2
		<div class="stepText" id="checkText">审核订单</div>
	</div>
	<div class="stepIco stepIco3" id="produce">3
		<div class="stepText" id="produceText">生产</div>
	</div>
	<div class="stepIco stepIco4" id="delivery">4
		<div class="stepText" id="deliveryText">配送</div>
	</div>
	<div class="stepIco stepIco5" id="received">5
		<div class="stepText" id="receivedText">签收</div>
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