<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <!-- Meta tags Obrigatórias -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Cadastrar Veículo - Locadora</title>
  </head>
  <body>
  
  <!-- Validar usuario logado -->
  <%
  if(session.getAttribute("logado") != null && !(boolean)session.getAttribute("logado")) {
	  response.sendRedirect("index.jsp");
  }
  %>
  
    <!-- Navbar -->
  	<c:import url="components/nav.jsp"/>

  	<!-- Exibir alerta de cadastro -->
  	<c:if test="${ veiculoCadastrado }">
  		<div class="container mb-4">
	  		<div class="alert alert-success alert-dismissible fade show">
  				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  			<strong>Sucesso!</strong> Veículo cadastrado.
			</div>
  		</div>
  		
  		<!-- Auto close alert -->
  		<script type="text/javascript" src="js/alert.js"></script>
	  	<% session.setAttribute("veiculoCadastrado", null); %>
  	</c:if>
	  
	<div class="container my-5 pt-5">
		<div class="row justify-content-center">
			<div class="col col-md-9 col-lg-7 col-xl-6">
			  	<div class="card">
			  		<div class="card-body">
			  			<form action="VeiculoServlet" method="post">
			  			
			  				<div class="form-group">
								<label for="marca">Marca:</label>
								<input type="text" class="form-control" id="marca" name="txtMarca" required>
							</div>
			  			
			  				<div class="form-group">
								<label for="modelo">Modelo:</label>
								<input type="text" class="form-control" id="modelo" name="txtModelo" required>
							</div>
			  			
			  				<div class="form-group">
								<label for="foto">Foto:</label>
								<input type="text" class="form-control" id="foto" name="txtFoto" required>
							</div>
			  			
			  				<div class="form-group">
								<label for="preco">Preço:</label>
								<input type="text" class="form-control" id="preco" name="txtPreco" required>
							</div>
			  			
			  				<div class="form-group">
								<label for="descricao">Descrição:</label>
								<input type="text" class="form-control" id="descricao" name="txtDescricao" required>
							</div>
							
							<input type="hidden" name="opcao" value="cadastrar">
							<button type="submit" class="btn btn-primary w-100 my-1">Cadastrar</button>
							
			  			</form>
			  		</div>
			  	</div>
	  		</div>
		 </div>
	 </div>

    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>