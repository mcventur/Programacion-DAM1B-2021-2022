package dam.prog.listapersonasmaven.controlador;

import dam.prog.listapersonasmaven.modelo.Genero;
import dam.prog.listapersonasmaven.modelo.ListaPersonas;
import dam.prog.listapersonasmaven.modelo.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.util.EventListener;
import java.util.HashSet;
import java.util.Set;

public class PersonasController {
    private ListaPersonas lista;

    @FXML
    private Button btnAdd;

    @FXML
    private CheckBox chkLectura;

    @FXML
    private CheckBox chkBaile;

    @FXML
    private CheckBox chkMonte;

    @FXML
    private CheckBox chkCine;

    @FXML
    private ToggleGroup genero;

    @FXML
    private Label lblEdad;

    @FXML
    private Label lblGenero;

    @FXML
    private Label lblHobbies;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblTitulo;

    @FXML
    private RadioButton rbtHombre;

    @FXML
    private RadioButton rbtMujer;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;


    public PersonasController() {
        lista = new ListaPersonas();
    }

    @FXML
    void initialize(){
        lblTitulo.setText("Lista personas");
    }

    @FXML
    void addPersona(ActionEvent event) {
        //Procesamos el nombre
        TextField txt = txtNombre;
        String nombre = txtNombre.getText();
        if (nombre.isEmpty()) {
            mostrarMensaje("Teclee nombre", Alert.AlertType.WARNING);
        }
        else {
            //Procesamos la edad introducida
            String strEdad = txtEdad.getText();
            int edad =0;
            if(strEdad.isEmpty()){
                mostrarMensaje("Teclee la edad", Alert.AlertType.ERROR);
            }
            else{
                try{
                    edad = Integer.parseInt(strEdad);
                    //Procesamos el valor del género seleccionado para pasarlo a un objeto del enum Genero
                    RadioButton seleccionado = (RadioButton) genero.getSelectedToggle();
                    Genero gen = Genero.valueOf(seleccionado.getText().toUpperCase());
                    //Creamos la persona
                    Persona p = new Persona(nombre, edad, gen);
                    p.addHobbies(obtenerHobbies());
                    lista.addPersona(p);
                    mostrarMensaje("Persona añadida a la lista", Alert.AlertType.INFORMATION);
                }
                catch (NumberFormatException e){
                    mostrarMensaje("La edad debe ser un número entero", Alert.AlertType.ERROR);
                }
            }
        }

    }

    /**
     *
     * @return un set con los hobbies seleccionados en el formulario
     */
    private Set<String> obtenerHobbies() {
        Set<String> retorno = new HashSet<>();
        if(chkLectura.isSelected()) retorno.add(chkLectura.getText());
        if(chkBaile.isSelected()) retorno.add(chkBaile.getText());
        if(chkCine.isSelected()) retorno.add(chkCine.getText());
        if(chkMonte.isSelected()) retorno.add(chkMonte.getText());
        return retorno;
    }

    /**
     * Muestra un cuadro de diálogo con el texto y tipo indicados
     */
    private void mostrarMensaje(String texto, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setTitle("Alerta");
        alert.setContentText(texto);
        alert.showAndWait();
    }



}
