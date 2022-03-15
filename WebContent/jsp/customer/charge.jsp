<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>充值页面</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/amazeui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
<!-- //font-awesome icons -->
<!-- js -->
<script src="${pageContext.request.contextPath}/js1/jquery-1.11.1.min.js"></script>
<!-- //js -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js1/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js1/easing.js"></script>
<!-- <script type="text/javascript">
	 jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	}); 
</script> -->
<!-- start-smoth-scrolling -->
</head>
<body>
<script>
      $(function(){
    	  var account="${account}";
    	  if(account==null||account==""){
    		  alert("请先登陆");
    		  window.location.href = "${pageContext.request.contextPath}/jsp/customer/account.jsp";
    		  return false;
    	  }
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
    				$('.rechnum').text('1.00元');
    			})
    			$('#uc_01 li:eq(0)').click(function() {
    				$('.tr_rechoth').hide();
    				$('.rechnum').text('100.00元');
    				$('.othbox').val('');
    			})
    			$('#uc_01 li:eq(1)').click(function() {
    				$('.tr_rechoth').hide();
    				$('.rechnum').text('200.00元');
    				$('.othbox').val('');
    			})
    			$('#uc_01 li:eq(2)').click(function() {
    				$('.tr_rechoth').hide();
    				$('.rechnum').text('500.00元');
    				$('.othbox').val('');
    			})
    			$(document).ready(function() {
    				$('.othbox').on('input propertychange', function() {
    					var num = $(this).val();
    					$('.rechnum').html(num + ".00元");
    				});
    			});
    		});

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
    	  
    	  $("#monney").click(function(){
    		  var price=$("#price").html();
    		  var a=new RegExp("元");
    		  price=price.replace(a,""); 
    		  var param={
    				  price:price
    		  }
    		  if($(".radio1").prop("checked")==false&&$(".radio2").prop("checked")==false||$(".radio1").prop("checked")=='false'&&$(".radio2").prop("checked")=='false'){
    			  $(".am-ucheck-radio").css({
    				  display:none
    			  });
    			  return false;
    		  }
    		  $.post("${pageContext.request.contextPath }/customer/UpdateAccountBlance",param,function(data){
    			  if(data==true||data=="true"){
    				  alert("充值成功");
    				 $('.othbox').html("");
    				 window.location.reload();
    				  
    			  }else{
    				  alert("充值失败");
    			  }
    		  });
    		  
    	  });
      });
      
</script>
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
								<!-- <li><a href="login.html">Login</a></li>  -->
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
				<h1><a href="${pageContext.request.contextPath}/jsp/index.jsp"><span>Grocery</span> Store</a></h1>
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
				<li>充值</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb -->
<!-- banner -->
	<div class="banner">
		<div class="w3l_banner_nav_left">
			<nav class="navbar nav_bottom">
			 <!-- Brand and toggle get grouped for better mobile display -->
			  <div class="navbar-header nav_2">
				  <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
			   </div> 
			   <!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
					<ul class="nav navbar-nav nav_1">
						<li><a href="${pageContext.request.contextPath }/jsp/customer/index.jsp">个人信息</a></li>
						<li><a href="${pageContext.request.contextPath }/jsp/customer/password.jsp">密码管理</a></li>
						<li><a href="${pageContext.request.contextPath }/jsp/customer/charge.jsp">充值</a></li>
						<li><a href="${pageContext.request.contextPath }/jsp/customer/withdrawals.jsp">提现</a></li>
						<li><a href="${pageContext.request.contextPath }/jsp/customer/transfer.jsp">转账</a></li>
						<li><a href="${pageContext.request.contextPath }/jsp/customer/location.jsp">收货地址管理</a></li>
						
					</ul>
				 </div><!-- /.navbar-collapse -->
			</nav>
		</div>
		<div class="w3l_banner_nav_right">
