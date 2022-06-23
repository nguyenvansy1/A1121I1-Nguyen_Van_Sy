<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/22/2022
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save" method="post">
    <input type="checkbox" name="check" value="Lettuce"> Lettuce
    <input type="checkbox" name="check" value="Tomato"> Tomato
    <input type="checkbox" name="check" value="Mustard"> Mustard
    <input type="checkbox" name="check" value="Sprouts"> Sprouts
    <button type="submit" name="">Save</button>
</form>
<c:forEach items="${list}" var="choice">
    <p>${choice}</p>
</c:forEach>

</body>
</html>
