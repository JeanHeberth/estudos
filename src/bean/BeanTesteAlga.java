package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.util.JSFUtil;
import dao.UsuarioDao;
import domain.Usuario;

@ViewScoped
@ManagedBean(name = "BeanAlga")
public class BeanTesteAlga {

	private Usuario usuario = new Usuario();
	private ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void salvar() throws SQLException {

		try {
			this.listaUsuario.add(usuario);
			UsuarioDao userDao = new UsuarioDao();
			userDao.salvar(usuario);
			this.usuario = new Usuario();
			System.out.println("Salvo com sucesso");
		} catch (Exception e) {
			JSFUtil.adicionarMensagemDeErro(e.getMessage());
		}
	}

}