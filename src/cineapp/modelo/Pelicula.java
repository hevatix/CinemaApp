package cineapp.modelo;

import java.sql.Date;

public class Pelicula {
	
	// Data
	private int id;
	private String titulo;
	private String clasificacion;
	private int duracion;
	private String genero;
	private String director;
	private String reparto;
	private String sinopsis;
	private String posterUrl;
	private String trailerUrl;
	private String horarios;
	private String fechaEstreno;
	
	// Getters
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public int getDuracion() {
		return duracion;
	}
	public String getGenero() {
		return genero;
	}
	public String getDirector() {
		return director;
	}
	public String getReparto() {
		return reparto;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public String getPosterUrl() {
		return posterUrl;
	}
	public String getTrailerUrl() {
		return trailerUrl;
	}
	public String getHorarios() {
		return horarios;
	}
	public String getFechaEstreno() {
		return fechaEstreno;
	}
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}
	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}
	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
}
