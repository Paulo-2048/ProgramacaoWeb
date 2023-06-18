package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DivisaoController")
public class DivisaoController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 		
			throws ServletException, IOException {
		
		 	int numero1 = Integer.parseInt(request.getParameter("numero1"));
	        int numero2 = Integer.parseInt(request.getParameter("numero2"));

	        if (numero2 != 0) {
	            double resultado = (double) numero1 / numero2;
	            request.setAttribute("resultado", resultado);
	        } else {
	            request.setAttribute("erro", "Não é permitido dividir por zero.");
	        }

	        request.getRequestDispatcher("Home.jsp").forward(request, response);
	    }
}


	