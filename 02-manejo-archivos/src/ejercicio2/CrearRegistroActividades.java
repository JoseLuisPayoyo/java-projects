package ejercicio2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class CrearRegistroActividades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ruta = "C:\\projects\\java-projects\\02-manejo-archivos\\src\\ejercicio2\\registro_actividades";
        File actividades = new File(ruta);

        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Actividad: ");
            String actividad = scanner.nextLine();

            String fecha = LocalDate.now().toString();

            //creamos archivo
            PrintWriter salida = new PrintWriter(new FileWriter(actividades, true));
            salida.println("[" + fecha + "] " + nombre + ": " + actividad);
            salida.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            scanner.close();
        }


    }
}
