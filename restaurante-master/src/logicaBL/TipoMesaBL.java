
package logicaBL;

import entidades.TipoMesa;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.db_TipoMesa;

/**
 *
 * @author Edwin CR
 */
public class TipoMesaBL {
    private TipoMesa tipoMesa;
    private db_TipoMesa db_tipoMesa;
    
    public void GuardarTipoMesa(String idTipomesa, String descripcion){
         if (idTipomesa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id tipo mesa no es correcto");
        } else if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, la descripcion no es correcta");
        }else{
            tipoMesa=new TipoMesa(idTipomesa, descripcion);
            db_tipoMesa=new db_TipoMesa();
            db_tipoMesa.GuardarTipoMesa(tipoMesa);
            JOptionPane.showMessageDialog(null, "SE GUARDO EL TIPO DE MESA: "+descripcion);
        }
    }
    
    public void ListarTipoMesa(JComboBox combo){
        db_tipoMesa=new db_TipoMesa();
        db_tipoMesa.llenarComboTipoMesa(combo);
    }
    
    public void ActualizarTipoMesa(String idTipomesa, String descripcion){
        if (idTipomesa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id tipo mesa no es correcto");
        } else if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la descripcion no es correcta");
        }else{
            tipoMesa=new TipoMesa(idTipomesa, descripcion);
            db_tipoMesa=new db_TipoMesa();
            db_tipoMesa.actualizar(tipoMesa);
            JOptionPane.showMessageDialog(null, " SE  ACTUALIZAR EL TIPO DE MESA");
        }
    }
    
    public void EliminarTipoMesa(String id){
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDO ELIMINAR");
        } else {
            tipoMesa=new TipoMesa(id);
            db_tipoMesa=new db_TipoMesa();
            db_tipoMesa.Eliminar(tipoMesa);
            JOptionPane.showMessageDialog(null, "SE ACTULIZO CORRECTAMENTE");
        }
    }
    
    public void listarTablaTipoMesa(JTable table, String dato){
        db_tipoMesa=new db_TipoMesa();
        db_tipoMesa.Listar(table, dato);
    }
    
    public String id(String dato){
        db_tipoMesa=new db_TipoMesa();
        return db_tipoMesa.IdTipoMesa(dato);
    }
}
