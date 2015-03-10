<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- Modal -->
<div class="modal fade" id="model_create_volume" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="${ctx}/dashbord/volumes/create">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">创建存储卷</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <label class="form-label">名称</label>
                                <div class="controls">
                                    <input type="text" name="name" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-label">数量</label>

                                <div class="controls">
                                    <input type="number" name="count" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-label">类型</label>
                                <div class="controls">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="type" value="1" class="px" checked="">
                                            <span class="lbl">性能性</span>&nbsp;&nbsp;&nbsp;<p class="help-block"> IO
                                            吞吐128 MB/s，单块最小容量10GB、最大容量1000GB。</p>
                                        </label>
                                        <label>
                                            <input type="radio" name="type" value="2" class="px" checked="">
                                            <span class="lbl">容量性</span>&nbsp;&nbsp;&nbsp;<p class="help-block">IO 吞吐 36
                                            MB/s，单块最小容量10GB、最大容量5000GB。</p>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="form-label">容量</label>

                                <div class="controls">
                                    <div class="col-md-8">
                                        <div class="ui-v-slider"></div>
                                    </div>
                                    <div class="col-md-2">
                                        <span id="clone_size">10</span>G
                                        <input type="hidden" name="size" id="size" value="10"/>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" name="create" class="btn btn-primary">创建</button>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        $(function () {
            var colorful_sliders_options = {
                'range': 'min',
                'min': 10,
                'max': 1000,
                'value': 10,
                'step': 10,
                'slide': function (event, ui) {
                    $("#size").val(ui.value);
                    $("#clone_size").text(ui.value);
                }
            };
            $('.ui-v-slider').slider(colorful_sliders_options);
        });
    </script>
</div>
