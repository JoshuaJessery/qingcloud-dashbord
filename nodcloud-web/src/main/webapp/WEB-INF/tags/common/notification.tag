<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="message" type="org.nodcloud.commons.model.notifaction.AbstratcNotifactionMessage" required="false" %>
<c:if test="${! empty message}">
    <c:if test="${message.info}">
        <div class="alert alert-info">
            <button type="button" class="close" data-dismiss="alert">×</button>
                ${message.message}
        </div>
    </c:if>
    <c:if test="${message.success}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">×</button>
                ${message.message}
        </div>
    </c:if>
    <c:if test="${message.warn}">
        <div class="alert alert-warning">
            <button type="button" class="close" data-dismiss="alert">×</button>
                ${message.message}
        </div>
    </c:if>
    <c:if test="${message.error}">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">×</button>
                ${message.message}
        </div>
    </c:if>
    <c:remove var="notification" scope="session"/>
</c:if>
