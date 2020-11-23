<%-- 
    Document   : NewProduct
    Created on : Jun 30, 2020, 7:20:56 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Product</title>
    </head>
    <body>
        <form action="ProductServlet">
            <table>
                <tr>
                    <td>Product Id</td>
                    <td><input type="text" name="productId"/></td>
                </tr>
                <tr>
                    <td>Product Name</td>
                    <td><input type="text" name="productName"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price"/></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><input type="text" name="title"/></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="description"/></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td><input type="text" name="status"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Create" name="action"/></td>
                </tr>
            </table>
        </form>

    </body>
</html>
