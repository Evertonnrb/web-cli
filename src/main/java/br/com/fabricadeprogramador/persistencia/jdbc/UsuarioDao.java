package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidades.Usuario;

public class UsuarioDao {
	// usando o método getConnetion da classe ConexaoFactory
	// para obter a conexao com o banco de dados
	private Connection con = ConexaoFactory.getConnection();

	// String sql ==> banco
	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario(nome,login,senha)values(?,?,?)";

		try {
			// passando para o preperadStatment a adm da sql
			PreparedStatement prep =  con.prepareStatement(sql);
			prep.setString(1,usu.getNome());
			prep.setString(2,usu.getLogin());
			prep.setString(3, usu.getSenha());
			prep.execute();
			prep.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usu) {
		//String para atualização no banco
		String sql = "update usuario set nome=?,login=?,senha=? where id=?";
		//try (){}==esse try e tipo um if (mais inteligente é auto closeble repare ele encerra a conxao auto)
		try (PreparedStatement prep =  con.prepareStatement(sql)){
			prep.setString(1,usu.getNome());
			prep.setString(2,usu.getLogin());
			prep.setString(3, usu.getSenha());
			prep.setInt(4, usu.getId());
			prep.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void excluir(Usuario usu) {
		String sql = "Delete from usuario where id=?";
		try (PreparedStatement prep = con.prepareStatement(sql)){
			prep.setInt(1,usu.getId());
			
			prep.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
