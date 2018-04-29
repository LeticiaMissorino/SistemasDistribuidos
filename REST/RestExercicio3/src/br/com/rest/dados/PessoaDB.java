package br.com.rest.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rest.entidade.Pessoa;
import br.com.rest.util.Conexao;

public class PessoaDB {

	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public PessoaDB(){
		
		connection = Conexao.getConnection();
		
	}
	public boolean inserir(Pessoa pessoa) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("INSERT INTO PESSOA (nome, idade , peso, altura , imc) values (?, ?, ?, ?, ?)");

			stmt.setString(1, pessoa.getNome());
			stmt.setInt(2, pessoa.getIdade());
			stmt.setFloat(3, pessoa.getPeso());
			stmt.setFloat(4, pessoa.getAltura());
			stmt.setFloat(5, pessoa.getImc());
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}
	
		public List<Pessoa> getAll() {

		List<Pessoa> lstCadastro = new ArrayList<>();
		try {
			ps = this.connection.prepareStatement("SELECT  nome, idade, peso, altura, imc FROM PESSOA");
			rs = ps.executeQuery();

			while (rs.next()) {
				lstCadastro.add(new Pessoa( rs.getString("nome"), rs.getInt("idade"), rs.getFloat("peso"), rs.getFloat("altura"), rs.getFloat("imc")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstCadastro;
	}
	
	
	
}
