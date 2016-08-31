package br.com.fabricadeprogramador.test;

import br.com.fabricadeprogramador.persistencia.entidades.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDao;

public class TestUsuarioDao {
	public static void main(String[] args) {
		testExcluir();
	}

	public static void testCadastrar() {
		// Criando usuario
		Usuario usu = new Usuario();
		usu.setNome("Joa");
		usu.setLogin("Joa@silva");
		usu.setSenha("123");
		// cadastrando no banco
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.cadastrar(usu);
		System.out.println("Cadastrado com sucesso");
	}
	public static void testAlterar(){
		// Alterando usuario
				Usuario usu = new Usuario();
				usu.setId(1);//ṕassando o ID de referencia para alteraçao do usuario
				usu.setNome("Jao Aldo rovha nascimento");
				usu.setLogin("Aldo@silva");
				usu.setSenha("zubat");
				// cadastrando no banco
				UsuarioDao usuDao = new UsuarioDao();
				usuDao.alterar(usu);
				System.out.println("Alterado com sucesso");
	}
	public static void testExcluir(){
		Usuario usu = new Usuario();
		usu.setId(1);//ṕassando o ID de referencia para alteraçao do usuario
		
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.excluir(usu);
		System.out.println("Excluido com sucesso");
	}
}
