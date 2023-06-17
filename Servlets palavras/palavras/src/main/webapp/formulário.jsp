<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Verificador de Palavras</title>
</head>
<body>
    <h2>Verificador de Palavras</h2>
    <form action="VerificadorServlet" method="post">
        <label for="palavra1">Palavra 1:</label>
        <input type="text" id="palavra1" name="palavra1"><br>

        <label for="palavra2">Palavra 2:</label>
        <input type="text" id="palavra2" name="palavra2"><br>

        <input type="submit" value="Verificar">
    </form>
</body>
</html>