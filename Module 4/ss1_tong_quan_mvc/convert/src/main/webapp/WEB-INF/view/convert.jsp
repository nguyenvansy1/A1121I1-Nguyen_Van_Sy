<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/21/2022
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert" method="post">
<label>USD</label>
<input type="number" name="convert">
<button type="submit">Convert</button>
</form>
<p>Result: ${result}</p>
</body>
</html>
