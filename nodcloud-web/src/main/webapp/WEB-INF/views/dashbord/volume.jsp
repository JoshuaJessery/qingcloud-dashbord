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
        <li><a href="#">主页</a></li>
        <li><a href="#">存储卷</li>
        <li class="active"><a href="#">akz-123</a></li>
    </ul>

    <div class="row">

        <div class="col-md-4">

            <div class="stat-panel col-sm-4  no-border-r padding-sm-hr valign-top">
                <h4 class="padding-sm no-padding-t padding-xs-hr">
                    <i class="fa fa-align-center text-primary"></i>&nbsp;&nbsp;基本属性</h4>
                <ul class="list-group no-margin">
                    <li class="list-group-item no-border-hr padding-xs-hr">
                        ID <span class="label pull-right">34</span>
                    </li>
                    <!-- / .list-group-item -->
                    <li class="list-group-item no-border-hr padding-xs-hr">
                        名称 <span class="label pull-right">128</span>
                    </li>
                    <li class="list-group-item no-border-hr padding-xs-hr">
                        状态
                    </li>
                    <!-- / .list-group-item -->
                    <li class="list-group-item no-border-hr no-border-b padding-xs-hr">
                        描述 <span class="label pull-right">12</span>
                    </li>
                    <li class="list-group-item no-border-hr padding-xs-hr">
                        容量
                    </li>
                    <li class="list-group-item no-border-hr padding-xs-hr">
                        类型
                    </li>
                    <!-- / .list-group-item -->
                    <li class="list-group-item no-border-hr no-border-b padding-xs-hr">
                        创建时间 <span class="label pull-right">12</span>
                    </li>
                    <!-- / .list-group-item -->
                </ul>
            </div>

        </div>

        <div class="col-md-8">
            <ul class="nav nav-tabs nav-tabs-simple nav-tabs-xs">
                <li class="active">
                    <a href="#volume_details_snapshot" data-toggle="tab">备份</a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="volume_details_snapshot">
                    <a href="#" class="btn btn-primary btn-labeled"><span
                            class="btn-label icon fa fa-plus"></span>创建备份</a>
                </div>
            </div>

        </div>

    </div>
</page:content>
</body>
</html>