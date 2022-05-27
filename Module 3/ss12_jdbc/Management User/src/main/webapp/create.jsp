<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 05/06/2022
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <style>
        th, td {
            padding: 4px;
        }


    </style>
</head>
<body>

    <h1 style="text-align:center">User Management</h1>
    <div align="center" >
        <form method="post" style="width:500px">
            <fieldset>
                <legend>Add User</legend>
                <table >
                    <tr>
                        <td>User New Name:</td>
                        <td>
                            <input type="text" name="name" id="name" size="40"/>
                        </td>
                    </tr>
                    <tr>
                        <td>User Email:</td>
                        <td>
                            <input type="text" name="email" id="email" size="40"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Country:</td>
                        <td>
                            <input type="text" name="country" id="country" size="15"/>
                        </td>
                    </tr>
                    <tr>

                        <td>
                            <button> <a href="users?action=users" style="color: black;text-decoration: none">Back To List</a></button>
                        </td>
                        <td style="padding-left: 90px">
                            <input type="submit" value="Create User"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</body>
</html>
