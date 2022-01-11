
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GuiAmigoInvisible extends Application {
    private TextField txtNombre;
    private Button btnAdd;
    private Button btnAsignar;
    private Button btnMostrarTodos;
    private Button btnAyuda;
    private ListView<String> lstParticipantes;
    private TextArea area;

    private JuegoAmigoInvisible juego;

    @Override
    public void start(Stage stage) {
        juego = new JuegoAmigoInvisible();

        VBox root = crearGui();

        Scene scene = new Scene(root, 900, 640);
        stage.setScene(scene);
        stage.setTitle("- El amigo invisible -");
        scene.getStylesheets().add(getClass().getResource("/application.css")
            .toExternalForm());
        stage.show();
        stage.setOnCloseRequest(ev->salir());
        cogerFoco();
    }

    private VBox crearGui() {
        VBox panel = new VBox();
        panel.setSpacing(5);
        panel.setPadding(new Insets(5));
        HBox pnlImagen = crearPanelImagen();
        HBox pnlEntrada = crearPanelEntrada();
        GridPane pnlInformacion = crearPanelInformacion();
        VBox.setVgrow(pnlInformacion, Priority.ALWAYS);
        HBox pnlOpciones = crearPanelOpciones();
        panel.getChildren().addAll(pnlImagen, pnlEntrada, pnlInformacion,
            pnlOpciones);
        return panel;
    }

    private HBox crearPanelOpciones() {
        HBox panel = new HBox();
        panel.setSpacing(5);
        panel.setPadding(new Insets(5));
        panel.setMinHeight(50);
        panel.setAlignment(Pos.CENTER);

        btnAsignar = new Button("Asignar amigo");
        btnAsignar.setMinWidth(120);
        btnAsignar.setOnAction(e -> asignar());

        btnMostrarTodos = new Button("Mostrar resultados");
        btnMostrarTodos.setMinWidth(120);
        btnMostrarTodos.setOnAction(e -> mostrarTodos());

        panel.getChildren().addAll(btnAsignar, btnMostrarTodos);

        return panel;
    }

    private void ayuda() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ayuda Amigo invisible");
        alert.setHeaderText(null);
        alert.setContentText("A�ada los participantes \n\n" +
            "No se permiten nombres de participantes repetidos\n\n"
            + "Asigne los amigos y muestre resultados\n\n" +
            "Para borrar un participante haga\n"
            + "doble click en la lista de selecci�n\n\n" +
            "Si borra un participante deber� volver a asignar amigos");

        alert.getDialogPane().getStylesheets()
        .add(getClass().getResource("/application.css")
            .toExternalForm());
        alert.showAndWait();
        cogerFoco();
    }

    private void mostrarTodos() {
        if (juego.totalParticipantes() == 0) {
            area.setText("A�ada primero los participantes en el juego");
        } else {
            area.setText(juego.toString());
        }
        cogerFoco();
    }

    private GridPane crearPanelInformacion() {
        GridPane panel = new GridPane();
        panel.setPadding(new Insets(5));
        panel.setHgap(5);
        panel.setVgap(5);
        panel.setAlignment(Pos.CENTER);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(40);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(60);
        panel.getColumnConstraints().addAll(col1, col2);

        lstParticipantes = new ListView<>();
        lstParticipantes.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent ev) {
                    if (ev.getClickCount() == 2) {
                        borrarParticipante();
                    } else if (ev.getClickCount() == 1) {
                        mostrar();
                    }

                }
            });

        area = new TextArea();
        panel.add(lstParticipantes, 0, 0);
        panel.add(area, 1, 0);

        GridPane.setVgrow(lstParticipantes, Priority.ALWAYS);
        GridPane.setVgrow(area, Priority.ALWAYS);
        GridPane.setHgrow(lstParticipantes, Priority.ALWAYS);
        GridPane.setHgrow(area, Priority.ALWAYS);
        return panel;
    }

    /**
     * 
     */
    private void borrarParticipante() {

        String nombreSeleccionado = lstParticipantes.getSelectionModel()
            .getSelectedItem();
        if (nombreSeleccionado != null) {
            boolean si = confirmarBorrado(nombreSeleccionado);
            if (si) {
                juego.borrarParticipante(nombreSeleccionado);
                area.setText("Borrado el participante " + nombreSeleccionado +
                    "\nVuelva a realizar la  asignaci�n de amigos");
                actualizarListView();
            }
        }
        cogerFoco();
    }

    public boolean confirmarBorrado(String nombre) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar borrado ");
        alert.setHeaderText(null);
        alert.setContentText("Desea borrar el participante " + nombre + " ?");
        Optional<ButtonType> respuesta = alert.showAndWait();
        return respuesta.get() == ButtonType.OK;
    }

    private void mostrar() {

        try {
            String nombre = lstParticipantes.getSelectionModel()
                .getSelectedItem();
            Participante p = juego.datosDe(nombre);
            Participante regalaA = p.getEmisor();
            Participante recibeDe = p.getReceptor();
            String nombreRegalaA = "NADIE";
            if (regalaA != null) {
                nombreRegalaA = regalaA.getNombre();
            }
            String nombreRecibeDe = "NADIE";
            if (recibeDe != null) {
                nombreRecibeDe = recibeDe.getNombre();
            }
            area.setText(nombre + " regala a " + nombreRegalaA);
            area.appendText(" y recibe de " + nombreRecibeDe);
        } catch (RuntimeException e) {

        }
        cogerFoco();

    }

    private HBox crearPanelEntrada() {
        HBox panel = new HBox();
        panel.setSpacing(5);
        panel.setPadding(new Insets(5));
        panel.setMinHeight(50);

        Label lblNombre = new Label("Participante");
        txtNombre = new TextField();
        txtNombre.setMaxWidth(Integer.MAX_VALUE);
        txtNombre.setOnAction(e -> add());
        HBox.setHgrow(txtNombre, Priority.ALWAYS);
        btnAdd = new Button("Add");
        btnAdd.setMinWidth(120);
        btnAdd.setOnAction(e -> add());
        panel.getChildren().addAll(lblNombre, txtNombre, btnAdd);
        return panel;
    }

    private void asignar() {

        if (juego.totalParticipantes() == 0) {
            area.setText("A�ada primero los participantes en el juego");
        } else {
            juego.asignarAmigos();
            area.setText("Se ha hecho el reparto del amigo invisible");
        }
        cogerFoco();

    }

    private void add() {
        area.clear();
        String nombre = txtNombre.getText();
        if (nombre.isEmpty()) {
            area.setText("Teclee nombre");
        } else if (juego.estaParticipante(nombre)) {
            area.setText("Ese participante ya existe, teclee otro nombre diferente");

        } else {
            Participante p = new Participante(nombre);
            juego.add(p);
            actualizarListView();

        }
        cogerFoco();

    }

    private void actualizarListView() {
        lstParticipantes.getItems().clear();
        if (juego.totalParticipantes() == 0) {
            area.setText("Añada participantes en el juego");
        }
        else {
            for (Participante p : juego.getParticipantes()) {
                lstParticipantes.getItems().add(p.getNombre());
            }
        }

    }

    private HBox crearPanelImagen() {
        HBox panel = new HBox();
        panel.setMinHeight(180);
        panel.setSpacing(5);
        panel.setPadding(new Insets(0));

        panel.setId("pnlImagen");

        StackPane pnl = new StackPane();
        pnl.setAlignment(Pos.CENTER);

        Label lblTexto = new Label("El amigo invisible");
        lblTexto.setTextAlignment(TextAlignment.CENTER);
        lblTexto.setId("lbltexto");
        StackPane.setAlignment(lblTexto, Pos.CENTER);
        pnl.getChildren().addAll(lblTexto);

        btnAyuda = new Button("?");
        btnAyuda.setId("buttonHelp");
        btnAyuda.setOnAction(e -> ayuda());
        StackPane.setAlignment(btnAyuda, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(btnAyuda, new Insets(10));
        pnl.getChildren().addAll(btnAyuda);

        panel.getChildren().add(pnl);
        HBox.setHgrow(pnl, Priority.ALWAYS);

        return panel;
    }

    private void cogerFoco() {
        txtNombre.requestFocus();
        txtNombre.selectAll();
    }

    private void salir() {
        //Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
