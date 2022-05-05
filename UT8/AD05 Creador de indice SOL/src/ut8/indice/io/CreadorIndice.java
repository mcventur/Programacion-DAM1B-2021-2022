package ut8.indice.io;

import ut8.indice.modelo.IndiceDocumento;

import java.io.*;

public class CreadorIndice {

    private IndiceDocumento indice;

    /**
     * Constructor de la clase CreadorIndice
     */
    public CreadorIndice() {

        indice = new IndiceDocumento();

    }

    /**
     * lee del fichero de texto una a una las líneas y va creando el índice del
     * documento
     *
     * Se capturan las excepciones
     *
     * @param f el fichero del que se va a leer
     */
    public void leerFichero(File f) {
       try(BufferedReader entrada = new BufferedReader(new FileReader(f))){
            String linea = entrada.readLine();
            int numLinea = 1;
            while(linea!=null){
                indice.addTodasPalabras(linea,numLinea);
                linea = entrada.readLine();
                numLinea++;
            }
       } catch (FileNotFoundException e) {
           System.out.println(e.getMessage());
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
    }

    /**
     * Guarda en un fichero de texto el índice del documento
     * Se propagan las excepciones
     */
    public void guardarIndiceDocumento(File f) throws IOException {
        try(PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(f)))){
            salida.println(getIndice());
        }
	}

    /**
     * Devuelve la representación textual del índice
     */
    public String getIndice() {

        return indice.toString();

    }

}
