package br.com.rest.exercicio;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("tabuada")
public class Tabuada {

	@GET
	@Path("tabuada={param}")
	public String tabuada(@PathParam("param") int num) {

		String result = "Tabuada: " + num + "<br>";
		int mult = 0;
		for (int x = 0; x <= 10; x++) {
			mult = num * x;
			result = result + num + "X" + x + "=" + mult + "<br>";

		}
		return result;

	}

}
