<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <!-- Meta tags Obrigatórias -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Carros disponíveis - Locadora</title>
  </head>
  <body>
  
  	<!-- Validar usuario logado -->
  	<%
  	Object logado = session.getAttribute("logado");
  	/* out.write(session.getAttribute("dataHoraLogin").toString()); */
  	if(logado == null) {
  		response.sendRedirect("login.jsp");
  		return;
  	}
  	else {
  		if(!(boolean)logado) {
  			response.sendRedirect("login.jsp");
  	  		return;
  		}
  	}
  	%>
  
  	<!-- Navbar -->
  	<c:import url="nav.jsp"/>
  	
  	<!-- Menu -->
  	<div class="container">
  		<div class="row">
			<div class="col my-2">
				<div class="float-right">
					<a href="cadastrarVeiculo.jsp" class="btn btn-primary" role="button" aria-pressed="true">Novo Veículo</a>
				</div>
			</div>
  		</div>
	</div>
  
  	<!-- Instanciar dao -->
    <jsp:useBean id="dao" class="br.com.dao.VeiculoDAO"/>
  
  	<!-- Exibir veiculos -->
  	<div class="container py-1">
  		<c:forEach var="carro" items="${ dao.lista() }">
	  		<div class="card mb-2">
		  		<div class="card-body">
		  			<div class="row">
		  				<div class="col">
		  					${ carro.modelo }
		  				</div>
		  				<div class="col">
		  					${ carro.marca }
		  				</div>
		  				<div class="col">
		  					${ carro.preco }
		  				</div>
		  				<div class="col-sm-4">
		  					<img class="w-75 rounded" src="${ carro.foto }">
		  				</div>
		  			</div>
		  		</div>
  			</div>
  		</c:forEach>
  	</div>

    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
