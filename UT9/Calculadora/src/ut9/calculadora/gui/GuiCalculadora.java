
package ut9.calculadora.gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import ut9.calculadora.modelo.Calculadora;

public class GuiCalculadora extends Application {

    private Calculadora calculadora; // el modelo
    private TextField txtNumero1;
    private TextField txtNumero2;
    private RadioButton rbtSuma;
    private RadioButton rbtResta;
    private RadioButton rbtProducto;
    private RadioButton rbtDivision;
    private Button btnCalcular;
    private Label lblResultado;

    @Override
    public void start(Stage stage) {

        this.calculadora = new Calculadora();
        BorderPane root = crearGui();

        Scene scene = new Scene(root, 600, 300);
        stage.setScene(scene);
        stage.setTitle("- Calculadora sencilla -");
        scene.getStylesheets().add(
                getClass().getResource("/application.css")
                        .toExternalForm());
        stage.show();
    }

    private BorderPane crearGui() {

        BorderPane panel = new BorderPane();
        panel.setPadding(new Insets(0));
        //Etiquetas
        Label lblTitulo = new Label("Calculadora");
        lblTitulo.setId("titulo");
        lblTitulo.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        lblResultado = new Label("Resultado");
        lblResultado.setId("resultado");
        lblResultado.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

        //Colocamos los elementos en ese contenedor raíz
        panel.setTop(lblTitulo);
        panel.setBottom(lblResultado);
        panel.setCenter(crearGrid());
        return panel;
    }

    private GridPane crearGrid() {

        GridPane panel = new GridPane();
        //panel.setGridLinesVisible(true);
        panel.setPadding(new Insets(10, 5, 10, 5));
        panel.setHgap(8);
        panel.setVgap(8);

        //Restricciones de columnas
        ColumnConstraints c1 = new ColumnConstraints();
        c1.setPercentWidth(20);
        c1.setHalignment(HPos.RIGHT);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setPercentWidth(60);
        ColumnConstraints c3 = new ColumnConstraints();
        c3.setPercentWidth(20);
        panel.getColumnConstraints().addAll(c1, c2, c3);

        //Restricciones de filas
        RowConstraints r1 = new RowConstraints();
        r1.setMinHeight(30);
        r1.setVgrow(Priority.ALWAYS);
        RowConstraints r2 = new RowConstraints();
        r2.setMinHeight(30);
        r2.setVgrow(Priority.ALWAYS);
        RowConstraints r3 = new RowConstraints();
        r3.setMinHeight(30);
        r3.setVgrow(Priority.ALWAYS);
        panel.getRowConstraints().addAll(r1, r2, r3);
        //Elementos
        Label l1 = new Label("Número 1");
        l1.setAlignment(Pos.CENTER_RIGHT);
        Label l2 = new Label("Número 2");
        l2.setAlignment(Pos.CENTER_RIGHT);
        txtNumero1 = new TextField();
        txtNumero2 = new TextField();
        panel.add(l1, 0, 0);
        panel.add(txtNumero1, 1, 0);
        panel.add(l2, 0, 1);
        panel.add(txtNumero2, 1, 1);
        btnCalcular = new Button("Calcular");
        btnCalcular.setDefaultButton(true);
        btnCalcular.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        btnCalcular.setPrefHeight(Integer.MAX_VALUE);
        btnCalcular.setOnAction(e->calcular());
        panel.add(btnCalcular, 2, 0, 1, 3);
        panel.add(crearPanelBotonesOperaciones(), 1, 2);
        return panel;
    }

    private HBox crearPanelBotonesOperaciones() {

        HBox panel = new HBox();
        panel.setPadding(new Insets(10));
        panel.setSpacing(10);
        panel.setAlignment(Pos.CENTER);
        rbtResta = new RadioButton("Resta");
        rbtSuma = new RadioButton("Suma");
        rbtSuma.setSelected(true);
        rbtProducto = new RadioButton("Producto");
        rbtDivision = new RadioButton("División entera");
        ToggleGroup tg = new ToggleGroup();
        rbtDivision.setToggleGroup(tg);
        rbtProducto.setToggleGroup(tg);
        rbtResta.setToggleGroup(tg);
        rbtSuma.setToggleGroup(tg);
        panel.getChildren().addAll(rbtSuma, rbtResta,
                rbtProducto, rbtDivision);


        return panel;
    }

    private void calcular() {
        if(txtNumero1.getText().isBlank() || txtNumero2.getText().isBlank()){
            mostrarMensaje("Debe teclear los dos valores");
        }
        else{
            try {
                int num1 = Integer.parseInt(txtNumero1.getText());
                try {
                    int num2 = Integer.parseInt(txtNumero2.getText());

                    if(rbtSuma.isSelected()){
                        lblResultado.setText(String.valueOf(calculadora.sumar(num1,num2)));
                    }
                    else if(rbtResta.isSelected()){
                        lblResultado.setText(String.valueOf(calculadora.restar(num1,num2)));
                    } else if (rbtProducto.isSelected()) {
                        lblResultado.setText(String.valueOf(calculadora.multiplicar(num1,num2)));
                    }
                    else{
                        lblResultado.setText(String.valueOf(calculadora.dividir(num1,num2)));
                    }
                } catch (NumberFormatException e) {
                    mostrarMensaje("Error en el formato del número 2");
                    cogerFoco(txtNumero2);
                }
            } catch (NumberFormatException e) {
                mostrarMensaje("Error en el formato del número 1");
                cogerFoco(txtNumero1);
            } catch (ArithmeticException e){
                mostrarMensaje("División entre cero");
                cogerFoco(txtNumero2);
            }
        }


    }

    private void mostrarMensaje(String mensaje) {

        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Aviso al usuario");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait(); // mostrar y esperar
    }

    private void cogerFoco(TextField target) {

        target.requestFocus();
        target.selectAll();

    }

    public static void main(String[] args) {

        launch(args);
    }
}
