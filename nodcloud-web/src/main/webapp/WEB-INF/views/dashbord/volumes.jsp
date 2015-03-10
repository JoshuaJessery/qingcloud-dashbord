<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../taglibs.jsp" %>

<html>
<head>
    <title>硬盘-Nodcloud Dashbord</title>
    <script type="text/javascript" src="${ctx}/assets/javascripts/app/volumes.js"></script>
</head>
<body>
<page:content id="volume-page">
    <page-header:volume/>
    <page:panel>
        <%--<page:panel-head title="硬盘"/>--%>
        <page:panel-table-body>
            <form id="volumeForm" method="post">
                <table-menus:volume-menus/>
                <table id="" class="table table-striped table-bordered dataTable no-footer">
                    <thead>
                    <tr role="row">
                        <th style="width:1%" class="sorting_disabled" role="columnheader" rowspan="1"
                            colspan="1">
                            <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
                                <input type="checkbox" class="checkall" id="toggle-all">
                                <label for="toggle-all"></label>
                            </div>
                        </th>
                        <th class="sorting_disabled" role="columnheader" rowspan="1" colspan="1"
                            style="width: 194px;">编号
                        </th>
                        <th class="sorting" role="columnheader" tabindex="0" aria-controls="example3"
                            rowspan="1"
                            colspan="1"
                            style="min-width: 100px;">名称
                        </th>
                        <th class="sorting" role="columnheader" tabindex="0" aria-controls="example3"
                            rowspan="1"
                            colspan="1"
                            style="width: 100px;">状态
                        </th>
                        <th style="min-width: 100px">
                            主机
                        </th>
                        <th role="columnheader" tabindex="0" aria-controls="example3"
                            rowspan="1" colspan="1" aria-sort="descending"
                            aria-label="Engine version: activate to sort column ascending" style="width: 50px;">
                            容量
                        </th>
                        <th class="sorting" role="columnheader" tabindex="0" aria-controls="example3"
                            rowspan="1"
                            colspan="1" aria-label="CSS grade: activate to sort column ascending"
                            style="width: 120px;">类型
                        </th>
                        <th class="sorting" role="columnheader" tabindex="0" rowspan="1"
                            colspan="1"
                            style="width: 200px;">创建时间
                        </th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody role="alert" aria-live="polite" aria-relevant="all">
                    <c:forEach items="${volumes.content}" var="volume">
                        <tr class="gradeA odd">
                            <td class=" ">
                                <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
                                    <input type="checkbox" name="id" class="check-item" value="${volume.id}">
                                </div>
                            </td>
                            <td class=" ">
                                <a href="${ctx}/dashbord/volume/${volume.id}">${volume.uuid}</a>
                            </td>
                            <td class=" ">
                                ${volume.name}
                            </td>
                            <td class=" ">
                                ${volume.status}
                            </td>
                            <td class="center">
                            </td>
                            <td class="center ">
                                ${volume.size}
                            </td>
                            <td>
                                -
                            </td>
                            <td class="center">${volume.createAt}
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
            <tags:pagination page="${volumes}" paginationSize="5"/>
        </page:panel-table-body>
    </page:panel>
</page:content>

<!-- import other medals -->
<models:createvolume/>
<models:attachvolume instances="${instances}"/>

</body>
