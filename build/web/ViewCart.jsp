<%-- 
    Document   : ViewCart
    Created on : Aug 24, 2019, 3:04:06 AM
    Author     : Administrator
--%>
<jsp:include page="checkUser.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="racoon.dto.CartDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="racoon.dto.ServiceDTO"%>
<%@page import="racoon.dto.CartServiceObject"%>
<%@page import="racoon.dto.FoodingDTO"%>
<%@page import="racoon.dto.CartFoodingObject"%>


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
    <form action="MainController" method="POST">
        <c:set var="DTO" value="${sessionScope.MSG}"/>
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

        <section class="section blog-post-entry bg-light" id="next">
            <div class="sidenav">
                <h2 class="heading" data-aos="fade-up">${DTO}</h2>
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

            <h1 style="color: #0088cc; padding-left: 50%"> Your Food </h1>
            <c:set var="CARTFOOD" value="${sessionScope.LISTFCART}"/>
            <c:if test="${not empty CARTFOOD}">
                <table class="table table-striped" style="width: 70%; color: black; margin-left: 20%;">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Food</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="dto" items="${CARTFOOD}" varStatus="counter">
                        <form action="MainController" method="POST">


                            <tr>
                                <td> ${counter.count}</td>
                                <td>${dto.name}</td>
                                <td>
                                    <input type="hidden" name="idFood" value="${dto.id}"/>
                                    <input type="number" name="txtQuantityFood" value="${dto.quantityCart}"/>
                                </td>
                                <td>${dto.price}</td>
                                <td>

                                    <input type="submit" name="btnAction" class="btn btn-outline-success" value="New Food Quantity"/>
                                </td>
                                <td>

                                    <input type="submit" name="btnAction" class="btn btn-outline-danger" value="Delete Food from Cart"/>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>     

                    <c:set var="TOTALFOODPRICE" value="${sessionScope.TOTALFOOD}"/>
                    <tr>
                        <td colspan="3">Total</td>
                        <td> <input type="hidden" name="txtTotalFood" value="${TOTALFOODPRICE}" />
                            ${TOTALFOODPRICE}</td>
                    </tr>

                    </tbody>
                </table>

            </c:if>
            <hr>

            <h1 style="color: #0088cc; padding-left: 50%"> Your Service </h1>

            <c:set var="CARTSERVICE" value="${sessionScope.LISTSCART}"/>
            <c:if test="${not empty CARTSERVICE}">
                <table class="table table-striped" style="width: 70%; color: black; margin-left: 20%;">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ServiceID</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                    <form action="MainController" method="POST">

                        <c:forEach items="${CARTSERVICE}" var="dto" varStatus="counter">

                            <tr>

                                <td>${counter.count}</td>
                                <td>${dto.name}</td>
                                <td>
                                    <input type="hidden" name="txtIDService" value="${dto.id}"/>
                                    <input type="number" name="txtQuantityService" value="${dto.quantityCart}"/>
                                </td>
                                <td>
                                    ${dto.price}
                                </td>
                                <td>
                                    <input type="submit" name="btnAction" class="btn btn-outline-success" value="New service Quantity"/>
                                </td>
                                <td><input type="submit" name="btnAction" class="btn btn-outline-danger" value="Delete Service From Cart"/></td>
                            </tr>
                        </form>

                    </c:forEach>

                    <c:set var="TOTAL" value="${sessionScope.TOTALSERVICE}"/>

                    <tr>
                        <td colspan="3"> Total</td>


                        <td><input type="hidden" name="txtTotalService" value="${TOTAL}" />
                            ${TOTAL}
                        </td>

                    </tr>

                </table> 
            </c:if>

            <span style="padding-left: 50%;">Your Total Price for the service is:</span><span style="color: red; font-weight: bold;"> ${TOTALFOOD + TOTAL} USD</span>
            <input type="submit" name="btnAction" value="Take Order" class="btn btn-outline-info"/>

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
