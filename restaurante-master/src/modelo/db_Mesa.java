package modelo;

import entidades.Mesa;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin CR
 */
public class db_Mesa extends ConeDB {

    public void GuardarMesa(Mesa mesa) {
        try {
            this.ps = this.Conectar().prepareStatement("insert into mesa(num_mesa,capacidad,estadomesa,idTipomesa,idRestaurante) values(?,?,?,?,?)");
            this.ps.setString(1, mesa.getNumMesa());
            this.ps.setInt(2, mesa.getCapacidad());
            this.ps.setString(3, mesa.getEsadoMesa());
            this.ps.setString(4, mesa.getIdTipoMesa());
            this.ps.setString(5, mesa.getIdRestaurante());
            this.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.Conectar().close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void Actualizar(Mesa mesa) {
        try {
            this.ps = this.Conectar().prepareStatement("update mesa set num_mesa=?,capacidad=?,estadomesa=?,idTipomesa=?,idRestaurante=? where idMesa=?");
            this.ps.setString(1, mesa.getNumMesa());
            this.ps.setInt(2, mesa.getCapacidad());
            this.ps.setString(3, mesa.getEsadoMesa());
            this.ps.setString(4, mesa.getIdTipoMesa());
            this.ps.setString(5, mesa.getIdRestaurante());
            this.ps.setInt(6, mesa.getIdMesa());
            this.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.Conectar().close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void Eliminar(Mesa mesa) {
        try {
            this.ps = this.Conectar().prepareStatement("delete from mesa where idMesa=?");
            this.ps.setInt(1, mesa.getIdMesa());
            this.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.Conectar().close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void Listar(JTable tabla,String dato){
        String [] titulo={"ID","NUMERO M","CAPACIDAD","ESTADO","TIPO","RESTAURANTE"};
        DefaultTableModel modelo=new DefaultTableModel(null, titulo);
        Object [] aux=new Object[6];
        try {
            this.rs=this.Conectar().createStatement().executeQuery("CALL listarMesa('"+dato+"')");
            while (this.rs.next()) {                
                for (int i = 0; i < 6; i++) {
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
