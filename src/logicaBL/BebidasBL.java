package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class BebidasBL {

    public void Guardar(String codbebidas, String nombre, String descripcion, String medida, int stok, int idtipo, int idAlmacen) {
        if (codbebidas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id esta vacio");
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el nombre esta vacio");
        } else if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guaradar, la descripcion esta vacia");
        } else if (medida.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, la media esta vacia");
        } else if (stok <= 0) {
            JOptionPane.showMessageDialog(null, "Error al guardar, el stok esta vacio");
        } else if (idtipo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el idtipo Almacen esta vacio");
        } else if (idAlmacen <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guaradar, el idAlmacen esta vacio");
        }else{
            
        }

    }

    public void Actualizar(String codbebidas, String nombre, String descripcion, String medida, int stok, int idtipo, int idAlmacen) {
        if (codbebidas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id esta vacio");
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el nombre esta vacio");
        } else if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la descripcion esta vacia");
        } else if (medida.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la media esta vacia");
        } else if (stok <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el stok esta vacio");
        } else if (idtipo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el idtipo Almacen esta vacio");
        } else if (idAlmacen <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el idAlmacen esta vacio");
        }else{
            
        }

    }
    public void Eliminar(String codbebidas){
        if (codbebidas.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Error al Eliminar Bebidas");
        }
    }
}
