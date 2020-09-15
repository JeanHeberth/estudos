package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drogaria.util.JSFUtil;
import dao.UsuarioDao;
import domain.Usuario;

@ManagedBean(name = "MBUsuario3")
@RequestScoped
public class UsuarioBean3 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private ArrayList<Usuario> usuarios;

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

	public void salvar() {

		try {
			Usuario usuario = new Usuario();
			UsuarioDao userdao = new UsuarioDao();
			userdao.salvar(usuario);
			usuarios = userdao.listar();
			JSFUtil.adicionarMessagemDeSucesso("Fabricante salvo com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemDeErro(ex.getMessage());
		}

	}

}
