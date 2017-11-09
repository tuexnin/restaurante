package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class PagoBL {

    public void Guardar(String idPago, String idTipoPago, int idMesa) {
        if (idPago.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar,el Idpago esta vacio");
        } else if (idTipoPago.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar,el idTipoPago esta vacio");
        } else if (idMesa <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, la mesa esta vacia");
        } else {

        }
    }

    public void Actualizar(String idPago, String idTipoPago, int idMesa) {
        if (idPago.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el Idpago esta vacio");
        } else if (idTipoPago.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el idTipoPago esta vacio");
        } else if (idMesa <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la mesa esta vacia");
        } else {

        }
    }

    public void Eliminar(String idPago) {
        if (idPago.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el pago");
        }
    }
}
