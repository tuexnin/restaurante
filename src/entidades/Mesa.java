
package entidades;

/**
 *
 * @author Edwin CR
 */
public class Mesa {
    private int idMesa;
    private String numMesa;
    private int capacidad;
    private String esadoMesa;
    private int idTipoMesa;
    private int idRestaurante;

    public Mesa(int idMesa, String numMesa, int capacidad, String esadoMesa, int idTipoMesa, int idRestaurante) {
        this.idMesa = idMesa;
        this.numMesa = numMesa;
        this.capacidad = capacidad;
        this.esadoMesa = esadoMesa;
        this.idTipoMesa = idTipoMesa;
        this.idRestaurante = idRestaurante;
    }

    public Mesa(String numMesa, int capacidad, String esadoMesa, int idTipoMesa, int idRestaurante) {
        this.numMesa = numMesa;
        this.capacidad = capacidad;
        this.esadoMesa = esadoMesa;
        this.idTipoMesa = idTipoMesa;
        this.idRestaurante = idRestaurante;
    }

    public Mesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(String numMesa) {
        this.numMesa = numMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEsadoMesa() {
        return esadoMesa;
    }

    public void setEsadoMesa(String esadoMesa) {
        this.esadoMesa = esadoMesa;
    }

    public int getIdTipoMesa() {
        return idTipoMesa;
    }

    public void setIdTipoMesa(int idTipoMesa) {
        this.idTipoMesa = idTipoMesa;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    

    
    
}
