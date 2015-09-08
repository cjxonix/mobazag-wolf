<%@page import="startek.util.Util"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglib.jsp"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>

<title>${title =='' ?'' : title } <tiles:getAsString name="title" />
</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="${ctx}/assets/s/img/favcon.png" type="image/x-icon" />
<link rel="shortcut icon" href="${ctx}/assets/s/img/favcon.png" type="image/x-icon" />



<!-- CSS styles -->
<link rel='stylesheet' type='text/css'
	href='${ctx}/assets/s/css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css'
	href='${ctx}/assets/s/css/main.css'>
<link rel='stylesheet' type='text/css'
	href='${ctx}/assets/s/css/owl.carousel.css'>
<link rel='stylesheet' type='text/css'
	href='${ctx}/assets/s/css/owl.theme.css'>

<!-- JS Libs -->
<script src="${ctx}/assets/s/js/jquery.js"></script>
<script src="${ctx}/assets/s/js/bootstrap.min.js"></script>
<script src="${ctx}/assets/s/js/respond.min.js"></script>
<script src="${ctx}/assets/s/js/owl.carousel.min.js"></script>
<script src="${ctx}/assets/s/css/fonts_.css"></script>
<script src="${ctx}/assets/s/css/custom.css"></script>

<tiles:insertAttribute name="css" />
</head>
<body>

		<!-- Main page container -->
		<div id="top-bar">
		    <div class="container">
		        <div class="row">
		            <div class="col-md-12">
		                <a class="brand pull-left" href="http://wolf.afriappstore.com/"><img src="${ctx}/assets/s/img/logo.png" alt="e-Classifieds" title="e-Classifieds"></a>
		                <ul class="nav nav-pills pull-right">
		                    <li class="phone"><img src="${ctx}/assets/s/img/phone.png" alt="" /></li>
		                    <li><a href="register.html"><i class="glyphicon glyphicon-user"></i> Sign In</a></li>
		                    <li><a href="register.html"><i class="glyphicon glyphicon-edit"></i> Create your profile</a></li>
		                </ul>									
		            </div>
		        </div>
		    </div>
		</div>	

	<!-- navbar -->
	<div class="navbar bs-docs-nav" role="banner">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-nav">
                <li class="active"><a href="http://wolf.afriappstore.com/">Home</a></li>
                <li class=""><a href="http://wolf.afriappstore.com/agencies">Wedding Agencies</a></li>						
                <li class=""><a href="http://wolf.afriappstore.com/works">Work Profiles</a></li>								
                <li class=""><a href="http://wolf.afriappstore.com/offers">Special Offers</a></li>
                <li class=""><a href="#">Articles</a></li>								
                <li class=""><a href="http://wolf.afriappstore.com/agency">Agency 1</a></li>								
                <li class=""><a href="contact.html">Contact Us</a></li>
            </ul>
        </nav>
    </div>
