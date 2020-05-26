<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.com.bean.VeiculoBean"%>
<%@ page import="java.util.ArrayList"%>

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
  
  	<!-- Instanciar servlet -->
    <jsp:useBean id="servlet" class="br.com.controller.VeiculoServlet"/>

	<%
	// Validar usuario logado
	Object logadoObj = session.getAttribute("logado");
	boolean logado = false;

	if(logadoObj != null) {
		logado = (boolean)logadoObj;
	}

	// Valida se há carros na pesquisa
	ArrayList<VeiculoBean> veiculos = (ArrayList<VeiculoBean>)session.getAttribute("carros");
	if(veiculos == null) {
		veiculos = servlet.listar();
		session.setAttribute("carros", veiculos);
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
  
  	<!-- Exibir veiculos -->
	<div class="container">

		<%-- Form de busca --%>
		<form action="VeiculoServlet" method="get">
			<div class="form-inline row mx-0 mb-3 justify-content-end">
				<input class="form-control text-center col" name="filter" type="search" placeholder="Pesquisar marca ou modelo" aria-label="Pesquisar marca ou modelo" required>
				<button class="btn btn-outline-primary ml-2 col-2 col-sm-1" type="submit"><i class="fas fa-search"></i></button>
			</div>
		</form>

		<%-- Se houver filtros ativados --%>
		<c:if test="${filter != null}">
			<div class="row">
				<div class="col text-center">
					Filtro: "${filter}"  <a href="index.jsp"><i class="fas fa-times text-danger"></i></a>
				</div>
			</div>
			<%-- Limpar filtros --%>
			<%session.setAttribute("filter", null);%>
		</c:if>

		<div class="card-deck mx-0">
			<div class="row">
				
				<c:forEach var="carro" items="${ carros }">
				
					<div class="col-6 col-md-4 col-lg-3 col-xg-3 mb-3">
						<div class="card mx-0 h-100">
							<div class="h-50">
								<img class="card-img-top mh-100" src="${ carro.foto }">
							</div>
							<%-- <img class="card-img-top" src="${ carro.foto }"> --%>
							
							<div class="card-body">
								<h5 class="card-title mb-0">${ carro.modelo }</h5>	
								<small class="card-text">${ carro.marca }</small>
								<h6 class="card-text text-right"><small>R$</small> ${ carro.preco }</h6>
								<small class="card-text">${ carro.descricao }</small>
								
								<c:if test="${ logado }">

									<c:if test="${ carro.alugado }">
										<h6 class="card-text text-danger">Indisponível</h6>
									</c:if>

									<c:if test="${ !carro.alugado }"> 
										<h6 class="card-text text-success">Disponível</h6>
									</c:if>

									
								</c:if> 
							</div> 
							<c:if test="${logado}">
								<div class="card-footer">
									<form action="VeiculoServlet" method="post" id="form">
										<input type="hidden" name="veiculoId" id="veiculoId" value="${ carro.id }">

										<%-- <c:if test="${ carro.alugado }">
											<input type="hidden" name="opcao" id="opcao" value="devolver">
											<a href="#" class="btn btn-primary w-100" onclick="this.parentNode.submit()">Devolver</a>
										</c:if>

										<c:if test="${ !carro.alugado }">
											<input type="hidden" name="opcao" id="opcao" value="alugar">
											<a href="#" class="btn btn-success w-100" onclick="this.parentNode.submit()">Alugar</a>
										</c:if>  --%>


									</form>

										<button type="button" class="btn btn-primary w-100" data-toggle="modal" data-target="#veiculoModal" data-whatever="${carro.id}" style="cursor:pointer;">Detalhes</button>
								</div>
							</c:if>
							
						</div>
					</div>  
					
				</c:forEach>

				<%-- Limpar lista de carros --%>
				<%session.setAttribute("carros", null);%>
			</div>
		</div>
	</div>

	
	<!-- Modal -->
	<div class="modal fade" id="veiculoModal" tabindex="-1" role="dialog" aria-labelledby="veiculoModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="veiculoModalLabel">Detalhes do Veículo</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col">
								<img class="rounded w-100" id="foto">
							</div>
							<div class="col">
								<div class="h5" id="modelo"></div>
								<small class="" id="marca"></small>
								<div class="" id="descricao"></div>
								<div class="" id="preco"></div>
								<div class="" id="disponivel"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" id="editarBtn">Editar</button>

					<form action="VeiculoServlet" method="post" id="formAlugar">
						<input type="hidden" name="opcao" id="opcao">
						<input type="hidden" name="veiculoId" id="veiculoId">
						<a href="#" class="btn btn-success" id="alugarButton"></a>
					</form>

				</div>
			</div>
		</div>
	</div>

	<!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

	<%-- Modal data javascript --%>
	<script src="js/modalData.js" type="text/javascript" charset="utf-8"></script>

  </body>
</html>
