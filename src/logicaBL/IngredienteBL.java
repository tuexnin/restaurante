package logicaBL;

import entidades.Ingrediente;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.db_Ingredientes;

/**
 *
 * @author MillerJMRO
 */
public class IngredienteBL {
    
    private Ingrediente ing;
    private db_Ingredientes db_ing;

    public void Guardar(String idIngrediente, String nombre, double Cantidad, String medida, String idAlmacen) {
        if (idIngrediente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar,el idIngrediente esta vacio");
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el nombre esta vacio");
        } else if (Cantidad<=0) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, la cantidad esta vacia");
        } else if(medida.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error al Guardar, la medida");
        }else if (idAlmacen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el idAlmacen esta vacio");
        } else {
            ing=new Ingrediente(idIngrediente, nombre, Cantidad, medida, idAlmacen);
            db_ing=new db_Ingredientes();
            db_ing.guardar(ing);
        }
    }

    public void Actualizar(String idIngrediente, String nombre, double Cantidad, String medida,String idAlmacen) {
        if (idIngrediente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar,el idIngrediente esta vacio");
        } else if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el nombre esta vacio");
        } else if (Cantidad<=0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la cantidad esta vacia");
        } else if(medida.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error al Actualizar, la medida");
        }else if (idAlmacen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el idAlmacen esta vacio");
        } else {
            ing=new Ingrediente(idIngrediente, nombre, Cantidad, medida, idAlmacen);
            db_ing=new db_Ingredientes();
            db_ing.Actualizar(ing);
        }
    }

    public void Eliminar(String idIngrediente) {
        if (idIngrediente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar, ingrediente");
        }else{
            ing=new Ingrediente(idIngrediente);
            db_ing=new db_Ingredientes();
            db_ing.Eliminar(ing);
        }
    }
    
    public void Listar(JTable tabla,String dato){
        db_ing=new db_Ingredientes();
        db_ing.Listar(tabla, dato);
    }
    
    public String SacarIDTipoAlmacen(String dato){
        db_ing=new db_Ingredientes();
        return db_ing.sacarIdDelTipoAlmacen(dato);
    }
    
    public void LLenarComboTipoAlmacen(JComboBox combo){
        db_ing=new db_Ingredientes();
        db_ing.LLenarComboTipoALmacen(combo);
    }
}
