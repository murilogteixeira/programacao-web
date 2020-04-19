package br.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bo.VeiculoBO;

/**
 * Servlet implementation class ListaCarros
 */
@WebServlet("/CarroServlet")
public class VeiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VeiculoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = request.getRequestURL().toString();
		
		String marca = "";
		String modelo = "";
		String foto = "";
		Double preco = Double.parseDouble("");
		
		VeiculoBO veiculoBO = new VeiculoBO();
		boolean carroInserido = veiculoBO.insereVeiculo(marca, modelo, foto, preco);
		
		request.setAttribute("success", carroInserido);
		request.getRequestDispatcher(url).forward(request, response);
	}

}