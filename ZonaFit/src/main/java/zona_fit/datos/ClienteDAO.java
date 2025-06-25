package zona_fit.datos;

import zona_fit.conexion.Conexion;
import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO implements IClienteDAO{
    @Override
    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConnection();
        var sql = "SELECT * FROM cliente ORDER BY id";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){ //next(entra cuando hay registros)
                var cliente = new Cliente();
                //obtenemos los valores
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConnection();
        var sql = "SELECT * FROM cliente WHERE id = ?";

        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());//1 indica que el id va en el primer ? que hay en el statment
            rs = ps.executeQuery();
            if (rs.next()){ //pregunta si tenemos un regitro
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar cliente por id: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        var sql = "INSERT INTO cliente(nombre, apellido, membresia) "
                + "VALUES(?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        var sql = "UPDATE cliente SET nombre=?, apellido=?, membresia=? " +
                "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.setInt(4, cliente.getId());

            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        var sql = "DELETE FROM cliente WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // listar clientes
        System.out.println("*** Listar Clientes ***");
        IClienteDAO clienteDao = new ClienteDAO();
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);

        //buscar por id
//        var cliente1 = new Cliente(2);
//        var encontrado = clienteDao.buscarClientePorId(cliente1);
//        if (encontrado) {
//            System.out.println("\nCliente encontrado:" + cliente1);
//        }else{
//            System.out.println("\nNo se encontro el cliente con el id: " + cliente1.getId());
//        }

        //agregar cliente
//        var nuevoCliente = new Cliente("Daniel", "Monete", 5);
//        var agregado = clienteDao.agregarCliente(nuevoCliente);
//        if (agregado){
//            System.out.println("Cliente agregado\n");
//        }else{
//            System.out.println("No se agrego");
//        }

        //modificar cliente
//        var modificarCliente = new Cliente(3,"Pepe", "Tejeda", 4);
//        var modificado = clienteDao.modificarCliente(modificarCliente);
//        if (modificado){
//            System.out.println("Cliente modificado: " + modificarCliente);
//        } else{
//            System.out.println("No se modifico el cliente: " + modificarCliente);
//        }

        //eliminar cliente
//        var clienteEliminar = new Cliente(3);
//        var eliminado = clienteDao.eliminarCliente(clienteEliminar);
//        if (eliminado){
//            System.out.println("Cliente eliminado: " + clienteEliminar);
//        }else{
//            System.out.println("Cliente no eliminado: " + clienteEliminar);
//        }
    }
}
