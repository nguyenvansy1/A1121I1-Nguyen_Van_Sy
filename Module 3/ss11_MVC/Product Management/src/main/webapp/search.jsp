<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 05/05/2022
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management</title>
    <style>
        table, th, td{
            border-top:1px solid #ccc;
            border-bottom:1px solid #ccc;
        }
        table{
            border-collapse:collapse;
            margin-left: 150px;
            margin-top: 60px;

        }
        tr:hover{
            background-color:#ddd;
            cursor:pointer;
        }
        th, td {
            padding: 10px;
        }

        table#alter tr:nth-child(odd) {
            background-color: #fff;
        }


        th {
            text-align: left;
            width: 150px;
        }


    </style>
</head>
<body>
<h1 style="text-align: center">Danh sách sản phẩm</h1>

<table>
    <th>STT</th>
    <th>Id</th>
    <th>Name Product</th>
    <th>Product Price</th>
    <th>Description</th>
    <th>Manufacturer</th>
    <th colspan="2"></th>


    <c:forEach items="${listsearch}" var="product1" varStatus="status" >
        <tr>
            <td>${status.count}</td>
            <td>${product1.id}</td>
            <td><a href="/product?action=detail&id=${product1.id}">${product1.name}</a></td>
            <td>${product1.price}</td>
            <td>${product1.description}</td>
            <td>${product1.manufacturer}</td>
            <td><button><a href="/product?action=update&id=${product1.id}">Update</a></button></td>
            <td><button><a href="/product?action=delete&id=${product1.id}">Delete</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>