</div>
	<!-- end navbar -->

	

	<!-- main container -->
	   <div class="container">
            <div class="row">

                <div class="col-md-9">
                <tiles:insertAttribute name="body" />
                    <form class="search_top_form form-inline" role="form">							
                        <div class="col-md-3 col-sm-3">
                            <input type="text" class="form-control" value="" placeholder="Keyword...">
                        </div>
                        <div class="col-md-3 col-sm-3">
                            <select name="type" class="form-control">
                                <option value="1">Auto</option>
                                <option value="2">Beauty and Fitness</option>
                                <option value="3">Real Estate</option>
                            </select>
                        </div>
                        <div class="col-md-3 col-sm-3">
                            <select name="city" class="form-control">
                                <option value="1">All city...</option>
                                <option value="2">Da Nang</option>
                                <option value="3">Ho Chi Minh</option>
                            </select>
                        </div>
                        <div class="col-md-3 col-sm-3">
                            <button class="btn btn-warning"><span class="glyphicon glyphicon-search"></span> Search Now</button>
                        </div>
                    </form>
                    <div class="main_content">

                        <!--Featured Agencies-->
                        <h3 class="title"><span class="pull-left">FEATURED LISTINGS</span><span class="pull-right"><a href="view_all.html">View all listings</a></span></h3>
                        <div class="row">
                            <div class="span12 product_listing">
                                <div id="owl-carousel" class="owl-carousel">
                                    <div class="col-md-12">
                                        <div class="item">
                                            <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m2.png" alt="Academy Theatre" title="Academy Theatre"></a>
                                            <a href="detail.html" class="title">Academy Theatre</a> <span class="label label-success">new</span><br/>in <a href="view_all.html" class="subinfo">Entertainment</a> by <a href="#" class="subinfo">Amanda</a>
                                            <p>This is example text for the overview section. This is my boss, Jonathan...</p>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="item">
                                            <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m3.png" alt="Special Jewelry" title="Special Jewelry"></a>
                                            <br/><a href="detail.html" class="title">Special Jewelry</a><br/>in <a href="view_all.html" class="subinfo">Real Estate</a> by <a href="#" class="subinfo">Anthony Bill</a>
                                            <p>This is example text for the overview section. There's a voice that keep...</p>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="item">
                                            <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m6.png" alt="Soft Bed Hotel" title="Soft Bed Hotel"></a>
                                            <a href="detail.html" class="title">Soft Bed Hotel</a><br/>in <a href="view_all.html" class="subinfo">Travel</a> by <a href="#" class="subinfo">Julia</a>
                                            <p>This is example text for the overview section. Just the good ol' boys, n...</p>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="item">
                                            <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m1.png" alt="Fly Airlines" title="Fly Airlines"></a>
                                            <a href="detail.html" class="title">Fly Airlines</a><br/>in <a href="view_all.html" class="subinfo">Sports</a> by <a href="#" class="subinfo">Carl Gilmore</a>
                                            <p>This is example text for the overview section. One for all and all for o...</p>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="item">
                                            <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m3.png" alt="Special Jewelry" title="Special Jewelry"></a>
                                            <br/><a href="detail.html" class="title">Special Jewelry</a><br/>in <a href="view_all.html" class="subinfo">Real Estate</a> by <a href="#" class="subinfo">Anthony Bill</a>
                                            <p>This is example text for the overview section. There's a voice that keep...</p>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="item">
                                            <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m2.png" alt="Academy Theatre" title="Academy Theatre"></a>
                                            <a href="detail.html" class="title">Academy Theatre</a> <span class="label label-success">new</span><br/>in <a href="view_all.html" class="subinfo">Entertainment</a> by <a href="#" class="subinfo">Amanda</a>
                                            <p>This is example text for the overview section. This is my boss, Jonathan...</p>
                                        </div>
                                    </div>								
                                    <div class="col-md-12">
                                        <div class="item">
                                            <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m1.png" alt="Fly Airlines" title="Fly Airlines"></a>
                                            <a href="detail.html" class="title">Fly Airlines</a><br/>in <a href="view_all.html" class="subinfo">Sports</a> by <a href="#" class="subinfo">Carl Gilmore</a>
                                            <p>This is example text for the overview section. One for all and all for o...</p>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="item">
                                            <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m6.png" alt="Soft Bed Hotel" title="Soft Bed Hotel"></a>
                                            <a href="detail.html" class="title">Soft Bed Hotel</a><br/>in <a href="view_all.html" class="subinfo">Travel</a> by <a href="#" class="subinfo">Julia</a>
                                            <p>This is example text for the overview section. Just the good ol' boys, n...</p>
                                        </div>
                                    </div>									
                                </div>								
                            </div>
                        </div>	


                        <!--Our Favorites Categories 9 items-->
                        <h3 class="title"><span class="pull-left">Our Favorites Categories</span><span class="pull-right"><a href="view_all.html">View all classifieds</a></span></h3>
                        <div class="row">
                            <div class="product_listing">
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m4.png" alt="Sell Harley-Davidson" title="Sell Harley-Davidson"></a>
                                        <a href="detail.html" class="title">Wedding Dresses</a> <span class="label">$200</span><br/>in <a href="view_all.html" class="subinfo">Entertainment</a> by <a href="#" class="subinfo">Amanda</a>										
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m7.png" alt="Winter Make-up" title="Winter Make-up"></a>
                                        <a href="detail.html" class="title">Cake Bakers</a> <span class="label">$370</span><br/>in <a href="view_all.html" class="subinfo">Health</a> by <a href="#" class="subinfo">Julia</a>										
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m8.png" alt="Office Furniture" title="Office Furniture"></a>
                                        <a href="detail.html" class="title">Food Cetering</a> <span class="label">$120</span><br/>in <a href="view_all.html" class="subinfo">Leisure</a> by <a href="#" class="subinfo">Jane</a>										
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m2.png" alt="BMW Deluxe" title="BMW Deluxe"></a>
                                        <a href="detail.html" class="title">BMW Deluxe</a> <span class="label label-danger">ask</span><br/>in <a href="view_all.html" class="subinfo">Food</a> by <a href="#" class="subinfo">Mark</a>										
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m8.png" alt="Office Furniture" title="Office Furniture"></a>
                                        <a href="detail.html" class="title">Office Furniture</a> <span class="label">$120</span><br/>in <a href="view_all.html" class="subinfo">Leisure</a> by <a href="#" class="subinfo">Jane</a>										
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m2.png" alt="BMW Deluxe" title="BMW Deluxe"></a>
                                        <a href="detail.html" class="title">BMW Deluxe</a> <span class="label label-danger">ask</span><br/>in <a href="view_all.html" class="subinfo">Food</a> by <a href="#" class="subinfo">Mark</a>										
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m8.png" alt="Office Furniture" title="Office Furniture"></a>
                                        <a href="detail.html" class="title">Office Furniture</a> <span class="label">$120</span><br/>in <a href="view_all.html" class="subinfo">Leisure</a> by <a href="#" class="subinfo">Jane</a>										
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m2.png" alt="BMW Deluxe" title="BMW Deluxe"></a>
                                        <a href="detail.html" class="title">BMW Deluxe</a> <span class="label label-danger">ask</span><br/>in <a href="view_all.html" class="subinfo">Food</a> by <a href="#" class="subinfo">Mark</a>										
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m2.png" alt="BMW Deluxe" title="BMW Deluxe"></a>
                                        <a href="detail.html" class="title">BMW Deluxe</a> <span class="label label-danger">ask</span><br/>in <a href="view_all.html" class="subinfo">Food</a> by <a href="#" class="subinfo">Mark</a>
                                    </div>
                                </div>
                                
                            </div>
                        </div>



                        <!--Top Deal & Promotion-->
                        <h3 class="title"><span class="pull-left">Top Promotions</span><span class="pull-right"><a href="view_all.html">View all deals</a></span></h3>						
                        <div class="row">
                            <div class="col-md-7 col-sm-7">
                                <div class="featured-item">
                                    <div class="pull-left deal-tag-info">
                                        <div class="deal-tag">$54</div>
                                        <div class="deal-discount">55% OFF</div>
                                    </div>
                                    <div class="pull-right">
                                        <a href="detail.html"><img src="${ctx}/assets/s/img/products/4_photo_2916.jpg" alt="55% off - The Prettiest Beauty Parlon" title="55% off - The Prettiest Beauty Parlon" class="img deal-featured"></a>
                                        <p><strong><a href="detail.html" title="55% off - The Prettiest Beauty Parlon">55% off - The Prettiest Beauty Parlon</a></strong>
                                            <br/>by <a href="#" title="The Prettiest Beauty Parlon">The Prettiest Beauty Parlon</a></p>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-5 col-sm-5">
                                <div class="other_info">
                                    <div class="item">
                                        <div class="deal-tag">$70</div>
                                        <strong><a href="detail.html" title="70% OFF for satellite T.V. at Soft Bed Hotel">70% OFF for satellite T.V. at Soft Bed Hotel</a></strong>
                                        <br/>by <a href="#" title="Soft Bed Hotel">Soft Bed Hotel</a>
                                    </div>
                                    <div class="item">
                                        <div class="deal-tag">$50</div>
                                        <strong><a href="detail.html" title="$50 - one month - Workout Gym">$50 - one month - Workout Gym</a></strong>
                                        <br/>by <a href="#" title="Workout">Workout</a>
                                    </div>
                                    <div class="item">
                                        <div class="deal-tag">$23</div>
                                        <strong><a href="detail.html" title="$23 For 30 Minute Massage">$23 For 30 Minute Massage</a></strong>
                                        <br/>by <a href="#" title="Relaxation Spa">Relaxation Spa</a>
                                    </div>
                                    <div class="item">
                                        <div class="deal-tag">$60</div>
                                        <strong><a href="detail.html" title="Weekday Promotion - 60% OFF">Weekday Promotion - 60% OFF</a></strong>
                                        <br/>by <a href="#" title="Golf Club Resort">Golf Club Resort</a>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <!--Featured Offered Items-->
                        <h3 class="title"><span class="pull-left">Feature Offers</span><span class="pull-right"><a href="view_all.html">View all classifieds</a></span></h3>
                        <div class="row">
                            <div class="product_listing">
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m4.png" alt="Sell Harley-Davidson" title="Sell Harley-Davidson"></a>
                                        <a href="detail.html" class="title">Sell Harley-Davidson</a> <span class="label">$200</span><br/>in <a href="view_all.html" class="subinfo">Entertainment</a> by <a href="#" class="subinfo">Amanda</a>										
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m7.png" alt="Winter Make-up" title="Winter Make-up"></a>
                                        <a href="detail.html" class="title">Winter Make-up</a> <span class="label">$370</span><br/>in <a href="view_all.html" class="subinfo">Health</a> by <a href="#" class="subinfo">Julia</a>										
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m8.png" alt="Office Furniture" title="Office Furniture"></a>
                                        <a href="detail.html" class="title">Office Furniture</a> <span class="label">$120</span><br/>in <a href="view_all.html" class="subinfo">Leisure</a> by <a href="#" class="subinfo">Jane</a>										
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m2.png" alt="BMW Deluxe" title="BMW Deluxe"></a>
                                        <a href="detail.html" class="title">BMW Deluxe</a> <span class="label label-danger">ask</span><br/>in <a href="view_all.html" class="subinfo">Food</a> by <a href="#" class="subinfo">Mark</a>										
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <a href="detail.html"><img class="img" src="${ctx}/assets/s/img/products/m4.png" alt="Sell Harley-Davidson" title="Sell Harley-Davidson"></a>
                                        <a href="detail.html" class="title">Sell Harley-Davidson</a> <span class="label">$200</span><br/>in <a href="view_all.html" class="subinfo">Entertainment</a> by <a href="#" class="subinfo">Amanda</a>
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="item">
                                        <div class="item-img-hld">
                                            <a href="detail.html"><img class="img" src="../../theweddingwolf.com/weddings_user_content/posts_/x285_/x285_fobyf6AaR6L0adFRCGdB1422351766973.html" alt="Winter Make-up" title="Winter Make-up"></a>
                                        </div>
                                        <a href="detail.html" class="title">Winter Make-up</a> <span class="label">$370</span><br/>in <a href="view_all.html" class="subinfo">Health</a> by <a href="#" class="subinfo">Julia</a>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <h3 class="title"><span class="pull-left">Recent Articles & Tips</span><span class="pull-right"><a href="view_all.html">View all articles</a></span></h3>
                        <div class="row">
                            <div class="col-md-7">
                                <div class="featured-item">
                                    <a href="#"><img src="${ctx}/assets/s/img/products/8_photo_2993.jpg" alt="Investing in Stocks" title="Investing in Stocks" class="img pull-left"></a>
                                    <strong><a href="#">Investing in Stocks</a></strong>
                                    <p>Published: 05/12/2010 by <a href="#" target="_blank"> Olivia Matthew</a> in <a href="#">Finance</a></p>
                                    <p>This is example text for the overview section. This is my boss, Jonathan Hart, a self-made millionaire, he's quite a guy</p>
                                </div>
                                <div class="featured-item">
                                    <a href="#"><img src="${ctx}/assets/s/img/products/7_photo_3011.jpg" alt="Retirement Plans" title="Retirement Plans" class="img pull-left"></a>
                                    <strong><a href="#">Retirement Plans</a></strong>
                                    <p>Published: 01/24/2010 by <a href="#" target="_blank"> Anthony Mark</a> in <a href="#">Finance</a></p>
                                    <p>This is example text for the overview section. One for all and all for one, Muskehounds are always ready.</p>
                                </div>
                            </div>
                            <div class="col-md-5">
                                <div class="other_info">
                                    <p>
                                        <strong><a href="#">Personal Growth	Personal Growth</a></strong>
                                        <br/>in <a href="#">Life Style</a> - 01/01/2010					
                                    </p>

                                    <p>
                                        <strong><a href="#">Starting a Business</a></strong>						
                                        <br/>in <a href="#">Business</a> - 12/26/2009					
                                    </p>						
                                    <p>
                                        <strong><a href="#">Health for kids</a></strong>							
                                        <br/>in <a href="#">Fitness</a> - 12/21/2009					
                                    </p>						
                                    <p>
                                        <strong><a href="#">The future of recycling</a></strong>
                                        <br/>in <a href="#">Volunteer</a> - 07/04/2009
                                    </p>
                                </div>
                            </div>
                        </div>
                        
                        
                         <h3 class="title"><span class="pull-left">Other Agencies</span><span class="pull-right"><a href="view_all.html">View all articles</a></span></h3>
                        <div class="row">
                            <div class="col-md-7">
                                <div class="featured-item">
                                    <a href="#"><img src="${ctx}/assets/s/img/products/8_photo_2993.jpg" alt="Investing in Stocks" title="Investing in Stocks" class="img pull-left"></a>
                                    <strong><a href="#">Investing in Stocks</a></strong>
                                    <p>Published: 05/12/2010 by <a href="#" target="_blank"> Olivia Matthew</a> in <a href="#">Finance</a></p>
                                    <p>This is example text for the overview section. This is my boss, Jonathan Hart, a self-made millionaire, he's quite a guy</p>
                                </div>
                                <div class="featured-item">
                                    <a href="#"><img src="${ctx}/assets/s/img/products/7_photo_3011.jpg" alt="Retirement Plans" title="Retirement Plans" class="img pull-left"></a>
                                    <strong><a href="#">Retirement Plans</a></strong>
                                    <p>Published: 01/24/2010 by <a href="#" target="_blank"> Anthony Mark</a> in <a href="#">Finance</a></p>
                                    <p>This is example text for the overview section. One for all and all for one, Muskehounds are always ready.</p>
                                </div>
                            </div>
                            <div class="col-md-5">
                                <div class="other_info">
                                    <p>
                                        <strong><a href="#">Personal Growth	Personal Growth</a></strong>
                                        <br/>in <a href="#">Life Style</a> - 01/01/2010					
                                    </p>

                                    <p>
                                        <strong><a href="#">Starting a Business</a></strong>						
                                        <br/>in <a href="#">Business</a> - 12/26/2009					
                                    </p>						
                                    <p>
                                        <strong><a href="#">Health for kids</a></strong>							
                                        <br/>in <a href="#">Fitness</a> - 12/21/2009					
                                    </p>						
                                    <p>
                                        <strong><a href="#">The future of recycling</a></strong>
                                        <br/>in <a href="#">Volunteer</a> - 07/04/2009
                                    </p>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>

                <!--The Navigation Listing & Side Menu-->
                
