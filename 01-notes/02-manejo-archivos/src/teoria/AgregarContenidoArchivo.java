package teoria;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AgregarContenidoArchivo {
    public static void main(String[] args) {
        boolean anexar = false; //para que no se pierda la info que ya hay
        var nombreArchivo = "mi_archivo.txt";
        var archivo = new File(nombreArchivo);

        try{
            //revisar si existe el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            var nuevoContenido = "Nuevo\ncontenido";
            salida.println(nuevoContenido);

            //guardar info en el archivo
            salida.close();
            System.out.println("Se agrego contenido al archivo");
        } catch (Exception e) {
            System.out.println("Error al imprimir el archivo: " + e.getMessage());
        }
    }
}
