package test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import modelo.ComandoType;

import java.io.File;
import java.io.IOException;

public class AppComandoType extends Application {

    private Button bntAbrir;
    private Button bntSalir;

    private ComandoType type;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        type = new ComandoType(); // crear el modelo
        HBox root = crearGui();

        Scene scene = new Scene(root, 300, 100);
        stage.setScene(scene);
        stage.setTitle("- Comando Type -");
        scene.getStylesheets().add(
                getClass().getResource("/application.css")
                        .toExternalForm());
        stage.show();
    }

    private HBox crearGui() {

        HBox panel = new HBox();
        panel.setPadding(new Insets(12));
        panel.setSpacing(10);
        panel.setAlignment(Pos.CENTER);
        bntAbrir = new Button("Abrir fichero");
        bntAbrir.setOnAction(event -> abrir());
        bntAbrir.setPrefWidth(150);
        bntAbrir.setMaxHeight(Integer.MAX_VALUE);
        bntSalir = new Button("Salir");
        bntSalir.setPrefWidth(150);
        bntSalir.setMaxHeight(Integer.MAX_VALUE);
        bntSalir.setOnAction(event -> salir());

        panel.getChildren().addAll(bntAbrir, bntSalir);

        return panel;
    }

    private void abrir() {

        FileChooser elector = new FileChooser();
        elector.setTitle("Abrir fichero");
        elector.setInitialDirectory(new File("."));
        elector.getExtensionFilters()
                .addAll(new ExtensionFilter("java", "*.java"));
        File f = elector.showOpenDialog(null);
        if (f != null) {
            String nombre = f.getAbsolutePath();
            System.out.println(nombre);
            try {
                type.mostrarFicheroV1(nombre);
                // type.mostrarFicheroV2(nombre);
            }
            catch (IOException e) {
                System.out.println("Error al mostrar fichero " + nombre);
            }

        }
    }

    private void salir() {
        Platform.exit();
    }
}
