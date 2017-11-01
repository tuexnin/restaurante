
package logicaBL;

import entidades.Mesa;
import javax.swing.JOptionPane;
import modelo.db_Mesa;

/**
 *
 * @author Edwin CR
 */
public class MesaBL {
    private Mesa mesa;
    private db_Mesa db_mesa;
    
    public void GuardarMesa(String numMesa,int capacidad, String estadoMesa, int idTipoMesa, int idRestaurante){
        if(numMesa.isEmpty() || capacidad<=0 || estadoMesa.isEmpty() || idTipoMesa<=0 || idRestaurante<=0){
            JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR LA MESA");
        }else{
            mesa=new Mesa(numMesa, capacidad, estadoMesa, idTipoMesa, idRestaurante);
            db_mesa=new db_Mesa();
            db_mesa.GuardarMesa(mesa);
            JOptionPane.showMessageDialog(null, "SE REGISTRO LA MESA :"+numMesa);
        }
    }
    
    
}
