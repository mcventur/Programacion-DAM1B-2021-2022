
package ut9.factorial;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiFactorial extends Application {

    private TextField txtNumero;
    private Label lblResultado;
    private Button btnFactorial;
    private Button btnPrimo;
    private Button btnClear;
    private Button btnSalir;
    private MenuItem itmFactorial;
    private MenuItem itmPrimo;
    private MenuItem itmClear;
    private MenuItem itmSalir;

    private Numero numero; // el modelo

    @Override
    public void start(Stage primaryStage) {

        numero = new Numero();
        BorderPane root = crearGui();

        Scene scene = new Scene(root, 500, 400);
        scene.getStylesheets().add(
                getClass().getResource("application.css")
                        .toExternalForm());
        cogerFoco();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Numero - Factorial y primo");
        primaryStage.show();

    }

    private BorderPane crearGui() {
        BorderPane panel = new BorderPane();
        panel.setTop(crearBarraMenu());
        panel.setCenter(crearPanelPrincipal());
        return panel;
    }

    private MenuBar crearBarraMenu() {
        MenuBar mb = new MenuBar();
        Menu menu = new Menu("Opciones");
        mb.getMenus().add(menu);
        itmFactorial = new MenuItem("Factorial");
        itmFactorial.setOnAction(e->factorial());
        itmPrimo = new MenuItem("Primo");
        itmPrimo.setOnAction(e->primo());
        itmClear = new MenuItem("Clear");
        itmClear.setOnAction(e->clear());
        itmSalir = new MenuItem("Salir");
        itmSalir.setOnAction(e->salir());
        menu.getItems().addAll(itmFactorial,itmPrimo,itmClear,
                new SeparatorMenuItem(),itmSalir);

		return mb;
    }

    private BorderPane crearPanelPrincipal() {
        BorderPane principal = new BorderPane();
        principal.setCenter(crearPanelCentral());
        principal.setRight(crearPanelBotones());
		return principal;
    }

    private BorderPane crearPanelCentral() {
        BorderPane central = new BorderPane();
        txtNumero = new TextField();
        txtNumero.setMaxWidth(Integer.MAX_VALUE);
        central.setTop(txtNumero);
        txtNumero.setOnAction(e->factorial());
        lblResultado = new Label("Aquí se mostrará el resultado");
        //Aplicamos el id resultado para que coja el selector CSS #resultado
        lblResultado.setId("resultado");
        lblResultado.setMaxSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
        central.setCenter(lblResultado);
		return central;
    }

    private VBox crearPanelBotones() {
		VBox botonera = new VBox();
        botonera.setPadding(new Insets(5,10,5,10));
        botonera.setSpacing(10);
        btnFactorial = new Button("_Factorial");
        btnFactorial.setOnAction(e->factorial());
        btnPrimo = new Button("_Primo");
        btnPrimo.setOnAction(e->primo());
        btnClear = new Button("_Clear");
        btnClear.setOnAction(e->clear());
        btnSalir = new Button("_Salir");
        btnSalir.setOnAction(e->salir());
        botonera.getChildren().addAll(btnFactorial,btnPrimo,btnClear,btnSalir);
        for (Node boton : botonera.getChildren()) {
            ((Button) boton).setMaxSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
            ((Button) boton).setMnemonicParsing(true);
            VBox.setVgrow(boton,Priority.ALWAYS);
        }
		return botonera;
    }

    private void salir() {
        //Platform.exit();
		System.exit(-1);
    }

    private void clear() {
		lblResultado.setText("");


		 

    }




    private void primo() {
        if(numeroCorrecto()) {
            lblResultado.setText(String.valueOf("Es primo? " + numero.esPrimo()));
        }
    }

    private void factorial() {
        if(numeroCorrecto()) {
            lblResultado.setText(String.valueOf(numero.factorial()));
        }
    }

    private boolean numeroCorrecto() {
        String texto = txtNumero.getText();
        if(texto.isEmpty()){
            lblResultado.setText("Introduzca un número");
            return false;
        }
        else{
            try {
                int numInt = Integer.parseInt(texto);
                numero.setNumero(numInt);
                return true;
            } catch (NumberFormatException e) {
                lblResultado.setText("Formato de número incorrecto");
                return false;
            } catch (IllegalArgumentException e){
                lblResultado.setText("El número debe ser positivo");
                return false;
            }
        }
    }


    private void cogerFoco() {

        txtNumero.requestFocus();
        txtNumero.selectAll();

    }

    public static void main(String[] args) {

        launch(args);
    }
}
