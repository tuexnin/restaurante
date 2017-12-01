/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Platos_de_ingrediente;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Edwin CR
 */
public class db_Platos_de_ingredientes extends ConeDB {

    public void Guardar(Platos_de_ingrediente pi) {
        try {
            this.rs = this.Conectar().createStatement().executeQuery("select * from platos_de_ingrediente where codigoPlato='" + pi.getCodigoPlato() + "' and idIngrediente='" + pi.getIdIngrediente() + "'");
            if (this.rs.next()) {
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR EL INGREDIENTE, EL PLATO YA TIENE ESE INGREDIENTE");
            } else {
                this.ps = this.Conectar().prepareStatement("insert into platos_de_ingrediente(codigoPlato,idIngrediente) values(?,?)");
                this.ps.setString(1, pi.getCodigoPlato());
                this.ps.setString(2, pi.getIdIngrediente());
                this.ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.Conectar().close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void ListarJree(JTree tre) {
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Tipos de platos");

        try {
            this.rs = this.Conectar().createStatement().executeQuery("SELECT tipo FROM tipo_plato");
            while (this.rs.next()) {
                DefaultMutableTreeNode tipos = new DefaultMutableTreeNode();
                tipos.setUserObject(rs.getObject(1));
                raiz.add(tipos);
                this.rs2 = this.Conectar().createStatement().executeQuery("select pla.nombre from platos pla\n"
                        + "inner join tipo_plato tp on tp.idtipo=pla.idtipo\n"
                        + "where tipo='" + this.rs.getObject(1) + "'");
                while (this.rs2.next()) {
                    DefaultMutableTreeNode platos = new DefaultMutableTreeNode();
                    platos.setUserObject(this.rs2.getObject(1));
                    tipos.add(platos);
                }
            }
            DefaultTreeModel modelo = new DefaultTreeModel(raiz);
            tre.setModel(modelo);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.Conectar().close();
                this.rs.close();
                this.rs2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void ListarIngredientesPorPlato(JList lista, String dato) {
        DefaultListModel modeloLista = new DefaultListModel();
        try {
            this.rs = this.Conectar().createStatement().executeQuery("select ing.nombre from platos_de_ingrediente  pi\n"
                    + "inner join platos pla on pla.codigoPlato=pi.codigoPlato\n"
                    + "inner join ingrediente ing on ing.idIngrediente=pi.idIngrediente\n"
                    + "where pla.codigoPlato=(select p.codigoPlato from platos p where p.nombre='" + dato + "')");
            while (this.rs.next()) {
                modeloLista.addElement(this.rs.getObject(1));
            }
            lista.setModel(modeloLista);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.Conectar().close();
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void Ingredientes(JList lista, String dato) {
        DefaultListModel modeloLista = new DefaultListModel();
        try {
            this.rs = this.Conectar().createStatement().executeQuery("SELECT nombre FROM ingrediente where idAlmacen='" + dato + "'");
            while (this.rs.next()) {
                modeloLista.addElement(this.rs.getObject(1));
            }
            lista.setModel(modeloLista);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.Conectar().close();
                this.rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String SacarIDPlato(String dato) {
        String valor = "";
        try {
            this.rs = this.Conectar().createStatement().executeQuery("select p.codigoPlato from platos p where p.nombre='" + dato + "'");
            if (this.rs.next()) {
                valor = this.rs.getObject(1).toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.Conectar().close();
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return valor;
    }

}
