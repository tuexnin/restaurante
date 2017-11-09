package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class TipopagoBL {

    public void guardar(String idTipoPago, String descripcion) {
        if (idTipoPago.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el tipo pago esta vacio");
        } else if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, la descripcion esta vacia");
        } else {

        }
    }

    public void Actualizar(String idTipoPago, String descripcion) {
        if (idTipoPago.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el tipo pago esta vacio");
        } else if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualiar, la descripcion esta vacia");
        } else {

        }
    }

    public void Eliminar(String idTipoPago) {
        if (idTipoPago.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al elimina el tipo de pago");
        }
    }
}
