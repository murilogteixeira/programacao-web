package com.webservice.service;

import com.google.gson.Gson;
import com.webservice.dao.ProdutoDAO;
import com.webservice.model.UserBean;

import org.json.JSONObject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("produtos")
public class Produtos {
    ProdutoDAO produtoDAO = new ProdutoDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        JSONObject json = new JSONObject();
        json.put("produtos", produtoDAO.lista());
        return json.toString();
    }

    @GET
    @Path("lista")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt2() {
        String json = new Gson().toJson(produtoDAO.lista());
        return json;
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(String json) {
        UserBean login = new Gson().fromJson(json, UserBean.class);
        return new Gson().toJson(login);
    }
}
