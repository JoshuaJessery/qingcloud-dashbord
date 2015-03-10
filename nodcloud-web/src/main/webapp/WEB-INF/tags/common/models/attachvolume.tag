<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="instances" type="org.nodcloud.web.common.page.model.Instances" required="true" %>
<div class="modal fade" id="attachVolume" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="get">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel2">Attach Volume</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-8 col-sm-8 col-xs-8">

                            <div class="form-group">

                                <label class="form-label">Attach To Running Instance</label>

                                <div class="controls">
                                    <input type="hidden" name="attach"/>
                                    <input type="hidden" id="detach_volume_id" name="volume_id" value=""/>
                                    <select name="instance_id" class="form-control">
                                        <c:forEach items="${instances.instances}" var="instance">
                                            <option value="${instance.id}">${instance.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div>
