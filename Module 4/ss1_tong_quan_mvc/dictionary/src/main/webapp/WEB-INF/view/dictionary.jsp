<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/21/2022
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="post">
<label>English</label>
<input type="text" name="eng">
<p style="color:red">${mess}</p>
<p>Result: ${result}</p>
<button type="submit" >Convert</button>
</form>
</body>
</html>
