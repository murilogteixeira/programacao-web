package br.com.murilo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Pessoa") // Essa nota��o server para buscar a p�gina no servidor
public class PessoaServlet extends HttpServlet { // Sempre que eu criar uma classe servlet tenho que extender de HttpServlet

	private static final long serialVersionUID = 1L; 

	// Sempre que o usuário acessar vai passar por esse método
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter p = resp.getWriter();
		p.write("<html>");
		p.write("<head>");
		p.write("<title>Projeto06</title>");
		p.write("</head>");
		p.write("<body>");
		p.write("Meu primeiro projeto JavaWeb!!");
		p.write("</body>");
		p.write("</html>");
	}
}
