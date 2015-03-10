<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="modal fade" id="resetInstanceModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">重置主机<span id="reset_instances_uuids"></span></h4>
            </div>
            <div class="modal-body">
                <div class="alert alert-warning fade in" role="alert">
                    重置主机会将您的操作系统盘重置为初始状态，确定要执行此操作？
                </div>
                <form method="POST" id="resetInstanceForm">
                    <div>
                        <!-- Nav tabs -->
                        <div>SSH登录方式:</div><br>
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="active"><a href="#home" id="resetKeyPaireLoginModel" role="tab" data-toggle="tab">SSH密钥</a></li>
                            <li><a href="#profile" role="tab" id="resetPasswdLoginMode" data-toggle="tab">密码</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="home">
                                <div>
                                    <p>用户名</p>
                                    <input type="text" readonly value="root" name="server_name" class="form-control">
                                </div>
                                <br>
                                <div>
                                    <p>SSH密钥</p>
                                    <select id="reset-keypair-select" class="form-control" name="keyPairId">
                                        <option value="">加载中</option>
                                    </select>
                                </div>
                            </div>
                            <div class="tab-pane" id="profile">
                                <div>
                                    <p>用户名</p>
                                    <input type="text" readonly value="root" name="server_name" class="form-control">
                                </div>
                                <br>
                                <div>
                                    <input type="password" placeholder="登录密码" name="loginPassword" class="form-control" value="">
                                </div>
                            </div>
                            <input type="hidden" name="loginMode" id="resetLoginMode" value="1"/>
                            <script type="text/javascript">
                                $(function () {
                                    $("#resetKeyPaireLoginModel").click(function () {
                                        $("#resetLoginMode").val(1);
                                    });
                                    $("#resetPasswdLoginMode").click(function () {
                                        $("#resetLoginMode").val(2);
                                    });
                                });
                            </script>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="reset-form-btn">提交</button>
            </div>
        </div>
    </div>
</div>
