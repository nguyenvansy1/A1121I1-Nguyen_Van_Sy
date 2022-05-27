<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creating page</title>
</head>
<body>


    <fieldset>
        <legend>Information Product</legend>
        <table>
            <tr>
                <td>Id:</td>
                <td><c:out value="${infoProduct.id}"></c:out></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><c:out value="${infoProduct.name}"></c:out></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><c:out value="${infoProduct.price}"></c:out></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><c:out value="${infoProduct.description}"></c:out></td>
            </tr>
            <tr>
                <td>Manufacturer:</td>
                <td><c:out value="${infoProduct.manufacturer}"></c:out></td>
            </tr>

        </table>
    </fieldset>

</body>
</html>