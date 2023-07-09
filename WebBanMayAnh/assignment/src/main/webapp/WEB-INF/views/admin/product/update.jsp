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
<header><h2 style="text-align: center;">Sửa Product</h2></header>
<main>
    <form action="/admin/product/update?id=${product.id}" method="post" class="container" enctype="multipart/form-data">
        <div class="mb-3">
            <label class="form-label">Id</label>
            <input type="text" class="form-control" name="id" value="${product.id}" disabled>
        </div>
        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" class="form-control" name="name" value="${product.name}">
        </div>
        <div class="mb-3">
            <label class="form-label">Image</label>
            <input type="file" class="form-control" name="image">
            <p>${product.image}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Price</label>
            <input type="text" class="form-control" name="price" value="${product.price}">
        </div>
        <div class="mb-3">
            <label class="form-label">Available </label>
            <input type="radio" name="available" value="true" ${product.available == true ? "checked" : ""}>Còn hàng
            <input type="radio" name="available" value="false" ${product.available == false ? "checked" : ""}>Hết hàng
        </div>
        <div class="mb-3">
            <br>
            <label class="form-label">Category </label>
            <select name="category">
                <c:forEach items="${categoryList }" var="c">
                    <option value="${c.id}" ${c.id == product.category.id ? 'selected="selected"' : ''} > ${c.name}</option>
                </c:forEach>
            </select>
            <br>
        </div>
        <button class="btn btn-dark" type="submit">Sửa</button>
    </form>
</main>
<footer><p style="text-align: center;">Dungttmph25136s</p></footer>
</body>
</html>
