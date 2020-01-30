<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p><!-- JSP es una tecnología que mezcla la parte de los servlets con la parte de la vista.
		 En este archivo podríamos escribir contenido dinámico al usar tecnología servlet.
		 Un JSP internamente es un servlet: todo lo que se puede hacer con un servlet se puede
		 hacer con un jst.
		 
		 Aún así, un jsp quedan en la parte de la vista y se debe utilizar únicamente para mostrar
		 datos. 
		 
		 En un servlet podemos mezclar código java con código html, gracias a la etiqueta scriptler.   -->

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