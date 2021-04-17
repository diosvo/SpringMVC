<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/main.css"/>" 
      rel="stylesheet" />

<h1 class="text-center text-info">GIỎ HÀNG</h1>

<div class="alert alert-warning">
    <h1>Tổng số lượng: ${cartStats.totalQuantity}</h1>
    <h1>Tổng tiền: ${cartStats.totalAmount} VNĐ</h1>
</div>

<table class="table">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Đơn giá</th>
        <th>Số lượng</th>
    </tr>
    <c:if test="${cart == null}">
        <tr>
            <td colspan="4">Không có sản phẩm nào trong giỏ!!!</td>
        </tr>
    </c:if>
    <c:if test="${cart != null}">
        <c:forEach items="${cart.values()}" var="c">
            <tr>
                <td>${c.productId}</td>
                <td>${c.productName}</td>
                <td>${c.price}</td>
                <td>
                    <input class="form-control" type="number" value="${c.quantity}" />
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<input type="button" value="Thanh toán" class="btn btn-danger" />
