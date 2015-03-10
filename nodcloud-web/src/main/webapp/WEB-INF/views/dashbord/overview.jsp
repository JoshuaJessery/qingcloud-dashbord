<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../taglibs.jsp"%>
<html>
<head>
    <title>Instance-Nodcloud Dashbord</title>
    <script type="text/javascript" src="${ctx}/assets/javascripts/app/overview.js"></script>
</head>
<body>
<ul class="breadcrumb breadcrumb-page">
    <div class="breadcrumb-label text-light-gray">当前位置:</div>
    <li><a href="#">主页</a></li>
    <li class="active"><a href="#">控制台</a></li>
</ul>
<div class="page-header">
    <div class="row">
        <!-- Page header, center on small screens -->
        <h1 class="col-xs-12 col-sm-4 text-center text-left-sm">
            <i class="fa fa-dashboard page-header-icon"></i>&nbsp;&nbsp;控制台&nbsp;&nbsp;<c:out
                value="${sessionScope.current_zone}"/>
        </h1>
    </div>
</div>
<div class="content" id="page-overview">
    <div class="row">
        <div class="col-md-4">
            <a href="${ctx}/dashbord/instances"><overview:grid-instances-chart/></a>
        </div>
        <div class="col-md-4">
            <a href="${ctx}/dashbord/volumes"><overview:grid-volumes-chart/></a>
        </div>
        <div class="col-md-4">
            <a href="${ctx}/dashbord/images"> <overview:grid-images-chart/></a>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4">
            <a href="${ctx}/dashbord/snapshots"> <overview:grid-snapshot-chart/></a>
        </div>
        <div class="col-md-4">
            <a href="${ctx}/dashbord/eips"> <overview:grid-eip-chart/></a>
        </div>
        <div class="col-md-4">
            <a href="${ctx}/dashbord/networks"> <overview:grid-network-chart/></a>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4">
            <overview:grid-load-balance-chart/>
        </div>
        <div class="col-md-4">
            <overview:grid-security-group-chart/>
        </div>
        <div class="col-md-4">
            <a href="${ctx}/dashbord/keypairs"><overview:grid-key-pair-chart/></a>
        </div>
    </div>

    <hr/>

    <div class="row">

        <div class="col-md-6">
            <div class="panel widget-support-tickets">
                <div class="panel-heading">
                    <span class="panel-title"><i class="panel-title-icon fa fa-bullhorn"></i>最近操作</span>
                </div>
                <div class="panel-body tab-content-padding">
                    <div class="panel-padding no-padding-vr">

                        <c:forEach items="${logs}" var="log">

                            <div class="ticket">
                                <span class="label label-${log.status} ticket-label">${log.status}</span>
                                <a href="#" title="" class="ticket-title"><span>[#${log.id}]</span>${log.message}</a>
								<span class="ticket-info">
                                        ${log.createAt}
								</span>
                            </div>

                        </c:forEach>

                    </div>
                </div> <!-- / .panel-body -->
            </div> <!-- / .panel -->
        </div>

    </div>

</div>
</body>
</html>

