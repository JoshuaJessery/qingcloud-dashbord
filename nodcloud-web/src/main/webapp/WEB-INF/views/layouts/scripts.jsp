<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">

    var ctx = '${ctx}';

</script>
<!-- Pixel Admin's javascripts -->
<script src="${ctx}/assets/javascripts/bootstrap.min.js"></script>
<script src="${ctx}/assets/javascripts/pixel-admin.min.js"></script>
<script src="${ctx}/assets/javascripts/nodcloud-core.js"></script>
<script type="text/javascript">
    init.push(function () {
        // Javascript code here
    })
    window.PixelAdmin.start(init);
</script>