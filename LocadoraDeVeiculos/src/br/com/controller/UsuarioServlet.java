package br.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.UsuarioBean;
import br.com.bo.UsuarioBO;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("txtNome");
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		
		UsuarioBO usuarioBO = new UsuarioBO();
		UsuarioBean usuarioCadastrado = usuarioBO.insereUsuario(nome, email, senha);
		
		request.setAttribute("tentativaCadastro", true);
		
		if(usuarioCadastrado != null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			request.setAttribute("cadastroEfetuado", true);
			request.setAttribute("usuarioCadastrado", usuarioCadastrado);
		}
		else {
			request.getRequestDispatcher("cadastroUsuario.jsp").forward(request, response);
			request.setAttribute("cadastroEfetuado", false);
			request.setAttribute("msgErro", "Usuário já cadastrado.");
		}
		
	}

}