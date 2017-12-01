package logicaBL;

import entidades.Platos_de_ingrediente;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import modelo.db_Ingredientes;
import modelo.db_Platos_de_ingredientes;

/**
 *
 * @author MillerJMRO
 */
public class Platos_de_ingredienteBL {

    private Platos_de_ingrediente pi;
    private db_Platos_de_ingredientes db;
    private db_Ingredientes ing;
    
    public void Guardar(String codigoPlato, String idIngrediente) {
        if (codigoPlato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el codigo plato esta vacio");
        } else if (idIngrediente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Guardar, el id ingrediente esta vacio");
        } else {
            pi=new Platos_de_ingrediente(codigoPlato, idIngrediente);
            db=new db_Platos_de_ingredientes();
            db.Guardar(pi);
        }
    }

    public void Actualizar(int idPlatodeIngrediente, String codigoPlato, String idIngrediente) {
        if (idPlatodeIngrediente <= 0) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id plato de ingredientes esta vacio");
        } else if (codigoPlato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el codigo plato esta vacio");
        } else if (idIngrediente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar, el id ingrediente esta vacio");
        } else {

        }
    }

    public void Eliminar(int idPlatodeIngrediente) {
        if (idPlatodeIngrediente <= 0) {
            JOptionPane.showMessageDialog(null, "Error al eliminar platos de ingrediente");
        }
    }
    
    public void ListarJtree(JTree tre){
        db=new db_Platos_de_ingredientes();
        db.ListarJree(tre);
    }
    
    
    public void ListarIngredientesPorPlato(JList lista,String dato){
        db=new db_Platos_de_ingredientes();
        db.ListarIngredientesPorPlato(lista, dato);
    }
    
    public void ingredientes(JList lista,String dato){
        db=new db_Platos_de_ingredientes();
        db.Ingredientes(lista, dato);
    }
    
    public String SacarIDPlatos(String dato){
        db=new db_Platos_de_ingredientes();
        return db.SacarIDPlato(dato);
    }
    
    public String SacarIDIngredientes(String dato){
        ing=new db_Ingredientes();
        return ing.SacarIDIngredientes(dato);
    }
}
