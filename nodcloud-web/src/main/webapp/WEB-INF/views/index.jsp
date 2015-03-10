<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="front" tagdir="/WEB-INF/tags/page/front" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>NodCloud -运营级混合云解决方案提供商</title>
	
	<!-- Bootstrap Core CSS -->
	<link href="${ctx}/assets/front/css/bootstrap.min.css" rel="stylesheet" />
	
	<!-- Google Web Fonts -->
	<%--<link href="http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:400,200,300,700" rel="stylesheet" type="text/css">--%>
	<%----%>
	<!-- Starter Template Files -->
	<link href="${ctx}/assets/front/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
	<link href="${ctx}/assets/front/css/style.css" rel="stylesheet" />
	<link href="${ctx}/assets/front/css/responsive.css" rel="stylesheet" />
	
	<!--[if lt IE 9]>
		<script src="${ctx}/assets/front/js/ie8-responsive-file-warning.js"></script>
	<![endif]-->
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	<!-- Fav and touch icons -->
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="${ctx}/assets/front/images/fav-144.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx}/assets/front/images/fav-114.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${ctx}/assets/front/images/fav-72.png">
	<link rel="apple-touch-icon-precomposed" href="${ctx}/assets/front/images/fav-57.png">
	<link rel="shortcut icon" href="${ctx}/assets/front/images/fav.png">
	
