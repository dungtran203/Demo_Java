<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header><h2 style="text-align: center;">Sửa Category</h2></header>
<main>
    <form action="/admin/category/update?id=${category.id}" method="post" class="container" enctype="multipart/form-data">
        <div class="mb-3">
            <label class="form-label">Id</label>
            <input type="text" class="form-control" name="id" value="${category.id}" disabled>
        </div>
        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" class="form-control" name="name" value="${category.name}">
        </div>
        <button class="btn btn-dark" type="submit">Sửa</button>
    </form>
</main>
<footer><p style="text-align: center;">Dungttmph25136</p></footer>
</body>
</html>
