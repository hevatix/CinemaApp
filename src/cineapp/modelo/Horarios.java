package cineapp.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Horarios {

	private final Connection conn = JDBC.getConnection();
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * Obtiene los horarios de peliculas
	 * @param dias que sumar a la fecha actual para obtener la cartelera.
	 * 				Si es 0 muestra la cartelera del dia actual.
	 * @param idSucursal sucursal
	 * @return
	 */
	public List<Pelicula> getHorarios(int dias, int idSucursal) {
		List<Pelicula> peliculas = new ArrayList<>();
		try {
			// Generar consilta
			sql = "SELECT\r\n" + 
					"	Horarios.id,\r\n" + 
					"	Peliculas.id,\r\n" + 
					"	Peliculas.titulo,\r\n" + 
					"	Peliculas.clasificacion,\r\n" + 
					"	Peliculas.duracion,\r\n" + 
					"	Peliculas.posterUrl\r\n" + 
					"FROM Horarios\r\n" + 
					"	JOIN Peliculas on Horarios.pelicula = Peliculas.id\r\n" + 
					"WHERE\r\n" + 
					"	DATE(Horarios.fecha) = DATE_ADD(DATE(NOW()), INTERVAL ? DAY)\r\n" + 
					"	AND Horarios.cine = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dias);
			ps.setInt(2, idSucursal);
			rs = ps.executeQuery();
			
			// Procesar ResultSet
			if (rs.first()) {
				do {
					// Obtener los valores
					Pelicula pelicula = new Pelicula();
					int idHorario = rs.getInt(1);
					pelicula.setId(rs.getInt(2));
					pelicula.setTitulo(rs.getString(3));
					pelicula.setClasificacion(rs.getString(4));
					pelicula.setDuracion(rs.getInt(5));
					pelicula.setPosterUrl(rs.getString(6));
					
					// Agregar las horas de proyeccion
					pelicula.setHorarios(getHorasPelicula(idHorario));
					
					// Agregar la pelicula a la lista
					peliculas.add(pelicula);
				} while (rs.next());
			} else {
				peliculas = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peliculas;
	}
	
	/**
	 * Retorna las diferentes horas de proyeccion de una misma pelicula
	 * 
	 * @param idPelicula
	 * @return
	 */
	private String getHorasPelicula(int idHorario) {
		String horas = "";
		try {
			// Generar consilta
			sql = "SELECT\r\n" + 
					"	hora\r\n" + 
					"FROM\r\n" + 
					"	horaspeliculas\r\n" + 
					"WHERE\r\n" + 
					"	horario = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idHorario);
			ResultSet rs = ps.executeQuery();
			
			// Procesar ResultSet
			if (rs.first()) {
				do {
					horas += rs.getString(1) + " | ";
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return horas;
	}
}
