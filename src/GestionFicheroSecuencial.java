import java.io.*;

public class GestionFicheroSecuencial {
    private RandomAccessFile fichero;
    private static final int LONGITUD_REGISTRO = 100; // Longitud total del registro

    public GestionFicheroSecuencial(String nombreFichero) throws IOException {
        fichero = new RandomAccessFile(nombreFichero, "rw");
    }

    public void cerrar() throws IOException {
        if (fichero != null) {
            fichero.close();
        }
    }

    public void agregarRegistro(String registro) throws IOException {
        fichero.seek(fichero.length()); // Mover el puntero al final del archivo
        escribirRegistro(registro);
    }

    public String recuperarRegistro(long posicion) throws IOException {
        if (posicion >= 0 && posicion < fichero.length()) {
            fichero.seek(posicion); // Mover el puntero a la posición especificada
            return leerRegistro();
        } else {
            return null; // Registro no encontrado
        }
    }

    public void modificarRegistro(long posicion, String nuevoRegistro) throws IOException {
        if (posicion >= 0 && posicion < fichero.length()) {
            fichero.seek(posicion); // Mover el puntero a la posición especificada
            escribirRegistro(nuevoRegistro);
        }
    }

    private void escribirRegistro(String registro) throws IOException {
        StringBuilder registroCompleto = new StringBuilder(registro);
        registroCompleto.setLength(LONGITUD_REGISTRO); // Rellenar el registro con espacios en blanco si es necesario
        fichero.writeChars(registroCompleto.toString());
    }

    private String leerRegistro() throws IOException {
        char[] registro = new char[LONGITUD_REGISTRO];
        for (int i = 0; i < LONGITUD_REGISTRO; i++) {
            registro[i] = fichero.readChar();
        }
        return new String(registro).trim(); // Eliminar espacios en blanco al final del registro
    }
}