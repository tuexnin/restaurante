package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class Tipo_almacenBL {

    public void Guardar(int idTipoAlmacen, String tipo) {
        if (idTipoAlmacen <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id tipo de almacen esta vacio");
        } else if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el tipo de almacen esta vacio");
        } else {

        }
    }

    public void Actualizar(int idTipoAlmacen, String tipo) {
        if (idTipoAlmacen <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id tipo de almacen esta vacio");
        } else if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el tipo de almacen esta vacio");
        } else {

        }
    }

    public void Eliminar(int idTipoAlmacen) {
        if (idTipoAlmacen <= 0) {
            JOptionPane.showMessageDialog(null, "Error al eliminar, el tipo de almacen");
        }
    }
}
