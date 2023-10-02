import java.io.*;
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            GestionFicheroSecuencial gestionFichero = new GestionFicheroSecuencial("miarchivo.dat");

            // Agregar un registro al final del fichero
            gestionFichero.agregarRegistro("Registro 1");

            // Recuperar un registro por posición
            String registroRecuperado = gestionFichero.recuperarRegistro(0);
            System.out.println("Registro recuperado: " + registroRecuperado);

            // Modificar un registro por posición
            gestionFichero.modificarRegistro(0, "Registro 1 modificado");

            // Recuperar el registro modificado
            registroRecuperado = gestionFichero.recuperarRegistro(0);
            System.out.println("Registro modificado: " + registroRecuperado);

            gestionFichero.cerrar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
