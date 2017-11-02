
package modelo;

import entidades.TipoMesa;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin CR
 */
public class db_TipoMesa extends ConeDB{
    
    public void GuardarTipoMesa(TipoMesa tm){
        try {
            this.ps=this.Conectar().prepareStatement("insert into tipomesa values(?,?)");
            this.ps.setString(1, tm.getIdTipoMesa());
            this.ps.setString(2, tm.getDescripcion());
            this.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.Conectar().close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void llenarComboTipoMesa(JComboBox combo){
        DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel();
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select Descripcion from tipomesa");
            while (rs.next()) {                

                modeloCombo.addElement(rs.getObject(1));
            }
            combo.setModel(modeloCombo);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.Conectar().close();
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void actualizar(TipoMesa tm){
        try {
            this.ps=this.Conectar().prepareStatement("update tipomesa set Descripcion=? where idTipomesa=?");
            this.ps.setString(1, tm.getDescripcion());
            this.ps.setString(2, tm.getIdTipoMesa());
            this.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.Conectar().close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void Eliminar(TipoMesa tm){
        try {
            this.ps=this.Conectar().prepareStatement("delete from tipomesa where idTipomesa=?");
            this.ps.setString(1, tm.getIdTipoMesa());
            this.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.Conectar().close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void Listar(JTable tabla, String dato){
        String [] titulo={"ID","DESCRIPCION"};
        DefaultTableModel modelo=new DefaultTableModel(null, titulo);
        Object [] aux=new Object[2];
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select * from tipomesa where Descripcion like '%"+dato+"%'");
            while (this.rs.next()) {                
                for (int i = 0; i < 2; i++) {
                    aux[i]=this.rs.getObject(i+1);
                }
                modelo.addRow(aux);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String IdTipoMesa(String descripcion){
        String id="";
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select idTipomesa from tipomesa where Descripcion='"+descripcion+"'");
            if(this.rs.next()){
                id=this.rs.getObject(1).toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.Conectar().close();
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }
}
