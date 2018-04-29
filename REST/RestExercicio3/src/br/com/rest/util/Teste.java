package br.com.rest.util;

import java.sql.SQLException;

import br.com.rest.dados.PessoaDB;
import br.com.rest.entidade.Pessoa;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

     Pessoa p = new Pessoa();
     
     p.setNome("teste");
     p.setAltura(12);
     
     try {
		new PessoaDB().inserir(p);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
