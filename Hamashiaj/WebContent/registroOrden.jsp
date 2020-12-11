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
<title> Registro de Orden</title>
</head>
<body>
<jsp:useBean class="modelo.ClienteDAO" id="clienteDAO"></jsp:useBean>
<jsp:useBean class="modelo.ChefDAO" id="chefDAO"></jsp:useBean>
<jsp:useBean class="modelo.CamareroDAO" id="camareroDAO"></jsp:useBean>
<jsp:useBean class="modelo.DomicilioDAO" id="domicilioDAO"></jsp:useBean>
<jsp:useBean class="modelo.EmpleadoDAO" id="empleadoDAO"></jsp:useBean>
<jsp:useBean class="modelo.PersonaDAO" id="personaDAO"></jsp:useBean>
<h1><b>Registro de Orden</b></h1>
<c:if test="${orden != null}">
                           <%--  <form action="${pageContext.request.contextPath}/ActualizarEmpleado?accion=edita&codigo=${empleado.codigo}"  method="post"> --%>
                           <form action="OrdenServlet?action=actualizar&id=${orden.id}"  method="POST">
                        </c:if>
                        <c:if test="${orden == null}">
                           <%--  <form action="${pageContext.request.contextPath}/AgregarEmpleado?accion=agregar&codigo=${empleado.codigo}"  method="POST"> --%>
                            <form action="OrdenServlet?action=registrar"  method="POST">
                        </c:if>

  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Cliente:</label>
    <div class="col-sm-10">
    <select class="form-control" id="exampleFormControlSelect1" name="cedula">
    <option value = "${orden.cliente.getCedula()}" > <c:out value="${orden.cliente.persona.getNombre()} "/> </option>
		   <c:forEach items="${clienteDAO.list()}" var="cliente">
				<option value="${cliente.cedula}" >
         <c:out value="${cliente.persona.getNombre()} "/>
         </option>
         </c:forEach>
        </select>
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Chef:</label>
    <div class="col-sm-10">
    <select class="form-control" id="exampleFormControlSelect1" name="chefid">
    <option value = "${orden.chef.getId()}" > <c:out value="${orden.chef.empleado.persona.getNombre()} "/> </option>
		   <c:forEach items="${chefDAO.list()}" var="chef">
				<option value="${chef.id}" >
         <c:out value="${chef.empleado.persona.getNombre()} "/>
         </option>
         </c:forEach>
        </select>
    </div>
  </div>
  
    <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Camarero:</label>
    <div class="col-sm-10">
    <select class="form-control" id="exampleFormControlSelect1" name="camareroid">
    <option value = "${orden.camarero.getId()}" > <c:out value="${orden.camarero.empleado.persona.getNombre()} "/> </option>
		   <c:forEach items="${camareroDAO.list()}" var="camarero">
				<option value="${camarero.id}" >
         <c:out value="${camarero.empleado.persona.getNombre()} "/>
         </option>
         </c:forEach>
        </select>
    </div>
  </div>
  
    <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Domicilio:</label>
    <div class="col-sm-10">
    <select class="form-control" id="exampleFormControlSelect1" name="domicilioid">
    <option value = "${orden.domicilio.getId()}" > <c:out value="${orden.domicilio.destino} "/></option>
		   <c:forEach items="${domicilioDAO.list()}" var="domicilio">
				<option value="${domicilio.id}" >
         <c:out value="${domicilio.destino}"/>
         </option>
         </c:forEach>
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