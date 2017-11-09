package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class Platos_de_ingredienteBL {

    public void Guardar(int idPlatodeIngrediente, String codigoPlato, String idIngrediente) {
        if (idPlatodeIngrediente <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id plato de ingredientes esta vacio");
        } else if (codigoPlato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el codigo plato esta vacio");
        } else if (idIngrediente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id ingrediente esta vacio");
        } else {

        }
    }

    public void Actualizar(int idPlatodeIngrediente, String codigoPlato, String idIngrediente) {
        if (idPlatodeIngrediente <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id plato de ingredientes esta vacio");
        } else if (codigoPlato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el codigo plato esta vacio");
        } else if (idIngrediente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id ingrediente esta vacio");
        } else {

        }
    }

    public void Eliminar(int idPlatodeIngrediente) {
        if (idPlatodeIngrediente <= 0) {
            JOptionPane.showMessageDialog(null, "Error al eliminar platos de ingrediente");
        }
    }
}
