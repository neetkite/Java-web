<%-- 
    Document   : Welcome
    Created on : Aug 25, 2019, 12:15:54 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Sogo Homestay</title>
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
        <style>

            input[type=submit]{
                border-radius: 40%;
                font-family: cursive;
                color: #f0f0f0;
                background-color: black;
            }

        </style>
    </head>
    <body>
        <header class="site-header js-site-header">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-6 col-lg-4 site-logo" data-aos="fade"><a href="Welcome.html">Sogo Homestay</a></div>
                </div>
            </div>
        </header>
        <!-- END head -->

        <section class="site-hero overlay" style="background-image: url(images/hero_4.jpg)" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="row site-hero-inner justify-content-center align-items-center">
                    <div class="col-md-10 text-center" data-aos="fade-up">
                        <span class="custom-caption text-uppercase text-white d-block  mb-3">Welcome To Sogo  Homestay</span>
                        <h1 class="heading">A Best Place To Stay</h1>
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

        <section class="section bg-light pb-0"  >
            <div class="container">

                <div class="row check-availabilty" id="next" style="padding-left: 30%;">
                    <div class="block-32" data-aos="fade-up" data-aos-offset="-200" style=";width: 60%; padding-left: 5%">

                        <form action="MainController" method="POST">

                            <span style="color: black; font-family: cursive">Username:</span> <input style="width: 100%" type="text" name="txtUsername" value="" />
                            <hr>
                            <span style="color: black; font-family: cursive">Password:</span>  <input style="width: 100%" type="password" name="txtPassword" value=""/>
                            <br><br>
                            <input  style="margin-right: 2%; margin-left: 10%;" type="submit" name="btnAction" value="Login"/>
                            <span style="color: black; font-family: cursive">Or</span> 
                            <input style="margin-left: 2%" type="submit" name="btnAction" value="Register for more offer" /> 
                        </form>
                    </div>
                </div>
            </div>
        </section>


        <!-- END section -->
        <section class="section bg-image overlay" style="background-image: url('images/hero_4.jpg');">
            <div class="container" >
                <div class="row align-items-center">
                    <div class="col-12 col-md-6 text-center mb-4 mb-md-0 text-md-left" data-aos="fade-up">
                        <h2 class="text-white font-weight-bold">A Best Place To Stay. Register Now</h2>
                    </div>
                    <div class="col-12 col-md-6 text-center text-md-right" data-aos="fade-up" data-aos-delay="200">
                        
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
