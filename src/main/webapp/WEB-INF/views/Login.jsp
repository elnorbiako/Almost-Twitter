<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 13.05.18
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>

<h2>Please login with Your email and password</h2>
<h2 style="color: crimson"><strong>${err}</strong></h2>

<form:form method="post" modelAttribute="user">
    <form:errors path="*"/>

    Email: <form:input path="email" placeholder="email"/>
    <form:errors path="email"/>

    Password: <form:input path="password" type="password"/>

    <input type="submit" value="login"/>


</form:form>


<a href="/addUser">Add a new user</a><br>

</body>
</html>
