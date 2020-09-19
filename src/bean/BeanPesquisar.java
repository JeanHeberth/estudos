package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;

import br.com.drogaria.util.JSFUtil;
import dao.UsuarioDao;
import domain.Usuario;

@ManagedBean(name = "MBUsuario3")
@RequestScoped
public class BeanPesquisar implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Usuario> listarUsuarios;

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {

		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Usuario> getListausuarios() {
		return listarUsuarios;
	}

	public void setListausuarios(ArrayList<Usuario> listausuarios) {
		this.listarUsuarios = listausuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* Método para listar usuários no banco de dados */
	@PostConstruct
	public void listar() {
		try {
			UsuarioDao userDao = new UsuarioDao();
			listarUsuarios = userDao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Método para salvar usuários no banco de dados */
	public void salvar() throws SQLException {

		try {

			this.usuarios.add(usuario);
			UsuarioDao userdao = new UsuarioDao();
			userdao.salvar(usuario);
			this.usuario = new Usuario();
			listarUsuarios = userdao.listar();
			System.out.println("Usuário salvo com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
