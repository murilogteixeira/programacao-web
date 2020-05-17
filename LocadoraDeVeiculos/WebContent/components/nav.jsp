<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <script src="https://kit.fontawesome.com/e4bae4855e.js" crossorigin="anonymous"></script>
    </head>

    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5">
            <div class="container">

                <a class="navbar-brand h1 mb-0" href="index.jsp">Locadora de Veículos</a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSite">

                    <ul class="navbar-nav mr-auto">
                        <li class="navbar-item">
                            <a class="nav-link" href="index.jsp">Veículos</a>
                        </li>
<<<<<<< HEAD
=======

                        <%-- <li class="navbar-item">
                        <a class="nav-link" href="listaCarros.jsp">Veículos</a>
                        </li> --%>
>>>>>>> 8c45b2b8b3aedecb592ccc7f9f90279b50988861

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="navDrop">Contato</a>

                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="tel:999999999">Telefone: 99999-9999</a>
                                <a class="dropdown-item" href="mailto:email@email.com">Email: email@email.com</a>
                            </div>
                        </li>

                    </ul>

                    <ul
                        class="navbar-nav ml-auto">

                        <!-- Se logado -->
                        <c:if test="${ logado }">
                        <%-- Editar menu --%>
                            <!-- <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="navDrop">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#">Veículos</a>
                                    <%-- <a class="dropdown-item" href="#">Usuário</a> --%>
                                </div>
                            </li> -->

                            <%-- Adicionar menu --%>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="navDrop">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#">Veículos</a>
                                    <%-- <a class="dropdown-item" href="#">Usuário</a> --%>
                                </div>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="navDrop">
                                    <i class="fas fa-plus"></i>
                                </a>
                                <div class="dropdown-menu">
                                    <%-- <a class="dropdown-item" href="cadastrarVeiculo.jsp">Veículo</a> --%>
                                    <button type="button" class="dropdown-item" data-toggle="modal" data-target="#cadastroCarroModal" data-whatever="@mdo" style="cursor:pointer;">Veículo</button>
                                    <%-- <a class="dropdown-item" href="#">Usuário</a> --%>
                                </div>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="navDrop">${ usuarioNome }</a>

                                <div class="dropdown-menu">
                                    <form action="UsuarioServlet" method="post" id="form">
<<<<<<< HEAD
                                        <input type="hidden" name="opcao" value="login">
=======
>>>>>>> 8c45b2b8b3aedecb592ccc7f9f90279b50988861
                                        <a class="dropdown-item" href="#" onclick="document.getElementById('form').submit()">Sair</a>
                                        <% session.setAttribute("loginOption", "sair"); %>
                                    </form>
                                </div>
                            </li>
                        </c:if>

                        <!-- Se nao logado -->
                        <c:if test="${ !logado }">
                            <li class="navbar-item">
                                <a class="nav-link" href="login.jsp">Login</a>
                                <%session.setAttribute("loginOption", "entrar");%>
                            </li>
                        </c:if>

                    </ul>

                </div>


            </div>
        </nav>


        <!-- Modal -->
        <div class="modal fade" id="cadastroCarroModal" tabindex="-1" role="dialog" aria-labelledby="cadastroCarroModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="cadastroCarroModalLabel">Cadastro Veículo</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
<<<<<<< HEAD
                    <form action="VeiculoServlet" method="post" id="cadastroForm">
                        <div class="modal-body">
			  			
			  				<div class="form-group">
								<label for="modelo">Modelo:</label>
								<input type="text" class="form-control" id="modelo" name="txtModelo" required>
							</div>
			  			
			  				<div class="form-group">
								<label for="marca">Marca:</label>
								<input type="text" class="form-control" id="marca" name="txtMarca" required>
=======
                    <form action="VeiculoServlet" method="post">
                        <div class="modal-body">
			  			
			  				<div class="form-group">
								<label for="marca">Marca:</label>
								<input type="text" class="form-control" id="marca" name="txtMarca" required>
							</div>
			  			
			  				<div class="form-group">
								<label for="modelo">Modelo:</label>
								<input type="text" class="form-control" id="modelo" name="txtModelo" required>
>>>>>>> 8c45b2b8b3aedecb592ccc7f9f90279b50988861
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
							
							
                        </div>
                        <div class="modal-footer">
<<<<<<< HEAD
                            <%-- <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> --%>
							<input type="hidden" name="opcao" id="opcao" value="cadastrar">
							<input type="hidden" name="veiculoId" id="veiculoId">
							<button type="submit" class="btn btn-danger" id="deletarBtn">Deletar</button>
							<button type="submit" class="btn btn-primary" id="salvarBtn">Cadastrar</button>
=======
							<input type="hidden" name="opcao" value="cadastrar">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Cadastrar</button>
>>>>>>> 8c45b2b8b3aedecb592ccc7f9f90279b50988861
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
