<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<page:content id="instance-page">

    <ul class="breadcrumb breadcrumb-page">
        <div class="breadcrumb-label text-light-gray">当前位置:</div>
        <li><a href="..">主页</a></li>
        <li><a href="../instances">主机</a></li>
        <li class="active"><a href="#">akz-123</a></li>
    </ul>

    <div class="row">
        <div class="col-md-4">
            <div class="stat-panel col-sm-4  no-border-r padding-sm-hr valign-top">
                <h4 class="padding-sm no-padding-t padding-xs-hr">
                    <i class="fa fa-align-center text-primary"></i>&nbsp;&nbsp;基本属性</h4>
                <ul class="list-group no-margin">
                    <li class="list-group-item no-border-hr padding-xs-hr">
                        ID <span class="label pull-right">${instance.id}</span>
                    </li>
                    <!-- / .list-group-item -->
                    <li class="list-group-item no-border-hr padding-xs-hr">
                        名称 <span class="label pull-right">${instance.name}</span>
                    </li>
                    <li class="list-group-item no-border-hr padding-xs-hr">
                        状态 <span class="label label-info pull-right">${instance.status}</span>
                    </li>
                    <!-- / .list-group-item -->
                    <li class="list-group-item no-border-hr no-border-b padding-xs-hr">
                        描述 <span class="label pull-right">${instance.descr}</span>
                    </li>
                    <!-- / .list-group-item -->
                    <li class="list-group-item no-border-hr no-border-b padding-xs-hr">
                        创建时间 <span class="label pull-right">${instance.createAt}</span>
                    </li>
                    <!-- / .list-group-item -->
                </ul>
            </div>

            <div class="stat-panel">
                <div class="stat-row">
                    <!-- Info background, small padding -->
                    <div class="stat-cell bg-info padding-sm">
                        <!-- Extra small text -->
                        <div class="text-xs" style="margin-bottom: 5px;">配置信息</div>
                        <div class="stats-sparklines" id="stats-sparklines-3" style="width: 100%"></div>
                    </div>
                </div>
                <!-- /.stat-row -->
                <div class="stat-row">
                    <div class="stat-counters bordered no-border-t text-center">
                            <%--<div class="stat-cell col-xs-4 padding-sm no-padding-hr">--%>
                            <%--<span class="text-bg"><strong>小型</strong></span><br>--%>
                            <%--<span class="text-xs">类型</span>--%>
                            <%--</div>--%>
                        <div class="stat-cell col-xs-4 padding-sm no-padding-hr">
                            <span class="text-bg"><strong>${instance.cup}核</strong></span><br>
                            <span class="text-xs">CPU</span>
                        </div>
                        <div class="stat-cell col-xs-4 padding-sm no-padding-hr">
                            <span class="text-bg"><strong>${instance.memory}MB</strong></span><br>
                            <span class="text-xs">内存</span>
                        </div>

                    </div>
                    <!-- /.stat-counters -->
                </div>
                <!-- /.stat-row -->
            </div>

            <div class="stat-panel col-sm-4  no-border-r padding-sm-hr valign-top">
                <h4 class="padding-sm no-padding-t padding-xs-hr">
                    <i class="fa fa-align-center text-primary"></i>&nbsp;&nbsp;绑定资源</h4>
                <ul class="list-group no-margin">
                    <li class="list-group-item no-border-hr padding-xs-hr">
                        <span>硬盘</span>
                        <c:forEach items="${instance.volumes}" var="volume">
                            <span class="label pull-right">${volume.uuid} </span>
                        </c:forEach>

                    </li>
                    <!-- / .list-group-item -->
                    <li class="list-group-item no-border-hr padding-xs-hr">
                        <span>网络</span>

                        <c:forEach items="${instance.vxnets}" var="vxnet">
                            <span class="label pull-right"> ${vxnet.uuid}</span>
                        </c:forEach>


                    </li>
                    <!-- / .list-group-item -->
                    <li class="list-group-item no-border-hr no-border-b padding-xs-hr">
                        <span>公网IP</span>
                        <span class="label pull-right">${instance.eip.address}</span>
                    </li>
                    <!-- / .list-group-item -->
                    <li class="list-group-item no-border-hr no-border-b padding-xs-hr">
                        <span>SSH秘钥</span>
                        <c:forEach items="${instance.keyPairs}" var="keyPair">
                            <span class="label pull-right">${keyPair.uuid}</span>
                        </c:forEach>
                    </li>
                    <!-- / .list-group-item -->
                </ul>
            </div>
        </div>

        <div class="col-md-8">
            <ul class="nav nav-tabs nav-tabs-simple nav-tabs-xs">
                <li class="">
                    <a href="#instance_details_monitor" data-toggle="tab">监控</a>
                </li>
                <li class="active">
                    <a href="#instance_details_snapshot" data-toggle="tab">备份</a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane " id="instance_details_monitor">
                    监控
                </div>
                <div class="tab-pane active" id="instance_details_snapshot">
                    <a href="#" class="btn btn-primary btn-labeled"><span
                            class="btn-label icon fa fa-plus"></span>创建备份</a>
                </div>
            </div>

        </div>

    </div>
</page:content>
</body>
</html>