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
        } catch (Exception e) {
            System.out.println("Error al recuperar cliente por id: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        return false;
    }

    public static void main(String[] args) {
        // listar clientes
        System.out.println("*** Listar Clientes ***");
        IClienteDAO clienteDao = new ClienteDAO();
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);
    }
}
