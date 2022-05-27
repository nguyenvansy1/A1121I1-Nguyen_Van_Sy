<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/2/2022
  Time: 1:42 AM
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
<button style="float: right;margin-right: 200px"><a href="/product?action=create">Create Product</a></button>
<form action="get">
<input type="text" name="searchProduct">
<button type="submit"><a href="/product?action=search">Search</a></button>
</form>
<button style="float: right;margin-right: 100px"><a href="/product?action=sortProduct">Sort Product</a></button>
<p style="color:red">${message}</p>
<table>
    <th>STT</th>
    <th>Id</th>
    <th>Name Product</th>
    <th>Product Price</th>
    <th>Description</th>
    <th>Manufacturer</th>
    <th colspan="2"></th>


    <c:forEach items="${list}" var="product" varStatus="status" >
        <tr>
            <td>${status.count}</td>
            <td>${product.id}</td>
            <td><a href="/product?action=detail&id=${product.id}">${product.name}</a></td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.manufacturer}</td>
            <td><button><a href="/product?action=update&id=${product.id}">Update</a></button></td>
            <td><button><a href="/product?action=delete&id=${product.id}">Delete</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
