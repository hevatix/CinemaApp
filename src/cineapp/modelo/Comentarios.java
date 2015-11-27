package cineapp.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Comentarios {
	
	private final Connection conn = JDBC.getConnection();
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * Inserta el comentario mandado  en la base de datos
	 * @param comentario a insertar en la base de datos
	 */
	public void insertarComentario(Comentario comentario) {
		try {
			// Preparar consulta
			sql = "INSERT INTO comentarios VALUES (default,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, comentario.getComentario());
			ps.setInt(2, comentario.getRespuestaComentario());
			ps.setString(3, comentario.getUsuario());
			ps.setString(4, comentario.getCorreo());
			
			// Ejecutar la consulta
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Obtiene todos los comentarios
	 * @return Devuelve una lista con todos los comentarios
	 */
	public List<Comentario> obtenerComentarios() {
		// Objeto a retornar
		List<Comentario> comentarios = new ArrayList<>();
		
		try {
			// Preparar consulta
			sql = "SELECT * FROM comentarios ORDER BY id DESC";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// Procesar ResultSet
			if (rs.first()) {
				do {
					// Almacenar informacion por cada comentario
					Comentario comentario = new Comentario();
					comentario.setId(rs.getInt(1));
					comentario.setComentario(rs.getString(2));
					comentario.setRespuestaComentario(rs.getInt(3));
					comentario.setUsuario(rs.getString(4));
					comentario.setCorreo(rs.getString(5));
					
					//Añadir el comentario a la lista de comentarios
					comentarios.add(comentario);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comentarios;
	}
	
}
