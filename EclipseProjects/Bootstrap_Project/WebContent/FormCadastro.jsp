<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Projeto com Bootstrap</title>
</head>
<body>
<div class="container">
	<h1>Cadastro de usuário</h1>
	<div class="card">
		<div class="card-body">
			<form action="" method="post">
				<div class="form-group row">
					<label class="col-sm-2">Nome</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="txtName" placeholder="Digite seu nome">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">Email</label>
					<div class="col-sm-7">
						<input type="email" class="form-control" name="txtEmail" placeholder="Digite seu email">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">Senha</label>
					<div class="col-sm-7">
						<input type="password" class="form-control" name="txtSenha" placeholder="Digite sua senha">
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Salvar</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>