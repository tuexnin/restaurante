
package entidades;

/**
 *
 * @author Edwin CR
 */
public class TipoMesa {
    private String idTipoMesa;
    private String descripcion;

    public TipoMesa(String idTipoMesa, String descripcion) {
        this.idTipoMesa = idTipoMesa;
        this.descripcion = descripcion;
    }

    public TipoMesa(String idTipoMesa) {
        this.idTipoMesa = idTipoMesa;
    }

    public String getIdTipoMesa() {
        return idTipoMesa;
    }

    public void setIdTipoMesa(String idTipoMesa) {
        this.idTipoMesa = idTipoMesa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoMesa{" + "idTipoMesa=" + idTipoMesa + ", descripcion=" + descripcion + '}';
    }

    
    
}
