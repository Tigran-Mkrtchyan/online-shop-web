<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>List</title>
</head>
<body>
<div style="width: 400px; height: 600px; margin: 200px auto;">
    <h1>Login</h1>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>
            Phone number: <input name="phoneNumber" type="text" value="test"/>
        </label>
        <br/>
        <label>
            Password: <input name="password" type="password" value="test">
        </label>
        <br/>
        <c:if test="${param['error'] != null}">
            <p>Invalid login or password</p>
            <br/>
        </c:if>
        <input type="submit" value="Login"/>
    </form>
</div>
</body>
</html>
