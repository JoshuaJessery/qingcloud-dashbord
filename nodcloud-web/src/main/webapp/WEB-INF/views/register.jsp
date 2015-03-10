<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="front" tagdir="/WEB-INF/tags/page/front" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!--[if IE 8]>         <html class="ie8"> <![endif]-->
<!--[if IE 9]>         <html class="ie9 gt-ie8"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="gt-ie8 gt-ie9 not-ie"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>Sign Up - PixelAdmin</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">

	<!-- Pixel Admin's stylesheets -->
	<link href="${ctx}/assets/stylesheets/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/assets/stylesheets/pixel-admin.min.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/assets/stylesheets/pages.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/assets/stylesheets/rtl.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/assets/stylesheets/themes.css" rel="stylesheet" type="text/css">

	<!--[if lt IE 9]>
		<script src="${ctx}/assets/javascripts/ie.min.js"></script>
	<![endif]-->

</head>


<!-- 1. $BODY ======================================================================================
	
	Body

	Classes:
	* 'theme-{THEME NAME}'
	* 'right-to-left'     - Sets text direction to right-to-left
-->
<body class="theme-default page-signup-alt">

	<div class="signup-header">
		<a href="${ctx}/" class="logo">

			<strong>Nodcloud</strong>
		</a> <!-- / .logo -->
		<a href="${ctx}/login" class="btn btn-primary">登录</a>
	</div> <!-- / .header -->

	<h1 class="form-header">注册用户</h1>

	<!-- Form -->
	<form method="POST" id="signup-form_id" class="panel">
		<div class="form-group">
			<input type="text" name="fullname" id="name_id" class="form-control input-lg" placeholder="全称">
		</div>

		<div class="form-group">
			<input type="text" name="email" id="email_id" class="form-control input-lg" placeholder="电子邮箱地址">
		</div>

		<div class="form-group">
			<input type="text" name="username" id="username_id" class="form-control input-lg" placeholder="用户名">
		</div>

		<div class="form-group">
			<input type="password" name="password" id="password_id" class="form-control input-lg" placeholder="密码">
		</div>

		<div class="form-group" style="margin-top: 20px;margin-bottom: 20px;">
			<label class="checkbox-inline">
				<input type="checkbox" name="signup_confirm" class="px" id="confirm_id">
				<span class="lbl">我同意 <a href="#" target="_blank">用户协议</a></span>
			</label>
		</div>

		<div class="form-actions">
			<input type="submit" value="创建账户" class="btn btn-primary btn-lg btn-block">
		</div>
	</form>
	<!-- / Form -->

	<div class="signup-with">
		<div class="header">or sign up with</div>
		<a href="index.html" class="btn btn-lg btn-facebook rounded"><i class="fa fa-facebook"></i></a>&nbsp;&nbsp;
		<a href="index.html" class="btn btn-lg btn-info rounded"><i class="fa fa-twitter"></i></a>&nbsp;&nbsp;
		<a href="index.html" class="btn btn-lg btn-danger rounded"><i class="fa fa-google-plus"></i></a>
	</div>


    <!-- Get jQuery from Google CDN -->
    <!--[if !IE]> -->
    <script type="text/javascript" src="${ctx}/assets/javascripts/jquery-2.0.3.js"></script>
    <!-- <![endif]-->
    <!--[if lte IE 9]>
    <script type="text/javascript"> window.jQuery || document.write('<script src="http://lib.sinaapp.com/js/jquery/1.8.3/jquery.js">' + "<" + "/script>"); </script>
    <![endif]-->


<!-- Pixel Admin's javascripts -->
<script src="${ctx}/assets/javascripts/bootstrap.min.js"></script>
<script src="${ctx}/assets/javascripts/pixel-admin.min.js"></script>

<script type="text/javascript">
	window.PixelAdmin.start([
		function () {
			$("#signup-form_id").validate({ focusInvalid: true, errorPlacement: function () {} });

			// Validate name
			$("#name_id").rules("add", {
				required: true,
				minlength: 1
			});

			// Validate email
			$("#email_id").rules("add", {
				required: true,
				email: true
			});
			
			// Validate username
			$("#username_id").rules("add", {
				required: true,
				minlength: 3
			});

			// Validate password
			$("#password_id").rules("add", {
				required: true,
				minlength: 6
			});

			// Validate confirm checkbox
			$("#confirm_id").rules("add", {
				required: true
			});
		}
	]);
</script>

</body>
</html>
