<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Ingrediente Platillo</title>
</head>
<body>
<jsp:useBean class="modelo.IngredientePlatilloDAO" id = "ingredienteplatilloDAO" ></jsp:useBean>
<jsp:useBean class="modelo.IngredientesplatillopkDAO" id = "ingredienteplatillopkDAO" ></jsp:useBean>
<h1><b>Lista Persona</b></h1>
  	<table class="table">
  <thead>
    <tr>
      <th scope="col">Id Ingrediente</th>
      <th scope="col">Id Platillo</th>
      <th scope="col">Peso</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${ingredienteplatilloDAO.list()}" var = "ingredienteplatillo" >
    <tr>
      <td><c:out value="${ingredienteplatillo.ingrediente.getNombre()}" /></td>
      <td><c:out value="${ingredienteplatillo.platillo.getNombre()}" /></td>
      <td><c:out value="${ingredienteplatillo.peso}" /></td>
    </tr>
 </c:forEach>
  </tbody>
</table>
</body>
</html>