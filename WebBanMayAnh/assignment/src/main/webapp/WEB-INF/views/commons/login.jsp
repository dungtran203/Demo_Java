<%--
  Created by IntelliJ IDEA.
  User: Tran Thi My Dung
  Date: 6/12/2023
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login CameraShop</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .btn-color{
            background-color: #0e1c36;
            color: #fff;

        }

        .profile-image-pic{
            height: 200px;
            width: 200px;
            object-fit: cover;
        }

        .cardbody-color{
            background-color: #ebf2fa;
        }

        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card my-5">
                <form:form class="card-body cardbody-color p-lg-5" action="/login" modelAttribute="account" method="post">
                    <div class="text-center">
                        <img src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png"
                             class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                             width="200px" alt="profile">
                    </div>

                    <div class="mb-3">
                        <form:input path="username" placeholder="Username" type="text" class="form-control"/>
                        <form:errors path="username" class="form-text text-danger" />
                        <c:if test="${not empty error_loginUsername}">
                            <div class="form-text text-danger" role="alert">
                                    ${error_loginUsername}
                            </div>
                        </c:if>
                    </div>

                    <div class="mb-3">
                        <form:input path="password" placeholder="Password" type="password" class="form-control"/>
                        <form:errors path="password" class="form-text text-danger" />
                        <c:if test="${not empty error_loginPass}">
                            <div class="form-text text-danger" role="alert">
                                    ${error_loginPass}
                            </div>
                        </c:if>
                    </div>

                    <div class="text-center"><button type="submit" class="btn btn-color px-5 mb-5 w-100">Login</button></div>

                    <div id="emailHelp" class="form-text text-center mb-5 text-dark">Not
                        Registered? <a href="/quenmatkhau" class="text-dark fw-bold"> Create an
                            Account</a>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
