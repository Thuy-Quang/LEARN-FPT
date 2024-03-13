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
        <input name="maSinhVien" class="form-control" type="text">
    </div>

    <!-- Khu vực tên -->
    <div class="mt-3">
        <span class="form-label">Tên Sinh Viên:</span>
        <input name="tenSinhVien"  class="form-control" type="text">
    </div>

    <!-- Khu vực giá -->
    <div class="mt-3">
        <span class="form-label">Tuổi:</span>
        <input name="tuoi"  class="form-control" type="text">
    </div>
    <div class="mt-3">
        <span class="form-label">Địa Chỉ:</span>
        <input name="diaChi"  class="form-control" type="text">
    </div><div class="mt-3">
        <span class="form-label">Tên Lớp:</span>
        <select class="form-control" name="tenLop" >
            <option value="SD123">SD123</option>
            <option value="SD321">SD321</option>
            <option value="SD234">SD234</option>
        </select>
    </div>
    <div class="mt-3 d-flex row">
        <span class="form-label col-4">Giới Tính:</span>
        <div class="form-check d-flex col-4 ">
            <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>Nam
            <label class="form-check-label" for="radio1"></label>
        </div>
        <div class="form-check col-4">
            <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Nữa
            <label class="form-check-label" for="radio2"></label>
        </div>

    </div>
    <div class="mt-3">
        <button type="submit" class="btn btn-primary" >Submit</button>
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
            <td>
                <button class="btn btn-info">detail</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
