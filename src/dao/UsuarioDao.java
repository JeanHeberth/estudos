package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import domain.Usuario;
import factory.Conexao;

public class UsuarioDao {

	@PostConstruct
	public void salvar(Usuario usuario) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" insert into usuario (nome) values (?) ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comandoPrepare = conexao.prepareStatement(sql.toString());
		comandoPrepare.setString(1, usuario.getNome());
		comandoPrepare.executeUpdate();

	}

	public ArrayList<Usuario> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("select codigo,nome from usuario order by codigo asc");

		Connection conexao = Conexao.conectar();

		PreparedStatement comandoPrepare = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comandoPrepare.executeQuery();
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();

		while (resultado.next()) {
			Usuario user = new Usuario();
			user.setCodigo(resultado.getLong("codigo"));
			user.setNome(resultado.getString("nome"));

			listaUsuario.add(user);
		}
		return listaUsuario;

	}

	public ArrayList<Usuario> buscarPorDescricao(Usuario user) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("select codigo, nome from usuario where nome like ? order by nome asc ");

		Connection conexao = Conexao.conectar();
		PreparedStatement comandoPrepare = conexao.prepareStatement(sql.toString());
		comandoPrepare.setString(1, "%" + user.getNome() + "%");

		ResultSet resultado = comandoPrepare.executeQuery();

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		while (resultado.next()) {
			Usuario itemUsuario = new Usuario();
			itemUsuario.setCodigo(resultado.getLong("codigo"));
			itemUsuario.setNome(resultado.getString("nome"));
			
			lista.add(itemUsuario);
		}
		return lista;

	}

}
