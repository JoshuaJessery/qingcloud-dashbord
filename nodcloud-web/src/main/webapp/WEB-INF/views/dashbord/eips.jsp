<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../taglibs.jsp" %>
<html>
<head>
    <title>公网IP-Nodcloud Dashbord</title>
    <script type="text/javascript" src="${ctx}/assets/javascripts/app/eips.js"></script>
</head>
<body>

<page:content id="eip-page">
    <page-header:eip/>
    <page:panel>
        <%--<page:panel-head title="网络"/>--%>
        <page:panel-table-body>
            <form id="eipForm" method="POST">
                <table-menus:eip-menus/>
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
                        <th role="columnheader" rowspan="1" colspan="1"
                            style="width: 194px;">ID
                        </th>
                        <th role="columnheader" tabindex="0" aria-controls="example3" rowspan="1"
                            colspan="1"
                            style="width: 251px;">名称
                        </th>
                        <th role="columnheader" tabindex="0" aria-controls="example3" rowspan="1"
                            colspan="1"
                            style="width: 236px;">地址
                        </th>
                        <th role="columnheader" tabindex="0" aria-controls="example3"
                            rowspan="1" colspan="1" aria-sort="descending"
                            aria-label="Engine version: activate to sort column ascending" style="width: 166px;">
                            状态
                        </th>
                        <th role="columnheader" tabindex="0" aria-controls="example3" rowspan="1"
                            colspan="1" aria-label="CSS grade: activate to sort column ascending"
                            style="width: 117px;">带宽
                        </th>
                        <th role="columnheader" tabindex="0" rowspan="1"
                            colspan="1"
                            style="width: 257px;">创建于
                        </th>

                    </tr>
                    </thead>

                    <tbody role="alert" aria-live="polite" aria-relevant="all">
                    <c:forEach items="${eips.content}" var="eip">
                        <tr id="${instance.id}" class="gradeA odd">
                            <td class=" ">
                                <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
                                    <input type="checkbox" name="id" class="check-item" value="${eip.id}"
                                           id="toggle-${eip.id}">
                                    <label for="toggle-${eip.id}"></label>
                                </div>
                            </td>
                            <td class=" ">${eip.uuid}
                            </td>

                            <td class=" ">${eip.name}
                            </td>

                            <td class="center">
                                    ${eip.address}
                            </td>
                            <td>
                                    ${eip.status}
                            </td>
                            <td>
                                    ${eip.bandwidth}
                            </td>

                            <td class="center">${eip.createAt}
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </page:panel-table-body>
    </page:panel>
</page:content>

<models:applyip/>
<models:associateeip/>

</body>



