
package logicaBL;

import javax.swing.JOptionPane;

/**
 *
 * @author MillerJMRO
 */
public class Bebidas_de_consumicionesBL {
    public void Guardar(int idbebiconsumic, String codbebidas, int idconsumisiones ){
        if (idbebiconsumic<=0) {
            JOptionPane.showMessageDialog(null,"Error al Guardar, id bebidas de consumiciones vacia");
        }else if(codbebidas.isEmpty()){
            JOptionPane.showMessageDialog(null,"Error al Guardar, codbebidas vacia ");
        }else if(idconsumisiones<=0){
            JOptionPane.showMessageDialog(null,"Error al Gurardar, id consumiciones vacia");
        }else {
            
        }
    }
    public void Actualizar(int idbebiconsumic, String codbebidas, int idconsumisiones ){
        if (idbebiconsumic<=0) {
            JOptionPane.showMessageDialog(null,"Error al Actuaizar, id bebidas de consumiciones vacia");
        }else if(codbebidas.isEmpty()){
            JOptionPane.showMessageDialog(null,"Error al Actualizar, codbebidas vacia ");
        }else if(idconsumisiones<=0){
            JOptionPane.showMessageDialog(null,"Error al Actualizar, id consumiciones vacia");
        }else {
            
        }
    }
    public void Eliminar(int idbebiconsumic){
        if (idbebiconsumic<=0) {
            JOptionPane.showMessageDialog(null,"Erro al Eliminar,Bebidas_de_consumicionesBL ");
        }
    }
}
