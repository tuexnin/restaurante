package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class CocinaBL {

    public void Guardar(String idcocina, String encargado, String minimoencargable) {
        if (idcocina.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el idcocina esta vacio");
        } else if (encargado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el encaragado esta vacio");
        } else if (minimoencargable.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el minimo encargable esta vacio");
        } else {

        }
    }

    public void Actualizar(String idcocina, String encargado, String minimoencargable) {
        if (idcocina.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el idcocina esta vacio");
        } else if (encargado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el encaragado esta vacio");
        } else if (minimoencargable.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el minimo encargable esta vacio");
        } else {

        }
    }

    public void Eliminar(String idcocina) {
        JOptionPane.showMessageDialog(null, "Error al Eliminar, cocina");
    }
}
