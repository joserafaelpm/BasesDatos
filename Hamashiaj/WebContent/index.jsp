<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<script type="text/jscript" src="script.js"></script>
<title>HAMASHÌAJ</title>
</head>
<body>
	<header>
		<div class="container-fluid align-items-sm-center row logos">
			<div class="col-3 img-logo">
				<img src="imagenes/logos/HAMASHIAJ LOGO CIRCULO.png" class="logo"
					alt="">
			</div>
			<div class="title-logo">
				<h2>
					<b>HAMASHÌAJ</b>
				</h2>
			</div>
		</div>
		<section class="banner">
			<div id="carouselExampleControls"
				class="carousel slide w-80px h-5 center" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="imagenes/logos/banner.png" class="d-block" alt="...">
					</div>
					<div class="carousel-item">
						<img src="imagenes/logos/banner.png" class="d-block" alt="...">
					</div>
					<div class="carousel-item">
						<img src="imagenes/logos/banner.png" class="d-block" alt="...">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleControls"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleControls"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</section>
		<!--- --->
	</header>
	<div class="container">
		<h1>
			<b>Camarero</b>
		</h1>
		<div class="dropdown">
  <button class="btn btn-warning dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Opciones de Camarero
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="${pageContext.request.contextPath}/buscarPersona.jsp">Buscar Persona</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/registroPersona.jsp">Registrar Persona</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/listaPersona.jsp">Lista De Personas</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/buscarCliente.jsp">Buscar Cliente</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/registroCliente.jsp">Registrar Cliente</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/listaCliente.jsp">Lista De Cliente</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/buscarOrden.jsp">Buscar Orden</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/registroOrden.jsp">Registrar Orden</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/listaOrden.jsp">Lista De Orden</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/buscarEmpleado.jsp">Buscar Empleado</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/registroEmpleado.jsp">Registrar Empleado</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/listaEmpleado.jsp">Lista De Empleado</a>
    
  </div>
</div>	
		<h1 class = "m-1"><b>Chef</b></h1>
				
		<div class="dropdown">
  <button class="btn btn-warning dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Opciones de Chef
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="${pageContext.request.contextPath}/buscarIngrediente.jsp">Buscar Ingrediente</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/registroIngrediente.jsp">Registrar Ingrediente</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/listaIngrediente.jsp">Lista De Ingrediente</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/buscarTipoDeIngrediente.jsp">Buscar Tipo de ingrediente</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/registroTipoDeIngrediente.jsp">Registrar Tipo de Ingrediente</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/listaTipoDeIngrediente.jsp">Lista De Tipos de Ingrediente</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/buscarPlatillo.jsp">Buscar Platillo</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/registroPlatillo.jsp">Registrar Platillo</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/listaPlatillo.jsp">Lista De Platillo</a>
    
  </div>
</div>
</div>

						
	<footer class="footer">
    <section id="bajo">
      <div class="container-fluid foter">
        <div class="row">
          <div class="col">
            <h1 class="page-header">
              Información de contacto
            </h1>
            <p>Email: elpapeme@gmail.com</p>
            <p>Teléfono de contacto: 318 6943404</p>
          </div>
          <div class="col-2">
            <ul class="icon">
              <li> <a href="https://web.facebook.com/COMIDAFAMILIAFE"> <i class="fa fa-facebook"></i> </a> </li>
              <li> <a href=""> <i class="fa fa-twitter"></i> </a> </li>
              <li> <a href="https://www.gram.com/hamashiaj.food/?hl=es-la"> <i class="fa fa-instagram"></i> </a> </li>
            </ul>
            <div class="contact">
              <a href="https://api.whatsapp.com/send?phone=573186943404&text=Hola%20Elda%20y%20Freddy%20tengo%20inter%C3%A9s%20en%20hacer%20un%20pedido%20a%20domicilio,%20mi%20nombre%20es">
                <button class="btn btn-primary"> Contactanos</button>
              </a>
            </div>
          </div>
          <div class="col-2">
            <img class="w-100" src="../imagenes/logos/HAMASHIAJ4.jpg" alt="">
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <p class="text-center text">
              Copyright y demas
            </p>
          </div>
        </div>
    </section>
  </footer>
</body>
<script src="https://snapwidget.com/js/snapwidget.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
</html>