package cineapp.modelo;

public class Comentario {

	// Data
	private int id;
	private String usuario;
	private String correo;
	private String comentario;
	private int respuestaComentario;
	
	// Getters
	public int getId() {
		return id;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getCorreo() {
		return correo;
	}
	public String getComentario() {
		return comentario;
	}
	public int getRespuestaComentario() {
		return respuestaComentario;
	}
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public void setRespuestaComentario(int respuestaComentario) {
		this.respuestaComentario = respuestaComentario;
		
	}
}
