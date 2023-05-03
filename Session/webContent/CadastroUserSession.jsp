<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Cadastro de Usuário - Session</title>
</head>
<body>
	<h1>Cadastro de Usuário</h1>
	<form action="CadastroServletSession" method="post">
		<h2>Informações Pessoais</h2>
		<label>Nome:</label>
		<input type="text" name="nome"><br>
		<label>E-mail:</label>
		<input type="email" name="email"><br>
		<label>Telefone:</label>
		<input type="tel" name="telefone"><br>
		
		<h2>Informações Acadêmicas</h2>
		<label>Instituição:</label>
		<input type="text" name="instituicao"><br>
		<label>Curso:</label>
		<input type="text" name="curso"><br>
		<label>Ano de Ingresso:</label>
		<input type="number" name="ano_ingresso"><br>
		
		<h2>Informações Profissionais</h2>
		<label>Empresa:</label>
		<input type="text" name="empresa"><br>
		<label>Cargo:</label>
		<input type="text" name="cargo"><br>
		<label>Ano de Início:</label>
		<input type="number" name="ano_inicio"><br>
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>
