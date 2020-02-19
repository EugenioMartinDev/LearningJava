<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
  table.presentacion {
    margin-left:auto; 
    margin-right:auto;
  }
  

  table.scroll{
    margin-left:auto; 
    margin-right:auto;
    border: 1px solid black;
  }
  
  
table.scroll thead, table.scroll tbody{display: block;}


table.scroll tbody{
	height: 350px;
	width: 100%;
    overflow-y: auto;
    overflow-x: auto;
}

</style>
<body>
	<div style="text-align: center;">
		<h1>Pedido</h1>

		<br/>
			Usuario : ${pedido.usuario.nombre }
			<br/>
			<br/>
			Importe Total : ${pedido.importe}
			<br/>
			<br/>
			<table class="scroll">
				<tr>
					<th>Nombre</th>
					<th>Precio Unitario</th>
					<th>Unidades</th>
					<th>Precio</th>	
				</tr>
				<c:forEach items="${pedido.listaProductosSeleccionados}" var="p">
					<tr>
						<td><c:out value="${p.nombre}"></c:out></td>
						<td><c:out value="${p.precio}"></c:out></td>
						<td><c:out value="${p.unidades}"></c:out></td>
						<td><c:out value="${p.unidades*p.precio}"></c:out></td>
					</tr>
				</c:forEach>
			</table>
			<hr/>
			<br/>
			<br/>
			<input type="button" value="Aceptar" onclick="location.href='aceptar'">
			<br/>
			<br/>
			<br/>
			<input type="button" value="Cancelar" onclick="location.href='cancelar'">
	</div>
</body>
</html>