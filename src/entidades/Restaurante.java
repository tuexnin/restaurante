
package entidades;

/**
 *
 * @author Edwin CR
 */
public class Restaurante {
    private String idRestaurante;
    private String direccion;
    private int aforo;
    private int cantMesas;

    public Restaurante(String idRestaurante, String direccion, int aforo, int cantMesas) {
        this.idRestaurante = idRestaurante;
        this.direccion = direccion;
        this.aforo = aforo;
        this.cantMesas = cantMesas;
    }

    public Restaurante(String idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(String idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public int getCantMesas() {
        return cantMesas;
    }

    public void setCantMesas(int cantMesas) {
        this.cantMesas = cantMesas;
    }

    @Override
    public String toString() {
        return "Restaurante{" + "idRestaurante=" + idRestaurante + ", direccion=" + direccion + ", aforo=" + aforo + ", cantMesas=" + cantMesas + '}';
    }
    
    
}
