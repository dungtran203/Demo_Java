<%--
  Created by IntelliJ IDEA.
  User: Tran Thi My Dung
  Date: 6/9/2023
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>CameraShop</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/35a8b342cd.js" crossorigin="anonymous"></script>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Roboto:400,500,700');
        *
        {
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        /* Remove the navbar's default rounded borders and increase the bottom margin */
        .navbar {
            margin-bottom: 50px;
            border-radius: 0;
        }

        /* Remove the jumbotron's default bottom margin */
        .jumbotron {
            margin-bottom: 0;
        }

        /* Add a gray background color and some padding to the footer */
        footer {
            background-color: #f2f2f2;
            padding: 25px;
        }

        body{
            font-family: 'Roboto', sans-serif;
        }

        a{
            text-decoration: none;
        }

        .product-card {
            width: 250px;
            position: relative;
            box-shadow: 0 2px 7px #dfdfdf;
            margin: 20px auto;
            background: #fafafa;
        }

        .badge {
            position: absolute;
            left: 0;
            top: 20px;
            text-transform: uppercase;
            font-size: 13px;
            font-weight: 700;
            background: red;
            color: #fff;
            padding: 3px 10px;
        }

        .product-tumb {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 250px;
            padding: 35px;
            background: #f0f0f0;
        }

        .product-tumb img {
            max-width: 100%;
            max-height: 100%;
        }

        .product-details {
            padding: 15px;
        }

        .product-catagory {
            display: block;
            font-size: 12px;
            font-weight: 700;
            text-transform: uppercase;
            color: #ccc;
            margin-bottom: 18px;
        }

        .product-details h4 a {
            font-weight: 500;
            display: block;
            margin-bottom: 15px;
            text-transform: uppercase;
            color: #363636;
            text-decoration: none;
            transition: 0.3s;
        }

        .product-details h4 a:hover {
            color: #fbb72c;
        }

        .product-details p {
            font-size: 13px;
            line-height: 20px;
            margin-bottom: 5px;
            color: #999;
        }

        .product-bottom-details {
            overflow: hidden;
            border-top: 1px solid #eee;
            padding-top: 5px;
        }

        .product-bottom-details div {
            float: left;
            width: 50%;
        }

        .product-price {
            font-size: 18px;
            color: #fbb72c;
            font-weight: 600;
        }

        .product-price small {
            font-size: 80%;
            font-weight: 400;
            text-decoration: line-through;
            display: inline-block;
            margin-right: 5px;
        }

        .product-links {
            text-align: right;
        }

        .product-links a {
            display: inline-block;
            margin-left: 5px;
            color: #e1e1e1;
            transition: 0.3s;
            font-size: 17px;
        }

        .product-links a:hover {
            color: #fbb72c;
        }

        .container-fluid{
            font-size: 17px;
        }
    </style>
</head>

<body>

    <div class="jumbotron - fluid">
        <!-- Carousel container -->
        <div id="my-pics" class="carousel slide" data-ride="carousel" style="width: 800px; height: 399px; margin:auto;">

            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#my-pics" data-slide-to="0" class="active"></li>
                <li data-target="#my-pics" data-slide-to="1"></li>
                <li data-target="#my-pics" data-slide-to="2"></li>
            </ol>

            <!-- Content -->
            <div class="carousel-inner" role="listbox">

                <!-- Slide 1 -->
                <div class="item active">
                    <img src="https://minhduongads.com/wp-content/uploads/2019/03/thiet-ke-banner-chuyen-nghiep-gia-re-44-1.jpg" alt="Sunset over beach">
                </div>

                <!-- Slide 2 -->
                <div class="item">
                    <img src="https://mayanh72.com/wp-content/uploads/2021/07/banner-may-anh.jpg" alt="Rob Roy Glacier">
                </div>

                <!-- Slide 3 -->
                <div class="item">
                    <img src="https://minhduongads.com/wp-content/uploads/2019/03/thiet-ke-banner-chuyen-nghiep-gia-re-26-1.jpg" alt="Longtail boats at Phi Phi">
                </div>

            </div>

            <!-- Previous/Next controls -->
            <a class="left carousel-control" href="#my-pics" role="button" data-slide="prev">
                <span class="icon-prev" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#my-pics" role="button" data-slide="next">
                <span class="icon-next" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>

        </div>
    </div>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#" >
                    <span class="glyphicon glyphicon-camera"></span> CameraShop</p>
                </a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Trang Chủ</a></li>
                    <li><a href="#">Về Chúng tôi</a></li>
                    <li class="nav-item dropdown" >
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Quản lý
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown1"
                             style="background: black; text-decoration: none; padding-left: 20px; font-size: 16px;">
                            <a class="dropdown-item" href="/admin/account/view" style="color: #ebf2fa">Quản Lý Account</a> <br>
                            <a class="dropdown-item" href="/admin/category/view" style="color: #ebf2fa">Quản Lý Category</a> <br>
                            <a class="dropdown-item" href="/admin/order/view" style="color: #ebf2fa">Quản Lý Order</a> <br>
                            <a class="dropdown-item" href="/admin/order-detail/view" style="color: #ebf2fa">Quản Lý Order Detail</a> <br>
                            <a class="dropdown-item" href="/admin/product/view" style="color: #ebf2fa">Quản Lý Product</a> <br>
                        </div>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <form class="navbar-form navbar-left" action="/home/search-and-page">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Tìm kiếm ..." name="keywords">
                        </div>
                        <button type="submit" class="btn btn-warning">Tìm kiếm</button>
                    </form>
                    <li><a href="/user/cart/view"><span class="glyphicon glyphicon-shopping-cart"></span> Giỏ Hàng</a></li>
                    <li class="nav-item dropdown" >
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Tài khoản
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown"
                             style="background: black; text-decoration: none; padding-left: 20px; font-size: 16px;">
                            <a class="dropdown-item" href="/quenmatkhau" style="color: #ebf2fa">Đổi mật khẩu</a> <br>
                            <a class="dropdown-item" href="/login" style="color: #ebf2fa">Đăng xuất</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="col-sm-12">
            <c:forEach var="item" items="${item.getContent()}">
                <div class="col-sm-3" style="margin-right: 25px; margin-left: 60px">
                    <div class="product-card">
                        <div class="badge">Hot</div>
                        <div class="product-tumb">
                            <img src="/files/${item.image}" alt="${item.image}">
                        </div>
                        <div class="product-details">
                            <h4><a href="">${item.name}</a></h4>
                            <p>Sony ZV-1 Digital Camera for Content Creators</p>
                            <div class="product-bottom-details">
                                <div class="product-price"><small>100.90</small>${item.price}</div>
                                <div class="product-links">
                                    <a href="/home/detail${item.id}" class="fa-solid fa-eye"></a>
                                    <a href="/user/cart/add/${item.id}"><i class="fa fa-shopping-cart"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div> <br>

    <div style="text-align: center">
        <c:if test="${item.getNumber() gt 0}">
            <a href="?page=${item.getNumber()}">
                Previous
            </a>
        </c:if>

        <span>${item.getNumber() + 1} / ${item.getTotalPages()}</span>

        <c:if test="${item.getNumber() lt item.getTotalPages() - 1}">
            <a href="?page=${item.getNumber() + 2}">
                Next
            </a>
        </c:if>
    </div>

    <footer class="container-fluid text-center" style="margin-top: 20px">
        <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
            <div class="me-5 d-none d-lg-block">
                    <span>Get connected with us on social networks:
                        <a class="fa-brands fa-facebook" href="https://www.facebook.com/dun.tran2003/"></a>
                        <a class="fa-brands fa-instagram" href="https://www.instagram.com/h.dun.2003/"></a>
                        <a class="fa-brands fa-github" href="https://github.com/dungttmph25136"></a>
                    </span>
            </div>
        </section>
        <div class="text-center p-4">
            © 2023 Copyright:
            <a class="text-reset fw-bold" href="https://www.youtube.com/@duntran12">Youtube.com</a>
        </div>
    </footer>

</body>

