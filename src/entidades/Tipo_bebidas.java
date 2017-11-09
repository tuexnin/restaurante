
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Tipo_bebidas {
    private int idTipoBebidas;
    private String tipo;

    public Tipo_bebidas(int idTipoBebidas, String tipo) {
        this.idTipoBebidas = idTipoBebidas;
        this.tipo = tipo;
    }

    public int getIdTipoBebidas() {
        return idTipoBebidas;
    }

    public void setIdTipoBebidas(int idTipoBebidas) {
        this.idTipoBebidas = idTipoBebidas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
