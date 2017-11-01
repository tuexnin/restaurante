
package modelo;

import entidades.Mesa;
import java.sql.SQLException;

/**
 *
 * @author Edwin CR
 */
public class db_Mesa extends ConeDB{
    
    public void GuardarMesa(Mesa mesa){
        try {
            this.ps=this.Conectar().prepareStatement("insert into mesa(num_mesa,capacidad,estadomesa,idTipomesa,idRestaurante) values(?,?,?,?,?)");
            this.ps.setString(1, mesa.getNumMesa());
            this.ps.setInt(2, mesa.getCapacidad());
            this.ps.setString(3, mesa.getEsadoMesa());
            this.ps.setInt(4, mesa.getIdTipoMesa());
            this.ps.setInt(5, mesa.getIdRestaurante());
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
}
