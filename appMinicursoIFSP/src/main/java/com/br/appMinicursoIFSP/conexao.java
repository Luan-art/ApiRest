package com.br.appMinicursoIFSP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
	 public Connection conexao() throws SQLException {
		   Connection conexao = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres",
					"aluno", "aluno");
		   return conexao;
	   }
}
