<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Commodity</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${pageContext.request.contextPath}/css/jquery-ui.min.css" rel="stylesheet">
<link  href="${pageContext.request.contextPath}/css/theme.css" rel="stylesheet"> 
<link  href="${pageContext.request.contextPath}/css/style.search.css" rel="stylesheet"> 
<!-- //for-mobile-apps -->
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css">
<!-- content -->

<!-- //font-awesome icons -->
<!-- <script type="text/javascript">
$(function () {
	$('[data-toggle="tooltip"]').tooltip();
	});
</script> -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/js1/jquery-2.2.4.min.js"></script>
</head>
	
<body>
<script type="text/javascript">
$(function(){
	
	$(".smallicon").click(function(){
		$(".products-list").removeClass("list");
		$(".products-list").addClass("grid");
		$(".products-list").children().removeClass("col-md-10");
		$(".products-list").children().addClass("col-md-4");
		
	});
	$(".bigicon").click(function(){
		$(".products-list").removeClass("grid");
		$(".products-list").addClass("list");
		$(".cartinfo--left").addClass("hidden");
		$(".products-list").children().removeClass("col-md-4");
		$(".products-list").children().addClass("col-md-10");
		
	});
	var typeId="${param.typeId}";
	var subtypeId="${param.subtypeId}";
	
	//通过详细类型来获取商品
	function showCommodityInfo(){
		if(typeId==''){
			//显示三个商家信息
			//价格分类
			//所有subId的商品
			//获取所有的详细类别
		}else{
			//显示所有的typeID的商品
			//获取所有的详细类别
			//价格分类
		}		
	}
	
})
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
								<li><a href="login.html">Login</a></li> 
								<li><a href="login.html">Sign Up</a></li>
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
	
<!-- //script-for sticky-nav -->
	<div class="logo_products">
		<div class="container">
			<div class="w3ls_logo_products_left">
				<h1><a href="index.html"><span>Grocery</span> Store</a></h1>
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
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">主页</a><span>|</span></li>
				<li>更多分类>女装</li>
			</ul>
		</div>
	</div>
