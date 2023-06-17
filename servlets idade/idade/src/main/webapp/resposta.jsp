<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Dados" method="post">
	     <label for="ano">Ano de Nascimento:</label>
        <input type="text" name="ano" id="ano" required><br>
        
        <label for="fezAniversario">Já fez aniversário este ano?</label>
        <input type="checkbox" name="fezAniversario" id="fezAniversario"><br>
        
        <input type="submit" value="Enviar">
	</form>
</body>
</html>