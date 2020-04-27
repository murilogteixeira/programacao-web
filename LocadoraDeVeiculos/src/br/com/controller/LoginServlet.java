package br.com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.UsuarioBean;
import br.com.bo.UsuarioBO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		switch ((String)request.getSession().getAttribute("loginOption")) {
		case "entrar":
			entrar(request, response);
			break;
		case "sair":
			sair(request, response);
			break;
		default:
			doGet(request, response);
		}
		
	}
	
	private void entrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		
		UsuarioBO usuarioBO = new UsuarioBO();
		UsuarioBean usuarioAutenticado = usuarioBO.autenticar(email, senha);
		
		if(usuarioAutenticado != null) {
			request.getSession().setAttribute("usuarioNome", usuarioAutenticado.getNome());
			request.getSession().setAttribute("logado", true);
			request.getSession().setAttribute("dataHoraLogin", new Date());
			response.sendRedirect("listaCarros.jsp");
			
			System.out.println("LoginServlet: usuario autenticado -> " + usuarioAutenticado.toString());
		}
		else {
			request.setAttribute("msg", "Email ou senha inválido!");
			request.getSession().setAttribute("logado", false);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	private void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.getSession().setAttribute("usuarioLogado", null);
		request.getSession().setAttribute("logado", false);
		doGet(request, response);
	}

}
