package cineapp.vista;

import cineapp.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BarraLateralController {

	@FXML
	private Button btnCartelera;
	@FXML
	private Button btnHorarios;
	@FXML
	private Button btnProximamente;
	@FXML
	private Button btnOfertas;
	@FXML
	private Button btnComentarios;

	// Referenciar aplicacion principal
	private MainApp mainApp;

	/**
	 * Contructor principal de la clase
	 */
	public BarraLateralController() {

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
	 * Mostrar en la ventana principal Cartelera.fxml
	 */
	@FXML
	private void handleButtonCartelera() {
		mainApp.showCartelera();
	}

	/**
	 * Mostrar en la ventana principal Horarios.fxml
	 */
	@FXML
	private void handleButtonHorarios() {
		mainApp.showHorarios();
	}

	/**
	 * Mostrar en la ventana principal Proximamente.fxml
	 */
	@FXML
	private void handleButtonProximamente() {
		mainApp.showProximamente();
	}

	/**
	 * Mostrar en la ventana principal Ofertas.fxml
	 */
	@FXML
	private void handleButtonOfertas() {
		mainApp.showOfertas();
	}

	/**
	 * Mostrar en la ventana principal Comentarios.fxml
	 */
	@FXML
	private void handleButtonComentarios() {
		mainApp.showComentarios();
	}
}
