<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="modal fade" id="applyEipModel" tabindex="-1" role="dialog" aria-labelledby="applyEipLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="${ctx}/dashbord/eips/create">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel2">申请公网IP</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <label class="form-label">名称</label>
                                <div class="controls">
                                    <input type="text" placeholder="名称" name="name" value="DEFAULT"
                                           class="form-control">
                                </div>
                            </div>
                            <div class="form-group" style="display: none">
                                <label class="form-label">数量</label>

                                <div class="controls">
                                    <input type="text" placeholder="1" name="count" value="1"
                                           class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-label">带宽</label>

                                <div class="controls">
                                    <div class="col-md-8">
                                        <div class="ui-v-slider"></div>
                                    </div>
                                    <div class="col-md-2">
                                        <span id="clone_bandwidth">1</span>Mbps
                                        <input type="hidden" name="bandwidth" id="bandwidth" value="1"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        $(function () {
            var colorful_sliders_options = {
                'range': 'min',
                'min': 1,
                'max': 300,
                'value': 1,
                'step': 1,
                'slide': function (event, ui) {

                    $("#bandwidth").val(ui.value);
                    $("#clone_bandwidth").text(ui.value);
                }
            };
            $('.ui-v-slider').slider(colorful_sliders_options);
        });
    </script>
</div>

