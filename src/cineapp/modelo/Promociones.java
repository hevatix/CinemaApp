package cineapp.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Promociones {

	private final Connection conn = JDBC.getConnection();
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * Obtiene las promociones de la base de datos
	 * @param id
	 */
	public Promocion getPromocion(int id) {
		Promocion promocion = new Promocion();
		try {
			// Generar consulta
			sql = "SELECT * FROM promociones WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			// Procesar ResultSet
			if (rs.first()) {
				promocion.setId(rs.getInt(1));
				promocion.setNombre(rs.getString(2));
				promocion.setDescripcion(rs.getString(3));
				promocion.setBannerUrl(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return promocion;
	}
	/**
	 * Obtiene el dia de la semana para cargar la promocion
	 * @return
	 */
	public int getDiaDeSemana() {
		int dia = 0;
		
		return dia;
	}
}
