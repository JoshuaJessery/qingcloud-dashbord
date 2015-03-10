<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../taglibs.jsp" %>
<html>
<head>
    <title>网络-Nodcloud Dashbord</title>
</head>
<body>

<page:content id="network-page">
    <page-header:network/>
    <page:panel>
        <%--<page:panel-head title="网络"/>--%>
        <page:panel-table-body>

            <ul class="nav nav-pills bs-tabdrop-example">
                <li class="active"><a href="#tab-content-route" data-toggle="tab">路由器</a></li>
                <li class=""><a href="#tab-content-network" data-toggle="tab">私有网络</a></li>
            </ul>

            <div class="tab-content">
                <div class="tab-pane active" id="tab-content-route">
                    <table class="table table-striped table-bordered dataTable no-footer">
                        <thead>
                        <tr role="row">
                            <th style="width:1%" class="sorting_disabled" role="columnheader" rowspan="1"
                                colspan="1">
                                <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
                                    <input type="checkbox" value="1" class="checkall" id="toggle-all">
                                    <label for="toggle-all"></label>
                                </div>
                            </th>
                            <th>编号
                            </th>
                            <th class="sorting">状态</th>
                            <th class="">镜像</th>
                            <th class="sorting">IP地址
                            </th>
                            <th class="sorting">类型
                            </th>
                            <th class="sorting">创建时间
                            </th>

                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane" id="tab-content-network">
                    <table class="table table-striped table-bordered dataTable no-footer">
                        <thead>
                        <tr role="row">
                            <th style="width:1%" class="sorting_disabled" role="columnheader" rowspan="1"
                                colspan="1">
                                <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
                                    <input type="checkbox" value="1" class="checkall" id="toggle-all">
                                    <label for="toggle-all"></label>
                                </div>
                            </th>
                            <th>编号
                            </th>
                            <th class="sorting">状态</th>
                            <th class="">镜像</th>
                            <th class="sorting">IP地址
                            </th>
                            <th class="sorting">类型
                            </th>
                            <th class="sorting">创建时间
                            </th>

                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>

        </page:panel-table-body>

    </page:panel>

</page:content>

</body>
</html>

