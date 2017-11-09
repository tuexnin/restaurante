package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class PlatosBL {

    public void Guardar(String codigoPlato, String nombre, int idTipo) {
        if (codigoPlato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el codigoPlato esta vacio");
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el nombre esta vacio");
        } else if (idTipo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar el idTipo plato esta vacio");
        } else {

        }
    }

    public void Actualizar(String codigoPlato, String nombre, int idTipo) {
        if (codigoPlato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el codigoPlato esta vacio");
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el nombre esta vacio");
        } else if (idTipo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar el idTipo plato esta vacio");
        } else {

        }
    }

    public void Eliminar(String codigoPlato) {
        if (codigoPlato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al eliminar, plato");
        }
    }
}
