<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>    
<%@ page  import = "java.util.*"%>
<%	
	Date dt_primeiro_acesso = new Date(session.getCreationTime());
	Date dt_ultimo_acesso = new Date(session.getLastAccessedTime());

	String titulo = "Seja Bem Vindo Novamente";
	String chave = new String("userID");
	
	String valor = new String("Glaucya Boechat");
	
	if (session.isNew()){
		titulo = "Bem vindo!!";
		session.setAttribute(chave, valor);
	}	
	chave = (String) session.getAttribute(chave);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Exemplo de Sessão </title>
</head>
<body>
<h1><% out.println(titulo); %> </h1>
<h2> Informações da Sessão: <br> </h2>
ID : <% out.println( session.getId()); %> <br>
Data e hora de criação da sessão :  <% out.println( dt_primeiro_acesso); %> <br>
Data e hora da útlima sessão :  <% out.println( dt_ultimo_acesso); %> <br>
Usuário : <% out.println(valor); %>
</body>
</html>
