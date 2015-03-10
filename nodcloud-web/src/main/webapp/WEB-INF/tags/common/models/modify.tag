<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="modal fade" id="modifyInstanceModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">修改主机<span id="modify_instances_attrs"></span>的属性</h4>
            </div>
            <div class="modal-body">
                <form method="POST" id="modifyInstanceForm">
                    <div>
                        <label style="float: left;padding-right: 20px;">名称</label>  <input type="text" class="form-control" name="name" style="width: 90%;">
                    </div>
                    <div>
                        <br>
                        <label style="float: left;padding-right: 20px;">描述</label>  <textarea name="descr" style="width: 90%;"></textarea>
                    </div>
                    <input type="hidden" name="id">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="modify-cancel" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="modify-form-btn">提交</button>
            </div>
        </div>
    </div>
</div>
