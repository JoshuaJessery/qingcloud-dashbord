<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="${ctx}/assets/js/app/tags/destoryinstance.js"></script>
<div class="modal fade" id="destoryInstanceModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Destory Instance</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <p>Are you sure destroy this instances ?</p>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancle</button>
                    <button type="button" id="tagBtnSureDestoryInstance" class="btn btn-primary">Sure</button>
                </div>
            </form>
        </div>
    </div>
</div>
