<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/favicon.ico">
    <script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
 <script type="text/javascript">
 
 addEventListener("load",function(){
	 setTimeout(hideURLbar,0);
 },false);
 function hideURLbar(){
	 window.scrollTo(0,1);
 }
 
 </script>
 
 <script>
 $(function(){
	
		$("#submit").click(function(){
			var account = $("input[type='text']").val();
			if(null == account || ""== account){
				alert("登录名不能为空");
				return false;
			}
			var password = $("input[type='password']").val();
			if(null == password || ""== password){
				alert("密码不能为空");
				return false;
			}
			var role = 2;	
			var $admin = $("#admin");
			if($admin.prop("checked") == true){//选中的是管理员而非商家
				role = 1;
			}
			var param = {
					account:account,
					password:password,
					role:role
			};
			 $.post("${pageContext.request.contextPath}/merchanadmin/MerchantAdmin",param,function(data){
				 
				 if(data ==true || data=="true"){
					 window.location.href="${pageContext.request.contextPath}/jsp/indexAdmin.jsp";
				 }else{
					 alert("登录失败，请检查账户和密码");
				 }
			 });
			 return false;
		 });
	 });
 
 </script>
  </head>
  <body>

    <div class="page login-page">
      <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
          <div class="row">
            <!-- Logo & Information Panel-->
            <div class="col-lg-6">
              <div class="info d-flex align-items-center">
                <div class="content">
                  <div class="logo">
                    <h2>欢迎你！</h2>
                  </div>
                  <p>这里是南老板后台管理系统</p>
                </div>
              </div>
            </div>
            <!-- Form Panel    -->
            <div class="col-lg-6 bg-white">
              <div class="form d-flex align-items-center">
                <div class="content">
                  <form method="post" class="form-validate">
                    <div class="form-group">
                   <input id="login-username" type="text" name="account" placeholder="账号" required data-msg="Please enter your username" class="input-material">
                      
                    </div>
                    <div class="form-group">
                   <input id="login-password" type="password" name="password" placeholder="密码" required data-msg="Please enter your password" class="input-material">
                      <br><br>
					  
					  <div  > <input  type="radio"  name="role" value="2" checked="checked"><label>商家</label>&nbsp;&nbsp;&nbsp;<input type="radio"  name="role" id="admin"  value="1"><label>商城管理员</label></div>
                    </div><a id="submit"  style="margin:0 0 20px;" class="btn btn-primary">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="register" href="${pageContext.request.contextPath }/jsp/merchantadmin/registered.jsp" class="btn btn-primary">注册</a>
                    <!-- This should be submit button but I replaced it with <a> for demo purposes-->
                  </form><a href="#" class="forgot-pass">&nbsp;忘记密码?</a><br>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="copyrights text-center">
        <p>Design by <a href="#" class="external">Bootstrapious</a>
          <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
        </p>
      </div>
    </div>
    <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath }/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath }/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${pageContext.request.contextPath }/vendor/chart.js/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath }/vendor/jquery-validation/jquery.validate.min.js"></script>
    <!-- Main File-->
    <script src="${pageContext.request.contextPath }/js/front.js"></script>
  </body>
</html>