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
                                <h4 class="card-title mb-0">User List</h4>
                            </div>
                            <a href="Admin_account_add.jsp" class="btn btn-primary">Add User</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="data-table table" style="width:100%">
                                    <thead>
                                    <tr>
                                        <th style="text-align: center">No</th>
                                        <th style="text-align: center">Username</th>
                                        <th style="text-align: center">Email</th>
                                        <th style="text-align: center">Role</th>
                                        <th style="text-align: center">DOB</th>
                                        <th style="text-align: center">Phone</th>
                                        <th style="text-align: center">Gender</th>
                                        <th style="text-align: center">Status</th>
                                        <th style="text-align: center">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listUser}" var="lu">
                                    <tr >
                                        <td style="text-align: center" >${lu.userId}</td>
                                        <td style="text-align: center" >${lu.userName}</td>
                                        <td style="text-align: center" >${lu.userEmail}</td>
                                        <td style="text-align: center" >${lu.userRole == 1?"Admin":(lu.userRole==2?"Staff":"Customer")}</td>
                                        <td style="text-align: center" >${lu.userDob}</td>
                                        <td style="text-align: center" >${lu.userPhone}</td>
                                        <td style="text-align: center" >${lu.userGender ==1?"Male":"Female"}</td>
                                        <td style="text-align: center" >${lu.userStatus ==1?"Active":"Block"}</td>
                                        <td>
                                            <div class="d-flex  list-action" style="margin-left: 41%;">
                                                <a class="badge bg-primary-light mr-2" data-toggle="tooltip" 
                                                   data-placement="top" title="" data-original-title="Edit"
                                                   href="Admin_account_edit.jsp"><i class="lar la-edit" ></i></a>
                                                <a class="badge bg-danger-light mr-2" data-toggle="tooltip" 
                                                   data-placement="top" title="" data-original-title="Delete"
                                                   href="#"
                                                   onclick="return confirm('Do you want to delete this user?');" ><i class="lar la-trash-alt "></i></a>
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