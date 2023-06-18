<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado da Divisão</title>
</head>
<body>
    <h1>Resultado da Divisão</h1>
    
    <% if (request.getAttribute("erro") != null) { %>
        <p><strong>Erro:</strong> <%= request.getAttribute("erro") %></p>
    <% } else { %>
        <p><strong>Resultado:</strong> <%= request.getAttribute("resultado") %></p>
    <% } %>
    
    <a href="Login.jsp">Voltar</a>
</body>
</html>