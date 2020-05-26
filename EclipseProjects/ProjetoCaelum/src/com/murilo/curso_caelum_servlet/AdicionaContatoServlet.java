package com.murilo.curso_caelum_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			out.print("Erro na conversão da Data.");
			return;
		}

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);

//		ContatoDao dao = new ContatoDao();
//		dao.adiciona(contato)

		Calendar dtNasc = contato.getDataNascimento();
		dtNasc.add(Calendar.MONTH, 1);
		int dia = dtNasc.get(Calendar.DAY_OF_MONTH);
		int mes = dtNasc.get(Calendar.MONTH);
		int ano = dtNasc.get(Calendar.YEAR);

		out.print("<html>");
		out.print("<body>");
		out.print("Contato adicionado com sucesso!<br><br>");
		out.print("Nome: " + contato.getNome() + "<br>");
		out.print("Email: " + contato.getEmail() + "<br>");
		out.print("Endereço: " + contato.getEndereco() + "<br>");
		out.print("Data de Nascimento: " + dia + "/" + mes + "/" + ano + "<br>");
		out.print("<body>");
		out.print("<html>");
	}
}
