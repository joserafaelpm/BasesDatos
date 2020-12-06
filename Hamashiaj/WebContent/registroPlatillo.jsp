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
<title> Registro de Platillos</title>
</head>
<body>
<h1><b>Registro De Platillos</b></h1>
<c:if test="${platillo != null}">
                           <%--  <form action="${pageContext.request.contextPath}/ActualizarEmpleado?accion=edita&codigo=${empleado.codigo}"  method="post"> --%>
                           <form action="PlatilloServlet?action=actualizar&id=${platillo.id}"  method="POST">
                        </c:if>
                        <c:if test="${platillo == null}">
                           <%--  <form action="${pageContext.request.contextPath}/AgregarEmpleado?accion=agregar&codigo=${empleado.codigo}"  method="POST"> --%>
                            <form action="PlatilloServlet?action=registrar"  method="POST">
                        </c:if>

  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Nombre:</label>
    <div class="col-sm-10">
      <input type="text" name="nombre" value="${platillo.nombre}"  class="form-control">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">precio:</label>
    <div class="col-sm-10">
      <input type="number" name="precio" value="${platillo.precio}"  class="form-control">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Descripcion:</label>
    <div class="col-sm-10">
      <input type="text" name="descripcion" value="${platillo.descripcion}"  class="form-control">
    </div>
  </div>
  
   <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Url Imagen:</label>
    <div class="col-sm-10">
      <input type="text" name="url" value="${platillo.urlImagen}"  class="form-control">
    </div>
  </div> 
  
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Registrar</button>
     <a href="${pageContext.request.contextPath}/buscar.jsp" class="btn btn-primary">Volver</a>
    </div>
    </div>
  
</form>
</body>
</html>