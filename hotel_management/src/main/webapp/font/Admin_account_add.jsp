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
                                <h4 class="card-title">New User Information</h4>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="new-user-info">
                                <form method="post" action="add-user">
                                    <div class="row">
                                        <div class="form-group col-md-6">
                                            <label>Name :</label>
                                            <input type="text" class="form-control"
                                                   placeholder="User Name " name="userName">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Email :</label>
                                            <input type="text" class="form-control"
                                                   placeholder="Email User " name="userEmail">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Password :</label>
                                            <input type="password" class="form-control"
                                                   placeholder="Enter Password" name="userPassword">
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <label>Role:</label>
                                            <select name="userRole" class="selectpicker form-control"
                                                    data-style="py-0">
                                                <option value="0">Select category</option>
                                                <option value="2">Staff</option>
                                                <option value="3">Customer</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Date of Birth :</label>
                                            <input type="date" class="form-control"
                                                   name="userDob">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Phone :</label>
                                            <input type="number" class="form-control"
                                                   placeholder="Enter Phone" name="userPhone">
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label>Gender :</label>
                                        </div>
                                        <div class="form-group col-md-2">

                                            <input class="form-check-input" type="radio" name="userStatus"
                                                   id="flexRadioDefault1" value="1">
                                            <label class="form-check-label" for="flexRadioDefault1">
                                                Male
                                            </label>
                                        </div>
                                        <div class="form-group col-md-2">

                                            <input class="form-check-input" type="radio" name="userGender"
                                                   id="flexRadioDefault2" value="0">
                                            <label class="form-check-label" for="flexRadioDefault2">
                                                Female
                                            </label>

                                        </div>
                                        <br>
                                        <div class="form-group col-md-2">
                                            <label>Status :</label>
                                        </div>
                                        <div class="form-group col-md-2">

                                            <input class="form-check-input" type="radio" name="userGender"
                                                   id="flexRadioDefault3" value="1">
                                            <label class="form-check-label" for="flexRadioDefault1" >
                                                Active
                                            </label>
                                        </div>
                                        <div class="form-group col-md-2">

                                            <input class="form-check-input" type="radio" name="userStatus"
                                                   id="flexRadioDefault4" value="0">
                                            <label class="form-check-label" for="flexRadioDefault2">
                                                Block
                                            </label>

                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-outline-success">Add</button>
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