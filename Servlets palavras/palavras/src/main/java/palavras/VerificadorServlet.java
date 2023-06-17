package palavras;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VerificadorServlet")
public class VerificadorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String palavra1 = request.getParameter("palavra1");
        String palavra2 = request.getParameter("palavra2");

        int tamanhoPalavra1 = palavra1.length();
        int tamanhoPalavra2 = palavra2.length();

        boolean saoIguais = palavra1.equals(palavra2);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Resultado</title></head>");
        out.println("<body>");
        out.println("<h2>Resultado</h2>");
        out.println("<p>Palavra 1: " + palavra1 + "</p>");
        out.println("<p>Tamanho da Palavra 1: " + tamanhoPalavra1 + "</p>");
        out.println("<p>Palavra 2: " + palavra2 + "</p>");
        out.println("<p>Tamanho da Palavra 2: " + tamanhoPalavra2 + "</p>");
        out.println("<p>As palavras são " + (saoIguais ? "iguais" : "diferentes") + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}