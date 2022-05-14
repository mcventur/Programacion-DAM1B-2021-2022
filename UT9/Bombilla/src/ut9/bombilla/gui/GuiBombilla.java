
package ut9.bombilla.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ut9.bombilla.modelo.Bombilla;

public class GuiBombilla extends Application {

    private Bombilla bombilla; // el modelo
    private Button btnEncender;
    private Button btnApagar;
    private Label lblImagen;

    @Override
    public void start(Stage primaryStage) {
        bombilla = new Bombilla();
        BorderPane root = crearGui();
        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets()
                .add(getClass().getResource(
                                "/css/application.css")
                        .toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle(" Bombilla JavaFX");
        primaryStage.show();

    }

    private BorderPane crearGui() {
        BorderPane panel = new BorderPane();
        panel.setPadding(new Insets(10));

        lblImagen = new Label();
        lblImagen.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        lblImagen.setAlignment(Pos.CENTER);
        lblImagen.getStyleClass().add("bg-black-style");
        panel.setCenter(lblImagen);
        panel.setBottom(crearPanelBotones());
        return panel;

    }

    private HBox crearPanelBotones() {
        HBox panel = new HBox();
        panel.setPadding(new Insets(10));
        panel.setSpacing(7);
        panel.setAlignment(Pos.CENTER);

        btnEncender = new Button("Encender");
        btnApagar = new Button("Apagar");
        btnApagar.setPrefWidth(100);
        btnApagar.setPrefWidth(100);
        btnApagar.setDisable(true);
        btnApagar.setOnAction(e->apagar());
        btnEncender.setOnAction(e->encender());

        panel.getChildren().addAll(btnEncender,btnApagar);
        return panel;
    }

    private void apagar() {
        bombilla.apagar();
        actualizaImagen();
    }

    private void encender() {
        bombilla.encender();
        actualizaImagen();
    }

    private void actualizaImagen() {
        lblImagen.setGraphic(new ImageView(bombilla.getImagen()));
        btnEncender.setDisable(!btnEncender.isDisable());
        btnApagar.setDisable(!btnApagar.isDisable());
    }


    public static void main(String[] args) {

        launch(args);
    }
}
