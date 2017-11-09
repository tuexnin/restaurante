package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class AlmacenBL {

    public void Guardar(String idAlmacen, String encargado, int idtipo) {
        if (idAlmacen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al guardar, el id almacen esta vacio");
        } else if (encargado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al guardar, el encargado esta vacio");
        } else if (idtipo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al guardar, el id del tipo Almacen no es el correcto");
        } else {

        }
    }

    public void Actualizar(String idAlmacen, String encargado, int idtipo) {
        if (idAlmacen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al actualizar, el id esta vacio");
        } else if (encargado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al actualizar, encargado esta vacio");
        } else if (idtipo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al actializar, id del tipo Almacen no es el correcto");
        } else {

        }
    }

    public void Eliminar(String idAlmacen) {
        if (idAlmacen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al eliminar, Almacen");
        }
    }
}
