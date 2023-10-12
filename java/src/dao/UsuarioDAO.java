package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Usuario;

public class UsuarioDAO {
	// create
		public void create(Usuario usuario) {

			String sql = "insert into usuarios (nome_completo, cpf, endereco, email, telefone, senha) values (?, ?, ?, ?, ?, ?)";

			Connection conn = null;
			PreparedStatement pstm = null;

			try {
				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, usuario.getNome_completo());
				pstm.setString(2, usuario.getCpf());
				pstm.setString(3, usuario.getEndereco());
				pstm.setString(4, usuario.getEmail());
				pstm.setString(5, usuario.getTelefone());
				pstm.setString(6, usuario.getSenha());

				pstm.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		
		// read
		public List<Usuario> read() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuarios";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuario = new Usuario();

				usuario.setId_usuario(rset.getInt("ID_Usuarios"));
				usuario.setNome_completo(rset.getString("Nome_completo"));
				usuario.setEmail(rset.getString("Email"));
				usuario.setSenha(rset.getString("Senha"));
				usuario.setCpf(rset.getString("CPF"));
				usuario.setTelefone(rset.getString("Telefone"));
				usuario.setEndereco(rset.getString("Endereco"));

				
				
				usuarios.add(usuario);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return usuarios;
	}
		// update
		public void update(Usuario usuario) {
			String sql = "UPDATE usuarios SET nome_completo = ?, cpf = ?, endereco = ?, email = ?, telefone = ?, senha = ? WHERE id_usuarios = ?";

			Connection conn = null;
			PreparedStatement pstm = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, usuario.getNome_completo());
				pstm.setString(2, usuario.getCpf());
				pstm.setString(3, usuario.getEndereco());
				pstm.setString(4, usuario.getEmail());
				pstm.setString(5, usuario.getTelefone());
				pstm.setString(6, usuario.getSenha());
				pstm.setInt(7, usuario.getId_usuario());

				pstm.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}


		// delete
		public void delete(int id) {
			String sql = "DELETE FROM usuarios WHERE id_usuarios = ?";

			Connection conn = null;
			PreparedStatement pstm = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);

				pstm.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		
		// readById
		public Usuario readById(int id) {
			Usuario usuario = new Usuario();
			String sql = "select * from usuarios WHERE id_usuarios = ?";

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;

			try {
				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				rset = pstm.executeQuery();
				
				rset.next();
				
				usuario.setId_usuario(rset.getInt("ID_Usuarios"));
				usuario.setNome_completo(rset.getString("Nome_completo"));
				usuario.setEmail(rset.getString("Email"));
				usuario.setSenha(rset.getString("Senha"));
				usuario.setCpf(rset.getString("CPF"));
				usuario.setTelefone(rset.getString("Telefone"));
				usuario.setEndereco(rset.getString("Endereco"));
				

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return usuario;
		}

	
}
