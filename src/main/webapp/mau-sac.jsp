<%--
  Created by IntelliJ IDEA.
  User: Mr Ngân
  Date: 3/26/2024
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table container">
    <thead>
    <tr>
        <td>ID</td>
        <td> ma danh  muc</td>
        <td> ten danh muc </td>
        <td> trang thai</td>
        <td> ngay tao</td>
        <td> ngay sua</td>

        <td> Thao Tác</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="ms" >
        <tr>
            <td>${ms.id}</td>
            <td>${ms.maMau}</td>
            <td>${ms.tenMau}</td>
            <td>${ms.trangThai}</td>
            <td>${ms.ngaySua}</td>
            <td>${ms.ngayTao}</td>

            <td>
                <a href="/sinh-vien/detail?id=${sinhvien.maSV}" class="btn btn-info">detail</a>
                <a href="/sinh-vien/delete?id=${sinhvien.maSV}" class="btn btn-success" >remove</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
