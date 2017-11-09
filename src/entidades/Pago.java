
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Pago {
    private String idPago;
    private String idTipoPago;
    private int idMesa;

    public Pago(String idPago, String idTipoPago, int idMesa) {
        this.idPago = idPago;
        this.idTipoPago = idTipoPago;
        this.idMesa = idMesa;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public String getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(String idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }
    
    
    
}
