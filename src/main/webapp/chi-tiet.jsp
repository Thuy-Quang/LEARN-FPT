<%--
  Created by IntelliJ IDEA.
  User: Mr Ngân
  Date: 3/15/2024
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<form action="/sinh-vien/update" method="post">
    <!-- Khu vực id -->
    <div class="mt-3">
        <span class="form-label">Mã Sinh Viên :</span>
        <input name="maSV" class="form-control" type="text" value="${sinhVienDetail.maSV}">
    </div>

    <!-- Khu vực tên -->
    <div class="mt-3">
        <span class="form-label">Tên Sinh Viên:</span>
        <input name="tenSV"  class="form-control" type="text" value="${sinhVienDetail.tenSV}">
    </div>

    <!-- Khu vực giá -->
    <div class="mt-3">
        <span class="form-label">Tuổi:</span>
        <input name="tuoi"  class="form-control" type="text" value="${sinhVienDetail.tuoi}">
    </div>
    <div class="mt-3">
        <span class="form-label">Địa Chỉ:</span>
        <input name="diaChi"  class="form-control" type="text" value="${sinhVienDetail.diaChi}">
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
        <button  type="submit" class="btn btn-primary" >Update</button>
    </div>




</form>
</body>
</html>
