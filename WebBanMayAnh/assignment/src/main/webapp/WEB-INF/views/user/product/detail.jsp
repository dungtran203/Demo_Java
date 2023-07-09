<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title> Product </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
            <div class="modal-content" style=" align-items: center; margin-top: 60px;">
                <div class="modal-header">
                    <h4 class="modal-title"> ${product.name} </h4>
                </div>
                <!-- Modal body -->
                <div class="modal-body">
                    <img width="200px" src="/files/${product.image } " style="margin-left: 5px"/>
                    <hr>
                    <h6> Id : ${product.id} </h6>
                    <h6> Name : ${product.name} </h6>
                    <h6> Price : ${product.price} </h6>
                    <h6> CreateDate : ${product.createDate} </h6>
                    <h6> Available : ${product.available ? "Còn hàng" : "Hết hàng"} </h6>
                </div>
                <!-- Modal footer -->
                <div class="modal-footer">
                    <a class="btn btn-dark" href="/home/view">Quay lại trang chủ</a>
                </div>
            </div>
</body>
</html>