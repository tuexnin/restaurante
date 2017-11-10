package logicaBL;

import entidades.Platos;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.db_Platos;

/**
 *
 * @author MillerJMRO
 */
public class PlatosBL {
    
    private Platos plato;
    private db_Platos db_plato;

    public void Guardar(String codigoPlato, String nombre, int idTipo) {
        if (codigoPlato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el codigoPlato esta vacio");
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el nombre esta vacio");
        } else if (idTipo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar el idTipo plato esta vacio");
        } else {
            plato=new Platos(codigoPlato, nombre, idTipo);
            db_plato=new db_Platos();
            db_plato.GuardarPlatos(plato);
            JOptionPane.showMessageDialog(null, "SE GUARDO EL PLATO");
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
            plato=new Platos(codigoPlato, nombre, idTipo);
            db_plato=new db_Platos();
            db_plato.ActualizarPlatos(plato);
            JOptionPane.showMessageDialog(null, "SE ACTUALIZO EL PLATO");
        }
    }

    public void Eliminar(String codigoPlato) {
        if (codigoPlato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al eliminar, plato");
        }else{
            plato=new Platos(codigoPlato);
            db_plato=new db_Platos();
            db_plato.Eliminar(plato);
            JOptionPane.showMessageDialog(null, "SE ELIMINO EL PLATO");
        }
    }
    
    public void Listar(JTable tabla,String dato){
        db_plato=new db_Platos();
        db_plato.Listar(tabla, dato);
    }
}
