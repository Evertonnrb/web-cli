package br.com.fabricadeprogramador.test;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.fabricadeprogramador.persistencia.entidades.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDao;

public class TestUsuarioDao {
	public static void main(String[] args) {
		// buscarPorId();
		// testCadastrar();
		//testExcluir();
		testBuscarTodos();
	}

	public static void testCadastrar() {
		// Criando usuario
		Usuario usu = new Usuario();
		usu.setNome(JOptionPane.showInputDialog("Digite o nome: "));
		usu.setLogin(JOptionPane.showInputDialog("Digite o login do usuario"));
		usu.setSenha(JOptionPane.showInputDialog("Digite a senha do usuario"));
		// cadastrando no banco
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.cadastrar(usu);
		System.out.println("Cadastrado com sucesso");
	}

	public static void testAlterar() {
		// Alterando usuario
		Usuario usu = new Usuario();
		usu.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuario que deseja alterar")));// ṕassando
																												// o
																												// ID
																												// de
																												// referencia
																												// para
																												// alteraçao
																												// do
																												// usuario
		usu.setNome(JOptionPane.showInputDialog("Digite o nome do usuario"));
		usu.setLogin(JOptionPane.showInputDialog("Digite o login do usuaruio"));
		usu.setSenha(JOptionPane.showInputDialog("Digite a senha do usuario"));
		// cadastrando no banco
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.alterar(usu);
		System.out.println("Alterado com sucesso");
	}

	public static void testExcluir() {
		Usuario usu = new Usuario();
		usu.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID que deseja excluir")));// ṕassando
																									// o
																									// ID
																									// de
																									// referencia
																									// para
																									// alteraçao
																									// do
																									// usuario

		UsuarioDao usuDao = new UsuarioDao();
		usuDao.excluir(usu);
		System.out.println("Excluido com sucesso");
	}

	public static void testSalvar() {
		Usuario usu = new Usuario();
		// usu.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o id
		// que deseja salvar")));
		usu.setNome(JOptionPane.showInputDialog("Digite o nome do usuario"));
		usu.setLogin(JOptionPane.showInputDialog("Digite o login"));
		usu.setSenha(JOptionPane.showInputDialog("Digite o login"));

		UsuarioDao usuDao = new UsuarioDao();
		usuDao.salvar(usu);
		System.out.println("Usuario salvo com sucesso*");
	}

	public static void buscarPorId() {
		UsuarioDao usuDao = new UsuarioDao();
		Usuario usu = usuDao
				.BuscarPorId(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o cod para busca")));
		// Usuario usu = usuDao.BuscarPorId(3);
		JOptionPane.showMessageDialog(null, usu.toString());
	}
	public static void testBuscarTodos(){
		UsuarioDao usuDao = new UsuarioDao();
		List<Usuario> lista = usuDao.buscarTodos();
		for (Usuario u : lista) {
			JOptionPane.showMessageDialog(null, u);
		}
	}
}
