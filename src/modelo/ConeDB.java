package modelo;

import auxiliares.logica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Edwin CR
 */
public class ConeDB {

    protected Connection con;
    protected PreparedStatement ps;
    protected Statement st;
    protected ResultSet rs;
    private logica log;
    protected ResultSet rs2;

    public Connection Conectar() {
        log = new logica();
        try {
            if (log.Recorrer().equals("MYSQL")) {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante10", "root", "12345678");
            } else if (log.Recorrer().equals("POSTGRESQL")) {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/restaurante10", "postgres", "12345678");
            } else if (log.Recorrer().equals("SQL SERVER")) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=restaurante10; user=root;password=12345678");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public Connection ConectarC() {
        log = new logica();
        try {
            if (log.Recorrer().equals("MYSQL")) {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "12345678");
            } else if (log.Recorrer().equals("POSTGRESQL")) {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "12345678");
            } else if (log.Recorrer().equals("SQL SERVER")) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=root;password=12345678");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public Connection ConectarEliminarPost() {
        log = new logica();
        try {

            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/restaurante10", "postgres", "12345678");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public Connection ConectarSqlServer() {
        log = new logica();
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=root;password=12345678");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public boolean ConexinCreacionDB(String ForName, String ruta, String user, String password) {

        try {
            Class.forName(ForName);
            con = DriverManager.getConnection(ruta, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (con != null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean ConexinCreacionDBSql(String ForName, String ruta) {

        try {
            Class.forName(ForName);
            con = DriverManager.getConnection(ruta);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (con != null) {
            return true;
        } else {
            return false;
        }

    }

}
