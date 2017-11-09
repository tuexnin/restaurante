/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author MillerJMRO
 */
public class Pedido {
    private String idPedido;
    private String horaPedido;
    private String estado;
    private int idMesa;
    private int idconsumiciones;
    private String idCocina;

    public Pedido(String idPedido, String horaPedido, String estado, int idMesa, int idconsumiciones, String idCocina) {
        this.idPedido = idPedido;
        this.horaPedido = horaPedido;
        this.estado = estado;
        this.idMesa = idMesa;
        this.idconsumiciones = idconsumiciones;
        this.idCocina = idCocina;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getIdconsumiciones() {
        return idconsumiciones;
    }

    public void setIdconsumiciones(int idconsumiciones) {
        this.idconsumiciones = idconsumiciones;
    }

    public String getIdCocina() {
        return idCocina;
    }

    public void setIdCocina(String idCocina) {
        this.idCocina = idCocina;
    }
    
    
}
