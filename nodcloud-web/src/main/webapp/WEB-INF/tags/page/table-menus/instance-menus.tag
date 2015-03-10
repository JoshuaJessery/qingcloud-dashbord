<%@ tag pageEncoding="utf-8" %>
<div class="row">
    <div class="col-xs-12 col-sm-12">
        <div class="row">
            <div class="pull-right col-xs-12 col-sm-4">
                <!-- Search field -->
                <div class="input-group no-margin">
                            <span class="input-group-addon"
                                  style="border:none;background: #fff;background: rgba(0,0,0,.05);"><i
                                    class="fa fa-search"></i></span>
                    <input type="text" placeholder="搜索..." class="form-control no-padding-hr"
                           style="border:none;background: #fff;background: rgba(0,0,0,.05);">
                </div>
            </div>

            <!-- "Create project" button, width=auto on desktops -->
            <div class="pull-left col-xs-12 col-sm-auto">
                <a href="#createInstanceModel" data-toggle="modal" data-target="#createInstanceModel"
                   class="btn btn-primary btn-labeled">
                    <span class="btn-label icon fa fa-plus"></span>创建主机
                </a>
                <a id="btn-start-instance" disabled href="#" class="btn btn-primary btn-labeled">
                    <span class="btn-label icon fa fa-play"></span>启动
                </a>
                <a id="btn-stop-instance" disabled href="#" class="btn btn-primary btn-labeled">
                    <span class="btn-label icon fa fa-plus"></span>停止
                </a>

                <div class="btn-group">
                    <a id="btn-group" class="btn btn-small dropdown-toggle"
                       data-toggle="dropdown" href="#"> 更多 <span
                            class="caret"></span> </a>
                    <ul class="dropdown-menu">
                        <li><a class="disabled-link" id="btn-restart-instance" href="#">重启</a></li>
                        <li><a class="disabled-link" href="#">挂载磁盘</a></li>
                        <li><a class="disabled-link" href="#">加入网络</a></li>
                        <li class="divider"></li>
                        <li><a class="disabled-link resizeInstanceModel" href="#resizeInstanceModel"
                               data-target="#resizeInstanceModel">更新配置</a></li>
                        <li><a class="disabled-link" href="#">备份</a></li>
                        <li><a class="disabled-link resetsInstanceModel" href="#resetInstanceModel"
                               data-target="#resetInstanceModel">重置</a></li>
                        <li><a class="" href="#" id="btn-destory-instance">销毁</a></li>
                    </ul>
                </div>
            </div>


        </div>
    </div>
</div>
<br/>
