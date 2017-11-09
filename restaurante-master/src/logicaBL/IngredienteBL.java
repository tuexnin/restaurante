package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class IngredienteBL {

    public void Guardar(String idIngrediente, String nombre, double Cantidad, String idAlmacen) {
        if (idIngrediente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar,el idIngrediente esta vacio");
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el nombre esta vacio");
        } else if (Cantidad<=0) {
            JOptionPane.showMessageDialog(null, "Error al Guaradr, la cantidad esta vacia");
        } else if (idAlmacen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el idAlmacen esta vacio");
        } else {

        }
    }

    public void Actualizar(String idIngrediente, String nombre, double Cantidad, String idAlmacen) {
        if (idIngrediente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar,el idIngrediente esta vacio");
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el nombre esta vacio");
        } else if (Cantidad<=0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la cantidad esta vacia");
        } else if (idAlmacen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el idAlmacen esta vacio");
        } else {

        }
    }

    public void Eliminar(String idIngrediente) {
        if (idIngrediente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar, ingrediente");
        }
    }
}
