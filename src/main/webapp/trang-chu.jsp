<%--
  Created by IntelliJ IDEA.
  User: Mr Ngân
  Date: 3/8/2024
  Time: 3:01 PM
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
<h1>Trang chủ </h1>


<%--<c:forEach items = "${listSinhVien}" var = "sinhvien" varStatus="1">--%>
<%--    <p>${i.index}</p>--%>
<%--    <p>${sinhvien.tenSV}</p>--%>
<%--</c:forEach>--%>
<form action="/sinh-vien/add" method="post">
    <!-- Khu vực id -->
    <div class="mt-3">
        <span class="form-label">Mã Danh Mục :</span>
        <input name="maDanhMuc" class="form-control" type="text">
    </div>

    <!-- Khu vực tên -->
    <div class="mt-3">
        <span class="form-label">Tên Danh Mục:</span>
        <input name="tenDanhMuc"  class="form-control" type="text">
    </div>

    <!-- Khu vực giá -->



    <div class="row">
        <p class="col-4"> trạng Thái
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Đã bán" name="trangThai"
                   <c:if test="${sinhVienDetail.gioiTinh == 'Nam'}">checked</c:if>
            >
            <label class="form-check-label">
                đã bán
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Đamg bán " name="trangThai"
                   <c:if test="${sinhVienDetail.gioiTinh == 'Nu'}">checked</c:if>>
            <label class="form-check-label">
                đang bán
            </label>
        </div>
    </div>
    <div class="mt-3">
        <button  type="submit" class="btn btn-primary" >Submit</button>
    </div>
</form>
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
    <c:forEach items="${listDanhMuc}" var="dm" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${dm.maDanhMuc}</td>
            <td>${dm.tenDanhMuc}</td>
            <td>${dm.trangThai}</td>
            <td>${dm.ngayTao}</td>
            <td>${dm.ngaySua}</td>

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
