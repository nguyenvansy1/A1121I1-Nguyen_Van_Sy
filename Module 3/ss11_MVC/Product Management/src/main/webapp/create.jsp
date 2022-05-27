<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/2/2022
  Time: 2:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creating page</title>
</head>
<body>
<form  action="/product" method="post">
    <input type="hidden" name="action" value="create">
    <fieldset>
        <legend>Add Product</legend>
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="text" name="id" ></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" ></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" ></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="description" ></td>
            </tr>
            <tr>
                <td>Manufacturer:</td>
                <td><input type="text" name="manufacturer" ></td>
            </tr>
            <tr>
                <td><input type="submit" value="Create product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
