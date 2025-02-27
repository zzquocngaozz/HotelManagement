<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sogo Hotel by Colorlib.com</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content=""/>
    <link rel="stylesheet" type="text/css"
          href="//fonts.googleapis.com/css?family=|Roboto+Sans:400,700|Playfair+Display:400,700">
    <link rel="shortcut icon" href="static/images/favicon.ico"/>
    <link rel="stylesheet" href="static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/animate.css">
    <link rel="stylesheet" href="static/css/owl.carousel.min.css">
    <link rel="stylesheet" href="static/css/aos.css">
    <link rel="stylesheet" href="static/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="static/css/jquery.timepicker.css">
    <link rel="stylesheet" href="static/css/fancybox.min.css">

    <link rel="stylesheet" href="static/fonts/font-awesome.min.css">

    <!-- Theme Style -->
    <link rel="stylesheet" href="static/css/style.css">
</head>
<body>

<jsp:include page="/common/header_home_page.jsp"></jsp:include>

<!-- END head -->

<section class="site-hero inner-page overlay" style="background-image: url('static/images/login/2126.jpg')"
         data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row site-hero-inner justify-content-center align-items-center">
            <div class="col-md-10 text-center" data-aos="fade">
                <h1 class="heading mb-3">Rooms</h1>
                <ul class="custom-breadcrumbs mb-4">
                    <li>Home</li>
                    <li>&bullet;</li>
                    <li>Rooms</li>
                </ul>
            </div>
        </div>
    </div>

    <a class="mouse smoothscroll" href="#next">
        <div class="mouse-icon">
            <span class="mouse-wheel"></span>
        </div>
    </a>
</section>
<!-- END section -->

<section class="section pb-4">
    <div class="container">

        <div class="row check-availabilty" id="next">
            <div class="block-32" data-aos="fade-up" data-aos-offset="-200">

                <form action="home-page-room" method="POST">
                    <div class="row">
                        <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                            <label for="checkint" class="font-weight-bold text-black">Check In</label>
                            <div class="field-icon-wrap">
                                <div class="icon"><span class="icon-calendar"></span></div>
                                <input type="datetime-local" required id="checkint" class="form-control" name="checkin">
                            </div>
                        </div>
                        <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                            <label for="checkoutt" class="font-weight-bold text-black">Check Out</label>
                            <div class="field-icon-wrap">
                                <div class="icon"><span class="icon-calendar"></span></div>
                                <input type="datetime-local" required id="checkoutt" class="form-control" name="checkout">
                            </div>
                        </div>
                        <div class="col-md-6 mb-3 mb-md-0 col-lg-3">
                            <div class="row">
                                <div class="col-md-6 mb-3 mb-md-0">
                                    <label for="adultt" class="font-weight-bold text-black">Room</label>
                                    <div class="field-icon-wrap">
                                        <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                        <select name="roomId" id="adultt" class="form-control">
                                            <c:forEach items="${list}" var="r">
                                                <option value="${r.roomId}">${r.roomCode}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3 align-self-end">
                            <button class="btn btn-primary btn-block text-white">Check Availabilty</button>
                        </div>
                    </div>
                </form>
            </div>


        </div>
    </div>
</section>


<section class="section">
    <div class="container">

        <div class="row">
            <div class="col-md-6 col-lg-4 mb-5" data-aos="fade-up">
                <a href="#" class="room">
                    <figure class="img-wrap">
                        <img src="static/images/img_3.jpg" alt="Free website template" class="img-fluid mb-3">
                    </figure>
                    <div class="p-3 text-center room-info">
                        <h2>Single Room</h2>
                        <span class="text-uppercase letter-spacing-1">90$ / per night</span>
                    </div>
                </a>
            </div>

            <div class="col-md-6 col-lg-4 mb-5" data-aos="fade-up">
                <a href="#" class="room">
                    <figure class="img-wrap">
                        <img src="static/images/img_2.jpg" alt="Free website template" class="img-fluid mb-3">
                    </figure>
                    <div class="p-3 text-center room-info">
                        <h2>Family Room</h2>
                        <span class="text-uppercase letter-spacing-1">120$ / per night</span>
                    </div>
                </a>
            </div>

            <div class="col-md-6 col-lg-4 mb-5" data-aos="fade-up">
                <a href="#" class="room">
                    <figure class="img-wrap">
                        <img src="static/images/img_4.jpg" alt="Free website template" class="img-fluid mb-3">
                    </figure>
                    <div class="p-3 text-center room-info">
                        <h2>Presidential Room</h2>
                        <span class="text-uppercase letter-spacing-1">250$ / per night</span>
                    </div>
                </a>
            </div>


        </div>
    </div>
</section>

