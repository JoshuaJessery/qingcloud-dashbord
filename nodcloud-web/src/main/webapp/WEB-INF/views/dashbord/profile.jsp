<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../taglibs.jsp" %>
<html>
<head>
    <title>Nodcloud-账户信息</title>
</head>
<body>
<div class="content" id="page-profile">
    <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
    <div id="portlet-config" class="modal hide">
        <div class="modal-header">
            <button data-dismiss="modal" class="close" type="button"></button>
            <h3>Widget Settings</h3>
        </div>
        <div class="modal-body"> Widget settings form goes here</div>
    </div>
    <div class="clearfix"></div>
    <div class="content">
        <div class="row">
            <div class="col-md-12">
                <div class=" tiles white col-md-12 no-padding">
                    <div class="tiles green cover-pic-wrapper">
                        <div class="overlayer bottom-right">
                            <div class="overlayer-wrapper">
                                <div class="padding-10 hidden-xs">
                                    <button type="button" class="btn btn-primary btn-small"><i class="fa fa-check"></i>&nbsp;&nbsp;Following
                                    </button>
                                    <button type="button" class="btn btn-primary btn-small">Add</button>
                                </div>
                            </div>
                        </div>
                        <img src="${ctx}/assets/img/cover_pic.png" alt="">
                    </div>
                    <div class="tiles white">

                        <div class="row">
                            <div class="col-md-3 col-sm-3">
                                <div class="user-profile-pic">
                                    <img width="69" height="69"
                                         data-src-retina="${cxt}/assets/img/profiles/avatar2x.jpg"
                                         data-src="${cxt}/assets/img/profiles/avatar.jpg"
                                         src="${cxt}/assets/img/profiles/avatar.jpg" alt="">
                                </div>
                                <div class="user-mini-description">
                                    <h3 class="text-success semi-bold">
                                        2548
                                    </h3>
                                    <h5>Followers</h5>

                                    <h3 class="text-success semi-bold">
                                        457
                                    </h3>
                                    <h5>Following</h5>
                                </div>
                            </div>
                            <div class="col-md-5 user-description-box  col-sm-5">
                                <h4 class="semi-bold no-margin">John Smith</h4>
                                <h6 class="no-margin">CEO of web-arch.co.uk</h6>
                                <br>

                                <p><i class="fa fa-briefcase"></i>UI & Graphic Design</p>

                                <p><i class="fa fa-globe"></i>www.google.com</p>

                                <p><i class="fa fa-file-o"></i>Download Resume</p>

                                <p><i class="fa fa-envelope"></i>Send Message</p>
                            </div>

                            <div class="clearfix"></div>
                        </div>
                    </div>

                </div>
            </div>
        </div>


    </div>
</div>
</div>
</body>
</html>
