package zona_fit.dominio;

import java.util.Objects;

public class Cliente {

    private int id;
    private String nombre, apellido;
    private int membresia;

    //constructor vacio
    public Cliente() {}

    //constructor para el id (eliminar)
    public Cliente(int id){
        this.id = id;
    }

    //insertar clientes
    public Cliente(String nombre, String apellido, int membresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.membresia = membresia;
    }

    //seleccion de objetos
    public Cliente(int id, String nombre, String apellido, int membresia) {
        this(nombre, apellido, membresia);
        this.id = id;
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMembresia() {
        return membresia;
    }

    public void setMembresia(int membresia) {
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return String.format("Cliente [%d]: %s %s | Membresía #%d",
                id, nombre, apellido, membresia);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && membresia == cliente.membresia && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, membresia);
    }
}
