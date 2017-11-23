
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Ingrediente {
    private String idIngrediente;
    private String nombre;
    private double Cantidad;
    private String medida;
    private String idAlmacen;

    public Ingrediente(String idIngrediente, String nombre, double Cantidad, String medida, String idAlmacen) {
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
        this.Cantidad = Cantidad;
        this.medida = medida;
        this.idAlmacen = idAlmacen;
    }

    public Ingrediente(String idIngrediente) {
        this.idIngrediente = idIngrediente;
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

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }
    
}
