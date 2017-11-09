
package modelo;

import entidades.Restaurante;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin CR
 */
public class db_Restaurante extends ConeDB{
    
    public void guardar(Restaurante restaurante){
        try {
            this.ps=this.Conectar().prepareStatement("insert into restaurante values(?,?,?,?)");
            this.ps.setString(1, restaurante.getIdRestaurante());
            this.ps.setString(2, restaurante.getDireccion());
            this.ps.setInt(3, restaurante.getAforo());
            this.ps.setInt(4, restaurante.getCantMesas());
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
    
    
    public void llenarComboRestaurante(JComboBox combo){
        DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel();
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select idRestaurante,direccion from restaurante");
            while (rs.next()) {                
                modeloCombo.addElement(rs.getString(1)+" - "+rs.getString(2));
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
    
    public void Actualizar(Restaurante rest){
        try {
            this.ps=this.Conectar().prepareStatement("update restaurante set direccion=?, aforo=?, cantidadMesas=? where idRestaurante=?");
            this.ps.setString(1, rest.getDireccion());
            this.ps.setInt(2, rest.getAforo());
            this.ps.setInt(3, rest.getCantMesas());
            this.ps.setString(4, rest.getIdRestaurante());
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
    
    public void Eliminar(Restaurante rest){
        try {
            this.ps=this.Conectar().prepareStatement("delete from restaurante where idRestaurante=?");
            this.ps.setString(1, rest.getIdRestaurante());
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
    
    public void listarRestaurante(JTable tabla, String dato){
        String [] titulos={"ID","DIRECCION","AFORO","C. MESAS"};
        DefaultTableModel modelo=new DefaultTableModel(null,titulos);
        Object [] aux=new Object[4];
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select * from restaurante where direccion like '%"+dato+"%'");
            while(this.rs.next()){
                for(int i=0;i<4;i++){
                    aux[i]=this.rs.getObject(i+1);
                }
                modelo.addRow(aux);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
