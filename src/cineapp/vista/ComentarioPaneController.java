package cineapp.vista;

import cineapp.MainApp;
import cineapp.modelo.Comentario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ComentarioPaneController {

	// Referenciar aplicacion principal
	private MainApp mainApp;
	@FXML
	private Label lblUsuario;
	@FXML
	private TextArea tAComentario;
	private int id;
	
	/**
	 * Contructor principal de la clase
	 */
	public ComentarioPaneController() {

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

	public void setComentario(Comentario comentario) {
		id = comentario.getId();
		lblUsuario.setText(comentario.getUsuario());
		tAComentario.setText(comentario.getComentario());
	}
}
