<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar-collapse collapse">
    <ul class="nav navbar-nav navbar-right">
        <li><a href="index">主页</a></li>
        <li><a href="portfolio">其他</a></li>
        <li><a href="contact">联系我们</a></li>
        <li><a href="dashbord/">控制台</a></li>
        <c:if test="${user!=null}">
            <li><a href="#">${user.loginName}</a></li>
        </c:if>
    </ul>
</div>
<!--/.nav-collapse -->