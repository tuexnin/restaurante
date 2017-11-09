
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Tipo_almacen {
    private int idTipoAlmacen;
    private String tipo;

    public Tipo_almacen(int idTipoAlmacen, String tipo) {
        this.idTipoAlmacen = idTipoAlmacen;
        this.tipo = tipo;
    }

    public int getIdTipoAlmacen() {
        return idTipoAlmacen;
    }

    public void setIdTipoAlmacen(int idTipoAlmacen) {
        this.idTipoAlmacen = idTipoAlmacen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
