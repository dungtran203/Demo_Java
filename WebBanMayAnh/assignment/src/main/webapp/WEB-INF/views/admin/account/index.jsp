<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Account</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header><h2 style="text-align: center;">Account</h2></header>
<main>
    <section class="container">
        <a class="btn btn-dark" href="/admin/account/view-add">Thêm</a>
        <a class="btn btn-dark" href="/home/view">Quay về trang chủ</a>
    </section>
    <section>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Username</th>
                    <th scope="col">Password</th>
                    <th scope="col">Fullname</th>
                    <th scope="col">Email</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listAccount.getContent()}" var="a">
                    <tr>
                        <td>${a.username}</td>
                        <td>${a.password}</td>
                        <td>${a.fullname}</td>
                        <td>${a.email}</td>
                        <td>
                            <a class="btn btn-dark" href="/admin/account/detail${a.username}" >Chi tiết</a>
                            <a class="btn btn-dark" href="/admin/account/view-update/${a.username}">Sửa</a>
                            <a class="btn btn-dark" href="/admin/account/delete/${a.username}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <c:if test="${listAccount.getNumber() gt 0}">
                <a href="?page=${listAccount.getNumber()}">
                    Previous
                </a>
            </c:if>

            <span>${listAccount.getNumber() + 1} / ${listAccount.getTotalPages()}</span>

            <c:if test="${listAccount.getNumber() lt listAccount.getTotalPages() - 1}">
                <a href="?page=${listAccount.getNumber() + 2}">
                    Next
                </a>
            </c:if>
        </div>
    </section>
</main>
<footer><p style="text-align: center;">Dungttmph25136</p></footer>
</body>
</html>
