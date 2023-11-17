package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Destino;


public class DestinoDAO {
	public void create(Destino destino) {

		String sql = "insert into Destinos (formas_de_pagamento, destino_da_viagem, data_de_ida, data_de_volta) values (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getFormas_de_pagamento());
			pstm.setString(2, destino.getDestino_da_viagem());
			pstm.setDate(3, new Date( destino.getData_de_ida().getTime()));
			pstm.setDate(4, new Date( destino.getData_de_volta().getTime()));
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
			public List<Destino> read() {
			List<Destino> destinos = new ArrayList<Destino>();
			String sql = "select * from destinos";

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				while (rset.next()) {
					Destino destino = new Destino();

					destino.setId_destino(rset.getInt("ID_Destinos"));
					destino.setFormas_de_pagamento(rset.getString("Formas_de_pagamento"));
					destino.setDestino_da_viagem(rset.getString("Destino_da_viagem"));
					destino.setData_de_ida(rset.getDate("Data_de_ida"));
					destino.setData_de_volta(rset.getDate("Data_de_volta"));

					destinos.add(destino);
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

			return destinos;
		}
			// update
			public void update(Destino destino) {
				String sql = "UPDATE destinos SET formas_de_pagamento = ?, destino_da_viagem = ?, data_de_ida = ?, data_de_volta = ? WHERE id_destinos = ?";

				Connection conn = null;
				PreparedStatement pstm = null;

				try {

					conn = ConnectionMySQL.createConnectionMySQL();

					pstm = conn.prepareStatement(sql);

					pstm.setString(1, destino.getFormas_de_pagamento());
					pstm.setString(2, destino.getDestino_da_viagem());
					pstm.setDate(3, new Date( destino.getData_de_ida().getTime()));
					pstm.setDate(4, new Date( destino.getData_de_volta().getTime()));
					pstm.setInt(5, destino.getId_destino());

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
				String sql = "DELETE FROM destinos WHERE id_Destinos = ?";

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
			public Destino readById(int id) {
				Destino destino = new Destino();
				String sql = "select * from destinos WHERE id_destinos = ?";

				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;

				try {
					conn = ConnectionMySQL.createConnectionMySQL();

					pstm = conn.prepareStatement(sql);
					pstm.setInt(1, id);
					rset = pstm.executeQuery();
					rset.next();
					destino.setId_destino(rset.getInt("ID_Destinos"));
					destino.setFormas_de_pagamento(rset.getString("Formas_de_pagamento"));
					destino.setDestino_da_viagem(rset.getString("Destino_da_viagem"));
					destino.setData_de_ida(rset.getDate("Data_de_ida"));
					destino.setData_de_volta(rset.getDate("Data_de_volta"));

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
				return destino;
			}
}