package logicaBL;

import entidades.Tipo_almacen;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.db_TipoAlmacen;

/**
 *
 * @author MillerJMRO
 */
public class Tipo_almacenBL {

    private Tipo_almacen ta;
    private db_TipoAlmacen db_ta;

    public void Guardar(String tipo) {
        if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el tipo de almacen esta vacio");
        } else {
            ta = new Tipo_almacen(tipo);
            db_ta = new db_TipoAlmacen();
            db_ta.Guardar(ta);
            JOptionPane.showMessageDialog(null, "SE GUARDO EL TIPO ALMACEN");
        }
    }

    public void Actualizar(int idTipoAlmacen, String tipo) {
        if (idTipoAlmacen <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id tipo de almacen esta vacio");
        } else if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el tipo de almacen esta vacio");
        } else {
            ta = new Tipo_almacen(idTipoAlmacen, tipo);
            db_ta = new db_TipoAlmacen();
            db_ta.Actualizar(ta);
            JOptionPane.showMessageDialog(null, "SE ACTUALIZO EL TIPO ALMACEN");
        }
    }

    public void Eliminar(int idTipoAlmacen) {
        if (idTipoAlmacen <= 0) {
            JOptionPane.showMessageDialog(null, "Error al eliminar, el tipo de almacen");
        } else {
            ta = new Tipo_almacen(idTipoAlmacen);
            db_ta = new db_TipoAlmacen();
            db_ta.Eliminar(ta);
            JOptionPane.showMessageDialog(null, "SE ELIMINO EL TIPO ALMACEN");
        }
    }
    
    public String SacarId(String tipo){
        db_ta=new db_TipoAlmacen();
        return db_ta.SacarID(tipo);
    }
    
    public void Listar(JList lista,String dato){
        db_ta=new db_TipoAlmacen();
        db_ta.Listar(lista, dato);
    }
}
