<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="zxx">
<head>
<!-- Meta Tag -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name='copyright' content='codeglim'>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Title Tag-->
<title>Home</title>

<!-- Google Fonts & Google Maps API -->
<link href="https://fonts.googleapis.com/css?family=Work+Sans:400,500,600,700" rel="stylesheet"> 
<!---<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDnhgNBg6jrSuqhTeKKEFDWI0_5fZLx0vM" type="text/javascript"></script>--->

<!-- Hover  Css -->
<link rel="stylesheet" href="<%=context%>/css/home/hover.min.css">

<!-- Mobile Nav -->
<link rel="stylesheet" href="<%=context%>/css/home/slicknav.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="<%=context%>/css/home/font-awesome.min.css">

<!-- Animate Min -->
<link rel="stylesheet" href="<%=context%>/css/home/animate.min.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="<%=context%>/css/home/magnific-popup.css">

<!-- Slick Slider -->
<link rel="stylesheet" href="<%=context%>/css/home/slick.css">

<!-- Bootstrap -->
<link rel="stylesheet" href="<%=context%>/css/home/bootstrap.min.css">

<!-- Sufia Stylesheet -->
<link rel="stylesheet" href="<%=context%>/css/home/reset.css">
<link rel="stylesheet" href="<%=context%>/css/home/style.css">
<link rel="stylesheet" href="<%=context%>/css/home/responsive.css">

<!-- Sufia Color -->
<!--<link rel="stylesheet" href="css/skin/orange.css">-->
<!--<link rel="stylesheet" href="css/skin/red.css">-->
<!--<link rel="stylesheet" href="css/skin/green.css">-->	
<!--<link rel="stylesheet" href="css/skin/purple.css">-->	
<!--<link rel="stylesheet" href="css/skin/pink.css">-->	
<!--<link rel="stylesheet" href="css/skin/blaze.css">-->	
<!--<link rel="stylesheet" href="css/skin/blue2.css">-->	
<link rel="stylesheet" href="<%=context%>/css/home/skin/blue.css">

<!--[if lt IE 9]>
	   <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
 <![endif]-->
<link rel="stylesheet" href="#" id="colors">
</head>
<body class="js">

<!-- Preloader -->
<div class="loader">
	<div class="loader-inner">
		<div class="k-loader k-circle"></div>
	</div>
</div>
<!-- End Preloader -->

<!-- Mp Color -->
<!-- <div class="mp-color">
	<div class="icon inOut"><i class="fa fa-cogs "></i></div>
	<h4>Choose Color</h4>
	<span class="color1"></span>
	<span class="color2"></span>
	<span class="color3"></span>
	<span class="color4"></span>
	<span class="color5"></span>
	<span class="color6"></span>
	<span class="color7"></span>
	<span class="color8"></span>
</div> -->
<!--/ End Mp Color -->

