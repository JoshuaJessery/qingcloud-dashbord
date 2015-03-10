<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<ul class="navigation">
    <li class="dropdown" id="navigation-zones">
        <a class="dropdown-toggle" data-toggle="dropdown">
            <i class="menu-icon fa fa-map-marker"></i>
            <span id="currentZone" class="mm-text"></span>
            <i class="fa fa-angle-down"></i>
        </a>
        <ul class="dropdown-menu availiable_zones_list">
        </ul>
    </li>
    <li>
        <a href="${ctx}/dashbord/overview">
            <i class="menu-icon fa fa-dashboard"></i>
            <span class="mm-text">控制台</span>
        </a>
    </li>

    <li>
        <a href="${ctx}/dashbord/instances">
            <i class="menu-icon fa fa-tasks"></i>
            <span class="mm-text">主机</span></a>
    </li>
    <li>
        <a href="${ctx}/dashbord/volumes">
            <i class="menu-icon fa fa-flask"></i>
            <span class="mm-text">硬盘</span>
        </a>
    </li>
    <li>
        <a href="${ctx}/dashbord/snapshots">
            <i class="menu-icon fa fa-desktop"></i>
            <span class="mm-text">备份</span>
        </a>
    </li>
    <li>
        <a href="${ctx}/dashbord/networks">
            <i class="menu-icon fa fa-check-square"></i>
            <span class="mm-text">网络</span>
        </a>
    </li>
    <li>
        <a href="${ctx}/dashbord/eips">
            <i class="menu-icon fa fa-table"></i>
            <span class="mm-text">公网IP</span>
        </a>
    </li>
    <%--<li>--%>
        <%--<a href="#">--%>
            <%--<i class="menu-icon fa fa-bar-chart-o"></i>--%>
            <%--<span class="mm-text">负载均衡器</span>--%>
        <%--</a>--%>
    <%--</li>--%>
    <%--<li>--%>
        <%--<a href="#">--%>
            <%--<i class="menu-icon fa fa-files-o"></i>--%>
            <%--<span class="mm-text">防火墙</span>--%>
            <%--<span class="label label-success">16</span></a>--%>
    <%--</li>--%>
    <li>
        <a href="${ctx}/dashbord/keypairs">
            <i class="menu-icon fa fa-briefcase"></i>
            <span class="mm-text">SSH秘钥</span>
        </a>
    </li>
    <li>
        <a href="${ctx}/dashbord/images">
            <i class="menu-icon fa fa-tint"></i>
            <span class="mm-text">映像</span>
        </a>
    </li>
    <%--<li>--%>
        <%--<a href="#">--%>
            <%--<i class="menu-icon fa fa-sitemap"></i>--%>
            <%--<span class="mm-text">操作日志</span>--%>
            <%--<span class="badge badge-primary">6</span></a>--%>
    <%--</li>--%>
    <%--<li>--%>
        <%--<a href="#">--%>
            <%--<i class="menu-icon fa fa-sitemap"></i>--%>
            <%--<span class="mm-text">子账户</span>--%>
            <%--<span class="badge badge-primary">6</span></a>--%>
    <%--</li>--%>
</ul>

<!-- / .navigation

<div class="menu-content">
<a href="${ctx}/pages-invoice.html" class="btn btn-primary btn-block btn-outline dark">Create
Invoice</a>
</div>
-->