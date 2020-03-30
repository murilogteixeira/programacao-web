<%@ page import="java.text.DecimalFormat" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado IMC</title>
<link rel="stylesheet" href="resultado.css">
<link rel="stylesheet" href="shared_style.css">
</head>
<body>
	<div class="center screen-height">
		<div class="content center">
			<div class="result">
				<h1>Resultado</h1>
				<%
					Object imcObj = request.getAttribute("imc");
					
					DecimalFormat format = new DecimalFormat("#0.00");
					Double imc = null;
					String imcString = "";
					if(imcObj != null) {
						imc = Double.parseDouble(imcObj.toString());
						imcString = format.format(imc);
					}
					out.print("Seu IMC é " + imcString + "kg/m<sup>2</sup>");
				%>
				<br>
				<%
					if(imc >= 18.5 && imc <= 24.9) {
						out.print("Peso NORMAL para a sua altura");
					}
					else if(imc < 18.5) {
						out.print("ABAIXO do peso ideal");
					}
					else {
						out.print("ACIMA do peso ideal");
					}
				%>
				<br><br>
				<table>
				<th>Parâmetro</th>
				<th>Kg/m<sup>2</sup></sup></th>
					<tr>
						<td>Abaixo</td>
						<td>até 18,4</td>
					</tr>
					<tr>
						<td>Normal</td>
						<td>18,5 a 24,9</td>
					</tr>
					<tr>
						<td>Acima</td>
						<td>a partir de 25</td>
					</tr>
				</table>
				<br>
				<button class="button" type="button" onclick="window.location.href = 'index.jsp'">Consultar novamente</button>
			</div>
		</div>
	</div>
</body>
</html>