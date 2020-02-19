<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h1>Bienvenidos a Pedidos del Supermercado</h1>
	<h3 style="color:blue">${param.mensaje }</h3>
	<h3 style="color:red">${param.error }</h3>
	<form action="doLogin">
	<table class="presentacion">
		<tr>
			<td>Nombre</td>
			<td><input type="text" name="nombre"/></td>
		</tr>
				<tr>
			<td>Password</td>
			<td><input type="password" name="pass"/></td>
		</tr>
	</table>
	<br/>
	<input type="submit" value="Enviar"/>
	</form>
	<br>
	<a href="mostrarAlta">¿Quiere registrarse?</a>
</div>
</body>
</html>