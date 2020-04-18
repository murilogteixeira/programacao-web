package br.com.bo;

import br.com.bean.CarroBean;
import br.com.dao.CarroDAO;

// Regras de negócio
public class CarroBO {
	CarroDAO carroDAO = new CarroDAO();
	
	public String insereCarro(String modelo, String fabricante) {
		CarroBean carroBean = new CarroBean(modelo, fabricante);
		
		if(carroDAO.insereCarro(carroBean)) {
			return "Resultado.jsp";
		}
		
		return "Erro.jsp";
	}
}
