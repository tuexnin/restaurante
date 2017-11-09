package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class PedidoBL {

    public void Guardar(String idPedido, String horaPedido, String estado, int idMesa, int idconsumiciones, String idCocina) {
        if (idPedido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el idPedido esta vacio");
        } else if (horaPedido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, la Hora de Pedido esta vacio");
        } else if (estado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el estado esta vacio");
        } else if (idMesa <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id mesa esta vacio");
        } else if (idconsumiciones <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id consumiciones estas vacio");
        } else if (idCocina.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id cocina esta vaci0");
        } else {

        }
    }

    public void Actualizar(String idPedido, String horaPedido, String estado, int idMesa, int idconsumiciones, String idCocina) {
        if (idPedido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el idPedido esta vacio");
        } else if (horaPedido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la Hora de Pedido esta vacio");
        } else if (estado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el estado esta vacio");
        } else if (idMesa <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id mesa esta vacio");
        } else if (idconsumiciones <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id consumiciones esta vacio");
        } else if (idCocina.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id cocina esta vaci0");
        } else {

        }
    }

    public void Eliminar(String idPedido) {
        if (idPedido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el pedido");
        }
    }

}
