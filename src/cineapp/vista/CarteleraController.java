package cineapp.vista;

import java.io.IOException;
import java.util.List;

import cineapp.MainApp;
import cineapp.modelo.Cartelera;
import cineapp.modelo.Pelicula;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class CarteleraController {

	// Referenciar aplicacion principal
	private MainApp mainApp;
	@FXML
	private GridPane gPArray;
	private Cartelera cartelera;

	/**
	 * Contructor principal de la clase
	 */
	public CarteleraController() {
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
	 * Muestra las peliculas en cartelera desde la base de datos
	 */
	public void cargarCartelera() {
		// Obtener peliculas de la Base de Datos
		List<Pelicula> peliculas = cartelera.getCartelera();
		// Colocar peliculas en gPArray
		int x = 0;
		int y = 0;
		for (Pelicula pelicula : peliculas) {
			addGridPane(pelicula, x, y);
			x++;
			if (x == 4) { // Si se llego a la Ultima columna entonces saltar
				x = 0; // de fila y reestablecer la columna
				y++;
			}
		}
	}

	/**
	 * Agrega el panel de pelicula a la cartelera
	 * 
	 * @param id
	 *            de la pelicula
	 * @param tituloPelicula
	 *            Titulo
	 * @param urlPoster
	 *            Ubicacion del poster
	 * @param x
	 *            Columna en la cual poner la pelicula
	 * @param y
	 *            Fila en la cual poner la pelicula
	 */
	private void addGridPane(Pelicula pelicula, int x, int y) {
		try {
			// Cargar el GridPane
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("vista/PeliculaPane.fxml"));
			GridPane peliculaPane = (GridPane) loader.load();

			// Colocar en la ubicacion deseada
			gPArray.add(peliculaPane, x, y);

			// Colocar informacion con el controlador
			PeliculaPaneController controlador = loader.getController();
			controlador.setData(pelicula);

			// Dar acceso a la aplicacion principal
			controlador.setMainApp(mainApp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
