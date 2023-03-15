<%--@elvariable id="user" type="com.js1603.app.model.User"--%>
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
                <div class="col-xl-12 col-lg-8">
                    <div class="card">
                        <div class="card-header d-flex justify-content-between">
                            <div class="header-title">
                                <h4 class="card-title">New Employment Information</h4>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="new-user-info">
                                <form method="post" action="update-user?id=${user.userId}">
                                    <div class="row">
                                        <div class="form-group col-md-6">
                                            <label>Name :</label>
                                            <input type="text" class="form-control"
                                                   placeholder="User Name " name="userName" value="${user.userName}">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Email :</label>
                                            <input type="text" class="form-control"
                                                   placeholder="Email User " name="userEmail" value="${user.userEmail}">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Password :</label>
                                            <input type="password" class="form-control"
                                                   placeholder="Enter Password" name="userPassword" value="${user.userPassword}">
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <label>Role:</label>
                                            <select name="userRole" class="selectpicker form-control"
                                                    data-style="py-0">

                                                <option value="1" ${user.userRole == 1?"selected":""}>Admin</option>
                                                <option value="2" ${user.userRole == 2?"selected":""}>Staff</option>
                                                <option value="3" ${user.userRole == 3?"selected":""}>Customer</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Date of Birth :</label>
                                            <input type="date" class="form-control"
                                                   name="userDob" value="${user.userDob}">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Phone :</label>
                                            <input type="number" class="form-control"
                                                   placeholder="Enter Phone" name="userPhone" value="${user.userPhone}">
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label>Gender :</label>
                                        </div>
                                        <div class="form-group col-md-2">

                                            <input class="form-check-input" type="radio" name="userGender"
                                                   id="flexRadioDefault1"  ${user.userGender == 1?"checked":""} value="1">
                                            <label class="form-check-label" for="flexRadioDefault1">
                                                Male
                                            </label>
                                        </div>
                                        <div class="form-group col-md-2">

                                            <input class="form-check-input" type="radio" name="userGender"
                                                   id="flexRadioDefault2" ${user.userGender == 0?"checked":""} value="0">
                                            <label class="form-check-label" for="flexRadioDefault2" >
                                                Female
                                            </label>

                                        </div>
                                        <br>
                                        <div class="form-group col-md-2">
                                            <label>Status :</label>
                                        </div>
                                        <div class="form-group col-md-2">

                                            <input class="form-check-input" type="radio" name="userStatus"
                                                   id="flexRadioDefault3" ${user.userStatus == 1?"checked":""} value="1">
                                            <label class="form-check-label" for="flexRadioDefault1">
                                                Active
                                            </label>
                                        </div>
                                        <div class="form-group col-md-2">

                                            <input class="form-check-input" type="radio" name="userStatus"
                                                   id="flexRadioDefault4" ${user.userStatus == 0?"checked":""} value="0">
                                            <label class="form-check-label" for="flexRadioDefault2" >
                                                Block
                                            </label>

                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-outline-success">Edit</button>
                                    <a class="btn btn-outline-primary" href="user-list">
                                        Back
                                    </a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Page end  -->

    <!-- Wrapper End-->

    <!-- Modal list start -->

    <footer class="iq-footer">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6">
                </div>
                <div class="col-lg-6 text-right">
                        <span class="mr-1">
                            <script>document.write(new Date().getFullYear())</script>©
                        </span> <a href="#" class="">Webkit</a>.
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