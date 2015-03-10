<!--
Uasge: <charts:easyPie id="rawuasge" value="70"/>
optional: bgColor
-->
<%@attribute name="id" type="java.lang.String" %>
<%@attribute name="value" type="java.lang.String" %>
<%@attribute name="bgColor" type="java.lang.String" required="false" %>
<div id="${id}" class="easy-pie-custom" data-percent="${value}"><span class="easy-pie-percent">${value}</span></div>
<script type="text/javascript">
    <%--$(function(){--%>
    <%--$('#<%=id %>').easyPieChart({--%>
    <%--animate: 1000,--%>
    <%--lineWidth: 8,--%>
    <%--barColor: "#6DCBDD"--%>
    <%--});--%>
    <%--});--%>
</script>