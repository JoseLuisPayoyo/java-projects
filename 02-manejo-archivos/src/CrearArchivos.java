import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearArchivos {
    public static void main(String[] args) throws IOException {

        var nombreArchivo = "mi_archivo.txt";
        var archivo = new File(nombreArchivo);

        try{
            if (archivo.exists()){
                System.out.println("El archivo ya existe");
            }else{
                //creamos el archiovo
                var salida = new PrintWriter(new FileWriter(archivo));
                //se guarda el archivo
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch (IOException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}