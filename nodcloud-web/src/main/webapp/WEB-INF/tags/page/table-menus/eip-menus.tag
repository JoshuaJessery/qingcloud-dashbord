<%@ tag pageEncoding="utf-8" %>
<div class="row">
    <div class="col-xs-12 col-sm-12">
        <div class="row">
            <div class="pull-left col-xs-12 col-sm-auto">
                <a href="" class="btn btn-primary">
                    <span class="btn-label icon fa fa-refresh"></span>
                </a>
                <a href="#applyEipModel" data-toggle="modal" data-target="#applyEipModel"
                   class="btn btn-primary btn-labeled">
                    <span class="btn-label icon fa fa-plus"></span>申请
                </a>
                <a id="btn-associate" href="#associateEipModel" disabled data-toggle="modal"
                   data-target="#associateEipModel" class="btn btn-primary btn-labeled">
                    <span class="btn-label icon fa fa-play"></span>分配到主机
                </a>
                <a id="btn-dissociate-eips" disabled class="btn btn-primary btn-labeled">
                    <span class="btn-label icon fa fa-remove"></span>解绑
                </a>
                <a id="btn-release-eips" disabled class="btn btn-primary btn-labeled">
                    <span class="btn-label icon fa fa-remove"></span>释放IP地址
                </a>
                <div class="btn-group">
                    <a id="btn-group" class="btn btn-small dropdown-toggle" disabled
                       data-toggle="dropdown" href="#"> 更多 <span
                            class="caret"></span> </a>
                    <ul class="dropdown-menu">
                        <li><a class="disabled-link" href="#">修改</a></li>
                        <li><a id="btn-remove" href="#">删除</a></li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>