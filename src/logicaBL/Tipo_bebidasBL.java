package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class Tipo_bebidasBL {

    public void Guardar(int idTipoBebidas, String tipo) {
        if (idTipoBebidas <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id tipo de bebida esta vacio");
        } else if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el tipo de almacen esta vacio");
        }
    }

    public void Actualizar(int idTipoBebidas, String tipo) {
        if (idTipoBebidas <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id tipo de bebida esta vacio");
        } else if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el tipo de almacen esta vacio");
        }
    }

    public void Eliminar(int idTipoBebidas) {
        if (idTipoBebidas <= 0) {
            JOptionPane.showMessageDialog(null, "Error al eliminar, tipo de bebidas");
        }
    }
}
