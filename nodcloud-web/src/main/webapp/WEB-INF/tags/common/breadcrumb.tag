<%@tag pageEncoding="UTF-8" %>
<%@ tag import="org.nodcloud.web.common.page.model.BreadCrumb" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="breadcrumbs" type="org.nodcloud.web.common.page.model.BreadCrumbs" required="true" %>

<ul class="breadcrumb">
    <li>
        <p>Dashbord</p>
    </li>
    <%
        for (BreadCrumb breadCrumb : breadcrumbs.breadCrumbs) {
    %>
    <li><a href="<%=breadCrumb.getUrl()%>"><%=breadCrumb.getName()%>
    </a></li>
    <%
        }
    %>
</ul>