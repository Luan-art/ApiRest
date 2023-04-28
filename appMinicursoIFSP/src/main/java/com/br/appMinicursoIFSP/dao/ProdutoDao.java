package com.br.appMinicursoIFSP.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.br.appMinicursoIFSP.conexao;
import com.br.appMinicursoIFSP.model.Produto;

public class ProdutoDao {


	public Produto insereProduto(Produto p) throws SQLException {
		PreparedStatement s = new conexao().conexao().prepareStatement("insert into cadproduto (descproduto) values (?)"
				,Statement.RETURN_GENERATED_KEYS);
		
		s.setString(1, p.getDescricao());
		s.execute();
		
		ResultSet rs = s.getGeneratedKeys();
		if ( rs.next()) {
			p.setCodigo(rs.getInt(1));
		}
		
		
		
		return p;
	}
	
	public Produto getProduto(int codigo) throws SQLException {
		
		PreparedStatement s = new conexao().conexao().prepareStatement("SELECT * FROM cadproduto where codproduto = ?");
		s.setInt(1, codigo);
		ResultSet rs = s.executeQuery();
		
		if (rs.next()) {
			Produto p = new Produto();
			p.setCodigo(codigo);
			p.setDescricao(rs.getString("descproduto"));
			
			return p;
		}
		
		
		return null;
	}
	
}
