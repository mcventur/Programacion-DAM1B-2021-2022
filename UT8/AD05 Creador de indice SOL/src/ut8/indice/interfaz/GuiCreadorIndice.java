package ut8.indice.interfaz;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import ut8.indice.io.CreadorIndice;

import java.io.File;
import java.io.IOException;

public class GuiCreadorIndice extends Application {

    private Label lblCabecera;
    private Label lblStatus;
    private TextArea areaTexto;
    private Button btnAbrir;
    private Button btnSalvar;
    private CreadorIndice creador;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        creador = new CreadorIndice(); // crear el modelo
        BorderPane root = crearGui();

        Scene scene = new Scene(root, 550, 400);
        stage.setScene(scene);
        stage.setTitle("- Creador de un índice de documento -");
        scene.getStylesheets().add(
                getClass().getResource("/application.css")
                        .toExternalForm());
        stage.show();
    }

    private BorderPane crearGui() {

        BorderPane panel = new BorderPane();
        panel.setPadding(new Insets(10));
        lblCabecera = new Label("Creador índice documento");
        lblCabecera.setId("labelCabecera");
        lblCabecera.setMaxWidth(Integer.MAX_VALUE);
        panel.setTop(lblCabecera);
        areaTexto = new TextArea();
        panel.setCenter(areaTexto);
        lblStatus = new Label("Aquí se mostrará el resultado");
        lblStatus.setMaxWidth(Integer.MAX_VALUE);
        lblStatus.setDisable(true);
        panel.setBottom(lblStatus);

        panel.setRight(crearPanelBotones());
        return panel;
    }

    private VBox crearPanelBotones() {

        VBox panel = new VBox();
        panel.setPadding(new Insets(10));
        panel.setSpacing(8);

        btnAbrir = new Button("Abrir fichero");
        btnAbrir.setPrefSize(150, 50);
        btnAbrir.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                abrir();

            }

        });
        btnSalvar = new Button("Salvar índice\nen fichero");
        btnSalvar.setPrefSize(150, 50);
        btnSalvar.setOnAction(event -> salvar());

        panel.getChildren().addAll(btnAbrir, btnSalvar);
        return panel;
    }

    private void salvar() {

        FileChooser elector = new FileChooser();
        elector.setTitle("Salvar fichero");
        elector.setInitialDirectory(new File("."));
        elector.getExtensionFilters()
                .addAll(new ExtensionFilter("txt", "*.txt"));
        File f = elector.showSaveDialog(null);
        if (f != null) {
            try {
                creador.guardarIndiceDocumento(f);
                lblStatus.setText("Guardado índice en fichero " + f.getName());
            } catch (IOException e) {
                System.out.println(
                        "Error al guardar el índice en fichero "
                                + f.getName());
            }

        }

    }

    private void abrir() {

        FileChooser elector = new FileChooser();
        elector.setTitle("Abrir fichero");
        elector.setInitialDirectory(new File("."));
        elector.getExtensionFilters()
                .addAll(new ExtensionFilter("txt", "*.txt"));
        File f = elector.showOpenDialog(null);
        if (f != null) {
            creador.leerFichero(f);
            areaTexto.appendText(creador.getIndice());
        }
    }
}
