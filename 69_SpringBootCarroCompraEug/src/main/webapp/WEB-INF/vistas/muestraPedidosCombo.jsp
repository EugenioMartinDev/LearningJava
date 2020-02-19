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
		<h1>Listado de Productos</h1>
			
	<script>
		function myFunction() {
		  var categoria = document.getElementById("nombreCategoria").value;
		  location.href='seleccionProductos?nombreCategoria=' + categoria
		}
		</script>
			
		<form action="tratarPedido">
			<label for="nombreCategoria">Seleccione una categoria:</label>	
			<select name="nombreCategoria" id="nombreCategoria" onchange="myFunction()">
			<c:if test="${empty categoriaRcvd }">
				<option value="">--Please choose an option--</option>
			</c:if>				
			<c:forEach items="${listaCategorias}" var="p">
				<option value="${p.nombre }">${p.nombre }</option>				
			</c:forEach>
			</select>
			<c:if test="${not empty listaProductosPorCategoria }">
				<label for="producto">Seleccione un producto:</label>
				<select name="producto" id="producto">
					<option value="">--Please choose an option--</option>
					<c:forEach items="${listaProductosPorCategoria}" var="p">
						<option value="${p.nombre }">${p.nombre }</option>				
					</c:forEach>
				</select>
				<input type="number" step=1 name="unidades" min="0" value="1"/>
				<input type="submit" value="Añadir"/>
			</c:if>
		</form>	
	
		<c:if test="${not empty listaPedidos }">	
		<hr/>
		<br/>
			<table class="scroll">
				<tr>
					<th>Nombre</th>
					<th>Precio Unitario</th>
					<th>Unidades</th>
					<th>Precio</th>	
				</tr>
				<c:forEach items="${listaPedidos}" var="p">
					<tr>
						<td><c:out value="${p.nombre}"></c:out></td>
						<td><c:out value="${p.precio}"></c:out></td>
						<td><c:out value="${p.unidades}"></c:out></td>
						<td><c:out value="${p.unidades*p.precio}"></c:out></td>
					</tr>
				</c:forEach>
			</table>
			<hr/>
			<input type="button" value="Comprar" onclick="location.href='calcularImporte'">
			
		</c:if>
	</div>
</body>
</html>