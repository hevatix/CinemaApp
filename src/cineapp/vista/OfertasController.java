package cineapp.vista;

import cineapp.MainApp;
import cineapp.modelo.Promocion;
import cineapp.modelo.Promociones;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OfertasController {

	// Referenciar aplicacion principal
	private MainApp mainApp;
	@FXML
	private ImageView iVOferta;
	private Promociones promociones;

	/**
	 * Contructor principal de la clase
	 */
	public OfertasController() {
		promociones = new Promociones();
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

	public void setOferta(int id) {
		// Obtener informacion de la aplicacion
		Promocion promocion = promociones.getPromocion(id);
		
		// Colocar banner de la promocion
		Image image = new Image("http://192.168.1.64/" + promocion.getBannerUrl());
		iVOferta.setImage(image);
	}
	
}
