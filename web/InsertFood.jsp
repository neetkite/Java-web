<%-- 
    Document   : InsertFood
    Created on : Aug 20, 2019, 1:03:04 PM
    Author     : Administrator
--%>
<jsp:include page="checkAdmin.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Insert Food</title>
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
                        <div class="bg-white p-md-5 p-4 mb-5 border">
                            <form action="MainController" method="POST" >
                                <c:set var="error" value="${requestScope.ERROR}"/>
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <label class="text-black font-weight-bold" for="name">Food ID</label>
                                        <input type="text" id="name" name="txtID" value="" class="form-control" />
                                        <c:if test="${not empty error}">
                                            <font style="color: red">
                                            ${error.idError}
                                            </font>
                                        </c:if>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label class="text-black font-weight-bold" for="phone">Name</label>
                                        <input type="text" id="phone" name="txtName" value="" class="form-control"/>
                                        <c:if test="${not empty error}">
                                            <font style="color: red">
                                            ${error.nameError}
                                            </font>
                                        </c:if>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <label class="text-black font-weight-bold" for="email">Price</label>
                                        <input type="number" step="0.01" id="email" name="txtPrice" value="" class="form-control" required="" />
                                        <c:if test="${not empty error}">
                                            <font style="color: red">
                                            ${error.priceError}
                                            </font>
                                        </c:if>
                                    </div>
                                </div>

                                <div class="row mb-4">
                                    <div class="col-md-12 form-group">
                                        <label class="text-black font-weight-bold" for="message">Quantity</label>
                                        <input type="number" name="txtQuantity" value="" id="message" class="form-control" cols="30" rows="8" required=""/>
                                        <c:if test="${not empty error}">
                                            <font style="color: red">
                                            ${error.QuantityError}
                                            </font>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="row mb-4">
                                    <div class="col-md-12 form-group">
                                        <label class="text-black font-weight-bold" for="message">Description</label>
                                        <input type="text" name="txtDes" value="" id="message" class="form-control" cols="30" rows="8"/>
                                    </div>
                                </div>

                                <div class="row mb-4">
                                    <div class="col-md-12 form-group">
                                        <label class="text-black font-weight-bold" for="message">Type</label>
                                        <select name="cboType">
                                            <option>Foody</option>
                                            <option>Drinky</option>
                                        </select>
                                    </div>
                                </div>
                                
                                 <div class="row mb-4">
                                    <div class="col-md-12 form-group">
                                        <label class="text-black font-weight-bold" for="message">Image</label>
                                        <input type="file" name="txtImg" value="" id="message" accept="images/" class="form-control" cols="30" rows="8"/>
                                      
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-md-6 form-group">         
                                        <input type="submit" value="Insert Foody" name="btnAction" class="btn btn-primary text-white py-3 px-5 font-weight-bold">
                                    </div>
                                </div>
                            </form>
                        </div>
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