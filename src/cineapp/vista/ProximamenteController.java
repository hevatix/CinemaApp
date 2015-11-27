package cineapp.vista;

import java.io.IOException;
import java.util.List;

import cineapp.MainApp;
import cineapp.modelo.Cartelera;
import cineapp.modelo.Pelicula;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class ProximamenteController {

	// Referenciar aplicacion principal
	private MainApp mainApp;
	private Cartelera cartelera;
	@FXML
	private GridPane gPArray;

	/**
	 * Contructor principal de la clase
	 */
	public ProximamenteController() {
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

	public void setPeliculas() {
		// Obtener peliculas de la Base de Datos
		List<Pelicula> peliculas = cartelera.getProximamente();
		// Colocar peliculas en gPArray
		int x = 1;
		int y = -1;
		String fechaEstreno = "";
		for (Pelicula pelicula : peliculas) {
			if (!fechaEstreno.equals(pelicula.getFechaEstreno())) {
				fechaEstreno = pelicula.getFechaEstreno();
				x = 1;
				y++;
				Label fecha = new Label(fechaEstreno);
				fecha.setStyle("-fx-font-size: 20.0pt;\r\n" + 
						"    -fx-font-family: \"Segoe UI Light\";\r\n" + 
						"    -fx-text-fill: white;\r\n" + 
						"    -fx-opacity: 1.0;");
				fecha.setTextAlignment(TextAlignment.CENTER);
				fecha.setWrapText(true);
				gPArray.add(fecha, 0, y);
			}
			addGridPane(pelicula, x, y);
			if (x++ == 4) { // Si se llego a la Ultima columna entonces saltar
				x = 1; // de fila y reestablecer la columna
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
