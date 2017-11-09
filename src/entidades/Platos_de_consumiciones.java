
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Platos_de_consumiciones {
    private int idPlatosdeConsumiciones;
    private String codigoPlato;
    private int idconsumiciones;

    public Platos_de_consumiciones(int idPlatosdeConsumiciones, String codigoPlato, int idconsumiciones) {
        this.idPlatosdeConsumiciones = idPlatosdeConsumiciones;
        this.codigoPlato = codigoPlato;
        this.idconsumiciones = idconsumiciones;
    }

    public int getIdPlatosdeConsumiciones() {
        return idPlatosdeConsumiciones;
    }

    public void setIdPlatosdeConsumiciones(int idPlatosdeConsumiciones) {
        this.idPlatosdeConsumiciones = idPlatosdeConsumiciones;
    }

    public String getCodigoPlato() {
        return codigoPlato;
    }

    public void setCodigoPlato(String codigoPlato) {
        this.codigoPlato = codigoPlato;
    }

    public int getIdconsumiciones() {
        return idconsumiciones;
    }

    public void setIdconsumiciones(int idconsumiciones) {
        this.idconsumiciones = idconsumiciones;
    }
    
    
    
}
