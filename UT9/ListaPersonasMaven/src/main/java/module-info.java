module dam.prog.listapersonasmaven {
    requires javafx.controls;
    requires javafx.fxml;


    opens dam.prog.listapersonasmaven to javafx.fxml;
    //exports dam.prog.listapersonasmaven;
    exports dam.prog.listapersonasmaven.demo;
    opens dam.prog.listapersonasmaven.demo to javafx.fxml;
    exports dam.prog.listapersonasmaven.controlador;
    opens dam.prog.listapersonasmaven.controlador to javafx.fxml;
}