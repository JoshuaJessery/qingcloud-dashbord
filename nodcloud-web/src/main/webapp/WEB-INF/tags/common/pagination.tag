<%@tag pageEncoding="UTF-8" %>
<%@ attribute name="page" type="org.springframework.data.domain.Page" required="true" %>
<%@ attribute name="paginationSize" type="java.lang.Integer" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    int current = Integer.parseInt(request.getParameter("page") != null ? request.getParameter("page") : "1");
    int begin = Math.max(1, current - paginationSize / 2);
    int end = Math.min(begin + (paginationSize - 1), page.getTotalPages());
    request.setAttribute("current", current);
    request.setAttribute("begin", begin);
    request.setAttribute("end", end);
%>

<div class="clearfix">
    <div class="DT-label">
        <div class="dataTables_info">从 ${begin} 到 ${end} 共 ${page.totalElements} 条记录
        </div>
    </div>
    <div class="DT-pagination">
        <div class="dataTables_paginate paging_simple_numbers" id="jq-datatables-example_paginate">
            <ul class="pagination">
                <% if (page.hasPreviousPage()) {%>
                <li class="paginate_button previous" aria-controls="jq-datatables-example" tabindex="0">
                    <a href="?page=${current-1}&sortType=${sortType}&${searchParams}">上一页</a>
                </li>
                <%} else {%>
                <li class="paginate_button previous disabled" aria-controls="jq-datatables-example" tabindex="0">
                    <a href="#">上一页</a>
                </li>
                <% } %>

                <c:forEach var="i" begin="${begin}" end="${end}">
                    <c:choose>
                        <c:when test="${i == current}">
                            <li class="paginate_button active" tabindex="0"><a href="?page=${i}&sortType=${sortType}&${searchParams}">${i}</a></a>
                        </c:when>
                        <c:otherwise>
                            <li class="paginate_button " tabindex="0"><a
                                    href="?page=${i}&sortType=${sortType}&${searchParams}">${i}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                </li>

                <% if (page.hasNextPage()) {%>
                <li class="paginate_button next"><a
                        href="?page=${current+1}&sortType=${sortType}&${searchParams}">下一页</a></li>
                <%} else {%>
                <li class="paginate_button next disabled"><a
                        href="#">下一页</a></li>
                <%} %>

            </ul>
        </div>
    </div>
</div>



