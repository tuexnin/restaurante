/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaBL;

import javax.swing.JOptionPane;
import modelo.ConeDB;
import modelo.db_inicial;

/**
 *
 * @author Edwin CR
 */
public class ConexionesBL {

    private ConeDB con;
    private String ruta;
    private String user;
    private String pss;
    private String fn;
    private db_inicial ini;

    public boolean Conectar(String bd) {
        boolean dato = false;
        if (bd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO A SELECCIONADO UNA BASE DE DATOS");
        } else {
            con = new ConeDB();
            if (bd.equals("MYSQL")) {
                fn = "com.mysql.jdbc.Driver";
                ruta = "jdbc:mysql://localhost:3306/";
                user = "root";
                pss = "12345678";
                boolean res = con.ConexinCreacionDB(fn, ruta, user, pss);
                if (res) {
                    JOptionPane.showMessageDialog(null, "CONEXION EXITOSA");
                    dato = true;
                } else {
                    JOptionPane.showMessageDialog(null, "CONEXION FALLIDA");
                }
            } else if (bd.equals("POSTGRESQL")) {
                fn = "org.postgresql.Driver";
                ruta = "jdbc:postgresql://localhost:5432/";
                user = "postgres";
                pss = "12345678";
                boolean res = con.ConexinCreacionDB(fn, ruta, user, pss);
                if (res) {
                    JOptionPane.showMessageDialog(null, "CONEXION EXITOSA");
                    dato = true;
                } else {
                    JOptionPane.showMessageDialog(null, "CONEXION FALLIDA");
                }
                
            } else if (bd.equals("SQL SERVER")) {
                fn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                ruta = "jdbc:sqlserver://localhost:1433;user=root;password=12345678";
                boolean res = con.ConexinCreacionDBSql(fn, ruta);
                if (res) {
                    JOptionPane.showMessageDialog(null, "CONEXION EXITOSA");
                    dato = true;
                } else {
                    JOptionPane.showMessageDialog(null, "CONEXION FALLIDA");
                }
            }
        }
        return dato;
    }

    
    
    public void CrearBD(String bd) {
        ini = new db_inicial();
        int dato = ini.createBD();
        if (dato == 1) {
            JOptionPane.showMessageDialog(null, "SE CREO LA BASE DE DATOS CORRECTAMENTE");
        } else if(dato==0 && bd.equals("POSTGRESQL")){
            JOptionPane.showMessageDialog(null, "SE CREO LA BASE DE DATOS CORRECTAMENTE");
            
        }else if(dato==0 && bd.equals("SQL SERVER")){
            JOptionPane.showMessageDialog(null, "SE CREO LA BASE DE DATOS CORRECTAMENTE");
        }else{
            JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR LA BASE DE DATOS");
        }
    }

    public void useBD() {
        ini = new db_inicial();
        int dato = ini.UseBD();
        if (dato == 1) {
            JOptionPane.showMessageDialog(null, "Se Conecto a la Base de Datos restaurante10 ");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo Conectar a la Base de Datos restaurante10");
        }
    }

    public void CrearTablas(String bd) {
        ini = new db_inicial();
        if (bd.equals("MYSQL")) {
          ini.UseBD();
          ini.createTableMYSQL();
          ini.closeConnection();
          JOptionPane.showMessageDialog(null, "SE CREO LA TABLAS CORRECTAMENTE");
        } else if (bd.equals("POSTGRESQL")) {
            con=new ConeDB();
            con.Conectar();
            ini.createTablePostGreSql();
            JOptionPane.showMessageDialog(null, "SE CREO LA TABLAS CORRECTAMENTE");
        } else if (bd.equals("SQL SERVER")) {
           ini.UseBD();
           ini.createTableSqlServer();
           ini.closeConnection();
           JOptionPane.showMessageDialog(null, "SE CREO LA TABLAS CORRECTAMENTE");
        }else{
            JOptionPane.showMessageDialog(null, "NO SELECCIONO UNA BASE DE DATOS");
        }
    }
    
    public void EliminarBD(String bd){
        ini=new db_inicial();
        int dato;
        if(bd.equals("POSTGRESQL")){
            dato=ini.eliminarBDPostgres();
        }else if(bd.equals("SQL SERVER")){
            dato=ini.eliminarBDSqlServer();
        }else{
            dato=ini.eliminarBD();
        }
        
        if(dato!=0){
            JOptionPane.showMessageDialog(null, "SE ELIMINO LA BASE DE DATOS");
        }else{
            JOptionPane.showMessageDialog(null, "NO SE ELIMINO LA BASE DE DATOS");
        }
    }
}
