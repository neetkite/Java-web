<%-- 
    Document   : Service
    Created on : Aug 23, 2019, 9:23:50 PM
    Author     : Administrator
--%>
<jsp:include page="checkUser.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Service Menu</title>
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <!-- Theme Style -->
        <link rel="stylesheet" href="css/style.css"> 
        <style>
            .sidenav {
                height: 100%;
                width: 200px;
                position: absolute;
                z-index: 1;
                top: 0;
                left: 0;
                background-color: #111;
                overflow-x: hidden;
                padding-top: 20px

            }

            /* Style the sidenav links and the dropdown button */
            .sidenav a, .dropdown-btn {
                padding: 6px 8px 6px 16px;
                text-decoration: none;
                font-size: 20px;
                color: #818181;
                display: block;
                border: none;
                background: none;
                width:100%;
                text-align: left;
                cursor: pointer;
                outline: none;
            }

            /* On mouse-over */
            .sidenav a:hover, .dropdown-btn:hover {
                color: #f1f1f1;
            }

            /* Main content */
            .main {
                margin-left: 200px; /* Same as the width of the sidenav */
                font-size: 20px; /* Increased text to enable scrolling */
                padding: 0px 10px;
            }

            /* Add an active class to the active dropdown button */
            .active {
                background-color: green;
                color: white;
            }

            /* Dropdown container (hidden by default). Optional: add a lighter background color and some left padding to change the design of the dropdown content */
            .dropdown-container {
                display: none;
                background-color: #262626;
                padding-left: 8px;
            }

            /* Optional: Style the caret down icon */
            .fa-caret-down {
                float: right;
                padding-right: 8px;
            }
        </style>

    </head>
    <body>
        <form action="/Homestay/MainController" method="POST">

            <header class="site-header js-site-header">
                <div class="container-fluid">
                    <div class="row align-items-center">
                        <div class="col-6 col-lg-4 site-logo" data-aos="fade"><a href="customer.jsp">Sogo Homestay</a></div>
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
                                                <li class="active"><a href="Service.jsp">Home</a></li>
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

                            <span class="custom-caption text-uppercase text-white d-block  mb-3">Get some stuff for your vacation, Mr/Mrs.</span>
                            <h1 class="heading" style="color: #d1ecf1">${sessionScope.FULLNAME}</h1>
                        </div>
                    </div>
                </div>

                <a class="mouse smoothscroll" href="#next">
                    <div class="mouse-icon">
                        <span class="mouse-wheel"></span>
                    </div>
                </a>
            </section>
            <c:set var="DTO" value="${sessionScope.MSG}"/>
            <section class="section slider-section bg-light">
                <div class="container">
                    <div class="row justify-content-center text-center mb-5">
                        <div class="col-md-7">
                            <h2 class="heading" style="color: orange; font-family: cursive" data-aos="fade-up">${DTO}</h2>
                            <p data-aos="fade-up" data-aos-delay="100">Images</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="home-slider major-caousel owl-carousel mb-5" data-aos="fade-up" data-aos-delay="200">
                                <div class="slider-item">
                                    <a href="images/slider-1.jpg" data-fancybox="images" data-caption="Caption for this image"><img src="images/slider-1.jpg" alt="Image placeholder" class="img-fluid"></a>
                                </div>
                                <div class="slider-item">
                                    <a href="images/slider-2.jpg" data-fancybox="images" data-caption="Caption for this image"><img src="images/slider-2.jpg" alt="Image placeholder" class="img-fluid"></a>
                                </div>
                                <div class="slider-item">
                                    <a href="images/slider-3.jpg" data-fancybox="images" data-caption="Caption for this image"><img src="images/slider-3.jpg" alt="Image placeholder" class="img-fluid"></a>
                                </div>
                                <div class="slider-item">
                                    <a href="images/slider-4.jpg" data-fancybox="images" data-caption="Caption for this image"><img src="images/slider-4.jpg" alt="Image placeholder" class="img-fluid"></a>
                                </div>
                                <div class="slider-item">
                                    <a href="images/slider-5.jpg" data-fancybox="images" data-caption="Caption for this image"><img src="images/slider-5.jpg" alt="Image placeholder" class="img-fluid"></a>
                                </div>
                                <div class="slider-item">
                                    <a href="images/slider-6.jpg" data-fancybox="images" data-caption="Caption for this image"><img src="images/slider-6.jpg" alt="Image placeholder" class="img-fluid"></a>
                                </div>
                                <div class="slider-item">
                                    <a href="images/slider-7.jpg" data-fancybox="images" data-caption="Caption for this image"><img src="images/slider-7.jpg" alt="Image placeholder" class="img-fluid"></a>
                                </div>
                            </div>
                            <!-- END slider -->
                        </div>

                    </div>
                </div>
            </section>
            <section class="section blog-post-entry bg-light" id="next">
                <c:set var="Mess" value="${requestScope.ORDERSUC}"/>
                <c:if test="${not empty Mess}">
                    <font style="margin-left: 20%;" class="aos-animate">
                    ${Mess}
                    </font>
                </c:if>
                <div class="sidenav">
                    <a href="Service.jsp">Room: ${DTO}</a>
                    <a href="MainController?btnAction=ServiceUser">Services</a>
                    <div class="dropdown-btn">Restaurant 
                        <i class="fa fa-caret-down"></i>
                    </div>
                    <div class="dropdown-container" style="color: whitesmoke">
                        <a href="MainController?btnAction=FoodyUser">Foody</a>
                        <a href="MainController?btnAction=DrinkyUser">Drinky</a>
                    </div>
                    <a href="MainController?btnAction=ShowCart">Show your bill</a>

                </div>

                <c:set var="LIST" value="${requestScope.LIST}"/>
                <c:set var="LISTSERVICE" value="${requestScope.LISTSERVICE}"/>
                <c:if test="${not empty LIST}">
                    <div class="sidenav">
                        <a href="Service.jsp">Room: ${DTO}</a>
                        <a href="MainController?btnAction=ServiceUser">Services</a>
                        <div class="dropdown-btn">Restaurant 
                            <i class="fa fa-caret-down"></i>
                        </div>
                        <div class="dropdown-container" style="color: whitesmoke">
                            <a href="MainController?btnAction=FoodyUser">Foody</a>
                            <a href="MainController?btnAction=DrinkyUser">Drinky</a>
                        </div>
                        <a href="MainController?btnAction=ShowCart">Show your Cart</a>

                    </div>


                    <div class="container" style="padding-left: 10%">
                        <div class="row">
                            <c:forEach var="dto" items="${LIST}">

                                <div class="col-lg-4 col-md-6 col-sm-6 col-12 post mb-5" data-aos="fade-up" data-aos-delay="100">

                                    <div class="media media-custom d-block mb-4 h-100">
                                        <img src="${dto.img}" alt="Image placeholder" class="img-fluid">
                                        <div class="media-body">
                                            <span class="meta-post">Price: ${dto.price}</span>
                                            <h2 class="mt-0 mb-3">${dto.name}</h2>
                                            <p>${dto.des}</p>
                                            <form action="MainController" method="POST">
                                                <input type="hidden" name="price" value="${dto.price}"/>
                                                <input type="hidden" name="prodID" value="${dto.id}"/>
                                                <input type="submit" name="btnAction" value="Get this Food" class="btn btn-success" />
                                            </form>
                                        </div>
                                    </div>

                                </div>

                            </c:forEach>

                        </div>
                    </div>

                </c:if>

                <c:if test="${not empty LISTSERVICE}">
                    <div class="sidenav">
                        <a href="Service.jsp">Room: ${DTO}</a>
                        <a href="MainController?btnAction=YourRoomInformation">Your Room</a>
                        <a href="MainController?btnAction=ServiceUser">Services</a>
                        <div class="dropdown-btn">Restaurant 
                            <i class="fa fa-caret-down"></i>
                        </div>
                        <div class="dropdown-container" style="color: whitesmoke">
                            <a href="MainController?btnAction=FoodyUser">Foody</a>
                            <a href="MainController?btnAction=DrinkyUser">Drinky</a>
                        </div>
                        <a href="MainController?btnAction=ShowCart">Show your Cart</a>

                    </div>
                    <div class="container" style="padding-left: 10%">
                        <div class="row">
                            <c:forEach var="dto" items="${LISTSERVICE}">

                                <div class="col-lg-4 col-md-6 col-sm-6 col-12 post mb-5" data-aos="fade-up" data-aos-delay="100">

                                    <div class="media media-custom d-block mb-4 h-100">
                                        <img src="${dto.img}" alt="Image placeholder" class="img-fluid">
                                        <div class="media-body">
                                            <span class="meta-post">Price: ${dto.price}</span>
                                            <h2 class="mt-0 mb-3">${dto.name}</h2>
                                            <p>${dto.des}</p>
                                            <form action="MainController" method="POST">
                                                <input type="hidden" name="price" value="${dto.price}"/>
                                                <input type="hidden" name="prodID" value="${dto.id}"/>
                                                <input type="submit" name="btnAction" value="Get this Service" class="btn btn-success" />
                                            </form>
                                        </div>
                                    </div>

                                </div>

                            </c:forEach>

                        </div>
                    </div>

                </c:if>


            </section>
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


        <script>
            var dropdown = document.getElementsByClassName("dropdown-btn");
            var i;

            for (i = 0; i < dropdown.length; i++) {
                dropdown[i].addEventListener("click", function () {
                    this.classList.toggle("active");
                    var dropdownContent = this.nextElementSibling;
                    if (dropdownContent.style.display === "block") {
                        dropdownContent.style.display = "none";
                    } else {
                        dropdownContent.style.display = "block";
                    }
                });
            }
        </script>
    </body>
</html>
