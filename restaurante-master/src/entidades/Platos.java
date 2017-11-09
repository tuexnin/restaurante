
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Platos {
    private String codigoPlato;
    private String nombre;
    private int idTipo;

    public Platos(String codigoPlato, String nombre, int idTipo) {
        this.codigoPlato = codigoPlato;
        this.nombre = nombre;
        this.idTipo = idTipo;
    }

    public String getCodigoPlato() {
        return codigoPlato;
    }

    public void setCodigoPlato(String codigoPlato) {
        this.codigoPlato = codigoPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    
    
}
