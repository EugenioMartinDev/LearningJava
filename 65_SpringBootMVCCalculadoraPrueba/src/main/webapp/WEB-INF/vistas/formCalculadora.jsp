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

div.overflow {
  overflow: auto;
}

thead,tbody{display: block;}

tbody {
	height: 600px;
	width: 100%;
    overflow-y: auto;
    overflow-x: auto;
}



</style>

</head>
<body>

	<div>
		<!-- Se llama css in line -->
		<h1 style="text-align: center;color:green;font-family: bookman old style">CALCULADORA</h1>
		<form action="doCalculadora" method="post">
			<c:if test="${not empty operacion }">
			Primer numero : <input type="number" name="numero1" value="${operacion.numero1 }"/>
			<br/>
			Segundo numero : <input type="number" name="numero2" value="${operacion.numero2 }"/>
			<br/>
			Elija la operacion
			<br/>
			<input type="radio" name="operator" id="SUMA" value="SUMA">SUMA
			<br/>
			<input type="radio" name="operator" id="RESTA" value="RESTA">RESTA
			<br/>
			<input type="radio" name="operator" id="PRODUCTO" value="PRODUCTO">PRODUCTO
			<br/>
			<input type="radio" name="operator" id="DIVISION" value="DIVISION">DIVISION
			<br/>
			<hr/>
			<br/>
			<script>		
				function check(id) {
			  			document.getElementById(id).checked = true;
				} 
				check("${operacion.operador}")
			</script>
			</c:if>
			<c:if test="${empty operacion }">
			Primer numero : <input type="number" name="numero1"/>	
			<br/>
			Segundo numero : <input type="number" name="numero2"/>
			<br/>
			Elija la operacion
			<br/>
			<input type="radio" name="operator" id="SUMA" value="SUMA">SUMA
			<br/>
			<input type="radio" name="operator" id="RESTA" value="RESTA">RESTA
			<br/>
			<input type="radio" name="operator" id="PRODUCTO" value="PRODUCTO">PRODUCTO
			<br/>
			<input type="radio" name="operator" id="DIVISION" value="DIVISION">DIVISION
			<br/>
			<hr/>
			<br/>
			</c:if>
			<input type="submit" value="Calcular">
		</form>
	</div>
	
	<div></div>
		<c:if test="${not empty operacion }">
			<hr/>
			<h1>Resultado : ${operacion.resultado}</h1>
			<br/>
			<a href="doCalculadora?listar=true">MostrarOperaciones</a>
		</c:if>
	</div>
	
	<div>
		<c:if test="${not empty listaOperaciones }">
			<hr/>
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
	</div>
</body>
</html>