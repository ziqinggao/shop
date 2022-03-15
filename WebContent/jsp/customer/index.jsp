<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>个人中心</title>
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
 		
	   showaccount();
	   //显示个人信息
	   function showaccount(){
		   $.post("${pageContext.request.contextPath}/customer/GetAccountServlet",{},function(data){
			   data=eval(data);
			   var account=data[0];
				$("#name").val(account.name);
				$("#accountName").val(account.accountName);
        		$("#phone").val(account.phone);	
        		if (account.gender==1){
        			$("#gender").prop("checked",true);
        		}else{
        			$("#gender1").prop("checked",true);
        		}
        		$("#age").val(account.age);
        		$("#birthday").val(account.birthday);	
        		$("#idCard").val(account.idCard);	
        		$("#balance").val(account.balance);
        		$("#email").val(account.email);
        		if(account.vip==0){
        			$("#vip").val("不是");
        		}else{
        			$("#vip").val("是");
        		}
        		$("#vipBirthday").val(account.vipBirthday);
        		$("#vipDate").val(account.vipDate)
        			
		   });
		  
	   }
	   $("#button").click(function(){
		   $("#name").removeAttr("disabled");
		   $("#phone").removeAttr("disabled");
		   $("#gender").removeAttr("disabled");
		   $("#gender1").removeAttr("disabled");
		   $("#idCard").removeAttr("disabled");
		   $("#birthday").removeAttr("disabled");
		   $("#email").removeAttr("disabled");
		   
	   });
	   $("#but").click(function(){
		   var name=$("#name").val();
		   var phone=$("#phone").val();
		   var gender=1;
		   if($("#gender1").checked==true){
			   gender=0;
		   }
		   var age=$("#age").val();
		   var birthday=$("#birthday").val();
		   var idCard=$("#idCard").val();
		   var email=$("#email").val();
		   var param1={
				   name:name,
				   phone:phone,
				   gender:gender,
				   age:age,
				   birthday:birthday,
				   idCard:idCard,
				   email:email
		   } 
		   console.log(param1);
		   $.post("${pageContext.request.contextPath}/customer/UpdateAccountServlet",param1,function(date){
			   console.log(date);
			   if(date==true||date=="true"){
				   alert("确认修改?");
				   window.location.reload();
				   
			   }else{
				   alert("修改失败");
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
				<li>个人中心</li>
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
						<li><a href="${pageContext.request.contextPath }/jsp/customer/charge.jsp">提现</a></li>
						<li><a href="${pageContext.request.contextPath }/jsp/customer/transfer.jsp">转账</a></li>
						<li><a href="${pageContext.request.contextPath }/jsp/customer/location.jsp">收货地址管理</a></li>
						
					</ul>
				 </div><!-- /.navbar-collapse -->
			</nav>
		</div>
		<div class="w3l_banner_nav_right">
<!-- mail -->

		<div class="mail" id="user" style=" margin-top:0px" >
			
			
			<!--<div class="agileinfo_mail_grids"> -->
			<form action="#" method="post" >
		<div style="height:60px ">
			姓名: <input type="text" disabled="disabled" name="accountname" id="name" style="width:210px "  >
			账号: <input type="text" disabled="disabled" name="account" id="accountName" style="width:210px "   >
			电话: <input type="number" disabled="disabled" name="accountphone" id="phone" style="width:210px "  >
		   </div >
			<div style="height:60px ">
			性别：<input type="radio" style="margin-left:30px" value="1"  disabled="disabled" name="accountgender" id="gender"   >男
			<input type="radio"  style="margin-left:30px" value="2" disabled="disabled" name="accountgender" id="gender1"   >女
			<span style="margin-left:92px">年龄:</span> <input type="number" disabled="disabled" name="accountage" id="age"  style=" width:210px; " >
			生日: <input type="date" disabled="disabled" name="acountbrithday" id="birthday"  style="width:210px " >
			</div>
			<div style="height:60px ">
			身份证号: <input type="number" disabled="disabled" name="accountidcard" id="idCard"  style="width:179px " >
			邮箱: <input type="email" disabled="disabled" name="accountemail" id="email"  style="width:210px " >
			余额: <input type="text" disabled="disabled" name="accountbalance" id="balance"  style="width:210px " >
			</div>
			<div style="height:60px ">
			注册时间: <input type="text" disabled="disabled" name="accountvipbirthday" id="vipBirthday" style="width:180px " >
			是否为VIP: <input type="text" disabled="disabled" name="accountvip" id="vip"  style="width:170px " >
			VIP到期时间: <input type="date" disabled="disabled" name="accountvipdate" id="vipDate" style="width:150px "  >	
			</div>
			<button id="button" type="button"  > 点击修改</button>
		    <button id="but" type="button" style="margin-left :50px" > 确定修改</button>
		</form>
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
						<img src="images/card.png" alt=" " class="img-responsive" />
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