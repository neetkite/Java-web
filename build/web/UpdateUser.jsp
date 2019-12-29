<%-- 
    Document   : UpdateUser
    Created on : Aug 15, 2019, 3:13:03 PM
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
        <title>Update Account</title>
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
                    <div class="col-6 col-lg-4 site-logo" data-aos="fade"><a href="admin/admin.jsp">Sogo Homestay</a></div>
                    <div class="col-6 col-lg-8">
                        <div class="site-menu-toggle js-site-menu-toggle"  data-aos="fade">
                            <span></span>
                            <span></span>
                            <span></span>
                        </div>


                        <div class="site-navbar js-site-navbar">
                            <nav role="navigation">
                                <div class="container">
                                    <div class="row full-height align-items-center">
                                        <div class="col-md-6 mx-auto">
                                            <ul class="list-unstyled menu">
                                                <li class="active"><a href="admin.jsp">Home</a></li>
                                                <li><a href="MainController?btnAction=Logout">Rooms</a></li>
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


        <section class="section contact-section" id="next">
            <div class="container">
                <div class="row">
                    <div class="col-md-7" data-aos="fade-up" data-aos-delay="100">

                        <form action="MainController" method="post" class="bg-white p-md-5 p-4 mb-5 border">
                            <c:set var="dto" value="${requestScope.DTO}"/>
                            <c:set var="error" value="${requestScope.ERROR}"/>
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <label class="text-black font-weight-bold" for="name">Username</label>
                                    <input type="text" id="name" name="txtUsername" value="${dto.username}" class="form-control" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label class="text-black font-weight-bold" for="phone">Age</label>
                                    <input type="name" id="phone" name="txtAge" value="${dto.age}" class="form-control ">
                                    <c:if test="${not empty error}">
                                        <font style="color: red">
                                            ${error.ageError}
                                        </font>
                                    </c:if>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12 form-group">
                                    <label class="text-black font-weight-bold" for="email">Full name</label>
                                    <input type="text" id="email" name="txtFullname" value="${dto.fullname}" class="form-control ">
                                    <c:if test="${not empty error}">
                                        <font style="color: red">
                                            ${error.fullnameError}
                                        </font>
                                    </c:if>
                                </div>
                            </div>

                            <div class="row mb-4">
                                <div class="col-md-12 form-group">
                                    <label class="text-black font-weight-bold" for="message">Address</label>
                                    <input name="txtAddress" value="${dto.address}" id="message" class="form-control" cols="30" rows="8"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <input type="submit" value="Update" name="btnAction" class="btn btn-primary text-white py-3 px-5 font-weight-bold">
                                </div>
                            </div>
                        </form>

                    </div>
                    <div class="col-md-5" data-aos="fade-up" data-aos-delay="200">
                        <div class="row">
                            <div class="col-md-10 ml-auto contact-info">
                                <p><span class="d-block">Address:</span> <span class="text-black"> 98 West 21th Street, Suite 721 New York NY 10016</span></p>
                                <p><span class="d-block">Phone:</span> <span class="text-black"> (+1) 435 3533</span></p>
                                <p><span class="d-block">Email:</span> <span class="text-black"> info@yourdomain.com</span></p>
                            </div>
                        </div>
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
