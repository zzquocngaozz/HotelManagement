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
                            <h4 class="card-title">Edit Service Information</h4>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="new-user-info">
                            <form action="service-update?id=${service.serviceId}" method="POST">
                                <div class="row">
                                    <div class="form-group col-md-6">
                                        <label>Name :</label>
                                        <input type="text" class="form-control"
                                               placeholder="Name service" name="serviceName" value="${service.serviceName}">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Cost :</label>
                                        <input type="number" class="form-control"
                                               placeholder="Cost service" name="servicePrice" value="${service.servicePrice}">
                                    </div>                               
                                    <div class="form-group col-md-12">
                                        <label>Description :</label>
                                        <textarea class="form-control" name="serviceDescription"
                                                  placeholder="Description service">${service.serviceDescription}</textarea>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-outline-success">Edit</button>
                                <a class="btn btn-outline-primary" href="service-list">
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