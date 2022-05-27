<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 05/06/2022
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <style>
        table, th, td{
            border-top:1px solid #ccc;
            border-bottom:1px solid #ccc;
        }
        table{
            border-collapse:collapse;
            margin-left: 200px;
        }
        tr:hover{
            background-color:#ddd;
            cursor:pointer;
        }
        th, td {
            padding: 10px;
        }

        th {
            text-align:left;
            width: 200px;
        }


    </style>
</head>
<body>
<div style="text-align:center">
    <h1 >User Management</h1>

    <caption style="text-align:center"><h2 >List of Users</h2></caption>
</div>

<div style="text-align:center">
    <table >
        <h2>
            <a  href="/users?action=create">Add New User</a>
        </h2>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>