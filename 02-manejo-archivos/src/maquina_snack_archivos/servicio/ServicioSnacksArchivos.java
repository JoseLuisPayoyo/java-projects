package maquina_snack_archivos.servicio;

import maquina_snack_archivos.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
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
                this.snacks = obtenerSnacks();
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

    private ArrayList<Snack> obtenerSnacks(){
        var snacks = new ArrayList<Snack>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for (String linea : lineas){
                String[] lineaSnack = linea.split(",");//separar cada vez que haya comas
                var idSnack = lineaSnack[0]; //no se usa
                var nombre = lineaSnack[1];
                var precio = Double.parseDouble(lineaSnack[2]);

                var snack = new Snack(nombre, precio);
                snacks.add(snack); //agregamos el snack a la lista
            }
        } catch (Exception e) {
            System.out.println("Erro al leer el archivo de snacks: " + e.getMessage());
        }
        return snacks;
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
            salida.println(snack.escribirSnack());
            salida.close();

        } catch (Exception e) {
            System.out.println("Error al agregar snack: " + e.getMessage());
        }
    }

    @Override
    public void mostrarSnack() {
        System.out.println(" --- Snacks en el inventario ---");
        var inventarioSnack = "";
        for (var snack : this.snacks){
            inventarioSnack += snack.toString() + "\n";
        }
        System.out.println(inventarioSnack);
    }

    @Override
    public List<Snack> getSnacks() {
        return List.of();
    }
}
