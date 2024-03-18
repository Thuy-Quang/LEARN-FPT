<%--
  Created by IntelliJ IDEA.
  User: Mr Ngân
  Date: 3/15/2024
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    </div>
    <div class="mb-3">
        <label for="disabledSelect" class="form-label">Ten lop</label>
        <select id="disabledSelect" class="form-select" name="lop">
            <c:forEach items="${tenLop}" var="lop">
                <option value="${lop}"
                        <c:if test="${sinhVienDetail.tenLop == lop}">selected</c:if>>
                ${lop}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="mt-3 d-flex row">
        <span class="form-label col-4">Giới Tính:</span>
        <div class="form-check d-flex col-4 ">
            <input type="radio" class="form-check-input" id="radio1" name="gioiTinh" value="Nam"
                <c:if test="${sinhVienDetail.gioiTinh == 'Nam'}">checked</c:if>>
            <label class="form-check-label" for="radio1">Nam</label>
        </div>
        <div class="form-check col-4">
            <input type="radio" class="form-check-input" id="radio2" name="gioiTinh" value="Nu"
                <c:if test="${sinhVienDetail.gioiTinh == 'Nu'}" >checked</c:if>>
            <label class="form-check-label" for="radio2">Nu</label>
        </div>

    </div>
    <div class="mt-3">
        <button  type="submit" class="btn btn-primary" >Update</button>
    </div>




</form>
</body>
</html>
