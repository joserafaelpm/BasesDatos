<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Ordenes</title>
</head>
<body>
<jsp:useBean class="modelo.ClienteDAO" id = "clienteDAO" ></jsp:useBean>
<jsp:useBean class="modelo.PersonaDAO" id = "personaDAO" ></jsp:useBean>
<jsp:useBean class="modelo.ChefDAO" id = "chefDAO" ></jsp:useBean>
<jsp:useBean class="modelo.CamareroDAO" id = "camareroDAO" ></jsp:useBean>
<jsp:useBean class="modelo.DomicilioDAO" id = "domicilioDAO" ></jsp:useBean>
<jsp:useBean class="modelo.OrdenDAO" id = "ordenDAO" ></jsp:useBean>
<jsp:useBean class="modelo.EmpleadoDAO" id = "empleadoDAO" ></jsp:useBean>
<h1><b>Lista De Ordenes</b></h1>
  	<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Cliente</th>
      <th scope="col">Chef</th>
      <th scope="col">Camarero</th>
      <th scope="col">Domicilio</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${ordenDAO.list()}" var = "orden" >
    <tr>
      <td><c:out value="${orden.id}" /></td>
      <td><c:out value="${orden.cliente.persona.getNombre()}" /></td>
      <td><c:out value="${orden.chef.empleado.persona.getNombre()}" /></td>
      <td><c:out value="${orden.camarero.empleado.persona.getNombre()}" /></td>
      <td><c:out value="${orden.domicilio.getDestino()}" /></td>
      <td><a href="OrdenServlet?action=eliminar&id=${orden.id}">Eliminar</a></td>
      <td><a href="OrdenServlet?action=mostrar&id=${orden.id}">Editar</a></td>
    </tr>
 </c:forEach>
  </tbody>
</table>
</body>
</html>