<!-- Start Header -->
<header class="header clearfix" id="header">
	<!-- Start Topbar -->
	<div class="topbar">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-sm-12 col-xs-12">
					<!-- Address -->
					<ul class="address">
						<!-- <li><i class="fa fa-globe"></i>Language: English</li> -->
						<li><i class="fa fa-phone"></i>0556-2825590</li>
						<li><i class="fa fa-clock-o"></i>周一 到 周日: 9:00 - 18:00</li>
					</ul>
					<!--/ End Address -->
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12">
					<!-- Social -->
					<ul class="social">
						<li><a href="mailto:871363673@qq.com"><i class="fa fa-send"></i>871363673@qq.com</a></li>
						<!-- <li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
						<li><a href="#"><i class="fa fa-dribbble"></i></a></li> -->
					</ul>
					<!-- End Social -->
				</div>
			</div>
		</div>
	</div>
	<!--/ End Topbar -->
	
	<!-- Header Inner -->
	<div class="header-inner">
		<div class="container">
			<div class="row">
				<div class="col-md-2 col-sm-2 col-xs-12">
					<!-- Logo -->
					<div class="logo">
						<a class="index.html" href="index.jsp">
							<img src="img/logo.png" alt="#">
						</a>
					</div>
					<!--/End Logo -->
					
					<!-- Mobile Menu -->
					<div class="mobile-menu"></div>	
					<!--/ End Mobile Menu -->
				</div>
				<div class="col-md-10 col-sm-10 col-xs-12">
					<!-- Main Menu -->
					<div class="main-menu">
						<!-- Cart Bar -->
						<ul class="cart-search-bar">
							<!-- <li class="search"><a href="#"><i class="fa fa-search"></i></a></li> -->
							<!-- <li><a href="#" class="fa fa-bars"></a></li> -->
						</ul>
						<!--/ End Cart Bar -->
						
						<!-- Search Form -->
						<form class="search-form">
							<input type="text" placeholder="search here" name="search">
							<input type="submit" value="search">
						</form>
						<!--/ End Search Form -->
						
						<!-- Side Menu -->
						<div class="side-menu">
							<ul class="nav navbar-nav">
								<li class="remove"><a><i class="fa fa-remove"></i></a></li>
								<li class="current"><a href="#header">Hello</a></li>
								<li><a href="index.jsp">Corporate</a></li>
								<li><a href="#">Personal Portfolio</a></li>
								<li><a href="#">App Landing Page</a></li>
								<li><a href="#">Video Background</a></li>
								<li><a href="#">Project</a></li>
								<li><a href="#">News</a></li>
							</ul>
						</div>
						<!--/ End Side Menu -->
						
						<!-- Navigation -->
						<nav class="navbar">
							<div class="collapse navbar-collapse">
								<ul class="nav menu navbar-nav">
									<li class="current"><a href="#header">首页</a>
										<!-- <ul class="dropdown">
											<li><a href="index.jsp">Corporate</a></li>
											<li><a href="#">Personal Portfolio</a></li>
											<li><a href="#">App Landing Page</a></li>
											<li><a href="#">Video Background</a></li>
										</ul> -->
									</li>
									<li><a href="#">关于我们</a>
									<li><a href="#">核心业务</a></li>
									<li><a href="#">企业登记</a>
										<!-- <ul class="dropdown">
											<li><a href="#">Project Masonry</a></li>
											<li><a href="#">Project 4 Column</a></li>
											<li><a href="#">Project 3 Column</a></li>
											<li><a href="#">Project Single</a></li>
										</ul> -->
									</li>
									<li><a href="#team">关于团队</a></li>
									<li><a href="#news">合作伙伴</a>
										<!-- <ul class="dropdown">
											<li><a href="#">Grid Layout</a></li>
											<li><a href="#">Grid With sidebar</a></li>
											<li><a href="#">List Layout</a></li>
											<li><a href="#">List With Sidebar</a></li>
											<li><a href="#">News Single</a></li>
											<li><a href="#">News Single With Sidebar</a></li>
										</ul> -->
									</li>										
									<li><a href="#contact">联系我们</a></li>
								</ul>
							</div>
						</nav>
						<!--/ End Navigation -->
					</div>
					<!--/ End Main Menu -->
				</div>
			</div>
		</div>
	</div>
	<!--/ End Header Inner -->
</header>
<!--/ End Header-->

