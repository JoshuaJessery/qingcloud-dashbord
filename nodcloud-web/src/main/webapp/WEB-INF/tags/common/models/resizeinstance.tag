<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="modal fade" id="resizeInstanceModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="cursor: move;">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4>更改主机<span class="id"></span>配置</h4>
            </div>
            <div class="modal-body" id="resize-instances">
                <form class="form form-horizontal" method="POST">
                    <div class="custom-instance-types">
                        <h5>推荐类型</h5>
                        <div class="types">
                            <div class="types-item" style="width: 56px;">
                                <div class="inner">
                                    <span class="icon icon-selected"></span>
                                </div>
                                <h6 class="type-name">小型A</h6>
                            </div>
                            <div class="types-item selected" style="width: 56px;">
                                <div class="inner">
                                    <span class="icon icon-selected"></span>
                                </div>
                                <h6 class="type-name">小型B</h6>
                            </div>
                            <div class="types-item" style="width: 56px;">
                                <div class="inner">
                                    <span class="icon icon-selected"></span>
                                </div>
                                <h6 class="type-name">小型C</h6>
                            </div>
                            <div class="types-item" style="width: 56px;">
                                <div class="inner">
                                    <span class="icon icon-selected"></span>
                                </div>
                                <h6 class="type-name">中型A</h6>
                            </div>
                            <div class="types-item" style="width: 56px;">
                                <div class="inner">
                                    <span class="icon icon-selected"></span>
                                </div>
                                <h6 class="type-name">中型B</h6>
                            </div>
                            <div class="types-item" style="width: 56px;">
                                <div class="inner">
                                    <span class="icon icon-selected"></span>
                                </div>
                                <h6 class="type-name">中型C</h6>
                            </div>
                            <div class="types-item" style="width: 56px;">
                                <div class="inner">
                                    <span class="icon icon-selected"></span>
                                </div>
                                <h6 class="type-name">大型A</h6>
                            </div>
                            <div class="types-item" style="width: 56px;">
                                <div class="inner">
                                    <span class="icon icon-selected"></span>
                                </div>
                                <h6 class="type-name">大型B</h6>
                            </div>
                            <div class="types-item" style="width: 56px;">
                                <div class="inner">
                                    <span class="icon icon-selected"></span>
                                </div>
                                <h6 class="type-name">大型C</h6>
                            </div>
                        </div>
                        <div class="cpu">
                            <h6>CPU</h6>
                            <div class="options">
                                <div class="types-options cpu-options selected" data-value="1" style="width: 124.75px;">1 核</div>
                                <div class="types-options cpu-options " data-value="2" style="width: 124.75px;">2 核</div>
                                <div class="types-options cpu-options " data-value="4" style="width: 124.75px;">4 核</div>
                                <div class="types-options cpu-options " data-value="8" style="width: 124.75px;">8 核</div>
                            </div>
                        </div>
                        <div class="memory">
                            <h6>内存</h6>
                            <div class="options">
                                <div class="types-options memory-options " data-value="512" style="width: 43.9px;">512MB</div>
                                <div class="types-options memory-options selected" data-value="1024" style="width: 43.9px;">1G</div>
                                <div class="types-options memory-options " data-value="2048" style="width: 43.9px;">2G</div>
                                <div class="types-options memory-options " data-value="4096" style="width: 43.9px;">4G</div>
                                <div class="types-options memory-options disabled" data-value="6144" style="width: 43.9px;">6G</div>
                                <div class="types-options memory-options disabled" data-value="8192" style="width: 43.9px;">8G</div>
                                <div class="types-options memory-options disabled" data-value="12288" style="width: 43.9px;">12G</div>
                                <div class="types-options memory-options disabled" data-value="16384" style="width: 43.9px;">16G</div>
                                <div class="types-options memory-options disabled" data-value="24576" style="width: 43.9px;">24G</div>
                                <div class="types-options memory-options disabled" data-value="32768" style="width: 43.9px;">32G</div>
                            </div>
                        </div>
                    </div>
                    <input name="cup" type="hidden" value="1">
                    <input name="memory" type="hidden" value="1024">
                </form>
            </div>
            <div class="form-actions">
                <input class="btn btn-primary" type="submit" id="resizeForm" value="提交">
                <input class="btn btn-cancel" type="button" data-dismiss="modal" value="取消">
            </div>
        </div>
    </div>
</div>