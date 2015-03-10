<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../taglibs.jsp"%>
<html>
<head>
    <title>Instance-Nodcloud Dashbord</title>
    <script type="text/javascript" src="${ctx}/assets/javascripts/app/instances.js"></script>
</head>
<body>
<page:content id="instances-page">
    <page-header:instance/>
    <page:panel>
        <%--<page:panel-head title="主机"/>--%>
        <page:panel-table-body>
            <form id="instanceForm" method="POST">
                <table-menus:instance-menus/>
                <table id="dataTableInstance" class="table table-striped table-bordered dataTable no-footer">
                    <thead>
                    <tr role="row">
                        <th style="width:1%" class="sorting_disabled" role="columnheader" rowspan="1"
                            colspan="1">
                            <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
                                <input type="checkbox" value="" class="checkall" id="toggle-all">
                                <label for="toggle-all"></label>
                            </div>
                        </th>
                        <th class="sorting_disabled" role="columnheader" rowspan="1" colspan="1"
                            style="width: 120px">编号
                        </th>
                        <th class="sorting" role="columnheader" tabindex="0" aria-controls="example3"
                            rowspan="1"
                            colspan="1"
                            style="width: 236px;">名称
                        </th>
                        <th class="" role="columnheader" tabindex="0" aria-controls="example3"
                            rowspan="1" colspan="1" aria-sort="descending"
                            aria-label="Engine version: activate to sort column ascending"
                            style="width: 330px;">
                            镜像
                        </th>
                        <th class="" role="columnheader" tabindex="0" style="width:150px">
                            IP地址
                        </th>
                        <th class="" role="columnheader" tabindex="0" style="width: 100px">
                            秘钥
                        </th>
                        <th class="sorting" role="columnheader" tabindex="0" rowspan="1"
                            colspan="1"
                            style="width: 117px;">配置
                        </th>
                        <th class="" role="columnheader" tabindex="0" style="width: 100px">
                            状态
                        </th>

                        <th class="sorting" role="columnheader" tabindex="0" rowspan="1"
                            colspan="1"
                            style="width: 257px;">创建时间
                        </th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${instances.content}" var="instance">
                        <tr id="${instance.id}" class="gradeA odd" data-target="#modifyInstanceModel">
                            <c:choose>
                            <c:when test="${instance.status == 'running'}">
                            <td class="instance-running">
                                </c:when>
                                <c:otherwise>
                            <td class="instance-disable">
                                </c:otherwise>
                                </c:choose>
                                <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
                                    <input type="checkbox" name="id" class="check-item" value="${instance.id}"
                                           id="toggle-${instance.id}">
                                    <label for="toggle-${instance.id}"></label>
                                </div>
                            </td>
                            <td class=" " name="instance-uuid"><a
                                    href="${ctx}/dashbord/instance/${instance.id}">${instance.uuid}</a>
                                <input type="hidden" name="descr" value="${instance.descr}">
                            </td>
                            <td class=" " name="instance-name">${instance.name}
                            </td>
                            <td class="center">${instance.image.name}</td>
                            <td>
                                    ${instance.eip.address}
                            </td>
                            <td>
                                <c:forEach items="${instance.keyPairs}" var="keypair">
                                    <span>${keypair.uuid}</span>
                                </c:forEach>
                            </td>
                            <td class="center">
                                <span>CPU:</span>${instance.cup},<span>内存:</span>${instance.memory}
                            </td>
                            <td>
                                <span class="instance-status">${instance.status}</span>
                            </td>
                            <td class="center">${instance.createAt}
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
            <tags:pagination page="${instances}" paginationSize="5"/>
        </page:panel-table-body>

    </page:panel>
</page:content>

<!-- Modal -->
<models:resetinstance/>
<models:createinstance images="${publicImages}"/>
<models:resizeinstance/>
<models:modify/>
</body>
</html>

