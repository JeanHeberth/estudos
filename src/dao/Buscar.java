package dao;

import java.util.ArrayList;

import domain.Usuario;

public class Buscar {

	public static void main(String[] args) {

		Usuario user = new Usuario();
		user.setNome("jean");

		UsuarioDao userDao = new UsuarioDao();

		try {
			ArrayList<Usuario> listarUsuario = userDao.buscarPorDescricao(user);
			for (Usuario u : listarUsuario) {
				System.out.println(" Resultado: " +u);

			}
		} catch (Exception e) {
			System.out.println("Erro ao tentar buscar");
		}
	}
}
