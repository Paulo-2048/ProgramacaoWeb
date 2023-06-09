package br.ucsal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sessao")
public class Session_Servelet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		try{			
			HttpSession sessao = request.getSession(true);			
			Integer acessos = (Integer) sessao.getAttribute("Numero_acessos");
			if (acessos == null) { acessos = 1;
			}else { acessos = acessos + 1; }
			sessao.setAttribute("Numero_acessos", acessos);	
			PrintWriter writer = response.getWriter();			
			writer.append( " <h1> Exemplo de sess�o </h1>" );			
			writer.append( "O documento foi acessado " +  acessos + " vezes.");
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}

