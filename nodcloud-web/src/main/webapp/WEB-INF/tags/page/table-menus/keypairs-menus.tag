<%@ tag pageEncoding="utf-8" %>
<div class="row">
    <div class="col-xs-12 col-sm-12">
        <div class="row">
            <!-- Search field -->
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
                <a href="" class="btn btn-primary">
                    <span class="btn-label icon fa fa-refresh"></span>
                </a>
                <a href="#createKeypairModal" data-toggle="modal" data-target="#createKeypairModal"
                   class="btn btn-primary btn-labeled">
                    <span class="btn-label icon fa fa-plus"></span>创建
                </a>
                <a id="" disabled href="#" class="btn btn-primary btn-labeled">
                    <span class="btn-label icon fa fa-play"></span>加载到主机
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
<br/>