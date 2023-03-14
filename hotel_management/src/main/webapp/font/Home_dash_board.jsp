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
                <div class="col-md-6 col-lg-3">
                    <div class="card card-block card-stretch card-height">
                        <div class="card-body">
                            <div class="top-block d-flex align-items-center justify-content-between">
                                <h5>User</h5>
                            </div>
                            <div class="d-flex align-items-center justify-content-between mt-1">
                                <p class="mb-0">Total User</p>
                                <span class="text-primary">12</span>
                            </div>
                            <div class="iq-progress-bar bg-primary-light mt-2">
                                <span class="bg-primary iq-progress progress-1" data-percent="100"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="card card-block card-stretch card-height">
                        <div class="card-body">
                            <div class="top-block d-flex align-items-center justify-content-between">
                                <h5>Booking</h5>
                            </div>
                            <div class="d-flex align-items-center justify-content-between mt-1">
                                <p class="mb-0">Total Booking</p>
                                <span class="text-warning">12</span>
                            </div>
                            <div class="iq-progress-bar bg-warning-light mt-2">
                                <span class="bg-warning iq-progress progress-1" data-percent="100"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="card card-block card-stretch card-height">
                        <div class="card-body">
                            <div class="top-block d-flex align-items-center justify-content-between">
                                <h5>Service</h5>
                            </div>
                            <div class="d-flex align-items-center justify-content-between mt-1">
                                <p class="mb-0">Total Service</p>
                                <span class="text-success">12</span>
                            </div>
                            <div class="iq-progress-bar bg-success-light mt-2">
                                <span class="bg-success iq-progress progress-1" data-percent="100"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-4">
                    <div class="card card-block card-stretch card-height">
                        <div class="card-body">
                            <div class="card border-bottom pb-2 shadow-none">
                                <div class="card-body text-center inln-date flet-datepickr">
                                    <input type="text" id="inline-date" class="date-input basicFlatpickr d-none"
                                        readonly="readonly">
                                </div>
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
    <script src="static/js/backend-bundle.min.js"></script>

    <!-- Table Treeview JavaScript -->
    <script src="static/js/table-treeview.js"></script>

    <!-- Chart Custom JavaScript -->
    <script src="static/js/customizer.js"></script>

    <!-- Chart Custom JavaScript -->
    <script async src="static/js/chart-custom.js"></script>
    <!-- Chart Custom JavaScript -->
    <script async src="static/js/slider.js"></script>

    <!-- app JavaScript -->
    <script src="static/js/app.js"></script>

    <script src="static/vendor/moment.min.js"></script>
</body>

</html>