package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class Tipo_platoBL {

    public void Guardar(int idtipo, String tipo) {
        if (idtipo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id del tipo plato no es correcto");
        } else if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el tipo de plato no es correcto");
        } else {

        }
    }

    public void Actualizar(int idtipo, String tipo) {
        if (idtipo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id del tipo plato no es correcto");
        } else if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el tipo de plato no es correcto");
        } else {

        }
    }

    public void Eliminar(int idtipo) {
        if (idtipo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el tipo de plato");
        }
    }
}
