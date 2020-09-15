package bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.UsuarioDao;
import domain.Usuario;
import factory.Conexao;

@ManagedBean(name = "MBUsuario")
@RequestScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private UsuarioDao userDao;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UsuarioDao userDao) {
		this.userDao = userDao;
	}

	

}
