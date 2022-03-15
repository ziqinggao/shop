<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
   <script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
	
  </script>
  <script type="text/javascript">
 
 addEventListener("load",function(){
	 setTimeout(hideURLbar,0);
 },false);
 function hideURLbar(){
	 window.scrollTo(0,1);
 }
 
 </script>
  <script type="text/javascript">
  $(function(){
	  //提示账户名是否已被注册
	  $("#account").blur(function(){
		  var account = $("#account").val();
		  var param={
				  account:account
		  }
		  $.post("${pageContext.request.contextPath}/merchantadmin/RepeatServlet",param,function(data){
			  if(data==true||data=="true"){
				
			  }else{
				  alert("该账户名已被注册，重新输入账户名");
				  $("#account").val("");
				  
			  }
			  return;
		  });
		  
	  });
	  
	  $("#submit").click(function(){
		  var account = $("#account").val();
			if(null == account || ""== account){
				alert("账户名不能为空");
				return false;
			}
			var password = $("#merchantPassowrd").val();
			if(null == password || ""== password){
				alert("密码不能为空");
				return false;
			}
			var merchantName=$("#merchantName" ).val();
			if(null ==merchantName||""==merchantName){
				alert("商家名字不能为空");
				return false ;
			}
			var unifyCode = $("#unifyCode").val();
			if(null == unifyCode || ""== unifyCode){
				alert("社会统一征信号码不能为空");
				return false;
			}
			var manage = $("#manage").val();
			if(null == password || ""== password){
				alert("经营范围不能为空");
				return false;
			}
			var location = $("#location").val();
			if(null == location || ""== location){
				alert("商家地址不能为空");
				return false;
			}
			var money = $("#money").val();
			if(null == money || ""== money){
				alert("注册资金不能为空");
				return false;
			}
			var corp = $("#corp").val();
			if(null == corp || ""== corp){
				alert("法人姓名不能为空");
				return false;
			}
			var corpPhone = $("#corpPhone").val();
			if(null == corpPhone || ""== corpPhone){
				alert("法人电话不能为空");
				return false;
			}
			var director = $("#director").val();
			if(null == director || ""== director){
				alert("主管姓名不能为空");
				return false;
			}
			var directorPhone = $("#directorPhone").val();
			if(null == directorPhone || ""== directorPhone){
				alert("主管电话不能为空");
				return false;
			}
			var licensePicture = $("#licensePicture").val();
			if(null == licensePicture || ""== licensePicture){
				alert("营业执照照片不能为空");
				return false;
			}
			var corpPicture = $("#corpPicture").val();
			if(null == corpPicture || ""== corpPicture){
				alert("法人身份证照片不能为空");
				return false;
			}
		  //点击提交
		  $(".form-validate").submit();
		  
	  });
	
  /* $("#submit").click(function(){
	
	  var account = $("#account").val();
		if(null == account || ""== account){
			alert("账户名不能为空");
			return false;
		}
		var password = $("#merchantPassowrd").val();
		if(null == password || ""== password){
			alert("密码不能为空");
			return false;
		}
		var merchantName=$("#merchantName" ).val();
		if(null ==merchantName||""==merchantName){
			alert("商家名字不能为空");
			return false ;
		}
		var unifyCode = $("#unifyCode").val();
		if(null == unifyCode || ""== unifyCode){
			alert("社会统一征信号码不能为空");
			return false;
		}
		var manage = $("#manage").val();
		if(null == password || ""== password){
			alert("经营范围不能为空");
			return false;
		}
		var location = $("#location").val();
		if(null == location || ""== location){
			alert("商家地址不能为空");
			return false;
		}
		var money = $("#money").val();
		if(null == money || ""== money){
			alert("注册资金不能为空");
			return false;
		}
		var corp = $("#corp").val();
		if(null == corp || ""== corp){
			alert("法人姓名不能为空");
			return false;
		}
		var corpPhone = $("#corpPhone").val();
		if(null == corpPhone || ""== corpPhone){
			alert("法人电话不能为空");
			return false;
		}
		var director = $("#director").val();
		if(null == director || ""== director){
			alert("主管姓名不能为空");
			return false;
		}
		var directorPhone = $("#directorPhone").val();
		if(null == directorPhone || ""== directorPhone){
			alert("主管电话不能为空");
			return false;
		}
		var licensePicture = $("#licensePicture").val();
		if(null == licensePicture || ""== licensePicture){
			alert("营业执照照片不能为空");
			return false;
		}
		var corpPicture = $("#corpPicture").val();
		if(null == corpPicture || ""== corpPicture){
			alert("法人身份证照片不能为空");
			return false;
		}
	  var param={
			  
			  account:account,	
	          password:password,
	          merchantName:merchantName,
	          unifyCode:unifyCode,
	          manage:manage,
	          location:location,
	          money:money,
	          corp:corp,
	          corpPhone:corpPhone,
	          director:director,
	          directorPhone:directorPhone,
	          licensePicture:licensePicture,
	          corpPicture:corpPicture
	  }
	$.post("${pageContext.request.contextPath}/merchantadmin/RegisteredServlet",param,function(data){
		if(data ==true || data=="true"){
			 alert("注册成功");
			 window.location.href="${pageContext.request.contextPath}/jsp/merchantadmin/login.jsp";
		 }else{
			 alert("注册失败，请检查各项输框有没有为空");
		 }
	});
	
	
  });*/
  
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
                    <h1>欢迎你</h1>
                  </div>
                  <p>这里是南老板商家注册系统</p>
                </div>
              </div>
            </div>
            <!-- Form Panel    -->
            <div class="col-lg-6 bg-white">
              <div class="form d-flex align-items-center">
                <div class="content">
                  <form class="form-validate" action="${pageContext.request.contextPath}/merchantadmin/RegisteredServlet" method="post" enctype="multipart/form-data" > 
                    <div class="form-group">
                     <input id="account" type="text"  placeholder="设置您的账号" name="registerUsername" required data-msg="请设置您的账号" class="input-material">
                      <label for="register-username" class="label-material"></label>
                    </div>
                   
                    <div class="form-group">
                      <input id="merchantPassowrd" type="password" placeholder="设置您的密码 " name="registerPassword" required data-msg="请设置您的密码 " class="input-material">
                      <label for="register-password" class="label-material">      </label>
                    </div>
					<div class="form-group">
                      <input id="merchantName" type="text" placeholder="设置您的商家名字 " name="registerUsername" required data-msg="请设置您的商家名字 " class="input-material">
                      <label for="register-username" class="label-material"></label>
                    </div>
					<div class="form-group">
                      <input id="unifyCode" type="number" placeholder="输入您的社会征信统一代码" name="registerUsername" required data-msg="请输入您的社会征信统一代码" class="input-material">
                      <label for="register-username" class="label-material"></label>
                    </div>
					<div class="form-group">
                      <input id="manage" type="text" placeholder="输入您的经营范围 " name="registerUsername" required data-msg="请输入您的经营范围 " class="input-material">
                      <label for="register-username" class="label-material"></label>
                    </div>
					<div class="form-group">
                      <input id="location" type="text" placeholder="输入您的商家地址 " name="registerUsername" required data-msg="请输入您的商家地址" class="input-material">
                      <label for="register-username" class="label-material"></label>
                    </div>
					<div class="form-group">
                      <input id="money" type="number"  placeholder="输入您的注册资金" name="registerUsername" required data-msg="请输入您的注册资金" class="input-material">
                      <label for="register-username" class="label-material"></label>
                    </div>
					<div class="form-group">
                      <input id="corp" type="text"  placeholder="输入您的法人姓名 " name="registerUsername" required data-msg="请输入您的法人姓名 " class="input-material">
                      <label for="register-username" class="label-material"></label>
                    </div>
					<div class="form-group">
                      <input id="corpPhone" type="number"  placeholder="输入您的法人电话 " name="registerUsername" required data-msg="请输入您的法人电话" class="input-material">
                      <label for="register-username" class="label-material"></label>
                    </div>
                    <div class="form-group">
                      <input id="director" type="text"  placeholder="输入您的主管姓名" name="registerUsername" required data-msg="请输入您的主管姓名" class="input-material">
                      <label for="register-username" class="label-material"></label>
                    </div>
					<div class="form-group">
                      <input id="directorPhone" type="number"  placeholder="输入您的主管电话 " name="registerUsername" required data-msg="请输入您的主管电话 " class="input-material">
                      <label for="register-username" class="label-material"></label>
                    </div> 
				
					 <div >
                     请上传您的营业执照 
					 <input id="licensePicture" type="file" name="licens" >
                    </div>
					<br/>
					 <div >
                     请上传法人身份证照片 
					 <input id="corpPicture" type="file" name="IDcard" >
                    </div>
			
					
                    <div class="form-group terms-conditions">
                      <input id="register-agree" name="registerAgree" type="checkbox" required value="1" data-msg="Your agreement is required" class="checkbox-template">
                      <label for="register-agree">我已详细阅读并同意服务协议及隐私保护指引</label>
                    </div>
                    <div >
                      <a
                       id="submit"   class="btn btn-primary">注册</a>
                    </div>
                  </form><small>已有账号? </small><a href="${pageContext.request.contextPath}/jsp/merchantadmin/login.jsp"class="signup">登录</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="copyrights text-center">
        <p>Copyright &copy; 2019.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
      </div>
    </div>
    <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath }/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath }/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${pageContext.request.contextPath }/vendor/chart.js/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath }/vendor/jquery-validation/jquery.validate.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/front.js"></script>
    <!-- Main File-->
   
  </body>
</html>
</body>
</html>