<!-- mail -->

			
			
		<div class="pay">
	<!--主内容开始编辑-->
	<div class="tr_recharge">
		<form action="" class="am-form" id="doc-vld-msg">
			<div class="tr_rechbox">
				<div class="tr_rechhead">
					<img src="${pageContext.request.contextPath }/imgs/ys_head2.jpg" />
					<p>充值帐号：
						<% %>
					</p>
					<div class="tr_rechheadcion">
						<img src="${pageContext.request.contextPath }/imgs/coin.png" alt="" />
						<span >当前余额:<span style="margin-left:6px" class="balance">${sessionScope.account.balance} </span></span>
					</div>
				</div>
				<div class="tr_rechli am-form-group">
					<ul class="ui-choose am-form-group" id="uc_01">
						<li>
							<label class="am-radio-inline">
							
									<input type="radio"  value="" name="docVlGender" required data-validation-message="请选择一项充值额度"> </br><P>100￥</P></label>
						</li>
						<li>
							<label class="am-radio-inline">
									<input type="radio" name="docVlGender" data-validation-message="请选择一项充值额度"></br><P>200￥</P>
								</label>
						</li>

						<li>
							<label class="am-radio-inline">
									<input type="radio" name="docVlGender" data-validation-message="请选择一项充值额度"> </br><P>500￥</P>
								</label>
						</li>
						<li>
							<label class="am-radio-inline">
									<input type="radio" name="docVlGender" data-validation-message="请选择一项充值额度"> </br><P>其它金额</P>
								</label>
						</li>
					</ul>
					<!--<span>1招兵币=1元 10元起充</span>-->
				</div>
				<div class="tr_rechoth am-form-group">
					<span>其他金额：</span>
					<input type="number" min="1" max="1000000" value="1.00" class="othbox" data-validation-message="充值金额范围：1-100000" />
					<!--<p>充值金额范围：10-10000元</p>-->
				</div>
				<div class="tr_rechcho am-form-group">
					<span>充值方式：</span>
					<label class="am-radio">
							<input class="radio1" type="radio" name="radio1" value="" data-am-ucheck required data-validation-message="请选择一种充值方式"><img src="${pageContext.request.contextPath }/imgs/wechatpay.png">
						</label>
					<label class="am-radio" style="margin-right:30px;">
							<input class="radio2" type="radio" name="radio1" value="" data-am-ucheck data-validation-message="请选择一种充值方式"><img src="${pageContext.request.contextPath }/imgs/zfbpay.png">
						</label>
						<!-- <label  style="margin-right:30px;">
							<input type="radio" name="radio1" value="" data-am-ucheck data-validation-message="请选择一种充值方式">>
						</label> -->
						
				</div>
				<div class="tr_rechnum">
					<span>应付金额：</span>
					<p class="rechnum" id="price">0.00元</p>
				</div>
			</div>
			<div class="tr_paybox">
				<input type="button"  id="monney" value="确认支付" class="tr_pay am-btn" />
			</div>
		</form>
	</div>
</div>
			
		<!-- </div> -->
<!-- //mail -->
		</div>
	
		<div class="clearfix"></div>
	</div>
<!-- //banner -->
<!-- map -->
<!-- //map -->
<!-- newsletter -->
	<div class="newsletter">
		<div class="container">
			<div class="w3agile_newsletter_left">
				<h3>sign up for our newsletter</h3>
			</div>
			<div class="w3agile_newsletter_right">
				<form action="#" method="post">
					<input type="email" name="Email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
					<input type="submit" value="subscribe now">
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
						<img src="imgs/card.png" alt=" " class="img-responsive" />
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
				<p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
			</div>
		</div>
	</div>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/js1/bootstrap.min.js"></script>
<script>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js1/amazeui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js1/ui-choose.js"></script>
<%-- <script type="text/javascript" id="snipcart" src="${pageContext.request.contextPath}/js1/snipcart.js" data-api-key="ZGQxNzVjZTItOWRmNS00YjJhLTlmNGUtMDE4NjdiY2RmZGNj"></script> --%>
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
<script type='text/javascript' src="${pageContext.request.contextPath}/js1/jquery.mycart.js"></script>
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