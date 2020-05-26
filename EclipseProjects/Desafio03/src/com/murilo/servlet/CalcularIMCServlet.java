package com.murilo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcular")
public class CalcularIMCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Double peso = Double.parseDouble(req.getParameter("peso"));
		Double altura = Double.parseDouble(req.getParameter("altura")) / 100;
		
		Double resultadoCalculo = calculaIMC(peso, altura);
//		
		req.setAttribute("imc", resultadoCalculo);
		req.getRequestDispatcher("resultado.jsp").forward(req, resp);
		
//		req.getSession().setAttribute("imc", resultadoCalculo);
//		resp.sendRedirect("resultado.jsp");
	}
	
	Double calculaIMC(Double peso, Double altura) {
		return peso / (altura * altura);
	}
}
