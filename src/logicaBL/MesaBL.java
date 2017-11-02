package logicaBL;

import entidades.Mesa;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.db_Mesa;

/**
 *
 * @author Edwin CR
 */
public class MesaBL {

    private Mesa mesa;
    private db_Mesa db_mesa;

    public void GuardarMesa(String numMesa, int capacidad, String estadoMesa, String idTipoMesa, String idRestaurante) {
        if (numMesa.isEmpty() || capacidad <= 0 || estadoMesa.isEmpty() || idTipoMesa.isEmpty() || idRestaurante.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR LA MESA");
        } else {
            mesa = new Mesa(numMesa, capacidad, estadoMesa, idTipoMesa, idRestaurante);
            db_mesa = new db_Mesa();
            db_mesa.GuardarMesa(mesa);
            JOptionPane.showMessageDialog(null, "SE REGISTRO LA MESA :" + numMesa);
        }
    }

    public void ActualizarMesa(int id, String numMesa, int capacidad, String estadoMesa, String idTipoMesa, String idRestaurante) {
        if (id <= 0 || numMesa.isEmpty() || capacidad <= 0 || estadoMesa.isEmpty() || idTipoMesa.isEmpty() || idRestaurante.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ACTUALIZAR LA MESA");
        }else{
            mesa =new Mesa(id, numMesa, capacidad, estadoMesa, idTipoMesa, idRestaurante);
            db_mesa=new db_Mesa();
            db_mesa.Actualizar(mesa);
            JOptionPane.showMessageDialog(null, "SE ACTULIZO LA MESA ");
        }
    }
    
    public void EliminarMesa(int id){
        if (id<=0) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR LA MESA");
        }else{
            mesa=new Mesa(id);
            db_mesa=new db_Mesa();
            db_mesa.Eliminar(mesa);
            JOptionPane.showMessageDialog(null, "SE ELIMINO LA MESA ");
        }
    }
    
    public void ListarTabla(JTable tabla, String dato){
        db_mesa=new db_Mesa();
        db_mesa.Listar(tabla, dato);
    }

}
