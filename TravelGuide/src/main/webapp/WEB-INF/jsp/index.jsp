<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-success">Danh mục sản phẩm</h1>

<table class="table table-bordered">
    <thead>
        <tr>
            <th scope="col">Mã SP</th>
            <th scope="col">Tên SP</th>
            <th scope="col">Giá bán</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
