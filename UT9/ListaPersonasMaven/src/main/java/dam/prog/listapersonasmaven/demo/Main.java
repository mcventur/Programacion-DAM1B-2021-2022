package dam.prog.listapersonasmaven.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            //BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/vista/GuiPersonas.fxml"));

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(
                    this.getClass().getResource("/dam/prog/listapersonasmaven/GuiPersonas.fxml"));
            BorderPane root = loader.load();

            Scene scene = new Scene(root, 400, 400);
            //scene.getStylesheets().add(getClass().getResource("/vista/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Lista Personas con Maven y Scene Builder");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
