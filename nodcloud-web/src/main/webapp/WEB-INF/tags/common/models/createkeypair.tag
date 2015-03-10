<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="modal fade" id="createKeypairModal" tabindex="-1" role="dialog" aria-labelledby="createKeypairModal"
     aria-hidden="true">
    <div class="modal-dialog">
        <form method="POST" action="${ctx}/dashbord/keypairs/create" class="form-horizontal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">新建秘钥</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">名称</label>

                            <div class="controls col-sm-10">
                                <input type="text" placeholder="" name="name" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">加密方法</label>

                            <div class="col-sm-10">
                                <div class="radio col-sm-2">
                                    <label>
                                        <input type="radio" name="encryptMethod" value="ssh-rsa" class="px" checked="">
                                        <span class="lbl">ssh-rsa</span>
                                    </label>
                                </div>
                                <!-- / .radio -->
                                <div class="radio col-sm-2">
                                    <label>
                                        <input type="radio" name="encryptMethod" value="ssh-dss" class="px">
                                        <span class="lbl">ssh-dss</span>
                                    </label>
                                </div>
                                <!-- / .radio -->
                            </div>
                            <!-- / .col-sm-10 -->
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">描述</label>

                            <div class="controls col-sm-10">
                                <textarea name="description" rows="3"
                                          class="form-control"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary">创建</button>
            </div>
    </div>
    </form>
</div>
</div>
