package logicaBL;

import entidades.Cliente;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.db_Cliente;

/**
 *
 * @author Edwin CR
 */
public class ClienteBL {

    Cliente cliente;
    db_Cliente db_cliente;

    public void guardarCliente(String id, String nombre, String dni) {
        if (id.isEmpty() || nombre.isEmpty() || dni.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR CLIENTE");
        } else {
            cliente = new Cliente(id, nombre, dni);
            db_cliente = new db_Cliente();
            db_cliente.guardar(cliente);
            JOptionPane.showMessageDialog(null, "EL CLIENTE: " + nombre + " FUE REGISTRADO");
        }
    }

    public void EditarCliente(String id, String nombre, String dni) {
        if (id.isEmpty() || nombre.isEmpty() || dni.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR AL CLIENTE");
        } else {
            cliente = new Cliente(id, nombre, dni);
            db_cliente = new db_Cliente();
            db_cliente.Editar(cliente);
            JOptionPane.showMessageDialog(null, "EL CLIENTE FUE ACTUALIZADO");
        }
    }

    public void EliminarCliente(String id) {
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR AL CLIENTE");
        } else {
            cliente=new Cliente(id);
            db_cliente = new db_Cliente();
            db_cliente.Eliminar(cliente);
            JOptionPane.showMessageDialog(null, "SE ELIMINO AL CLIENTE");
        }
    }

    public void ListarCliente(JTable tabla, String dato) {
        db_cliente = new db_Cliente();
        db_cliente.ListarCliente(tabla, dato);
    }
}
