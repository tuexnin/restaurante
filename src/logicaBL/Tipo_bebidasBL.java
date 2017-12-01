package logicaBL;

import entidades.Tipo_bebidas;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.db_TipoBebidas;

/**
 *
 * @author MillerJMRO
 */
public class Tipo_bebidasBL {
    
    private Tipo_bebidas tb;
    private db_TipoBebidas db;

    public void Guardar( String tipo) {
        if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el tipo de bebidas esta vacio");
        }else{
            tb=new Tipo_bebidas(tipo);
            db=new db_TipoBebidas();
            db.guardar(tb);
            JOptionPane.showMessageDialog(null, "SE GUARDO EL TIPO DE BEBIDAS");
        }
    }

    public void Actualizar(int idTipoBebidas, String tipo) {
        if (idTipoBebidas <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id tipo de bebidas esta vacio");
        } else if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el tipo de bebidas esta vacio");
        }else{
            tb=new Tipo_bebidas(idTipoBebidas, tipo);
            db=new db_TipoBebidas();
            db.Actualizar(tb);
            JOptionPane.showMessageDialog(null, "SE ACTUALIZO EL TIPO DE BEBIDAS");
        }
    }

    public void Eliminar(int idTipoBebidas) {
        if (idTipoBebidas <= 0) {
            JOptionPane.showMessageDialog(null, "Error al eliminar, tipo de bebidas");
        }else{
            tb=new Tipo_bebidas(idTipoBebidas);
            db=new db_TipoBebidas();
            db.Eliminar(tb);
            JOptionPane.showMessageDialog(null, "SE ELIMINO EL TIPO DE BEBIDAS");
        }
    }
    
    public void Listar(JList lista, String dato){
        db=new db_TipoBebidas();
        db.Listar(lista, dato);
    }
    
    public String SacarIDTipoBebida(String dato){
        db=new db_TipoBebidas();
        return db.sacarID(dato);
    }
}
