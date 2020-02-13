<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
h2{
	text-align: center;
	color: red;
}
</style>

</head>
<body>
	<!-- Se llama css in line -->
	<h1 style="text-align: center;color:green;font-family: bookman old style">CALCULADORA</h1>
	<form action="doCalculadora" method="post">
		Primer numero : <input type="number" name="numero1"/>
		<br/>
		Segundo numero: <input type="number" name="numero2"/>
		<br/>
		Operacion: 
		<br/>
		<h3>Elija la operacion</h3>
		<input type="radio" name="operator" value="SUMA">SUMA
		<br/>
		<input type="radio" name="operator" value="RESTA">RESTA
		<br/>
		<input type="radio" name="operator" value="PRODUCTO">PRODUCTO
		<br/>
		<input type="radio" name="operator" value="DIVISION">DIVISION
		<br/>
		<hr/>
		<br/>
		<input type="submit" value="Calcular">
	</form>
	
	<c:if test="${not empty resultado }">
		<hr/>
		<h1>Resultado : ${operacion.resultado}</h1>
		<br/>
		<a href="muestraOperaciones">MostrarOperaciones</a>
	</c:if>
	
	<c:if test="${not empty listaOperaciones }">
		<hr/>
		<h1>Resultado : ${resultado}</h1>
				<table border=1>
			<tr>
				<th>numero1</th>
				<th>numero2</th>
				<th>operador</th>
				<th>resultado</th>
			</tr>
			 <c:forEach items="${listaOperaciones}" 
			 	var="operacion">
             	<tr>
             		<td>${operacion.numero1}</td>
                	<td>${operacion.numero2}</td>
                	<td>${operacion.operador}</td>
                	<td>${operacion.resultado}</td>
                </tr>
             </c:forEach>
		</table>
	</c:if>
		
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>