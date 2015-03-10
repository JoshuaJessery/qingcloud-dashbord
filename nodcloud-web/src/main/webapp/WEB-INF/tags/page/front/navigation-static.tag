<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="front" tagdir="/WEB-INF/tags/page/front" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div role="navigation" class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="compressed">
            <div class="navbar-header">
                <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand compressed">
                    <img src="${ctx}/assets/img/logo_condensed.png" alt=""
                         data-src="assets/img/logo_condensed.png"
                         data-src-retina="assets/img/logo2x.png" width="119"
                         height="22"/></a>
            </div>
            <front:navigation-menu/>
        </div>
    </div>
</div>