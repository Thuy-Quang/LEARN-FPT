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
        <span class="form-label">Mã Sinh Viên :</span>
        <input name="maSV" class="form-control" type="text">
    </div>

    <!-- Khu vực tên -->
    <div class="mt-3">
        <span class="form-label">Tên Sinh Viên:</span>
        <input name="tenSV"  class="form-control" type="text">
    </div>

    <!-- Khu vực giá -->
    <div class="mt-3">
        <span class="form-label">Tuổi:</span>
        <input name="tuoi"  class="form-control" type="text">
    </div>
    <div class="mt-3">
        <span class="form-label">Địa Chỉ:</span>
        <input name="diaChi"  class="form-control" type="text">
    </div>
    <div class="mb-3">
        <label for="disabledSelect" class="form-label">Ten lop</label>
        <select id="disabledSelect" class="form-select" name="tenLop">
            <c:forEach items="${tenLop}" var="lop">
                <option value="${lop}"
                    <c:if test="${sinhVienDetail.tenLop == lop}">selected</c:if>>
                        ${lop}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="row">
        <p class="col-4">Gioi tinh
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Nam" name="gioiTinh"
                   <c:if test="${sinhVienDetail.gioiTinh == 'Nam'}">checked</c:if>
            >
            <label class="form-check-label">
                Nam
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Nu" name="gioiTinh"
                   <c:if test="${sinhVienDetail.gioiTinh == 'Nu'}">checked</c:if>>
            <label class="form-check-label">
                Nu
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
        <td>STT</td>
        <td> ma sinh vien</td>
        <td> ho ten</td>
        <td> dia chi</td>
        <td> Tuoi</td>
        <td> Lop</td>
        <td> Gioi Tinh</td>
        <td> Thao Tác</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSinhVien}" var="sinhvien" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${sinhvien.maSV}</td>
            <td>${sinhvien.tenSV}</td>
            <td>${sinhvien.diaChi}</td>
            <td>${sinhvien.tuoi}</td>
            <td>${sinhvien.tenLop}</td>
            <td>${sinhvien.gioiTinh}</td>
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
