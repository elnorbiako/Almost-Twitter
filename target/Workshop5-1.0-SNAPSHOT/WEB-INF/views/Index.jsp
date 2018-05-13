<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 12.05.18
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>

<%--Okej <br>--%>

<%--<a href="/user/{id}/tweets">Tweets</a><br>--%>
<%--<a href="/user/search-tweets/{titlePart}">Search Tweets</a><br>--%>
<%--<a href="/user/add">User Add</a><br>--%>
<%--<a href="/tweet/add">Tweet Add</a><br>--%>
<%--<a href="/user/clear">Delete All Users along with Tweets  --- ACHTUNG ----</a><br>--%>
<div align="right">
<a href="/logout"><strong>Logout</strong></a><br>
</div>

Add new tweet:
<form:form method="post" modelAttribute="tweet">
    <form:errors path="*"/>

    Title: <form:input path="title" placeholder="Title"/>
    <form:errors path="title"/>

    Tweet text: <form:textarea path="tweetText" rows="3" cols="20" placeholder="Text"/>
    <form:errors path="tweetText"/>

    <form:hidden path="user.id" value="${loggedUserId}"></form:hidden>
    <input type="submit" value="save"/>


</form:form>




<h3>Tweets:</h3>
<ul>
    <c:forEach items="${tweets}" var="tweet">

        <li>
            <span><strong>${tweet.title}</strong> <br>
                    ${tweet.tweetText}     <i>${tweet.created}</i></span>
                <%--<a href="book/delete/${book.id}"> Delete</a>--%>
                <%--<a href="book/edit/${book.id}"> Edit</a>--%>
                <%----%>
        </li>
    </c:forEach>
</ul>


</body>
</html>

