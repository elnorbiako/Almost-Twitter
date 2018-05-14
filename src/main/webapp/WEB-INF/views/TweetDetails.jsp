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
    <title>Tweet Details</title>
</head>
<body>

<h3>Tweet Details</h3>


<li>
            <span><strong>${tweet.title}</strong> <br>
                    ${tweet.tweetText} <br>
                ${user.username}  <i>${tweet.created}</i>
            </span>

</li>
<h3>Comments:</h3>
<ul>
    <c:forEach items="${comments}" var="comment">

        <li>
            <span> ${comment.commentText} <br>
                <i>${comment.created}</i>  </span>
        </li>
    </c:forEach>
</ul>


Add new tweet:
<form:form method="post" modelAttribute="comment">
    <form:errors path="*"/>

    Comment text: <form:textarea path="commentText" rows="2" cols="30" placeholder="Text"/>
    <form:errors path="commentText"/>

    <form:hidden path="user.id" value="${loggedUserId}"></form:hidden>
    <input type="submit" value="save"/>


</form:form>




<a href="/home">Back to main page</a><br>
</body>
</html>

