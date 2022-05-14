package ut9.dados.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import ut9.dados.modelo.Dado;

public class GuiDados extends Application {

    private Dado dado1;
    private Dado dado2;
    private Label lblPuntos;
    private Label lblDado1;
    private Label lblDado2;
    private Button btnTirar;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        dado1 = new Dado();
        dado2 = new Dado();
        BorderPane root = crearGui();
        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(
                getClass().getResource("/application.css")
                        .toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle(" Dados ");
        primaryStage.show();

    }

    private BorderPane crearGui() {
        BorderPane panel = new BorderPane();
        panel.setPadding(new Insets(10));
        panel.setTop(crearPanelTop());
        panel.setCenter(crearPanelCenter());
        panel.setBottom(crearPanelBottom());
        return panel;
    }

    private HBox crearPanelTop() {
        HBox panel = new HBox();
        panel.setPadding(new Insets(5));

        lblPuntos = new Label("Puntuación");
        lblPuntos.setAlignment(Pos.CENTER);
        lblPuntos.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        HBox.setHgrow(lblPuntos, Priority.ALWAYS);
        panel.getStyleClass().add("hbox");

        panel.getChildren().add(lblPuntos);

        return panel;
    }

    private GridPane crearPanelCenter() {
        GridPane panel = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 =  new ColumnConstraints();
        col2.setPercentWidth(50);
        panel.getColumnConstraints().addAll(col1,col2);

        lblDado1 = new Label();
        lblDado1.setAlignment(Pos.CENTER);
        lblDado1.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        GridPane.setHgrow(lblDado1, Priority.ALWAYS);
        GridPane.setVgrow(lblDado1,Priority.ALWAYS);

        lblDado2 = new Label();
        lblDado2.setAlignment(Pos.CENTER);
        lblDado2.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        GridPane.setHgrow(lblDado2, Priority.ALWAYS);
        GridPane.setHgrow(lblDado2, Priority.ALWAYS);

        actualizarEtiquetas();

        panel.add(lblDado1, 0, 0);
        panel.add(lblDado2, 1, 0);

        //panel.setGridLinesVisible(true); //Para ver las celdas. Útil para depurar
        return panel;
    }


    private void actualizarEtiquetas() {
        int puntosDado1 = dado1.getCara();
        Image imgDado1 = new Image(getClass().getResourceAsStream("/images/" + puntosDado1 + ".gif"));
        lblDado1.setGraphic(new ImageView(imgDado1));

        int puntosDado2 = dado2.getCara();
        Image imgDado2 = new Image(getClass().getResourceAsStream("/images/" + puntosDado2 + ".gif"));
        lblDado2.setGraphic(new ImageView(imgDado2));

        String strPuntos = String.valueOf(puntosDado1 + puntosDado2);
        lblPuntos.setText(strPuntos);
    }

    private HBox crearPanelBottom() {
        HBox panel = new HBox();
        panel.setPadding(new Insets(5));

        btnTirar = new Button("Tirar dados");
        btnTirar.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

        btnTirar.setOnAction(e -> tirarDados());

        HBox.setHgrow(btnTirar, Priority.ALWAYS);
        panel.getStyleClass().add("hbox");
        panel.getChildren().add(btnTirar);
        return panel;
    }

    private void tirarDados() {
        dado1.tirarDado();
        dado2.tirarDado();
        actualizarEtiquetas();
    }
}
