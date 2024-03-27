<%--
  Created by IntelliJ IDEA.
  User: Mr Ngân
  Date: 3/25/2024
  Time: 3:04 PM
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
<form action="/san-pham/add" method="post">
    <!-- Khu vực id -->
    <div class="mt-3">
        <span class="form-label">Mã San Pham:</span>
        <input name="maSanPham" class="form-control" type="text">
    </div>

    <!-- Khu vực tên -->
    <div class="mt-3">
        <span class="form-label">Tên San Pham:</span>
        <input name="tenSanPham"  class="form-control" type="text">
    </div>
    <div class="row">
        <p class="col-4">Trang thai
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Active" name="trangThai">
            <label class="form-check-label">
                Active
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Inactive" name="trangThai">
            <label class="form-check-label">
                Inactive
            </label>
        </div>
    </div>
    <div class="mt-3">
        <span class="form-label"> ten danh muc :</span>
        <select name="danhMuc"  class="form-control">
           <c:forEach items="${listDM}" var="dm">
               <option value="${dm.id}">${dm.id}</option>
           </c:forEach>
        </select>
    </div>
    <div class="mt-3">
        <button  type="submit" class="btn btn-primary" >Submit</button>
    </div>
</form>


<table class="table container">
    <thead>
    <tr>
        <td>ID</td>
        <td> ma san pham</td>
        <td> ten san pham    </td>
        <td> trang thai</td>
        <td> ngay tao</td>
        <td> ngay sua</td>
        <td> id danh muc </td>
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
            <td>${sp.danhMuc.tenDanhMuc}</td>
            <td>
                <a href="/san-pham/delete?id=${sp.id}" class="btn btn-primary">xoa</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
