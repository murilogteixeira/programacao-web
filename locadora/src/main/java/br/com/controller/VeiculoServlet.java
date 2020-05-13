package br.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.bean.VeiculoBean;
import br.com.bo.VeiculoBO;

@WebServlet("/VeiculoServlet")
public class VeiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VeiculoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Object filter = req.getParameter("filter");
		if (filter != null) {
			req.getSession().setAttribute("carros", listar((String)filter));
			req.getSession().setAttribute("filter", (String)filter);
			req.getRequestDispatcher("index.jsp").forward(req, res);
		}
		else {
			res.sendRedirect("index.jsp");
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Object logadoObj = req.getSession().getAttribute("logado");
		if (logadoObj != null) {
			if(!(boolean)logadoObj) {
				doGet(req, res);
			}
		}

		Object opcao = req.getParameter("opcao");
		if(opcao != null) {
			switch ((String)opcao) {
				case "cadastrar":
					cadastrar(req, res);
					break;
				case "alterar":
					alterar(req, res);
					break;
				case "deletar":
					deletar(req, res);
					break;
				case "alugar":
					alugar(req, res);
					break;
				case "devolver":
					devolver(req, res);
					break;
				case "buscarId":
					buscarId(req, res);
					break;
				default:
					break;
			}
		}
		
 
	}

	public void cadastrar(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String marca = req.getParameter("txtMarca");
		String modelo = req.getParameter("txtModelo");
		String foto = req.getParameter("txtFoto");
		String descricao = req.getParameter("txtDescricao");
		Double preco = Double.parseDouble(req.getParameter("txtPreco"));

		VeiculoBO veiculoBO = new VeiculoBO();
		boolean carroCadastrado = veiculoBO.insereVeiculo(marca, modelo, foto, preco, descricao);

		req.getSession().setAttribute("veiculoCadastrado", carroCadastrado);
		res.sendRedirect("index.jsp");
	}

	public void alterar(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Integer veiculoId = Integer.parseInt(req.getParameter("veiculoId"));
		String marca = req.getParameter("txtMarca");
		String modelo = req.getParameter("txtModelo");
		String foto = req.getParameter("txtFoto");
		String descricao = req.getParameter("txtDescricao");
		Double preco = Double.parseDouble(req.getParameter("txtPreco"));

		VeiculoBean veiculo = new VeiculoBean(marca, modelo, foto, preco, descricao, veiculoId, false);

		VeiculoBO veiculoBO = new VeiculoBO();
		boolean carroCadastrado = veiculoBO.atualizarVeiculo(veiculo);
		System.out.println(carroCadastrado);

		res.sendRedirect("index.jsp");
	}

	public void deletar(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Integer veiculoId = Integer.parseInt(req.getParameter("veiculoId"));

		VeiculoBO veiculoBO = new VeiculoBO();
		boolean carroDeletado = veiculoBO.deletarVeiculo(veiculoId);
		System.out.println(carroDeletado);

		res.sendRedirect("index.jsp");
	}

	public void alugar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer veiculoId = Integer.parseInt(req.getParameter("veiculoId"));
		VeiculoBO veiculoBO = new VeiculoBO();
		veiculoBO.alugarVeiculo(veiculoId, true);

		req.getRequestDispatcher("index.jsp").forward(req, res);
	}

	public void devolver(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Integer veiculoId = Integer.parseInt(req.getParameter("veiculoId"));
		VeiculoBO veiculoBO = new VeiculoBO();
		veiculoBO.alugarVeiculo(veiculoId, false);

		res.sendRedirect("index.jsp");
	}

	public ArrayList<VeiculoBean> listar() {
		return new VeiculoBO().listarTodos();
	}

	public ArrayList<VeiculoBean> listar(String filter) {
		return new VeiculoBO().listarModelos(filter);
	}

	public void buscarId(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		VeiculoBean veiculo = new VeiculoBO().buscarId(id);
		
		String veiculoJson = new Gson().toJson(veiculo);
		
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		out.print(veiculoJson);
		out.flush();
	}

}