<%-- 
    Document   : customer
    Created on : Aug 22, 2019, 12:33:31 PM
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
        <title>Sogo Welcome </title>
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
                        <div class="col-6 col-lg-4 site-logo" data-aos="fade" style="font-weight: bold; font-size: 50px;">Sogo Homestay</div>
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
                                                <li class="active"><a href="customer.jsp">Home</a></li>
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

                            <span class="custom-caption text-uppercase text-white d-block  mb-3">Glad to see you, Mr/Mrs.</span>
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
        </form>

        <section class="section bg-light pb-0"  >
            <div class="container">

                <div class="row check-availabilty" id="next">
                    <div class="block-32" data-aos="fade-up" data-aos-offset="-200">

                        <form action="MainController">
                            <div class="row">

                                <c:set var="list" value="${requestScope.LIST}"/>
                                <c:if test="${not empty list}">
                                    <section>
                                        <c:forEach var="dto" items="${list}">
                                            <div class="col-md-6 col-lg-4" data-aos="fade-up" style="float: left; width: 400px; height: 400px">
                                                <c:url var="getLink" value="${MainController}">
                                                    <c:param name="id" value="${dto.id}"/>
                                                    <c:param name="btnAction" value="RoomDetails"/>
                                                </c:url>

                                                <a href="${getLink}" class="room">

                                                    <figure class="img-wrap" style="height: 50%;">
                                                        <img src="images/${dto.img}" alt="Free website template" class="img-fluid mb-3" >
                                                    </figure>
                                                    <div class="p-3 text-center room-info">
                                                        <h2>${dto.id}</h2>
                                                        <span class="text-uppercase letter-spacing-1">$ ${dto.price}/night</span>
                                                    </div>
                                                </a>
                                            </div>
                                        </c:forEach>
                                    </section>

                                </c:if>



                            </div>
                        </form>
                    </div>


                </div>
            </div>
        </section>





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
