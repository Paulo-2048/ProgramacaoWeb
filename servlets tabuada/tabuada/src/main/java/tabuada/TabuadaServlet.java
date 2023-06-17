package tabuada;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TabuadaServlet")
public class TabuadaServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtém o número informado pelo usuário
        int numero = Integer.parseInt(request.getParameter("numero"));

        out.println("<html>");
        out.println("<head><title>Tabuada</title></head>");
        out.println("<body>");
        out.println("<h1>Tabuada do " + numero + "</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Operação</th><th>Resultado</th></tr>");

        // Calcula a tabuada do número informado
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            out.println("<tr><td>" + numero + " x " + i + "</td><td>" + resultado + "</td></tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}