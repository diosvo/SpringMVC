<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/main.css"/>" 
      rel="stylesheet" />

<h1 class="text-center text-success">Danh mục sản phẩm</h1>

<table class="table table-bordered">
    <thead>
        <tr>
            <th scope="col">Mã SP</th>
            <th scope="col">Tên SP</th>
            <th scope="col">Giá bán</th>
            <th scope="col">Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="p">
            <tr id="product${p.id}">
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>
                    <a href="javascript:;" class="btn btn-danger" onclick="deleteProduct(${p.id})">Xóa</a>
                    <a href="javascript:;" class="btn btn-info">Cập nhật</a>
                    <a href="javascript:;" class="btn btn-success">Thêm</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<script src="<c:url value="js/main.js"/>"></script>
