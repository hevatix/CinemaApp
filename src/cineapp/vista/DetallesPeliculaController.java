package cineapp.vista;

import cineapp.MainApp;
import cineapp.modelo.Cartelera;
import cineapp.modelo.Pelicula;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class DetallesPeliculaController {

	// Referenciar aplicacion principal
	private MainApp mainApp;
	// Datos de pelicula
	@FXML
	private ImageView iVPoster;
	@FXML
	private Label lblTitulo;
	@FXML
	private Label lblClasificacion;
	@FXML
	private Label lblDuracion;
	@FXML
	private Label lblGenero;
	@FXML
	private Label lblDirector;
	@FXML
	private Label lblReparto;
	@FXML
	private Label lblsinopsis;
	// Reproductor
	@FXML
	private MediaView mediaView;
	// Pelicula
	private Pelicula pelicula;
	private Cartelera cartelera;

	/**
	 * Contructor principal de la clase
	 */
	public DetallesPeliculaController() {
		cartelera = new Cartelera();
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
	 * Regresa a la ventana de cartelera
	 */
	@FXML
	private void handleBackButton() {
		mainApp.showCartelera();
	}

	/**
	 * Coloca la informacion de la pelicula seleccionada
	 */
	public void setMovieData(int id) {
		pelicula = cartelera.getPelicula(id);
		
		// Colocar informacion en labels
		lblTitulo.setText(pelicula.getTitulo());
		lblClasificacion.setText(pelicula.getClasificacion());
		lblDuracion.setText(Integer.toString(pelicula.getDuracion()) + "min.");
		lblGenero.setText(pelicula.getGenero());
		lblDirector.setText(pelicula.getDirector());
		lblReparto.setText(pelicula.getReparto());
		lblsinopsis.setText(pelicula.getSinopsis());
		
		// Cargar el poster
		Image image = new Image("http://192.168.1.64/" + pelicula.getPosterUrl());
		iVPoster.setImage(image);
		
		// Cargar el trailer
		reproducirVideo(pelicula.getTrailerUrl());
	}

	/**
	 * Agrega el trailer de la pelicula seleccionada al MediaView
	 */
	private void reproducirVideo(String url) {
		try {
			String source = "http://192.168.1.64/" + url;
			Media media = new Media(source);
			MediaPlayer player = new MediaPlayer(media);
			mediaView.setMediaPlayer(player);
			// player.play();
			// TODO: Solucionar continuar reproduccion
		} catch (MediaException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reproduce el video
	 */
	@FXML
	private void playVideo() {
		mediaView.getMediaPlayer().play();
	}
	
	/**
	 * Pausa el video
	 */
	@FXML
	private void pauseVideo() {
		mediaView.getMediaPlayer().pause();
	}
}
