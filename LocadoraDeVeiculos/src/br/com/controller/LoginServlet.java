package br.com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.UsuarioBean;
import br.com.dao.UsuarioDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("src/pages/index.jsp");
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
		
		
		UsuarioBean usuarioAutenticado = autenticar(email, senha);
		
		
		if(usuarioAutenticado != null) {
			request.getSession().setAttribute("usuarioLogado", usuarioAutenticado);
			request.getSession().setAttribute("logado", true);
			request.getSession().setAttribute("dataHoraLogin", new Date());
			response.sendRedirect("src/pages/listaCarros.jsp");
			
			System.out.println("LoginServlet: usuario autenticado -> " + usuarioAutenticado.toString());
		}
		else {
			request.setAttribute("msg", "Email ou senha inválido!");
			request.getSession().setAttribute("logado", false);
			request.getRequestDispatcher("src/pages/login.jsp").forward(request, response);
		}
	}
	
	private UsuarioBean autenticar(String email, String senha) {
		UsuarioBean usuarioEncontrado = encontrarUsuario(email);
		
		if(usuarioEncontrado != null) {
			boolean senhaValidada = validarSenha(usuarioEncontrado.getSenha(), senha);
			if(senhaValidada) {
				
				return usuarioEncontrado;
			}
		}
		
		return null;
	}
	
	private UsuarioBean encontrarUsuario(String email) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		for(UsuarioBean usuario : usuarioDAO.lista()) {
			if(usuario.getEmail().equals(email)) {
				return usuario;
			}
		}
		return null;
	}
	
	private boolean validarSenha(String senhaUsuario, String senhaDigitada) {
		if(senhaUsuario.equals(senhaDigitada)) {
			return true;
		}
		
		return false;
	}
	
	private void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.getSession().setAttribute("usuarioLogado", null);
		request.getSession().setAttribute("logado", false);
		doGet(request, response);
	}

}
