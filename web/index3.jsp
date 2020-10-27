<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practica # 3</title>
    </head>
    <body>
        <h1>Productos</h1>
        <p><a href="inicio3?action=add">Nuevo Producto</a></p>

        <table border="1">
            <tr>
                <th><b>Id</b></th>
                <th><b>Producto</b></th>
                <th><b>Precio</b></th>
                <th><b>Cantidad</b></th>
                <th><b>Modificar</b></th>
                <th><b>Eliminar</b></th>
            </tr>
            <c:forEach var="item" items="${productos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre_producto}</td>
                    <td>${item.precio}</td>
                    <td>${item.stock}</td>
                    <td><a href="inicio3?action=edit&id=${item.id}">Modificar</a></td>
                    <td><a href="inicio3?action=delete&id=${item.id}" onclick="return(confirm('Esta Seguro'))">Eliminar</a></td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>

