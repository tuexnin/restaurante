
package entidades;

/**
 *
 * @author Edwin CR
 */
public class Reserva {
    private String idReserva;
    private String dia;
    private String time;
    private String idCliente;
    private int ideMesa;

    public Reserva(String idReserva, String dia, String time, String idCliente, int ideMesa) {
        this.idReserva = idReserva;
        this.dia = dia;
        this.time = time;
        this.idCliente = idCliente;
        this.ideMesa = ideMesa;
    }

    public Reserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdeMesa() {
        return ideMesa;
    }

    public void setIdeMesa(int ideMesa) {
        this.ideMesa = ideMesa;
    }
    
    
}
