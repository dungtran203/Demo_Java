<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Account</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header><h2 style="text-align: center;">Sửa Account</h2></header>
<main>
    <form action="/admin/account/update?username=${account.username}" method="post" class="container" enctype="multipart/form-data">

        <div class="mb-3">
            <label class="form-label">Username</label>
            <input type="text" class="form-control" name="username" value="${account.username}" disabled>
        </div>

        <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="text" class="form-control" name="password" value="${account.password}">
        </div>

        <div class="mb-3">
            <label class="form-label">Fullname</label>
            <input type="text" class="form-control" name="fullname" value="${account.fullname}">
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="text" class="form-control" name="email" value="${account.email}">
        </div>

        <div class="mb-3">
            <label class="form-label">Photo</label>
            <input type="file" class="form-control" name="photo">
            <p>${account.photo}</p>
        </div>

        <div class="mb-3">
            <label class="form-label">Active : </label>
            <input type="radio" name="active" value="true" ${account.active == true ? "checked" : ""}> True
            <input type="radio" name="active" value="false" ${account.active == false ? "checked" : ""}> False
        </div>

        <div class="mb-3">
            <label class="form-label">Admin : </label>
            <input type="radio" name="admin" value="true" ${account.admin == true ? "checked" : ""}> True
            <input type="radio" name="admin" value="false" ${account.admin == false ? "checked" : ""}> False
        </div>

        <button class="btn btn-dark" type="submit">Sửa</button>
    </form>
</main>
<footer><p style="text-align: center;">Dungttmph25136</p></footer>
</body>
</html>
