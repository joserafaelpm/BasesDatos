<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Platillos</title>
</head>
<body>
<jsp:useBean class="modelo.PlatilloDAO" id = "platilloDAO" ></jsp:useBean>
<h1><b>Lista Platillos</b></h1>
  	<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nombre</th>
      <th scope="col">Precio</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Url Imagen</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${platilloDAO.list()}" var = "platillo" >
    <tr>
      <td><c:out value="${platillo.id}" /></td>
      <td><c:out value="${platillo.nombre}" /></td>
      <td><c:out value="${platillo.precio}" /></td>
      <td><c:out value="${platillo.descripcion}" /></td>
      <td><c:out value="${platillo.urlImagen}" /></td>
      <td><a href="PlatilloServlet?action=eliminar&id=${platillo.id}">Eliminar</a></td>
      <td><a href="PlatilloServlet?action=mostrar&id=${platillo.id}">Editar</a></td>
    </tr>
 </c:forEach>
  </tbody>
</table>
</body>
</html>