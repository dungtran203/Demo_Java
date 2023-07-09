<%--
  Created by IntelliJ IDEA.
  User: Tran Thi My Dung
  Date: 6/14/2023
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                <form class="card-body cardbody-color p-lg-5" action="/logout" method="post">
                    <div class="text-center">
                        <img src="/avata/${user.photo}" alt="${user.photo}"
                             class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                             width="200px" alt="profile">
                    </div>

                    <div class="mb-3">
                        <input value="${user.username}" readonly placeholder="Username" type="text" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <input value="${user.password}" readonly placeholder="Password" type="password" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <input value="${user.fullname}" readonly placeholder="Fullname" type="text" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <input value="${user.email}" readonly placeholder="Email" type="email" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <input value="${user.admin?'Admin':'user'}" readonly placeholder="Admin" type="text" class="form-control"/>
                    </div>
                    <div class="w-100 text-end">
                        <button formaction="/home/view" formmethod="get" type="submit" class="btn btn-color px-5">Tiếp tục</button>
                        <button type="submit" class="btn btn-color px-5">Logout</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</html>
