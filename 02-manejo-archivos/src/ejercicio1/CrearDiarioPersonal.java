package ejercicio1;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CrearDiarioPersonal {
    public static void main(String[] args) {

        //ruta de la carpeta
        String ruta = "C:\\projects\\java-projects\\02-manejo-archivos\\diario_personal.txt";
        File diario = new File(ruta);

        try{
            if (diario.exists()){
                System.out.println("El archivo ya existe");
            }else{
                //creamos el archivo
                PrintWriter salida = new PrintWriter(new FileWriter(diario));
                salida.close();
            }
        } catch (Exception e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}
