
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Consumiciones {
    private int idconsumiciones;
    private String descripcion;

    public Consumiciones(int idconsumiciones, String descripcion) {
        this.idconsumiciones = idconsumiciones;
        this.descripcion = descripcion;
    }

    public int getIdconsumiciones() {
        return idconsumiciones;
    }

    public void setIdconsumiciones(int idconsumiciones) {
        this.idconsumiciones = idconsumiciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
