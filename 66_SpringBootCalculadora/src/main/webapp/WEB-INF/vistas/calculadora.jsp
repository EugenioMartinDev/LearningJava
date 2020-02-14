<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
  table{
    margin-left:auto; 
    margin-right:auto;
  }
</style>
</head>
<body>
	<div style="text-align: center;">
		<h1>Bienvenidos a nuestra calculadora</h1>
		<form action="alta">
			<table>
				<tr>
					<td>Numero 1:</td>
					<td><input type="text" name="numero1"/></td>
					<td style="color:red">${param.errorNumero1 }</td>
				</tr>
				<tr>
					<td>Numero 2:</td>
					<td><input type="text" name="numero2"/></td>
					<td style="color:red">${param.errorNumero2 }</td>
				</tr>
			</table>
			<input type="radio" name="tipo" value="sumar"/>Sumar
			<input type="radio" name="tipo" value="restar"/>Restar
			<input type="radio" name="tipo" value="multiplicar"/>Multiplicar
			<input type="radio" name="tipo" value="dividir"/>Dividir
			<br/>
			<p style="color:red">${param.errorTipo}</p>
			<br/>
			<input type="submit" value="calcular"/>
			<br>
		</form>
		<input type="text" value="${param.resultado}" readonly="readonly"/> 
		<br/>
		<table>
			<tr>
				<th>ID</th>
				<th>Numero 1</th>
				<th>Numero 2</th>
				<th>Tipo de Operacion</th>
				<th>Resultado</th>		
			</tr>
			<c:forEach items="${lista}" var="o">
				<tr>
					<td><c:out value="${o.id}"></c:out></td>
					<td><c:out value="${o.numero1}"></c:out></td>
					<td><c:out value="${o.numero2}"></c:out></td>
					<td><c:out value="${o.tipo}"></c:out></td>
					<td><c:out value="${o.resultado}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>