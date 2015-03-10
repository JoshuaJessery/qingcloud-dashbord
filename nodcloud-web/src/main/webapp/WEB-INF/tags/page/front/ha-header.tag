<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<header id="ha-header" class="ha-header ha-header-hide ">
    <div class="ha-header-perspective">
        <div class="ha-header-front navbar navbar-default">

            <div class="compressed">
                <div class="navbar-header">
                    <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="#" class="navbar-brand compressed"><img src="${ctx}/assets/img/logo_condensed.png" alt=""
                                                                     data-src="${ctx}/assets/img/logo_condensed.png"
                                                                     data-src-retina="${ctx}/assets/img/logo2x.png"
                                                                     width="119"
                                                                     height="22"/></a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index">主页</a></li>
                        <li><a href="portfolio">其他</a></li>
                        <li><a href="contact">联系我们</a></li>
                        <li><a href="${ctx}/dashbord/">控制台</a></li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>

        </div>
    </div>
</header>