<!-- Start Slider -->
<section class="sufia-slider clearfix">
	<div class="slider-main">
		<!-- Slider Item -->
		<div class="single-slider" style="background-image:url(img/baner-1.jpg)">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="welcome-text center">
							<h1><span>上海 Shanghai</span>创业伞已开通服务城市</h1>
							<!-- <div class="button">
								<a href="#" class="btn primary">Learn More</a>
								<a href="#" class="btn ">Buy Now</a>
							</div> -->
							<a class="b-arrow" href="#"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!--/ End Slider Item -->
		<!-- Slider Item -->
		<div class="single-slider" style="background-image:url(img/baner-8.jpg)">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="welcome-text right">
							<h1><span>北京 Beijin</span>创业伞已开通服务城市</h1>
							<!-- <div class="button">
								<a href="#" class="btn primary">Learn More</a>
								<a href="#" class="btn ">Buy Now</a>
							</div> -->
							<a class="b-arrow" href="#"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!--/ End Slider Item -->
		<!-- Slider Item -->
		<div class="single-slider" style="background-image:url(img/baner-2.jpg)">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="welcome-text">
							<h1><span>南京 Nanjing</span>创业伞已开通服务城市</h1>
							<!-- <div class="button">
								<a href="#" class="btn primary">Learn More</a>
								<a href="#" class="btn">Buy Now</a>
							</div> -->
							<a class="b-arrow" href="#"></a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="single-slider" style="background-image:url(img/baner-5.jpg)">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="welcome-text">
							<h1><span>天津 Tianjin</span>创业伞已开通服务城市</h1>
							<!-- <div class="button">
								<a href="#" class="btn primary">Learn More</a>
								<a href="#" class="btn">Buy Now</a>
							</div> -->
							<a class="b-arrow" href="#"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/ End Slider Item -->
	</div>
</section>
<!--/ End Slider -->

<!-- Start Features -->
<section id="features" class="features section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12 wow fadeInUp">
				<div class="section-title">
					<h2>创业伞核心业务版块</h2>
					<p>顾客就是上帝,我们力求将服务做到极致</p>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.4s">
				<!-- Single features -->
				<div class="single-features">
					<!-- <i class="fa fa-adjust"></i> -->
					<img src="img/25.png">
					<h4>企业登记</h4>
					<p>
                        企业设立、变更、重组等咨询及代理，提供定制解决方案。
                    </p>
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.6s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/29.png">
					<!-- <i class="fa fa-bars"></i> -->
					<h4>财税服务</h4>
					<p>
                        会计及咨询、企业及个人所得税筹划、内控程序设计及实施。
                    </p>
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/24.png">
					<!-- <i class="fa fa-edit"></i> -->
					<h4>证照交易</h4>
					<p>
                        公司收购、转让信息的发布及交易一站式服务，全程专业人士跟单协助完成。
                    </p>
				</div>
				<!--/ End features -->
			</div>
			
		</div>
	</div>
</section>
<!--/ End Features -->

<!-- Start Count Down -->
<section id="countdown" class="count-down section">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-6 wow fadeInUp" data-wow-delay="0.3s">
				<!-- Single Count -->
				<div class="single-count">
					<i class="fa fa-check"></i>
					<h2 class="count">10</h2>
					<p>产品覆盖城市</p>
				</div>
				<!--/ End Single Count -->
			</div>
			<div class="col-md-3 col-sm-3 col-xs-6 wow fadeInUp" data-wow-delay="0.5s">
				<!-- Single Count -->
				<div class="single-count">
					<i class="fa fa-pencil-square"></i>
					<h2 class="count">8000</h2>
					<p>服务客户</p>
				</div>
				<!--/ End Single Count -->
			</div>
			<div class="col-md-3 col-sm-3 col-xs-6 wow fadeInUp" data-wow-delay="0.7s">
				<!-- Single Count -->
				<div class="single-count">
					<i class="fa fa-star"></i>
					<h2 class="count">18000</h2>
					<p>成功案例</p>
				</div>
				<!--/ End Single Count -->
			</div>
			<div class="col-md-3 col-sm-3 col-xs-6 wow fadeInUp" data-wow-delay="0.9s">
				<!-- Single Count -->
				<div class="single-count">
					<i class="fa fa-coffee"></i>
					<h2 class="count">15000</h2>
					<p>好评度</p>
				</div>
				<!--/ End Single Count -->
			</div>
		</div>
	</div>
</section>
<!--/ End Count Down -->


