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
                                <h4 class="card-title mb-0">Booking List</h4>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="data-table table" style="width:100%">
                                    <thead>
                                    <tr>
                                        <th style="text-align: center">ID</th>
                                        <th style="text-align: center">Name</th>
<%--                                        <th style="text-align: center">Phone</th>--%>
                                        <th style="text-align: center">Room Code</th>
                                        <th style="text-align: center">Check in Date</th>
                                        <th style="text-align: center">Check out Date</th>
                                        <th style="text-align: center">Pre Price</th>
                                        <th style="text-align: center">Status</th>
                                        <th style="text-align: center">Setting</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="s">
                                        <tr>
                                            <td style="text-align: center">${s.billId}</td>
                                            <td style="text-align: center">${s.user.userName}</td>
<%--                                            <td style="text-align: center">${s.user.userPhone}</td>--%>
                                            <td style="text-align: center">${s.room.roomCode}</td>
                                            <td style="text-align: center">${s.checkInDate}</td>
                                            <td style="text-align: center">${s.checkOutDate}</td>
                                            <td style="text-align: center">${s.billPrePrice}</td>
                                            <td style="text-align: center">${s.billStatus == 1?"Active":"Inactive"}</td>
                                            </td>

                                            <td>
                                                <div class="d-flex  list-action" style="margin-left: 15%; justify-content: center;">
                                                    <a class="badge bg-primary-light mr-2" data-toggle="tooltip"
                                                       data-placement="top" title="" data-original-title="checkout"
                                                       href="bill?id=${s.billId}"><i class="lar la-eye"></i></a>
                                                    <a class="badge bg-primary-light mr-2" data-toggle="tooltip"
                                                       data-placement="top" title="" data-original-title="list service"
                                                       href="list_service_by_bill?id=${s.billId}"><i
                                                            class="las la-plus-circle"></i>
                                                    </a>
                                                    <a class="badge bg-primary-light mr-2" data-toggle="tooltip"
                                                       data-placement="top" title="" data-original-title="Edit"
                                                       href="update-booking?id=${s.billId}"><i class="lar la-edit"></i></a>

                                                    <a class="badge ${s.billStatus == 1?"bg-danger":"bg-success"} mr-2"
                                                       data-toggle="tooltip"
                                                       data-placement="top" title=""
                                                       data-original-title="${s.billStatus == 1?"Inactive":"Active"}"
                                                       href="delete-booking?id=${s.billId}&status=${s.billStatus}"
                                                       onclick="return confirm('Do you want to change status booking?');">
                                                        <i class="las la-undo-alt"></i>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>

                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
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