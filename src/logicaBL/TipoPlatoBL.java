/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaBL;

import entidades.TipoPlato;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.db_TipoPlato;

/**
 *
 * @author Edwin CR
 */
public class TipoPlatoBL {

    private db_TipoPlato db_tp;
    private TipoPlato tp;

    public void Guardar(String tipo) {
        if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR EL TIPO DE PLATO");
        } else {
            tp = new TipoPlato(tipo);
            db_tp = new db_TipoPlato();
            db_tp.guardarTipoPlato(tp);
            JOptionPane.showMessageDialog(null, "SE GUARDO CORRECTAMENTE");
        }
    }

    public void Actualizar(int id, String tipo) {
        if (id <= 0 || tipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR AL CLIENTE");
        } else {
            tp = new TipoPlato(id, tipo);
            db_tp = new db_TipoPlato();
            db_tp.ActualizarTipoPlato(tp);
            JOptionPane.showMessageDialog(null, "SE ACTUALIZO CORRECTAMENTE");
        }
    }

    public void Eliminar(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR AL CLIENTE");
        } else {
            tp = new TipoPlato(id);
            db_tp = new db_TipoPlato();
            db_tp.EliminarTipoPlato(tp);
            JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
        }
    }
    
    public void Listar(JList lista, String dato){
        db_tp=new db_TipoPlato();
        db_tp.Listar(lista, dato);
    }
    
    
    public String sacarID(String tipo){
        db_tp=new db_TipoPlato();
        return db_tp.sacarID(tipo);
    }
    
    public void LlenarComboTipoPlato(JComboBox combo){
        db_tp=new db_TipoPlato();
        db_tp.llenarComboTipoPlato(combo);
    }

}