<!-- Main page container -->
<div class="col-md-3">
    <h3 class="title nm">BROWSE BY CATEGORY</h3>
    <div class="panel-group right-col" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                    <h3 class="title nm nl">Listings</h3>
                </a>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <div class="panel-body">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="view_all.html">» Auto</a><span>(35)</span></li>
                        <li><a href="view_all.html">» Beauty and Fitness</a><span>(4419)</span></li>
                        <li><a href="view_all.html">» Entertainment</a><span>(13082)</span></li>
                        <li><a href="view_all.html">» Food and Dining</a><span>(4998)</span></li>
                        <li><a href="view_all.html">» Gifts and Flowers</a><span>(8106)</span></li>
                        <li><a href="view_all.html">» Health</a><span>(24)</span></li>
                        <li><a href="view_all.html">» Lawyer</a><span>(5)</span></li>
                        <li><a href="view_all.html">» Real Estate</a><span>(1)</span></li>
                        <li><a href="view_all.html">» Sports</a><span>(2022)</span></li>
                        <li><a href="view_all.htmlhttp_/wolf.afriappstore.com/index.html">» Travel</a><span>(3204)</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                    <h3 class="title nl nm">Classifieds</h3>
                </a>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="view_all.html">» Food and Dining</a><span>(4998)</span></li>
                        <li><a href="view_all.html">» Gifts and Flowers</a><span>(8106)</span></li>
                        <li><a href="view_all.html">» Health</a><span>(24)</span></li>
                        <li><a href="view_all.html">» Lawyer</a><span>(5)</span></li>
                        <li><a href="view_all.html">» Real Estate</a><span>(1)</span></li>
                        <li><a href="view_all.html">» Sports</a><span>(2022)</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                    <h3 class="title nl nm">Deals</h3>
                </a>
            </div>
            <div id="collapseThree" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul class="nav nav-pills nav-stacked">																
                        <li><a href="view_all.html">» Gifts and Flowers</a><span>(8106)</span></li>
                        <li><a href="view_all.html">» Health</a><span>(24)</span></li>
                        <li><a href="view_all.html">» Lawyer</a><span>(5)</span></li>
                        <li><a href="view_all.html">» Real Estate</a><span>(1)</span></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>			
    <h3 class="title nmb">RANDOM ITEMS</h3>
    <div id="myCarousel" class="carousel slide home">
        <div class="carousel-inner">
            <div class="item active">
                <img alt="" src="${ctx}/assets/s/img/products/sitemgr_photo_360.jpg" />
                <div class="carousel-caption">									
                    <h4>Save 30%</h4>
                    <p>Lorem Ipsum is simply dummy text printing.</p>
                </div>
            </div>
            <div class="item">
                <img alt="" src="${ctx}/assets/s/img/products/sitemgr_photo_2627.jpg" />
                <div class="carousel-caption">
                    <h4>Save 12%</h4>
                    <p>Sed ut perspiciatis unde omnis iste.</p>
                </div>
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>
    <h3 class="title nmb">RECENT REVIEWS</h3>
    <div class="reviews-item">
        <div>
            <a href="#" title="John"><img class="img" src="${ctx}/assets/s/img/products/1_photo_1776.jpg" alt="" title=""></a>
        </div>
        <strong><a href="#">Ann Hotel</a></strong>
        <div class="rate">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOn.png" alt="Star On">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOn.png" alt="Star On">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOff.png" alt="Star Off">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOff.png" alt="Star Off">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOff.png" alt="Star Off">
        </div>
        <a href="#">» Read More</a>
        <p>The staff are the best! The rooms were clean! The parking was great!I had a great stay there! Can't wait to come back!!</p>
        <div class="info">
            <p>by&nbsp;<a href="#" title="John">John</a>
                <br/>Arlington, VA, 08/05/2011 - 03:37 pm</p>
        </div>
    </div>
    <div class="reviews-item">
        <div>
            <a href="#" title="Mark"><img class="img" src="${ctx}/assets/s/img/products/218_photo_1772.jpg" alt="" title=""></a>
        </div>
        <strong><a href="#">Mattew Law Firm</a></strong>
        <div class="rate">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOn.png" alt="Star On">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOn.png" alt="Star On">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOn.png" alt="Star On">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOn.png" alt="Star On">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOn.png" alt="Star On">
        </div>
        <a href="#">» Read More</a>
        <p>They were responsive, attentive and friendly while helping us.</p>
        <div class="info">
            <p>by&nbsp;<a href="#" title="Mark">Mark</a>
                <br/>Tulsa, Oklahoma, 06/16/2010 - 06:26 pm</p>
        </div>
    </div>
    <div class="reviews-item">
        <div class="item">
            <a href="#" title="Julia"><img class="img" src="${ctx}/assets/s/img/products/9_photo_1778.jpg" alt="" title=""></a>
        </div>
        <strong><a href="#">Tayu</a></strong>
        <div class="rate">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOn.png" alt="Star On">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOn.png" alt="Star On">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOn.png" alt="Star On">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOn.png" alt="Star On">
            <img src="${ctx}/assets/s/img/products/img_rateMiniStarOff.png" alt="Star Off">
        </div>
        <a href="#">» Read More</a>
        <p>The best part of this restaurant was definitely the decor and the server. We had the agedashi tofu and it was THE BES...</p>
        <div class="info">
            <p>by&nbsp;<a href="#" title="Julia">Julia</a>
                <br/>Norwich, New York, 06/16/2010 - 06:19 pm</p>
        </div>
    </div>
