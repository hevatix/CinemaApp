package cineapp.vista;

import java.io.IOException;
import java.util.List;

import com.sun.javafx.font.freetype.FTFactory;

import cineapp.MainApp;
import cineapp.modelo.Comentario;
import cineapp.modelo.Comentarios;
import cineapp.modelo.Pelicula;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;

public class ComentariosController {

	// Referenciar aplicacion principal
	private MainApp mainApp;
	@FXML
	private GridPane gPArray;
	@FXML
	private TextField tFusuario;
	@FXML
	private TextField tFcorreo;
	@FXML
	private TextArea tAcomentario;
	@FXML
	private Label lblNotificacion;
	private Comentarios comentarios;

	/**
	 * Contructor principal de la clase
	 */
	public ComentariosController() {
		comentarios = new Comentarios();
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
	 * Obtiene la lista de comentarios de la base de datos y los coloca en orden
	 */
	public void cargarComentarios() {
		gPArray.getChildren().clear();
		List<Comentario> listComentarios = comentarios.obtenerComentarios();
		int y = 0;
		for (Comentario comentario : listComentarios) {
			addGridPane(comentario, y);
			y++;
		}
	}
	
	/**
	 * Almacena el comentario validado en la base de datos
	 */
	@FXML
	private void insertarComentario() {
		// Validar campos
		if (tFusuario.getText().trim().length() > 1) { 		// Validar usuario
			if (tFcorreo.getText().trim().length() > 8		// Validar correo
					&& tFcorreo.getText().indexOf('@') != -1
					&& tFcorreo.getText().indexOf('.') != -1) {
				if (tAcomentario.getText().trim().length() > 0) {	// Validar comentario
					Comentario comentario = new Comentario();
					comentario.setUsuario(tFusuario.getText());
					comentario.setCorreo(tFcorreo.getText());
					comentario.setRespuestaComentario(0);
					comentario.setComentario(tAcomentario.getText());
					comentarios.insertarComentario(comentario); 	// Insertar comentario
					mainApp.showComentarios();
				} else {	//Comentario vacio
					lblNotificacion.setText("¡Escriba un comentario!");
				}
			} else {		//Correo invalido
				lblNotificacion.setText("¡Use un correo válido!");
			}
		} else {	//Campo usuario vacio
			lblNotificacion.setText("¡Use un nombre válido!");
		}
	}
	
	/**
	 * Agrega el comentario cargado al GridPane
	 * @param comentario
	 * @param y
	 */
	private void addGridPane(Comentario comentario, int y) {
		try {
			// Cargar el GridPane
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("vista/ComentarioPane.fxml"));
			GridPane comentarioPane = (GridPane) loader.load();

			// Colocar en la ubicacion deseada
			gPArray.add(comentarioPane, 0, y);

			// Colocar informacion con el controlador
			ComentarioPaneController controlador = loader.getController();
			controlador.setComentario(comentario);

			// Dar acceso a la aplicacion principal
			controlador.setMainApp(mainApp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
