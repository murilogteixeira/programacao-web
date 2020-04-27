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
@WebServlet("/VeiculoServlet")
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
		
		String marca = request.getParameter("txtMarca");
		String modelo = request.getParameter("txtModelo");
		String foto = request.getParameter("txtFoto");
		Double preco = Double.parseDouble(request.getParameter("txtPreco"));
		
		VeiculoBO veiculoBO = new VeiculoBO();
		boolean carroCadastrado = veiculoBO.insereVeiculo(marca, modelo, foto, preco);
		
		request.getSession().setAttribute("veiculoCadastrado", carroCadastrado);
		response.sendRedirect("listaCarros.jsp");
	}

}