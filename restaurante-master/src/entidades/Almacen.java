
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Almacen {
    private String idAlmacen;
    private String encargado;
    private int idtipo;

    public Almacen(String idAlmacen, String encargado, int idtipo) {
        this.idAlmacen = idAlmacen;
        this.encargado = encargado;
        this.idtipo = idtipo;
    }

    public String getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }
    
    
    
}
