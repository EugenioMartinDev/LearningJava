<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP es una tecnologia que mezca la parte de los servlets
	con la parte de la vista. En este archivo podiamos escribir
	contenido dinamico al usar tecnologia servlet. Un jsp
	internamente es un Servlet, todo lo que podemos hacer con un
	servlet lo podemos hacer con un jsp</h1>
	<h1>Aún así, los jsps quedan en la parte de la vista, y
	unicamente deberian ser capaz de mostrar datos</h1>
	
	<h1>En un jsp podemos mezclar codigo java con codigo
	html gracias a una etiqueta que se llama scriptler</h1>
	<h1>Esto seria un ejemplo de un scriptler</h1>
	
	<%
		//eso ya es java NO es html, esto es un comentario 
		//en java
		String s = "hola mundo";
		int otraVariable = 1;
	%>
	
	<%
		//esto seria otro scriptler
		otraVariable++;
	%>
	<table>
		<%
			for(int i=1;i<=10;i++){
		%>
			<tr>
				<td>8 * <td>
				<td><%=i %><td>
				<td>= <%=i*8%><td>
			</tr>
		<%
			}
		%>
	</table>
	
	<hr/>
	<form action="ServletFormulario">
		Nombre: <input type="text" name="nombre"/>
		<br/>
		Peso: <input type="number" name="peso"/>
		<br/>
		<input type="submit" name="Enviar"/>
	</form>
	
	
	<!-- Esto seria con html -->
	<table>
		<tr>
			<td>5 * </td>
			<td>1 </td>
			<td>= 5 </td>
		</tr>
		<tr>
			<td>5 * </td>
			<td>2 </td>
			<td>= 10 </td>
		</tr>
		<tr>
			<td>5 * </td>
			<td>3 </td>
			<td>= 15 </td>
		</tr>
		<tr>
			<td>5 * </td>
			<td>4 </td>
			<td>= 20 </td>
		</tr>
		<tr>
			<td>5 * </td>
			<td>5 </td>
			<td>= 25 </td>
		</tr>
		<tr>
			<td>5 * </td>
			<td>6 </td>
			<td>= 30 </td>
		</tr>
		<tr>
			<td>5 * </td>
			<td>7 </td>
			<td>= 35 </td>
		</tr>
		<tr>
			<td>5 * </td>
			<td>8 </td>
			<td>= 40 </td>
		</tr>
		<tr>
			<td>5 * </td>
			<td>9 </td>
			<td>= 45 </td>
		</tr>
		<tr>
			<td>5 * </td>
			<td>10 </td>
			<td>= 50 </td>
		</tr>
	</table>
</body>
</html>