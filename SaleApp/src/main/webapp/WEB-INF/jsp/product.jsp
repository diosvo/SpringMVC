<%-- 
    Author     : diosvo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" 
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" 
           uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center">Trang sản phẩm</h1>

<!--path = its property in pojo-->
<c:url value="/product/add" var="action" />
<form:form method="post" 
           action="${action}"
           modelAttribute="product">
    <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />
    <div class="form-group">
        <label><spring:message code="product.name" /></label>
        <form:input cssClass="form-control" path="name" />
    </div>
    <div class="form-group">
        <label><spring:message code="product.desc" /></label>
        <form:input cssClass="form-control" path="description" />
    </div>
    <div class="form-group">
        <label><spring:message code="product.price" /></label>
        <form:input cssClass="form-control" path="price" />
    </div>
    <div class="form-group">
        <label><spring:message code="product.category" /> </label>
        <form:select path="category" cssClass="form-control">
            <c:forEach items="${categories}" var="cate">
                <c:if test="${cate.id == product.category.id}">
                    <option selected value="${cate.id}">${cate.name}</option>
                </c:if>
                <c:if test="${cate.id != product.category.id}">
                    <option value="${cate.id}">${cate.name}</option>
                </c:if>
            </c:forEach>
        </form:select>
    </div>
    <div>
        <form:hidden path="id" />
        <input type="submit" class="btn btn-danger" value="<spring:message code="product.submit" />" />
    </div>

</form:form>