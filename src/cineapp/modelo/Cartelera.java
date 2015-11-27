package cineapp.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cartelera {

	private final Connection conn = JDBC.getConnection();
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * Obtiene las peliculas listadas como en cartelera de
	 * la Base de Datos
	 * @return Peliculas en cartelera
	 */
	public List<Pelicula> getCartelera() {
		List<Pelicula> peliculas = new ArrayList<>();
		try {
			// Generar consulta
			sql = "SELECT\r\n" + 
					"	id,\r\n" + 
					"	titulo,\r\n" + 
					"	posterUrl\r\n" + 
					"FROM peliculas\r\n" + 
					"WHERE estado = 1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// Procesar ResultSet
			if (rs.first()) {
				do {
					// Obtener los valores
					Pelicula pelicula = new Pelicula();
					pelicula.setId(rs.getInt(1));
					pelicula.setTitulo(rs.getString(2));
					pelicula.setPosterUrl(rs.getString(3));
					
					// Agregar la pelicula a la lista
					peliculas.add(pelicula);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peliculas;
	}
	
	public Pelicula getPelicula(int id) {
		Pelicula pelicula = new Pelicula();
		try {
			// Generar consulta
			sql = "SELECT\r\n" + 
					"	titulo,\r\n" + 
					"	director,\r\n" + 
					"	reparto,\r\n" + 
					"	descripcion,\r\n" + 
					"	clasificacion,\r\n" + 
					"	duracion,\r\n" + 
					"	genero,\r\n" + 
					"	posterUrl,\r\n" + 
					"	trailerUrl\r\n" + 
					"FROM peliculas\r\n" + 
					"WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			//Procesar ResultSet
			if (rs.first()) {
				pelicula.setTitulo(rs.getString(1));
				pelicula.setDirector(rs.getString(2));
				pelicula.setReparto(rs.getString(3));
				pelicula.setSinopsis(rs.getString(4));
				pelicula.setClasificacion(rs.getString(5));
				pelicula.setDuracion(rs.getInt(6));
				pelicula.setGenero(rs.getString(7));
				pelicula.setPosterUrl(rs.getString(8));
				pelicula.setTrailerUrl(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pelicula;
	}

	/**
	 * Obtiene las peliculas listadas como proximos estrenos de
	 * la Base de Datos
	 * @return Proximos estrenos
	 */
	public List<Pelicula> getProximamente() {
		List<Pelicula> peliculas = new ArrayList<>();
		try {
			// Generar consulta
			sql = "SET lc_time_names = 'es_MX'";
			ps = conn.prepareStatement(sql);
			ps.execute();
			sql = "SELECT\r\n" + 
					"	id,\r\n" + 
					"	titulo,\r\n" + 
					"	DAYOFMONTH(fechaEstreno),\r\n" + 
					"	MONTHNAME(fechaEstreno),\r\n" + 
					"	posterUrl\r\n" + 
					"FROM peliculas\r\n" + 
					"WHERE estado = 2\r\n" + 
					"ORDER BY fechaEstreno ASC";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// Procesar ResultSet
			if (rs.first()) {
				do {
					// Obtener los valores
					Pelicula pelicula = new Pelicula();
					pelicula.setId(rs.getInt(1));
					pelicula.setTitulo(rs.getString(2));
					pelicula.setFechaEstreno(rs.getInt(3) + " de\n" + rs.getString(4));
					pelicula.setPosterUrl(rs.getString(5));
					
					// Agregar la pelicula a la lista
					peliculas.add(pelicula);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peliculas;
	}
}
