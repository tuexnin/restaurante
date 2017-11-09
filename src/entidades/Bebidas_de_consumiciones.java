
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Bebidas_de_consumiciones {
    private int idbebiconsumic;
    private String codbebidas;
    private int idconsumisiones;

    public Bebidas_de_consumiciones(int idbebiconsumic, String codbebidas, int idconsumisiones) {
        this.idbebiconsumic = idbebiconsumic;
        this.codbebidas = codbebidas;
        this.idconsumisiones = idconsumisiones;
    }

    public int getIdbebiconsumic() {
        return idbebiconsumic;
    }

    public void setIdbebiconsumic(int idbebiconsumic) {
        this.idbebiconsumic = idbebiconsumic;
    }

    public String getCodbebidas() {
        return codbebidas;
    }

    public void setCodbebidas(String codbebidas) {
        this.codbebidas = codbebidas;
    }

    public int getIdconsumisiones() {
        return idconsumisiones;
    }

    public void setIdconsumisiones(int idconsumisiones) {
        this.idconsumisiones = idconsumisiones;
    }
    
    
}
