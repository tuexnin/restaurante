
package modelo;

import entidades.Cliente;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin CR
 */
public class db_Cliente extends ConeDB{
    
    public void guardar(Cliente cliente){
        try {
            this.ps=this.Conectar().prepareStatement("insert into cliente values(?,?,?)");
            this.ps.setString(1, cliente.getIdCliente());
            this.ps.setString(2, cliente.getNombre());
            this.ps.setString(3, cliente.getDni());
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
    
    public void Editar(Cliente cliente){
        try {
            this.ps=this.Conectar().prepareStatement("update cliente set nombre=?,dni=? where idcliente=?");
            this.ps.setString(1, cliente.getNombre());
            this.ps.setString(2, cliente.getDni());
            this.ps.setString(3, cliente.getIdCliente());
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
    
    public void Eliminar(Cliente cliente){
        try {
            this.ps=this.Conectar().prepareStatement("delete from cliente where idcliente=?");
            this.ps.setString(1, cliente.getIdCliente());
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
    
    
    public void ListarCliente(JTable tabla, String dato){
        String [] titulos={"ID","NOMBRE","DNI"};
        DefaultTableModel tablaModelo=new DefaultTableModel(null,titulos);
        Object [] aux =new Object[3];
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select * from cliente where dni like '%"+dato+"%'");
            while(this.rs.next()){
                for(int i=0;i<3;i++){
                    aux[i]=this.rs.getObject(i+1);
                }
                tablaModelo.addRow(aux);
            }
            tabla.setModel(tablaModelo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
