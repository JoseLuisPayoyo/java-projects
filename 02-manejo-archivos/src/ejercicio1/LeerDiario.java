package ejercicio1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeerDiario {
    public static void main(String[] args) {
        String ruta = "C:\\projects\\java-projects\\02-manejo-archivos\\diario_personal.txt";

        try{
            List<String> contenido = Files.readAllLines(Paths.get(ruta));
            System.out.println("Contenido del archivo: ");
            int contador = 1;
            for (String lineas : contenido){
                System.out.println("Linea " + contador + ": " + lineas);
                contador++;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
