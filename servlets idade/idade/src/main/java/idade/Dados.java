package idade;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Dados")
public class Dados extends HttpServlet{
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
     ServletException,IOException {	
	response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        // Obtenha os valores enviados pelo formulário
        int anoNascimento = Integer.parseInt(request.getParameter("ano"));
        boolean fezAniversario = "on".equals(request.getParameter("fezAniversario"));
        
        // Calcule a idade com base no ano de nascimento e se a pessoa já fez aniversário
        int idade = calcularIdade(anoNascimento, fezAniversario);
        
        // Exiba a idade na resposta
    	PrintWriter writer = response.getWriter();
        writer.append("<html>");
        writer.append("<head>");
        writer.append("<title>Resposta</title>");
        writer.append("</head>");
        writer.append("<body>");
        writer.append("<h1>A idade da pessoa é: " + idade +  "</h1>");
        writer.append("</body>");
        writer.append("</html>");
    }
}
		private int calcularIdade(int anoNascimento, boolean fezAniversario) {
	        LocalDate dataAtual = LocalDate.now();
	        int idade = dataAtual.getYear() - anoNascimento;
	        
	        if (!fezAniversario) {
	            idade--;
	        }
	        
	        return idade;
	}   
}