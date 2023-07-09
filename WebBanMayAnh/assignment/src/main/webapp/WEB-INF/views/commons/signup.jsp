<%--
  Created by IntelliJ IDEA.
  User: Tran Thi My Dung
  Date: 6/12/2023
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sign Up CameraShop</title>
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

                <form class="card-body cardbody-color p-lg-5" action="" method="post">

                    <div class="text-center">
                        <img src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png"
                             class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                             width="200px" alt="profile">
                    </div>

                    <div class="mb-3">
                        <input type="text" class="form-control" aria-describedby="emailHelp"
                               placeholder="Username" name="username">
                    </div>

                    <div class="mb-3">
                        <input type="text" class="form-control" placeholder="Password" name="password">
                    </div>

                    <div class="mb-3">
                        <input type="text" class="form-control" placeholder="Fullname" name="fullname">
                    </div>

                    <div class="mb-3">
                        <input type="email" class="form-control" placeholder="Email" name="email">
                    </div>

                    <div class="mb-3">
                        <input type="file" class="form-control" placeholder="Photo" name="photo">
                    </div>

                    <p style="color: red">${message}${param.error}</p>
                    <div class="text-center"><button type="submit" class="btn btn-color px-5 mb-5 w-100">Create account</button></div>
                    <div id="emailHelp" class="form-text text-center mb-5 text-dark">Registered
                        <a href="#" class="text-dark fw-bold"> Login</a>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>

</body>
</html>
