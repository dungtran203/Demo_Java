<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Order Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header><h2 style="text-align: center;">Order Detail</h2></header>
<main>
    <section class="container" style="margin-top: 20px">
        <a class="btn btn-dark" href="/home/view">Quay về trang chủ</a>
    </section>
    <section>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orderDetails}" var="orderDetail">
                    <tr>
                        <td>${orderDetail.id}</td>
                        <td>${orderDetail.price}</td>
                        <td>${orderDetail.quantity}</td>
                        <td>
                            <a class="btn btn-dark" href="/admin/product/detail${p.id}" >Chi tiết</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <c:if test="${listODetail.getNumber() gt 0}">
            <a href="?page=${listODetail.getNumber()}">
                Previous
            </a>
        </c:if>

        <span>${listODetail.getNumber() + 1} / ${listODetail.getTotalPages()}</span>

        <c:if test="${listODetail.getNumber() lt listODetail.getTotalPages() - 1}">
            <a href="?page=${listODetail.getNumber() + 2}">
                Next
            </a>
        </c:if>

    </section>
</main>


<footer><p style="text-align: center;">Dungttmph25136</p></footer>
</body>
</html>
