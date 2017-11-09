
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Bebidas {
    private String codbedidas;
    private String nombre;
    private String descripcion;
    private String medida;
    private int stok;
    private int idtipo;
    private int idAlmacen;

    public Bebidas(String codbedidas, String nombre, String descripcion, String medida, int stok, int idtipo, int idAlmacen) {
        this.codbedidas = codbedidas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.medida = medida;
        this.stok = stok;
        this.idtipo = idtipo;
        this.idAlmacen = idAlmacen;
    }

    public String getCodbedidas() {
        return codbedidas;
    }

    public void setCodbedidas(String codbedidas) {
        this.codbedidas = codbedidas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }
    
    
}
