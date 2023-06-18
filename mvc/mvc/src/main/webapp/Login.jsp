<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<body>
	<h1>Divisão de Números</h1>
	
    <form action="DivisaoController" method="POST">
        <label for="numero1">Número 1:</label>
        <input type="text" name="numero1" id="numero1"><br><br>
        <label for="numero2">Número 2:</label>
        <input type="text" name="numero2" id="numero2"><br><br>
        <input type="submit" value="Dividir">
    </form>
    
	</body>
</html>
