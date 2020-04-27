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
  	Object logadoObj = session.getAttribute("logado");
  	boolean logado = false;
  	String proxPagina = "#";
  	
  	if(logadoObj != null) {
  		logado = (boolean)logadoObj;
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
  		<script type="text/javascript">
	  		window.setTimeout(function() {
	  			$(".alert").alert('close');
	  		}, 3000);
  		</script>
	  	<%
  		session.setAttribute("veiculoCadastrado", null);
	  	%>
  	</c:if>
  
  	<!-- Instanciar dao -->
    <jsp:useBean id="dao" class="br.com.dao.VeiculoDAO"/>
  
  	<!-- Exibir veiculos -->
	<div class="container">
		<div class="card-deck">
			<div class="row">
			
				<c:forEach var="carro" items="${ dao.lista() }">
				
					<div class="col-6 col-md-4 col-lg-3 mb-3">
						<div class="card mx-0">
						
							<%-- <img class="card-img-top" src="${ carro.foto }"> --%>
							<img class="card-img-top" src="https://picsum.photos/300">
							
							<div class="card-body">
								<h5 class="card-title mb-0">${ carro.modelo }</h5>	
								<small class="card-text">${ carro.marca }</small>
								<h6 class="card-text text-right"><small>R$</small> ${ carro.preco }</h6>
								
								<form action="EscolherVeiculoServlet" method="post">
									<input type="hidden" name="veiculoId" value="${ carro.id }">
									<a href="#" class="btn btn-primary stretched-link w-100 mt-3" onclick="this.parentNode.submit()">Escolher</a>
								</form>
							</div>
							
						</div>
					</div>
					
				</c:forEach>
				
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
