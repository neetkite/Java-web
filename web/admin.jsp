<%-- 
    Document   : admin
    Created on : Aug 13, 2019, 2:25:50 PM
    Author     : Administrator
--%>
<jsp:include page="checkAdmin.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Administrator's work page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=|Roboto+Sans:400,700|Playfair+Display:400,700">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">
        <link rel="stylesheet" href="css/fancybox.min.css">

        <link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">
        <link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">

        <!-- Theme Style -->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <form action="MainController" method="POST">
            <header class="site-header js-site-header">
                <div class="container-fluid">
                    <div class="row align-items-center">
                        <div class="col-6 col-lg-4 site-logo" data-aos="fade"><a href="admin.jsp">Sogo Homestay</a></div>
                        <div class="col-6 col-lg-8">
                            <div class="site-menu-toggle js-site-menu-toggle"  data-aos="fade">
                                <span></span>
                                <span></span>
                                <span></span>
                            </div>
                            <!-- END menu-toggle -->


                            <div class="site-navbar js-site-navbar">
                                <nav role="navigation">
                                    <div class="container">
                                        <div class="row full-height align-items-center">
                                            <div class="col-md-6 mx-auto">
                                                <ul class="list-unstyled menu">
                                                    <li class="active"><a href="admin.jsp">Home</a></li>
                                                <li><a href="MainController?btnAction=Logout">Sign Out</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </nav>
                            </div>

                        </div>
                    </div>
                </div>
            </header>



            <section class="site-hero overlay" style="background-image: url(images/hero_4.jpg)" data-stellar-background-ratio="0.5">
                <div class="container">
                    <div class="row site-hero-inner justify-content-center align-items-center">
                        <div class="col-md-10 text-center" data-aos="fade-up">

                            <span class="custom-caption text-uppercase text-white d-block  mb-3">Have a nice work's day</span>
                            <h1 class="heading" style="color: #d1ecf1">Mr.${sessionScope.ADMIN}</h1>
                        </div>
                    </div>
                </div>

                <a class="mouse smoothscroll" href="#next">
                    <div class="mouse-icon">
                        <span class="mouse-wheel"></span>
                    </div>
                </a>
            </section>


            <section class="section">
                <div class="container">

                    <div class="row">
                        <div class="col-md-6 col-lg-4 mb-5" data-aos="fade-up">
                            <a href="MainController?btnAction=CustomerModify" class="room">
                                <figure class="img-wrap">
                                    <img src="images/img_1.jpg" alt="Free website template" class="img-fluid mb-3">
                                </figure>
                                <div class="p-3 text-center room-info">
                                    <h2>Customer Information</h2>
                                    <span class="text-uppercase letter-spacing-1">Modify the customer's information</span>
                                </div>
                                
                            </a>
                        </div>

                        <div class="col-md-6 col-lg-4 mb-5" data-aos="fade-up">
                            <a href="MainController?btnAction=OrderModify" class="room">
                                <figure class="img-wrap">
                                    <img src="images/img_2.jpg" alt="Free website template" class="img-fluid mb-3">
                                </figure>
                                <div class="p-3 text-center room-info">
                                    <h2>Order Information</h2>
                                    <span class="text-uppercase letter-spacing-1">Modify the order's information</span>
                                </div>
                            </a>
                        </div>

                        <div class="col-md-6 col-lg-4 mb-5" data-aos="fade-up">
                            <a href="MainController?btnAction=ServiceModify" class="room">
                                <figure class="img-wrap">
                                    <img src="images/img_3.jpg" alt="Free website template" class="img-fluid mb-3">
                                </figure>
                                <div class="p-3 text-center room-info">
                                    <h2>Services Information</h2>
                                    <span class="text-uppercase letter-spacing-1">Modify the Service's information</span>
                                </div>
                            </a>
                        </div>

                        <div class="col-md-6 col-lg-4 mb-5" data-aos="fade-up">
                            <a href="MainController?btnAction=FoodingModify" class="room">
                                <figure class="img-wrap">
                                    <img src="images/img_1.jpg" alt="Free website template" class="img-fluid mb-3">
                                </figure>
                                <div class="p-3 text-center room-info">
                                    <h2>Food/Drink Information</h2>
                                    <span class="text-uppercase letter-spacing-1">Modify Food/Drink's Information</span>
                                </div>
                            </a>
                        </div>

                        <div class="col-md-6 col-lg-4 mb-5" data-aos="fade-up">
                            <a href="MainController?btnAction=RoomModify" class="room">
                                <figure class="img-wrap">
                                    <img src="images/img_2.jpg" alt="Free website template" class="img-fluid mb-3">
                                </figure>
                                <div class="p-3 text-center room-info">
                                    <h2>Room's information</h2>
                                    <span class="text-uppercase letter-spacing-1">Room's Information</span>
                                </div>
                            </a>
                        </div>

                        <div class="col-md-6 col-lg-4 mb-5" data-aos="fade-up">
                            <a href="#" class="room">
                                <figure class="img-wrap">
                                    <img src="images/img_3.jpg" alt="Free website template" class="img-fluid mb-3">
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
                            <p><span class="d-block"><span class="ion-ios-location h5 mr-3 text-primary"></span>Address:</span> <span> 198 West 21th Street, <br> Suite 721 New York NY 10016</span></p>
                            <p><span class="d-block"><span class="ion-ios-telephone h5 mr-3 text-primary"></span>Phone:</span> <span> (+1) 435 3533</span></p>
                            <p><span class="d-block"><span class="ion-ios-email h5 mr-3 text-primary"></span>Email:</span> <span> info@domain.com</span></p>
                        </div>

                    </div>
                    <div class="row pt-5">
                        <p class="col-md-6 text-left">
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
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


        </form>


        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/jquery.fancybox.min.js"></script>


        <script src="js/aos.js"></script>

        <script src="js/bootstrap-datepicker.js"></script> 
        <script src="js/jquery.timepicker.min.js"></script> 



        <script src="js/main.js"></script>
    </body>
</html>