<!-- content -->
		<div style="width:1200px; margin: 10px auto; min-height:800px; ">

			<div id="search-box">
				<dl>
					<dt>品牌：</dt>
					<dd>惠普</dd>
					<dd>联想</dd>
					<dd>戴尔</dd>
					<dd>三星</dd>
					<dd>宏基</dd>
					<dd>苹果</dd>
					<dd>神舟</dd>
					<dd>华硕</dd>
					<dd>方正</dd>
				</dl>
				<dl>
					<dt>价格：</dt>
					<dd>3000-3999</dd>
					<dd>4000-4999</dd>
					<dd>5000-5999</dd>
					<dd>6000-6999</dd>
					<dd>7000-7999</dd>
					<dd>8000-8999</dd>
					<dd>9000-9999</dd>
					<dd>10000以上</dd>
				</dl>
				<dl>
					<dt>尺寸：</dt>
					<dd>8.9英寸以及以下</dd>
					<dd>11英寸</dd>
					<dd>12英寸</dd>
					<dd>13英寸</dd>
					<dd>14英寸</dd>
					<dd>15英寸</dd>
					<dd>16英寸</dd>
				</dl>
				<dl style="border: none">
					<dt>显卡：</dt>
					<dd>独立显卡</dd>
					<dd>集成显卡</dd>
					<dd>核芯显卡</dd>
				</dl>
				<dl class="select" style="border-bottom-width: 0px;">
					<dt>已选条件：</dt>
				</dl>
			</div>
			 <div id="content" class="col-md-9 col-sm-8">
        		<div class="products-category">
        			<!-- Filters -->
                    <div class="product-filter product-filter-top filters-panel">
                        <div class="row">
                            <div class="col-md-5 col-sm-3 col-xs-12 view-mode">
                                
                                    <div class="list-view">
                                        <button class="btn btn-default grid active smallicon" data-view="grid" data-toggle="tooltip"  data-original-title="Grid"><i class="fa fa-th"></i></button>
                                        <button class="btn btn-default list  bigicon" data-view="list" data-toggle="tooltip" data-original-title="List"><i class="fa fa-th-list"></i></button>
                                    </div>
                        
                            </div>
                           
					   </div>
                    </div>
                    <!-- //end Filters -->

        			<!--changed listings-->
                    <div class="products-list row nopadding-xs so-filter-gird">
                        <div class="product-layout col-lg-15 col-md-4 col-sm-6 col-xs-12">
                            <div class="product-item-container">
                                <div class="left-block left-b">
                                    
                                    <div class="product-image-container second_img">
                                        <a href="product.html" target="_self" title="Lastrami bacon">
                                            <img src="${pageContext.request.contextPath}/images/e1.jpg" class="img-1 img-responsive" alt="image1">
                                            <img src="${pageContext.request.contextPath}/images/e10.jpg" class="img-2 img-responsive" alt="image2">
                                        </a>
                                    </div>
                                </div>
                                <div class="right-block">
                                    <div class="button-group so-quickview cartinfo--left">
                                        <button type="button" class="addToCart" title="Add to cart" onclick="cart.add('60 ');">
                                            <span>Add to cart </span>   
                                        </button>
                                        <button type="button" class="wishlist btn-button" title="Add to Wish List" onclick="wishlist.add('60');"><i class="fa fa-heart-o"></i><span>Add to Wish List</span>
                                        </button>
                                        <button type="button" class="compare btn-button" title="Compare this Product " onclick="compare.add('60');"><i class="fa fa-retweet"></i><span>Compare this Product</span>
                                        </button>
                                        
                                    </div>
                                    <div style="width:800px">
                                    <div class="caption hide-cont">
                                        <div class="ratings">
                                            <div class="rating-box">   
                                            </div>
                                        </div>
                                        <h4><a href="product.html" title="Pastrami bacon" target="_self">Lastrami bacon</a></h4>
                                        
                                    </div>
                                    <p class="price">
                                      <span class="price-new">$80.00</span>
                                      
                                    </p>
                                    <div class="description item-desc">
                                        <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est . </p>
                                    </div>
                                    <div class="list-block">
                                        <button class="addToCart btn-button" type="button" title="Add to Cart" onclick="cart.add('101', '1');"><i class="fa fa-shopping-basket"></i>
                                        </button>
                                        <button class="wishlist btn-button" type="button" title="Add to Wish List" onclick="wishlist.add('101');"><i class="fa fa-heart"></i>
                                        </button>
                                        <button class="compare btn-button" type="button" title="Compare this Product" onclick="compare.add('101');"><i class="fa fa-refresh"></i>
                                        </button>
                                       
                                    </div>
                                </div>
								</div>
                            </div>
                        </div>
                        
                        <div class="product-layout col-lg-15 col-md-4 col-sm-6 col-xs-12">
                            <div class="product-item-container">
                                <div class="left-block left-b">
                                    
                                    <div class="product-image-container second_img">
                                        <a href="product.html" target="_self" title="Lastrami bacon">
                                            <img src="${pageContext.request.contextPath}/images/e1.jpg" class="img-1 img-responsive" alt="image1">
                                            <img src="${pageContext.request.contextPath}/images/e10.jpg" class="img-2 img-responsive" alt="image2">
                                        </a>
                                    </div>
                                </div>
                                <div class="right-block">
                                    <div class="button-group so-quickview cartinfo--left">
                                        <button type="button" class="addToCart" title="Add to cart" onclick="cart.add('60 ');">
                                            <span>Add to cart </span>   
                                        </button>
                                        <button type="button" class="wishlist btn-button" title="Add to Wish List" onclick="wishlist.add('60');"><i class="fa fa-heart-o"></i><span>Add to Wish List</span>
                                        </button>
                                        <button type="button" class="compare btn-button" title="Compare this Product " onclick="compare.add('60');"><i class="fa fa-retweet"></i><span>Compare this Product</span>
                                        </button>
                                        
                                    </div>
                                    <div style="width:800px">
                                    <div class="caption hide-cont">
                                        <div class="ratings">
                                            <div class="rating-box">   
                                            </div>
                                        </div>
                                        <h4><a href="product.html" title="Pastrami bacon" target="_self">Lastrami bacon</a></h4>
                                        
                                    </div>
                                    <p class="price">
                                      <span class="price-new">$80.00</span>
                                      
                                    </p>
                                    <div class="description item-desc">
                                        <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est . </p>
                                    </div>
                                    <div class="list-block">
                                        <button class="addToCart btn-button" type="button" title="Add to Cart" onclick="cart.add('101', '1');"><i class="fa fa-shopping-basket"></i>
                                        </button>
                                        <button class="wishlist btn-button" type="button" title="Add to Wish List" onclick="wishlist.add('101');"><i class="fa fa-heart"></i>
                                        </button>
                                        <button class="compare btn-button" type="button" title="Compare this Product" onclick="compare.add('101');"><i class="fa fa-refresh"></i>
                                        </button>
                                       
                                    </div>
                                </div>
								</div>
                            </div>
                        </div>
                        

                    </div>
                    
        			<!--// End Changed listings-->
        			<!-- Filters -->
        			<div class="product-filter product-filter-bottom filters-panel">
                        <div class="row">
                            
                        </div>
                    </div>
        			<!-- //end Filters -->
        			
        		</div>
        		
        	</div>
		</div>
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
<!-- Bootstrap Core JavaScript -->

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/js1/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/js1/themejs/libs.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/js1/countdown/jquery.countdown.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/js1/dcjqaccordion/jquery.dcjqaccordion.2.8.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/js1/datetimepicker/moment.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/js1/datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/js1/themejs/application.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/move-top.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easing.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.search.js"></script> 
	<script type="text/javascript">
		if($.cookie('display')){
			view = $.cookie('display');
		}else{
			view = 'grid';
		}
		if(view) display(view);
	</script> 

<!-- js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.mycart.js"></script>
<script type="text/javascript">
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
</body>
</html>