<section id="features" class="features section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12 wow fadeInUp">
				<div class="section-title">
					<h2>企业登记</h2>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.4s">
				<!-- Single features -->
				<div class="single-features">
					<!-- <i class="fa fa-adjust"></i> -->
					<img src="img/dj1.jpg" class="bus-reg-img">
					<h4 style="margin-top: 20px;">企业设立</h4>
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.6s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/dj2.jpg" class="bus-reg-img">
					<!-- <i class="fa fa-bars"></i> -->
					<h4 style="margin-top: 20px;">企业变更</h4>
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/dj3.jpg" class="bus-reg-img">
					<!-- <i class="fa fa-edit"></i> -->
					<h4 style="margin-top: 20px;">企业注销</h4>
				</div>
				<!--/ End features -->
			</div>

			<div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/dj4.jpg" class="bus-reg-img">
					<!-- <i class="fa fa-edit"></i> -->
					<h4 style="margin-top: 20px;">特殊类企业</h4>
				</div>
				<!--/ End features -->
			</div>
			
		</div>
	</div>
</section>

<!--/ End Project -->

<!-- Start Testimonial -->
<section id="testimonials" class="testimonial section">
	<div class="container">
		<div class="row">
			<div class="testimonial-active wow fadeInUp" data-wow-delay="0.4s">
				<!-- Single Testimonial -->
				<div class="testimonial-content">                   
					<h2>客户的评价?</h2>
					<p>服务很周到,办事效率很高. </p>
					<h4 class="t-name">— 江先生</h4>
				</div>   
				<!--/ End Single Testimonial -->
				<!-- Single Testimonial -->
				<div class="testimonial-content">                   
					<h2>客户的评价?</h2>
					<p>良心产品,能找到这样的企业真的很棒. </p>
					<h4 class="t-name">— 王女士</h4>
				</div>   
				<!--/ End Single Testimonial -->
				<!-- Single Testimonial -->
				<div class="testimonial-content">                   
					<h2>客户的评价?</h2>
					<p>他们为我很好的解决了问题,期待下次的合作. </p>
					<h4 class="t-name">— 张先生</h4>
				</div>  
				<!--/ End Single Testimonial -->
			</div>
		</div>
	</div>
</section>
<!--/ End Testimonial -->

<!-- Start News -->
<section id="news" class="newsblog section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12 wow fadeInUp">
				<div class="section-title">
					<h2>财税服务</h2>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12 wow fadeInUp" data-wow-delay="0.4s">
				<!-- Single News -->
				<div class="single-news">
					<div class="news-head">
						<img src="img/fw1.jpg" alt="#">
						<a href="#" class="link"><i class="fa fa-link"></i></a>
					</div>
					<div class="news-content">
						<h4><a href="#">代理记账</a></h4>
						<!-- <div class="date">Marketing / 16 Feb, 2017</div> -->
						<p>代替企业执行日常的税务申报和财务工作，服务内容包括：系统开始报税和开票之前的工作、月度代理记账服务、月度税务申报、发票服务、年度税务代理服务。</p>
						<!-- <a href="#" class="btn">Read More <span class="fa fa-angle-double-right"></span></a> -->
					</div>
				</div>
				<!--/ End Single Testimonial -->
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12 wow fadeInUp" data-wow-delay="0.6s">
				<!-- Single News -->
				<div class="single-news">
					<div class="news-head">
						<img src="img/fw2.jpg" alt="#">
						<a href="#" class="link"><i class="fa fa-link"></i></a>
					</div>
					<div class="news-content">
						<h4><a href="#">税务筹划</a></h4>
						<!-- <div class="date">Marketing / 16 Feb, 2017</div> -->
						<p>
                    		
                    在税法规定的范围内，不违反法律法规的情况下，通过一系列对经营、投资、理财等活动的事先筹划和安排，协助纳税人获得税收最大利益的筹划，尽可能的获得“节税”的税收利益。通过利用税收优惠政策法、纳税期的递延法、转让定价筹划法、利用税法漏洞筹划法、利用会计处理方法筹划法等等办法，帮企业税收最大化收益。
                		</p>
						<!-- <a href="#" class="btn">Read More <span class="fa fa-angle-double-right"></span></a> -->
					</div>
				</div>
				<!--/ End Single News -->
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single News -->
				<div class="single-news">
					<div class="news-head">
						<img src="img/fw3.jpg" alt="#">
						<a href="#" class="link"><i class="fa fa-link"></i></a>
					</div>
					<div class="news-content">
						<h4><a href="#">
                    上市财务辅导
                		</a></h4>
						<!-- <div class="date">Marketing / 16 Feb, 2017</div> -->
						<p>
                    从企业有意愿上市的时候，开始介入，协助企业搭建合适的上市的股权架构，培训企业的员工，规范历史财务数据，整理客户的内控系统，帮企业进行税收筹划等等工作，
