<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../taglibs.jsp" %>
<html>
<head>
    <title>备份-Nodcloud Dashbord</title>
</head>
<body>

<page:content id="snapshot-page">
    <page-header:snapshot/>
    <page:panel>
        <%--<page:panel-head title="快照"/>--%>
        <page:panel-table-body>
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
                    <th class="sorting_disabled" role="columnheader" rowspan="1" colspan="1"
                        style="width: 194px;">编号
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="example3"
                        rowspan="1"
                        colspan="1"
                        style="width: 236px;">状态
                    </th>
                    <th role="columnheader" tabindex="0" aria-controls="example3"
                        rowspan="1" colspan="1" aria-sort="descending"
                        aria-label="Engine version: activate to sort column ascending"
                        style="width: 166px;">
                        镜像
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" rowspan="1"
                        colspan="1"
                        style="width: 117px;">IP地址
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" rowspan="1"
                        colspan="1"
                        style="width: 80px;">类型
                    </th>
                    <th class="sorting" role="columnheader" tabindex="0" rowspan="1"
                        colspan="1"
                        style="width: 257px;">创建时间
                    </th>

                </tr>
                </thead>

                <tbody role="alert" aria-live="polite" aria-relevant="all">
                </tbody>
            </table>
        </page:panel-table-body>
    </page:panel>
</page:content>

</body>
</html>

