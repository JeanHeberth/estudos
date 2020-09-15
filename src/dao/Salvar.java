package dao;

import domain.Usuario;

public class Salvar {
	
	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Luiz Augusto");
		
		UsuarioDao  userDao = new UsuarioDao();
		try {
			userDao.salvar(usuario);
			System.out.println("Salvo com sucesso!");
		}catch (Exception e) {
			System.out.println("Falha ao salvar!");
		}
	}

}
