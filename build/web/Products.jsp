<%-- 
    Document   : Products
    Created on : Jun 30, 2020, 7:09:20 PM
    Author     : ADMIN
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Product</title>
    </head>
    <body>
        <table border="1">
            <thead>
            <th>Product Id</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Title</th>
            <th>Description</th>
            <th>Status</th>
            <th>Action</th>
            </thead>
            <tbody>
                <c:forEach items="${listProduct}" var="pro">
                    <tr>
                        <td>${pro.productId}</td>
                        <td>${pro.productName}</td>
                        <td>${pro.price}</td>
                        <td>${pro.title}</td>
                        <td>${pro.description}</td>
                        <td>${pro.status}</td>
                        <td>
                            <a href="ProductServlet?productId=${pro.productId}&&action=initUpdate">Update</a>
                            <a href="ProductServlet?productId=${pro.productId}&&action=Delete">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="NewProduct.jsp">Create new Product</a>
    </body>
</html>
