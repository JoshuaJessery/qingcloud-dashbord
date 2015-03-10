<%@ tag pageEncoding="utf-8" %>
<div class="row">
    <div class="col-xs-12 col-sm-12">
        <div class="row">
            <div class="pull-right col-xs-12 col-sm-4">
                <div class="input-group no-margin">
                        <span class="input-group-addon"
                              style="border:none;background: #fff;background: rgba(0,0,0,.05);"><i
                                class="fa fa-search"></i></span>
                    <input type="text" placeholder="搜索..." class="form-control no-padding-hr"
                           style="border:none;background: #fff;background: rgba(0,0,0,.05);">
                </div>
            </div>
            <div class="pull-left col-xs-12 col-sm-auto">
                <a href="#model_create_volume" data-toggle="modal" data-target="#model_create_volume"
                   class="btn btn-primary btn-labeled">
                    <span class="btn-label icon fa fa-plus"></span>创建
                </a>

                <div class="btn-group">
                    <a class="btn btn-small dropdown-toggle"
                       data-toggle="dropdown" href="#"> 更多 <span
                            class="caret"></span> </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">修改</a></li>
                        <li><a href="#">挂载</a></li>
                        <li><a href="#">卸载</a></li>
                        <li class="divider"></li>
                        <li><a href="#">备份</a></li>
                        <li><a id="btn_destory" href="#">删除</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<br/>