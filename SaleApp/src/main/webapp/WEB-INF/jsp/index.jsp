<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travel Guide</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1 style="color:red">${message}</h1>
        
        <ul>
            <c:forEach items="${categories}" var="cat">
                <li>${cat.id} - ${cat.name}</li>
            </c:forEach>
        </ul>
    </body>
</html>