使之即符合证监会对上市企业财务规范的要求，又达到企业税收最大化收益。
                </p>
						<!-- <a href="#" class="btn">Read More <span class="fa fa-angle-double-right"></span></a> -->
					</div>
				</div>
				<!--/ End Single News -->
			</div>
		</div>
		
	</div>
</section>
<!--/ End News -->

<section id="features" class="features section" style="padding-top: 0;">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12 wow fadeInUp">
				<div class="section-title">
					<h2>证照交易</h2>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.4s">
				<!-- Single features -->
				<div class="single-features">
					<!-- <i class="fa fa-adjust"></i> -->
					<img src="img/zz1.jpg" class="bus-reg-img">
					<h4 style="margin-top: 20px;">交易大厅</h4>
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.6s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/zz2.jpg" class="bus-reg-img">
					<!-- <i class="fa fa-bars"></i> -->
					<h4 style="margin-top: 20px;">公司出售</h4>
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/zz3.jpg" class="bus-reg-img">
					<!-- <i class="fa fa-edit"></i> -->
					<h4 style="margin-top: 20px;">公司求购</h4>
				</div>
				<!--/ End features -->
			</div>
			
		</div>
	</div>
</section>

<section id="features" class="features section" style="padding-top: 0;">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12 wow fadeInUp">
				<div class="section-title">
					<h2>我们的优势</h2>
					<p>你想知道的都在这里</p>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.4s">
				<!-- Single features -->
				<div class="single-features">
					<h4>
                                企业服务产品覆盖广
                            </h4>
					<p>
                        
                                创业伞精耕企业服务专业领域，以管家式服务覆盖企业发展全程。
                            
                    </p>
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.6s">
				<!-- Single features -->
				<div class="single-features">
					<h4>专业</h4>
					<p>
                        
                                员工主体皆有行业内十年以上工作经验，确保每个环节的准确度，为客户提供安全可靠的专家服务。
                            
                    </p>
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<h4>
                                创业服务互联网生态系统
                            </h4>
					<p>
                        
                                创业伞为创业者、政府机构、投融资机构提供良好的沟通平台，便于商务社交和资源共享，形成创业生态圈。
                            
                    </p>
				</div>
				<!--/ End features -->
			</div>

			<div class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<h4>
                                
                                创业配套B2B平台
                            
                            </h4>
					<p>
                        
                                
                                创业伞颠覆传统，以B2B模式为企业提供优质便捷的用户体验。
                            
                            
                    </p>
				</div>
				<!--/ End features -->
			</div>

			<div class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<h4>
                                
                                便捷
                            
                            </h4>
					<p>
                        
                                
                                简化传统办理过程，企业服务产品多样，客户只需网上操作，轻松享受一站式服务。
                            
                            
                    </p>
				</div>
				<!--/ End features -->
			</div>

			<div class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<h4>
                                
                                安全
                            
                            </h4>
					<p>
                        
                                
                                产品标准化定价，无任何隐形费用，专业人士严格把控办理过程，所有环节规范清晰安全。
                            
                            
                    </p>
				</div>
				<!--/ End features -->
			</div>
			
		</div>
	</div>
</section>

