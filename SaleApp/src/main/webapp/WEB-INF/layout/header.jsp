<%-- 
        Author     : diosvo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<c:url value="/" />">Trang chủ</a>
                </li>

                <c:forEach items="${categories}" var="cat">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/" />?cateId=${cat.id}">${cat.name}</a>
                    </li>
                </c:forEach>

                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/stats" />">
                        Thống kê
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link text-warning" href="<c:url value="/cart" />">
                        Giỏ hàng 
                        <span class="badge badge-danger" id="cart-counter">${cartStats.totalQuantity}</span>
                    </a>
                </li>
            </ul>

            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>