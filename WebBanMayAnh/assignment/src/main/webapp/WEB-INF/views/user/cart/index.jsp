<%--
  Created by IntelliJ IDEA.
  User: 0978078602
  Date: 30/05/2023
  Time: 12:24 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<html>
<head>
    <title>Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<form action="/user/cart/addOrderDetail" method="post">
<section style="position: relative">
    <div class="container" style=" position: absolute; margin-left: 50px; margin-top: 30px">
        ${mess}
        <table class="col-8" style="margin-bottom: 20px; margin-top: 50px">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Quantity</th>
                <th scope="col">Available</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cart.items}">
                    <form action="/user/cart/update/${item.id}" method="post">
                        <input type="hidden" name="id" value="${item.id}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.price}</td>
                            <td><input name="qty" value="${item.qty}"
                                       onblur="this.form.submit()" style="width: 50px;"></td>
                            <td>${item.price * item.qty}</td>
                            <td>
                                <a class="btn btn-dark" href="/user/cart/remove/${item.id}">Remove</a>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>

        <a class="btn btn-dark" href="/user/cart/clear">Clear Cart</a>
        <a class="btn btn-dark" href="/home/view">Add more</a>

        <form style=" position: absolute;  right: 20px; top: 5px; width: 400px; height: 200px" action="/user/cart/addOrder" method="post">
            <header><h4 style="text-align: center">Thông tin nhận hàng</h4></header>
            <div class="container" enctype="multipart/form-data">
                <div class="mb-6" style="margin-top: 15px">
                    <label class="form-label">Họ Tên :</label>
                    <input type="text" class="form-control" name="account" value="${user.username}">
                </div>
                <div class="mb-6" style="margin-top: 15px">
                    <label class="form-label">Địa chỉ nhận hàng :</label>
                    <input type="text" class="form-control" name="address" placeholder="Vui lòng nhập địa chỉ nhận hàng !">
                </div>
            </div>

            <div class="row mx-auto">
                <div class="mb-3">
                    <div class="col-6">Số lượng sản phẩm : ${tongsp }</div>
                </div>
                <div class="d-flex justify-content-between mt-3">
                    <div class="col-6" style="margin-bottom: 10px">Tổng tiền hàng</div>
                    <div class="col-6 text-end">
                        <fmt:formatNumber type="number" pattern="$ ###" value="${tongth }"/>
                    </div>
                </div>
                <hr>
                <div class="d-flex justify-content-between mt-3">
                    <div class="col-6">Tạm tính</div>
                    <div class="col-6 text-end">
                        <fmt:formatNumber type="number" pattern="$ ###" value="${tamtinh }"/>
                    </div>
                </div>
            </div>
            <button class="btn btn-dark" type="submit">Thanh toán</button>
        </form>
    </div>
</section>
</form>
</body>
</html>
