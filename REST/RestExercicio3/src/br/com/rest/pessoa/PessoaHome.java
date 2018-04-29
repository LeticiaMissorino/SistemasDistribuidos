package br.com.rest.pessoa;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import br.com.rest.dados.PessoaDB;
import br.com.rest.entidade.Pessoa;


@Path("pessoa")
public class PessoaHome {
//imc = peso / (altura * altura)
	@GET
	@Path("nome={param1}/idade={param2}/peso={param3}/altura={param4}")
	public String tabuada(@PathParam("param1") String nome, @PathParam("param2") int idade, @PathParam("param3") float peso , @PathParam("param4") float altura) {		
		
		PessoaDB pessoaDado = new  PessoaDB();
		Pessoa pessoa = new Pessoa();
		try {
			pessoa.setNome(nome);
			pessoa.setIdade(idade);
			pessoa.setAltura(altura);
			pessoa.setPeso(peso);
			pessoa.setImc(Calculo(peso , altura));
			pessoaDado.inserir(pessoa);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "";

	}
	
	private float Calculo (float peso, float alt){
		float result =0;
		
		result = peso / (alt * alt);
		
		return result;
		
	}
	
}