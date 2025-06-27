package ejercicio2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeerRegistroActividades {
    public static void main(String[] args) {
        String ruta = "C:\\projects\\java-projects\\02-manejo-archivos\\src\\ejercicio2\\registro_actividades.txt";

        try {
            List<String> contenido = Files.readAllLines(Paths.get(ruta));
            System.out.println("*** REGISTRO DE ACTIVIDADES ***");
            for (String actividad : contenido){
                System.out.println(actividad);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
