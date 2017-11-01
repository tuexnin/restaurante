
package entidades;

/**
 *
 * @author Edwin CR
 */
public class Cliente {
    private String idCliente;
    private String nombre;
    private String dni;

    public Cliente(String idCliente, String nombre, String dni) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dni = dni;
    }

    public Cliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", dni=" + dni + '}';
    }
    
    
    
}
