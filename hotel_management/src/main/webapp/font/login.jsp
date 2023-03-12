<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>
    <!-- CSS only -->
    <!--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">-->
    <!-- Favicon -->
    <link rel="shortcut icon" href="/static/images/favicon.ico">
    <link rel="stylesheet" href="/static/css/backend-plugin.min.css">
    <link rel="stylesheet" href="/static/css/backend.css">
    <link rel="stylesheet" href="/static/vendor/line-awesome/dist/line-awesome/css/line-awesome.min.css">
    <link rel="stylesheet" href="/static/vendor/remixicon/fonts/remixicon.css">

    <link rel="stylesheet" href="/static/vendor/tui-calendar/tui-calendar/dist/tui-calendar.css">
    <link rel="stylesheet" href="/static/vendor/tui-calendar/tui-date-picker/dist/tui-date-picker.css">
    <link rel="stylesheet" href="/static/vendor/tui-calendar/tui-time-picker/dist/tui-time-picker.css">
</head>
<body class=" ">
<!-- loader Start -->
<div id="loading">
    <div id="loading-center">
    </div>
</div>
<!-- loader END -->

<div class="wrapper">
    <section class="login-content">
        <div class="container">
            <div class="row align-items-center justify-content-center height-self-center">
                <div class="col-lg-8">
                    <div class="card auth-card">
                        <div class="card-body p-0">
                            <div class="d-flex align-items-center auth-content">
                                <div class="col-lg-6 bg-primary content-left">
                                    <div class="p-3">
                                        <h2 class="mb-2 text-white">Sign In</h2>
                                        <p>Login to stay connected.</p>
                                        <form th:action="@{/doLogin}" method="post">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <div class="floating-label form-group">
                                                        <input class="floating-input form-control" type="email"
                                                               placeholder=" " name="email">
                                                        <label>Email</label>
                                                    </div>
                                                </div>
                                                <div class="col-lg-12">
                                                    <div class="floating-label form-group">
                                                        <input class="floating-input form-control" type="password"
                                                               placeholder=" " name="password">
                                                        <label>Password</label>
                                                    </div>
                                                </div>
                                                <div class="col-lg-6">
                                                    <div class="custom-control custom-checkbox mb-3">
                                                        <input type="checkbox" class="custom-control-input"
                                                               id="customCheck1" name="remember-me">
                                                        <label class="custom-control-label control-label-1 text-white"
                                                               for="customCheck1">Remember Me</label>
                                                    </div>
                                                </div>
                                                <div class="col-lg-6">
                                                    <a href="auth-recoverpw.html" class="text-white float-right">Forgot
                                                        Password?</a>
                                                </div>
                                            </div>
                                            <button type="submit" class="btn btn-white">Sign In</button>
                                            <p class="mt-3">
                                                Create an Account <a th:href="@{/process_register}"
                                                                     class="text-white text-underline">Sign Up</a>
                                            </p>
                                        </form>
                                    </div>
                                </div>
                                <div class="col-lg-6 content-right">
                                    <img src="/static/images/login/2348793.jpg" class="img-fluid image-right" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<!-- Backend Bundle JavaScript -->
<script src="/static/js/backend-bundle.min.js"></script>

<!-- Table Treeview JavaScript -->
<script src="/static/js/table-treeview.js"></script>

<!-- Chart Custom JavaScript -->
<script src="/static/js/customizer.js"></script>

<!-- Chart Custom JavaScript -->
<script async src="/static/js/chart-custom.js"></script>
<!-- Chart Custom JavaScript -->
<script async src="/static/js/slider.js"></script>

<!-- app JavaScript -->
<script src="/static/js/app.js"></script>

<script src="/static/vendor/moment.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>-->
</body>
</html>