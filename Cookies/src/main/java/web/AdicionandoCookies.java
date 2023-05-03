package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdicionandoCookies")
public class AdicionandoCookies extends HttpServlet{
   protected void doGet(HttpServletRequest request, HttpServletResponse response) {
      try{
	Cookie cookie1 = new Cookie("nome", "Glaucya");
Cookie cookie2 = new Cookie("sobrenome", "Boechat");				
	cookie1.setMaxAge(60*2); //2 minutos
	cookie2.setMaxAge(60*2); //2 minutos
	response.addCookie(cookie1);
	response.addCookie(cookie2);
	PrintWriter writer = response.getWriter();			
	writer.append( " <HTML>  <BODY> " );
	writer.append( " <H1> Exemplo de cookies (nome, valor) </H1> " );
	writer.append(  "Cookie 1) nome = nome e valor = Glaucya <br> " );
	writer.append(  "Cookie 2) nome = sobrenome e valor = Boechat");
	writer.append( "</BODY> </HTML>  " );
       } catch (IOException e){
e.printStackTrace();	
       } 
   } 
}

