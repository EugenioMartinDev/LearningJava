<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Bienvenido ${param.nombre}</h1>
	</center>
	
	<!-- Esto siempre es GET -->
	<a href="ServletDetalle?nombre=${param.nombre}">ir a detalle</a>
</body>
</html>