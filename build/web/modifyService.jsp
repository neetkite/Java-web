<%-- 
    Document   : modifyService
    Created on : Aug 15, 2019, 5:07:55 PM
    Author     : Administrator
--%>
<jsp:include page="checkAdmin.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Modify Customer's Information</title>
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
            div.gallery {
                margin: 5px;
                border: 2px solid #ccc;
                float: left;
                width: 200px;
                height: 300px;
                padding-bottom: 20px;
                border-radius: 10px;
            }

            div.gallery:hover {
                z-index: 2;
                border: 2px solid #007bff;
                
            }

            div.gallery img {
                width: 100%;
                height: 55%;
            }

            div.desc {
                padding: 2px;
                text-align: center;
                color: tomato;
                font-size: 15px;
            }
        </style>
    </head>
    <body>
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
                                                <li><a href="MainController?btnAction=Logout">Sign out</a></li>
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
                        <h1 class="heading" style="color: #383d41">Modify the Service</h1>
                        <span class="custom-caption text-uppercase text-white d-block  mb-3">All the Service</span>
                    </div>
                </div>
            </div>
        </section> 


        <section class="section">  
            <div class="col-md-6 col-lg-4 mb-5" data-aos="fade-up">
                <figure class="img-wrap">
                    <img src="images/img_1.jpg" alt="Free website template" class="img-fluid mb-3">
                </figure>
                <div class="p-3 text-center room-info">
                    <h2>Service Information</h2>
                    <span class="text-uppercase letter-spacing-1">Modify the Service's information</span>
                </div>
            </div>
            <form action="MainController" method="POST">
                <input type="text" name="txtSearch" value="" style=" border-radius: 10px; border-color: blue"/> &emsp; 
                <input type="submit" name="btnAction" value="Search Service"  class="btn btn-primary text-white py-3 px-5 font-weight-bold"/>
                <div style="float: right"> <input type="submit" name="btnAction" value="Insert more service" /></div>
                <div>
                    <c:set var="SEARCH" value="${param.txtSearch}"/>
                    <c:if test="${not empty SEARCH}">
                        <c:set var="LIST" value="${requestScope.RESULT}"/>
                        <c:if test="${not empty LIST}">
                            <c:forEach items="${LIST}" var="dto">
                                <div class="gallery" style="width: 20%">

                                    <img src="images/${dto.img}" alt="Cinque Terre" width="600" height="400">

                                    <div class="desc">${dto.name}</div>
                                    Price: <span style="font-style: inherit; font-size: 20px; color: green"> ${dto.price} USD</span>
                                    <br><span style="font-size: 10px;color: #212529"> ${dto.des}</span>

                                    <br>
                                    <c:url var="DeleteLink" value="${MainController}">
                                        <c:param name="btnAction" value="Delete this Service"/>
                                        <c:param name="id" value="${dto.id}"/>
                                        <c:param name="txtSearch" value="${param.txtSearch}"/>
                                    </c:url>
                                    <a href="${DeleteLink}" style="width: 50%">Delete this Service</a>

                                    <form   style="float: right; padding-right: 10px; color: black; font-family: cursive;" action="MainController" method="POST">
                                        <input type="hidden" name="id" value="${dto.id}" />
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                        <input style="height: 30px; " type="submit" name="btnAction" value="Edit this Service"/>
                                    </form>

                                </div>
                            </c:forEach>
                        </c:if>
                    </c:if>
                    <c:set var="LIST" value="${requestScope.DTO}"/>
                    <c:if test="${not empty LIST}">
                        <c:forEach items="${LIST}" var="dto">
                            <div class="gallery" style="width: 20%">
                                <img src="images/${dto.img}" alt="Cinque Terre" width="600" height="400">
                                <div class="desc">${dto.name}</div>
                                Price: <span style="font-style: inherit; font-size: 20px; color: green"> ${dto.price} USD</span>
                                <br><span style="font-size: 10px;color: #212529"> ${dto.des}</span>

                                <br>
                                <c:url var="DeleteLink" value="${MainController}">
                                    <c:param name="btnAction" value="Delete this Service"/>
                                    <c:param name="id" value="${dto.id}"/>
                                    <c:param name="txtSearch" value="${param.txtSearch}"/>
                                </c:url>
                                <a href="${DeleteLink}" style="width: 50%; font-size: 12px;">Delete this Service</a>

                                <form  style="float: right; padding-right: 10px; border-radius: 5px; color: black; font-family: cursive;" action="MainController" method="POST">
                                    <input type="hidden" name="id" value="${dto.id}" />
                                    <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                    <input style="height: 30px; " type="submit" name="btnAction" value="Edit this Service"/>
                                </form>

                            </div>
                        </c:forEach>
                    </c:if>
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
