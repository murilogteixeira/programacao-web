package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.VeiculoBean;
import br.com.bo.VeiculoBO;

/**
 * Servlet implementation class ListaCarros
 */
@WebServlet("/VeiculoServlet")
public class VeiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VeiculoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		boolean logado = (boolean) req.getSession().getAttribute("logado");
		if (!logado) {
			doGet(req, res);
		}

		switch (req.getParameter("opcao")) {
			case "cadastrar":
				cadastrar(req, res);
				break;
			case "alugar":
				alugar(req, res);
				break;
			case "devolver":
				devolver(req, res);
				break;
			default:
				break;
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
		res.sendRedirect("cadastrarVeiculo.jsp");
	}

	public void alugar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer veiculoId = Integer.parseInt(req.getParameter("veiculoId"));
		VeiculoBO veiculoBO = new VeiculoBO();
		veiculoBO.alugar(veiculoId, true);

		res.sendRedirect("listaCarros.jsp");
	}

	public void devolver(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Integer veiculoId = Integer.parseInt(req.getParameter("veiculoId"));
		VeiculoBO veiculoBO = new VeiculoBO();
		veiculoBO.alugar(veiculoId, false);

		res.sendRedirect("listaCarros.jsp");
	}

	public ArrayList<VeiculoBean> listar() {
		// ArrayList<VeiculoBean> lista = new ArrayList<>();
		// VeiculoBean veiculo1 = new VeiculoBean("Volkwagem", "Arteon", "https://i0.statig.com.br/bancodeimagens/de/2a/rt/de2art1u6pp04a0dzhnwf4ess.jpg", 125.0, "", 0);
		// lista.add(veiculo1);
		// VeiculoBean veiculo2 = new VeiculoBean("Dodge", "Challenger", "https://combustivel.app/imgs/t650/consumo-rs6-avant-performance-4-0-v8-tfsi.jpg", 125.0, "", 1);
		// lista.add(veiculo2);
		// VeiculoBean veiculo3 = new VeiculoBean("Audi", "RS6", "https://i.ytimg.com/vi/shjCEUR5PjQ/maxresdefault.jpg", 125.0, "", 2);
		// lista.add(veiculo3);
		// VeiculoBean veiculo4 = new VeiculoBean("Renault", "Optima", "https://i.ytimg.com/vi/shjCEUR5PjQ/maxresdefault.jpg", 125.0, "", 3);
		// lista.add(veiculo4);
		// VeiculoBean veiculo5 = new VeiculoBean("Volkwagem", "Arteon", "https://i0.statig.com.br/bancodeimagens/de/2a/rt/de2art1u6pp04a0dzhnwf4ess.jpg", 125.0, "", 0);
		// lista.add(veiculo5);
		// VeiculoBean veiculo6 = new VeiculoBean("Dodge", "Challenger", "https://combustivel.app/imgs/t650/consumo-rs6-avant-performance-4-0-v8-tfsi.jpg", 125.0, "", 1);
		// lista.add(veiculo6);
		// VeiculoBean veiculo7 = new VeiculoBean("Audi", "RS6", "https://i.ytimg.com/vi/shjCEUR5PjQ/maxresdefault.jpg", 125.0, "", 2);
		// lista.add(veiculo7);
		// VeiculoBean veiculo8 = new VeiculoBean("Renault", "Optima", "https://i.ytimg.com/vi/shjCEUR5PjQ/maxresdefault.jpg", 125.0, "", 3);
		// lista.add(veiculo8);
		// return lista;
		return new VeiculoBO().lista();
	}

}