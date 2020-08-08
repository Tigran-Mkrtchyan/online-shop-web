<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: dimgray">
<div style="width: 500px; border: 2px solid ; margin: 100px auto ">
    <form action="${pageContext.request.contextPath}/register" method="post" >
        <table>
            <tr>
                <td>Phone:</td>
                <td><label>
                    <input name= "phone" type="text" style="width: 100%"/>
                </label></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><label>
                    <input name= "pass" type="password" style="width: 100%"/>
                </label></td>
            </tr>
            <tr>
                <td> Name:</td>
                <td><label >
                    <input name="name" type="text" style="width: 100%"/>
                </label></td>
            </tr>

        </table>
        <input type="submit" value="SignUp" style="width: 30% ;margin: 10px 150px"/>
    </form>
    <c:if test="${param['error'] != null}">
        <p> Invalid Phone Number</p>

    </c:if>
</div>
</body>
</html>
