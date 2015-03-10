<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html>
<!--

TABLE OF CONTENTS.

Use search to find needed section.

===================================================================

| 1. $BODY | Body |
| 2. $MAIN_NAVIGATION | Main navigation |
| 3. $NAVBAR_ICON_BUTTONS | Navbar Icon Buttons |
| 4. $MAIN_MENU | Main menu |
| 5. $UPLOADS_CHART | Uploads chart |
| 6. $EASY_PIE_CHARTS | Easy Pie charts |
| 7. $EARNED_TODAY_STAT_PANEL | Earned today stat panel |
| 8. $RETWEETS_GRAPH_STAT_PANEL | Retweets graph stat panel |
| 9. $UNIQUE_VISITORS_STAT_PANEL | Unique visitors stat panel |
| 10. $SUPPORT_TICKETS | Support tickets |
| 11. $RECENT_ACTIVITY | Recent activity |
| 12. $NEW_USERS_TABLE | New users table |
| 13. $RECENT_TASKS | Recent tasks |

===================================================================

-->


<!--[if IE 8]> <html class="ie8"> <![endif]-->
<!--[if IE 9]> <html class="ie9 gt-ie8"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="gt-ie8 gt-ie9 not-ie"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
    <title><sitemesh:title/></title>
    <!-- Pixel Admin's stylesheets -->
    <link href="${ctx}/assets/stylesheets/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/assets/stylesheets/pixel-admin.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/assets/stylesheets/widgets.min.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/assets/stylesheets/rtl.min.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/assets/stylesheets/themes.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/assets/plugins/jquery-datatable/css/jquery.dataTables.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/assets/stylesheets/custom.css" rel="stylesheet" type="text/css">
    <!--[if lt IE 9]>
    <script src="${ctx}/assets/javascripts/ie.min.js" type="text/javascript"></script>
    <![endif]-->
    <!-- Get jQuery from Google CDN -->
    <!--[if !IE]> -->
    <script type="text/javascript" src="${ctx}/assets/javascripts/jquery-2.0.3.js"></script>
    <!-- <![endif]-->
    <!--[if lte IE 9]>
    <script type="text/javascript"> window.jQuery || document.write('<script src="http://lib.sinaapp.com/js/jquery/1.8.3/jquery.js">' + "<" + "/script>"); </script>
    <![endif]-->
    <sitemesh:head/>
</head>


<!-- 1. $BODY ======================================================================================

	Body

	Classes:
	* 'theme-{THEME NAME}'
	* 'right-to-left'      - Sets text direction to right-to-left
	* 'main-menu-right'    - Places the main menu on the right side
	* 'no-main-menu'       - Hides the main menu
	* 'main-navbar-fixed'  - Fixes the main navigation
	* 'main-menu-fixed'    - Fixes the main menu
	* 'main-menu-animated' - Animate main menu
-->
<body class="theme-default main-menu-animated dont-animate-mm-content-sm animate-mm-md animate-mm-lg">
<script>var init = [];</script>
<div id="main-wrapper">
    <jsp:include page="main-navbar.jsp"/>
    <!-- /2. $END_MAIN_NAVIGATION -->
    <jsp:include page="main-menu.jsp"/>
    <!-- /4. $MAIN_MENU -->

    <div id="content-wrapper">
        <tags:notification message="${notification}"/>
        <sitemesh:body/>
    </div>
    <!-- / #content-wrapper -->
    <div id="main-menu-bg"></div>
</div>
<jsp:include page="scripts.jsp"/>
</body>
</html>