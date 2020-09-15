package bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

import dao.UsuarioDao;
import domain.Usuario;

@RequestScoped
@ManagedBean
public class UsuarioBean2 {

	private String nome;
	private ArrayList<Usuario> nomes = new ArrayList<Usuario>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Usuario> getNomes() {
		return nomes;
	}

	public void setNomes(ArrayList<Usuario> nomes) {
		this.nomes = nomes;
	}

	public void listarUsuarios() {

		try {
			UsuarioDao userDao = new UsuarioDao();
			ArrayList<Usuario> listaUsuario = userDao.listar();
			nomes = new ArrayList<Usuario>(listaUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}