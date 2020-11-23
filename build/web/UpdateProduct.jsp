<%-- 
    Document   : UpdateProduct
    Created on : Jun 30, 2020, 7:41:59 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
    </head>
    <body>
        <form action="ProductServlet">
            <table>
                <tr>
                    <td>Product Id</td>
                    <td><input type="text" name="productId" value="${pro.productId}" readonly="true"/></td>
                </tr>
                <tr>
                    <td>Product Name</td>
                    <td><input type="text" name="productName" value="${pro.productName}"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" value="${pro.price}"/></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><input type="text" name="title" value="${pro.title}"/></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="description" value="${pro.description}"/></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td><input type="text" name="status" value="${pro.status}"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Update" name="action"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
