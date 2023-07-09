<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header><h2 style="text-align: center;">Thêm Product</h2></header>
<main>
    <form action="/admin/product/add" method="post" class="container" enctype="multipart/form-data">
        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="mb-3">
            <label class="form-label">Image</label>
            <input type="file" class="form-control" name="image">
            ${mess}
        </div>
        <div class="mb-3">
            <label class="form-label">Price</label>
            <input type="text" class="form-control" name="price">
        </div>
        <div class="mb-3">
            <label class="form-label">Available </label>
            <input type="radio" name="available" value="true" checked>Còn hàng
            <input type="radio" name="available" value="false">Hết hàng
        </div>
        <div class="mb-3">
            <br>
            <label class="form-label">Category </label>
            <select name="category">
                <c:forEach items="${categoryList }" var="c">
                    <option value="${c.id}">${c.name}</option>
                </c:forEach>
            </select>
            <br>
        </div>
        <button class="btn btn-dark" type="submit">Thêm</button>
    </form>
</main>
<footer><p style="text-align: center;">Dungttmph25136</p></footer>
</body>
</html>
