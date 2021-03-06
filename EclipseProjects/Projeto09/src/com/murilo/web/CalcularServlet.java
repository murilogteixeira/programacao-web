package com.murilo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcularServlet
 */
@WebServlet("/calcular")
public class CalcularServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
				
		out.print("<html>");
		out.print("<body>");
		out.print("<a href=\"index.jsp\">Calculadora</a>");
		out.print("<body>");
		out.print("<html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Double num1 = Double.parseDouble(req.getParameter("num1"));
		Double num2 = Double.parseDouble(req.getParameter("num2"));
		String operador = req.getParameter("operador");
				
		Calculadora calc = new Calculadora();
		Double resultado = calc.calcular(num1, num2, operador);
		
		req.setAttribute("num1", num1);
		req.setAttribute("num2", num2);
		req.setAttribute("operador", operador);
		req.setAttribute("resultado", resultado);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