</div>


            </div>			
        </div>
	
	<!-- /end- main container -->

  <div id="footer">
    <div class="container">			
        <div class="row">					
            <div class="col-md-3">   
                <h4 class="">Information</h4>
                <ul>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Delivery Information</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Terms &amp; Conditions</a></li>
                </ul>
            </div>
            <div class="col-md-3">
                <h4>My Account</h4>
                <ul>
                    <li><a href="#">My Account</a></li>
                    <li><a href="#">Order History</a></li>
                    <li><a href="#">Wish List</a></li>
                    <li><a href="#">Newsletter</a></li>
                </ul>
            </div>
            <div class="col-md-3">
                <h4>Connect with us</h4>
                <a href="#"><img src="img/social-facebook.html" alt="Facebook" /></a>
                <a href="#"><img src="img/social-twitter.html" alt="Twitter" /></a>
                <a href="#"><img src="img/social-rss.html" alt="RSS" /></a>
                <a href="#"><img src="img/social-flickr.html" alt="Flickr" /></a>
            </div>
            <div class="col-md-3">
                <div class="company_info">
                    <h4>eDirectory</h4>
                    <p>
                        74/6 Nguyen Van Thoai, Da Nang, Viet Nam<br/>
                        Tel: +84 905276796
                    </p>
                </div>
            </div>					
        </div>	
    </div>
</div>

	<div>
		<footer class="text-center"
			style="margin-bottom: 20px; font-weight: bold; margin-top: -59px;">
			<small>Copyright 2015 &copy; All Reserved The Wedding Wolf</small>
		</footer>
	</div>

	<tiles:insertAttribute name="js" />
<tiles:insertAttribute name="footer" />



	<!-- /Main page container -->
	<script>
		$('.carousel').carousel({
			interval : 2000
		})

		$("#owl-carousel").owlCarousel({
			autoPlay : 3000, //Set AutoPlay to 3 seconds
			items : 4,
			pagination : true
		});
	</script>

</body>

</html>