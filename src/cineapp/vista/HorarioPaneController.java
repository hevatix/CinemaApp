package cineapp.vista;

import cineapp.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HorarioPaneController {

	private int id;

	// Aplicacion principal
	private MainApp mainApp;
	@FXML
	private ImageView iVPoster;
	@FXML
	private Label lblTitulo;
	@FXML
	private Label lblClasificacion;
	@FXML
	private Label lblHorarios;

	/**
	 * Contructor principal de la clase
	 */
	public HorarioPaneController() {

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
	 * Obetiene el ID para referenciar
	 * @return id
	 */
	public int getId () {
		return this.id;
	}
	
	/**
	 * Coloca la informacion referente a los horarios de la pelicula
	 * 
	 * @param id
	 * @param titulo
	 * @param clasificacion
	 * @param duracion
	 * @param horarios
	 */
	public void setData(int id, String titulo, String clasificacion, int duracion, String horarios, String posterUrl) {
		// Coloca el id
		this.id = id;

		// Coloca la imagen del poster
		Image image = new Image("http://192.168.1.64/" + posterUrl);
		iVPoster.setImage(image);

		// Coloca la informacion
		lblTitulo.setText(titulo);
		lblClasificacion
				.setText("Clasificación: " + clasificacion + " | Duración: " + Integer.toString(duracion) + "min.");
		lblHorarios.setText(horarios);
	}

}
