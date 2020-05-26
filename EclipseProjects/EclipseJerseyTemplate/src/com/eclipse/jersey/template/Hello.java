package com.eclipse.jersey.template;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

@Path("/teste")
public class Hello {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() {
		JSONObject json = new JSONObject();
		json.put("teste", "testando");
		return json.toString();
	}
}