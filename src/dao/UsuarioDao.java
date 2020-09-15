package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

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

}
