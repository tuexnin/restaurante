package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class ConsumicionesBL {

    public void Guardar(int idconsumiciones, String descripcion) {
        if (idconsumiciones <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el idconsumiciones esta vacio");
        } else if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, la descripcion esta vacia");
        } else {

        }
    }

    public void Actualizar(int idconsumiciones, String descripcion) {
        if (idconsumiciones <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el idconsumiciones esta vacio");
        } else if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la descripcion esta vacia");
        } else {

        }
    }

    public void Eliminar(int idconsumiciones) {
        if (idconsumiciones <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar,consumiciones");
        }
    }
}