<section class="section bg-light">

    <div class="container">
        <div class="row justify-content-center text-center mb-5">
            <div class="col-md-7">
                <h2 class="heading" data-aos="fade">Great Offers</h2>
                <p data-aos="fade">Far far away, behind the word mountains, far from the countries Vokalia and
                    Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of
                    the Semantics, a large language ocean.</p>
            </div>
        </div>

        <div class="site-block-half d-block d-lg-flex bg-white" data-aos="fade" data-aos-delay="100">
            <a href="#" class="image d-block bg-image-2" style="background-image: url('static/images/img_4.jpg');"></a>
            <div class="text">
                <span class="d-block mb-4"><span class="display-4 text-primary">$199</span> <span
                        class="text-uppercase letter-spacing-2">/ per night</span> </span>
                <h2 class="mb-4">Single Room</h2>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live
                    the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large
                    language ocean.</p>
                <%--            <p><a href="#" class="btn btn-secondary text-white">Book Now</a></p>--%>
            </div>
        </div>
        <div class="site-block-half d-block d-lg-flex bg-white" data-aos="fade" data-aos-delay="200">
            <a href="#" class="image d-block bg-image-2 order-2"
               style="background-image: url('static/images/img_2.jpg');"></a>
            <div class="text order-1">
                <span class="d-block mb-4"><span class="display-4 text-primary">$299</span> <span
                        class="text-uppercase letter-spacing-2">/ per night</span> </span>
                <h2 class="mb-4">Family Room</h2>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live
                    the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large
                    language ocean.</p>
                <%--            <p><a href="#" class="btn btn-secondary text-white">Book Now</a></p>--%>
            </div>
        </div>
        <div class="site-block-half d-block d-lg-flex bg-white" data-aos="fade" data-aos-delay="100">
            <a href="#" class="image d-block bg-image-2" style="background-image: url('static/images/img_4.jpg');"></a>
            <div class="text">
                <span class="d-block mb-4"><span class="display-4 text-primary">$199</span> <span
                        class="text-uppercase letter-spacing-2">/ per night</span> </span>
                <h2 class="mb-4">Presidential Room</h2>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live
                    the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large
                    language ocean.</p>
                <%--              <p><a href="#" class="btn btn-secondary text-white">Book Now</a></p>--%>
            </div>
        </div>

    </div>
</section>

<section class="section bg-image overlay" style="background-image: url('static/images/login/2126.jpg');">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-12 col-md-6 text-center mb-4 mb-md-0 text-md-left" data-aos="fade-up">
                <h2 class="text-white font-weight-bold">A Best Place To Stay. Reserve Now!</h2>
            </div>
        </div>
    </div>
</section>

<footer class="section footer-section">
    <div class="container">
        <div class="row mb-4">
            <div class="col-md-3 mb-5">
                <ul class="list-unstyled link">
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Terms &amp; Conditions</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Rooms</a></li>
                </ul>
            </div>
            <div class="col-md-3 mb-5">
                <ul class="list-unstyled link">
                    <li><a href="#">The Rooms &amp; Suites</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact Us</a></li>
                    <li><a href="#">Restaurant</a></li>
                </ul>
            </div>
            <div class="col-md-3 mb-5 pr-md-5 contact-info">
                <!-- <li>198 West 21th Street, <br> Suite 721 New York NY 10016</li> -->
                <p><span class="d-block"><span class="fa fa-map-marker h5 mr-3 text-primary"></span>Address:</span>
                    <span> 198 West 21th Street, <br> Suite 721 New York NY 10016</span></p>
                <p><span class="d-block"><span class="fa fa-phone h5 mr-3 text-primary"></span>Phone:</span> <span> (+1) 435 3533</span>
                </p>
                <p><span class="d-block"><span class="fa fa-envelope-o h5 mr-3 text-primary"></span>Email:</span> <span> info@domain.com</span>
                </p>
            </div>
            <div class="col-md-3 mb-5">
                <p>Sign up for our newsletter</p>
                <form action="#" class="footer-newsletter">
                    <div class="form-group">
                        <input type="email" class="form-control" placeholder="Email...">
                        <button type="submit" class="btn"><span class="fa fa-paper-plane"></span></button>
                    </div>
                </form>
            </div>
        </div>
        <div class="row pt-5">
            <p class="col-md-6 text-left">
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                All rights reserved | This template is made with <i class="icon-heart-o" aria-hidden="true"></i> by <a
                    href="https://colorlib.com" target="_blank">Colorlib</a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>

            <p class="col-md-6 text-right social">
                <a href="#"><span class="fa fa-tripadvisor"></span></a>
                <a href="#"><span class="fa fa-facebook"></span></a>
                <a href="#"><span class="fa fa-twitter"></span></a>
                <a href="#"><span class="fa fa-linkedin"></span></a>
                <a href="#"><span class="fa fa-vimeo"></span></a>
            </p>
        </div>
    </div>
</footer>
<script src="static/js/jquery-3.3.1.min.js"></script>
<script src="static/js/jquery-migrate-3.0.1.min.js"></script>
<script src="static/js/popper.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/owl.carousel.min.js"></script>
<script src="static/js/jquery.stellar.min.js"></script>
<script src="static/js/jquery.fancybox.min.js"></script>


<script src="static/js/aos.js"></script>

<script src="static/js/bootstrap-datepicker.js"></script>
<script src="static/js/jquery.timepicker.min.js"></script>


<script src="static/js/main.js"></script>
</body>
</html>