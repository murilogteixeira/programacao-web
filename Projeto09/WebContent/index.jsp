<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calculadora-jsp</title>
</head>

<body>

<%
Object objNum1 = request.getAttribute("num1");
Object objNum2 = request.getAttribute("num2");
Object objResult = request.getAttribute("resultado");

String num1;
String num2;
String resultado;

if (objResult == null) {
	num1 = "";
	num2 = "";
	resultado = "";
}
else {
	num1 = objNum1.toString();
	num2 = objNum2.toString();
	resultado = objResult.toString();
}
%>

<form action="calcular" method="post">
	<input type="text" name="num1" value="<%=num1 %>"><br>
	<input type="text" name="num2" value="<%=num2 %>"><br>
	
	<select name="operador">
		<option value="+">Somar</option>
		<option value="-">Subtrair</option>
		<option value="*">Multiplicar</option>
		<option value="/">Dividir</option>
	</select>
	
	<input type="submit" value="Calcular">
</form>

<p><%=resultado %></p>

</body>
</html>