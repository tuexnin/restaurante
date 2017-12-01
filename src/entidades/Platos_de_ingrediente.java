
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Platos_de_ingrediente {
    private int idPlatodeIngrediente;
    private String codigoPlato;
    private String idIngrediente;

    public Platos_de_ingrediente(int idPlatodeIngrediente, String codigoPlato, String idIngrediente) {
        this.idPlatodeIngrediente = idPlatodeIngrediente;
        this.codigoPlato = codigoPlato;
        this.idIngrediente = idIngrediente;
    }

    public Platos_de_ingrediente(String codigoPlato, String idIngrediente) {
        this.codigoPlato = codigoPlato;
        this.idIngrediente = idIngrediente;
    }

    public Platos_de_ingrediente(int idPlatodeIngrediente) {
        this.idPlatodeIngrediente = idPlatodeIngrediente;
    }
    
    

    public int getIdPlatodeIngrediente() {
        return idPlatodeIngrediente;
    }

    public void setIdPlatodeIngrediente(int idPlatodeIngrediente) {
        this.idPlatodeIngrediente = idPlatodeIngrediente;
    }

    public String getCodigoPlato() {
        return codigoPlato;
    }

    public void setCodigoPlato(String codigoPlato) {
        this.codigoPlato = codigoPlato;
    }

    public String getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(String idIngrediente) {
        this.idIngrediente = idIngrediente;
    }
    
    
    
}
