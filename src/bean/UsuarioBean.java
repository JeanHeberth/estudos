package bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.UsuarioDao;
import domain.Usuario;
import factory.Conexao;


@ManagedBean
@RequestScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private ListDataModel<Usuario> usuarios;

	public ListDataModel<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ListDataModel<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@PostConstruct
	public void carregaUsuario() {
		try {
			UsuarioDao userDao = new UsuarioDao();
			ArrayList<Usuario> listaUsuario = userDao.listar();
			usuarios = new ListDataModel<Usuario>(listaUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void cadastrar() {
		
		usuario = new Usuario();
		
		try {
			if(!usuario.getNome().equals("")) {
				UsuarioDao userDao = new UsuarioDao();
				userDao.salvar(usuario);
				System.out.println("Salvo com sucesso!");
			}
		} catch (SQLException e) {
			System.out.println("Falha ao salvar");
		}
	}

}
