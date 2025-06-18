package ejercicio1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class CrearDiarioPersonal {
    public static void main(String[] args) {
        String ruta = "C:\\projects\\java-projects\\02-manejo-archivos\\diario_personal.txt";
        File diario = new File(ruta);
        Scanner scanner = new Scanner(System.in);

        try {
            // Pedimos datos al usuario
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("¿Cómo te sientes hoy? ");
            String estadoAnimo = scanner.nextLine();

            String fecha = LocalDate.now().toString();

            // Siempre escribimos (modo append)
            PrintWriter salida = new PrintWriter(new FileWriter(diario, true));
            salida.println("[" + fecha + "] " + nombre + " se siente: " + estadoAnimo);
            salida.close();

            System.out.println("Entrada añadida correctamente al diario.");

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
