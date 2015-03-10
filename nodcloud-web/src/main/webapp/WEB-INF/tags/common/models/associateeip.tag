<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="modal fade" id="associateEipModel" tabindex="-1" role="dialog" aria-labelledby="applyEipLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="${ctx}/dashbord/eips/associate">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel2">分配到主机</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <label class="form-label">名称</label>
                                <input type="hidden" name="eip" value="" id="AssociateeTarget">
                                <div class="controls">
                                    <select id="associate-availiable-instances" name="targetId" class="form-control">
                                        <option value="">加载中</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">分配</button>
                </div>
            </form>
        </div>
    </div>

</div>

