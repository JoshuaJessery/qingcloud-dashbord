<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- 2. $MAIN_NAVIGATION ===========================================================================
Main navigation
-->
<div id="main-navbar" class="navbar navbar-inverse" role="navigation">
    <!-- Main menu toggle -->
    <button type="button" id="main-menu-toggle"><i class="navbar-icon fa fa-bars icon"></i><span class="hide-menu-text">HIDE MENU</span>
    </button>

    <div class="navbar-inner">
        <!-- Main navbar header -->
        <div class="navbar-header">

            <!-- Logo -->
            <a href="${ctx}/dashbord/" class="navbar-brand">
                <div><img alt="Nodlcoud" src="${ctx}/assets/img/nodcloud-logo.png"></div>
            </a>
            <!-- Main navbar toggle -->
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#main-navbar-collapse"><i class="navbar-icon fa fa-bars"></i></button>
        </div>
        <!-- / .navbar-header -->

        <div id="main-navbar-collapse" class="collapse navbar-collapse main-navbar-collapse">
            <div>
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">产品</a>
                        <ul class="dropdown-menu">
                            <li><a href="#">计算与网络</a></li>
                            <li><a href="#">存储与CDN</a></li>
                            <li class="divider"></li>
                            <li><a href="#">数据库</a></li>
                            <li><a href="#">监控</a></li>
                            <li><a href="#">移动服务</a></li>
                        </ul>
                    </li>
                </ul>
                <!-- / .navbar-nav -->

                <div class="right clearfix">
                    <ul class="nav navbar-nav pull-right right-navbar-nav">

                        <!-- 3. $NAVBAR_ICON_BUTTONS =======================================================================

                                                    Navbar Icon Buttons

                                                    NOTE: .nav-icon-btn triggers a dropdown menu on desktop screens only. On small screens .nav-icon-btn acts like a hyperlink.

                                                    Classes:
                                                    * 'nav-icon-btn-info'
                                                    * 'nav-icon-btn-success'
                                                    * 'nav-icon-btn-warning'
                                                    * 'nav-icon-btn-danger'
                        -->
                        <li class="dropdown">
                            <a href="#" id="current_zone" class="dropdown-toggle" data-toggle="dropdown">当前节点:<c:out
                                    value="${ sessionScope.current_zone}"/></a>
                            <ul class="dropdown-menu availiable_zones_list">

                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">客服</a>
                            <ul class="dropdown-menu">
                                <li><a href="#">工单</a></li>
                                <li><a href="#">备案</a></li>
                                <li class="divider"></li>
                                <li><a href="#">文档</a></li>
                                <li><a href="#">其他资源</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle user-menu" data-toggle="dropdown">
                                <img src="${ctx}/assets/images/avatar/4.jpg" alt="">
                                <span>INodcloud</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#"><span class="label label-warning pull-right">New</span>我的账户</a></li>
                                <li><a href="#"><span class="badge badge-primary pull-right">New</span>账单及付款</a></li>
                                <li><a href="#"><i class="dropdown-icon fa fa-cog"></i>设置</a></li>
                                <li class="divider"></li>
                                <li><a href="${ctx}/logout"><i class="dropdown-icon fa fa-power-off"></i>&nbsp;&nbsp;
                                    退出</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- / .navbar-nav -->
                </div>
                <!-- / .right -->
            </div>
        </div>
        <!-- / #main-navbar-collapse -->
    </div>
    <!-- / .navbar-inner -->
</div>
<!-- / #main-navbar -->