<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<%--  --%>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  </script>
<title> Registro de Clientes</title>
</head>
<body>
<jsp:useBean class="modelo.PersonaDAO" id="personaDAO"></jsp:useBean>
<h1><b>Registro de Clientes</b></h1>
<c:if test="${empleado != null}">
                           <%--  <form action="${pageContext.request.contextPath}/ActualizarEmpleado?accion=edita&codigo=${empleado.codigo}"  method="post"> --%>
                           <form action="EmpleadoServlet?action=actualizar&id=${empleado.id}"  method="POST">
                        </c:if>
                        <c:if test="${empleado == null}">
                           <%--  <form action="${pageContext.request.contextPath}/AgregarEmpleado?accion=agregar&codigo=${empleado.codigo}"  method="POST"> --%>
                            <form action="EmpleadoServlet?action=registrar"  method="POST">
                        </c:if>

  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Cedula:</label>
    <div class="col-sm-10">
    <select class="form-control" id="exampleFormControlSelect1" name="cedula">
		   <c:forEach items="${personaDAO.list()}" var="persona">
				<option value="${persona.cedula}" >
         <c:out value="${persona.nombre} "/>
         </option>
         </c:forEach>
        </select>
    </div>
  </div>
  
    <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Cargo:</label>
    <div class="col-sm-10">
    <select class="form-control" id="exampleFormControlSelect1" name="cargo">
			<option value = "${empleado.cargo}" > <c:out value="${empleado.cargo} "/> </option>
			<option >Camarero</option>
			<option>Chef</option>
        </select>
    </div>
  </div>

  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Registrar</button>
     <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary">Volver</a>
    </div>
    </div>
</form>
</body>
</html>