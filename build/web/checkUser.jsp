<%-- 
    Document   : checkUser
    Created on : Aug 25, 2019, 12:24:55 PM
    Author     : Administrator
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <c:if test="${sessionScope.FULLNAME == null}">
             
            <jsp:forward page="Welcome.jsp"/>
        </c:if>
    </body>
</html>
