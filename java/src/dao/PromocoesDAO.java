package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Destino;
import model.Promocoes;
import model.Usuario;

public class PromocoesDAO {

	public void create(Promocoes promocao) {

		String sql = "insert into Promocoes (id_destinos, id_usuarios, descricao, preco) values (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, promocao.getDestino().getId_destino());
			pstm.setInt(2, promocao.getUsuario().getId_usuario());
			pstm.setString(3, promocao.getDescricao());
			pstm.setFloat(4, promocao.getPreco());

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
	public List<Promocoes> read() {
		List<Promocoes> promocoes = new ArrayList<Promocoes>();
		String sql = "select * from promocoes";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Promocoes promocao = new Promocoes();

				promocao.setId_promocoes(rset.getInt("ID_Promocoes"));
				promocao.setDescricao(rset.getString("Descricao"));
				promocao.setPreco(rset.getFloat("Preco"));
				int idUsuario = rset.getInt("ID_Usuarios");
				int idDestino = rset.getInt("ID_Destinos");
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.readById(idUsuario);
				promocao.setUsuario(usuario);
				DestinoDAO destinoDAO = new DestinoDAO();
				Destino destino = destinoDAO.readById(idDestino);
				promocao.setDestino(destino);

				promocoes.add(promocao);
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

		return promocoes;
	}

	// update
				public void update(Promocoes promocao) {
					String sql = "UPDATE promocoes SET id_destinos = ?, id_usuarios = ?, descricao = ?, preco = ? WHERE id_promocoes = ?";

					Connection conn = null;
					PreparedStatement pstm = null;

					try {

						conn = ConnectionMySQL.createConnectionMySQL();

						pstm = conn.prepareStatement(sql);

						pstm.setInt(1, promocao.getDestino().getId_destino());
						pstm.setInt(2, promocao.getUsuario().getId_usuario());
						pstm.setString(3, promocao.getDescricao());
						pstm.setFloat(4, promocao.getPreco());
						pstm.setInt(5, promocao.getId_promocoes());

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
					String sql = "DELETE FROM promocoes WHERE id_promocoes = ?";

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
				public Promocoes readById(int id) {
					Promocoes promocao = new Promocoes();
					String sql = "select * from promocoes WHERE id_promocoes = ?";

					Connection conn = null;
					PreparedStatement pstm = null;
					ResultSet rset = null;

					try {
						conn = ConnectionMySQL.createConnectionMySQL();

						pstm = conn.prepareStatement(sql);
						
						pstm.setInt(1, id);
						
						rset = pstm.executeQuery();
						
						rset.next();
						
						

						promocao.setId_promocoes(rset.getInt("ID_Promocoes"));
						promocao.setDescricao(rset.getString("Descricao"));
						promocao.setPreco(rset.getFloat("Preco"));
						int idUsuario = rset.getInt("ID_Usuarios");
						int idDestino = rset.getInt("ID_Destinos");
						UsuarioDAO usuarioDAO = new UsuarioDAO();
						Usuario usuario = usuarioDAO.readById(idUsuario);
						promocao.setUsuario(usuario);
						DestinoDAO destinoDAO = new DestinoDAO();
						Destino destino = destinoDAO.readById(idDestino);
						promocao.setDestino(destino);
						

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
					return promocao;
				}

}