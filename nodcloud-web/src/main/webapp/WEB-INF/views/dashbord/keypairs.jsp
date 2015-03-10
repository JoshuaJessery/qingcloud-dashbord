<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../taglibs.jsp" %>

<html>
<head>
    <title>秘钥-Nodcloud Dashbord</title>
    <script type="text/javascript" src="${ctx}/assets/javascripts/app/keypair.js"></script>
</head>
<body>

<page:content id="snapshot-page">
    <page-header:keypair/>
    <page:panel>
        <%--<page:panel-head title="秘钥"/>--%>
        <page:panel-table-body>
            <form id="keyPairForm" method="POST">

                <table-menus:keypairs-menus/>

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
                        <th class="sorting_disabled" role="columnheader" rowspan="1" colspan="1" style="width: 194px;">
                            编号
                        </th>
                        <th>名称</th>
                        <th>加密方法</th>
                        <th>创建时间</th>
                        <th>下载私钥</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${keyPairs.content}" var="keypair">
                        <tr class="gradeA odd">
                            <td>
                                <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
                                    <input type="checkbox" name="id" class="check-item" value="${keypair.id}"
                                           id="toggle-${keypair.id}">
                                    <label for="toggle-${keypair.id}"></label>
                                </div>
                            </td>
                            <td>${keypair.uuid}</td>
                            <td>${keypair.name}</td>
                            <td>${keypair.encryptMethod}</td>
                            <td>${keypair.createAt}</td>
                            <td><a href="${ctx}/dashbord/keypairs/download/${keypair.id}">下载</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <tags:pagination page="${keyPairs}" paginationSize="5"/>
            </form>
        </page:panel-table-body>
    </page:panel>
</page:content>

<models:createkeypair/>

</body>
</html>

