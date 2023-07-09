<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title> Account </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
            <div class="modal-content" style=" align-items: center; margin-top: 60px;">
                <div class="modal-header">
                    <h4 class="modal-title"> ${account.username} </h4>
                </div>
                <!-- Modal body -->
                <div class="modal-body">
                    <img width= 200px" src="/avata/${account.photo} " style="margin-left: 37px"/>
                    <hr>
                    <h6> Username : ${account.username} </h6>
                    <h6> Password : ${account.password} </h6>
                    <h6> Fullname : ${account.fullname} </h6>
                    <h6> Email : ${account.email} </h6>
                    <h6> Active : ${account.active ? "true" : "false"} </h6>
                    <h6> Admin : ${account.admin ? "true" : "false"} </h6>
                </div>
                <!-- Modal footer -->
                <div class="modal-footer">
                    <a class="btn btn-dark" href="/admin/account/view">Quay lại</a>
                </div>
            </div>
</body>
</html>