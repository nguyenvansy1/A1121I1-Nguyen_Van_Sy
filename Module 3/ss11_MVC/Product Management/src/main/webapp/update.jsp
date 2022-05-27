<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2022
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<form  action="/product" method="post">
    <input type="hidden" name="action" value="update">

    <fieldset>
        <legend>Update Product</legend>
        <table>
            <input type="hidden" name="id" value="${updateProduct.id}">
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
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
