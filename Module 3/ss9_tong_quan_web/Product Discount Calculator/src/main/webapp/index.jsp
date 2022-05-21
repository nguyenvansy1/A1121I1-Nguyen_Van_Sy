<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/30/2022
  Time: 12:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <style>
    #nav {
      height: 250px;
      width:  500px;
      margin-left: 400px ;
      border: 1px solid;
    }
    label {
      margin-bottom: 50px;
      padding-left: 10px;
    }
    #sub_nav input{
      margin-top: 20px ;

    }
  </style>
</head>
<body>
<div id="nav" >
  <h2 style="text-align: center">Product Discount Calculator</h2>
  <form action="/calculator" method="post">
    <div id="sub_nav">
      <label>Product Description:</label>
      <input type="text" name="description">
      <br>

      <label>List Price:</label>
      <input style="margin-left: 65px"type="text" name="price">
      <br>

      <label>Discount Percent:</label>
      <input style="margin-left: 17px"type="text" name="percent">
      <br>

      <button style="margin-top: 20px;margin-left: 180px" type="submit">Calculate Discount</button>

    </div>
  </form>
</div>
</body>
</html