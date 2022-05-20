package ut9.calculadora.controlador;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import ut9.calculadora.modelo.Calculadora;

public class CalculadoraController {


    private Calculadora calculadora; // el modelo


    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtNumero1;

    @FXML
    private TextField txtNumero2;

    @FXML
    private RadioButton rbtSuma;

    @FXML
    private RadioButton rbtResta;

    @FXML
    private RadioButton rbtProducto;

    @FXML
    private RadioButton rbtDivisionEntera;

    @FXML
    public void initialize() {
        this.calculadora = new Calculadora(); // crear el modelo

    }

    @FXML
    private void calcular(Event evento) {
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

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso al usuario");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait(); // mostrar y esperar
    }


    private void cogerFoco(TextField target) {

        target.requestFocus();
        target.selectAll();

    }


}
