package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String instituicao = request.getParameter("instituicao");
		String curso = request.getParameter("curso");
		int ano_ingresso = Integer.parseInt(request.getParameter("ano_ingresso"));
		String empresa = request.getParameter("empresa");
		String cargo = request.getParameter("cargo");
		int ano_inicio = Integer.parseInt(request.getParameter("ano_inicio"));

		// Salvando as informações em cookies
		Cookie nomeCookie = new Cookie("nome", nome);
		Cookie emailCookie = new Cookie("email", email);
		Cookie telefoneCookie = new Cookie("telefone", telefone);
		Cookie instituicaoCookie = new Cookie("instituicao", instituicao);
		Cookie cursoCookie = new Cookie("curso", curso);
		Cookie anoIngressoCookie = new Cookie("ano_ingresso", String.valueOf(ano_ingresso));
		Cookie empresaCookie = new Cookie("empresa", empresa);
		Cookie cargoCookie = new Cookie("cargo", cargo);
		Cookie anoInicioCookie = new Cookie("ano_inicio", String.valueOf(ano_inicio));

		response.addCookie(nomeCookie);
		response.addCookie(emailCookie);
		response.addCookie(telefoneCookie);
		response.addCookie(instituicaoCookie);
		response.addCookie(cursoCookie);
		response.addCookie(anoIngressoCookie);
		response.addCookie(empresaCookie);
		response.addCookie(cargoCookie);
		response.addCookie(anoInicioCookie);

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
		out.println("<a href='CadastroUser.jsp'>Voltar</a>");
		out.println("</body></html>");
	}
}
