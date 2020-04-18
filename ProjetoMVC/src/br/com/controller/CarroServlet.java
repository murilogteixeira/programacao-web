package br.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bo.CarroBO;

/**
 * Servlet implementation class CarroServlet
 */
@WebServlet("/CarroServlet")
// Controller da view
public class CarroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CarroBO carroBO = new CarroBO();
		String resultado = carroBO.insereCarro(req.getParameter("txtModeloVeiculo"), req.getParameter("txtFabricanteVeiculo"));
		
		if(resultado == "Resultado.jsp") {
			req.setAttribute("mensagem", "Inserção realizada com sucesso!");
		}
		else {
			req.setAttribute("mensagem", "Deu ruim. Algo de errado não está certo.");
		}
		
		req.getRequestDispatcher(resultado).forward(req, resp);
		
	}

}