<section id="features" class="features section" style="padding-top: 0;">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12 wow fadeInUp">
				<div class="section-title">
					<h2>选择我们的客户</h2>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.4s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_01.jpg" class="logo-img">
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.6s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_02.jpg" class="logo-img">
					
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_03.jpg" class="logo-img">
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_04.jpg" class="logo-img">
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_05.jpg" class="logo-img">
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_06.jpg" class="logo-img">
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_07.jpg" class="logo-img">
				</div>
				<!--/ End features -->
			</div>
			<div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_08.jpg" class="logo-img">
				</div>
				<!--/ End features -->
			</div>
			<div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_09.jpg" class="logo-img">
				</div>
				<!--/ End features -->
			</div>
			<div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_10.jpg" class="logo-img">
				</div>
				<!--/ End features -->
			</div>
			<div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_11.jpg" class="logo-img">
				</div>
				<!--/ End features -->
			</div>
			
		</div>
	</div>
</section>

<section id="features" class="features section" style="padding-top: 0;">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12 wow fadeInUp">
				<div class="section-title">
					<h2>合作伙伴</h2>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.4s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_23.png" class="logo-img2">
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.6s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_22.jpg" class="logo-img2">
					
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_27.png" class="logo-img2">
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_20.jpg" class="logo-img2">
				</div>
				<!--/ End features -->
			</div>
			 <div class="col-md-2 col-sm-6 col-xs-12 wow fadeInUp" data-wow-delay="0.8s">
				<!-- Single features -->
				<div class="single-features">
					<img src="img/logo_25.png" class="logo-img2">
				</div>
				<!--/ End features -->
			</div>
			
		</div>
	</div>
</section>

<!-- Start Newslatter -->
<section id="newslatter" class="newslatter section">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-sm-6 col-xs-12 wow fadeInLeft" data-wow-delay="0.4s">
				<!-- Newslatter Title -->
				<!-- <div class="news-title">
					<h2>Subscribe to Newsletter</h2>
					<p>Subscribe to our newsletter to get daily updates and promotions.</p>
				</div> -->
				<!--/ End Newslatter Title -->
			</div>
			 <div class="col-md-6 col-sm-6 col-xs-12 wow fadeInRight" data-wow-delay="0.4s">
				<!-- Newslatter Form -->
				<!-- <div class="news-form">
					<input type="text" class="newso-input" placeholder="Enter you e-mail...">
					<input type="submit" class="signup" value="Signup">
				</div> -->
				<!--End Newslatter Form -->
			</div>
		</div>
	</div>
</section>
<!--/ End Newslatter -->



<!-- Contact Us -->
<section id="contact" class="section">
	<div class="container">
		 <div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12 wow fadeInUp">
				<div class="section-title">
				   <h2>联系我们</h2>
				   <p>填写下面的表单并提交,我们的客服会在2个工作日内与您联系</p>
				</div>
			</div>
		 </div>
	
		<div class="row">
			<!-- Contact Form -->
			<div class="col-md-5 col-sm-6 col-xs-12 wow fadeInUp">
				<form class="form" method="post" action="mail/mail.php">
					<div class="form-group">
						<input type="text" name="name" placeholder="您的称呼" required="required">
					</div>
					<div class="form-group">
						<input type="email" name="email" placeholder="您的邮箱Email" required="required">
					</div>
					<div class="form-group">
						<textarea name="message" rows="6" placeholder="留言" ></textarea>
					</div>
					<div class="form-group">	
						<button type="submit" class="button primary"><i class="fa fa-send"></i>发送</button>
					</div>
				</form>
			</div>
			<!--/ Contact Form -->
			<!-- Google Map -->
			<div class="col-md-7 col-sm-6 col-xs-12 wow fadeInUp">
				<div class="contact-map">
					<div class="map"></div>
				</div>
			</div>
			<!--/ End Google Map -->
		</div>
	</div>
</section>
<!--/ End Clients Us -->


