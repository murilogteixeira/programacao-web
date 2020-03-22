package com.murilo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcular")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String txtOperador1 = req.getParameter("nmbOperando1");
		String txtOperador2 = req.getParameter("nmbOperando2");
		String txtOperador = req.getParameter("txtOperador");

		Float operador1 = Float.parseFloat(txtOperador1.replace(",", "."));
		Float operador2 = Float.parseFloat(txtOperador2.replace(",", "."));

		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='UTF-8'>");
		out.print("<title>Resultado</title>");
		out.print("<head>");
		out.print("<body>");
		out.print(operador1 + " " + txtOperador + " " + operador2 + " = " + " "
				+ calcular(operador1, operador2, txtOperador));
		out.print("<body>");
		out.print("<html>");
	}

	Float calcular(Float op1, Float op2, String operador) {

		switch (operador) {
		case "+":
			return (op1 + op2);
		case "-":
			return (op1 - op2);
		case "*":
			return (op1 * op2);
		case "/":
			if (op1 == 0) {
				return (null);
			}
			return (op1 / op2);
		default:
			return (null);
		}
	}
}
