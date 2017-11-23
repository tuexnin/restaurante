/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Almacen;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin CR
 */
public class db_Almacen extends ConeDB {

    public void Guardar(Almacen almacen) {
        try {
            this.rs = this.Conectar().createStatement().executeQuery("select * from almacen where encargado ='" + almacen.getEncargado() + "' or idtipo='" + almacen.getIdtipo() + "'");
            if (this.rs.next()) {
                if (this.rs.getObject(2).toString().equals(almacen.getEncargado())) {
                    JOptionPane.showMessageDialog(null, "El encargado ya se encuenta a cargo de otra area");
                } else {
                    JOptionPane.showMessageDialog(null, "El area asignado ya se encuentra con encargado");
                }
            } else {
                this.ps = this.Conectar().prepareStatement("insert into almacen values(?,?,?)");
                this.ps.setString(1, almacen.getIdAlmacen());
                this.ps.setString(2, almacen.getEncargado());
                this.ps.setInt(3, almacen.getIdtipo());
                int val = this.ps.executeUpdate();
                if (val == 1) {
                    JOptionPane.showMessageDialog(null, "SE GUARDO CORRECTAMENTE");
                } else {
                    JOptionPane.showMessageDialog(null, "no se pudo GUARDar");
                }
            }

        } catch (SQLException e) {
            
                JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
            
            e.printStackTrace();
        } finally {
            try {
                this.Conectar().close();
                if (this.ps != null) {
                    this.ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void Actualizar(Almacen almacen) {
        try {

            this.ps = this.Conectar().prepareStatement("update almacen set encargado=?, idtipo=? where idAlmacen=?");
            this.ps.setString(1, almacen.getEncargado());
            this.ps.setInt(2, almacen.getIdtipo());
            this.ps.setString(3, almacen.getIdAlmacen());
            int val = this.ps.executeUpdate();
            if (val == 1) {
                JOptionPane.showMessageDialog(null, "SE ACTUALIZO CORRECTAMENTE");
            } else {
                JOptionPane.showMessageDialog(null, "no se pudo ACTUALIZAR");
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

    public void Eliminar(Almacen almacen) {
        try {
            this.ps = this.Conectar().prepareStatement("delete from almacen where idAlmacen=?");
            this.ps.setString(1, almacen.getIdAlmacen());
            int val=this.ps.executeUpdate();
            if(val==1){
                    JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
                }else{
                    JOptionPane.showMessageDialog(null, "no se pudo ELIMINAR");
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

    public void Listar(JTable tabla, String dato) {
        String[] titulo = {"CODIGO", "ENCARGADO", "TIPO ALMACEN"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null, titulo);
        Object[] aux = new Object[3];
        try {
            this.rs = this.Conectar().createStatement().executeQuery("select almacen.idAlmacen, almacen.encargado, tipo_almacen.tipo from almacen \n" +
                                                                     "inner join tipo_almacen on tipo_almacen.idtipo_almacen = almacen.idtipo\n" +
                                                                     "where almacen.encargado like '%"+dato+"%'");
            while (this.rs.next()) {
                for (int i = 0; i < 3; i++) {
                    aux[i] = this.rs.getObject(i + 1);
                }
                modeloTabla.addRow(aux);
            }
            tabla.setModel(modeloTabla);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
