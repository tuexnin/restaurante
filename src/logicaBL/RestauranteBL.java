
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
    
    public void GuardarRestaurante(String id,String direccion, int aforo, int cantMesas){
        if(id.isEmpty() || direccion.isEmpty() || aforo<=0 || cantMesas<=0){
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR LOCAL RESTAURANTE");
        }else{
            restaurante=new Restaurante(id, direccion, aforo, cantMesas);
            db_resRestaurante=new db_Restaurante();
            db_resRestaurante.guardar(restaurante);
            JOptionPane.showMessageDialog(null, "EL RESTAURANTE CON SEDE: "+direccion+" SE GUARDO");
        }
    }
    
    public void ListarRestaurante(JComboBox combo){
        db_resRestaurante=new db_Restaurante();
        db_resRestaurante.llenarComboRestaurante(combo);
    }
    
    public void ActualizarRestaurante(String id,String direccion, int aforo, int cantMesas){
        if(id.isEmpty() || direccion.isEmpty() || aforo<=0 || cantMesas<=0){
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR LOCAL RESTAURANTE");
        }else{
            restaurante=new Restaurante(id, direccion, aforo, cantMesas);
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
