package br.ucsal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CadastroServletSession")
public class CadastroServeletSession extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession sessao = request.getSession(true);			


		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String instituicao = request.getParameter("instituicao");
		String curso = request.getParameter("curso");
		int ano_ingresso = Integer.parseInt(request.getParameter("ano_ingresso"));
		String empresa = request.getParameter("empresa");
		String cargo = request.getParameter("cargo");
		int ano_inicio = Integer.parseInt(request.getParameter("ano_inicio"));

		// Salvando as informações em session
		sessao.setAttribute("nome", nome);
		sessao.setAttribute("email", email);
		sessao.setAttribute("telefone", telefone);
		sessao.setAttribute("instituicao", instituicao);
		sessao.setAttribute("curso", curso);
		sessao.setAttribute("ano_ingresso", String.valueOf(ano_ingresso));
		sessao.setAttribute("empresa", empresa);
		sessao.setAttribute("cargo", cargo);
		sessao.setAttribute("ano_inicio", String.valueOf(ano_inicio));
		
		Integer acessos = (Integer) sessao.getAttribute("Numero_acessos");
		if (acessos == null) { acessos = 1; }
		else { acessos = acessos + 1; }
		
		sessao.setAttribute("Numero_acessos", acessos);
		
		if (acessos >= 3) {
			response.sendRedirect("ExcetedServelet");
		}

		out.println("<html><body>");
		out.println("<h2>Informações do Usuário</h2>");
		out.println("<p><strong>Nome:</strong> " + nome + "</p>");
		out.println("<p><strong>E-mail:</strong> " + email + "</p>");
		out.println("<p><strong>Telefone:</strong> " + telefone + "</p>");
		out.println("<p><strong>Instituição:</strong> " + instituicao + "</p>");
		out.println("<p><strong>Curso:</strong> " + curso + "</p>");
		out.println("<p><strong>Ano de Ingresso:</strong> " + ano_ingresso + "</p>");
		out.println("<p><strong>Empresa:</strong> " + empresa + "</p>");
		out.println("<p><strong>Cargo:</strong> " + cargo + "</p>");
		out.println("<p><strong>Ano de Início:</strong> " + ano_inicio + "</p>");
		out.println("<p><strong>Vezes Acessado:</strong> " + acessos + "</p>");
		out.println("<a href='CadastroUserSession.jsp'>Voltar</a>");
		out.println("</body></html>");
	}
}
