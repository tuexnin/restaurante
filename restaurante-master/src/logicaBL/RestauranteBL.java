
package logicaBL;

import entidades.Restaurante;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.db_Restaurante;

/**
 *
 * @author Edwin CR
 */
public class RestauranteBL {
    private Restaurante restaurante;
    private db_Restaurante db_resRestaurante;
    
    public void GuardarRestaurante(String idRestaurante, String direccion, int aforo, int cantidadMesas){
         if (idRestaurante.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id restaurante no es correcto");
        } else if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, la direccion no es correcto");
        } else if (aforo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al guardar, el aforo no es correcto");
        } else if (cantidadMesas <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, la cantidad de mesas no es correcto ");
        }else{
            restaurante=new Restaurante(idRestaurante, direccion, aforo, cantidadMesas);
            db_resRestaurante=new db_Restaurante();
            db_resRestaurante.guardar(restaurante);
            JOptionPane.showMessageDialog(null, "EL RESTAURANTE CON SEDE: "+direccion+" SE GUARDO");
        }
    }
    
    public void ListarRestaurante(JComboBox combo){
        db_resRestaurante=new db_Restaurante();
        db_resRestaurante.llenarComboRestaurante(combo);
    }
    
    public void ActualizarRestaurante(String idRestaurante, String direccion, int aforo, int cantidadMesas){
        if (idRestaurante.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id restaurante no es correcto");
        } else if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la direccion no es correcto");
        } else if (aforo <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el aforo no es correcto");
        } else if (cantidadMesas <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la cantidad de mesas no es correcto ");
        }else{
            restaurante=new Restaurante(idRestaurante, direccion, aforo, cantidadMesas);
            db_resRestaurante=new db_Restaurante();
            db_resRestaurante.Actualizar(restaurante);
            JOptionPane.showMessageDialog(null, "EL RESTAURANTE SE ACTUALIZO");
        }
    }
    
    public void EliminarRestaurante(String id){
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO SELECIONO UN CLIENTE");
        }else{
            restaurante=new Restaurante(id);
            db_resRestaurante=new db_Restaurante();
            db_resRestaurante.Eliminar(restaurante);
            JOptionPane.showMessageDialog(null, "SE ELIMINO EL RESTAURANTE");
        }
    }
    
    public void ListarTablaRestaurante(JTable table,String dato){
        db_resRestaurante=new db_Restaurante();
        db_resRestaurante.listarRestaurante(table, dato);
    }
}
