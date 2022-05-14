package pkgsemaforo.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pkgsemaforo.modelo.Semaforo;

public class GuiSemaforo extends Application
{

	private Semaforo semaforo; // el modelo
	private Button btnCambiar;
	private Label lblColor;

	@Override
	public void start(Stage primaryStage) {

		semaforo = new Semaforo();
		BorderPane root = crearGui();

		Scene scene = new Scene(root, 400, 300);

		scene.getStylesheets().add(getClass()
		                .getResource("/application.css")
		                .toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Semáforo JavaFX");
		primaryStage.show();

	}

	private BorderPane crearGui() {
		BorderPane panel = new BorderPane();
		//Trabajamos sobre la etiqueta con el color del semáforo
		lblColor = new Label();
		lblColor.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		ponerColorFondo();
		panel.setCenter(lblColor);
		//Trabajamos sobre el botón
		btnCambiar = new Button("_Cambiar color semáforo");
		//Esto hace, si el texto del control empieza por barra baja, que se pueda activar
		//usando Alt + la primera letra
		btnCambiar.setMnemonicParsing(true);
		btnCambiar.setMaxSize(Double.MAX_VALUE,100);
		btnCambiar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				cambiarColor();
			}
		});
		panel.setBottom(btnCambiar);

		return panel;
	}

	private void cambiarColor() {
		semaforo.avanzar();
		ponerColorFondo();
	}

	private void ponerColorFondo() {
		Color color = semaforo.getColor();
		lblColor.setBackground(new Background(
				new BackgroundFill(color, CornerRadii.EMPTY,
						Insets.EMPTY)));
	}

	public static void main(String[] args) {

		launch(args);
	}

}
