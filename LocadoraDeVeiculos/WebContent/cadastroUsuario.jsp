<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <!-- Meta tags Obrigatórias -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Cadastro Usuário - Locadora</title>
  </head>
  <body>
  
  <!-- Validar usuario logado -->
  <%
  if(!(boolean)session.getAttribute("logado")) {
	  response.sendRedirect("index.jsp");
  }
  %>
  
  	<!-- Navbar -->
  	<c:import url="components/nav.jsp"/>
  	
  	<!-- Exibir alerta de cadastro -->
  	<c:if test="${ tentativaCadastro && !cadastroEfetuado }">
  	
  		<div class="container mb-4">
  		
	  		<div class="alert alert-danger alert-dismissible fade show">
  				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  			<strong>Erro!</strong> Usuário já cadastrado.
			</div>
	  		
  		</div>
  		
  		<!-- Auto close alert -->
  		<script type="text/javascript">
	  		window.setTimeout(function() {
	  			$(".alert").alert('close');
	  		}, 3000);
  		</script>
  		
  	</c:if>
 	 
 	 <div class="container my-5 pt-5">
		<div class="row justify-content-center">
			<div class="col col-md-9 col-lg-7 col-xl-6">
			  	<div class="card">
			  		<div class="card-body">
			  			<form action="UsuarioServlet" method="post">
			  			
			  				<div class="form-group row">
								<label for="nome" class="col-sm-3 col-form-label">Nome:</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="nome" name="txtNome">
									<small class="text-danger" id="erroNome"></small>
								</div>
							</div>
			  			
			  				<div class="form-group row">
								<label for="email" class="col-sm-3 col-form-label">Email:</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="email" name="txtEmail">
									<small class="text-danger" id="erroEmail"></small>
								</div>
							</div>
			  			
			  				<div class="form-group row">
								<label for="senha" class="col-sm-3 col-form-label">Senha:</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="senha" name="txtSenha">
									<small class="text-danger" id="erroSenha"></small>
								</div>
							</div>
			  			
			  				<div class="form-group row my-0">
			  					<div class="col-sm-3 my-0"></div>
								<div class="col-5 my-0" id="forcaSenha"></div>
							</div>
			  			
			  				<div class="form-group row">
								<label for="confirmaSenha" class="col-sm-3 col-form-label">Confirmação:</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="confirmaSenha" name="txtConfirmaSenha">
									<small class="text-danger" id="erroConfirmaSenha"></small>
								</div>
							</div>
							
							<button type="submit" class="btn btn-primary w-100 my-1">Cadastrar</button>
					        
			  			</form>
			  		</div>
			  	</div>
	  		</div>
		 </div>
	 </div>

    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
    <!-- Validar senha -->	 
	 <script type="text/javascript" src="script/cadastroUsuario.js"></script>
  </body>
</html>