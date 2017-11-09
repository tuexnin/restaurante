
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Ingrediente {
    private String idIngrediente;
    private String nombre;
    private double Cantidad;
    private String idAlmacen;

    public Ingrediente(String idIngrediente, String nombre, double Cantidad) {
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
        this.Cantidad = Cantidad;
    }

    public String getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(String idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    
    
    
}
