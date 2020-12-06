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
<jsp:useBean class="modelo.ClienteDAO" id = "clienteDAO" ></jsp:useBean>
<h1><b>Lista Persona</b></h1>
  	<table class="table">
  <thead>
    <tr>
      <th scope="col">Cedula</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${clienteDAO.list()}" var = "cliente" >
    <tr>
      <td><c:out value="${cliente.cedula}" /></td>
      <td><a href="ClienteServlet?action=eliminar&cedula=${cliente.cedula}">Eliminar</a></td>
      <td><a href="ClienteServlet?action=mostrar&cedula=${cliente.cedula}">Editar</a></td>
    </tr>
 </c:forEach>
  </tbody>
</table>
</body>
</html>