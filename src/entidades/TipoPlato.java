/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Edwin CR
 */
public class TipoPlato {
    
    private int idTipoPlato;
    private String tipo;

    public TipoPlato(int idTipoPlato, String tipo) {
        this.idTipoPlato = idTipoPlato;
        this.tipo = tipo;
    }

    public TipoPlato(String tipo) {
        this.tipo = tipo;
    }

    public TipoPlato(int idTipoPlato) {
        this.idTipoPlato = idTipoPlato;
    }
    

    public int getIdTipoPlato() {
        return idTipoPlato;
    }

    public void setIdTipoPlato(int idTipoPlato) {
        this.idTipoPlato = idTipoPlato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
