package logicaBL;

import entidades.Almacen;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.db_Almacen;

/**
 *
 * @author MillerJMRO
 */
public class AlmacenBL {
    
    private Almacen almacen;
    private db_Almacen db_almacen;

    public void Guardar(String idAlmacen, String encargado, int idtipo) {
        if (idAlmacen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al guardar, el id almacen esta vacio");
        } else if (encargado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al guardar, el encargado esta vacio");
        } else if (idtipo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al guardar, el id del tipo Almacen no es el correcto");
        } else {
            almacen=new Almacen(idAlmacen, encargado, idtipo);
            db_almacen=new db_Almacen();
            db_almacen.Guardar(almacen);
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
            almacen=new Almacen(idAlmacen, encargado, idtipo);
            db_almacen=new db_Almacen();
            db_almacen.Actualizar(almacen);
        }
    }

    public void Eliminar(String idAlmacen) {
        if (idAlmacen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al eliminar, Almacen");
        }else{
            almacen=new Almacen(idAlmacen);
            db_almacen=new db_Almacen();
            db_almacen.Eliminar(almacen);
        }
    }
    
    public void Listar(JTable table,String dato){
        db_almacen=new db_Almacen();
        db_almacen.Listar(table, dato);
    }
}
