package logicaBL;

import entidades.Mesa;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.db_Mesa;

/**
 *
 * @author Edwin CR
 */
public class MesaBL {

    private Mesa mesa;
    private db_Mesa db_mesa;

    public void GuardarMesa(String num_mesa, int capacidad, String estadomesa, String idTipomesa, String idTipoRestaurante) {
        if (num_mesa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el numero de mesa no es correcto");
        } else if (capacidad <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, la capacidad no es correcto");
        } else if (estadomesa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el estado de la mesa no es correcto");
        } else if (idTipomesa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id tipo mesa no es correcto");
        } else if (idTipoRestaurante.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id tipo restaurante no es correcto");
        } else {
            mesa = new Mesa(num_mesa, capacidad, estadomesa, idTipomesa, idTipoRestaurante);
            db_mesa = new db_Mesa();
            db_mesa.GuardarMesa(mesa);
            JOptionPane.showMessageDialog(null, "SE REGISTRO LA MESA :" + num_mesa);
        }
    }

    public void ActualizarMesa(int idMesa, String num_mesa, int capacidad, String estadomesa, String idTipomesa, String idTipoRestaurante) {
        if (idMesa <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id mesa no es correcto");
        } else if (num_mesa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el numero de mesa no es correcto");
        } else if (capacidad <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la capacidad no es correcto");
        } else if (estadomesa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el estado de la mesa no es correcto");
        } else if (idTipomesa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id tipo mesa no es correcto");
        } else if (idTipoRestaurante.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id tipo restaurante no es correcto");
        } else {
            mesa = new Mesa(idMesa, num_mesa, capacidad, estadomesa, idTipomesa, idTipoRestaurante);
            db_mesa = new db_Mesa();
            db_mesa.Actualizar(mesa);
            JOptionPane.showMessageDialog(null, "SE ACTULIZO LA MESA ");
        }
    }

    public void EliminarMesa(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR LA MESA");
        } else {
            mesa = new Mesa(id);
            db_mesa = new db_Mesa();
            db_mesa.Eliminar(mesa);
            JOptionPane.showMessageDialog(null, "SE ELIMINO LA MESA ");
        }
    }

    public void ListarTabla(JTable tabla, String dato) {
        db_mesa = new db_Mesa();
        db_mesa.Listar(tabla, dato);
    }

}
