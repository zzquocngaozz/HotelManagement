<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 3/12/2023
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="site-header js-site-header">
    <div class="container-fluid">
        <div class="row align-items-center">
            <div class="col-6 col-lg-4 site-logo" data-aos="fade"><a href="home-page">Wogo Hotel</a></div>
            <div class="col-6 col-lg-8">


                <div class="site-menu-toggle js-site-menu-toggle" data-aos="fade">
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
                                        <li class="active"><a href="home-page">Home</a></li>
                                        <li><a href="home-page-room">Rooms</a></li>
                                        <c:if test="${sessionScope.user.userRole == 1}">
                                            <li><a href="home-dash-board">Dash board</a></li>
                                        </c:if>
                                        <c:if test="${sessionScope.user != null}">
                                            <li><a href="logout">Logout</a></li>
                                            <li><a href="home-page">${sessionScope.user.userName}</a></li>
                                        </c:if>
                                        <c:if test="${sessionScope.user == null}">
                                            <li><a href="login">Login</a></li>
                                        </c:if>
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
</body>
</html>