</head>
<body>
	<!-- Preloader Starts -->
		<div class="loader"></div>
	<!-- Preloader Ends -->
	<!-- Header Section Starts -->
		<header id="header">
			<div class="header-overlay">
				<div class="container">
				<!-- Logo Starts -->
					<div data-scroll-reveal="enter top and move 50px over 1.2s" class="logo">
						<img src="${ctx}/assets/front/images/logo.png" alt="Saturn Designers" />
					</div>
				<!-- Logo Ends -->
				<!-- Main Heading Starts -->
					<div class="main-head">
						<h2 data-scroll-reveal="enter left and move 50px over 1.8s">距离NodCloud正式上线还有</h2>
						<h4 data-scroll-reveal="enter right and move 50px over 2.0s">NodCloud是国内云计算领域资深技术团队NodTech利用其自主研发开源云平台CecOS的商业版本NodOS优化后部署搭建，第一期工程建设三个节点，北京，上海及广州节点，具体功能及性能惊喜请下拉</h4>
					</div>
				<!-- Main Heading Ends -->
				</div>
			<!-- Countdown Area Starts -->
				<div id="countdown-area">
				<!-- Count Down Timer Starts -->
					<ul class="countdown">
						<li>
							<span data-scroll-reveal="enter top and move 50px over 2.2s" class="days">00</span>
							<p data-scroll-reveal="enter bottom and move 50px over 2.4s" class="days_ref">days</p>
						</li>
						<li>
							<span data-scroll-reveal="enter top and move 50px over 2.6s" class="hours">00</span>
							<p data-scroll-reveal="enter bottom and move 50px over 2.8s" class="hours_ref">hours</p>
						</li>
						<li>
							<span data-scroll-reveal="enter top and move 50px over 3.0s" class="minutes">00</span>
							<p data-scroll-reveal="enter bottom and move 50px over 3.2s" class="minutes_ref">minutes</p>
						</li>
						<li>
							<span data-scroll-reveal="enter top and move 50px over 3.4s" class="seconds">00</span>
							<p data-scroll-reveal="enter bottom and move 50px over 3.6s" class="seconds_ref">seconds</p>
						</li>
					</ul>
				<!-- Count Down Timer Ends -->
				</div>
			<!-- Countdown Area Ends -->
			<!-- Scroll Down Starts -->
				<div data-scroll-reveal="enter bottom and move 50px over 1.2s" class="top-arrow">
					<a href="#subcribe"><span class="fa fa-angle-down"></span></a>
				</div>
			<!-- Scroll Down Ends -->
			</div>
		</header>
	<!-- Header Section Ends -->
	<!-- Subscribe Section Starts -->
		<section id="subcribe">
			<div class="container">
			<!-- Main Heading Starts -->
				<div class="main-head">
					<h2 data-scroll-reveal="enter top and move 50px over 1.2s">公测登记及发布会登记</h2>
					<h4 data-scroll-reveal="enter left and move 50px over 1.3s">我们将正式上线前10天开放200个公测名额，上线当天将向公众开放300个参加名额，参与公测及发布会路演活动均可获得精美礼品</h4>
				</div>
			<!-- Main Heading Ends -->
			<!-- Subscribe Form Starts -->
				<form data-scroll-reveal="enter bottom and move 50px over 1.4s" id="subscribe-form"  role="form">
					<button type="submit" class="btn btn-default"><a href="${ctx}/rggc" >公测报名</a></button>
                    <button type="submit" class="btn btn-default"><a href="${ctx}/rgfbh" >发布会报名</a></button>
				</form>
			<!-- Subscribe Form Ends -->
			</div>
		</section>
	<!-- Subscribe Section Ends -->
	<!-- Services Section Starts -->
		<section id="services">
			<div class="services-overlay">
				<div class="container">
				<!-- Main Heading Starts -->
					<div class="main-head">
						<h2 data-scroll-reveal="enter top and move 50px over 1.2s">NodCloud的功能及优势</h2>

					</div>
				<!-- Main Heading Ends -->
				<!-- Services List Starts -->
					<div id="services-blocks" class="row">
						<div data-scroll-reveal="enter bottom and move 50px over 1.6s" class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<span class="fa fa-cogs"></span>
							<h4>弹性Web规模计算</h4>
							<p>
                                所有计算资源弹性可扩展，不需要的资源可以随时销毁。
							</p>
							<p>
								<a href="${ctx}/rggc">登记公测</a>
							</p>
						</div>
						<div data-scroll-reveal="enter top and move 50px over 1.7s" class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<span class="fa fa-cloud-upload"></span>
							<h4>秒级响应 快速部署</h4>
							<p>
                                您可以只花几秒钟时间创建计算资源，按需使用。
							</p>
							<p>
								<a href="${ctx}/rggc">登记公测</a>
							</p>
						</div>
						<div data-scroll-reveal="enter bottom and move 50px over 1.8s" class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<span class="fa fa-group"></span>
							<h4>多重实时副本 保证安全</h4>
							<p>
                                多重实时副本保障您的数据安全，异地副本也能快速恢复。
							</p>
							<p>
								<a href="${ctx}/rggc">登记公测</a>
							</p>
						</div>
                        <div data-scroll-reveal="enter bottom and move 50px over 1.8s" class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <span class="fa fa-group"></span>
                            <h4>SDN私有网络之间完全隔离</h4>
                            <p>
                                满足对安全的完美追求
                            </p>
                            <p>
                                <a href="${ctx}/rggc">登记公测</a>
                            </p>
                        </div>
                        <div data-scroll-reveal="enter bottom and move 50px over 1.8s" class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <span class="fa fa-group"></span>
                            <h4>通过GRE安全隧道连接</h4>
                            <p>
                                能够轻松部署公私兼顾的虚拟私有云和混合云
                            </p>
                            <p>
                                <a href="#">登记公测</a>
                            </p>
                        </div>
                        <div data-scroll-reveal="enter bottom and move 50px over 1.8s" class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <span class="fa fa-group"></span>
                            <h4>出众的磁盘性能</h4>
                            <p>
                                可运行大型数据库业务，磁盘IO理论值达到175M/S
                            </p>
                            <p>
                                <a href="#">登记公测</a>
                            </p>
                        </div>
					</div>
				<!-- Services List Ends -->
				</div>
			</div>
		</section>
	<!-- Services Section Ends -->
	<!-- Contact Us Section Starts -->
	<!-- Contact Us Section Ends -->
	<!-- Footer Starts -->
		<footer id="footer">
			<div class="container">
			<!-- Footer Heading Starts -->
				<h2 data-scroll-reveal="enter top and move 50px over 1.2s">分享NodCloud</h2>
			<!-- Footer Heading Ends -->
			<!-- Social Media Links Starts -->
				<ul data-scroll-reveal="enter bottom and move 50px over 1.4s" class="list-inline sm-links">
					<li><a href="#"><span class="fa fa-google-plus"></span></a></li>
					<li><a href="#"><span class="fa fa-twitter"></span></a></li>
					<li><a href="#"><span class="fa fa-facebook"></span></a></li>
					<li><a href="#"><span class="fa fa-linkedin"></span></a></li>
					<li><a href="#"><span class="fa fa-skype"></span></a></li>
					<li><a href="#"><span class="fa fa-pinterest"></span></a></li>
					<li><a href="#"><span class="fa fa-youtube"></span></a></li>
				</ul>
			<!-- Social Media Links Ends -->
			<!-- Copyright Starts -->
				<div data-scroll-reveal="enter bottom and move 50px over 1.2s" class="copyright">
					<p data-scroll-reveal="enter top and move 50px over 3.2s">
						联系我们：QQ群：160943182     资源建设方/IDC合作：15618049627
					</p>
                    <p data-scroll-reveal="enter top and move 50px over 3.2s">
                        All Rights Reserved - 2014. @nodcloud.com NodTech Inc
                    </p>
				</div>
			<!-- Copyright Ends -->
			</div>
		</footer>
	<!-- Footer Ends -->
	<!-- Bootstrap core JavaScript -->
	<script src="${ctx}/assets/front/js/jquery-1.11.1.min.js"></script>
	<script src="${ctx}/assets/front/js/bootstrap.min.js"></script>
	<script src="${ctx}/assets/front/js/jquery.backstretch.min.js"></script>
	<script src="${ctx}/assets/front/js/scrollReveal.js"></script>
	<script src="${ctx}/assets/front/js/singlepagenav.jquery.js"></script>
	<script src="${ctx}/assets/front/js/jquery.downCount.js"></script>
	<script src="${ctx}/assets/front/js/jquery.gmap.min.js"></script>
	<script src="${ctx}/assets/front/js/custom.js"></script>
	<script>
		// Scroll Reveal Activate
		window.scrollReveal = new scrollReveal();
	</script>
</body>
</html>