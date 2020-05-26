package com.service.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.service.dao.ProdutoDAO;

@Path("produtos")
public class Produto {
    ProdutoDAO produtoDAO = new ProdutoDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
    	JSONObject json = new JSONObject();
		json.put("produtos", produtoDAO.lista());
		return json.toString();
    }
}

