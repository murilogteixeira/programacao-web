package br.com.murilo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Mensagem")
public class MensagemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ArrayList<String> mensagens = new ArrayList<String>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setMensagens();
		String message = getRandomMessage();
		PrintWriter m = resp.getWriter();
		m.write("<html>");
		m.write("<head>");
		m.write("<title>Projeto06</title>");
		m.write("</head>");
		m.write("<body>");
		m.write(message);
		m.write("</body>");
		m.write("</html>");
	}
	
	public String getRandomMessage() {
		int arraySize = getMensagens().size();
		int index = new Random().nextInt(arraySize);
		return getMensagens().get(index);
	}

	public ArrayList<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens() {
		ArrayList<String> messages = new ArrayList<>();
		messages.add("N�o deixe que as pessoas te fa�am desistir daquilo que voc� mais quer na vida. Acredite. Lute. Conquiste. E acima de tudo, seja feliz.");
		messages.add("N�o importa o que voc� decidiu. O que importa � que isso te fa�a feliz.");
		messages.add("Algumas vezes coisas ruins acontecem em nossas vidas para nos colocar na dire��o das melhores coisas que poder�amos viver.");
		messages.add("Se a vida n�o ficar mais f�cil, trate de ficar mais forte.");
		this.mensagens = messages;
	}
	
}
