<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<table class="table table-dark">
    <form action="" method="post">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="/sinh-vien/view-add">Add Student</a></button>
    <tr>
        <th>STT</th>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${abc}" var="sv" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${sv.maSV}</td>
            <td>${sv.ten}</td>
            <td>${sv.diaChi}</td>
            <td>${sv.tuoi}</td>
            <td>${sv.gioiTinh}</td>
            <td>
                <a href="/sinh-vien/detail?viTri=${i.index}" class="btn btn-primary">detail</a>
                <a href="/sinh-vien/view-update?viTri=${i.index}" class="btn btn-success">edit</a>
                <a href="/sinh-vien/remove?viTri=${i.index}" class="btn btn-warning">remove</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
