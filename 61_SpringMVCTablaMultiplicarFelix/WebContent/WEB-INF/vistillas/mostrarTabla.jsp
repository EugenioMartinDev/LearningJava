<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MOSTRAR UNA TABLA DE MULTIPLICAR</title>
</head>
<body>
	<center>
		<h1>Bienvenidos a nuestra página WEB de multiplicación</h1>
		<h2>Ha elegido usted el número ${tablaMultiplicar.numero }</h2>
		<table border=1>
		    <tr>
				<th>Numero</th>
				<th>Contador</th>
				<th>Resultado</th>
			</tr>
			<c:forEach var="resultado" items="${tablaMultiplicar.listaResultados }" varStatus="contador">
			<tr>
				<td>${tablaMultiplicar.numero }</td>
				<td>${contador.count }</td>
				<td>${resultado }</td>
				</tr>
			</c:forEach>
		</table>
		
	</center>
</body>
</html>
