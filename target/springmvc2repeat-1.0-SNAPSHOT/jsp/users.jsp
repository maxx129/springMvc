<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <link href="../css/style.css" rel="stylesheet" type="text/css">

    <title>Title</title>
</head>
<body>


<div class="form-style-2">
    <div class="form-style-2-heading">Please Sign Up</div>

    <form method="post" action="/users">
        <label for="firstName">First Name
            <input class="input-field" type="text" id="firstName" name="firstName">
        </label>

        <label for="lastName">Last Name
            <input class="input-field" type="text" id="lastName" name="lastName">
        </label>
        <input type="submit" value="Add user">
    </form>
</div>



<div class="form-style-2">
    <div class="form-style-2-heading">Already Registered</div>
    <table>
        <tr>
            <th>First name</th>
            <th>Last name</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</div>



</body>
</html>
