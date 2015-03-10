<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="main-menu" role="navigation" style="background-color: #23272d;">
    <div id="main-menu-inner">
        <div class="menu-content top" id="menu-content-demo">
            <!-- Menu custom content demo
                 CSS:        styles/pixel-admin-less/demo.less or styles/pixel-admin-scss/_demo.scss
                 Javascript: html/assets/demo/demo.js
             -->
            <div>
                <div class="text-bg"><span class="text-slim">欢迎,</span> <span class="text-semibold">John</span>
                </div>

                <img src="${ctx}/assets/images/avatar/4.jpg" alt="" class="">

                <div class="btn-group">
                    <a href="/messages" class="btn btn-xs btn-primary btn-outline dark"><i
                            class="fa fa-envelope"></i></a>
                    <a href="${ctx}/dashbord/profile" class="btn btn-xs btn-primary btn-outline dark"><i
                            class="fa fa-user"></i></a>
                    <a href="/seetings" class="btn btn-xs btn-primary btn-outline dark"><i class="fa fa-cog"></i></a>
                    <a href="/logout" class="btn btn-xs btn-danger btn-outline dark"><i class="fa fa-power-off"></i></a>
                </div>

            </div>
        </div>
        <jsp:include page="navigation.jsp"/>

    </div>
    <!-- / #main-menu-inner -->
</div>
<!-- / #main-menu -->