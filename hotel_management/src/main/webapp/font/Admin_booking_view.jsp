<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <jsp:include page="/common/css_header.jsp"></jsp:include>
</head>
<body class=" color-light ">
<!-- loader Start -->
<div id="loading">
    <div id="loading-center">
    </div>
</div>
<!-- loader END -->
<!-- Wrapper Start -->
<div class="wrapper">

    <jsp:include page="/common/header.jsp"></jsp:include>
    <div class="content-page">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="card card-block card-stretch card-height">
                        <div class="card-header d-flex justify-content-between">
                            <div class="iq-header-title">
                                <h4 class="card-title mb-0">View bill Room</h4>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table" style="width:100%">
                                    <thead>
                                    <tr>
                                        <th style="text-align: center">No.</th>
                                        <th style="text-align: center">Room Code</th>
                                        <th style="text-align: center">Price Per Hour</th>
                                        <th style="text-align: center">Hour in</th>
                                        <th style="text-align: center">Price</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td style="text-align: center">1</td>
                                        <td style="text-align: center">H112R</td>
                                        <td style="text-align: center">120</td>
                                        <td style="text-align: center">10</td>
                                        <td style="text-align: center">1200</td>
                                        <th style="text-align: left">$</th>
                                    </tr>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                        <th style="text-align: center">Subtotal :</th>
                                        <th style="text-align: center">1200</th>
                                        <th style="text-align: left">$</th>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>

<%--                <div class="col-lg-12">--%>
<%--                    <div class="card card-block card-stretch card-height">--%>
<%--                        <div class="card-header d-flex justify-content-between">--%>
<%--                            <div class="iq-header-title">--%>
<%--                                <h4 class="card-title mb-0">View bill Service</h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="card-body">--%>
<%--                            <div class="table-responsive">--%>
<%--                                <table class="table" style="width:100%">--%>
<%--                                    <thead>--%>
<%--                                    <tr>--%>
<%--                                        <th style="text-align: center">No.</th>--%>
<%--                                        <th style="text-align: center">Item Description</th>--%>
<%--                                        <th style="text-align: center">Price</th>--%>
<%--                                    </tr>--%>
<%--                                    </thead>--%>
<%--                                </table>--%>
<%--                            </div>--%>

<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>
</div>
<!-- Wrapper End-->

<!-- Modal list start -->
<footer class="iq-footer">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">
            </div>
            <div class="col-lg-6 text-right">
                <span class="mr-1"><script>document.write(new Date().getFullYear())</script>©</span> <a href="#"
                                                                                                        class="">Webkit</a>.
            </div>
        </div>
    </div>
</footer>
<!-- Backend Bundle JavaScript -->
<script src="static/js/backend-bundle.min.js"></script>

<!-- Table Treeview JavaScript -->
<!-- <script src="../assets/js/table-treeview.js"></script> -->

<!-- Chart Custom JavaScript -->
<!-- <script src="../assets/js/customizer.js"></script> -->

<!-- Chart Custom JavaScript -->
<!-- <script async src="../assets/js/chart-custom.js"></script> -->
<!-- Chart Custom JavaScript -->
<!-- <script async src="../assets/js/slider.js"></script> -->

<!-- app JavaScript -->
<script src="static/js/app.js"></script>

<!-- <script src="../assets/vendor/moment.min.js"></script> -->
</body>
</html>