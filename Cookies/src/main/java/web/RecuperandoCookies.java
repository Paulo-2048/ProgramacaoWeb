package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RecuperandoCookies")
public class RecuperandoCookies extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try{
		   Cookie cookies[] = null;
		   cookies = request.getCookies();
			
		   PrintWriter writer = response.getWriter();
		   writer.append( " <HTML>  <BODY> " );
		   writer.append( " <H1> Exemplo de Cookies </H1> " );			
		   if (cookies != null) {
			Cookie cookie = null;
			for (int i=0; i< cookies.length; i++) {
				cookie = cookies[i];
				writer.append("Nome: " + cookie.getName() + ",  Valor: " + cookie.getValue() + "<br>"  );
			}
		   }
		   writer.append( "</BODY> </HTML> " );
		} catch (IOException e){
		   e.printStackTrace();
		}
	}
}


   
   
