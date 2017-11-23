/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import vista.FrmCrearBD;

/**
 *
 * @author Edwin CR
 */
public class pool_bd {
    
    private String Dato;

    public pool_bd(String Dato) {
        this.Dato = Dato;
    }
    
    
    public String getDato() {
        return Dato;
    }

    public void setDato(String Dato) {
        this.Dato = Dato;
    }
    
    public String pool(String dato){
        return dato;
    }
    
   
    
    
    
}
