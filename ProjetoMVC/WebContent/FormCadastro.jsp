<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro veículo</title>
</head>
<body>
<form action="CarroServlet" method="post">
	<label>Modelo</label>
	<input type="text" name="txtModeloVeiculo">
	<br>
	<label>Fabricante</label>
	<input type="text" name="txtFabricanteVeiculo">
	<br>
	<input type="submit" name="Cadastrar">
</form>
</body>
</html>