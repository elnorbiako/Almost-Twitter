<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 11.05.18
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <form:errors path="*"/>

    <h2>Add new user:</h2>
    <h2 style="color: crimson"><strong>${err}</strong></h2>

    Username: <form:input path="username" placeholder="Username"/>
    <form:errors path="username"/>

    Email: <form:input path="email" placeholder="email"/>
    <form:errors path="email"/>

    Password: <form:input path="password" type="password"/>

    <input type="submit" value="save"/>


</form:form>

</body>



</html>