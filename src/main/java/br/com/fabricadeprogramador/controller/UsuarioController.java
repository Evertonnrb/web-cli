package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.fabricadeprogramador.persistencia.entidades.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDao;

//http://localhost:8080/fabricaweb/usucontrole.do
@WebServlet("/usucontroler.do")
public class UsuarioController extends HttpServlet {

	public UsuarioController(){
		System.out.println("Chamou o construtuor");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("Chamou o init");
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JOptionPane.showMessageDialog(null, "Chamou o get!!!");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usu = new Usuario();
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.salvar(usu);
		resp.getWriter().println("<b>Gravado com sucesso</b>");
		System.out.println("Gravado com sucesso");
		
		
		
	}
	@Override
	public void destroy() {
		System.out.println("Destroy....");
		super.destroy();
	}
}
