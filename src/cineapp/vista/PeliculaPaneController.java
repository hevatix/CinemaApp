package cineapp.vista;

import cineapp.MainApp;
import cineapp.modelo.Pelicula;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PeliculaPaneController {
	
	// Aplicacion Principal
	private MainApp mainApp;
	@FXML
	private ImageView iVPoster;
	@FXML
	private Label lblTitulo;
	private int id;

	/**
	 * Contructor principal de la clase
	 */
	public PeliculaPaneController() {

	}

	/**
	 * Inicializa el controlador. Este metodo es llamado al terminar de cargar
	 * el fxml
	 */
	@FXML
	private void initialize() {

	}
	
	/**
	 * Es llamado por la aplicacion principal para referenciarse a si misma
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Coloca la informacion de la pelicula
	 * @param tituloPelicula Titulo de la pelicula
	 * @param urlPoster Ubicacion de la imagen del poster
	 */
	public void setData(Pelicula pelicula) {
		// Colocar el id
		this.id = pelicula.getId();
		
		// Colocar el titulo
		lblTitulo.setText(pelicula.getTitulo());
		
		// Buscar la Imagen
		Image image = new Image("http://192.168.1.64/" + pelicula.getPosterUrl());
		iVPoster.setImage(image);
	}
	/**
	 * Se encarga de mostrar la vista de datalles de la pelicula seleccionada
	 */
	@FXML
	private void handleMovieSelection() {
		mainApp.showDetallesPelicula(id);
	}
}
