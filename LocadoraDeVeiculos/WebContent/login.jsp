<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<!-- Meta tags Obrigatórias -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title>Login - Locadora</title>
</head>
<body>
  	
	<!-- Navbar -->
  	<c:import url="components/nav.jsp"/>
  	
  	<!-- Exibir alerta de cadastro -->
  	<c:if test="${ cadastroEfetuado }">
  	
  		<div class="container mb-4">
  		
	  		<% if(request.getAttribute("usuarioCadastrado") != null) { %>
	  		
		  		<div class="alert alert-success alert-dismissible fade show">
	  				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		  			<strong>Sucesso!</strong> Usuário cadastrado.
				</div>
				
	  		<% } else { %>
	  		
		  		<div class="alert alert-danger alert-dismissible fade show">
	  				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		  			<strong>Erro!</strong> Não foi possível cadastrar usuário.
				</div>
				
	  		<% } %>
	  		
  		</div>
  		
  		<!-- Auto close alert -->
  		<script type="text/javascript" src="script/alert.js"></script>
  		
  	</c:if>

	<!-- Form login -->
	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col col-md-9 col-lg-7 col-xl-6 pt-5">
				<div class="card">
					<div class="card-body">
					
						<form action="LoginServlet" method="post">
						
							<div class="form-group">
								<label for="email">Email:</label>
								<input type="email" class="form-control" id="email" name="txtEmail" required>
							</div>
							
							<div class="form-group">
								<label for="senha">Senha:</label>
								<input type="password" class="form-control" id="senha" name="txtSenha" required>
								<c:if test="${ msg != null }">
									<small class="text-danger form-text">${ msg }</small>
								</c:if>
							</div>
							
							<button type="submit" class="btn btn-primary w-100 my-1">Entrar</button>
							
							<div class="form-group text-center mt-2 mb-0">
								<a class="btn btn-link" href="cadastroUsuario.jsp">Não é cadastrado? Cadastre-se aqui.</a>
							</div>
						
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