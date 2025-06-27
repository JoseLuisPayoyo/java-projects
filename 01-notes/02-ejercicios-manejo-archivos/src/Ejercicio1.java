import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ejercicio1 {
    public static void main(String[] args) {
        String ruta = "C:\\projects\\java-projects\\02-ejercicios-manejo-archivos\\src\\registro_visitas.txt";
        File registro = new File(ruta);

        try {
            LocalDateTime fecha = LocalDateTime.now();
            String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            //escribimos modo append
            PrintWriter salida = new PrintWriter(new FileWriter(registro, true));
            salida.println("[" + fechaFormateada + "] El programa fue ejecutado");
            salida.close();

            System.out.println("Ejecutado con exito");
        } catch (Exception e) {
            System.out.println("No se ha posido escribir el archivo: " + e.getMessage());
        }
    }
}