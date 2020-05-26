package com.murilo.web;

public class Calculadora {
	
	Double calcular(Double num1, Double num2, String operador) {
		switch (operador) {
		case "+":
			return(num1 + num2);

		case "-":
			return(num1 - num2);

		case "*":
			return(num1 * num2);

		case "/":
			return(num1 / num2);

		default:
			return(null);
		}
	}
}
