<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/1/2022
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
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
<h1 style="text-align: center">Danh sách khách hàng</h1>
<table>
    <th>STT</th>
    <th>Tên</th>
    <th>Ngày Sinh</th>
    <th>Địa Chỉ</th>
    <th>Ảnh</th>

    <c:forEach items="${list}" var="khach_hang" varStatus="status">
        <tr>
             <td>${status.count}</td>
             <td>${khach_hang.name}</td>
             <td>${khach_hang.birthday}</td>
             <td>${khach_hang.address}</td>
            <td><img src="${khach_hang.img}"></td>
        </tr>
    </c:forEach>



</table>
</body>
</html>
