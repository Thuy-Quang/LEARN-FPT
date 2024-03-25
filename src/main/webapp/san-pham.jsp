<%--
  Created by IntelliJ IDEA.
  User: Mr Ngân
  Date: 3/25/2024
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <c:forEach items="${listSp}" var="sp" varStatus="i">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.maSanPham}</td>
            <td>${sp.tenSanPham}</td>
            <td>${sp.trangThai}</td>
            <td>${sp.ngayTao}</td>
            <td>${sp.ngaySua}</td>

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
