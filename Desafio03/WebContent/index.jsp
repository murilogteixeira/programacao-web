<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cálculo IMC</title>
<link rel="stylesheet" href="index.css">
<link rel="stylesheet" href="shared_style.css">
<script type="text/javascript" src="script.js"></script>
</head>
<body>
<div class="center screen-height">
	<div class="content center">
		<form class="form" action="calcular" method="post" id="form">
			<h1>Cálculo IMC</h1>
			<div class="space-between" >
				<label>Peso (Ex: 70): </label>
				<input class="input-text" type="number" name="peso" id="peso">
			</div>
			<br>
			<div class="space-between" >
				<label>Altura (Ex: 170): </label>
				<input class="input-text" type="number" name="altura" id="altura">
			</div>
			<br>
			<input class="button" type="submit" value="Calcular" onclick="validaCampos()">
		</form>
	</div>
</div>
</body>
</html>