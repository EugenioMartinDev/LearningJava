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
	<h1>RESUMEN DEL PEDIDO</h1>
	<hr/>
	<table border="1">
		<tr>
			<td>Nombre:</td>
			<td>${pedido.nombreCliente }</td>
		</tr>
		<tr>
			<td>Direccion:</td>
			<td>${pedido.direccion }</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>${pedido.email }</td>
		</tr>
		<tr>
			<td>Ram:</td>
			<td>${pedido.ordenador.ram }</td>
		</tr>
		<tr>
			<td>Procesador:</td>
			<td>${pedido.ordenador.procesador }</td>
		</tr>
		<tr>
			<td>lista de perifericos:</td>
			<td>${pedido.ordenador.listaPerifericos }</td>
		</tr>
		<tr>
			<td>Comentarios del cliente:</td>
			<td>${pedido.comentario }</td>
		</tr>
	</table>
</center>
</body>
</html>