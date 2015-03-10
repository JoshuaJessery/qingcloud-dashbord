<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ attribute name="images" type="org.nodcloud.web.common.page.model.Images" required="true" %>
<div class="modal fade" id="createInstanceModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <form method="POST" action="${ctx}/dashbord/instances/create">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">创建主机</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">

                            <ul class="nav nav-tabs nav-tabs-simple nav-tabs-xs tag-web-flow">
                                <li class="active">
                                    <a href="#tag_form_choice_image" data-toggle="tab">选择镜像<i
                                            class="fa fa-angle-right "></i></a>
                                </li>
                                <li class="">
                                    <a href="#tag_form_choice_type" data-toggle="tab">服务器配置<i
                                            class="fa fa-angle-right "></i></a>
                                </li>
                                <li class="" style="display: none">
                                    <a href="#tag_form_choice_network" data-toggle="tab">网络配置<i
                                            class="fa fa-angle-right "></i></a>
                                </li>
                                <li class="">
                                    <a href="#tag_form_choice_basic" data-toggle="tab">基本信息</a>
                                </li>
                            </ul>

                            <div class="tab-content">
                                <div class="tab-pane active" id="tag_form_choice_image">

                                    <div class="form-group">

                                        <label class="form-label">选择镜像:</label>

                                        <div class="controls">
                                            <select type="text" class="form-control" name="imageId">
                                                <c:forEach items="${images.images}" var="image">
                                                    <option value="${image.id}">${image.name}
                                                    </option>
                                                </c:forEach>
                                            </select>

                                        </div>
                                    </div>

                                </div>
                                <div class="tab-pane" id="tag_form_choice_type">

                                    <div class="form-group">
                                        <label class="form-label">CUP</label>

                                        <div class="controls">
                                            <div class="" data-toggle="buttons">
                                                <label class="btn btn-info btn-lg active">
                                                    <input type="radio" name="cup" value="1" checked> 1核
                                                </label>
                                                <label class="btn btn-info  btn-lg">
                                                    <input type="radio" name="cup" value="2"> 2核
                                                </label>
                                                <label class="btn btn-info  btn-lg">
                                                    <input type="radio" name="cup" value="4"> 4核
                                                </label>
                                                <label class="btn btn-info  btn-lg">
                                                    <input type="radio" name="cup" value="8"> 8核
                                                </label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="form-label">内存</label>

                                        <div class="controls">
                                            <div class="" data-toggle="buttons">

                                                <label class="btn btn-info  btn-lg active">
                                                    <input type="radio" name="memory" value="1024" checked> 1G
                                                </label>
                                                <label class="btn btn-info  btn-lg">
                                                    <input type="radio" name="memory" value="2048"> 2G
                                                </label>
                                                <label class="btn btn-info  btn-lg">
                                                    <input type="radio" name="memory" value="4096"> 4G
                                                </label>
                                                <label class="btn btn-info  btn-lg">
                                                    <input type="radio" name="memory" value="6144"> 6G
                                                </label>
                                                <label class="btn btn-info  btn-lg">
                                                    <input type="radio" name="memory" value="8192"> 8G
                                                </label>
                                                <label class="btn btn-info  btn-lg">
                                                    <input type="radio" name="memory" value="12288"> 12G
                                                </label>
                                                <label class="btn btn-info  btn-lg">
                                                    <input type="radio" name="memory" value="16384"> 16G
                                                </label>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="tab-pane" id="tag_form_choice_network"></div>
                                <div class="tab-pane" id="tag_form_choice_basic">

                                    <div class="form-group">
                                        <ul class="nav nav-tabs nav-tabs-xs">
                                            <li class="active"><a href="#bs-logmode-passwd" id="PasswdLoginMode"
                                                                  data-toggle="tab">密码登陆</a>
                                            </li>
                                            <li class=""><a href="#bs-logmode-keypair" id="KeyPairLoginMode"
                                                            data-toggle="tab">秘钥登录</a></li>
                                        </ul>
                                        <input type="hidden" name="loginMode" id="loginMode" value="2"/>
                                        <script type="text/javascript">
                                            $(function () {
                                                $("#KeyPairLoginMode").click(function () {
                                                    $("#loginMode").val(1);
                                                });
                                                $("#PasswdLoginMode").click(function () {
                                                    $("#loginMode").val(2);
                                                });
                                            });
                                        </script>
                                    </div>


                                    <div class="form-group">
                                        <label class="form-label">主机名称</label>

                                        <div class="controls">
                                            <input type="text" placeholder="主机名称" name="name" value="DEFAULT"
                                                   class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="form-label">用户名</label>

                                        <div class="controls">
                                            <input type="text" name="server_name" value="root" readonly
                                                   class="form-control">
                                        </div>
                                    </div>

                                    <div class="tab-content">
                                        <div class="tab-pane active" id="bs-logmode-passwd">
                                            <div class="form-group" aria-required="loginModelKeyPair"
                                                 aria-radio="logMode">
                                                <div class="controls">
                                                    <input type="password" placeholder="登录密码" name="loginPassword"
                                                           class="form-control" value="">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="tab-pane " id="bs-logmode-keypair">
                                            <div class="form-group">
                                                <div class="controls">
                                                    <select id="keypair-select" class="form-control" name="keyPairId">
                                                        <option value="">加载中</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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
<script type="text/javascript" src="${ctx}/assets/plugins/bootstrap-select2/select2.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/plugins/bootstrap-select2/select2_locale_zh-CN.js"></script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            method: 'get',
            url: "${ctx}/dashbord/api/keypairs",
            success: function (result, statuText, jqXHR) {
                $("#keypair-select, #reset-keypair-select").empty();
                for (var index in result) {
                    var keyPair = result[index];
                    $("#keypair-select, #reset-keypair-select").append("<option value='" + keyPair.id + "'>" + keyPair.uuid + "</option>");
                }
            }
        });
    });
</script>