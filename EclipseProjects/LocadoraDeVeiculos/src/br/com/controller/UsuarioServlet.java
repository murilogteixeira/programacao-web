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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Object opcao = req.getParameter("opcao");
		if (opcao != null) {
			switch ((String) opcao) {
				case "cadastro":
					cadastrar(req, res);
					break;
				case "login":
					login(req, res);
					break;
				default:
<<<<<<< HEAD
					doGet(req, res);
=======
>>>>>>> 8c45b2b8b3aedecb592ccc7f9f90279b50988861
					break;
			}
		}
	}

	private void cadastrar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String nome = req.getParameter("txtNome");
		String email = req.getParameter("txtEmail");
		String senha = req.getParameter("txtSenha");

		UsuarioBO usuarioBO = new UsuarioBO();
		UsuarioBean usuarioCadastrado = usuarioBO.insereUsuario(nome, email, senha);

		req.setAttribute("tentativaCadastro", true);

		if (usuarioCadastrado != null) {
			req.getRequestDispatcher("login.jsp").forward(req, res);
			req.setAttribute("cadastroEfetuado", true);
			req.setAttribute("usuarioCadastrado", usuarioCadastrado);
		} else {
			req.getRequestDispatcher("cadastroUsuario.jsp").forward(req, res);
			req.setAttribute("cadastroEfetuado", false);
			req.setAttribute("msgErro", "Usuário já cadastrado.");
		}
	}

	private void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Object loginOption = req.getSession().getAttribute("loginOption");
		if(loginOption != null) {
			switch ((String) loginOption) {
				case "entrar":
					entrar(req, res);
					break;
				case "sair":
					req.getSession().setAttribute("usuarioLogado", null);
					req.getSession().setAttribute("logado", false);
<<<<<<< HEAD
					res.sendRedirect("index.jsp");
=======
					doGet(req, res);
>>>>>>> 8c45b2b8b3aedecb592ccc7f9f90279b50988861
					break;
				default:
					doGet(req, res);
			}
		}
	}

	private void entrar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("txtEmail");
		String senha = req.getParameter("txtSenha");

		UsuarioBO usuarioBO = new UsuarioBO();
		UsuarioBean usuarioAutenticado = usuarioBO.autenticar(email, senha);

		if (usuarioAutenticado != null) {
			req.getSession().setAttribute("usuarioNome", usuarioAutenticado.getNome());
			req.getSession().setAttribute("logado", true);
			req.getSession().setAttribute("dataHoraLogin", new Date());
			res.sendRedirect("index.jsp");
		} else {
			req.setAttribute("msg", "Email ou senha inválido!");
			req.getSession().setAttribute("logado", false);
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}

}