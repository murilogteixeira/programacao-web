<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
Object pgNameObj = session.getAttribute("pgName");
String pgName = "";
if(pgNameObj != null) {
	pgName = (String)pgNameObj;
}
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5">
	<div class="container">

		<a class="navbar-brand h1 mb-0" href="index.jsp">Locadora de Veículos</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSite">

			<ul class="navbar-nav mr-auto">
				<li class="navbar-item">
					<a class="nav-link" href="index.jsp">Início</a>
				</li>

				<li class="navbar-item">
					<a class="nav-link" href="listaCarros.jsp">Alugue um carro</a>
				</li>

				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="navDrop">Contatos</a>

					<div class="dropdown-menu">
						<a class="dropdown-item" href="tel:999999999">Telefone: 99999-9999</a> 
						<a class="dropdown-item" href="mailto:email@email.com">Email: email@email.com</a>
					</div>
				</li>

			</ul>

			<ul class="navbar-nav ml-auto">

				<!-- Se logado -->
				<c:if test="${ logado }">
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="navDrop">Menu Admin</a>

						<div class="dropdown-menu">
							<a class="dropdown-item" href="cadastrarVeiculo.jsp">Cadastrar veículo</a>
							<a class="dropdown-item" href="#">Usuários</a>
						</div>
					</li>
					<li class="navbar-item">
						<form action="../../LoginServlet" method="post" id="form">
							<a class="nav-link" href="#" onclick="document.getElementById('form').submit()">Sair</a>
							<%session.setAttribute("loginOption", "sair");%>
						</form>
					</li>
				</c:if>

				<!-- Se nao logado -->
				<c:if test="${ !logado }">
					<li class="navbar-item"><a class="nav-link" href="login.jsp">Login</a>
						<%session.setAttribute("loginOption", "entrar");%>
					</li>
				</c:if>

			</ul>

		</div>
	</div>
</nav>