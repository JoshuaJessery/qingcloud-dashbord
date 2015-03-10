<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="front" tagdir="/WEB-INF/tags/page/front" %>
<%@attribute name="css" type="java.lang.String" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div role="navigation" class="navbar navbar-transparent navbar-top">
    <div class="container">
        <div class="compressed">
            <div class="navbar-header">
                <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand">
                    <img src="${ctx}/assets/img/logo.png"
                         data-src="${ctx}/assets/img/logo.png"
                         data-src-retina="${ctx}/assets/img/logo_2x.png" width="119"
                         height="22" alt=""/>
                </a>
            </div>
            <front:navigation-menu/>
        </div>
    </div>
</div>