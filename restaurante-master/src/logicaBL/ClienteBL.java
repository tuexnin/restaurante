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

    public void guardarCliente(String idcliente, String nombre, String dni) {
        if (idcliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id cliente no es correcto");
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el nombre no es correcto");
        } else if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el DNI no es correcto");
        } else {
            cliente = new Cliente(idcliente, nombre, dni);
            db_cliente = new db_Cliente();
            db_cliente.guardar(cliente);
            JOptionPane.showMessageDialog(null, "EL CLIENTE: " + nombre + " FUE REGISTRADO");
        }
    }

    public void EditarCliente(String idcliente, String nombre, String dni) {
        if (idcliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id cliente no es correcto");
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el nombre no es correcto");
        } else if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el DNI no es correcto");
        } else {
            cliente = new Cliente(idcliente, nombre, dni);
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
