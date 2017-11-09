package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class ReservaBL {

    public void Guardar(String idReserva, String dia, String hora, String idcliente, int idMesa) {
        if (idReserva.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id reserva noes correcto");
        } else if (dia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el dia de resrva no es correcto");
        } else if (hora.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, la hora de reserva no es correcto");
        } else if (idcliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id del cliente no es correcto");
        } else if (idMesa <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id de la mesa no es correcto");
        } else {

        }
    }

    public void Actualizar(String idReserva, String dia, String hora, String idcliente, int idMesa) {
        if (idReserva.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id reserva noes correcto");
        } else if (dia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el dia de resrva no es correcto");
        } else if (hora.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la hora de reserva no es correcto");
        } else if (idcliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id del cliente no es correcto");
        } else if (idMesa <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id de la mesa no es correcto");
        } else {

        }
    }

    public void Eliminar(String idReserva) {
        if (idReserva.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al eliminar l reserva");
        }
    }
}
