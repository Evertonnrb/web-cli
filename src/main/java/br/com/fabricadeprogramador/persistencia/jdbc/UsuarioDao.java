package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public void salvar(Usuario usu){
		if (usu.getId()!=null) {
			alterar(usu);
		} else {
			cadastrar(usu);
		}
	}
	/**
	 * Bucar registro no banco pelo numero do Id do usuário
	 * @paramid é um inteiro que retorna o numero do id do usuario 
	 * @return Objeto usuário que retorn o null quando não encontra 
	 */
	public Usuario BuscarPorId(Integer id){
		String sql = "select*from usuario where id=?";
		try (PreparedStatement prep = con.prepareStatement(sql);){
			prep.setInt(1,id);
			ResultSet resul = prep.executeQuery();
			if(resul.next()){
				Usuario usu = new Usuario();
				usu.setId(resul.getInt("id"));
				usu.setNome(resul.getString("nome"));
				usu.setLogin(resul.getString("login"));
				usu.setSenha(resul.getString("login"));
				
				return usu;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return JOptionPane.showMessageDialog(null,"Nao encontrado");
		return null;
	}
	/**
	 * Realiza a busca de todos o usuarios da tabela usuarios
	 * @return uma lista de objetos usuarios
	 */
	public List<Usuario> buscarTodos(){
		
		String sql = "select*from usuario";
		List<Usuario>lista = new ArrayList <Usuario>();
		try (PreparedStatement prep = con.prepareStatement(sql);){
			
			ResultSet resul = prep.executeQuery();
			while(resul.next()){
				Usuario usu = new Usuario();
				usu.setId(resul.getInt("id"));
				usu.setNome(resul.getString("nome"));
				usu.setLogin(resul.getString("login"));
				usu.setSenha(resul.getString("login"));
				
				lista.add(usu);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return JOptionPane.showMessageDialog(null,"Nao encontrado");
		return lista;
	}
}
