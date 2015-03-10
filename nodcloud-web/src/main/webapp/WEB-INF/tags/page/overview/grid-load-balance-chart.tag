<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="charts" tagdir="/WEB-INF/tags/common/charts" %>
<div class="grid simple">
    <tags:gridtitle title="负载均衡器"/>
    <div class="grid-body no-border grid-content-center">
        <charts:easyPie id="raw-load-balanace-summary" value="0"/>
    </div>
</div>