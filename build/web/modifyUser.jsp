<%-- 
    Document   : modifyUser
    Created on : Aug 14, 2019, 3:08:03 PM
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
                        <h1 class="heading" style="color: #383d41">Modify the Customer</h1>
                        <span class="custom-caption text-uppercase text-white d-block  mb-3">List Customer has Registered</span>
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
            <div class="col-md-6 col-lg-4 mb-5" data-aos="fade-up">
                <figure class="img-wrap">
                    <img src="images/img_1.jpg" alt="Free website template" class="img-fluid mb-3">
                </figure>
                <div class="p-3 text-center room-info">
                    <h2>Customer Information</h2>
                    <span class="text-uppercase letter-spacing-1">Modify the customer's information</span>
                </div>
            </div>
            <form action="MainController" method="POST">
                <input type="text" name="txtSearch" value="" style=" border-radius: 10px; border-color: blue"/> &emsp; 
                <input type="submit" name="btnAction" value="Search"  class="btn btn-primary text-white py-3 px-5 font-weight-bold"/>
                <c:set var="searchValue" value="${param.txtSearch}"/>

                <c:set var="dto" value="${requestScope.RESULT}"/>
                <c:if test="${not empty dto}">
                    <table class="table table-striped" style="width: 60%; color: black;">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Username</th>
                                <th>Role</th>
                                <th>Age</th>
                                <th>Address</th>
                                <th>Full name</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${dto}" var="o" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${o.username}</td>
                                    <td>${o.role}</td>
                                    <td>${o.age}</td>
                                    <td>${o.address}</td>
                                    <td>${o.fullname}</td>
                                    <td>
                                        <c:url var="DeleteLink" value="${MainController}">
                                            <c:param name="btnAction" value="x"/>
                                            <c:param name="id" value="${o.username}"/>
                                            <c:param name="txtSearch" value="${param.txtSearch}"/>
                                        </c:url>
                                        <a href="${DeleteLink}">x</a>
                                    </td>
                                    <td>
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="id" value="${o.username}"/>
                                            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                            <input type="submit" name="btnAction" value="Edit"/>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </c:if>

                <c:set var="list" value="${requestScope.LISTUSER}"/>
                <c:if test="${not empty list}">
                    <table class="table table-striped" style="width: 60%; color: black;">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Username</th>
                                <th>Role</th>
                                <th>Age</th>
                                <th>Address</th>
                                <th>Full name</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="dto" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${dto.username}</td>
                                    <td>${dto.role}</td>
                                    <td>${dto.age}</td>
                                    <td>${dto.address}</td>
                                    <td>${dto.fullname}</td>
                                    <td>
                                        <c:url var="DeleteLink" value="${MainController}">
                                            <c:param name="btnAction" value="x"/>
                                            <c:param name="id" value="${dto.username}"/>
                                            <c:param name="txtSearch" value="${param.txtSearch}"/>
                                        </c:url>
                                        <a href="${DeleteLink}">x</a>
                                    </td>
                                    <td>
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="id" value="${dto.username}"/>
                                            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                            <input type="submit" name="btnAction" value="Edit"/>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </c:if>
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
