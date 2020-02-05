<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- Hay que bajarse las librerias jstl en del maven respositoy
	y meter la linea taglib de la linea 3 de este documento
	concretamete "este". y en el pom hay que meter las librerias
	maven, ojo, solo una vez. Correcto loreto, la etiqueta
	taglib, habria que meterla en cada jsp donde vayas a utilizar
	jstl. Si no lo vais ausar, no haria falta meter este taglib
 -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Bienvenidos a nuestra pagina web de multiplicacion</h1>
		<h2>Ha elegido usted el numero ${tablaMultiplicar.numero}</h2>
		<table border=1>
			<tr>
				<th>Numero</th>
				<th>Contador</th>
				<th>Resultado</th>
			</tr>
			<!-- Esta etiqueta es una etiqueta de la librería
			jstl que se metio prviametne en el maven, se disinguen
			porque todas empiezan por "c", ojo, este "c" depende
			de como se haya configurado en el tag lib de mas arriba
			:) :) :)
			
			Esta etiqueta es una etiqueta repetitiva, es decir,
			vamos a iterar una estructura de tipo lista
			En el atributo items iria la lista a iterar
			En el atributo var iria el objeto devuelto por
			la lista. Su mecanica es practicamente igual que
			la estructura forEach de java pero ahora con etiquetas
			En el atributo varStatus podemos usarlo para sacar
			el contador de ciclo del bucle			
			-->
			 <c:forEach items="${tablaMultiplicar.listaResultados}" 
			 	var="resultado" varStatus="i">
             	<tr>
             		<td>${tablaMultiplicar.numero}</td>
                	<td>${i.count}</td>
                	<td>${resultado}</td>
                </tr>
             </c:forEach>
		</table>
	</center>
</body>
</html>