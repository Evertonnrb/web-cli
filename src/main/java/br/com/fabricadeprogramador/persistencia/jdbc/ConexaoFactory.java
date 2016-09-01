package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoFactory {
	//Aqui abre a conexao com o banco
	public static Connection getConnection() {

		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb"
					, "postgres", "postgres");

		} catch (SQLException e) {
			//passando a exception para  classe UsuarioDao
			throw new RuntimeException(e);
		}

	}

}