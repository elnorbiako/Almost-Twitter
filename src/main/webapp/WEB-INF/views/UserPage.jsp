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
    <title>User Page</title>
</head>
<body>

<h3>Your Tweets:</h3>
<ul>
    <c:forEach items="${tweets}" var="tweet">

        <li>
            <span><strong>${tweet.title}</strong> <br>
                    ${tweet.tweetText}     <i>${tweet.created}</i>  <a href="/tweet/${tweet.id}">Details</a></span>
                <%--<a href="book/delete/${book.id}"> Delete</a>--%>
                <%--<a href="book/edit/${book.id}"> Edit</a>--%>
                <%----%>
        </li>
    </c:forEach>
</ul>

<a href="/home">Back to main page</a><br>
</body>
</html>

