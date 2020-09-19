package dao;




import domain.Usuario;

public class Buscar {
	
	public static void main(String[] args) {
		
		Usuario listaUsuario = new Usuario();
		listaUsuario.setNome("j");
		
		UsuarioDao  userDao = new UsuarioDao();
		try {

			ArrayL
			System.out.println("Salvo com sucesso!");
		}catch (Exception e) {
			System.out.println("Falha ao salvar!");
		}
	}

}
