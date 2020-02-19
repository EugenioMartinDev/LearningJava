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
	<h1>Listado de Productos</h1>
	
	<c:forEach items="${listaPedidos}" var="p">
		<form action="tratarPedido">
			<input type="text" name="Nombre" value="${p.nombre }" readonly="readonly"/>
			<input type="text" name="Precio" value="${p.precio }" readonly="readonly"/> 
			<input type="number" step=1 name="Unidades" value="${p.unidades }"/>
			</br>
			<input type="submit" value="Añadir"/>
		</form>		
	</c:forEach>

</body>
</html>