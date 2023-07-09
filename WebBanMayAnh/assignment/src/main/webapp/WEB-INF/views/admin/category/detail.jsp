<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title> Category </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
            <div class="modal-content" style=" align-items: center; margin-top: 60px;">
                <div class="modal-header">
                    <h4 class="modal-title"> ${category.name} </h4>
                </div>
                <!-- Modal body -->
                <div class="modal-body">
                    <h6> Id : ${category.id} </h6>
                    <h6> Name : ${category.name} </h6>
                </div>
                <!-- Modal footer -->
                <div class="modal-footer">
                    <a class="btn btn-dark" href="/admin/category/view">Quay lại trang chủ</a>
                </div>
            </div>
</body>
</html>