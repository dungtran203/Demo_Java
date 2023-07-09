<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <style>
        .form-gap {
            padding-top: 70px;
        }
    </style>
</head>
<body>
<div class="alert alert-${ale}">
    ${me}
</div>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<div class="form-gap"></div>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <h2 class="text-center"> Nhập mật khẩu mới</h2>
                        <div class="panel-body">

                            <form id="register-form" role="form" action="/matkhau" autocomplete="off" class="form" method="get">

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i
                                                class="glyphicon glyphicon-envelope color-blue"></i></span>
                                        <input name="matkhaumoi" placeholder="Mật Khẩu Mới" class="form-control"
                                               type="password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input class="btn btn-lg btn-primary btn-block" value="Xác nhận"
                                           type="submit">
                                </div>

                            </form>

                            <div class="d-flex justify-content-end">
                                <button class="btn btn btn-lg"><a href="/login">
                                    <font color="black">Login</font>
                                </a></button>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>


<!------ Include the above in your HEAD tag ---------->

