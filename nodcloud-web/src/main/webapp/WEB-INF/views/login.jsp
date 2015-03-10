<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <meta charset="utf-8"/>
    <title>NodCloud - Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- BEGIN CORE CSS FRAMEWORK -->
    <link href="${ctx}/assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="${ctx}/assets/plugins/boostrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/assets/plugins/boostrapv3/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/assets/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/assets/stylesheets/front/animate.min.css" rel="stylesheet" type="text/css"/>
    <!-- END CORE CSS FRAMEWORK -->
    <!-- BEGIN CSS TEMPLATE -->
    <link href="${ctx}/assets/stylesheets/front/login.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/assets/stylesheets/front/responsive.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/assets/stylesheets/front/custom-icon-set.css" rel="stylesheet" type="text/css"/>
    <!-- END CSS TEMPLATE -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="error-body no-top">
<div class="container">
    <div class="row login-container column-seperation">
        <div class="col-md-5 col-md-offset-1">
            <h2>登录到Nodcloud</h2>

            <p>使用微博或Github账号进行登录<br>
                <a href="${ctx}/register">免费注册!</a> 成为Nodcloud的注册会员</p>
            <br>

            <a href="${ctx}/oauth2-login" class="btn btn-block btn-info col-md-8" type="button">
                <span class="pull-left"><i class="icon-facebook"></i></span>
                <span class="bold">Login with Github</span></a>
            <button disabled class="btn btn-block btn-success col-md-8" type="button">
                <span class="pull-left"><i class="icon-twitter"></i></span>
                <span class="bold">Login with Weibo</span>
            </button>
        </div>
        <div class="col-md-5 "><br>

            <form id="login-form" class="login-form" action="${ctx}/login" method="post">
                <div class="row">
                    <div class="form-group col-md-10">
                        <%
                            String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
                            if (error != null) {
                        %>
                        <div class="alert alert-error controls input-large">
                            <%
                                if (error.contains("DisabledAccountException")) {
                                    out.print("用户已被屏蔽,请登录其他用户.");
                                } else {
                                    out.print("登录失败，请重试.");
                                }
                            %>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-10">
                        <label class="form-label">用户名</label>

                        <div class="controls">
                            <div class="input-with-icon  right">
                                <i class=""></i>
                                <input type="text" name="username" value="${username}" id="txtusername"
                                       class="form-control">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-10">
                        <label class="form-label">密码</label>
                        <span class="help"></span>

                        <div class="controls">
                            <div class="input-with-icon  right">
                                <i class=""></i>
                                <input type="password" name="password" id="txtpassword" class="form-control">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="control-group  col-md-10">
                        <div class="checkbox checkbox check-success"><a href="#">登录出现问题?</a>&nbsp;&nbsp;
                            <input type="checkbox" id="checkbox1" name="rememberMe" value="1">
                            <label for="checkbox1">记住我 </label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-10">
                        <button class="btn btn-primary btn-cons pull-right" type="submit">登录</button>
                    </div>
                </div>
            </form>
        </div>


    </div>
</div>
<!-- END CONTAINER -->
<!-- BEGIN CORE JS FRAMEWORK-->
<script src="${ctx}/assets/plugins/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/pace/pace.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/javascripts/login.js" type="text/javascript"></script>
<!-- BEGIN CORE TEMPLATE JS -->
<!-- END CORE TEMPLATE JS -->
</body>
</html>