/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import javax.swing.JButton;

/**
 *
 * @author Edwin CR
 */
public class TransparenciaButtons {
    
    
    public static void PonerBottonTransparente(JButton boton){
        boton.setOpaque(false);
        //boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
    }
    
}
