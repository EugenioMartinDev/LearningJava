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
	<!-- h1>Detalle de los Datos </h1>${param.usuario}  También es posible utilizar el parámetro usuario de la request primitiva -->
	<h1>Detalle de los Datos </h1>${detalle.nombre}
	<hr/>
	<p>Direccion : ${detalle.direccion}</p>
	<br/>
	<p>Edad : ${detalle.edad}</p>
	<br/>
	<p>Peso : ${detalle.peso}</p>
	<br/>
	<br/>
</center>
</body>
</html>