<!-- Footer Top -->
<footer class="footer wow fadeInUp" id="contact">
	<div class="footer-top">
		<div class="container">
			<div class="row">
				<!-- Single Widget -->
				<div class="col-md-6 col-sm-4 col-xs-12 ">
					<div class="single-widget about">
						<div class="footer-logo">
							<a href="#"><img src="img/footer-logo.png" alt="#"></a>
						</div>
						<p>
                    创业伞以B2B模式，结合线上平台与线下服务，为企业解决创业路上各种繁琐的政策问题，为企业从创业初期到发展成熟期提供安全、便捷、透明的标准化服务。 创业伞深悉客户痛点，致力于打造让企业省事省心省钱的服务平台。</p>
						
					</div>
				</div>
				<!--/ End Single Widget -->
				<!-- Single Widget -->
				<div class="col-md-6 col-sm-4 col-xs-12">
					<div class="single-widget contact">
						<h2>联系方式</h2>
						<ul class="list">
							<li><i class="fa fa-map"></i>地址: 上海市闵行区黎安路688号强劲大厦9楼907</li>
							<li><i class="fa fa-phone"></i>电话: 400-808-2340</li>
							<li><i class="fa fa-envelope"></i>Email:<a href="mailto:info@chuangyesan.com">info@chuangyesan.com</a></li>
							<!-- <li><i class="fa fa-map"></i>官网: <a href="http://www.chuangyesan.com">www.chuangyesan.com</a></li> -->
						</ul>
					</div>
				</div>
				<!--/ End Single Widget -->
				<!-- Single Widget -->
				
				<!--/ End Single Widget -->
			</div>
		</div>
	</div>
	<!-- Footer Bottom -->
	<div class="copyright">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12 text-center">
					<!-- Copyright -->
					<p>Copyright &copy; 2017.Company name All rights reserved.</p>
					<!--/ End Copyright -->
				</div>
			</div>
		</div>
	</div>	
	<!--/ End Footer Bottom -->
</footer>
<!--/ End footer Top -->

<!-- Jquery -->
<script type="text/javascript" src="<%=context%>/js/home/jquery.min.js"></script>

<!-- Colors -->
<script type="text/javascript" src="<%=context%>/js/home/colors.js"></script>

<!-- Modernizr JS -->
<script type="text/javascript" src="<%=context%>/js/home/modernizr.min.js"></script>

<!-- Appear Js -->
<script type="text/javascript" src="<%=context%>/js/home/jquery.appear.js"></script>

<!-- Scrool Up -->
<script type="text/javascript" src="<%=context%>/js/home/jquery.scrollUp.min.js"></script>

<!-- Typed Js -->
<script type="text/javascript" src="<%=context%>/js/home/typed.min.js"></script>

<!-- Slick Nav -->
<script type="text/javascript" src="<%=context%>/js/home/jquery.slicknav.min.js"></script>

<!-- Onepage Nav -->
<script type="text/javascript" src="<%=context%>/js/home/jquery.nav.js"></script>

<!-- Yt Player -->
<script type="text/javascript" src="<%=context%>/js/home/ytplayer.min.js"></script>

<!-- Magnific Popup -->
<script type="text/javascript" src="<%=context%>/js/home/magnific-popup.min.js"></script>

<!-- Wow JS -->
<script type="text/javascript" src="<%=context%>/js/home/wow.min.js"></script>

<!-- Counter JS -->
<script type="text/javascript" src="<%=context%>/js/home/waypoints.min.js"></script>
<script type="text/javascript" src="<%=context%>/js/home/jquery.counterup.min.js"></script>

<!-- Isotop JS -->
<script type="text/javascript" src="<%=context%>/js/home/isotope.pkgd.min.js"></script>

<!-- Masonry JS -->
<script type="text/javascript" src="<%=context%>/js/home/masonry.pkgd.min.js"></script>

<!-- Slick Slider -->
<script type="text/javascript" src="<%=context%>/js/home/slick.min.js"></script>

<!-- Bootstrap JS -->
<script type="text/javascript" src="<%=context%>/js/home/bootstrap.min.js"></script>

<!-- Google Map JS -->
<script type="text/javascript" src="<%=context%>/js/home/gmap.js"></script>
	
<!-- Activate JS -->
<script type="text/javascript" src="<%=context%>/js/home/active.js"></script>
</body>
</html>
