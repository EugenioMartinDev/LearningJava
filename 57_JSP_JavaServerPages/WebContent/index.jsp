<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p><!-- JSP es una tecnolog�a que mezcla la parte de los servlets con la parte de la vista.
		 En este archivo podr�amos escribir contenido din�mico al usar tecnolog�a servlet.
		 Un JSP internamente es un servlet: todo lo que se puede hacer con un servlet se puede
		 hacer con un jst.
		 
		 A�n as�, un jsp quedan en la parte de la vista y se debe utilizar �nicamente para mostrar
		 datos. 
		 
		 En un servlet podemos mezclar c�digo java con c�digo html, gracias a la etiqueta scriptler.   -->

	</p>

	<%
		//Esto es java
		String s = "hola mundo";
		int variable = 1;
	%>
	
	<%
		int otraVariable = 1;
	%>
	
	<table>
		<%
			for (int i=0; i<=10; i++) {
		%>
			<tr>
				<td>5 * </td>
				<td> <%=i %></td>
				<td> <%=i*5 %>
			</tr>
		<%
			}
		%>
	</table>
	
	
	</hr>
	
	<form action="ServletFormulario">
		Nombre: <input type="text" name="nombre"/>
		<br/>Peso: <input type="number" name="peso"/>
		<br/><input type="submit" name="Enviar"/>
	</form>
		 
</body>
</html>