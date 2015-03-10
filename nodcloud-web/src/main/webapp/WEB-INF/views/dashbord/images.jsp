<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../taglibs.jsp" %>
<html>
<head>
    <title>Instance-Nodcloud Dashbord</title>
    <script type="text/javascript" src="${ctx}/assets/js/app/volumes.js"></script>
</head>
<body>

<page:content id="image-page">
    <page-header:image/>
    <page:panel>
        <%--<page:panel-head title="镜像"/>--%>
        <page:panel-table-body>

            <ul class="nav nav-pills bs-tabdrop-example">
                <li class="active"><a href="#bs-tagdrop-publicimage" data-toggle="tab">系统</a></li>
                <li class=""><a href="#bs-tagdrop-privateimage" data-toggle="tab">自有</a></li>
            </ul>

            <div class="tab-content">
                <div class="tab-pane active" id="bs-tagdrop-publicimage">
                    <div class="dataTables_wrapper form-inline" role="grid">
                        <table class="table table-striped table-bordered dataTable no-footer">
                            <thead>
                            <tr role="row">
                                <th class="sorting_disabled" role="columnheader" rowspan="1" colspan="1
                                    ">ID
                                </th>
                                <th class="sorting" role="columnheader" tabindex="0"
                                    rowspan="1"
                                    colspan="1"
                                        >名称
                                </th>
                                <th class="sorting" role="columnheader" tabindex="0"
                                    rowspan="1"
                                    colspan="1"
                                        >状态
                                </th>
                                <th class="sorting" role="columnheader" tabindex="0" rowspan="1"
                                    colspan="1"
                                        >创建时间
                                </th>

                            </tr>
                            </thead>

                            <tbody role="alert" aria-live="polite" aria-relevant="all">
                            <c:forEach items="${systemImages.content}" var="image">
                                <tr class="gradeA odd">

                                    <td class=" ">
                                            ${image.uuid}
                                    </td>
                                    <td class=" ">
                                            ${image.name}
                                    </td>
                                    <td>
                                            ${image.status}
                                    </td>
                                    <td class="center">${image.createAt}
                                    </td>

                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                        <tags:pagination page="${systemImages}" paginationSize="5"/>
                    </div>
                </div>
                <div class="tab-pane" id="bs-tagdrop-privateimage">
                    <div class="dataTables_wrapper form-inline" role="grid">
                        <table-menus:private-images-menus/>

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
                                <th class="sorting_disabled" role="columnheader" rowspan="1" colspan="1
                                    ">ID
                                </th>
                                <th class="sorting" role="columnheader" tabindex="0"
                                    rowspan="1"
                                    colspan="1"
                                        >名称
                                </th>
                                <th class="sorting" role="columnheader" tabindex="0"
                                    rowspan="1"
                                    colspan="1"
                                        >状态
                                </th>
                                <th class="sorting" role="columnheader" tabindex="0" rowspan="1"
                                    colspan="1"
                                        >创建时间
                                </th>
                            </tr>
                            </thead>

                            <tbody role="alert" aria-live="polite" aria-relevant="all">
                            <c:forEach items="${userImages.content}" var="image">
                                <tr class="gradeA odd">
                                    <td class=" ">
                                        <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
                                            <input type="checkbox" value="1" id="toggle-${image.id}">
                                            <label for="toggle-${image.id}"></label>
                                        </div>
                                    </td>
                                    <td class=" ">
                                            ${image.uuid}
                                    </td>
                                    <td class=" ">
                                            ${image.name}
                                    </td>
                                    <td>
                                            ${image.description}
                                    </td>
                                    <td class="center">${image.createAt}
                                    </td>

                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                        <tags:pagination page="${userImages}" paginationSize="5"/>
                    </div>
                </div>
            </div>

        </page:panel-table-body>

    </page:panel>

</page:content>


</body>
