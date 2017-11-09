
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Cocina {
    private String idcocina;
    private String encargado;
    private String minimoencargable;

    public Cocina(String idcocina, String encargado, String minimoencargable) {
        this.idcocina = idcocina;
        this.encargado = encargado;
        this.minimoencargable = minimoencargable;
    }

    public String getIdcocina() {
        return idcocina;
    }

    public void setIdcocina(String idcocina) {
        this.idcocina = idcocina;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getMinimoencargable() {
        return minimoencargable;
    }

    public void setMinimoencargable(String minimoencargable) {
        this.minimoencargable = minimoencargable;
    }

   
    
}
