<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Tabuada</title>
</head>
<body>
    <h1>Tabuada</h1>
    <form action="TabuadaServlet" method="GET">
        <label for="numero">Digite um número inteiro:</label>
        <input type="number" id="numero" name="numero" required>
        <br><br>
        <input type="submit" value="Mostrar Tabuada">
    </form>
</body>
</html>