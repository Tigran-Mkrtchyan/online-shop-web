<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Online shop</title>
</head>
<body style="width: 800px; margin: 0 auto">
<div style="width: 100%; height: 60px;">
    <a href="${pageContext.request.contextPath}/">
        <img style="float:left; width: 60px; height: 60px;" alt="Logo"
             src="https://seeklogo.net/wp-content/uploads/2017/02/shopify-logomark-logo.png"/>
    </a>
    <form>
        <label>
            <input style="float: left; width: 400px; margin-left: 40px; margin-top: 15px; height: 30px;" type="text" placeholder="Search"/>
        </label>
    </form>

    <c:if test="${loggedInUser == null}">
        <a href="${pageContext.request.contextPath}/login">
            <button style="float: right; margin-right: 10px; margin-top: 17px; width: 80px; height: 26px;">Login</button>
        </a>
        <a href="${pageContext.request.contextPath}/register">
            <button style="float: right; margin-right: 10px; margin-top: 17px; width: 80px; height: 26px;">Register</button>
        </a>
    </c:if>

    <c:if test="${loggedInUser != null}">
        <a href="${pageContext.request.contextPath}/logout">
            <button style="float: right; margin-right: 10px; margin-top: 17px; width: 80px; height: 26px;">Logout</button>
        </a>
        <a href="${pageContext.request.contextPath}/profile">
            <button style="float: right; margin-right: 10px; margin-top: 17px; width: 80px; height: 26px;">Profile</button>
        </a>
    </c:if>
</div>
<div style="width: 100%;">
    <c:forEach var="post" items="${posts}">
        <a style="text-decoration: none; color: black;" href="${pageContext.request.contextPath}/posts/${post.id}">
            <div style="margin: 10px;">
                <img style="width: 150px; height: 150px;" alt="Post" src="${post.imageUrl}"/>
                <p>${post.header}</p>
                <p>${post.price}</p>
            </div>
        </a>
    </c:forEach>
</div>
</body>
</html>
