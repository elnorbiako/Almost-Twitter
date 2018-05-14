<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 13.05.18
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form:form  method="post" modelAttribute="user">
    <form:input path="username" placeholder="${user.username}"/>
    <form:errors path="username"/>


    <form:input path="email" placeholder="${user.email}"/>
    <form:errors path="email"/>

    Password: <form:input path="password" type="password"/>

    <%--<form:hidden path="user.id" value="${loggedUserId}"></form:hidden>--%>
    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
