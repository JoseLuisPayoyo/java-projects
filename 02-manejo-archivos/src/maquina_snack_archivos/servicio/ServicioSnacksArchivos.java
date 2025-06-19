package maquina_snack_archivos.servicio;

import maquina_snack_archivos.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksArchivos  implements IServicioSnacks{
    
    private final String NOMBRE_ARCHIVO = "C:\\projects\\java-projects\\02-manejo-archivos\\src\\maquina_snack_archivos\\snacks.txt";

    private List<Snack> ArrayList;
    //Crear lista de snacks
    private ArrayList<Snack> snacks = new ArrayList<>();

    //constructor clase
    public ServicioSnacksArchivos(){
        //creamos archivo si no existe
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;

        try{
            existe = archivo.exists();

            if (existe){
                //this.snacks = obtenerSnacks();
            }else{ //creamos el archiov
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        } catch (Exception e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
        //si no existe, cargamos algunos snacks iniciales
        if (!existe){
            carrgarSnacksIniciales();
        }
    }

    private void carrgarSnacksIniciales(){
        this.agregarSnack(new Snack("Papas", 70));
        this.agregarSnack(new Snack("Refresco", 50));
        this.agregarSnack(new Snack("Sandwich", 120));
    }

    @Override
    public void agregarSnack(Snack snack) {
        //Agregamos el nuevo snack,
        //1. a la lista n memoria
        this.snacks.add(snack);

        //2. guardamos el nuevo snack en el archivo
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack){
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(snack);
            salida.close();

        } catch (Exception e) {
            System.out.println("Error al agregar snack: " + e.getMessage());
        }
    }

    @Override
    public void mostrarSnack() {

    }

    @Override
    public List<Snack> getSnacks() {
        return List.of();
    }
}
