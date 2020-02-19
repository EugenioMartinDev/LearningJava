<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SUPERMERCADO</title>
<style type="text/css">
  table.presentacion, table.lista{
    margin-left:auto; 
    margin-right:auto;
  }
  

  table.lista{
    margin-left:auto; 
    margin-right:auto;
    border: 1px solid black;
  }
  
  
table.lista thead, table.lista tbody{display: block;}


table.lista tbody{
	height: 350px;
	width: 100%;
    overflow-y: auto;
    overflow-x: auto;
}

</style>
</head>
<body>
	<div style="text-align: center;">
		<h1>Catalogo del Supermercado</h1>
		<form action="alta">
			<table class="presentacion">
				<tr>
					<td>Nombre:</td>
					<!-- El value es el valor del texto. En este caso valdra lo que valga
					el parametro nombre. Este caso es para pintar el nombre en caso
					de que haya habido un error y no queramos hacer al usuario escribir 
					de nuevo el nombre -->
					<td><input type="text" name="nombre" value="${param.nombre }"/></td>
					<td style="color:red">${param.errorNombre }</td>
				</tr>
				<tr>
					<td>Precio:</td>
					<td><input type="number" step="10" name="precio" value="${param.precio }"/></td>
					<td style="color:red">${param.errorPrecio }</td>
				</tr>
				<tr>
				<td>Categoria:</td>
				<td>	
					<input type="radio" name="categoria" id="Alimentacion" value="Alimentacion"/>Alimentacion
					<input type="radio" name="categoria" id="Limpieza" value="Limpieza"/>Limpieza
					<input type="radio" name="categoria" id="Papeleria" value="Papeleria"/>Papeleria
					<input type="radio" name="categoria" id="Menaje" value="Menaje"/>Menaje
					<input type="radio" name="categoria" id="Belleza" value="Belleza"/>Belleza
					<input type="radio" name="categoria" id="Salud" value="Salud"/>Salud
					<input type="radio" name="categoria" id="Mascotas" value="Mascotas"/>Mascotas

				</td>
				<td style="color:red">${param.errorCategoria}</td>
				</tr>
			</table>
			<br/>
			<input type="submit" value="Enviar"/>
			<br/>
		</form>
		<c:if test="${not empty param.categoriaRcvd }">
			<script>	
				//Javascript
				//Esto es para seleccionar el radio button que haya seleccionado previamente
				//el usuario. Misma idea que con el nombre de arriba
				function check(id) {
			  			document.getElementById(id).checked = true;
				} 
				check("${param.categoriaRcvd}")
			</script>
		</c:if>
		<p>${param.mensaje}<p/> 
		<br/>
		<table class="lista">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Categoria</th>	
			</tr>
			<c:forEach items="${lista}" var="p">
				<tr>
					<td><c:out value="${p.id}"></c:out></td>
					<td><c:out value="${p.nombre}"></c:out></td>
					<td><c:out value="${p.precio}"></c:out></td>
					<td><c:out value="${p.categoria}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>