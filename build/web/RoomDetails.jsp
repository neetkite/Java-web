<%-- 
    Document   : RoomDetails
    Created on : Aug 23, 2019, 2:34:08 PM
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

                            <span class="custom-caption text-uppercase text-white d-block  mb-3">Get your room,please Mr/Mrs.</span>
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


        <section class="section contact-section" id="next">
            <form action="MainController" method="POST" >
                <div class="container">
                    <div class="row">
                        <div class="col-md-7" data-aos="fade-up" data-aos-delay="100">
                            <div class="bg-white p-md-5 p-4 mb-5 border">

                                <c:set var="dto" value="${requestScope.DTO}"/>
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <label class="text-black font-weight-bold" for="name">Room number</label>
                                        <input type="text" id="name" name="txtID" value="${dto.id}" readonly="" class="form-control" />

                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label class="text-black font-weight-bold" for="phone">Type</label>
                                        <c:if test="${dto.type eq true}">
                                            <input type="text" id="phone" name="txtType" value="Duo" readonly="" class="form-control"/>
                                        </c:if>
                                        <c:if test="${dto.type eq false}">
                                            <input type="text" id="phone" name="txtType" value="Single" readonly="" class="form-control"/>
                                        </c:if>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <label class="text-black font-weight-bold" for="email">Price per night</label>
                                        <input type="number" step="0.01" id="email" name="txtPrice" value="${dto.price}" style="width: 20%;"class="form-control" readonly="" />
                                    </div>
                                </div>


                                <div class="row mb-4">
                                    <div class="col-md-12 form-group">
                                        <label class="text-black font-weight-bold" for="message">Description</label>
                                        <input type="text" name="txtDes" value="${dto.des}" id="message" class="form-control" cols="30" rows="8" readonly=""/>
                                    </div>
                                </div>

                                    <input type="hidden" name="id" value="${dto.id}"/>
                            </div>
                        </div>
                        <div class="col-md-5" data-aos="fade-up" data-aos-delay="200">
                            <div class="row">
                                <div class="col-md-10 ml-auto contact-info" style="border: black">
                                    <img src="${dto.img}" style="width: 460px; height: 300px">
                                </div>
                            </div>
                                    <c:set var="error" value="${requestScope.MSG}"/>
                            <div class="row">
                                <div style="margin-left: 10%; padding-top: 20px; float: left;color: black; font-family: cursive ">
                                    <div>
                                        Date checkin: <input style="margin-left: 3%;" type="date" class="date datepicker" value="" name="dateIn" required=""/>
                                    </div>
                                    <div style="padding-top: 2%">
                                        Date checkout: <input type="date" class="date datepicker" value="" name="dateOut" required=""/>
                                    </div>
                                    <input style="margin-top: 3%" type="submit" class="btn btn-danger" name="btnAction" value="Check this room"/>
                                    <c:if test="${not empty error}">
                                    <font style="color: red">
                                        ${error}
                                    </font>
                                </c:if>
                                </div>
                                
                            </div>
                        </div>

                    </div>
                </div>
            </form>
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
