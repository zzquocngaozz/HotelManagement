<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <jsp:include page="/common/css_header.jsp"></jsp:include>

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
                                <h4 class="card-title mb-0">Service List</h4>
                            </div>
                            <a href="Admin_service_add.jsp" class="btn btn-primary">Add Service</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="data-table table" style="width:100%">
                                    <thead>
                                    <tr>
                                        <th style="text-align: center">No</th>
                                        <th style="text-align: center">Name</th>
                                        <th style="text-align: center">Cost</th>
                                        <th style="text-align: center">Description</th>
                                        <th style="text-align: center">Setting</th>                                   
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr >
                                        <td style="text-align: center" >1</td>
                                        <td style="text-align: left" ></td>
                                        <td style="text-align: left" ></td>
                                        <td style="text-align: left" ></td>
                                        </td>
                                        <td>
                                            <div class="d-flex  list-action" style="margin-left: 41%;">
                                                <a class="badge bg-primary-light mr-2" data-toggle="tooltip" 
                                                   data-placement="top" title="" data-original-title="Edit"
                                                   href="Admin_service_edit.jsp"><i class="lar la-edit" ></i></a>
                                                <a class="badge bg-danger-light mr-2" data-toggle="tooltip" 
                                                   data-placement="top" title="" data-original-title="Delete"
                                                   href="#"
                                                   onclick="return confirm('Do you want to delete this service?');" ><i class="lar la-trash-alt "></i></a>
                                            </div>
                                        </td>
                                    </tr>
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