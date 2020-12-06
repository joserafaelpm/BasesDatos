<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Heroes</title>
</head>
<body>
<jsp:useBean class="modelo.TipoDeIngredienteDAO" id = "tipoingredienteDAO" ></jsp:useBean>
<h1><b>Lista De Ingredientes</b></h1>
  	<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Descripcion</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${tipoingredienteDAO.list()}" var = "tipoingrediente" >
    <tr>
      <td><c:out value="${tipoingrediente.id}" /></td>
      <td><c:out value="${tipoingrediente.descripcion}" /></td>
      <td><a href="TipoDeIngredienteServlet?action=eliminar&id=${tipoingrediente.id}">Eliminar</a></td>
      <td><a href="TipoDeIngredienteServlet?action=mostrar&id=${tipoingrediente.id}">Editar</a></td>
    </tr>
 </c:forEach>
  </tbody>
</table>
</body>
</html>