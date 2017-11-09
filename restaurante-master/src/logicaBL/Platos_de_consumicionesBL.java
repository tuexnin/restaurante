package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class Platos_de_consumicionesBL {

    public void Guardar(int idPlatosdeConsumiciones, String codigoPlato, int idconsumiciones) {
        if (idPlatosdeConsumiciones <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id Platos de Consumiciones esta vacio");
        } else if (codigoPlato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el codigo plato esta vacio");
        } else if (idconsumiciones <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id consumiciones esta vacio");
        } else {

        }
    }

    public void Actualizar(int idPlatosdeConsumiciones, String codigoPlato, int idconsumiciones) {
        if (idPlatosdeConsumiciones <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id Platos de Consumiciones esta vacio");
        } else if (codigoPlato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el codigo plato esta vacio");
        } else if (idconsumiciones <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id consumiciones esta vacio");
        } else {

        }
    }

    public void Eliminar(int idPlatosdeConsumiciones) {
        if (idPlatosdeConsumiciones <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Eliminiar platos de consumiciones");
        }
    }
}
