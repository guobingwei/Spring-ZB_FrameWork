<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <c:if test="${!empty error}">
        <c:out value="${error}"/>
    </c:if>
    <form action="<c:url value="/loginCheck.html"/>" method="post">
        用户名：
        <input type="text" name="userName">
        <br>
        密 码：
        <input type="password" name="password">
        <br>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
